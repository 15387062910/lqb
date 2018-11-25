package lqb_beikao;

// 字符串全排列
/*
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
	输入: S = "a1b2"
	输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
	
	输入: S = "3z4"
	输出: ["3z4", "3Z4"]
	
	输入: S = "12345"
	输出: ["12345"]

注意：
	S 的长度不超过12。
	S 仅由数字和字母组成。
*/

import java.util.ArrayList;
import java.util.List;

public class t21 {
	private static void dfs(String pre, String S, List<String> res, int index) {
	    /*
	     * pre:  累计叠加的字符串
	     * S: 	  原始字符串
	     * res:  结果列表
	     * index: 当前索引
	     */
	    if (index == S.length()){
	    	// 进行到最后 将pre添加到结果列表中
	    	res.add(pre);
	    }
	    else {
	        char ch = S.charAt(index);
	        if (!Character.isLetter(ch)){
	        	// 如果不是字母
	        	dfs(pre + ch, S, res, index + 1);
	        }
	            
	        else {
	            // 将字符参数转化为小写的
	            ch = Character.toLowerCase(ch);
	            dfs(pre + ch, S, res, index + 1);
	            // 将字符参数转化为大写的
	            ch = Character.toUpperCase(ch);
	            dfs(pre + ch, S, res, index + 1);
	        }
	    }
	}
	    
    private static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList();
        dfs("", S, res, 0);
        return res;
    }
	    
	public static void main(String[] args) {
		List<String> res = new ArrayList();
		res = letterCasePermutation("a1b2");
		System.out.println(res);
	}
}
