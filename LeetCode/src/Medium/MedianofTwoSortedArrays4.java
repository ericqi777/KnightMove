package Medium;

import java.util.Arrays;

public class MedianofTwoSortedArrays4 {

	public static void main(String[] args) {
		int [] a1 = {1,5};
		int [] a2 = {2,3,4,6};
		
		System.out.println(	findMedianSortedArrays(a1, a2));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int len1 = nums1.length;
       int len2 = nums2.length;
       int skew = len1>len2?len2/2:len1/2;
       int[] new1 = new int[len1+len2];
              
       if(len1==0&&len2==0)
    	   return 0;
       if(len1==0&&len2!=0) return findMedian(nums2);
       if(len2==0&&len1!=0) return findMedian(nums1);
       
       if(len1!=0&&len2!=0){
    	   if(len1==1||len2==1)
    		   return check(nums1,nums2);
       }
       
       if(nums1[len1-1]<=nums2[0]){
    	   int i=0;
    	   for(i=0;i<len1;i++){
    		   new1[i] = nums1[i];
    	   }
    	   for(int j=0;j<len2;j++){
    		   new1[i+j] =nums2[j];
    	   }
    	   return findMedian(new1);
       }
       if(nums1[0]>=nums2[len2-1]){
    	   int i=0;
    	   for(i=0;i<len2;i++){
    		   new1[i] = nums2[i];
    	   }
    	   for(int j=0;j<len1;j++){
    		   new1[i+j] =nums1[j];
    	   }
    	   return findMedian(new1);
       }
       
       
       if(len1==0&&len2!=0) return len2%2==1?nums2[len2/2]:(double)(nums2[(len2/2)-1]+nums2[len2/2])/2;
       if(len2==0&&len1!=0) return len1%2==1?nums1[len1/2]:(double)(nums1[(len1/2)-1]+nums1[len1/2])/2;
       
       double med1 = findMedian(nums1);
       double med2 = findMedian(nums2);
      
       int n1[];
       int n2[];
       
       if(med1==med2)
    	   return med1;
       else if(med1>med2){
    	   n1 = shrinkDown(nums1,skew);
    	   for(int i=0;i<n1.length;i++){
    		   System.out.println("~~~~n1["+i+"]"+n1[i]);
    	   }
    	   n2 = shrinkUp(nums2,skew);
    	   for(int j=0;j<n2.length;j++){
    		   System.out.println("~~~~n2["+j+"]"+n2[j]);
    	   }
       }
       else{
    	   n1 = shrinkUp(nums1,skew);
    	   for(int i=0;i<n1.length;i++){
    		   System.out.println("++++n1["+i+"]"+n1[i]);
    	   }
    	   n2 = shrinkDown(nums2,skew);
    	   for(int j=0;j<n2.length;j++){
    		   System.out.println("++++n2["+j+"]"+n2[j]);
    	   }
    	   if(n1[0]>=n2[n2.length-1])
    		   return 0;
       }
                	   
       return findMedianSortedArrays(n1,n2);       
	}
	
	public static double check(int[] n1, int[] n2){
		int l1=n1.length;
	    int l2=n2.length;
    
	    double m1 = findMedian(n1);
	    double m2 = findMedian(n2);
	             
	    if(l1==1&&l2==1)
	    	return (double)(n1[0]+n2[0])/2;
	    else if(l1!=1&&l2==1){
	    	if(m1==m2)   return m1;
	    	else if(m1>m2){
	    		if(l1%2==1)
	    			return m2>n1[(l1/2)-1]?(double)(n1[l1/2]+m2)/2:(double)(n1[l1/2]+n1[(l1/2)-1])/2;    			      
	    		else
	    			return m2>n1[(l1/2)-1]?m2:n1[(l1/2)-1];    			   
	    	}
	    	else{
	    		if(l1%2==1)
	    			return m2<n1[(l1/2)+1]?(double)(n1[l1/2]+m2)/2:(double)(n1[l1/2]+n1[(l1/2)+1])/2;   			   
	    		else
	    			return m2<n1[(l1/2)]?m2:n1[l1/2];    			   
	    	}
	    }
	    else{
	    	if(m1==m2) return m1;
	    	else if(m1>m2){
	    		if(l2%2==1)
	    			return m1>n2[(l2/2)+1]?(double)(n2[l2/2]+n2[(l2/2)+1])/2:(double)(n2[l2/2]+m1)/2;
	    		else
	    			return m1<n2[l2/2]?m1:n2[l2/2];
	    	}
	    	else{ 
	    		if(l2%2==1)
	    			return m1>n2[(l2/2)-1]?(double)(n2[l2/2]+m1)/2:(double)(n2[l2/2]+n2[(l2/2)-1])/2;
	    		else
	    			return m1>n2[(l2/2)-1]?m1:n2[(l2/2)-1];    	
	    	}
	     }
	}	
	
	public static int[] shrinkUp(int[] num, int sk){
		int len = num.length;
		int med = len/2;
		if(len==2){
			int[] a = {num[1]};
			return a;
		}
		if(len%2==1)
			return Arrays.copyOfRange(num,med,med+sk+1);
		else
			return Arrays.copyOfRange(num, med, med+sk);
	}
	
	public static int[] shrinkDown(int[] num, int sk){
		int len = num.length;
		int med = len/2;
		if(len==2){
			int[] a = {num[0]};
			return a;
		}
		if(len%2==0)		
			return Arrays.copyOfRange(num, med-sk, med);
		else
			return Arrays.copyOfRange(num, med-sk, med+1);		
	}
	
	public static double findMedian(int[] num){
		int len = num.length;
		double med;
	       
	    if(len%2==0&&len>2)
	    	med = (double)(num[len/2]+num[(len/2)-1])/2;
	    else if(len%2==1&&len>2)
	    	med = num[len/2];
	    else if(len==2)
	    	med = (double)(num[0]+num[1])/2;
	    else if(len==1)
	    	med = num[0];
	    else med = 0.1;
	    
	    return med;
	}	
}
