package Hard;

public class MostTrappingWater42 {

	public static void main(String[] args) {
		int a[] = {4,2,3};
		System.out.println(trap(a));

	}

	public static int trap(int[] height) {
        if(height.length<3)
            return 0;
		int brick=0;
		int high = 0;
		int index=0;
		int rain, res=0;
		int leftEnd=0;
		int cut=0;
		int rightEnd = height.length-1;
        for(int i=0;i<height.length;i++){
        	if(height[i]>high){
        		high = height[i];
        		index = i;
        	}
        	brick = brick+height[i];
        	if(brick==0){
        		leftEnd=i;
        	}
        }
        for(int j =height.length-1; j>=index;j--){
        	res=height[j]+res;
        	if(res==0)
        		rightEnd=j;
        	else
        		break;
        }
        rain = high*height.length-brick;
        System.out.println(rain);
        
        int left = 0;
        int right = height.length-1;
        int leftpre = index;
        int rightpre = index;
        int leftHigh=index;
        int rightHigh = index;
        while(left>leftEnd+1){
        	leftHigh=subHigh(height,height[leftHigh],height[leftpre]);
        	cut=(height[leftpre]-height[leftHigh])*leftpre;
        	rain=rain-cut;
        	leftpre=leftHigh;
        	left=leftHigh;
        }
        System.out.println(rain);
        rain = rain-(height[leftEnd+1]*(leftEnd+1));
        System.out.println(rain);
        
        while(right<rightEnd-1){
        	rightHigh = subHigh(height,height[rightHigh], height[rightpre]);
        	cut=(height[rightpre]-height[rightHigh])*rightpre;
        	rain=rain-cut;
        	rightpre=rightHigh;
        	right=rightHigh;
        }
        System.out.println(rain);
        rain = rain-(height[rightEnd-1]*(height.length-rightEnd));
        
        return rain;
        	
    }
	
	public static int subHigh(int[] height, int index, int high){
		int sub=0;
		int subIndex=index;
		for(int i=index;i>=0;i--){
			if(height[i]>sub){
				sub = height[i];
				subIndex = i;
			}
		}
		return subIndex;
	}
}
