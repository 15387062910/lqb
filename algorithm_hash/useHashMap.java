package algorithm_hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

// 使用Java内置哈希表
public class useHashMap {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("wyb", "21");
		System.out.println(map.containsKey("wyb"));
		System.out.println(map.containsKey("wyb666"));
		System.out.println("=========================");

		System.out.println(map.get("wyb"));
		System.out.println(map.get("wyb666"));
		System.out.println("=========================");

		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("=========================");

		System.out.println(map.remove("wyb"));
		System.out.println(map.containsKey("wyb"));
		System.out.println(map.get("wyb"));
		System.out.println(map.isEmpty());
		System.out.println(map.size());
		System.out.println("=========================");

		map.put("wyb", "21");
		System.out.println(map.get("wyb"));
		map.put("wyb", "22");
		System.out.println(map.get("wyb"));
		System.out.println("=========================");

		map.put("wyb", "21");
		map.put("xxx", "22");
		map.put("abc", "23");
		// 遍历哈希表的key
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		// 遍历哈希表的value
		for (String values : map.values()) {
			System.out.println(values);
		}
		System.out.println("=========================");

		map.clear();		// 清空哈希表
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		map.put("D", "1");
		map.put("E", "2");
		map.put("F", "3");
		map.put("G", "1");
		map.put("H", "2");
		map.put("I", "3");
		// 遍历哈希表的key和value
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("=========================");

		// you can not remove item in map when you use the iterator of map
//		 for(Entry<String,String> entry : map.entrySet()){
//			 if(!entry.getValue().equals("1")){
//				 map.remove(entry.getKey());
//			 }
//		 }

		// if you want to remove items, collect them first, then remove them by
		// this way.
		List<String> removeKeys = new ArrayList<String>();
		for (Entry<String, String> entry : map.entrySet()) {
			if (!entry.getValue().equals("1")) {
				removeKeys.add(entry.getKey());
			}
		}
		for (String removeKey : removeKeys) {
			map.remove(removeKey);
		}
		for (Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "," + value);
		}
		System.out.println("=========================");

	}

}

