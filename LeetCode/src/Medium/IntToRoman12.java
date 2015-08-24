package Medium;

public class IntToRoman12 {

	public static void main(String[] args) {
		int num=3999;
		System.out.println(intToRoman(num));
	}
	
	public static String intToRoman(int num){
		//I=1	V=5	X=10	L=50	C=100	D=500	M=1000
		int b=num;
		int mod=1000;
		String t="";
		
		String[][] roman={{"M"},{"C","D","M"},{"X","L","C"},{"I","V","X"}};
		int[] a=new int[4];
		
		for(int i=0;i<4;i++){
			a[i]=b/mod;
			b=b-a[i]*mod;
			mod=mod/10;
			String c="";
			if(a[i]==4||a[i]==9){
				if(a[i]==4)
					c=roman[i][0]+roman[i][1];
				if(a[i]==9)
					c=roman[i][0]+roman[i][2];
				t=t+c;
			}
			else if(a[i]==0){
				
			}
			else if(a[i]<4){
				c=roman[i][0];
				while(a[i]!=1){
					c=roman[i][0]+c;
					a[i]--;
				}
				t=t+c;
			}
			else if(a[i]==5){
				c=roman[i][1];
				t=t+c;
			}
			else{
				c=roman[i][1];
				while(a[i]!=5){
					c=c+roman[i][0];
					a[i]--;
				}
				t=t+c;
			}
		}
		return t;
	}
}
