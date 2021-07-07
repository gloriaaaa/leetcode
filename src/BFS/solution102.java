package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

//10分07秒
public class solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> aans = new ArrayList<>();
            while(size-->0)
            {
                TreeNode cur= queue.poll();
                aans.add(cur.val);
                if(cur.left!=null)queue.add(cur.left);
                if(cur.right!=null)queue.add(cur.right);

            }
            ans.add(new LinkedList<>(aans));
//            System.out.println(cur.val);
        }
        return ans;

    }
}
