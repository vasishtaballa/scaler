package com.scaler.academy.homework.oct18;

// Question: https://codeforces.com/problemset/problem/982/B

import com.scaler.academy.assignment.util.ArrayUtils;

import java.util.*;

public class BusAndPassenger {

    static class Item {
        public int data;
        public int index;

        public Item(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }

    class DataComparator implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            return o1.data - o2.data;
        }
    }

    public static void main(String[] args) {
        BusAndPassenger obj = new BusAndPassenger();
        int[] array = {10, 8, 9, 11, 13, 5};
        List<Integer> result = obj.solve((ArrayList<Integer>) ArrayUtils.getListFromArray(array), "010010011101");
        System.out.println(result.toString());
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, String B) {
        ArrayList<Item> items = new ArrayList<>(A.size());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++)
            items.add(new Item(A.get(i), i));
        Collections.sort(items, new DataComparator());
        int type0 = 0;
        Stack<Item> itemStack = new Stack<>();
        for (int i = 0; i < B.length(); i++) {
            char type = B.charAt(i);
            if (type == '0') {
                itemStack.push(items.get(type0));
                result.add(items.get(type0).index + 1);
                type0++;
            } else {
                Item top = itemStack.pop();
                result.add(top.index + 1);
            }
        }
        return result;
    }
}
