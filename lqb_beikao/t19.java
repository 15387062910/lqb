package lqb_beikao;

// 统计单词
// 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。  注意，你可以假定字符串里不包括任何不可打印的字符。
// 输入: "Hello, my name is John"  输出: 5

public class t19 {
	private static int countSegments(String s) {
		// 代码提交地址: https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
		int res;
		if(s.length()==0||s==null){
			res = 0;
		}
		else{
			// 默认一开始就有一个单词
			res = 1;
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i)==' '){
					if(i<s.length()-1){
						if(s.charAt(i+1)!=' '){
							res += 1;
						}
					}
				}
			}
			if(s.charAt(0)==' '){
				// 一开始没有单词
				res -= 1;
			}
			
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(countSegments(""));
		System.out.println(countSegments("Hello, my name is John"));
		System.out.println(countSegments(", , , ,        a, eaefa"));
	}
}
