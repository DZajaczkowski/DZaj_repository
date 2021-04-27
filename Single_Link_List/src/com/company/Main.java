package com.company;

public class Main {

    public static void main(String[] args) {

        MyList sList = new MyList();


        sList.appendNode(1);
        sList.appendNode(2);
        sList.appendNode(3);
        sList.appendNode(4);
        sList.prependNode(5);
        sList.insertNode(7, 2);
        sList.replaceNode(0, 0);

        sList.printList();

        sList.isEmpty();
        System.out.println();
        sList.printHead();
        System.out.println();
        sList.printTail();
    }
}    