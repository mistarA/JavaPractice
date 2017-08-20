package linkedlist;

import java.util.ArrayList;
import java.util.List;

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

    private boolean isCircular() {

        Node slowPtr = head;
        Node fastPtr = head;
        boolean isCircularFlag = false;
        while (fastPtr != null && fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr.equals(fastPtr)) {
                isCircularFlag = true;
                System.out.println("The list is Circular");
                break;
            }
        }
        //x + 2y + z  =   x + y
        //----------      ------
        //     2x      =     x

        // x = z
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
        //First lets go to the middle of the linked list so that we can start replacing the characters
        //We are going to use the Runner Technique over here
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
        List<Node> elements = new ArrayList<>();
        while (fastPtr != null) {
            Node tempFastPtr = fastPtr.next;
            fastPtr.next = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            fastPtr.next = tempFastPtr;
            fastPtr = fastPtr.next;
        }
        System.out.print(elements);
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
        size++;
    }

    public void removeKthFromEnd(int position) {
        Node temp1 = head;
        Node temp2 = head;
        boolean flagSizeExceeded = false;
        for (int i = 2; i <= position; i++) {
            if (temp2.next != null) {
                temp2 = temp2.next;
            } else {
                flagSizeExceeded = true;
                break;
            }
        }
        if (flagSizeExceeded) {
            System.out.print("Value  " + temp2.getData());
        } else {
            while (temp2.next != null) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        System.out.print(temp1.getData());
    }

    public boolean isPalindrome() {

        Node tempHead = head;
        List<Integer> numbers = new ArrayList<>();
        while (tempHead.next != null) {
            if (numbers.contains(tempHead.data)) {
                numbers.remove(numbers.indexOf(tempHead.data));
            } else {
                numbers.add(tempHead.data);
            }
            tempHead = tempHead.next;
        }
        if (numbers.size() == 1) {
            return true;
        }
        return false;
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

    public void removeDuplicates() {

        Node headTemp = head;
        while (headTemp != null && headTemp.next != null) {
            Node nodeToBeCompared = headTemp.next;
            Node previousNode = headTemp;

            while (nodeToBeCompared != null) {
                if (nodeToBeCompared.getData().equals(headTemp.getData())) {
                    previousNode.next = nodeToBeCompared.next;
                    size--;
                } else {
                    previousNode = nodeToBeCompared;
                }
                nodeToBeCompared = nodeToBeCompared.next;
            }
            headTemp = headTemp.next;
        }
    }

    class Node {
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
