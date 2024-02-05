/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
 */

import java.util.Stack;
import java.util.Scanner;
import java.util.Collections;

public class CA3_Question1
{

    public static void runSimulation(Integer plateNumber)
    {
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();

        if(plateNumber < 0){
            driveway.pop();
            System.out.println("was popped out");
        }

        if(plateNumber > 0){
            plateNumber = plateNumber * -1;
            driveway.push(plateNumber);
            System.out.println(plateNumber + " was pushed in the driveway");
        }
    }

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter license plate number: ");

        Integer plateNumber = number.nextInt();  // Read user input

        runSimulation(plateNumber);
    }
}
