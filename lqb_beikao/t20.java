package lqb_beikao;

// ��ת�ַ���
// ���������ַ���, A �� B��
// A ����ת�������ǽ� A ����ߵ��ַ��ƶ������ұߡ� ����, �� A = 'abcde'�����ƶ�һ��֮��������'bcdea' ��
// ��������ɴ���ת����֮��A �ܱ��B����ô����True��

/*
ʾ�� 1:
����: A = 'abcde', B = 'cdeab'
���: true

ʾ�� 2:
����: A = 'abcde', B = 'abced'
���: false
 */

public class t20 {
	private static boolean rotateString(String A, String B) {
		// �����ύ��ַ: https://leetcode-cn.com/problems/rotate-string/description/
		if(A==null||B==null){
			return false;
		} else if(A.length()!=B.length()){
			return false;
		} else{
			String c = A + A;
			if(c.contains(B)){
				return true;
			} else{
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(rotateString("", ""));
		System.out.println(rotateString("abcde", "cdeab"));
		System.out.println(rotateString("abcde", "abced"));
	}
}
