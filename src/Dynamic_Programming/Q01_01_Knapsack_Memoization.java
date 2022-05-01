package Dynamic_Programming;

class Q01_01_Knapsack_Memoization
{
    static int[][] dp = new int[5][5];

    static int solve(int w, int wt[], int val[], int n){

        if(w == 0 || n == 0){
            return 0;
        }
        if(dp[w][n] != -1){
            return dp[w][n];
        }

        if(wt[n-1] <= w){
            return dp[w][n]=Math.max(val[n-1] + solve(w-wt[n-1], wt, val, n-1),solve(w, wt, val, n-1));
        }
        else{
            return dp[w][n]=solve(w, wt, val, n-1);
        }

    }

    static int knapSack(int w, int wt[], int val[], int n)
    {

        for(int i = 0; i<5 ; i++){
            for(int j = 0; j<5; j++){
                dp[i][j]=-1;
            }
        }

        return solve(w, wt, val, n);
    }

    public static void main(String[] args) {
        int w = 4;
        int n = 3;
        int[] val = {1,2,3};
        int[] wt = {4,5,1};

        System.out.println(knapSack(w, wt, val, n));
    }
}