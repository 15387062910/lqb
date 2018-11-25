package lqb_beikao;

// 旋转字符串
// 给定两个字符串, A 和 B。
// A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。
// 如果在若干次旋转操作之后，A 能变成B，那么返回True。

/*
示例 1:
输入: A = 'abcde', B = 'cdeab'
输出: true

示例 2:
输入: A = 'abcde', B = 'abced'
输出: false
 */

public class t20 {
	private static boolean rotateString(String A, String B) {
		// 代码提交地址: https://leetcode-cn.com/problems/rotate-string/description/
		if(A==null||B==null){
			return false;
		} else if(A.length()!=B.length()){
			return false;
		} else{
			String c = A + A;
			if(c.contains(B)){
				return true;
			} else{
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(rotateString("", ""));
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("abcde", "abced"));
	}
}
