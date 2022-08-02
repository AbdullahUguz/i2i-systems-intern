package com.i2i.intern.hazelcast;

import java.util.Map.Entry;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastTimePerformans {

	private long putDataTime(IMap<String, String> map) {

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 20000; i++) {
			map.put(i + "ali", "velii");
		}
		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		return totalTime;
	}

	private long getDataTime(IMap<String, String> map) {
		long startTime = System.currentTimeMillis();

		for (Entry<String, String> entry : map.entrySet()) {
			entry.getKey();
		//	entry.getValue();
		}

		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		return totalTime;
	}

	public void hazelcastOperation() {
		HazelcastInstance hz = HazelcastClient.newHazelcastClient();
		IMap<String, String> map = hz.getMap("my-hazelcast-11");

		System.out.println("Put 20000 Data  Time : " + putDataTime(map) + " ms");
		System.out.println("Get 20000 Data  Time : " + getDataTime(map) + " ms");

		hz.shutdown();
	}
}
