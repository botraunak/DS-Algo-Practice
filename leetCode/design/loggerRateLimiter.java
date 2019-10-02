class Logger {
    Map<String, Integer> log;

    /** Initialize your data structure here. */
    public Logger() {
        log = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(log.containsKey(message)){
            int t = log.get(message);
            if(t+10>timestamp)
                return false;
        }
        log.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */