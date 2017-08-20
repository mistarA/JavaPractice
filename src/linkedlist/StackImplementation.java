package linkedlist;

import java.util.Scanner;

/**
 * Created by anandmishra on 20/08/17.
 */
public class StackImplementation {

    static int size = 0;
    static int maxSize = 3;

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        Scanner scan = new Scanner(System.in);
        System.out.println("Stack Implementation\n");
        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. Stack Push");
            System.out.println("2. Stack Pop");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt();
                    push(linkedList, num);
                    break;
                case 2:
                    System.out.println(pop(linkedList));
                    linkedList.display();
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            linkedList.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }

    static void push(LinkedList linkedList, int data){
        if (size == maxSize){
            System.out.print("Stack Overflow");
        } else{
            linkedList.insertAtEnd(data);
        }
        size++;
        linkedList.display();
    }

    static int pop(LinkedList linkedList){
        LinkedList.Node slowPtr = linkedList.head;
        LinkedList.Node fastPtr = linkedList.head;
        if (size != 0) {
            while (fastPtr != null && fastPtr.next != null && fastPtr.next.next != null) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
            }

            while (slowPtr.next != null && !slowPtr.next.equals(fastPtr)){
                slowPtr = slowPtr.next;
            }
            int data = slowPtr.getData();
            slowPtr.next = null;
            size--;
            return data;
        }
        return -1;
    }
}
