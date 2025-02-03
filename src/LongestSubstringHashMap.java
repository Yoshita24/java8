import java.util.HashSet;

public class LongestSubstringHashMap {
    public static String longestSubstringWithoutRepeating(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0, start = 0;
        String longestSubstring = "";

        for (int right = 0; right < s.length(); right++) {
            // If the character at 'right' is already in the set, move 'left' pointer
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;  // Shrink window from left to remove duplicates
            }
            set.add(s.charAt(right));  // Add current character to the set

            // Update max length and start position if we find a longer substring
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
            }
        }

        // Extract the longest substring
        longestSubstring = s.substring(start, start + maxLength);
        return longestSubstring + " (Length: " + maxLength + ")";
    }

    public static void main(String[] args) {
        String str = "cache";
        System.out.println("Longest substring: " + longestSubstringWithoutRepeating(str));
    }
}
