
public class Solution55 {
    public boolean canJump(int[] nums) {
        int maxpos=0;
        for(int i=0;i<nums.length;i++)
        {
            if(maxpos>=i)
            {
                maxpos=Math.max(i+nums[i],maxpos);
                if(maxpos>=nums.length-1) return true;

            }

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(111);
    }
}
