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


}
