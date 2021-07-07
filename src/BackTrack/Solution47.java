package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//19分14秒
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
//        if(nums.length=)
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> aans= new ArrayList<>();
        boolean [] visited = new boolean[nums.length];
        backtrack(ans,nums,visited,aans);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,int[] nums,boolean[] visited,List<Integer> aans)
    {
        if(aans.size()==nums.length)
        {
//            ans.add(aans);
            ans.add(new ArrayList<>(aans));//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
//            if(i!=0&&nums[i]==nums[i-1])continue;
            if(i!=0&&nums[i]==nums[i-1]&& !visited[i - 1])continue;//!!!!!!!!!!!!!!!!!!!!!!
            if(!visited[i])
            {
                aans.add(nums[i]);
                visited[i]=true;
                backtrack(ans,nums,visited,aans);
                aans.remove(aans.size()-1);
                visited[i]=false;
            }

        }
    }
}
