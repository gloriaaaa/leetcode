package BackTrack;

import java.util.ArrayList;
import java.util.List;

//13分26秒
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if(nums.length==0) return ans;
        for(int i=1;i<=nums.length;i++)
        {
            backtrack(nums,ans,0,i,new ArrayList<>());
        }
        return ans;
    }
    public void backtrack(int [] nums,List<List<Integer>> ans,int pos,int n,List<Integer> aans)
    {
        if(aans.size()==n)
        {
            ans.add(new ArrayList<>(aans));
        }
        if(aans.size()>n) return;
        for(int i=pos;i<nums.length;i++ )
        {
            aans.add(nums[i]);
            backtrack(nums,ans,++pos,n,aans);
            aans.remove(aans.size()-1);
        }
    }
}
