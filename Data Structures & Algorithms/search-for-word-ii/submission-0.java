class Solution {
    private static class TrieNode{
            TrieNode[] children;
            String word;

            public TrieNode(){
                children = new TrieNode[26];
                word = null;
            }
        }
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        root = new TrieNode();
        for(String word:words){
            insert(root, word);
        }

        for (int row=0; row<board.length; row++){
            for (int col =0; col<board[0].length; col++){
                backtrack(board, row, col, root, result);  // 每个字符都作为最开始的原点，然后试着往后找
            }
        }
        return result;
    }

    private void insert(TrieNode root, String word){
        TrieNode current = root;
        for (char c:word.toCharArray()){
            int index = c-'a';
            if (current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.word = word;
    }

    private void backtrack(char[][] board, int row, int col, TrieNode node, List<String> result){
        
        if (row<0||col<0||row>=board.length||col>=board[0].length){
            return;
        }

        char letter = board[row][col];

        if (letter == '#'){
            return;
        }

        int index = letter - 'a';

        if (node.children[index]==null){
            return; // 结束了，跳出此处backtrack的运行
        }

        if (node.children[index] != null){
            node = node.children[index];

            // 此时的node有可能已经是终点
            if (node.word != null){
                result.add(node.word);
                node.word = null;  // 这里是为了防止，当前这个单词被重复加入
            }

            board[row][col]='#';

            backtrack(board, row+1, col, node, result);
            backtrack(board, row-1, col, node, result);
            backtrack(board, row, col+1, node, result);
            backtrack(board, row, col-1, node, result);

            board[row][col]=letter;
        }
    }
}
























