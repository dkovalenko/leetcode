import java.util.NavigableMap;

class HitCounter {
  
    NavigableMap<Integer, Integer> nm = new TreeMap<>();

    public HitCounter() {
      nm.put(-1, 0);
    }
    
    public void hit(int timestamp) {
        nm.put(timestamp, nm.lastEntry().getValue() + 1);
    }
    
    public int getHits(int timestamp) {
      int hi = nm.floorEntry(timestamp).getValue();
      int loVal = 0;
      if (timestamp >300) {
        loVal = timestamp - 300;
      }
      int lo = nm.floorEntry(loVal).getValue();
      return hi-lo;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */