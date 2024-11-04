//TC: O(n*m)
//SC: O(1)
class Solution {
    public int shortestWay(String source, String target) {
        int targetIndex = 0;  // Pointer for target string
        int subsequencesCount = 0;  // Count of subsequences used
        
        // Loop through the target string to match with source subsequences
        while (targetIndex < target.length()) {
            int sourceIndex = 0;  // Pointer for source string
            int prevTargetIndex = targetIndex;  // Store the target index before scanning the current subsequence
            
            // Try to form as much of the target string as possible using the current source subsequence
            while (sourceIndex < source.length() && targetIndex < target.length()) {
                if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
                    targetIndex++;  // Move to the next character in target if there's a match
                }
                sourceIndex++;  // Always move to the next character in source
            }
            
            // If no progress was made in matching the target (targetIndex didn't move), return -1
            if (targetIndex == prevTargetIndex) {
                return -1;
            }
            
            // Increment the subsequences count since we used one subsequence
            subsequencesCount++;
        }
        
        return subsequencesCount;  // Return the number of subsequences needed
    }
}
