package Easy;

public class isPalindrome {

	public static void main(String[] args) {
		int x = 1234321;
		System.out.println(isPalindrome(x));

	}
	public static boolean isPalindrome(int x) {
        int mod=1000000000;
        int pal = 0;
        int s = x;
        int t=1;
        int flag=0;
        for(int i=0;i<10;i++){
        	if(s/mod>0||flag==1){
        		flag=1;    		
        		pal=(s/mod)*t+pal;
        		t=t*10;
        		s=s-(s/mod)*mod;
        	}
        	mod = mod/10; 
        }
        if (pal==x)
        	return true;
        else
        	return false;
    }
}
