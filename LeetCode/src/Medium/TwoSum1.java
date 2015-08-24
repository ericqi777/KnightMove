package Medium;

import java.util.Arrays;

public class TwoSum1 {

	public static void main(String[] args) {
		int [] b = {-1,-2,-3,-4,-5};
		//System.out.println(twoSum(b,4)[0]);
		twoSum(b,-7);

	}
	
	 public static int[] twoSum(int[] numbers, int target) {
		    int[] a =new int[numbers.length];
		 	for(int j=0;j<numbers.length;j++){
		 		a[j] = numbers[j];
		 	}
	        int[] c = new int[2];
	        int m=0,n=0,l=0;
	        int index1=0;
	        int index2=0;
	        Arrays.sort(a);
	        for(int i=0;i<a.length;i++){
	        	m=m>Arrays.binarySearch(a, target-a[i])?m:Arrays.binarySearch(a, target-a[i]);
	        	if(m>0&&target-a[i]==a[m]){
	        		n=a[i];
	        		l=a[m];
	        		break;
	        	}
	        }
	 
	        for(int j = 0;j<numbers.length;j++){
		    	   if(numbers[j]==n){
		    		   index1=j+1;
		    		   break;
		    	   }
		    }
	        for(int k = 0;k<numbers.length;k++){
		    	   if(numbers[k]==l&&k!=index1-1){
		    		   index2=k+1;
		    		   break;
		    	   }
		    }
	       
	        c[0]=index1<index2?index1:index2;
	        c[1]=index1+index2-c[0];
	        
	        System.out.println(c[0]+"    "+c[1]	);
	        return c;
	 }

}
