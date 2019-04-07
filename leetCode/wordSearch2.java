class Solution {
    
    class Trie{
        class Node{
            String word;
            Node[] chars;
            
            public Node(){
                this.word = null;
                this.chars = new Node[26];
            }
        }
        
        private Node root;
        
        public Trie(){
            root = new Node();
        }
        
        public void add(String word){
            Node curr = root;
            for(Character ch: word.toCharArray()){
                if(curr.chars[ch-'a'] == null){
                    curr.chars[ch-'a'] = new Node();
                }
                curr = curr.chars[ch-'a'];                
            }
            curr.word = word;
        }
    }
    
    List<String> res;
    
    public List<String> findWords(char[][] board, String[] words) {
        //making dictionary
        Trie trie = new Trie();
        for(String word: words){
            trie.add(word);
        }
        
        res = new ArrayList<>();
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                wordCheck(board, r, c, trie.root, "");
            }
        }
        
        return res;
    }
    
    public void wordCheck(char[][] board, int x, int y, Trie.Node p, String word){
        if(board[x][y]=='#' || p.chars[board[x][y]-'a'] == null) return;
        
        p = p.chars[board[x][y]-'a'];
        word += board[x][y];
        
        if(p.word != null){
            res.add(word);
            p.word = null;
        }
        
        char temp = board[x][y];
        board[x][y] = '#';
        if(y < board[0].length-1) wordCheck(board, x, y+1, p, word);
        if(y > 0) wordCheck(board, x, y-1, p, word);
        if(x < board.length-1) wordCheck(board, x+1, y, p, word);
        if(x > 0) wordCheck(board, x-1, y, p, word);
        board[x][y] = temp;
    }
}