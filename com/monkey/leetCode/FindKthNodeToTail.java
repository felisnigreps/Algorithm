package com.monkey.leetCode;


public class FindKthNodeToTail {
    private static class Node<V> {
        V value;
        Node<V> next;

        public Node() {
        }

        public Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }

        public String toString() {

            return this.value.toString();
        }
    }

    public Node find(Node head, int k) {
        //遍历两次
        if (head == null || k <= 0) {
            return null;
        }
        Node p = head;
        Node q = head;
        for (int i = 0; i < k - 1; i++) {
            if (p.next != null) {
                p = p.next;
            } else {
                return null;
            }
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    public static void main(String[] args) {
        Node head = new Node();
        Node second = new Node();
        Node third = new Node();
        Node forth = new Node();
        head.next = second;
        second.next = third;
        third.next = forth;
        head.value = 1;
        second.value = 2;
        third.value = 3;
        forth.value = 4;
        FindKthNodeToTail test = new FindKthNodeToTail();
        Node result = test.find(head, 1);
        System.out.println(result);
    }

}
