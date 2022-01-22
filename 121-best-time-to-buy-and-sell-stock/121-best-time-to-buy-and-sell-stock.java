class Solution {
    
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int currentMin = prices[0];
        
        for(int i=1; i<prices.length; i++) {
            
            if(currentMin < prices[i] ) {
            
              int currentProfit = prices[i] - currentMin;
            
              if(currentProfit > maxProfit) {
                maxProfit = currentProfit;
              }
            }
            
            if(prices[i] < currentMin ) {
                currentMin = prices[i];
            }
            
        }
        
        return maxProfit;
        
    }
}