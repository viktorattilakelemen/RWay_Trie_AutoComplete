/** node class */
public class TrieNode{
    boolean isWordEnd;
    String wordEndWord;
    TrieNode[] children = new TrieNode[26];

    /** constructor */
    public TrieNode(){
        isWordEnd = false;
        for(int i = 0; i < 26; i++)
            children[i] = null;
    }
    public TrieNode[] getChildren(){
        return this.children;
    }
    public void setChild(TrieNode newChild, int index){
        this.children[index] = newChild;
    }
    public void setIsWordEnd(String word){
        this.isWordEnd = true;
        this.wordEndWord = word;
    }
    public boolean getIsWordEnd(){
        return this.isWordEnd;
    }
    public String getWordEndWord(){
        return this.wordEndWord;
    }
}
