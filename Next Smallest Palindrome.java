import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends
class Solution {

    Vector<Integer> generateNextPalindrome(int nums[], int n) {
        
        Vector<Integer> ans = new Vector<>();
        boolean isAllNine = true;
        for(int in=0; in<n; in++) {
            if(nums[in]!=9)
            {
                isAllNine = false;
                break;
            }
        }
        if(isAllNine) {
            ans.add(1);
            for(int in=1; in<n; in++) {
                ans.add(0);
            }
            ans.add(1);
            return ans;
        }
        
        int mid = n/2;
        
        int i = mid-1; 
        int j = (n%2==0) ? mid : mid+1;
        
        while(i>=0 && j<n) {
            if(nums[i]==nums[j]) {
                i--; j++;
            }
            else break;
        }
        
        boolean leftsmaller = false;
        if(i<0 || nums[i] < nums[j])
            leftsmaller = true; 
        
        while(i>=0) {
            nums[j++] = nums[i--]; 
        }
        if(leftsmaller) {
            
            int carry = 1;
            
            if(n%2==1)
            {nums[mid] += carry;
            carry = nums[mid]/10;
            nums[mid] = nums[mid]%10;}
            
            i= mid-1;
            j = (n%2==0) ? mid : mid+1;
            
            while(i>=0 && carry>0) {
                nums[i] = nums[i] + carry;
                carry = nums[i]/10;
                nums[i] = nums[i]%10;
                nums[j] = nums[i]; i--; j++;
            }
            
        }
        
        
        for(int num : nums){
            ans.add(num);
        }
        
        return ans;
    }
}
