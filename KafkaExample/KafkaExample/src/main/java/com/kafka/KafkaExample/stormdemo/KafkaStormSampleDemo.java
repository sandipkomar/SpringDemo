package com.kafka.KafkaExample.stormdemo;

import java.util.UUID;

import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.kafka.BrokerHosts;
import org.apache.storm.kafka.KafkaSpout;
import org.apache.storm.kafka.SpoutConfig;
import org.apache.storm.kafka.StringScheme;
import org.apache.storm.kafka.ZkHosts;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;

public class KafkaStormSampleDemo {

	public static void main(String[] args) {
		Config config = new Config();
		config.setDebug(true);
		config.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);
		String zkConnectionString = "localhost:2181";
		
		String topic = "streams-plaintext-input";		
		BrokerHosts hosts = new ZkHosts(zkConnectionString);
		
		SpoutConfig kafkaSpoutConfig = new SpoutConfig(hosts, topic, "/" + topic, UUID.randomUUID().toString());
		kafkaSpoutConfig.bufferSizeBytes = 1024 * 1024 * 4;
		kafkaSpoutConfig.fetchSizeBytes = 1024 *1024 * 4;
		kafkaSpoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("kafka-spout", new KafkaSpout(kafkaSpoutConfig));
		builder.setBolt("word-spitter", new SplitBolt()).shuffleGrouping("kafka-spout");
		builder.setBolt("word-counter", new CountBolt()).shuffleGrouping("word-spitter");
		
		try {
			StormSubmitter.submitTopology("KafkaStormSampleDemo", config, builder.createTopology());
			Thread.sleep(10000);
		} catch (AlreadyAliveException | InvalidTopologyException | AuthorizationException  |InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
