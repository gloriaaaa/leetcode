import java.util.Deque;
import java.util.LinkedList;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] ans = new int[temperatures.length];
        Deque<Integer> stack= new LinkedList<>();
        for(int i=temperatures.length-1;i>=0;i--)
        {
            while(stack.size()!=0&&temperatures[i]>=temperatures[stack.peek()]) stack.pop();
            if(stack.size()==0)
            {
                ans[i]=0;

            }
            else{ans[i]=stack.peek()-i;}
            stack.push(i);

        }
        return ans;

    }
}
