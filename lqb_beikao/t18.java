package lqb_beikao;

// (1)��ת�����е��ʵ�˳��
// ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣�����е����Կո��������
// Ϊ������������ź���ͨ��ĸһ��������ע�⴦���������ַ���ʱ�Ļس��ַ���
// ���룺�跴ת���ַ���  ���������Ҫ��ת����ַ���
// ʾ�����������롰I am a student.�����������student. a am I��

// (2)��ת�ַ���
// ��дһ���������������ǽ�������ַ�����ת������
// ����: "hello" ���: "olleh"
// ����: "A man, a plan, a canal: Panama"  ���: "amanaP :lanac a ,nalp a ,nam A"
public class t18 {
	private static String reverseWord(String str){
		String[] split = str.split(" "); 	// ��������ַ������зָ� ����һ������
		StringBuilder res = new StringBuilder();
		for(int i=split.length-1; i>=0; i--){
			if(i==0){
				res.append(split[i]);
			} else{
				res.append(split[i] + " ");
			}
		}
		return res.toString();
	}
	
	private static String reverseString(String s) {
		// �����ύ��ַ: https://leetcode-cn.com/problems/reverse-string/description/
		// ��ͳֱ��reverse�ķ��������ݹ���ʱʱ�䲻�� ��ʱ��  
		int length = s.length();
        char[] str = s.toCharArray();
        for(int i = 0;i < length / 2;i++){
            char temp = str[i];
            str[i] = str[length - 1 - i];
            str[length - 1 - i] = temp;
        }
        return new String(str);
    }
	
	public static void main(String[] args) {
		String r = reverseWord("I am a student.");
		System.out.println(r);
		System.out.println(reverseString("hello"));
		System.out.println(reverseString("A man, a plan, a canal: Panama"));
	}
}
