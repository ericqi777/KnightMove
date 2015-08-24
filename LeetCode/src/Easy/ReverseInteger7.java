package Easy;
import java.lang.*;
public class ReverseInteger7 {

	public static void main(String[] args) {
		//System.out.println (Math.pow(10, 0));
		System.out.println(reverse(-1563847412));

	}
	
	public static int reverse(int x) {
		int pre = 1;
		if(x==Integer.MAX_VALUE||x==Integer.MIN_VALUE)
			return 0;
		if(x<0)
			pre = -1;
		x = x*pre;
		int k = 0;
		
		String a = Integer.toString(x);
		char[] ch = a.toCharArray();
		String t;
		int temp = 0;
		int n = ch.length;

		for(int i =0; i<n; i++){
        	t = String.valueOf(ch[i]);
        	temp = Integer.parseInt(t);
        	k = (int) (k+temp*Math.pow(10, i));      	
        }
          
		if(k==Integer.MAX_VALUE||k==Integer.MIN_VALUE)
		       return 0;
		else{
			k= k*pre;
			return k;
		}
	}
}
