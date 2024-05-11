package dsa_75_hard.string

/**
 * Question Link: {@link https://leetcode.com/problems/merge-strings-alternately/description/?source=submission-ac}
 *
 * 1768. Merge Strings Alternately
 *
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 * Return the merged string.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 *
 * Example 2:
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 *
 * Example 3:
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 */

fun main(){
    val str1 = "qwerty"
    val str2 = "abc"

    val mergedString = mergeString(str1, str2)
    print(mergedString)
}

fun mergeString(str1: String, str2: String): String {
//    val l1 = str1.length
//    val l2 = str2.length
//
//    if(l1 == 0) return str2
//    if(l2 == 0) return str1
//
//    val bigStr = max(l1, l2)
//    var mergedStr = ""
//
//    for( i in 0..<bigStr){
//        if(i < l1){
//            mergedStr += str1[i]
//        }
//        if(i < l2) mergedStr += str2[i]
//    }
//
//    return mergedStr

    val merged = StringBuilder()
    var i = 0
    var j = 0

    while (i < str1.length && j < str2.length) {
        merged.append(str1[i])
        merged.append(str2[j])
        i++
        j++
    }

    while (i < str1.length) {
        merged.append(str1[i])
        i++
    }

    while (j < str2.length) {
        merged.append(str2[j])
        j++
    }

    return merged.toString()
}
