package javaB2016;

/* 
 B          DEF
 A  +  ----  +  --------  = 10
 C          GHI

 这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
 比如：
 6+8/3+952/714 就是一种解法，
 5+3/1+972/486 是另一种解法。
 这个算式一共有多少种解法？
 注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
 */
// 答案: 29
// 请注意为了避免操蛋的小数问题 请化简等式将等式中的除法转换成乘法!!!

public class t3 {
	private static boolean check(int i, int j, int k, int l, int a, int b,
			int c, int d, int e) {
		// 抽屉原理
		int[] array = new int[10];
		array[i] += 1;
		array[j] += 1;
		array[k] += 1;
		array[l] += 1;
		array[a] += 1;
		array[b] += 1;
		array[c] += 1;
		array[d] += 1;
		array[e] += 1;
		for (int t = 1; t <= 9; t++) {
			if (array[t] != 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int res = 0;
		for (int i = 1; i <= 9; i++)
			for (int j = 1; j <= 9; j++)
				for (int k = 1; k <= 9; k++)
					for (int l = 1; l <= 9; l++)
						for (int a = 1; a <= 9; a++)
							for (int b = 1; b <= 9; b++)
								for (int c = 1; c <= 9; c++)
									for (int d = 1; d <= 9; d++)
										for (int e = 1; e <= 9; e++) {
											int A = j;
											int B = k;
											int C = l * 100 + a * 10 + b;
											int D = c * 100 + d * 10 + e;
											// System.out.println(s);
											if (check(i, j, k, l, a, b, c, d, e)) {
												if (i * B * D + A * D + B * C == 10
														* B * D) {
													res += 1;
												}
											}
										}
		System.out.println(res);
	}
}
