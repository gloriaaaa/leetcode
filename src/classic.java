import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class classic {
    //141 环形链表
    public boolean hasCycle(ListNode head) {
        ListNode fast =head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null&&slow!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++)
//        {
//            map.put(target-nums[i],i);
//        }
//        System.out.println(map.toString());
//        int [] ans = new int [2];
//        for(int i=0;i<nums.length;i++)
//        {
////            int pos=map.get(nums[i]);
//            if(map.get(nums[i])!=null&&map.get(nums[i])!=i)
//            {
//                ans[0]=i;
//                ans[1]=map.get(nums[i]);
//                return ans;
//            }
//        }
//        return ans;
//    }
    //1两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
    //53 最大子序和
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int [] dp= new int [nums.length];
        dp[0]=nums[0];
        int maxsum = dp[0];
        for(int i=1;i<dp.length;i++)
        {
            //    dp[i]=nums[i];
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            maxsum=Math.max(maxsum,dp[i]);
        }
        return maxsum;

    }
    //94 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        visit(root,ans);
        return ans;
    }
    public void visit(TreeNode root,List<Integer> ans){
        if(root==null) return;
        visit(root.left,ans);
        ans.add(root.val);
        visit(root.right,ans);

    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    //34在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            {
                int lb=mid;
                while(lb>=0&&nums[lb]==target){lb--;}
                int rb=mid;
                while(rb<=nums.length-1&&nums[rb]==target){rb++;}
                return new int []{lb+1,rb-1};
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return new int[]{-1,-1};

    }
    //18分57秒
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        if(strs.length==1) return strs[0];
        StringBuilder sb = new StringBuilder();
        boolean end=false;
        int pos=0;
        while(!end)
        {
            if(pos>=strs[0].length())
            {
                break;
            }
            sb.append(strs[0].charAt(pos));
            for(int i=1;i<strs.length;i++){
                // System.out.println(pos+" "+sb.charAt(pos)+" "+strs[i].charAt(pos));
                if(pos>=strs[i].length())
                {
                    sb.deleteCharAt(pos);
                    end=true;
                    break;
                }
                if(strs[i].charAt(pos)!=sb.charAt(pos))
                {
                    sb.deleteCharAt(pos);
                    end=true;
                    break;
                }
            }
            // System.out.println("????");
            pos++;

        }
        return sb.toString();
    }
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }

//    作者：guanpengchn
//    链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    //136
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        while(i<nums.length&&j<nums.length)
        {
            if(nums[i]!=nums[j]) break;
            i=i+2;
            j=j+2;
        }
        return nums[i];
    }
    class Solution {
        public int singleNumber(int[] nums) {
            int single = 0;
            for (int num : nums) {
                single ^= num;
            }
            return single;
        }
    }

//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //110 平衡二叉树 10分17秒
    public boolean isBalanced(TreeNode root) {
//        if(root==null) return true;
//        int h1=helper(root.left);
//        int h2=helper(root.right);
//        if(h1==-1||h2==-1||Math.abs(h1-h2)>1) return false;
//        else return true;
        if(helper(root)==-1) return false;
        else return true;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int h1=helper(root.left);
        int h2=helper(root.right);
        if(h1==-1||h2==-1||Math.abs(h1-h2)>1) return -1;
        else return Math.max(h1,h2)+1;
    }
    //3. 无重复字符的最长子串 20分53秒
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int l=0;int r=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxwin=0;
        int win=0;
        while(r<s.length()){
            if(!map.containsKey(s.charAt(r)))
            {
                map.put(s.charAt(r), r);
                win++;
                maxwin=Math.max(maxwin,win);
                r++;
            }
            else{
                maxwin=Math.max(maxwin,win);
                // System.out.println(l+" "+r+" "+maxwin);
                // System.out.println(map.toString());
                map.remove(s.charAt(l));
                l++;
                win=r-l;
            }
        }
        return maxwin;


    }



}
