import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

class Solution {
    public boolean solutionProgram(String s) {



        if (s == null || s.length() < 2){
            return false;
        }


        // ArrayList<Character> myList = new ArrayList<Character>();
        Stack<Character> myStack = new Stack<Character>();
        Map<Character,Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')','(');
        matchingBrackets.put('}','{');
        matchingBrackets.put(']','[');

        char currentChar; 

         
        for(int i = 0; i < s.length(); i++){

            currentChar = s.charAt(i);

            // if open, push it onto stack, go to next char
            // if (currentChar == '(' || currentChar == '{' || currentChar == '['){
            if (matchingBrackets.containsValue(currentChar)){

            
                // myList.add(currentChar);
                myStack.push(currentChar);

            } else {
                // if closed: 
                // if the stack is already empty, return false or if it doesn't match, else, pop

                if (myStack.isEmpty() || myStack.pop()!= matchingBrackets.get(currentChar) ){
                    return false;
                }
            
                //     if matches the top of the stack, pop that off the stack, go to next char

                // if( (currentChar == ')' && myList.get(myList.size()-1) == '(') || 
                // (currentChar == '}' && myList.get(myList.size()-1) == '{') || 
                // (currentChar == ']' && myList.get(myList.size()-1) == '[')){
                // if(matchingBrackets)
                //     myList.remove(myList.size()-1);
                // } else {
                //     return false;
                // }
                   

                    //  if doesn't match the top of the stck, return false
            }
        
        }
        
        // after the last element, if the stack is empty, return true. else false
        if (myStack.isEmpty()){
            return true;
        } else {

            return false;
        }

    }

    public static void runTest(String[] testCases, boolean[] correctSolutions) {
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
            boolean result = sol.solutionProgram(testCases[i]);
            boolean expected = correctSolutions[i];

            // Compare result with expected solution
            if (result == expected) {
                System.out.println(
                        "Test case " + (i + 1) + " passed. Test Case was: " + testCases[i] + ",  and got: " + result);
                numPassed++;
                // System.out.println("numPassed: " + numPassed);
            } else {
                System.out.println("Test case " + (i + 1) + " failed. Expected: " + expected + ", but got: " + result);
            }
        }

        percentPassed = ((double) numPassed / numTestCases) * 100;

        System.out.println(percentPassed + "% passed");

    }

    public static void main(String[] args) {

        String[] testCases = {
                "()",
                "()[]{}",
                "(]",
                "([])",
                "){"

        };

        // Define correct solutions
        boolean[] correctSolutions = {
                true,
                true,
                false,
                true,
                false
        };

        runTest(testCases, correctSolutions);

    }
}