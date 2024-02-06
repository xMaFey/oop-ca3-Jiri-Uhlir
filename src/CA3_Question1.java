/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
 */

import java.util.Stack;
import java.util.Scanner;

public class CA3_Question1
{
     static Stack<Integer> driveway = new Stack<>();
     static Stack<Integer> street = new Stack<>();

    public static void runSimulation(Integer plateNumber)
    {
        if(plateNumber > 0){
            driveway.push(plateNumber);
            System.out.println("Driveway stack: " + driveway);
        }
        else{
            plateNumber = plateNumber * -1;
            if(driveway.contains(plateNumber)){
                while(!driveway.isEmpty()){
                    int num = driveway.pop();
                    if(plateNumber != num){
                        street.push(num);
                    }
                }

                while(!street.isEmpty()){
                    driveway.push(street.pop());
                }
            }

            System.out.println("Driveway stack: " + driveway);
        }
    }

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter plate number: ");
        int plateNumber = number.nextInt();  // Read user input

        while(plateNumber != 0) {
            runSimulation(plateNumber);

            System.out.println("Enter plate number: ");
            plateNumber = number.nextInt();  // Read user input
        }

        System.out.println("Closed - come back tomorrow");
    }
}
