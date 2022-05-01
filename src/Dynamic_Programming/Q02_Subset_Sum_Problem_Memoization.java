package Dynamic_Programming;

public class Q02_Subset_Sum_Problem_Memoization {

    static int[][] dp = new int[101][100001];

    static Boolean isSubsetSum(int n, int arr[], int sum){

        for(int i=0; i<101; i++){
            for(int j=0; j<100001; j++){
                if(j==0){
                    dp[i][j]=0;
                }
                else if(i==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=-1;
                }
            }
        }

        return solve(n, arr, sum) == 1 ;

    }

    static int solve(int n, int arr[], int sum){

        //Base Condition
        if(sum == 0){
            return 1;
        }else if( n == 0 && sum > 0 ){
            return 0;
        }

        if(dp[n][sum] != -1){
            return dp[n][sum];
        }

        //Recursive Memoized code
        if(arr[n-1] <= sum){
            return dp[n][sum] = Math.max(solve(n-1,arr,sum-arr[n-1]), solve(n-1,arr,sum));
        }
        else{
            return dp[n][sum] = solve(n-1,arr,sum);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int sum = 9;
        int[] arr = {3, 34, 4, 12, 5, 2};

        System.out.println(isSubsetSum(n, arr, sum));
    }
}