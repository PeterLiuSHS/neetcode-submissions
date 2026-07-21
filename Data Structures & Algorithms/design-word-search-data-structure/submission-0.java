class WordDictionary {
    public static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        return dfs(word, 0, current);
    }

    private boolean dfs(String word, int position, TrieNode current) {
        if (position == word.length()) {
            return current.isEnd;
        }

        char c = word.charAt(position);

        if (c != '.') {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
            return dfs(word, position + 1, current);
        }

        // 接下来处理是.的情况
        if (c == '.') {
            for (TrieNode child : current.children) {
                // current.children得到的是一个数组
                if (child != null) {
                    if (dfs(word, position + 1, child)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
