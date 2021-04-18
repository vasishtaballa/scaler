package com.scaler.academy.homework.oct30;

// Question: https://leetcode.com/problems/grid-illumination/

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.*;

public class GridIllumination {

    static final int[][] directions = {
            {0, 0},
            {0, 1},
            {0, -1},
            {1, 0},
            {1, 1},
            {1, -1},
            {-1, 0},
            {-1, 1},
            {-1, -1}
    };

    public static void main(String[] args) {
        GridIllumination obj = new GridIllumination();
        int[][] matrix1 = {
                {3, 6},
                {3, 7},
                {7, 0},
                {3, 0}
        };
        int[][] matrix2 = {
                {3, 7},
                {1, 0},
                {5, 3},
                {7, 2},
                {4, 6},
                {2, 2},
                {2, 1},
                {3, 1},
                {2, 7},
                {1, 5},
                {6, 2}
        };
        ArrayList<Integer> result = obj.solve(8,
                (ArrayList<ArrayList<Integer>>) ArrayUtils.getListFromMatrix(matrix1),
                (ArrayList<ArrayList<Integer>>) ArrayUtils.getListFromMatrix(matrix2));
        System.out.println(result.toString());
    }

    /*
    The idea is to maintain 4 maps each one for the following
    1. To store how many lamps are there in each row
    2. To store how many lamps are there in each col
    3. To store how many lamps are there in each primary diagonal (right to left)
    4. To store how many lamps are there in each secondary diagonal (left to right)

    One Set to indicate whether lamp is on or off in each cell of grid. This is used to turn off the lamp from the given position and also update
    other maps with corresponding lamps.
    Identifying rows and cols lamps are straight forward. Map each x co-ordinates with value in map for rows and y co-ordinates with value in map for cols
    But identifying the same for both diagonals is tricky. If we observe carefully below are the conditions for each diagonal in a grid
    Primary Diagonal (right to left): Difference between x and y co-ordinates is same for all cells in each primary diagonal.
    Example: (1,0), (2, 1), (3, 2)... (So, let's store this difference as key)
    Secondary Diagonal (left to right): Sum of x and y co-ordinates is same for all cells in each secondary diagonal.
    Example: (4,0), (3, 1), (2, 2)... (So, let's store this sum as key)

    Each element in a set represents one cell in a grid. But how do we represent each cell in grid? Two ways are there.
    1. Represent them in (x, y)
    2. Represent them in 0, 1, 2, 3, 4, 5, 6, 7 etc. How do we conclude to this number from given (x, y) co-ordinates? Below is the formula:
    (N * x) + y
    Example: For cell (2, 3) in a 4 * 4 grid, it's index would be (4 * 2) + 3 = 11
     */
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, ArrayList<ArrayList<Integer>> C) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> rowToCountMap = new HashMap<>();
        Map<Integer, Integer> colToCountMap = new HashMap<>();
        Map<Integer, Integer> primaryDiagonalToCountMap = new HashMap<>();
        Map<Integer, Integer> secondaryDiagonalToCountMap = new HashMap<>();
        Set<Integer> lamps = new HashSet<>(B.size());
        // Iterate lamps and update all our maps and set
        for (int i = 0; i < B.size(); i++) {
            int lampX = B.get(i).get(0);
            int lampY = B.get(i).get(1);
            // Add this lamp position in lamps set
            boolean added = lamps.add(A * lampX + lampY);
            // Update maps only if this lamp is already not considered
            if (added) {
                rowToCountMap.put(lampX, rowToCountMap.getOrDefault(lampX, 0) + 1);
                colToCountMap.put(lampY, colToCountMap.getOrDefault(lampY, 0) + 1);
                primaryDiagonalToCountMap.put((lampX - lampY), primaryDiagonalToCountMap.getOrDefault((lampX - lampY), 0) + 1);
                secondaryDiagonalToCountMap.put((lampX + lampY), secondaryDiagonalToCountMap.getOrDefault((lampX + lampY), 0) + 1);
            }
        }
        // Iterate each query and populate result. Alongside update the maps and set (turning off the lamps)
        for (int i = 0; i < C.size(); i++) {
            int queryX = C.get(i).get(0);
            int queryY = C.get(i).get(1);
            if (rowToCountMap.getOrDefault(queryX, 0) > 0 ||
                    colToCountMap.getOrDefault(queryY, 0) > 0 ||
                    primaryDiagonalToCountMap.getOrDefault(queryX - queryY, 0) > 0 ||
                    secondaryDiagonalToCountMap.getOrDefault((queryX + queryY), 0) > 0)
                result.add(1);
            else
                result.add(0);
            // Check in all 8 directions and turn off lamps if required
            for (int j = 0; j < directions.length; j++) {
                int x = queryX + directions[j][0];
                int y = queryY + directions[j][1];
                // If the lamp in that cell is already on, then turn off the same. Update lamps and set
                if (lamps.contains(A * x + y) && isValidCell(x, y, A)) {
                    rowToCountMap.put(x, rowToCountMap.getOrDefault(x, 1) - 1);
                    colToCountMap.put(y, colToCountMap.getOrDefault(y, 1) - 1);
                    primaryDiagonalToCountMap.put(x - y, primaryDiagonalToCountMap.getOrDefault(x - y, 1) - 1);
                    secondaryDiagonalToCountMap.put(x + y, secondaryDiagonalToCountMap.getOrDefault(x + y, 1) - 1);
                    lamps.remove(A * x + y);
                }
            }
        }
        return result;
    }

    /*
    This method is required because, there might be few cases where the current cell which needs to be turned off might go outside boundaries
    of grid. This couldn't be guaranteed by just calculating A * x + y.
     */
    private boolean isValidCell(int x, int y, int size) {
        return x < size && y < size;
    }

}
