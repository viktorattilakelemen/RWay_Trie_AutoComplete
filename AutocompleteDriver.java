import java.io.*;
import java.util.*;

/** Driver class for Autocomplete program, containing the main method */ 
public class AutocompleteDriver{
    /** main method
    * takes in a txt file and builds an R-way Trie based on import
    * takes in a prefix and prints all corresponding words
    */
    public static void main(String[] args) throws IOException{
        System.out.println("Give me a txt to work from: ");
        Scanner scan = new Scanner(System.in);
        File file = new File(scan.next());
        scan = new Scanner(file);
        R_WayTrie autoCompleteTrie = new R_WayTrie();
        while(scan.hasNextLine()){
            String inp = scan.next();
            boolean isBad = false;
            //check if non-alphanumeric chars are present
            for(int i = 0; i < inp.length(); i++){
                if(Character.isLetter(inp.charAt(i)) != true)
                    isBad = true;

            }
            if(isBad == false)
                autoCompleteTrie.add(inp.toLowerCase());
        }
        System.out.println("Trie has been successfully built!");
        System.out.println("Prefix: ");
        scan = new Scanner(System.in);
        String input = scan.next();
        ArrayList<String> autoFills = autoCompleteTrie.getAutoFill(input);
        // print autofills
        int count = 1;
        for(String autofill: autoFills){
            System.out.println(count + ": " + autofill);
            count++;
        }

    }


}
