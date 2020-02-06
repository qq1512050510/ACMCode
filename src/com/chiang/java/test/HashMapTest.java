package com.chiang.java.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("name1", "josan1");
		hashMap.put("name2", "josan2");
		hashMap.put("name3", "josan3");
		Iterator stringIter = hashMap.keySet().iterator();
		while (stringIter.hasNext()) {
			String whileString = (String) stringIter.next();
			System.out.println(whileString);
		}
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("name1", "josan1");
		linkedHashMap.put("name2", "josan2");
		linkedHashMap.put("name3", "josan3");

		Iterator linkedMapIter = linkedHashMap.entrySet().iterator();
		while (linkedMapIter.hasNext()) {
			Entry whileMap = (Entry) linkedMapIter.next();
			System.out.println(String.format("%s-%s", whileMap.getKey(), whileMap.getValue()));
		}
	}
}
