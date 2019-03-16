class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 1;
        int profit = 0, sum = 0;
        while(sell<prices.length){
            if(prices[sell]-prices[buy] > profit){
                profit = prices[sell]-prices[buy];
            } else if(prices[buy]>prices[sell]){
                buy = sell;
                sum += profit;
                profit = 0;
            } else if(prices[sell]<prices[sell-1]){
                buy = sell;
                sum += profit;
                profit = 0;
            }
            sell++;
        }
        sum += profit;
        
        return sum;
    }
}