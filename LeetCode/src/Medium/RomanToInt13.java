package Medium;

public class RomanToInt13 {

	public static void main(String[] args) {
		String roman="DCXXI";
		System.out.println(romanToInt(roman));

	}
	public static int romanToInt(String s) {
		int num=0;
		//I=1	V=5	X=10	L=50	C=100	D=500	M=1000
        int[] a=new int[s.length()];
        for(int i=0;i<s.length();i++){
        	if(s.substring(i, i+1).equals("M"))
        		a[i]=1000;
        	else if(s.substring(i, i+1).equals("D"))
        		a[i]=500;
        	else if(s.substring(i, i+1).equals("C"))
        		a[i]=100;
        	else if(s.substring(i, i+1).equals("L"))
        		a[i]=50;
        	else if(s.substring(i, i+1).equals("X"))
        		a[i]=10;
        	else if(s.substring(i, i+1).equals("V"))
        		a[i]=5;
        	else
        		a[i]=1;
        	if(i>0){
        		if(a[i-1]<a[i])
        			num=num-a[i-1];
        		else
        			num=num+a[i-1];
        	}
        }    
        num = num+a[a.length-1];
        return num;
    }

}
