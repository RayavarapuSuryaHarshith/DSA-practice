// Leetcode 1092

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        if(str1.contains(str2)){
            return str1;
        }
        if(str2.contains(str1)){
            return str2;
        }
        StringBuilder s = new StringBuilder();
        int i=0;
        int j=0;
        String t = m(str1,str2);
        for(char ch : t.toCharArray()){
            while(str1.charAt(i)!= ch){
                s.append(str1.charAt(i));
                i++;
            }
            while(str2.charAt(j)!= ch){
                s.append(str2.charAt(j));
                j++;
            }
            s.append(ch);
            i++;
            j++;
        }
        while(i < str1.length()){
            s.append(str1.charAt(i));
            i++;
        }
        while(j < str2.length()){
            s.append(str2.charAt(j));
            j++;
        }
        return s.toString();
        
    }
    public String m(String str1,String str2){
        int m = str1.length();
        int n = str2.length();
        int[][]dp = new int[m+1][n+1];
        char[][] c = new char[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    c[i][j] = 'd';
                }
                else if(dp[i][j-1]>dp[i-1][j]){
                    dp[i][j] = dp[i][j-1];
                    c[i][j] = 'l';
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    c[i][j] = 'u';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while(i>0 &&j>0){
            if(c[i][j] == 'u'){
                i--;
            }
            else if(c[i][j] == 'd'){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                j--;
            }
        }
        String s = sb.reverse().toString();
        return s;
    }
}
