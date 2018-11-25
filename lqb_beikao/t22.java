package lqb_beikao;

/* ���仰�еĲ���������
������������ A �� B �� ��������һ���ɿո�ָ��ĵ��ʡ�ÿ�����ʽ���Сд��ĸ��ɡ���
���һ������������һ��������ֻ����һ�Σ�����һ��������ȴû�г��֣���ô������ʾ��ǲ������ġ�
�������в����õ��ʵ��б����԰��κ�˳�򷵻��б�

ʾ�� 1��
	���룺A = "this apple is sweet", B = "this apple is sour"
	�����["sweet","sour"]
ʾ�� 2��
	���룺A = "apple apple", B = "banana"
	�����["apple","banana"]
 
��ʾ��
	0 <= A.length <= 200
	0 <= B.length <= 200
	A �� B ��ֻ�����ո��Сд��ĸ�� 
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class t22 {
	// �ַ�������ȥ��
	private static String[] lt(String[] arrStr){
		Map<String, Object> map = new HashMap<String, Object>();
		for(String str:arrStr){
			map.put(str, str);
		}
		String[] newArrStr = map.keySet().toArray(new String[1]);
		
		return newArrStr;
	}
	
	private static String[] split(String str){
		String[] res = str.split(" ");
		
		return lt(res);
	}
	
	private static List<String> f(String[] s1, String[] s2){
		List<String> res = new ArrayList();
		// �ҳ�s1�д��ڵ�����s2�еĵ���
		for(int i=0; i<s1.length; i++){
			String a = s1[i];
			// System.out.println("a: " + a);
			boolean find = false;
			for(int j=0; j<s2.length; j++){
				String b = s2[j];
				// System.out.println("b: " + b);
				if(a.equals(b)){
					find = true;
					break;
				}
			}
			if(!find){
				res.add(a);
			}
		}
		
		// �ҳ�s2�д��ڵ�����s1�еĵ���
		for(int i=0; i<s2.length; i++){
			String a = s2[i];
			// System.out.println("a: " + a);
			boolean find = false;
			for(int j=0; j<s1.length; j++){
				String b = s1[j];
				// System.out.println("b: " + b);
				if(a.equals(b)){
					find = true;
					break;
				}
			}
			if(!find){
				res.add(a);
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		List<String> res = f(split("this apple is sweet"), split("this apple is sour"));
		System.out.println(res);
		List<String> res2 = f(split("apple apple"), split("banana"));
		System.out.println(res2);
	}
}
