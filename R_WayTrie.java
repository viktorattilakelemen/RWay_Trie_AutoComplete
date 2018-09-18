import java.io.*;
import java.util.*;

/**
Class for the R-way Trie data structure
Inspiration from: https://www.geeksforgeeks.org/trie-insert-and-search/
*/
public class R_WayTrie{
    TrieNode root = new TrieNode();

    /** constructor */
    public R_WayTrie(){}

    /** add word to Trie */
    public void add(String word){
        String[] letters = word.split("");
        TrieNode currNode = root;
        for(int i = 0; i < letters.length; i++){
            char l = letters[i].charAt(0);
            int letter = l;
            int index = letter - 'a';
            // child = the one we need to check
            TrieNode child = currNode.getChildren()[index];
            if(child == null){
                TrieNode newNode = new TrieNode();
                currNode.setChild(newNode, index);
            }
            currNode = currNode.getChildren()[index];
        }
        currNode.setIsWordEnd(word);
    }

    /** @return true if the input word exists in the Trie */
    public boolean search(String word){
        String[] letters = word.split("");
        TrieNode currNode = root;
        TrieNode child = null;
        for(int i = 0; i < letters.length; i++){
            char l = letters[i].charAt(0);
            int letter = l;
            int index = letter - 'a';
            // child = the one we need to check
            child = currNode.getChildren()[index];
            if(child == null){
                return false;
            }

            currNode = currNode.getChildren()[index];
        }
        if(child != null)
            return true;
        return false;
    }

    /** @return an ArrayList of autofills (Strings)*/
    public ArrayList<String> getAutoFill(String word){
        ArrayList<String> autoFills = new ArrayList<String>();

        if(search(word) == false){
            autoFills.add("There are no autofills available for this prefix!");
            return autoFills;
        }
        if(search(word) == true){
            String currAutoFill = "";
            String[] letters = word.split("");
            TrieNode currNode = root;
            for(int i = 0; i < letters.length; i++){
                char l = letters[i].charAt(0);
                int letter = l;
                int index = letter - 'a';
                currAutoFill.concat(letters[i]);
                // child = the one we need to check
                TrieNode child = currNode.getChildren()[index];

                currNode = currNode.getChildren()[index];
            }
            autoFills = autoFillHelper(currNode);

            return autoFills;
        }
        else
            return autoFills;

    }
    public ArrayList<String> autoFillHelper(TrieNode currNode){
        ArrayList<String> result = new ArrayList<String>();
        if(currNode != null){
            if(currNode.getIsWordEnd())
                result.add(currNode.getWordEndWord());
            for(TrieNode child: currNode.getChildren())
                result.addAll(autoFillHelper(child));
        }
        return result;
    }
}
