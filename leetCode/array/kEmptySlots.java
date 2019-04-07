class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        boolean[] bloom = new boolean[flowers.length+1];
        for(int i=0; i<flowers.length; i++){
            int f = flowers[i];
            bloom[f] = true;
            int c = 0;
            if(f-k>0){
                while(c<k){
                    if(bloom[--f]) break;
                    c++;
                }
                if(c==k && bloom[--f])
                    return i+1;
            }
            f = flowers[i];
            c = 0;
            if(f+k<flowers.length){
                while(c<k){
                    if(bloom[++f]) break;
                    c++;
                }
                if(c==k && bloom[++f])
                    return i+1;
            }
        }
        return -1;
    }
}