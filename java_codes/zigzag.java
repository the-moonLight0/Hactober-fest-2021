class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int len = s.length();
        int groupLen = numRows * 2 - 2;
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            int pos = i;
            while (pos < len) {
                str.append(s.charAt(pos));
                if (pos % groupLen == 0 || pos % groupLen == numRows - 1) {//case (0, 6, 12) || (3, 9)
                    pos += groupLen;
                } else if (pos % groupLen < numRows) {//case (1, 2, 7, 8, 13)
                    pos += groupLen - pos % groupLen - i;
                } else if (pos % groupLen >= numRows) {//case (4, 5, 10, 11)
                    pos += groupLen - pos % groupLen + i;
                }
            }
        }
        return str.toString();
    }
}
