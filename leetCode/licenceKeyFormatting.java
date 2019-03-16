class Solution {
    public String licenseKeyFormatting(String S, int k) {
        
        String DASH = "-";
        String keyWithoutDash = S.replaceAll("-","").toUpperCase();
        int len = keyWithoutDash.length();
        
        if(len==0)
            return "";
        
        StringBuilder builder = new StringBuilder();
        
        int counter = 0;
        
        if(len%k == 0){
            builder.append(keyWithoutDash.substring(0,k));
            counter = k;
        } else{
            builder.append(keyWithoutDash.substring(0,len%k));
            counter = len%k;
        }
        
        while(builder.length() < len+(len/k)-1){
            builder.append(DASH);
            if(counter+k < len)
                builder.append(keyWithoutDash.substring(counter, counter+k));
            else
                builder.append(keyWithoutDash.substring(counter));
            counter += k;
        }
        
        System.out.println(builder.toString());
        return builder.toString();
    }
}