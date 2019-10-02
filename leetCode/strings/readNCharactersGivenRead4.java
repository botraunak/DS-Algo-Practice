/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] b = new char[4];
        int counter = 0;
        int check = read4(b);
        while(check > 0 && counter < n){
            for(int i=0; i<check; i++){
                buf[counter++] = b[i];
            }
            check = read4(b);
        }
        if(counter > n) return n;
        return counter;
    }
}