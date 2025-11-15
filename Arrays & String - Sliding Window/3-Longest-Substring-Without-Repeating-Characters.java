class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0, left=0, right=0;
        HashSet<Character> charSet = new HashSet<>();

        while(right<s.length()){
            if(!charSet.contains(s.charAt(right))){
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right-left+1);
                right++;
            } else{
                charSet.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
