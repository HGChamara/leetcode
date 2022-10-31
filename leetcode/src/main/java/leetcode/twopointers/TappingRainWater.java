package leetcode.twopointers;

public class TappingRainWater {

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trapWithTwoPointers(height));
	}
	
	public static int trapWithTwoPointers(int[] height) {
		
		int i=0;
		int j=height.length-1;
		int ML = height[0];
		int MR = height[height.length-1];
		int dropCount = 0;
		
		while(i<j) {
			int a = height[i];
			int b = height[j];
			//System.out.println("---------Start--------------");
			//System.out.println("i-"+i+" | j-"+j);
			//System.out.println("a="+a+" | b="+b);
			
			if(ML<=a) {
				ML=a;
			}
			if(MR<=b) {
				MR=b;
			}
			//System.out.println("ML - "+ML+" | MR - "+MR);
			if(ML<=MR) {
				dropCount += (ML-a)>=0?(ML-a):0;
				i++;
			}
			else {
				dropCount += (MR-b)>=0?(MR-b):0;
				j--;
			}
			//System.out.println("---------End--------------");
		}
		//System.out.println();
		return dropCount;
	}
	
	public static int trap(int[] height) {
		
		int block =0;
		int[] maxLefts  = new int[height.length];
		//int[] maxRights = new int[height.length];
		//int[] minLR = new int[height.length];
		int maxLeft = 0;
		int maxRight = 0;
		
		int tempLR = 0;
		
		for(int i=0; i<height.length; i++) {
			if(i==0) {
				maxLeft = 0;
			}
			else {
				if(height[i-1]>maxLeft) {
					maxLeft = height[i-1];
				}
			}
			maxLefts[i] = maxLeft;
		}
		
		for(int i=height.length-1; i>=0; i--) {
			if(i==height.length-1) {
				maxRight = 0;
			}
			else {
				if(height[i+1]>maxRight) {
					maxRight = height[i+1];
				}
			}
			//maxRights[i] = maxRight;
			
			tempLR= maxLefts[i]>maxRight ? maxRight : maxLefts[i];
			
			if(tempLR-height[i]>0) {
				block += tempLR-height[i];
			}
			
		}
		
		
        return block;
    }

}
