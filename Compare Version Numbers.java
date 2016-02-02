public class Solution {
    public int compareVersion(String version1, String version2) {
        int index1,index2;
        int c1, c2;
       while(true)
       {
           index1 = version1.indexOf(".");
           index2 = version2.indexOf(".");
           if(index1 >= 1) c1 = Integer.valueOf(version1.substring(0,index1));
           else c1 = Integer.valueOf(version1);
           if(index2 >= 1) c2 = Integer.valueOf(version2.substring(0,index2));
           else c2 = Integer.valueOf(version2);
           if(c1 > c2) return 1;
           if(c1 < c2) return -1;
           if(c1 == c2) 
           {
               if(index1 < 0 && index2 >-1) version1 = version1 + ".0";
               else if(index1 > -1 && index2 < 0) version2 = version2 + ".0";
               else if(index1 < 0 && index2 < 0) return 0;
               else 
               {
                   version1 = version1.substring(index1 + 1);
                   version2 = version2.substring(index2 + 1);
               }
           }
        }
    }
}

//use split
public class Solution {
public int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");

    int length = Math.max(levels1.length, levels2.length);
    for (int i=0; i<length; i++) {
        Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
        Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
        int compare = v1.compareTo(v2);
        if (compare != 0) {
            return compare;
        }
    }
    return 0;
  }
}