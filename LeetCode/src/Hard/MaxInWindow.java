package Hard;

public class MaxInWindow {
	public static void main(String[] args){
		int[] nums = {1,3,1,2,0,5};
		int k = 3;
		int[] a = maxSlidingWindow(nums, k);
		for(int i = 0; i <a.length; i++){
			System.out.println(a[i]);
		}
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return null;
        }
        if(k<2){
            return nums;
        }
        int max = nums[0];
        int index = 0;
        int subIndex;
        int left = -1;
        int right = k-1;
        int[] pair = new int[2];
        int[] a = new int[nums.length-k+1];
        int l = a.length;
        int i = 0;
       
        
        do{
            pair = findMax(left, nums,k);
            max = pair[0];
            subIndex = pair[1];
            left = subIndex;
            System.out.println("max:"+max);
            System.out.println("i:"+i);
            System.out.println("right:"+right);
            System.out.println("index:"+index);
            i = fill(max, a, i,left, index,l);
            index =left;
           right = left+k-1;
        }while(right< nums.length);
        return a;
    }
    
    public static int[] findMax(int index, int[] nums,int k){
        int[] pair = new int[2];
        int max = nums[index+1];
        int last = nums.length;
        if(index+k+1<=nums.length)
            last = index+k+1;
        
        for(int i = index+1; i<last; i++){
            if(nums[i]>=max){
                max = nums[i];
                index = i;
            }
        }
        pair[0] = max;
        pair[1] = index;
        
        return pair;
    }
    
    public static int fill(int max, int[] a, int i, int left, int index, int l){
        int p = index;
        if(i == 0){
        	a[i] = max;
        	i++;     	
        }
        else{
        	while(p<left&&i<l){
        		a[i] = max;
        		i++;
        	}
        }	
        return i;
    }
}
