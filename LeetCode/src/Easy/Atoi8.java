package Easy;

public class Atoi8 {

	public static void main(String[] args) {
		String s = "      -0012a";
		System.out.println(myAtoi(s));

	}
	
	public static int myAtoi(String str) {
        int pre=1;
        int prec=0;
        char cut;
        double atoi=0;
        int flag=0;

        for(int i=0;i<str.length();i++){
        	cut = str.charAt(i);
        	if(str.charAt(i)==43){
        		pre=1; 
        		prec++;
        	}
        	else if(str.charAt(i)==45){
        		pre=-1;   
        		prec++;
        	}
        	else if(cut==32){
        		if(flag==1||prec>0){
        			return (int) (atoi*pre);
        		}
        	}
        	else if(cut>=48&&cut<=57){
        		if(prec>1)
        			break;
        		else{
        			atoi = (atoi*10)+(cut-48);
        			flag=1; 
        		}
        	}
        	else if(cut<48||cut>57){
        		return (int) (atoi*pre);
        	}
        	else if(atoi>=2147483647&&pre==1){
        		atoi=2147483647;
        		return (int) atoi;
        	}
        	else if(atoi<=-2147483648&&pre==-1){
        		atoi=-2147483648;
        		return (int) atoi;
        	}
        }
        return (int) (atoi*pre);
    }

}
