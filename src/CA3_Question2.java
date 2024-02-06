import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
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

    static Stack<Pair> values = new Stack<>();
    private static void fill(int r, int c, int[][] arr)
    {
        int num = 1;
        values.push(new Pair(r,c));

        while(!values.isEmpty()){
            Pair current = values.pop();

            int x = current.getRow();
            int y = current.getColumn();

            arr[x][y] = num++;

            //up
            if(x > 0 && arr[x - 1][y] == 0){
                arr[x - 1][y] = num;
                values.push(new Pair(x - 1, y));
            }

            //down
            if(x < arr.length - 1 && arr[x + 1][y] == 0){
                arr[x + 1][y] = num;
                values.push(new Pair(x + 1, y));
            }

            //left
            if(y > 0 && arr[x][y - 1] == 0){
                arr[x][y - 1] = num;
                values.push(new Pair(x, y - 1));
            }

            //right
            if(y < arr[x].length - 1 && arr[x][y + 1] == 0){
                arr[x][y + 1] = num;
                values.push(new Pair(x, y + 1));
            }
        }
    }

    public static void start()
    {
        int[][] arr = floodFillStart();
        //display(arr);

        fill(0,0, arr);
        display(arr);
    }

    public static void main(String[] args) {
        start();
    }

}


class Pair{
    int row;
    int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

