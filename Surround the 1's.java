import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

class Solution
{
    public int dir[][] = {{1,1},{0,1},{1,0},{-1,-1},{-1,0},{0,-1},{1,-1},{-1,1}};
    public int  Count(int[][] matrix)
    {
        int m = matrix.length; int n = matrix[0].length;
        int count = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                
                if(matrix[i][j] == 0)
                continue;
                int zcount = 0;
                for(int[] d : dir) {
                    int r = i+d[0];
                    int c = j+d[1];
                    if(r>=0 && r<m && c>=0 && c<n) {
                        if(matrix[r][c]==0)
                        zcount++;
                    }
                }
                if(zcount!=0 && zcount%2==0)
                count++;
                
            }
        }
        return count;
        
    }
}
