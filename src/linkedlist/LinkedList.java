package linkedlist;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * Created by anandmishra on 18/07/17.
 */
public class LinkedList implements Cloneable {

    Node head;
    int size;

    public void display() {
        if (isCircular()) {
            System.out.print("\nCircular Linked List Can't display");
            return;
        }
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.next == null) {
            System.out.println(head.getData());
            return;
        }
        Node ptr;
        System.out.print(head.getData() + "->");
        ptr = head.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }

    public void insertAtEnd(int i) {
        //Insert at end could be first element
        if (head == null) {
            head = new Node(i, null);
        } else {
            Node newNode = new Node(i, null);
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    //x + 2y + z  =   x + y
    //----------      ------
    //     2x      =     x

    // x = z
    private boolean isCircular() {

        Node slowPtr = head;
        Node fastPtr = head;
        boolean isCircularFlag = false;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr.equals(fastPtr)) {
                isCircularFlag = true;
                System.out.println("The list is Circular");
                break;
            }
        }
        //printLoopStartingPoint
        if (isCircularFlag) {
            Node tempHead = head;
            while (slowPtr.next != null && !tempHead.equals(slowPtr)) {
                tempHead = tempHead.next;
                slowPtr = slowPtr.next;
            }
            System.out.print("Circular List Starting point is: " + tempHead.getData());
        }
        return isCircularFlag;
    }

    //a1 a2 a3 a4 .. an b1 b2 b3 b4 .. bn
    // a1 b1 a2 b2 a3 b3 a4 b4 .. an bn
    public void arrangeLinkedList() {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        //Now slowPtr is at the middle of the list, we will start the replacements
        Node middleElement = slowPtr;
        slowPtr = slowPtr.next;
        //This will break the connection from the middle
        middleElement.next = null;
        fastPtr = head;
        while (fastPtr != null) {
            Node tempFastPtr = fastPtr.next;
            fastPtr.next = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            fastPtr.next = tempFastPtr;
            fastPtr = fastPtr.next;
        }
    }

    public void makeItCircular() {

        Node tempHead = head;
        Node loopPoint = null;
        int secondIndex = 1;
        while (tempHead.next != null) {
            if (secondIndex == 3) {
                loopPoint = tempHead;
            }
            tempHead = tempHead.next;
            secondIndex++;
        }
        tempHead.next = loopPoint;
        System.out.println("Last Value  " + tempHead.getData());
        System.out.println("Loop Value  " + tempHead.next.getData());
    }

    public void insertAtStart(int i) {

        if (head == null) {
            head = new Node(i, null);
        } else {
            Node newNode = new Node(i, null);
            Node temp = head;
            head = newNode;
            newNode.setNextNode(temp);
        }
    }

    public void removeKthFromEnd(int position) {
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < position; i++) {
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                System.out.println("Out of bounds");
            }
        }
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        //Delete p1
        p1.data = p1.next.data;
        p1.next = p1.next.next;
    }

    public boolean isPalindrome() {
        //Odd size list
        //Slow ptr will be at middle
        //Even Size list
        //slowPtr will be at
        // 1 2 3 4 5 4 3 2 1

        // 1 2 3 3 2 1
        Node slowPtr = head;
        Node fastPtr = head;
        Stack<Node> entries = new Stack<>();
        while (fastPtr != null && fastPtr.next != null) {
            entries.push(slowPtr);
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }
        while (slowPtr != null) {
            int value = entries.pop().data;
            if (value != slowPtr.data) {
                return false;
            }
            slowPtr = slowPtr.next;
        }
        return true;
    }

    public void insertAtPos(int num, int pos) {
        Node newNode = new Node(num, null);
        Node current = head;
        Node nextOfCurrent = head.next;
        int index = 1;
        //If pos is 2 we will be inserting at 2nd position same for 3rd position
        //Hence there will be one less traversal
        pos = pos - 1;
        while (index != pos) {
            current = current.next;
            nextOfCurrent = current.next;
            index++;
        }
        current.next = newNode;
        newNode.next = nextOfCurrent;
        size++;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            head = head.next;
            size--;
            return;
        }
        if (size == 1) {
            head = null;
            size--;
            return;
        }
        Node current = head;
        Node nextOfCurrent = head.next;
        int index = 1;
        //If pos is 2 we will be inserting at 2nd position same for 3rd position
        //Hence there will be one less traversal
        pos = pos - 1;
        while (index != pos) {
            current = nextOfCurrent;
            nextOfCurrent = nextOfCurrent.next;
            index++;
        }
        current.next = nextOfCurrent.next;
        size--;
    }

    //Sorted List
    //Linked List = 1->2->3->3->3->6->7->8->9->10->11->12->13
    public void removeDuplicates() {
        int sizeOfList = 0;
        if (head == null || size == 1) {
            return;
        }
        Node current = head;
        Node nextNode = head.next;
        while (current != null && current.next != null) {
            while (nextNode != null && current.data.equals(nextNode.data)) {
                nextNode = nextNode.next;
            }
            current.next = nextNode;
            current = current.next;
            sizeOfList++;
        }
        size = sizeOfList;

    }

    public void reverseALinkedList() {
        Node previousNode = head;
        // 1 2 3 4 5 6
        // 6 5 4 3 2 1

        Node nextNode = previousNode.next; // 2
        previousNode.next = null; // 1- null
        while (nextNode != null) {
            Node tempNext = nextNode.next; // 3
            nextNode.next = previousNode; // 2 - 1
            previousNode = nextNode; // 2
            nextNode = tempNext; // 3
            if (nextNode == null) {
                head = previousNode; // last element
            }
        }
    }

    public class Node implements Comparator<Node> {
        Integer data;
        Node next;

        Node(Integer data, Node n) {
            this.data = data;
            this.next = n;
        }

        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }

        public Integer getData() {
            return data;
        }

        public Node getLink() {
            return next;
        }

        @Override
        public String toString() {
            return this.getData().toString() + "---";
        }

        public int compare(Node o1, Node o2) {
            return o1.data - o2.data;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
