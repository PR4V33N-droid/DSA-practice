package dsa_75_hard.string

/**
 *
 * Question Link: {@link https://leetcode.com/problems/reverse-words-in-a-string/submissions/1254839054/?envType=study-plan-v2&envId=leetcode-75}
 *
 * 151. Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

fun main(){
    val s = "the sky is blue"
    print(reverseString(s))
}

fun reverseString(s: String): String {
    val n = s.length
    if(n <= 1) return s

    var i = 0
    var reversedString = ""
    while(i < n){
        while(i < n && s[i] == ' ') i++
        if(i >= n) break

        var j = i + 1
        while (j < n && s[j] != ' ') {
            j++
        }

        if(reversedString == ""){
            reversedString = s.substring(i, j)
        } else {
            reversedString = s.substring(i, j) + " " + reversedString
        }

        i = j
    }

    return reversedString
}