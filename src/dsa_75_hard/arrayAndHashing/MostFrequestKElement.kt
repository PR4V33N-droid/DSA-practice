package dsa_75_hard.arrayAndHashing

/**
 * Question Link: {@link https://leetcode.com/problems/top-k-frequent-elements/description/}
 *
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 */

fun main(){

    val result = mostKFrequent(intArrayOf(3,0,1,0,1,1,3), 3)
    print(result.contentToString())
}

fun mostKFrequent(nums: IntArray, k: Int): IntArray{

    val setDnp = IntArray(k)
    var i = 0
    val hashMap = HashMap<Int, Int>()

    for(num in nums) {
        if(hashMap.containsKey(num)){
            val value = hashMap[num]
            hashMap[num] = value!! + 1
        } else {
            hashMap[num] = 1
        }
    }

    val temp = hashMap.map { it }.sortedByDescending { it.value }

    for(i in 0 until k){
        setDnp[i] = temp.get(i).key
    }

    return setDnp
}