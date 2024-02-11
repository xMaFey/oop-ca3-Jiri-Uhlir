import java.util.*;
/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
 */
public class CA3_Question7
{
    /*
   Will repeatedly ask the user to enter the commands in the format
   buy company qty price
   or
   sell company qty price
   or
   quit
    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Map<String, Queue<Block>> sharesMap = new HashMap<>();
        double totalGain = 0.0;

        System.out.println("Commands: buy company quantity price; sell company quantity price; quit");

        String command = "";
        do {
            System.out.print(">");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double price = in.nextDouble();

                // Code to buy shares here
                sharesMap.putIfAbsent(company, new LinkedList<>());
                sharesMap.get(company).offer(new Block(qty, price));
                System.out.println("Bought: " + qty + " shares of " + company + " at $ " + price + " each");
            }

            else if(command.equalsIgnoreCase("sell"))
            {
                String company = in.next();
                int qty = in.nextInt();
                double totalPrice = 0.0;

                // Code to sell shares and calculate profit here
                Queue<Block> shares = sharesMap.get(company);

                if(shares == null || shares.isEmpty()){
                    System.out.println("No shares of " + company + " to sell");
                    continue;
                }

                while(qty > 0 && !shares.isEmpty()){
                    Block block = shares.peek();
                    double sellPrice = in.nextDouble();

                    if(block.quantity <= qty){
                        totalPrice += block.quantity * (sellPrice - block.price);
                        qty -= block.quantity;
                        shares.poll();
                    } else{
                        totalPrice += qty * (sellPrice - block.price);
                        block.quantity -= qty;
                        qty = 0;
                    }
                }

                System.out.println("Sold shares of " + company + ". Gan on this sale: $" + totalPrice);
                totalGain += totalPrice;
            }
        } while(!command.equalsIgnoreCase("quit"));

        System.out.println("Total gain: $" + totalGain);
    }
}
