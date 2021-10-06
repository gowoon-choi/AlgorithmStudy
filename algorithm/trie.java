import java.util.*;

class TrieNode {
    private Map<Character, TrieNode> childNodes = new HashMap<>();
    private boolean isLast;

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}

public class Trie {
    private TrieNode rootNode;

    Trie(){
        rootNode = new TrieNode();
    }

    void insert(String word){
        TrieNode node = this.rootNode;
        for(int i=0; i<word.length(); i++) node = node.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        node.setLast(true);
    }

    boolean contains(String word){
        TrieNode node = this.rootNode;
        char cur;
        for(int i=0; i<word.length(); i++){
            cur = word.charAt(i);
            if(!node.getChildNodes().containsKey(cur)) return false;
            node = node.getChildNodes().get(cur);
        }
        return node.isLast();
    }

    void delete(String word){
        delete(this.rootNode, word, 0);
    }
    private void delete(TrieNode node, String word, int index){
        if(index == word.length()){
            if(!node.isLast()) throw new Error("not exist");
            node.setLast(false);
            return;
        }
        char cur = word.charAt(index);
        if(!node.getChildNodes().containsKey(cur)) throw new Error("not exist");
        TrieNode child = node.getChildNodes().get(cur);
        delete(node.getChildNodes().get(cur), word, index+1);
        if(child.getChildNodes().isEmpty()) {
            if(!child.isLast()) node.getChildNodes().remove(cur, child);
        }
    }
}
