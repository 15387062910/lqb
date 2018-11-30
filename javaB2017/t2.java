package javaB2017;

/*
 * 	纸牌三角形
        A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
        下图就是一种排法（如有对齐问题，参看p1.png）。

              A
             9 6
            4   8
           3 7 5 2

        这样的排法可能会有很多。如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？
        请你计算并提交该数字。 注意：需要提交的是一个整数，不要提交任何多余内容
 	
*/
public class t2 {
	public static void main(String[] args) {
		int res = 0;
		for(int i=1; i<=9; i++)
		for(int j=1; j<=9; j++)
		for(int k=1; k<=9; k++)
		for(int a=1; a<=9; a++)
		for(int b=1; b<=9; b++)
		for(int c=1; c<=9; c++)
		for(int d=1; d<=9; d++)
		for(int e=1; e<=9; e++)
		for(int f=1; f<=9; f++){
			if(i!=j && i!=k&&j!=k && i!=a&&j!=a&&k!=a && i!=b&&j!=b&&k!=b&&a!=b){
				if(i!=c&&j!=c&&k!=c&&a!=c&&b!=c && i!=d&&j!=d&&k!=d&&a!=d&&b!=d&&c!=d ){
					if(i!=e&&j!=e&&k!=e&&a!=e&&b!=e&&c!=e&&d!=e && i!=f&&j!=f&&k!=f&&a!=f&&b!=f&&c!=f&&d!=f&&e!=f ){
						res += 1;
					}
				}
			}
		}
		
		System.out.println(res);
		res = res/6;
		System.out.println(res);
		// 362880
		// 60480
	}
}
