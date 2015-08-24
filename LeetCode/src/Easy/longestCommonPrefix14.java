package Easy;

public class longestCommonPrefix14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length==0)
    		return "";
        int len=strs[0].length();
        int loca=0;
        boolean flag=true;
        String com = "";
        
        for(int i=1;i<strs.length;i++){
        	if(strs[i].length()<len){
        		len=strs[i].length();
        		loca = i;
        	}
        }
        
        for(int i=strs[loca].length();i>0;i--){
        	String sub=strs[loca].substring(0, i);
        	com=sub;
        	for(int j=0;j<strs.length;j++){
        		flag=flag&&sub.equals(strs[j].substring(0,i));
        	} 
        	if(flag==true)
        		return com;
        	else if(flag==false&&i==1)
        		return "";
        }
		return com;
    }
}
