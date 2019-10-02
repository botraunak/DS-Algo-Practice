class Solution {
    int[] mask = {1,7,15,31};
    int[] shift = {7,5,4,3};
    
    public boolean validUtf8(int[] data) {
        for(int i=0; i<data.length; i++){
            int k = -1;
            for(int j=0; j<4; j++){
                if(((data[i]>>shift[j])&(mask[j])) == mask[j]-1){
                    k = j;
                    break;
                }
            }
            if(k==-1) return false;
            if(i+k >= data.length) return false;
            for(int j=1; j<=k; j++){
                if(((data[i+j]>>6)&(3)) != 2) return false;
            }
            i += k;
        }
        return true;
    }
}