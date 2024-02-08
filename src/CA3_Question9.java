import java.util.Stack;

/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
 */


public class CA3_Question9
{
    public enum DIRECTION {NORTH, SOUTH,EAST,WEST};
    static int[][] maze = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0}
    };

    public static void main(String[] args){
        display(maze);
        solve(0,0, DIRECTION.EAST);
    }

    public static void display(int[][] image){
        for (int x = 0; x < image.length; x++){
            for (int y = 0; y < image[0].length; y++)
            {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public static void solve(int x, int y, DIRECTION dir)
    {
        Stack<int[]> path = new Stack<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        path.push(new int[]{x, y});
        visited[x][y] = true;

        while(!path.isEmpty()){
            int[] current = path.peek();
            int row = current[0];
            int column = current[1];

            if(row == maze.length - 1 && column == maze[0].length - 1){
                System.out.println("Exit found!");
                displayPath(path);
                return;
            }

            boolean moved = false;
            for(DIRECTION direction : DIRECTION.values()){
                int newRow = row, newColumn = column;
                switch(direction){
                    case NORTH:
                        newRow--;
                        break;
                    case SOUTH:
                        newRow++;
                        break;
                    case EAST:
                        newColumn++;
                        break;
                    case WEST:
                        newColumn--;
                        break;
                }

                if(isValidMove(newRow, newColumn, visited)){
                    path.push(new int[]{newRow, newColumn});
                    visited[newRow][newColumn] = true;
                    dir = direction;
                    moved = true;
                    break;
                }
            }

            if(!moved){
                path.pop();
                switch(dir){
                    case NORTH:
                        dir = DIRECTION.SOUTH;
                        break;
                    case SOUTH:
                        dir = DIRECTION.NORTH;
                        break;
                    case EAST:
                        dir = DIRECTION.WEST;
                        break;
                    case WEST:
                        dir = DIRECTION.EAST;
                        break;
                }
            }
        }

        System.out.println("No path found");
    }

    public static boolean isValidMove(int row, int column, boolean[][] visited){
        return row >= 0 && row < maze.length && column >= 0 &&
                column < maze[0].length &&
                maze[row][column] == 0 && !visited[row][column];
    }

    public static void displayPath(Stack<int[]> path){
        System.out.println("Path: ");
        for(int[] point : path){
            System.out.println("(" + point[0] + ", " + point[1] + ")");
        }
    }
}