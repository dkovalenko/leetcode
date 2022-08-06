
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
      Map<String, Integer> mapping = new HashMap<String, Integer>();
      List<String> result = new ArrayList<String>();
      
      fillMap(mapping, cpdomains);
      // System.out.println(mapping);
      calculateResultingCount(mapping, result);
        
      return result;
    }
  
    void fillMap(Map<String, Integer> mapping, String[] cpdomains) {
      for (String entry: cpdomains) {
        String[] countAndDomain = entry.split(" ");
        int count = Integer.parseInt(countAndDomain[0]);
        String[] parts = countAndDomain[1].split("\\.");
        // System.out.println(countAndDomain[1]);
        // System.out.println(Arrays.toString(parts));
        List<String> domains = formDomains(parts);
        for (String domain: domains) {
          if (mapping.get(domain) == null) {
            mapping.put(domain, count);
          } else {
            mapping.compute(domain, (key, val) -> val += count);  
          }
          
        }
      }
    }
  
    List<String> formDomains(String[] parts) {
      String prev = null;
      List<String> result = new ArrayList<String>();
      
      for (int i=parts.length-1; i>=0; i--) {
        List<String> list = new ArrayList();
        if (prev == null) {
          list = Arrays.asList(parts[i]);
        } else {
          list = Arrays.asList(parts[i], prev);  
        }
        
        String currentDomain = String.join(".", list);
        // String currentDomain = "";
        result.add(currentDomain);
        prev = currentDomain;
      }
      return result;
    }
    
  void calculateResultingCount(Map<String, Integer> mapping, List<String> result) {
    for (Map.Entry<String, Integer> entry : mapping.entrySet()) {
      result.add(entry.getValue() + " " + entry.getKey());
    }
  }
}