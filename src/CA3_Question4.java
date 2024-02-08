import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 *  Name: Jiri Uhlir
 *  Class Group: GD2b
 */
public class CA3_Question4 {

    /*
        filename: name of the file to test.
     */

    static Stack<String> tags = new Stack<>();
    public static boolean validate(String fileName) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(fileName));

        while (fileScanner.hasNext()) {
            String token = fileScanner.next();

            if (token.startsWith("<")) {
                //Its a tag
                if (token.startsWith("</")) {
                    //Its a closing tag

                    String openingTag = tags.pop();
                    if (!openingTag.equals(token.substring(2, token.length() - 1))) {
                        return false;
                    }
                } else {
                    tags.push(token.substring(1, token.length() - 1));
                }
            }
        }
        return tags.isEmpty();
    }

    /*
        This function tests the files in the files array to see if
         they are valid.
         tags_valid.txt should return true;
         tags_invalid.txt should output as invalid;
     */
    public static void main(String[] args) throws FileNotFoundException {
        String[] files = {"tags_valid.txt", "tags_invalid.txt"};
        for(String fName: files) {
            System.out.print(fName +": ");
            if (validate(fName)) {
                System.out.println("This file is valid");
            } else {
                System.out.println("This file is invalid");
            }
            tags.clear();
        }
    }
}
