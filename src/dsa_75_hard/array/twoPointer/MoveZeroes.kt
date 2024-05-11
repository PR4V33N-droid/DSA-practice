package dsa_75_hard.array.twoPointer

/**
 * Question Link: {@link https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75}
 *
 * 283. Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 */

fun main(){
    val nums = intArrayOf(0,1,0,3,12)
    moveZeroes(nums)
    print(nums.contentToString())
}

/**
 * Moves non-zero elements of an array to the beginning, maintaining their order,
 * while placing zeros at the end. Does this in-place without using extra space.
 *
 * This function utilizes a two-pointer approach. It iterates through the array
 * and finds the index of the next non-zero element. It then swaps the value at
 * that non-zero index with the value at an index currently holding a zero.
 * A separate variable keeps track of the non-zero index to use it for the next swap.
 *
 * @param [nums] The input array of integers.
 */

fun moveZeroes(nums: IntArray) {

    var nonZeroIndex = 0
    for( i in nums.indices){
        if(nums[i]!=0){
            val temp = nums[nonZeroIndex]
            nums[nonZeroIndex] = nums[i]
            nums[i] = temp
            nonZeroIndex++
        }
    }
}
