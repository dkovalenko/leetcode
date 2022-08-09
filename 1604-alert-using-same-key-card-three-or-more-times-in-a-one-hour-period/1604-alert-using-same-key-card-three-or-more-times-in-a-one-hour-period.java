class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
      
      Map<String, SortedSet<Integer>> map = new HashMap<>();
      
      fillMap(keyName, keyTime, map);
      List<String> alerts = getAlertNames(map);
      //System.out.println(map);
      Collections.sort(alerts);
      
      return alerts;
    }
  
  void fillMap(String[] keyName, String[] keyTime, Map<String, SortedSet<Integer>> map) {
    for (int i=0; i < keyName.length; i++) {
      final String name = keyName[i];
      final String time = keyTime[i];
      TreeSet<Integer> newTreeSet = new TreeSet<>(List.of(timeToMinutes(time)));
      map.computeIfAbsent(name, v -> newTreeSet).add(timeToMinutes(time));
    }
  }
  
  Integer timeToMinutes(String time) {
    String[] parts = time.split(":");
    return Integer.parseInt(parts[0])*60 + Integer.parseInt(parts[1]);
  }
  
  List<String> getAlertNames(Map<String, SortedSet<Integer>> map) {
    SortedSet<String> result = new TreeSet<>();
    Deque<Integer> dq = new ArrayDeque<>();
    map.forEach( (k, v) -> {
      dq.clear();
      for (Integer time: v) {
        dq.offer(time);
        if (dq.peekLast() - dq.peek() > 60) {
          dq.poll();
        }
        if (dq.size() >= 3) {
          result.add(k);
        }
      }
    });
    
    return new ArrayList<String>(result);
  }

}