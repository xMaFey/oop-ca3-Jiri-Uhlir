import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name:
 *  Class Group:
 */

public class CA3_Question5
{
    public static Queue<String> takeoffQ = new LinkedList<>();
    public static Queue<String> landingQ = new LinkedList<>();

    public static void takeoff(String flightSymbol){
        takeoffQ.offer(flightSymbol);
    }

    public static void land(String flightSymbol){
        landingQ.offer(flightSymbol);
    }

    public static void next(){
        if(!landingQ.isEmpty()){
            System.out.println("Landing: " + landingQ.poll());
        }
        else if(!takeoffQ.isEmpty()){
            System.out.println("Takeoff: " + takeoffQ.poll());
        }
        else{
            System.out.println("No planes in queue");
        }
    }

    public static void main(String[] args)
    {
        Scanner flightReader = new Scanner(System.in);

        while(true){
            System.out.println("Enter takeoff or land + flight symbol (to add to the queue); next (to do one landing or takeoff) or quit (to quit the app): ");
            String input = flightReader.nextLine().trim();

            if(input.startsWith("takeoff")){
                String flightSymbol = input.split(" ")[1];
                takeoff(flightSymbol);
            }
            else if(input.startsWith("land")){
                String flightSymbol = input.split(" ")[1];
                land(flightSymbol);
            }
            else if(input.equals("next")){
                next();
            }
            else if(input.equals("quit")){
                break;
            }
            else{
                System.out.println("Invalid command");
            }
        }

        flightReader.close();
    }

}
