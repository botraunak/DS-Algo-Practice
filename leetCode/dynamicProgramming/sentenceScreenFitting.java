class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int i=0,j=0,k=0;
        String sent = String.join(" ", sentence) + " ";
        int n=sent.length();
        while(i<rows){
            j += cols;
            while(j>=0 && sent.charAt(j%n)!=' ') j--;
            j++;
            i++;
        }
        return j/n;
    }
}