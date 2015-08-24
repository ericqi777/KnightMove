package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sumof3 {

	public static void main(String[] args) {
		int[] a ={-4,-1,-1,0,1,2};
		System.out.println(threeSum(a));

	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> sum = new ArrayList<List<Integer>>();
		
		if(nums.length<3)
			return sum;
		
		int i=0;
		
		
		for(i=0;i<nums.length-2;i++){
		    while((i>0&&i<nums.length-2)&&nums[i]==nums[i-1]){
		        i++;
		    }
		    int head=i+1;
		    int tail = nums.length-1;
			while(head<tail){
				
				if(nums[i]+nums[head]+nums[tail]==0){
				    ArrayList<Integer> next = new ArrayList<Integer>();
					next.add(nums[i]);
					next.add(nums[head]);
					next.add(nums[tail]);
					
					sum.add(next);
					do{head++;}
					while(head<tail&&nums[head]==nums[head-1]);
					do{tail--;}
					while(head<tail&&nums[tail]==nums[tail+1]);
				}
				
				else if(nums[i]+nums[head]+nums[tail]<0){
					head++;
					
				}
				else if(nums[i]+nums[head]+nums[tail]>0){
					tail--;
					
				}
			}
		}		
		return sum;
    }
}
