package lqb_beikao;

// 15���� 5���̵� 3�ŻƵ� 7�����ģ� ����ץ��10���ǣ���������������������ͳ���ܹ��ж������
public class t11_ft {
	static class Solution{
		public static void ft(){
			int count = 0;
			for(int i=0; i<=5; i++){
				for(int j=0; j<=3; j++){
					for(int k=0; k<=7; k++){
						if(i+j+k==10){
							System.out.println(i + " " + j + " " + k);
							count += 1;
						}
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) {
		Solution.ft();
	}
}
