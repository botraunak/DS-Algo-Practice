class Solution {
    public void rotate(int[] nums, int k) {
        int counter = 0;
        int currIdx, nextIdx;
        int temp = 0;
    	int temp1 = 0;
        for(int startIdx = 0;counter<nums.length;startIdx++) {
    	
    	    currIdx = startIdx;
    	
    	    temp = 0;
    	    temp1 = 0;
    	    do {
    		    nextIdx = (currIdx+k) % nums.length;
    		
    		    if(currIdx==startIdx) {
    			    temp = nums[nextIdx];
    			    nums[nextIdx] = nums[currIdx];
    		    }
    		    else {
    			    temp1 = temp;
    			    temp = nums[nextIdx];
    			    nums[nextIdx] = temp1;
    		    }
    		    currIdx = (currIdx+k) % nums.length;
    		    counter++;
    		
    	    }while(currIdx!=startIdx);
        }
    }
}