class Solution {
    public String nextClosestTime(String time) {
        char[] t = time.toCharArray();
        TreeSet<Integer> nums = new TreeSet<>();
        int min = 9;
        for(int i=0; i<5; i++){
            if(i==2) continue;
            nums.add(t[i]-'0');
            min = Math.min(min,t[i]-'0');
        }
        for(int i=4; i>=0; i--){
            if(i==2) continue;
            Integer n = nums.higher(t[i]-'0');
            if(n==null)
                t[i] = (char)(min+'0');
            else if (i==4){
                t[i] = (char)(n+'0');
                break;
            } else if (i==3 && n<6){
                t[i] = (char)(n+'0');
                break;
            } else if (i==1 && t[0]-'0'<2){
                t[i] = (char)(n+'0');
                break;
            } else if (i==1 && n<4){
                t[i] = (char)(n+'0');
                break;
            } else if(i==0 && n<3){
                t[i] = (char)(n+'0');
                break;
            } else
               t[i] = (char)(min+'0'); 
        }
        return new String(t);
    }
}