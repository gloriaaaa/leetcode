package BackTrack;

import java.util.ArrayList;
import java.util.List;

//回溯，ip地址
public class Solution93 {
    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(0,s,new StringBuilder(),ans);
        return ans;
    }
    public static void backtrack(int k,String s,StringBuilder ip,List<String> ans)
    {
//        System.out.println(ip);
        if(k==4&&s.length()==0)
        {
            System.out.println(ip);
            ans.add(ip.toString());
            return;
        }
        else if(k==4||s.length()==0)
        {
            return;
        }
        for(int i=0;i<=2&&i<s.length();i++)
        {
            if(i!=0&& s.charAt(0)=='0')
            {
                break;
            }
            String part=s.substring(0,i+1);
            if(Integer.valueOf(part)<=255)
            {
                if(ip.length()!=0)
                {
                    part="."+part;
                }
                ip.append(part);
                backtrack(k+1,s.substring(i+1),ip,ans);
                ip.delete(ip.length()-part.length(),ip.length());
            }

        }

    }
}
