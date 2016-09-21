public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder newS= new StringBuilder();
        for(String str : strs) {
            newS.append(str.length()).append('/').append(str);
        }
        return newS.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int start = 0;
        while(start < s.length()) {
            int slash = s.indexOf('/', start);
            int len = Integer.valueOf(s.substring(start, slash));
            res.add(s.substring(slash + 1, slash + len + 1));
            start = slash + len + 1;
        }
        return res;
    }
}