package Medium;

public class LongestPalindromicSubstring5 {

	public static
	void main(String[] args) {
		String x = "aaaaabcdefghijkjihgfedcbaccccc";
		String s = "aaaa";
		String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(longestPalindrome(s));
		//System.out.println(reverse("abcdef"));

	}
	
	public static String longestPalindrome(String s) {
        int start=0;
        int end=1;
        int range=0;
        int a = s.length();
        String max = "#";
        
        if(a==3){
        	if(s.substring(0,1).equals(s.substring(2,3)))
        		return s;
        	else
        		return null;
        }
        for(end=1;end+2<a;end++){
        	if(s.substring(end-1, end).equals(s.substring(end, end+1))){
        		range = max.length()%2==1?1+max.length()/2:max.length();
        		System.out.println("end: "+end);
        		System.out.println("range: "+range);
        		boolean con = end-range>=0&&end+range<=max.length();
        		if(con){
        		if(s.substring(end-range,end-range+1).equals(s.substring(end+range-1,end+range)))
        			max=evenPanlindromic(s,start,end,max);}
        	}
        	else if(s.substring(end-1,end).equals(s.substring(end+1,end+2))){
        		range = max.length()%2==1?1+max.length()/2:max.length();
        		boolean con1 = end-range>=0&&end+range+1<=max.length();
        		if(con1){
        		if(s.substring(end-range, end-range+1).equals(s.substring(end+range,end+range+1)))
        			max=oddPanlindromic(s,start,end,max);}
        	}
        }      
        return max;        
    }
	
	public static String evenPanlindromic(String s, int start, int end, String max){
		int leftEnd = end;
		int rightEnd = end;
		String left = s.substring(leftEnd-1, leftEnd);
		String right = s.substring(rightEnd,rightEnd+1);
		while(left.equals(right)){
			if(rightEnd-leftEnd+2>=max.length())				
				max = s.substring(leftEnd-1,rightEnd+1);			
			leftEnd--;
			rightEnd++;
			if(leftEnd==0||rightEnd==s.length())
				break;
			left = s.substring(leftEnd-1, leftEnd);
			right = s.substring(rightEnd,rightEnd+1);
		}
		return max;
	}
	
	public static String oddPanlindromic(String s, int start, int end, String max){
		int leftEnd = end;
		int rightEnd = end;
		System.out.println(max);
		String left = s.substring(leftEnd-1, leftEnd);
		String right = s.substring(rightEnd+1,rightEnd+2);
		while(left.equals(right)){
			if((rightEnd-leftEnd+3)>=max.length())
				max = s.substring(leftEnd-1,rightEnd+2);
			if(leftEnd==1||rightEnd+2==s.length())
				break;
			leftEnd--;
			rightEnd++;
			left = s.substring(leftEnd-1, leftEnd);
			right = s.substring(rightEnd+1,rightEnd+2);			
		}
		System.out.println(max);
		return max;
	}
}
