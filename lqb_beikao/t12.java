package lqb_beikao;

// ����ѡ�ֲμ�ƹ������Ů���˫��3λ���˶�Ա��abc 3λŮ�˶�Ա��xyz
// a˵����x��� 	x˵�����c	c˵����z�		�����仰���Ǽٵ�  �����ҳ�˭��˭�
// Ҳ����˵a����x��� c����x��� c����z���
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
		int i, j, k;				// i j k �ֱ����a b c����Զ���     1 2 3�ֱ����x y z
		for(i=1; i<=3; i++){
			for(j=1; j<=3; j++){
				for(k=1; k<=3; k++){
					if(i!=1&&k!=1&&k!=3&&i!=j&&i!=k&&j!=k){
						// System.out.println(i + " " + j + " " + k);
						Solution.f("a��Զ���: ", i);
						Solution.f("b��Զ���: ", j);
						Solution.f("c��Զ���: ", k);
					}
				}
			}
		}
	}
}
