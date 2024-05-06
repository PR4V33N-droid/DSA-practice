package dsa_75_hard.twoPointer

import kotlin.math.max
import kotlin.math.min

/**
 * Question Link: {@link https://leetcode.com/problems/container-with-most-water/description}
 *
 * 11. Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 */

fun main(){
    val maxWater = maxArea(intArrayOf(1,1))
    print(maxWater)
}

/**
 * The maxArea function uses two pointers, i and j, to iterate through the pillars array.
 * It compares the heights of the pillars pointed to by i and j and calculates the area of the container formed by them.
 * It keeps track of the maximum area found so far and updates it if a larger area is encountered.
 * The pointers are moved strategically to find the optimal combination of pillars that maximizes the container's area.
 */

fun maxArea(pillars: IntArray): Int {
    var j = pillars.size - 1
    var i = 0
    var maxArea = 0
    var minPillar: Int

    while(i != j){
        minPillar = min(pillars[i], pillars[j])
        val newMaxArea = minPillar * (j - i)
        maxArea = max(newMaxArea, maxArea)
        if(pillars[i] > pillars[j]) j--
        else i++
    }

    return maxArea
}