package lqb_beikao;

// 三队选手参加乒乓球男女混合双打，3位男运动员是abc 3位女运动员是xyz
// a说他和x配对 	x说她搭档是c	c说他和z搭档		这三句话都是假的  请编程找出谁和谁搭档
// 也就是说a不和x配对 c不和x配对 c不和z配对
public class t12 {
	static class Solution{
		public static void f(String prefix, int n){
			switch (n){
				case 1:
					System.out.println(prefix + "x");
					break;
				case 2:
					System.out.println(prefix + "y");
					break;
				case 3: 
					System.out.println(prefix + "z");
					break;
			}
		}
	}
	
	public static void main(String[] args) {
		int i, j, k;				// i j k 分别代表a b c的配对对象     1 2 3分别代表x y z
		for(i=1; i<=3; i++){
			for(j=1; j<=3; j++){
				for(k=1; k<=3; k++){
					if(i!=1&&k!=1&&k!=3&&i!=j&&i!=k&&j!=k){
						// System.out.println(i + " " + j + " " + k);
						Solution.f("a配对对象: ", i);
						Solution.f("b配对对象: ", j);
						Solution.f("c配对对象: ", k);
					}
				}
			}
		}
	}
}
