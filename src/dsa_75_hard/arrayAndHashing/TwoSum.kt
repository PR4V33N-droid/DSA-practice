package dsa_75_hard.arrayAndHashing

/**
    Question Link: {@link https://leetcode.com/problems/two-sum/description/}

    1. Two Sum

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]
 */

fun main(){
    val twoSumIndexes = twoSum(
        intArrayOf(2,7,11,15),
        9
    )
    println(twoSumIndexes.contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map: MutableMap<Int, Int> = HashMap()

    for( i in nums.indices) {
        val diff = target - nums[i]
        if(map.containsKey(diff)){    //check difference is present in map ?
            return intArrayOf(map[diff]!!, i)   // if present, return the function with index of the diff and current index
        }
        map[nums[i]] = i    // add element as key and index as value
    }
    return intArrayOf()
}