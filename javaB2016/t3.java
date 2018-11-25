package javaB2016;

/* 
	    B          DEF
A +    ---    +  -------  = 10
        C          GHI
 
这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
比如：
	6+8/3+952/714 就是一种解法，
	5+3/1+972/486 是另一种解法。
	这个算式一共有多少种解法？
	注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
*/
// 思路: 九层循环 暴力破解 真的很暴力很无脑 不过没关系 反正搞出来就行 填答案的题不在乎暴力不暴力
// 第一次完整算出来 38706673 感觉不对把 怎么可能这么大  一看答案是29 果然不对 
// 最后还是没有找出来问题在哪、、、
// 原来是漏了一个条件: A~I代表1~9的数字，不同的字母代表不同的数字 、、、、
// 加了这个条件之后算出来是35721  还是不对 、、、

public class t3 {
	private static boolean check(int i, int j, int k, int l, int a, int b, int c, int d, int e){
		// 抽屉原理
		int[] array = new int[10];
		array[i] += 1; array[j] += 1; array[k] += 1; array[l] += 1;
		array[a] += 1; array[b] += 1; array[c] += 1; array[d] += 1; array[e] += 1;
		for(int t=1; t<=9; t++){
			if(array[t]!=1){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int res = 0;	// 记录结果数
		for(int i=1; i<=9; i++)
		for(int j=1; j<=9; j++)
		for(int k=1; k<=9; k++)
		for(int l=1; l<=9; l++)
		for(int a=1; a<=9; a++)
		for(int b=1; b<=9; b++)
		for(int c=1; c<=9; c++)
		for(int d=1; d<=9; d++)
		for(int e=1; e<=9; e++){
			int A = j;
			int B = k;
			int C = l*100 + a*10 + b;
			int D = c*100 + d*10 + e;
			// System.out.println(s);
			if(check(i, j, k, l, a, b, c, d, e)){
				int s = i+A/B+C/D;
				if(s==10){
					res += 1;
				}
			}
		}
		System.out.println(res);
	}
}
