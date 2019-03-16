class Solution {
   
   private boolean isOverlap(Interval a, Interval b) {
       return (a.start >= b.start && a.start <= b.end) ||
               (b.start >= a.start && b.start <= a.end) ||
               (a.end >= b.start && a.end <= b.end) ||
               (b.end >= a.start && b.end <= a.end);
   }

   public List<Interval> merge(List<Interval> intervals) {
       for (int i = 0; i < intervals.size(); i++) {
           boolean found = false;
           for (int j = 0; j < intervals.size(); j++) {
               if (i != j) {
                   if (isOverlap(intervals.get(i), intervals.get(j))) {
                       Interval merged = new Interval(Integer.min(intervals.get(i).start, intervals.get(j).start), Integer.max(intervals.get(i).end, intervals.get(j).end));
                       intervals.remove(i);
                       intervals.add(i, merged);
                       intervals.remove(j);
                       found = true;
                   }
               }
           }
           if (found) {
               i--;
           }
       }
       return intervals;
   }
}