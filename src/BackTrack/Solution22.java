package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public static void main(String[] args) {
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder s= new StringBuilder();
        backtrack(ans,s,n,n);
        return ans;
    }
    public static void backtrack(List<String> ans,StringBuilder s,int nl,int nr)
    {
        if(nl==0 && nr==0)
        {
            System.out.println(s.toString());
            ans.add(s.toString());
            return;
        }
        if(nl>nr) return;
        if(nl>0)
        {
            s.append("(");
            backtrack(ans,s,nl-1,nr);
            s.deleteCharAt(s.length()-1);
        }
        if(nr >0 )
        {
            s.append(")");
            backtrack(ans,s,nl,nr-1);
            s.deleteCharAt(s.length()-1);

        }
//        for(int i=0;i<2;i++)
//        {
//            if(i==0&&nl+1<=n)
//            {
//                s.append("(");
//                backtrack(ans,s,n,nl+1,nr);
//                s.deleteCharAt(s.length()-1);
//            }
//            else if(i==0&&nr+1<=n)
//            {
//                if(nl<=nr) continue;
//                s.append(")");
//                backtrack(ans,s,n,nl,nr+1);
//                s.deleteCharAt(s.length()-1);
//
//            }
//        }
    }
}
