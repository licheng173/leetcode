public class Solution {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> nRow = new ArrayList<Integer>();
    	int tmp = 0;
    	int flag = 0;
    	nRow.add(0,1);
    	for(int i = 0; i < rowIndex; i++){
    		
    		int len = nRow.size();
    		for(int j = len - 1; j > 0; j--){
    			tmp = nRow.get(j) + nRow.get(j-1);
    			nRow.set(j,tmp);
    			
    		}
    		nRow.add(len,1);
    	}
    	return nRow;      
    }
}


//more simple
public class Solution {
     public List<Integer> getRow(int rowIndex) {
    List<Integer> list = new ArrayList<Integer>();
    if (rowIndex < 0)
        return list;

    for (int i = 0; i < rowIndex + 1; i++) {
        list.add(0, 1);
        for (int j = 1; j < list.size() - 1; j++) {
            list.set(j, list.get(j) + list.get(j + 1));
        }
    }
    return list;
}
}