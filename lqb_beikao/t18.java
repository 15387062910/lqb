package lqb_beikao;

// (1)翻转句子中单词的顺序
// 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。句子中单词以空格符隔开。
// 为简单起见，标点符号和普通字母一样处理。（注意处理在输入字符串时的回车字符）
// 输入：需反转的字符串  输出：按照要求反转后的字符串
// 示例：例如输入“I am a student.”，则输出“student. a am I”

// (2)反转字符串
// 编写一个函数，其作用是将输入的字符串反转过来。
// 输入: "hello" 输出: "olleh"
// 输入: "A man, a plan, a canal: Panama"  输出: "amanaP :lanac a ,nalp a ,nam A"
public class t18 {
	private static String reverseWord(String str){
		String[] split = str.split(" "); 	// 对输入的字符串进行分割 返回一个数组
		StringBuilder res = new StringBuilder();
		for(int i=split.length-1; i>=0; i--){
			if(i==0){
				res.append(split[i]);
			} else{
				res.append(split[i] + " ");
			}
		}
		return res.toString();
	}
	
	private static String reverseString(String s) {
		// 代码提交地址: https://leetcode-cn.com/problems/reverse-string/description/
		// 传统直接reverse的方法在数据过大时时间不够 超时了  
		int length = s.length();
        char[] str = s.toCharArray();
        for(int i = 0;i < length / 2;i++){
            char temp = str[i];
            str[i] = str[length - 1 - i];
            str[length - 1 - i] = temp;
        }
        return new String(str);
    }
	
	public static void main(String[] args) {
		String r = reverseWord("I am a student.");
		System.out.println(r);
		System.out.println(reverseString("hello"));
		System.out.println(reverseString("A man, a plan, a canal: Panama"));
	}
}
