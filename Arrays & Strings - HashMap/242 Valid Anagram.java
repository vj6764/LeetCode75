import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> charCountMap = new HashMap<>();

        for(char c: s.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c,0)+1);
        }

        for(char c: t.toCharArray()){
            if(!charCountMap.containsKey(c)){
                return false;
            }
            charCountMap.put(c, charCountMap.get(c)-1);
            if(charCountMap.get(c) <0){
                return false;
            }
        }
        return true;
        
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}
