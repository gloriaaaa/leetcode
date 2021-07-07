public class Solution48 {
    //8分58秒
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        if(m==0 && n==0) return;
        for(int i=0;i<m;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++)
        {
            int l=0;
            int r=m-1;
            while(l<r)
            {
                int temp=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=temp;
                l++;r--;
            }
        }


    }
}
