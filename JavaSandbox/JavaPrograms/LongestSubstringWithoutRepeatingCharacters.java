import java.util.HashMap;
import java.util.Map;

class Solution{
	
	public static void main(String args[]) {
		
		String s = "abccabdfgabc";
		Solution sol = new Solution();
		 
		String res = sol.LongestSubstring(s);
		System.out.println(res);
	}
	
	public String LongestSubstring(String s) {
		if (s == null || s.length() == 0) {
            return ""; 
        }
		
		Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int longestSubstrStart = 0; 
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                left = charMap.get(currentChar) + 1;
            }

            charMap.put(currentChar, right);


            int currentWindowLength = right - left + 1;

            if (currentWindowLength > maxLength) {
                maxLength = currentWindowLength;
                longestSubstrStart = left;
            }
        }

        return s.substring(longestSubstrStart, longestSubstrStart + maxLength);
	}
}