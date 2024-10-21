class Solution {
    public String longestPalindrome(String s) {

        String longestString = "";
        String oddString;
        String evenString;
        String tempString;

        // if the string is empty or null, return empty string.
        if (s == null || s.length() < 1) {
            return longestString;
        }

        // For every letter in the string, check if there's a palindrome
        // centered on this letter or the position right after it.

        for (int i = 0; i < s.length(); i++) {
            oddString = getLongestPalindromeAboutPoint(s, i, i);
            evenString = getLongestPalindromeAboutPoint(s, i, i + 1);
            tempString = oddString.length() > evenString.length() ? oddString : evenString;

            if (tempString.length() > longestString.length()) {
                longestString = tempString;
            }

        }

        return longestString;

    }

    private String getLongestPalindromeAboutPoint(String str, int p1, int p2) {

        while (p1 >= 0 && p2 < str.length() && str.charAt(p1) == str.charAt(p2)) {
            p1--;
            p2++;
        }

        return str.substring(p1 + 1, p2);

    }

    public static void runTest(String[] testCases, String[] correctSolutions){
        Solution sol = new Solution();
        int numTestCases = testCases.length;

         // Check if both arrays have the same length
         if (numTestCases != correctSolutions.length) {
            System.out.println("Test cases and correct solutions arrays must be of the same length.");
            return;
        }

        int numPassed = 0;
        double percentPassed = 0;


        // Loop through all test cases
        for (int i = 0; i < numTestCases; i++) {
            String result = sol.longestPalindrome(testCases[i]);
            String expected = correctSolutions[i];

            // Compare result with expected solution
            if (result.equals(expected)) {
                System.out.println("Test case " + (i + 1) + " passed. Test Case was: " + testCases[i] + ",  and got: " + result);
                numPassed++;
            } else {
                System.out.println("Test case " + (i + 1) + " failed. Expected: " + expected + ", but got: " + result);
            }
        }

        percentPassed = (numPassed / numTestCases) * 100; 

        System.out.println(percentPassed + "% passed");


    }
    public static void main(String[] args) {
       
        String[] testCases = {
            "babad",
            "cbbd",
            "a",
            "ac",
            "racecar",
            "noon",
            "abcdefghijklmnopqrssrqponm444abcdeeft"
        };

        // Define correct solutions
        String[] correctSolutions = {
            "bab",    // or "aba"
            "bb",
            "a",
            "a",      // or "c"
            "racecar",
            "noon",
            "mnopqrssrqponm"
        };

        runTest(testCases,correctSolutions);
    


    }
}