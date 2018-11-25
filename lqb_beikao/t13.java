package lqb_beikao;

// 日本某地发生了一件谋杀案，警察通过排查确定杀人凶手必为4个嫌疑犯的一个。以下为4个嫌疑犯的供词。
// A说：不是我。  B说：是C。  C说：是D。 D说：C在胡说  已知3个人说了真话，1个人说的是假话。
// 现在请根据这些信息，写一个程序来确定到底谁是凶手。
public class t13 {
	
	public static void main(String[] args) {
		int murder;
		for(murder=1; murder<=4; murder++){
			int res = 0;
			if(murder!=1){
				res += 1;
			}
			if(murder==3){
				res += 1;
			}
			if(murder==4){
				res += 1;
			}
			if(murder!=4){
				res += 1;
			}
			if(res==3){
				System.out.println((char)('A'+murder-1));
			}
		}
	}
	
}
