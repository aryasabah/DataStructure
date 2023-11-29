import java.util.Scanner;



public class Josephus {
    public static void main(String[] args) {
        CLL cl = new CLL();
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter a number for n: ");
        int n = inp.nextInt();
        System.out.println("Enter a number for m:");
        int m = inp.nextInt();

        
        for (int i = 1; i <= n; i++) {
            cl.add(i);
        }

        System.out.println("Initial List:");
        cl.show();

        cl.josephus(m);
    }
}
class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class CLL {
     Node head;

    public void add(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            head.next = head; 
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head; 
        }
    }

   

    public void josephus(int m) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        Node previous = null;

        while (current.next != current) {
            // Move to the m-th node
            for (int i = 1; i < m; i++) {
                previous = current;
                current = current.next;
            }

            // Print eliminated number and updated list
            System.out.println("Eliminated: " + current.val);
            if (current == head) {
                head = current.next; // Update head if the first node is eliminated
            }
            previous.next = current.next;
            current = previous.next;
            show();
        }

        System.out.println("Survivor: " + current.val);
    }
    public void show() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (true) {
            System.out.print(current.val + " ");
            current = current.next;
            if (current == head) {
                break;
            }
        }
        System.out.println();
    }
}
