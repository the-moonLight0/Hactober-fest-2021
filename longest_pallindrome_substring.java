class Solution {
    
    public String longestPalindrome(String s) {
        int best = 0, end = 0, length = 0;
        // have each point be the center
        for (int i = 0; i < s.length()-1; i++) {
            int lower = i, upper = i+1;
			// checks if two repeat characters are the center (e.g. baab)
            boolean repeat = s.charAt(upper) == s.charAt(lower);
			// if only one character in center, decrease lower
            if (!repeat && lower>0) {
                lower--;
            }
			// check the characters around the center
            while (lower >=0 && upper < s.length()) {
                boolean check = s.charAt(upper) == s.charAt(lower);
                // if repeat, just increment upper
                if (check && repeat) {
                    length = upper-lower;
                    upper++;
                } // if upper == lower, then shift each by 1.
                else if (check && !repeat) {
                    length = upper-lower;
                    lower--;
                    upper++;
                } // if 2 same in pivot
                else if (!check && repeat) {
                    lower--;
                    repeat = false;
                } // if upper != lower, then stop searching
                else break;
            } // update longest substring
            if (length >best) {
               best = length;
                end = upper-1;
            }
            // optimization: if ended because all checked, no need to check any more
            if (upper == s.length()) return s.substring(end-best, end+1);
        }
        return s.substring(end - best, end + 1);
    }
}
