package lqb_beikao;

// ͳ�Ƶ���
// ͳ���ַ����еĵ��ʸ���������ĵ���ָ���������Ĳ��ǿո���ַ���  ע�⣬����Լٶ��ַ����ﲻ�����κβ��ɴ�ӡ���ַ���
// ����: "Hello, my name is John"  ���: 5

public class t19 {
	private static int countSegments(String s) {
		// �����ύ��ַ: https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
		int res;
		if(s.length()==0||s==null){
			res = 0;
		}
		else{
			// Ĭ��һ��ʼ����һ������
			res = 1;
			for(int i=0; i<s.length(); i++){
				if(s.charAt(i)==' '){
					if(i<s.length()-1){
						if(s.charAt(i+1)!=' '){
							res += 1;
						}
					}
				}
			}
			if(s.charAt(0)==' '){
				// һ��ʼû�е���
				res -= 1;
			}
			
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		System.out.println(countSegments(""));
		System.out.println(countSegments("Hello, my name is John"));
		System.out.println(countSegments(", , , ,        a, eaefa"));
	}
}
