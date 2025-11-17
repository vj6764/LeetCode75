class Solution {
    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length()<t.length()){
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for(char c: t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }

        int left=0, right=0;
        int have=0, need=tmap.size();
        int minLeft=0, minRight=0;
        int minLength = Integer.MAX_VALUE;

        Map<Character, Integer> smap = new HashMap<>();
        while(right < s.length()){
            char c = s.charAt(right);

            smap.put(c, smap.getOrDefault(c,0)+1);

            if(tmap.containsKey(c) && smap.get(c).intValue() == tmap.get(c).intValue()){
                have++;
            }
            while(left<=right && have==need){
                c = s.charAt(left);
                int currentWindow = right-left+1;
                if(currentWindow < minLength){
                    minLength = currentWindow;
                    minLeft = left;
                    minRight = right;
                }
                smap.put(c, smap.get(c)-1);

                if(tmap.containsKey(c) && smap.get(c).intValue() < tmap.get(c).intValue()){
                    have--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE? "": s.substring(minLeft, minRight+1);

    }
}
