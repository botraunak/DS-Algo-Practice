/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        if(isBadVersion(1))
            return 1;
        
        int l = 1, r = n;
        int mid = n>>2;
        
        while(l<r){
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid+1;
            }
            mid = l + (r-l)>>2;
        }
        
        return mid;
        
    }
}