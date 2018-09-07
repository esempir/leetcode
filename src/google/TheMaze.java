package google;

/**
 * Created by rh727 on 9/7/18.
 */
public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int[][] newMaze = new int[maze.length + 2][maze[0].length + 2];

        for (int i = 0; i < newMaze[0].length; i++) {
            newMaze[0][i] = newMaze[newMaze.length - 1][i] = 1;
        }
        for (int i = 0; i < newMaze.length; i++) {
            newMaze[i][0] = newMaze[i][newMaze[0].length - 1] = 1;
        }

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                newMaze[i + 1][j + 1] = maze[i][j];
            }
        }

        int[] dest = {destination[0] + 1, destination[1] + 1};
        boolean[][] visited = new boolean[newMaze.length][newMaze[0].length];

        return dfs(newMaze, start[0] + 1, start[1] + 1, dest, visited);
    }

    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean dfs(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if (maze[i][j] == 1 || visited[i][j]) {
            return false;
        }

        if (destination[0] == i && destination[1] == j) {
            return true;
        }

        if (visited[destination[0]][destination[1]]) {
            return false;
        }

        for (int k = 0; k < 4; k++) {
            int x = i, y = j;
            while (maze[i][j] != 1) {
                visited[x][y] = true;
                x = x + dir[k][0];
                y = y + dir[k][1];
                if (dfs(maze, x, y, destination, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
