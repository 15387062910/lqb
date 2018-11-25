package lqb_beikao;

/* 两句话中的不常见句子
给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
返回所有不常用单词的列表。可以按任何顺序返回列表。

示例 1：
	输入：A = "this apple is sweet", B = "this apple is sour"
	输出：["sweet","sour"]
示例 2：
	输入：A = "apple apple", B = "banana"
	输出：["apple","banana"]
 
提示：
	0 <= A.length <= 200
	0 <= B.length <= 200
	A 和 B 都只包含空格和小写字母。 
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class t22 {
	// 字符串数组去重
	private static String[] lt(String[] arrStr){
		Map<String, Object> map = new HashMap<String, Object>();
		for(String str:arrStr){
			map.put(str, str);
		}
		String[] newArrStr = map.keySet().toArray(new String[1]);
		
		return newArrStr;
	}
	
	private static String[] split(String str){
		String[] res = str.split(" ");
		
		return lt(res);
	}
	
	private static List<String> f(String[] s1, String[] s2){
		List<String> res = new ArrayList();
		// 找出s1中存在但不在s2中的单词
		for(int i=0; i<s1.length; i++){
			String a = s1[i];
			// System.out.println("a: " + a);
			boolean find = false;
			for(int j=0; j<s2.length; j++){
				String b = s2[j];
				// System.out.println("b: " + b);
				if(a.equals(b)){
					find = true;
					break;
				}
			}
			if(!find){
				res.add(a);
			}
		}
		
		// 找出s2中存在但不在s1中的单词
		for(int i=0; i<s2.length; i++){
			String a = s2[i];
			// System.out.println("a: " + a);
			boolean find = false;
			for(int j=0; j<s1.length; j++){
				String b = s1[j];
				// System.out.println("b: " + b);
				if(a.equals(b)){
					find = true;
					break;
				}
			}
			if(!find){
				res.add(a);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		List<String> res = f(split("this apple is sweet"), split("this apple is sour"));
		System.out.println(res);
		List<String> res2 = f(split("apple apple"), split("banana"));
		System.out.println(res2);
	}
}
