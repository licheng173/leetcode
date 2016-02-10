import java.util.*;

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) 
      {
        boolean[] mark = new boolean[s.length() + 1];
        return word(s,wordDict,mark);
        
      } 
        public boolean word(String s, Set<String> wordDict, boolean[] mark)
        {
        if(s.length() == 0) return false;
        boolean t1,t2;
        
        boolean t3 = false;
        if(mark[s.length()])
        return true;
        for(int i = 1; i < s.length(); i++)
        {
            String tmp = s.substring(0,i);
            t2 = word(tmp, wordDict, mark);
            t1 = wordDict.contains(s.substring(i, s.length()));
            
            t3 = t3 || (t1 && t2);
            
            
        }
        mark[s.length()] = t3 || wordDict.contains(s);
        return mark[s.length()];
        
  //DP bottom up
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) 
      {
       boolean[] mark = new boolean[s.length() + 1];
       mark[0] = true;
       for(int i = 1; i <= s.length(); i++)
       {
           for(int j = 0; j < i; j++)
           {
               if(mark[j] && wordDict.contains(s.substring(j,i)))
                {
                    mark[i] = true;
                }
           }
       }
        
    return mark[s.length()];
    }
    
}

// BFS
//DFS





    }
/*
    public static void main(String[] args)
    {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Set<String> dic = new HashSet<String>();
        dic.add("a"); 
        dic.add("aa");
        dic.add("aaa");
        dic.add("aaaa");
        dic.add("aaaaa");
        dic.add("aaaaaa");
        dic.add("aaaaaaa");
        dic.add("aaaaaaaa");
        dic.add("aaaaaaaaa");
        dic.add("aaaaaaaaaa");
        dic.add("aaaaaaaaaaa");
        if(wordBreak(s, dic))
            System.out.println("sfdgfasdf");
    }
*/


}
