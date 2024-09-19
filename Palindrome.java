class Solution {
    public boolean isPalindrome(int x) {
        // Handle negative numbers which can't be palindromes
        if (x < 0) {
            return false;
        }

        int count = 0;
        int temp = x; // Temporary variable to count digits without modifying x

        // Count the number of digits
        while (temp > 0) {
            temp = temp / 10;  // Divide temp to remove last digit
            count++;           // Increment the digit count
        }

        // Palindrome check
        while (count > 1) { // Continue as long as there are digits to compare
            // Get the first digit
            int firstNum = x / (int)Math.pow(10, count - 1);
            // Get the last digit
            int lastNum = x % 10;
            
            if (firstNum != lastNum) {
                return false;
            }
            
            // Remove the first and last digits
            x = (x % (int)Math.pow(10, count - 1)) / 10;
            
            // Reduce count by 2 
            count -= 2;
        }

        return true;
    }
}