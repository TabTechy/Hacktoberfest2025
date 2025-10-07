class Solution {
    // Function to calculate the minimum number of candies 
    public int candy(int[] ratings) {

        // Get number of children
        int n = ratings.length;

        // Initially give 1 candy to each child
        int candies = n;

        // Start from second child
        int i = 1;

        while (i < n) {

            // Skip equal ratings
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            // Initialize increasing slope counter
            int peak = 0;

            // Traverse strictly increasing ratings
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                candies += peak;
                i++;
            }

            // Initialize decreasing slope counter
            int valley = 0;

            // Traverse strictly decreasing ratings
            while (i < n && ratings[i] < ratings[i - 1]) {
                valley++;
                candies += valley;
                i++;
            }

            // Remove overlapping candy at the peak
            candies -= Math.min(peak, valley);
        }

        // Return total candies required
        return candies;
    }
}

public class Main {
    public static void main(String[] args) {

        // Input array of ratings
        int[] ratings = {1, 3, 6, 8, 9, 5, 3};

        // Create object of Solution class
        Solution sol = new Solution();

        // Call function and print result
        System.out.println("Minimum candies required: " + sol.candy(ratings));
    }
}
Complexity Analysis
