package lqb_beikao;

// �ձ�ĳ�ط�����һ��ıɱ��������ͨ���Ų�ȷ��ɱ�����ֱ�Ϊ4�����ɷ���һ��������Ϊ4�����ɷ��Ĺ��ʡ�
// A˵�������ҡ�  B˵����C��  C˵����D�� D˵��C�ں�˵  ��֪3����˵���滰��1����˵���Ǽٻ���
// �����������Щ��Ϣ��дһ��������ȷ������˭�����֡�
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
