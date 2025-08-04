// Leetcode 516

class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int[][]dp = new int[m+1][m+1];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }
        return lcs(dp,s,t,0,0);
    }
    public int lcs(int[][]dp,String a,String b,int i,int j){
        if(i == a.length() || j==b.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = 1+lcs(dp,a,b,i+1,j+1);
        }
        return dp[i][j] = Math.max(lcs(dp,a,b,i+1,j),lcs(dp,a,b,i,j+1));
    }
}
