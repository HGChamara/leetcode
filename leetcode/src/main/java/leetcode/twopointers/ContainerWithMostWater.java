package leetcode.twopointers;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));

	}
	
	 public static int maxArea(int[] height) {
	       int i=0;
	       int j=height.length-1;
	       int maxVolume = 0;
	       while(i<j) {
	    	   
	    	   int minHeight = height[i]>=height[j] ? height[j] : height[i];
	    	   int tempVolume = minHeight * (j-i);
	    	   if(tempVolume>maxVolume) {
	    		   maxVolume = tempVolume;
	    	   }
	    	   if(height[i]>=height[j]) {
	    		   j--;
	    	   }
	    	   else if(height[i]<height[j]) {
	    		   i++;
	    	   }
	    	   else if (height[i]==height[j]) {
	    		   if(height[i+1]>height[j-1]) {
	    			   i++;
	    		   }
	    		   else {
	    			   j--;
	    		   }
	    	   }
	    	   
	       }
	       return maxVolume;
	    }

}
