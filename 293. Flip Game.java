public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        if(s.length() == 0)
            return new ArrayList<>();
		List<String> res = new ArrayList<>();
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length - 1; i++) {
			if (chs[i] == '+' && chs[i + 1] == '+') {
				chs[i] = '-';
				chs[i + 1] = '-';
				res.add(String.valueOf(chs));
				chs[i] = '+'; // Put back stuffs.
				chs[i + 1] = '+';
			}
		}
		return res;
	}
}