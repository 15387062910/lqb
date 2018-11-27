package lqb_beikao;

/* 求众数
 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 你可以假设数组是非空的，并且给定的数组总是存在众数。

 示例 :
 输入: [3,2,3]
 输出: 3

 输入: [2,2,1,1,1,2,2]
 输出: 2

 */

import java.util.Map;
import java.util.HashMap;

public class t23 {
	private static int findM(int[] arr){
		int res = 0;
		int Mid = arr.length/2;
		// transfer array to map
		Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();		// similar to python's dict
		for(int num:arr){
			if(numberMap.get(num)==null){
				numberMap.put(num, 1);
			} else{
				numberMap.put(num, (numberMap.get(num))+1);
			}
		}
		
		// find the mode
		for (Map.Entry<Integer, Integer> entry : numberMap.entrySet()) { 
			if(entry.getValue()>Mid){
				res = entry.getKey();
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[] arr1 = { 3, 2, 3 };
		int[] arr2 = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(findM(arr1));
		System.out.println(findM(arr2));
	}
}
