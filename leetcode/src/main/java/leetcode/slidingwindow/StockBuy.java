package leetcode.slidingwindow;

public class StockBuy {

	public static void main(String[] args) {
		int[] stockprices = {2,4,1};
		
		int profit = maxProfit(stockprices);
		System.out.println(profit);

	}
	
	public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = prices[0];
        
        int l=0;
        int r=1;
        
        while(r<prices.length) {
        	if(prices[l]>prices[r]) {
        		minValue = prices[r];
        		//maxProfit=0;
        		l=r;
        		r++;
        	}
        	else {
        		System.out.println(prices[l]+" "+prices[r]);
        		if(maxProfit<(prices[r]-prices[l])) {
        			maxProfit = (prices[r]-prices[l]);
        		}
        		r++;
        	}
        }
        return maxProfit;
    }
	
	public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int minValue = prices[0];
        
        for(int i=0; i<prices.length; i++) {
        	
        	if(prices[i]<minValue) {
        		minValue = prices[i];
        	}
        	
        	if((prices[i]-minValue)>maxProfit) {
        		maxProfit = (prices[i]-minValue);
        	}
        	
        }
        return maxProfit;
    }

}
