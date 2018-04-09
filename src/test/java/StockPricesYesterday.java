import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockPricesYesterday {
    @Test
    public void getMaxProfitTest(){
        int[] prices = new int[]{100,10, 7, 5, 8, 11, 9};

        assertEquals(6,getMaxProfit(prices));
    }

    public int getMaxProfit(int[] prices){
        int lowest = prices[0];
        int maxDifference = prices[0] - lowest;

        for(int i=1;i<prices.length;i++){
            if(prices[i] - lowest > maxDifference){
                maxDifference = prices[i] - lowest;
            }
            if(prices[i] < lowest){
                lowest = prices[i];
            }
        }

        return maxDifference;
    }
}
