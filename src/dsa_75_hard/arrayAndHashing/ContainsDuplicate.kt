package dsa_75_hard.arrayAndHashing

/**
    Question Link: {@link https://leetcode.com/problems/contains-duplicate/description/}

    217. Contains Duplicate

    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: true

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

 */

fun main(){
    print(containsDuplicate(intArrayOf(1,2,3,4)))
}

/**
 * in this approach, we'll use set and add items one-by-one
 * while adding we'll also check if element is already present or not
 * Time Complexity - O(n),
 * Space Complexity - 0(n)
 */
fun containsDuplicate(nums: IntArray): Boolean {
    val setContainer = mutableSetOf<Int>()
    for(num in nums){
        if(setContainer.contains(num)) return true
        setContainer.add(num)
    }
    return false
}

/**
 * in this approach, we'll use two loop first loop takes a number and
 * compare it with other numbers in second loop
 * Time Complexity - O(n^2),
 * Space Complexity - 0(1)
 */
fun containsDuplicateBruteForceApproach(nums: IntArray): Boolean {
    for(i in nums.indices){
        for(j in i+1 until nums.size){
            if(nums[i] == nums[j]) return true
        }
    }
    return false
}


/**
 * in this approach, we'll sort the array first and
 * compare an element with the next element, as the array is sorted, the duplicate numbers will be next to each other.
 * Time Complexity - O(nlogn) better than O(n^2),
 * Space Complexity - 0(1)
 */
fun containsDuplicateSortingApproach(nums: IntArray): Boolean {
    nums.sort()
    print(nums.contentToString())
    for(i in 0 until nums.size-1){
        if(nums[i] == nums[i+1]) return true
    }
    return false
}