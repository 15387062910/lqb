package lqb_beikao;

// �ַ���ȫ����
/*
����һ���ַ���S��ͨ�����ַ���S�е�ÿ����ĸת���Сд�����ǿ��Ի��һ���µ��ַ������������п��ܵõ����ַ������ϡ�

ʾ��:
	����: S = "a1b2"
	���: ["a1b2", "a1B2", "A1b2", "A1B2"]
	
	����: S = "3z4"
	���: ["3z4", "3Z4"]
	
	����: S = "12345"
	���: ["12345"]

ע�⣺
	S �ĳ��Ȳ�����12��
	S �������ֺ���ĸ��ɡ�
*/

import java.util.ArrayList;
import java.util.List;

public class t21 {
	private static void dfs(String pre, String S, List<String> res, int index) {
	    /*
	     * pre:  �ۼƵ��ӵ��ַ���
	     * S: 	  ԭʼ�ַ���
	     * res:  ����б�
	     * index: ��ǰ����
	     */
	    if (index == S.length()){
	    	// ���е���� ��pre��ӵ�����б���
	    	res.add(pre);
	    }
	    else {
	        char ch = S.charAt(index);
	        if (!Character.isLetter(ch)){
	        	// ���������ĸ
	        	dfs(pre + ch, S, res, index + 1);
	        }
	            
	        else {
	            // ���ַ�����ת��ΪСд��
	            ch = Character.toLowerCase(ch);
	            dfs(pre + ch, S, res, index + 1);
	            // ���ַ�����ת��Ϊ��д��
	            ch = Character.toUpperCase(ch);
	            dfs(pre + ch, S, res, index + 1);
	        }
	    }
	}
	    
    private static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList();
        dfs("", S, res, 0);
        return res;
    }
	    
	public static void main(String[] args) {
		List<String> res = new ArrayList();
		res = letterCasePermutation("a1b2");
		System.out.println(res);
	}
}
