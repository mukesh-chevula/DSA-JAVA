import java.util.* ;
import java.io.*; 
public class Trie {
    class TrieNode{
        TrieNode[] refs;
        int prefix_count;
        int end_with;
        TrieNode(){
            this.refs=new TrieNode[26];
            this.prefix_count=0;
            this.end_with=0;
        }
    }
    TrieNode root;
    public Trie() {
        // Write your code here.
        root=new TrieNode();
    }

    public void insert(String word) {
        // Write your code here.
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.refs[c-'a']==null){
                cur.refs[c-'a']=new TrieNode();
            }
            cur=cur.refs[c-'a'];
            cur.prefix_count++;
        }
        cur.end_with++;
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.refs[c-'a']==null) return 0;
            cur=cur.refs[c-'a'];
        }
        return cur.end_with;
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.refs[c-'a']==null) return 0;
            cur=cur.refs[c-'a'];
        }
        return cur.prefix_count;
    }

    public void erase(String word) {
        // Write your code here.
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.refs[c-'a']==null) return;
            cur=cur.refs[c-'a'];
            if(cur.prefix_count>0) cur.prefix_count--;
        }
        if(cur.end_with>0) cur.end_with--;
    }

}
