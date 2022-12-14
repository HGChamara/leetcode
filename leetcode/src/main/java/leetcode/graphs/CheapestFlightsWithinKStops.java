package leetcode.graphs;


public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(findCheapestPrice(4, flights, 0, 3, 1 ));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for(int i=0; i<n; i++) {
            prices[i] = Integer.MAX_VALUE;
        }
        prices[src] = 0;
        //Bellman-ford
        for(int j=0; j<k+1; j++) {
            int[] tempPrices = prices.clone();

            for(int[] flight : flights) {
                if(prices[flight[0]]==Integer.MAX_VALUE) continue;
                if(prices[flight[0]]+flight[2] < tempPrices[flight[1]]) tempPrices[flight[1]] = prices[flight[0]]+flight[2];
            }
            prices = tempPrices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
