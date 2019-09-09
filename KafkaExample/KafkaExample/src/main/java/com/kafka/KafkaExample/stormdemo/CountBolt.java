package com.kafka.KafkaExample.stormdemo;

import java.util.HashMap;
import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;

public class CountBolt implements IRichBolt {
	private Map<String, Integer> counters;
	private OutputCollector collector;
	
	@Override
	public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {
		this.collector = collector;
		counters = new HashMap<>();
	}

	@Override
	public void execute(Tuple input) {
		String word = input.getString(0);
		
		if(!counters.containsKey(word)) counters.put(word, 1); 
		else counters.put(word, counters.get(word) + 1);
		
		collector.ack(input);
	}

	@Override
	public void cleanup() {
		counters.entrySet().stream().forEach((e -> {System.out.println(e.getValue());}));
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
