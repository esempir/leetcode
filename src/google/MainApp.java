package google;

/**
 * Created by rh727 on 7/15/18.
 */
public class MainApp {
    public static void main(String args[]) {
        TheMaze test = new TheMaze();

        int[][] matrix = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0,4};
        int[] dest = {4,4};
        System.out.println(test.hasPath(matrix, start, dest));
    }
}
