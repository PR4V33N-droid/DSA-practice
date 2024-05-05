package dsa_75_hard.arrayAndHashing

/**
 * Question Link: {@link https://leetcode.com/problems/contains-duplicate/description/}
 *
 *  242. Valid Anagram
 *  Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */

fun main(){
    val result = isAnagram("cat", "car")
    print(result)
}

fun isAnagram(s: String, t: String): Any {

    if(s.length != t.length) return false

//    val letterContainer = HashMap<Char, Int>()
//
//    for(c in s){
//        val count = letterContainer.getOrDefault(c, 0)
//        letterContainer[c] = count + 1
//    }
//
//    for(c in t){
//        val count = letterContainer.getOrDefault(c, 0)
//        letterContainer[c] = count - 1
//    }
//    return letterContainer.filter { it.value != 0 }.isEmpty()

    val freq = IntArray(26)

    for (i in s.indices) {
        freq[s[i] - 'a']++
        freq[t[i] - 'a']--
    }

    return !freq.any { it != 0 }
}
