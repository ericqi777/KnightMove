package Medium;

public class ContainerWithMostWater11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
        int left=0;
        int right = height.length-1;
        int lower;
        int max=0;
        
        while(right>left){
        	if(height[left]>=height[right]){
        		lower = height[right];
        		max = max>lower*(right-left)?max:lower*(right-left);
        		right--;
        		while(height[right]<lower&&right>left)
        			right--;
        	}
        	else{
        		lower = height[left];
        		max = max>lower*(right-left)?max:lower*(right-left);
        		left++;
        		while(height[left]<lower&&right>left)
        			left++;
        	}
        }
        return max;
	}      
}
