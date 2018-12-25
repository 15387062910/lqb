package algorithm_Tree;

// 前缀树
public class TrieTree {
	
	public static class TrieNode {
		// path: string arrive the node
		// end: string end in the node
		// nexts: next nodes
		public int path;
		public int end;
		public TrieNode[] nexts; // also can be hashMap(Char-TrieNode)

		public TrieNode() {
			path = 0;
			end = 0;
			nexts = new TrieNode[26];
		}

	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			// insert a word to a trie
			if (word == null) {
				return;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.path++;
			}
			node.end++;
		}
		
		public int search(String word) {
			// search a word in a trie(similar to insert)
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}

		public void delete(String word) {
			// delete a word to a trie(similar to insert)
			if(search(word) != 0){
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}
		
		public int prefixNumber(String pre){
			// get the pre in trie's fixNumber(similar to search)
			if(pre==null){
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}	
	}
	
	public static void test(String[] arr1, String[] arr2){
		Trie trie = new Trie();
		for(int i=0; i<arr1.length; i++){
			trie.insert(arr1[i]);
		}
		
		// 打印arr2中出现在arr1中的字符串
		for(int i=0; i<arr2.length; i++){
			if(trie.search(arr2[i]) != 0){
				System.out.print(arr2[i] + " ");
			}
		}
		System.out.println();
		
		// 打印arr2中作为arr1中某个字符串前缀出现的字符串
		for(int i=0; i<arr2.length; i++){
			if(trie.prefixNumber(arr2[i]) != 0){
				System.out.print(arr2[i] + " ");
			}
		}
		System.out.println();
		
		// 打印arr2中作为arr1中某个字符串前缀出现次数最大的字符串
		int index = -1, max = 0;
		for(int i=0; i<arr2.length; i++){
			int times = trie.prefixNumber(arr2[i]);
			if(times > max){
				max = times;
				index = i;
			}
		}
		System.out.println(arr2[index]);
		System.out.println();
	}
	
	// for test
	public static void main(String[] args) {
		String[] arr1 = {"a", "b", "ab", "abc", "bad"};
		String[] arr2 = {"a", "b", "c", "ab", "ba"};
		test(arr1, arr2);
	}

}
