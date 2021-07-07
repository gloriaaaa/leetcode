public class Solution238 {
    //7分26秒
    public int[] productExceptSelf(int[] nums) {
        int []before= new int [nums.length];
        int []after=new int [nums.length];
        before[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            before[i]=nums[i-1]*before[i-1];
        }
        after[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            after[i]=nums[i+1]*after[i+1];
        }
        int [] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            ans[i]=before[i]*after[i];
        }
        return  ans;


    }
}
