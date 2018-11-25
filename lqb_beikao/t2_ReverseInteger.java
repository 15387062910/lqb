package lqb_beikao;

// 反转整数
// 任意输入一个整数，将其反转 eg:  230 -> 32   234 -> 432    -123 -> -321
// 注意: 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。

public class t2_ReverseInteger {
	static class Solution {
		// 利用求余法一步一步反转整数
	    public static int reverse(int x) {
	        long result = 0;
	        long tmp = Math.abs(x);
	        while(tmp>0){
	        	result *= 10;
	        	result += tmp % 10;
	        	if (result > Integer.MAX_VALUE){
	        		return 0;
	        	}
	        	tmp /= 10;
	        }
	        
	        return (int)(x>0?result:-result);
	    	
	    }
	}
	
	public static void main(String[] args) {
		int[] array = {123, -123, 120, -2147483648};
		
		for(int i=0; i<array.length; i++){
			int num = array[i];
			int res = Solution.reverse(num);
			System.out.println(res);
		}
	}
}
