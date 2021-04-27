package com.company;

class MyList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void appendNode(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void insertNode(int data, int index) {

        Node newNode = head;
        int i = 0;

        while (newNode != null && i < index) {
            newNode = newNode.next;
            i++;
        }
        if (newNode != null) {
            Node temp = new Node(data);
            temp.next = newNode.next;
            newNode.next = temp;
        } else {
            System.out.println();
            System.out.println("No node on that index. Choose different index or use appendNode to add new nodes.");
            System.out.println();
        }


    }

    public void replaceNode(int data, int index) {

        Node newNode = head;
        int i = 0;

        while (newNode != null && i + 1 < index) {
            newNode = newNode.next;
            i++;
        }
        if (newNode != null) {
            newNode.data = data;
        } else {
            System.out.println();
            System.out.println("No node on that index. Choose different index.");
            System.out.println();
        }


    }

    public void prependNode(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

    }

    public boolean isEmpty() {
        System.out.println(head == null);
        return head == null;
    }

    public void printList() {
        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printHead() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Head of list: ");
        System.out.println(head.data);
    }

    public void printTail() {
        Node current = head.next;

        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Tail of list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}