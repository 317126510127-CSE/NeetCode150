//Approach: Bruteforce (Nested Loops,2 loops)
//Time & Space Complexity
//Time complexity: O(n*2)
//Space complexity: O(1)

public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sell = prices[j];
                res = Math.max(res, sell - buy);
            }
        }
        return res;
    }
}



//Approach: Two Pointers
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxP = 0;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                l = r;
            }
            r++;
        }
        return maxP;
    }
}



//Approach: My solution
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;
        if (prices.length <= 1) {
            return 0;
        }
        int lastMinPrice = prices[0], len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] > lastMinPrice) {
                int profit = prices[i] - lastMinPrice;
                maximumProfit = Math.max(profit, maximumProfit);
            }
            if (prices[i] < lastMinPrice) {
                lastMinPrice = prices[i];
            }
        }
        return maximumProfit;
    }
}



//Approach : Similar to My Solution (Dynamic Programming) (Optimal)
//Time & Space Complexity
//Time complexity: O(n)
//Space complexity: O(1)
public class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }
}