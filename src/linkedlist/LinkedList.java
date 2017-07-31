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
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (head.next == null) {
            System.out.println(head.getData());
            return;
        }
        Node ptr = head;
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

    public void makeItCircular() {

        Node tempHead = head;
        Node loopPoint = null;
        int secondIndex = 0;
        while (tempHead.next != null){
            if (secondIndex == 3){
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
                if (nodeToBeCompared.getData() == headTemp.getData()) {
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
        int data;
        Node next;

        Node(int data, Node n) {
            this.data = data;
            this.next = n;
        }

        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }

        public int getData() {
            return data;
        }

        public Node getLink() {
            return next;
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
