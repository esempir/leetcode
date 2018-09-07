package google;

/**
 * Created by rh727 on 9/6/18.
 */
public class LongestIncreasingPath {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix.length == 0) return 0;

        int[] mem = new int[matrix[0].length * matrix.length];

        int count = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count = Math.max(count, dfs(matrix, mem, i, j, Integer.MIN_VALUE));
            }
        }

        return count;
    }

    public int dfs(int[][] matrix, int[] mem, int i, int j, int parent) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= parent) {
            return 0;
        }

        int id = matrix[0].length * i + j;
        if (mem[i] != 0) {
            return mem[i];
        }

        int count = 0;

        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];

            count = Math.max(count, dfs(matrix, mem, x, y, matrix[i][j]));
        }
        count++;
        mem[id] = count;

        System.out.println(i + " " + j + " " + count);
        return count;

    }
}
