package BackTrack;

public class Solution79 {
    private final static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int m;
    static int n;
    public static boolean exist(char[][] board, String word) {
        m=board.length;
        n=board[0].length;
        boolean flag=false;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    board[i][j]='#';
                    flag=backtrack(board,word,0,i,j);
                    board[i][j]=word.charAt(0);
                    if(flag)
                    {
                        return flag;
                    }
                }
            }
        }
        return flag;

    }
    public static boolean backtrack(char [][] board,String word,int i,int r,int c)
    {
        if(i==word.length()-1)
        {
            return true;
        }
//        boolean flag=false;
        for(int [] d:direction)
        {
            int x=r+d[0];
            int y=c+d[1];
            if(x<m && y<n &&x>=0 && y>=0&& board[x][y]==word.charAt(i+1))
            {
                System.out.println(x+" "+y);
                System.out.println(board[x][y]);
                board[x][y]='#';
                if(backtrack(board,word,i+1,x,y)) return true;
                board[x][y]=word.charAt(i+1);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        char [][] a= new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char [][] a= new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        boolean ans=exist(a,"SEE");
        System.out.println(ans);
    }
}
