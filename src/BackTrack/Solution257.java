package BackTrack;

import java.util.ArrayList;
import java.util.List;

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

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<String> ans = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        path.append(root.val);
        backtrack(ans,root,path);
        return ans;

    }
    public static void backtrack(List<String> ans,TreeNode cur,StringBuilder path)
    {
        if(cur.left==null&&cur.right==null)
        {
            ans.add(path.toString());
            return;
        }
        for(int i=0;i<=1;i++)
        {
            if(i==0)
            {
                String p;
                p="->"+cur.left.val;
                path.append(p);
                backtrack(ans,cur.left,path);
                path.delete(path.length()-p.length(),path.length());

            }
            else if(i==1)
            {
                String p;
                p="->"+cur.right.val;
                path.append(p);
                backtrack(ans,cur.right,path);
                path.delete(path.length()-p.length(),path.length());

            }
        }
        return;

    }
}
