/*
ʵ��һ�� Trie (ǰ׺��)������?insert,?search, ��?startsWith?������������

ʾ��:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // ���� true
trie.search("app");     // ���� false
trie.startsWith("app"); // ���� true
trie.insert("app");   
trie.search("app");     // ���� true
˵��:

����Լ������е����붼����Сд��ĸ?a-z?���ɵġ�
��֤���������Ϊ�ǿ��ַ�����

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
            if(temp[cs[i]-'a'] == null) temp[cs[i]-'a'] = new Trie(); //ע��
            if(i == cs.length-1) temp[cs[i]-'a'].end = true; //ע��
            temp = temp[cs[i]-'a'].trie; //ע��.tire
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Trie[] temp = trie;
        for(int i=0;i<cs.length;i++){
            if(temp[cs[i]-'a'] == null) return false;
            else if(i == cs.length-1 && temp[cs[i]-'a'].end == true) return true; //ע��
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
