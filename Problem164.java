//TC: O(n)
//SC: O(1)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Try to make all elements in `tops` or `bottoms` equal to `tops[0]`
        int rotationsA = check(tops[0], tops, bottoms);
        // Try to make all elements in `tops` or `bottoms` equal to `bottoms[0]`
        int rotationsB = check(bottoms[0], tops, bottoms);
        
        // If both are impossible, return -1. Otherwise, return the minimum rotations.
        if (rotationsA == -1 && rotationsB == -1) {
            return -1;
        } else if (rotationsA == -1) {
            return rotationsB;
        } else if (rotationsB == -1) {
            return rotationsA;
        } else {
            return Math.min(rotationsA, rotationsB);
        }
    }
    
    // Helper function to check how many rotations are needed to make all values equal to `x`
    private int check(int x, int[] tops, int[] bottoms) {
        int topRotations = 0;
        int bottomRotations = 0;
        
        // Iterate through all dominoes
        for (int i = 0; i < tops.length; i++) {
            // If `x` is not in either top or bottom at index `i`, return -1 (not possible)
            if (tops[i] != x && bottoms[i] != x) {
                return -1;
            } 
            // If `x` is not in `tops[i]`, increment top rotations
            else if (tops[i] != x) {
                topRotations++;
            }
            // If `x` is not in `bottoms[i]`, increment bottom rotations
            else if (bottoms[i] != x) {
                bottomRotations++;
            }
        }
        
        // Return the minimum rotations needed to make all values equal to `x`
        return Math.min(topRotations, bottomRotations);
    }
}
