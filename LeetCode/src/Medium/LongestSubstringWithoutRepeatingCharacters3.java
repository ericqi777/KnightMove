package Medium;

public class LongestSubstringWithoutRepeatingCharacters3 {

	public static void main(String[] args) {
		
		System.out.println(lengthOfLongestSubstring("abba"));

	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s=="")
			return 0;
		String next,pre="";
		int current=0,k=0,max =0;
        
        for(int i=0; i<s.length();i++){
        	if(i == s.length()-1)
        		next = s.substring(i);
        	else
        		next=s.substring(i, i+1);
        	//System.out.println(next);
        	if(pre.contains(next)==false){
        		pre +=  next;
        		current++;
        		max = max>current?max:current;
        	}
        	else{
        		k = pre.indexOf(next);
        		pre = pre.substring(k+1)+next;
        		//System.out.println(pre);
        		current = pre.length();
        		max = max>current?max:current;
        		//System.out.println(pre.length());
        	}
        }
        return max;
    }

}
