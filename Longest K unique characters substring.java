import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends

class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> hmap = new HashMap<>();
        int maxlen = -1;
        int i=0, j=0;
        
        while(i<=j && j<n) {
            
            while(j<n && hmap.size()<=k) {
                char ch = s.charAt(j);
                hmap.put(ch, hmap.getOrDefault(ch,0)+1);
                j++;
            }
            
            if(hmap.size()==k)
            {
                //System.out.println("here");
                maxlen = Math.max(j-i, maxlen);
            }
            if(hmap.size() > k) {
                j--;
                hmap.remove(s.charAt(j));
                maxlen = Math.max(j-i, maxlen);
            }
            //System.out.println(s.substring(i,j));
            
            while(i<=j && hmap.size()==k) {
                char ch = s.charAt(i);
                hmap.put(ch, hmap.getOrDefault(ch,0)-1);
                if(hmap.get(ch)==0)
                    hmap.remove(ch);
                i++;
            }
            
        }
        return maxlen;
        
       
    }
}
