
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
 */
public class CA3_Question6
{
    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {

       Scanner in = new Scanner(System.in);
       Queue<Block> shares = new LinkedList<>();
       double totalGain = 0.0;

        System.out.println("Commands: buy quantity price, sell quantity price, quit");

        String command = "";
            do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                int qty = in.nextInt();
                double price = in.nextDouble();
                shares.offer(new Block(qty, price));
                System.out.println("Bought " + qty + " shares at $" + price + " each");
            }
            else if(command.equalsIgnoreCase("sell"))
            {
                int qty = in.nextInt();
                double totalPrice = 0.0;

                while(qty > 0 && !shares.isEmpty()){
                    Block block = shares.peek();

                    if(block.quantity <= qty){
                        double sellPrice = in.nextDouble();
                        totalPrice += block.quantity * (sellPrice - block.price);
                        qty -= block.quantity;
                        shares.poll();
                    } else{
                        double sellPrice = in.nextDouble();
                        totalPrice += qty * (sellPrice - block.price);
                        block.quantity -= qty;
                        qty = 0;
                    }
                }

                System.out.println("Sold shares. Gain on this sale: $" + totalPrice);
                totalGain += totalPrice;
            }
        } while(!command.equalsIgnoreCase("quit"));

        System.out.println("Total gain: $" + totalGain);
    }
}

class Block{
    int quantity;
    double price;

    public Block(int quantity, double price){
        this.quantity = quantity;
        this.price = price;
    }
}