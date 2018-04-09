import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StockPricesYesterday {
    @Test
    public void foo(){
        List prices = Arrays.asList(10, 7, 5, 8, 11, 9);

        assertEquals(6,getMaxProfit(prices));
    }

    public int getMaxProfit(List<Integer> prices){
        int lowest = prices.get(0);
        int highest = prices.get(0);
        int max = highest - lowest;

        for(Integer price : prices){
            if(price < lowest){
                lowest = price;
            }
            if(price > highest){
                highest = price;
            }

            if(highest - lowest > max){
                max = highest - lowest;
            }
        }

        return max;
    }
}
