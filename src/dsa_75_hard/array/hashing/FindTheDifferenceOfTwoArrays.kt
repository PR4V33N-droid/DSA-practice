package dsa_75_hard.array.hashing


/**
 *  Question Link: {@link https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75}
 *
 *  2215. Find the Difference of Two Arrays
 *
 *  Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 *
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 * Note that the integers in the lists may be returned in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,3], nums2 = [2,4,6]
 * Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2,
 *  whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1,
 *  whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
 *
 * Example 2:
 * Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * Output: [[3],[]]
 * Explanation:
 * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3],
 * their value is only included once and answer[0] = [3].
 * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 */

fun main(){
    val difference = findDifference(
        intArrayOf(-80,-15,-81,-28,-61,63,14,-45,-35,-10),
        intArrayOf(-1,-40,-44,41,10,-43,69,10,2)
    )
    print(difference)
}

/**
 * Finds the difference between two unsorted integer arrays.
 *
 * This function takes two integer arrays `nums1` and `nums2` as input and returns a list containing
 * two lists:
 *  - The first list contains elements present in `nums1` but not in `nums2`.
 *  - The second list contains elements present in `nums2` but not in `nums1`.
 *
 * The function handles empty arrays as edge cases.
 *
 * @param [nums1] The first integer array.
 * @param [nums2] The second integer array.
 * @return A list containing two lists representing the difference between the input arrays.
 */

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    // Initialize result with empty lists
    val result = mutableListOf<List<Int>>(listOf(), listOf())

    // Handle empty arrays as edge cases
    if (nums1.isEmpty() && nums2.isEmpty()) {
        result[0] = emptyList()
        result[1] = emptyList()
        return result
    } else if (nums1.isEmpty()) {
        result[0] = emptyList()
        result[1] = nums2.toList()
        return result
    } else if (nums2.isEmpty()) {
        result[0] = nums1.toList()
        result[1] = emptyList()
        return result
    }

    // Use a HashMap to track element existence (instead of bigNum comparison)
    val differenceMap = HashMap<Int, String>()

    // Add elements from nums1 to the map with a flag "nums1"
    for (i in nums1.indices) {
        differenceMap[nums1[i]] = "nums1"
    }

    // Iterate through nums2:
    //  - If the element exists in the map with flag "nums1", remove it (present in both)
    //  - Otherwise, add the element to the map with flag "nums2" (present in nums2 only)
    for (j in nums2.indices) {
        if (differenceMap.containsKey(nums2[j])) {
            if (differenceMap[nums2[j]] == "nums1")
                differenceMap.remove(nums2[j]) // Element present in both, remove from map
        } else {
            differenceMap[nums2[j]] = "nums2"
        }
    }

    // Separate elements based on their flag in the map and convert them to lists
    result[0] = differenceMap.filter { it.value == "nums1" }.keys.toList() // Elements from nums1 (not in nums2)
    result[1] = differenceMap.filter { it.value == "nums2" }.keys.toList() // Elements from nums2 (not in nums1)

    return result
}