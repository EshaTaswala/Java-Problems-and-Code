import java.util.Arrays;

class Solution{
	
	public static void main(String args[]) {
		
		int []prices = {5,11,2, 7, 11, 15};
		Solution sol = new Solution();
		 
		int res = sol.BuyAndSellStock(prices);
		System.out.println(res);
	}
	
	public int BuyAndSellStock(int[] prices) {
		if (prices == null || prices.length <= 1) {
            return 0; 
        }

        int minPrice = prices[0]; 
        int maxProfit = 0;      

        for (int i = 1; i < prices.length; i++) {
          
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
               
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
	}
}