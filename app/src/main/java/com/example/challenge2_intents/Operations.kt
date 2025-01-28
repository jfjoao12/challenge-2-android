package com.example.challenge2_intents

/**
 * Class Operations, defines all methods to be used in the app.
 */
class Operations {
    /**
     * Method to validate if a string is a palindrome
     * @param str the string to be validated
     */
    fun checkForPalindrome (str: String):Boolean {

        val flag: Boolean = str == str.reversed()
        return flag
    }
    /**
     * Method to validate if a string is a pangram
     * @param str the string to be validated
     */
    fun checkForPangram (str: String): Boolean {
        var flag = false

        for (char in ('a'..'z')) {
            flag = char in str.lowercase()
        }
        return flag
    }
}