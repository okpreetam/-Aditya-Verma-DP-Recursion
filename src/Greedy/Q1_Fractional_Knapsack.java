package Greedy;

import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class Q1_Fractional_Knapsack{

    static double solve(int W, ArrayList<Item> arr, int n){
        SortedMap<Integer,Integer> valuePerWeight = new TreeMap<>();

        for(int i=0; i<n; i++){
            valuePerWeight.put(arr.get(i).value/arr.get(i).weight, i);
        }

        Iterator it = valuePerWeight.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();

            System.out.println(m.getKey() +" "+m.getValue());

        }

        return 0.1;
    }

    public static void main(String[] args) {
        int n = 3;
        int w = 50;
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(60,10));
        items.add(new Item(100,20));
        items.add(new Item(120,30));

        solve(w, items, n);

    }
}