package algorithm_hash;

import java.util.HashSet;
import java.util.Iterator;

// 使用Java内置集合
public class useHashSet {
	public static class News{
		private int id;
		private String s1;
		private String s2;
		
		public News(int num, String str1, String str2){
			this.setId(num);
			this.setS1(str1);
			this.setS2(str2);
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setS1(String s1) {
			this.s1 = s1;
		}

		public String getS1() {
			return s1;
		}

		public void setS2(String s2) {
			this.s2 = s2;
		}

		public String getS2() {
			return s2;
		}
		
		
	}
	
	public static void main(String[] args) {
		News news = new News(1, "test", "test HashSet");
		News news2 = new News(2, "wyb", "哈哈哈");
		News news3 = new News(3, "1213", "666");
		
		// 创建HashSet集合，储存无序，唯一的数据
		// HashSet是是使用equals来进行对象对比，确定数据是唯一的
		// 如果两个数据的对象是一致的，那么HashSet将会把这两个合并，只储存一个空间
		HashSet<News> set = new HashSet<News>();
		set.add(news);
		set.add(news2);
		set.add(news3);
		
		// 遍历HashSet:
		// 由于HashSet储存数据都是无序的，所以不能用get(i);来获取具体对象
		// 所以我们必须通过遍历来得到HashSet的各个数据，由于是没有索引的
		// 所以不能使用普通类型的for来遍历它
		// HashSet只能通过增强型for和迭代器来遍历它
		// 1、增强型for
		for(News n : set){
			System.out.println(n.getId()+"\t"+n.getS1()+"\t"+n.getS2());
		}
		System.out.println("*****************************************");
		// 2、迭代器
		Iterator<News> it = set.iterator();
		while (it.hasNext()) {
			News n = it.next();
			System.out.println(n.getId()+"\t"+n.getS1()+"\t"+n.getS2());
		}
		System.out.println("*****************************************");
		
		// set的各种方法:
		// set增加
		set.add(null);
		
		// 删除
		set.remove(news);
		
		// 对比查找
		set.contains(news);
		
		// 清空集合
		set.clear();
		
		// 获取长度
		System.out.println(set.size());
		
	}
}
