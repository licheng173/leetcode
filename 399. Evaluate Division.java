public class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> value = new HashMap<>();
        for(int i = 0; i < equations.length; i++) {
            String[] pair = equations[i];
            if(!pairs.containsKey(pair[0])) {
                pairs.put(pair[0], new ArrayList<>());
                value.put(pair[0], new ArrayList<>());
            }
            if(!pairs.containsKey(pair[1])) {
                pairs.put(pair[1], new ArrayList<>());
                value.put(pair[1], new ArrayList<>());
            }
            pairs.get(pair[0]).add(pair[1]);
            pairs.get(pair[1]).add(pair[0]);
            value.get(pair[0]).add(values[i]);
            value.get(pair[1]).add(1 / values[i]);
        }
        double[] res = new double[queries.length];
        for(int i  = 0; i < queries.length; i++) {
            String[] pair = queries[i];
            res[i] = DFS(pair[0], pair[1], pairs, value, 1, new HashSet<String>());
            if(res[i] == 0.0) {
                res[i] = -1;
            }
        }
        
        return res;
    }
    
    public double DFS(String start, String end, Map<String, List<String>> pairs, Map<String, List<Double>> value, double res, Set<String> set){
        if(set.contains(start)) return 0.0;
        if(!pairs.containsKey(start)) return 0.0;
        if(start.equals(end)) return res;
        set.add(start);
        List<String> follow = pairs.get(start);
        double tmp = 0.0;
        List<Double> followValue = value.get(start);
        for(int i = 0; i < follow.size(); i++) {
            //System.out.println(follow.size());
             tmp = DFS(follow.get(i), end, pairs, value, res * followValue.get(i), set);
            if(tmp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }
}