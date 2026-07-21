class PrefixTree {
    private static class TrieNode{
        // 每个TrieNode要有两个属性，分别是数组和boolean
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    // 完了要构造一个root节点
    TrieNode root ;  // 先声明

    public PrefixTree() {
        root = new TrieNode();  // 再构造
        
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char c:word.toCharArray()){
            int index = c-'a'; // 现在就获得了顺序
            if (current.children[index]==null){
                // 说明什么，说明之前这里是空的嘛
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.isEnd=true;
        
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c:word.toCharArray()){
            int index = c-'a';
            if (current.children[index]==null){
                return false;
            }
            current=current.children[index];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c:prefix.toCharArray()){
            int index = c-'a';
            if (current.children[index]==null){
                return false;
            }
            current=current.children[index];
        }
        return true;
    }
}
