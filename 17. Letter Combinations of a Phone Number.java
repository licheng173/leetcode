public class Solution {
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        String[] map={"","","acb","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> stringList = new ArrayList<String>();
        combination(digits, map, length, stringList, 0, "");
        return stringList;
    }
    public void combination(String digits, String[] map, int length, List<String> list, int index, String p) {
        if(length == p.length() && p.length() != 0) {
            list.add(p);
            return;
        }
        if(length == 0) return;
        String current = map[digits.charAt(index) - '0'];
        for(int i = 0; i < current.length(); i++) {
            p += current.charAt(i);
            combination(digits,map, length, list, index+1, p);
            p = p.substring(0, p.length() - 1);
            //System.out.println(p.length());
            
        }
    }
}

//FIFO
  public class Solution {
      public static List<String> letterCombinations(String digits) {
          String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
          List<String> result = new ArrayList<String>();
          if (digits.length() == 0) return result;
          result.add("");
          for (int i = 0; i < digits.length(); i++) {
            result = combine(digitletter[digits.charAt(i) - '0'], result);
          }
          return result;
      }
      public static List<String> combine(String digit, List<String> l) {
          List<String> result = new ArrayList<String>();
          for (int i = 0; i < digit.length(); i++)  {
              for (String x : l) {
                  result.add(x + digit.charAt(i));
              }
          }
          return result;
      }
  }