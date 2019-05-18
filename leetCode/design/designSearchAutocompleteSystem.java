class AutocompleteSystem {
    
    class TrieNode {
        TrieNode[] nodes;
        TreeSet<SentenceCount> sentences;
        
        public TrieNode() {
            nodes = new TrieNode[27];
            sentences = new TreeSet<>(Comparator.comparing(SentenceCount::count).reversed().thenComparing(SentenceCount::sentence));
        }
    }
    
    class SentenceCount {
        String sentence;
        int count;
        
        public SentenceCount(String str, int count){
            sentence = str;
            this.count = count;
        }
        
        public String sentence(){
            return sentence;
        }
        
        public int count(){
            return count;
        }
    }
    
    TrieNode root, cur;
    StringBuilder sb;
    Map<String, Integer> countMap;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();
        countMap = new HashMap<>();
        
        for(int i=0; i<times.length; i++){
            countMap.put(sentences[i], times[i]);
            addSentenceToTrie(sentences[i], times[i]);
        }
    }
    
    public void addSentenceToTrie(String str, int count){
        TrieNode t = root;
        int i;
        for(char c: str.toCharArray()){
            i = c-'a';
            if(c==' ') i = 26;
            if(t.nodes[i] == null)
                t.nodes[i] = new TrieNode();
            t = t.nodes[i];
            if(countMap.containsKey(str))
                t.sentences.remove(new SentenceCount(str, count-1));
            t.sentences.add(new SentenceCount(str, count));
        }
    }
    
    public void addSentence(){
        String sent = this.sb.toString();
        sb.setLength(0);
        countMap.put(sent, countMap.getOrDefault(sent, 0)+1);
        addSentenceToTrie(sent, countMap.get(sent));
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if(c=='#'){
            addSentence();
            cur = root;
            return res;
        }
        sb.append(c);
        int i = c-'a';
        if(c==' ') i = 26;
        if(cur != null)
            cur = cur.nodes[i];
        if(cur != null){
            for(SentenceCount sc: cur.sentences){
                res.add(sc.sentence());
                if(res.size()==3) break;
            }
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */