package lqb_beikao;

// С���ոտ����Ӱ����39��̨�ס����뿪��ӰԺ��ʱ��������������ǰ��̨������ǡ����39��!
// վ��̨��ǰ����ͻȻ������һ�����⣺
// �����ÿһ��ֻ������1����2��̨�ס�������ţ�Ȼ�����ҽ��棬���һ�������ҽţ�Ҳ����˵һ��Ҫ��ż��������ô������39��̨�ף��ж����ֲ�ͬ���Ϸ��أ�
public class t14 {
	private static int f(int n){
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		return f(n-1)+f(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(f(1));
		System.out.println(f(2));
		System.out.println(f(3));
		System.out.println(f(39));
	}
}
