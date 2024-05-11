package dsa_75_hard.array.slidingWindow

import kotlin.math.max

/**
    Question Link: {@link https://leetcode.com/problems//best-time-to-buy-and-sell-stock/description/}

    121. Best Time to Buy and Sell Stock

    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.

 */

fun main() {
    val maxProfit = maxProfit(intArrayOf(7,1,5,3,6,4))
    print(maxProfit)
}


/**
 * here, we're using sliding window technique:
 * we'll take two pointer l=0 (l will point to the first element)
 * r=1 (r will be pointing to the second element
 * we'll loop through the array until r is less than the array size
 * if the element at l is less than element at right, we keep on increment r
 * if element at l is greater than element at right, we'll change the value of l with r
 * check if the currProfit is greater than maxProfit, make currProfit as maxProfit
 */
fun maxProfit(prices: IntArray): Int {
    var l = 0
    var r = 1
    var maxProfit = 0

    while(r < prices.size){
        if(prices[r] > prices[l]){
            val currProfit = prices[r] - prices[l]
            maxProfit = max(maxProfit, currProfit)
        } else {
            l = r
        }
        r++
    }

    return maxProfit
}