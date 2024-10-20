import java.util.*;

public class SpiralOrderMatrix {

    // Function to perform spiral order traversal of a matrix
    public static List<Integer> spiralOrder(int[][] matrix) {

        // Number of rows in the matrix
        int m = matrix.length;

        // Number of columns in the matrix
        int n = matrix[0].length;

        // List to store the spiral order elements
        List<Integer> result = new ArrayList<>();

        // Edge case: if matrix is empty
        if (m == 0)
            return result;

        // 2D array to keep track of visited cells
        boolean[][] seen = new boolean[m][n];

        // Arrays to represent the four possible movement
        // directions: right, down, left, up

        // Change in row index for each direction
        int[] dr = {0, 1, 0, -1};

        // Change in column index for each direction
        int[] dc = {1, 0, -1, 0};

        // Initial position in the matrix
        int r = 0, c = 0;

        // Initial direction index (0 corresponds to 'right')
        int di = 0;

        // Iterate through all elements in the matrix
        for (int i = 0; i < m * n; ++i) {

            // Add current element to result list
            result.add(matrix[r][c]);

            // Mark current cell as visited
            seen[r][c] = true;

            // Calculate the next cell coordinates based on
            // current direction
            int newR = r + dr[di];
            int newC = c + dc[di];

            // Check if the next cell is within bounds and not
            // visited
            if (0 <= newR && newR < m && 0 <= newC && newC < n
                    && !seen[newR][newC]) {

                // Move to the next row
                r = newR;

                // Move to the next column
                c = newC;
            } else {

                // Change direction (turn clockwise)
                di = (di + 1) % 4;

                // Move to the next row according to new
                // direction
                r += dr[di];

                // Move to the next column according to new
                // direction
                c += dc[di];
            }
        }

        // Return the list containing spiral order elements
        return result;
    }

    // Main function
    public static void main(String[] args) {

        // Example matrix initialization
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        // Function call to get the spiral order traversal
        List<Integer> result = spiralOrder(matrix);

        // Print the result elements
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
