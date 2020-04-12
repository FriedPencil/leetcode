/*
实现一个 Trie (前缀树)，包含?insert,?search, 和?startsWith?这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");   
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母?a-z?构成的。
保证所有输入均为非空字符串。

*/
class Trie {
    Trie[] trie;
    boolean end;
    /** Initialize your data structure here. */
    public Trie() {
        trie = new Trie[26];
        end = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] cs = word.toCharArray();
        Trie[] temp = trie;
        for(int i=0;i<cs.length;i++){
            if(temp[cs[i]-'a'] == null) temp[cs[i]-'a'] = new Trie(); //注意
            if(i == cs.length-1) temp[cs[i]-'a'].end = true; //注意
            temp = temp[cs[i]-'a'].trie; //注意.tire
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Trie[] temp = trie;
        for(int i=0;i<cs.length;i++){
            if(temp[cs[i]-'a'] == null) return false;
            else if(i == cs.length-1 && temp[cs[i]-'a'].end == true) return true; //注意
            temp = temp[cs[i]-'a'].trie;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        Trie[] temp = trie;
        for(int i=0;i<cs.length;i++){
            if(temp[cs[i]-'a'] == null) return false; 
            temp = temp[cs[i]-'a'].trie;
        }
        return true;
    }
}
