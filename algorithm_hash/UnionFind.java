package algorithm_hash;

import java.util.List;
import java.util.HashMap;

// 并查集实现
public class UnionFind {

	public static class Node<T> {
		// T is whatever you like eg: String, Int, Char, Double 、、、
		public T value;

		public Node(T v) {
			this.value = v;
		}
	}

	public static class UnionFindSet {
		// fatherMap: key is child, value is father
		// sizeMap: the size of the node in set
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet(List<Node> nodes) {
			// init the map
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			for (Node node : nodes) {
				// one Node become one set
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		private Node findHead(Node node) {
			// find the head of a set
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father); // 将链变扁平
			return father;
		}
		
		// ================================
		// extrenal useable method
		public boolean isSameSet(Node a, Node b) {
			// to judge a two node in a same set
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			// to union two set by two node
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				int size = aSetSize + bSetSize;		// the size of after union
				if (aSetSize <= bSetSize) {
					// union a to b
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, size);
				} else {
					// union b to a 
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, size);
				}
			}
		}

	}

}
