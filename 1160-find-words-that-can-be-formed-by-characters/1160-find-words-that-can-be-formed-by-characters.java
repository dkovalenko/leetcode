class Solution {
    public int countCharacters(String[] words, String chars) {
      int frequency[] = new int[26];
      int sum = 0;
      
      chars.chars().forEach(c -> frequency[c-'a'] += 1);
       
      System.out.println(Arrays.toString(frequency));
      
      for (String word: words) {
        int[] frequencyClone = frequency.clone();
        boolean wordPass = true;
        
        for (char c : word.toCharArray()) {
          frequencyClone[c-'a'] -= 1;
          if (frequencyClone[c-'a'] < 0) {
            wordPass = false;
          }
        }
        if (wordPass) {
          sum += word.length();
        }
      }
      
      return sum;
    }
}