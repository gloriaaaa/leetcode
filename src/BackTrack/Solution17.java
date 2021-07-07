package BackTrack;

import java.util.ArrayList;
import java.util.List;

//回溯 电话号码盘
public class Solution17 {
    public static final String [] KEYS={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits==null||digits.length()==0)
        {
            return combinations;
        }
        backtrack(new StringBuilder(),combinations,digits);
        return combinations;
    }
    public void backtrack(StringBuilder s,List<String> combinations,String digits)
    {
        if(s.length()==digits.length())
        {
            combinations.add(s.toString());
        }
        int cur=digits.charAt(s.length())-'0';
        String letters= KEYS[cur];
        for(int i=0;i<letters.length();i++)
        {
            s.append(letters.charAt(i));
            backtrack(s,combinations,digits);
            s.deleteCharAt(s.length()-1);
        }
//        for()
//        s.append()

    }
}
