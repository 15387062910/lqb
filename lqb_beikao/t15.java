package lqb_beikao;

// 未名湖边的烦恼
// 每年冬天，北大未名湖上都是滑冰的好地方。北大体育组准备了许多冰鞋，可是人太多了，每天下午收工后，常常一双冰鞋都不剩。
// 每天早上，租鞋窗口都会排起长龙，假设有还鞋的m个，有需要租鞋的n个。现在的问题是，这些人有多少种排法，可以避免出现
// 体育组没有冰鞋可租的尴尬场面。（两个同样需求的人（比如都是租鞋或都是还鞋）交换位置是同一种排法）

// 输入格式:  两个整数，表示m和n
// 输出格式:  一个整数，表示队伍的排法的方案数。

public class t15 {
	private static int f(int m, int n){
		if(m<n){
			return 0;
		}
		else if(n==0){
			return 1;
		}
		else{
			return f(m-1, n) + f(m, n-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(f(3, 1));
		System.out.println(f(3, 5));
		System.out.println(f(5, 3));
	}
}
