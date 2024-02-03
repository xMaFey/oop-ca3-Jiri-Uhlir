import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;

/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {
        ArrayDeque<Pair> stack = new ArrayDeque();
        int num = 1;

        stack.push(new Pair(r, c));

        while(!stack.isEmpty()){
            Pair current = stack.pop();

            int x = current.getX();
            int y = current.getY();

            arr[x][y] = num++;

            if(x > 0 && arr[x - 1][y] == 0){
                stack.push(new Pair(x, y));
            }
            if(x < 9 && arr[x + 1][y] == 0){
                stack.push(new Pair(x, y));
            }
            if(y > 0 && arr[x][y - 1] == 0){
                stack.push(new Pair(x, y));
            }
            if(y < 9 && arr[x][y + 1] == 0){
                stack.push(new Pair(x, y));
            }
        }
    }

    public static void start()
    {
       int[][] arr = floodFillStart();
       display(arr);
       fill(2, 3, arr);
       display(arr);

    }
    public static void main(String[] args) {
        start();
        display(floodFillStart());
    }

}

class Pair{
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

