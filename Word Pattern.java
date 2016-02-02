//10ms
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String s[] = str.split("\\s+");
        if(s.length != pattern.length()) return false;
        HashMap<Character, String> hash = new HashMap<Character, String>();
        for(int i = 0; i < pattern.length(); i++)
        {
            
            if(hash.containsKey(pattern.charAt(i)))
            {
                if(!hash.get(pattern.charAt(i)).equals(s[i])) 
                    return false;
                    
            }
            else if(hash.containsValue(s[i]))
            {
                if(!hash.containsKey(pattern.charAt(i)))
                return false;
            }
            else
            hash.put(pattern.charAt(i),s[i]);
        }
        return true;
        
    }
}

//faster nb nb nb
public boolean wordPattern(String pattern, String str) {
    String[] words = str.split(" ");
    if (words.length != pattern.length())
        return false;
    Map index = new HashMap();
    for (Integer i=0; i<words.length; ++i)
        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
            return false;
    return true;
}
