package javaB2016;

/* 
	    B          DEF
A +    ---    +  -------  = 10
        C          GHI
 
�����ʽ��A~I����1~9�����֣���ͬ����ĸ����ͬ�����֡�
���磺
	6+8/3+952/714 ����һ�ֽⷨ��
	5+3/1+972/486 ����һ�ֽⷨ��
	�����ʽһ���ж����ֽⷨ��
	ע�⣺���ύӦ���Ǹ���������Ҫ��д�κζ�������ݻ�˵�������֡�
*/
// ˼·: �Ų�ѭ�� �����ƽ� ��ĺܱ��������� ����û��ϵ ������������� ��𰸵��ⲻ�ں�����������
// ��һ����������� 38706673 �о����԰� ��ô������ô��  һ������29 ��Ȼ���� 
// �����û���ҳ����������ġ�����
// ԭ����©��һ������: A~I����1~9�����֣���ͬ����ĸ����ͬ������ ��������
// �����������֮���������35721  ���ǲ��� ������

public class t3 {
	private static boolean check(int i, int j, int k, int l, int a, int b, int c, int d, int e){
		// ����ԭ��
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
		int res = 0;	// ��¼�����
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
