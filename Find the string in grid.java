import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
            if(ans.length==0)
            {
                System.out.println("-1");
            }

        }
    }
}
class Solution
{
    public int[][] searchWord(char[][] grid, String word)
    {
        int m = grid.length;
        int n = grid[0].length;
        
        if(word.length()>m && word.length()>n)
        return new int[0][0];
        
        List<int[]> ans = new ArrayList<>();
        int dir[][] = {{1,1},{-1,-1},{1,0},{-1,0},{0,1},{0,-1},{1,-1},{-1,1}};

        int index = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==word.charAt(index)) {
                    boolean isCell = false;
                    for(int k=0; k<8; k++) {
                        if(checkDir(dir[k], grid, word, index+1, i, j))
                        {
                            isCell = true;
                            break;
                        }
                    }
                    if(isCell) {
                        ans.add(new int[]{i,j});
                    }
                }
            }
        }
        
        int ret[][] = new int[ans.size()][2];
        for(int i=0; i<ret.length; i++) {
            ret[i][0] = ans.get(i)[0];
            ret[i][1] = ans.get(i)[1];
        }
        return ret;
    }
    
    private boolean checkDir(int[] d, char[][] grid, String word, int index, int r, int c) {
        
        int row = d[0] + r;
        int col = d[1] + c;
        
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length)
        return false;
        
        while(!(row<0 || col<0 || row>=grid.length || col>=grid[0].length) && index<word.length() && grid[row][col]==word.charAt(index)) {
            index++;
            row = row + d[0];
            col = col + d[1];
        }
        if(index==word.length())
        return true;
        
        else return false;
        
    }
}
