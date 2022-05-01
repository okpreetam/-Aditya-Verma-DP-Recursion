package Dynamic_Programming;

public class Q02_Subset_Sum_Problem_TopDown {

    static Boolean isSubsetSum(int n, int arr[], int sum){

        boolean dp[][] = new boolean[n+1][sum+1];

        //Initializing 0th row/col
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int j=1;j<sum+1;j++){
            dp[0][j] = false;
        }

        //Shortcut for above loop
        //As By default the value is false
        //
        //for(int i=0; i<101; i++) dp[i][0] = true;
        //     sum(i) →
        // n(j)| 1   | 0   | 0   | 0   | 0   |
        //   ↓ | --- | --- | --- | --- | --- |
        //     | 1   | 0   | 0   | 0   | 0   |
        //     | 1   | 0   | 0   | 0   | 0   |
        //     | 1   | 0   | 0   | 0   | 0   |
        //     | 1   | 0   | 0   | 0   | 0   |


        //Recursive to Iterative
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int n = 6;
        int sum = 9;
        int[] arr = { 3, 34, 4, 12, 5, 2 };

        System.out.println(isSubsetSum(n, arr, sum));
    }
}
