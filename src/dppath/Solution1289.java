package dppath;

public class Solution1289 {
    class Solution {
        //其实只需要枚举最小值和次小值，不可能俩都不对
        // public int minFallingPathSum(int[][] arr) {
        //     int n=arr.length;
        //     int [][] dp = new int[n][n];
        //     for(int i=0;i<n;i++)
        //     {
        //         dp[0][i]=arr[0][i];
        //     }
        //     for(int i=1;i<n;i++)
        //     {
        //         for(int j=0;j<n;j++)
        //         {
        //             dp[i][j]=Integer.MAX_VALUE;
        //             int val=arr[i][j];
        //             for(int p=0;p<n;p++){
        //                 if(j!=p){
        //                     dp[i][j]=Math.min(dp[i][j],dp[i-1][p]+val);
        //                 }
        //             }
        //         }
        //     }
        //     int ans=Integer.MAX_VALUE;
        //     for(int i=0;i<n;i++)
        //     {
        //         ans=Math.min(ans,dp[n-1][i]);
        //     }
        //     return ans;
        // }
        int MAX = Integer.MAX_VALUE;
        public int minFallingPathSum(int[][] arr) {
            int n = arr.length;
            int[][] f = new int[n][n];

            // i1 代表最小值列下标，i2 代表次小值列下标
            int i1 = -1, i2 = -1;

            // 先转移第一行
            for (int i = 0; i < n; i++) {

                // 更新动规值
                int val = arr[0][i];
                f[0][i] = val;

                // 更新 i1 和 i2
                if (val < (i1 == -1 ? MAX : f[0][i1])) {
                    i2 = i1;
                    i1 = i;
                } else if (val < (i2 == -1 ? MAX : f[0][i2])) {
                    i2 = i;
                }
            }

            // 再转移剩余行
            for (int i = 1; i < n; i++) {

                // 当前转移第 i 行，使用临时变量保存转移过程中的「最小值列下标」&「次小值列下标」
                int ti1 = -1, ti2 = -1;

                for (int j = 0; j < n; j++) {
                    f[i][j] = MAX;
                    int val = arr[i][j];

                    // 更新动规值
                    // 可以选择「最小值」的列选择「最小值」
                    if (j != i1) {
                        f[i][j] = f[i - 1][i1] + val;

                        // 不能选择「最小值」的列选择「次小值」
                    } else {
                        f[i][j] = f[i - 1][i2] + val;
                    }

                    // 更新 ti1 和 ti2
                    if (f[i][j] < (ti1 == -1 ? MAX : f[i][ti1])) {
                        ti2 = ti1;
                        ti1 = j;
                    } else if (f[i][j] < (ti2 == -1 ? MAX : f[i][ti2])) {
                        ti2 = j;
                    }
                }

                // 使用临时变量更新 i1 和 i2
                i1 = ti1; i2 = ti2;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, f[n-1][i]);
            }
            return ans;
        }
    }
}
