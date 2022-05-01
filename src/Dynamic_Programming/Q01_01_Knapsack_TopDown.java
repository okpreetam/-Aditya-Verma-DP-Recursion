package Dynamic_Programming;

public class Q01_01_Knapsack_TopDown {
    static int[][] dp = new int[4][5];

    static int knapSack(int w, int wt[], int val[], int n)
    {

        //Filling Initial 0th row/col

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        //Recursive to Iterative

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {

                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        int n = 3;
        int w = 4;
        int[] val = {1,2,3};
        int[] wt = {4,5,1};

        System.out.println(knapSack(w, wt, val, n));
    }

}