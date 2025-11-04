class Solution {
    public boolean isSubsequence(String s, String t) {
        int itr1=0, itr2=0;

        while(itr1<s.length() && itr2<t.length()){
            if(s.charAt(itr1)==t.charAt(itr2)){
                itr1++;
            }
            itr2++;
        }
        return itr1==s.length();
    }
}
