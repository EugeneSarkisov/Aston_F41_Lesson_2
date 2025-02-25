package ru.aston.collection_implementation.run;

import ru.aston.collection_implementation.util.MyArrayList;
import ru.aston.collection_implementation.util.MyList;

import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {
        //creating new collection
        MyList<Integer> myArrayList = new MyArrayList<>(10);
        myArrayList.add(6);
        myArrayList.add(4);
        myArrayList.add(8);
        myArrayList.add(2);
        myArrayList.add(1);
        myArrayList.add(4);
        myArrayList.add(3);
        myArrayList.add(8);

        //printing collection in console
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }

        //checking size of collection
        System.out.println("Size of collection: " + myArrayList.size());

        //adding new object into the middle of collection
        myArrayList.add(10, 5);

        //checking size of collection
        System.out.println("Size of collection: " + myArrayList.size());

        //creating second collection
        MyList<Integer> myArrayList2 = new MyArrayList<>(10);
        myArrayList2.add(3);
        myArrayList2.add(7);
        myArrayList2.add(1);
        myArrayList2.add(9);
        myArrayList2.add(5);
        myArrayList2.add(3);
        myArrayList2.add(1);
        myArrayList2.add(10);

        //adding collection into first collection
        myArrayList.addAll(myArrayList2);

        //checking size of collection
        System.out.println("Size of collection: " + myArrayList.size());

        //removing object from collection
        myArrayList.remove(6);

        //checking size of collection
        System.out.println("Size of collection: " + myArrayList.size());

        //bubble sort
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        myArrayList.sort(comparator);
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}
