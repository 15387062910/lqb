package algorithm_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {
	// comparator
	public static class Mycomparator implements Comparator<String>{
		@Override
		public int compare(String a, String b) {
			return (a+b).compareTo(b+a);
		}
	}
	
	public static String lowestString(String[] strs){
		if(strs==null||strs.length==0){
			return "";
		}
		Arrays.sort(strs, new Mycomparator());
		String res = "";
		for(int i=0; i<strs.length; i++){
			res += strs[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] strs1 = {"jibw", "ji", "jp", "bw", "jibw"};
		System.out.println(lowestString(strs1));
		
		String[] strs2 = {"b", "ba"};
		System.out.println(lowestString(strs2));
	}
}
