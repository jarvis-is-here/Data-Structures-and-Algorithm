package StringsSubsequence;

import java.util.Arrays;

public class Allpathprint {
    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[board.length][board[0].length];
        AllPathsPrint("", board, 0, 0, path, 1);
    }

    static void AllPathsPrint(String p, boolean[][] Maze, int row, int col, int[][] path, int step) {
        if (row == Maze.length - 1 && col == Maze[0].length - 1) {
            path[row][col] = step;
            for (int[] arr : path){
               System.out.println(Arrays.toString(arr));
           }
            System.out.println(p);
            System.out.println();
            return;
        }

        if (!Maze[row][col]) {
            return;
        }
        // I am considering this block in my path

        Maze[row][col] = false;
        path[row][col] = step;
        if (row < Maze.length - 1) {
            AllPathsPrint(p + 'D', Maze, row + 1, col, path, step+1);
        }
        if (col < Maze[0].length - 1) {
            AllPathsPrint(p + 'R', Maze, row, col + 1,path, step+1);
        }
        if (row > 0) {
            AllPathsPrint(p + 'U', Maze, row - 1, col,path, step+1);
        }
        if (col > 0) {
            AllPathsPrint(p + 'L', Maze, row, col - 1,path, step+1);
        }
        // this line is where the function will be over
        //So before the functions get removed, also remove the changes that were made by that function
        Maze[row][col] = true;
        path[row][col] = 0;
    }
}
