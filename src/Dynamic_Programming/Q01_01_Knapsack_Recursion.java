package Dynamic_Programming;

class Q01_01_Knapsack_Recursion
{

    static int knapSack(int w, int wt[], int val[], int n){

        if(w == 0 || n == 0){
            return 0;
        }

        if(wt[n-1] <= w){
            return Math.max(val[n-1] + knapSack(w-wt[n-1], wt, val, n-1),knapSack(w, wt, val, n-1));
        }
        else{
            return knapSack(w, wt, val, n-1);
        }

    }

    public static void main(String[] args) {
        int w = 4;
        int n = 3;
        int[] val = {1,2,3};
        int[] wt = {4,5,1};

        System.out.println(knapSack(w, wt, val, n));
    }
}