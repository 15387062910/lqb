package javaB2016;

/*
��������:
	ĳ����ĳ�꿪ʼÿ�궼�ٰ�һ������party������ÿ�ζ�Ҫ��Ϩ��������ͬ����������
	��������������һ����Ϩ��236������
	���ʣ����Ӷ����꿪ʼ������party�ģ�
	����д����ʼ������party����������
	ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�		��: 26
*/
public class t2 {
	public static void main(String[] args) {
		for(int i=1; i<=100; i++){
			int t = 0;
			for(int j=i; j<=100; j++){
				t += j;
				if(t==236){
					System.out.println(i + " " + j);
					// System.out.println(26+27+28+29+30+31+32+33);
				}
				if(t>236){
					break;
				}
			}
		}
	}
}
