class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 1;
        int profit = 0;
        while(sell<prices.length){
            if(prices[sell]-prices[buy] > profit){
                profit = prices[sell]-prices[buy];
            } else if(prices[buy]>prices[sell]){
                buy = sell;
            }
            sell++;
        }
        return profit;
    }
}