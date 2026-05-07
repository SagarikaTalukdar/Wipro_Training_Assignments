package SDET_Day10;

import java.util.ArrayList;

public class Q1_linkedList {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        ArrayList<Integer> list3 = new ArrayList<>();
        /*list3.addAll(list1);
        list3.addAll(list2);

        System.out.println(list3);*/
        
        for(Integer i : list1) {
        	if(!list3.contains(i)) {
        		list3.add(i);
        	}
        }
        for(Integer i : list2) {
        	if(!list3.contains(i)) {
        		list3.add(i);
        	}
        }
        System.out.println(list3);
    }
}
