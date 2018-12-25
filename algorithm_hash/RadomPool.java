package algorithm_hash;

import java.util.HashMap;

// 设计RandomPool结构 :
// 设计一种结构，在该结构中有如下三个功能：
// 		insert(key)：将某个key加入到该结构，做到不重复加入。 
//		delete(key)：将原本在结构中的某个key移除。
//		getRandom()： 等概率随机返回结构中的任何一个key。 
// 要求: 
//		insert、delete和getRandom方法的时间复杂度都是 O(1)

public class RadomPool {

	public HashMap<String, Integer> keyIndexMap;
	public HashMap<Integer, String> indexKeyMap;
	public int size;

	public RadomPool() {
		keyIndexMap = new HashMap<String, Integer>();
		indexKeyMap = new HashMap<Integer, String>();
		size = 0;
	}

	public void insert(String key) {
		if(!this.keyIndexMap.containsKey(key)){
			keyIndexMap.put(key, size);
			indexKeyMap.put(size, key);
			size++;
		}
	}
	
	public void delete(String key){
		if(this.keyIndexMap.containsKey(key)){
			int deleteIndex = this.keyIndexMap.get(key);
			int lastIndex = --this.size;
			String lastKey = this.indexKeyMap.get(lastIndex);
			// update keyIndexMap
			this.keyIndexMap.put(lastKey, deleteIndex);
			this.keyIndexMap.remove(key);
			// update indexKeyMap
			this.indexKeyMap.put(deleteIndex, lastKey);
			this.indexKeyMap.remove(lastIndex);
		}
	}

	public String getRandom() {
		if (size == 0) {
			return null;
		}
		int randomIndex = (int) (Math.random() * this.size);	// 0 ~ size-1
		return indexKeyMap.get(randomIndex);
	}

	public static void main(String[] args) {
		RadomPool test = new RadomPool();
		test.insert("wyb");
		test.insert("xxx");
		test.insert("abc");
		System.out.println(test.getRandom());
		System.out.println(test.getRandom());
		System.out.println(test.getRandom());
		test.delete("xxx");
		System.out.println(test.getRandom());
		System.out.println(test.getRandom());
		System.out.println(test.getRandom());
	}

}
