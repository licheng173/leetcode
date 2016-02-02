public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalRow = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        l.add(0,1);

        if(numRows == 0)
        {
            return pascalRow;
        }

        for(int i = 0; i < numRows; i++){
            pascalRow.add(i,l);
            l = recurseGenerate(l);
        }
    return pascalRow;
    }
    
    public List<Integer> recurseGenerate(List<Integer> nRows){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(0,1);
            int p;
            int len = nRows.size();
            for(int i = 1; i < len; i++){
                 p = nRows.get(i) + nRows.get(i-1);
                 tmp.add(i,p);
            }
            tmp.add(len,1);
            return tmp;
        }
}