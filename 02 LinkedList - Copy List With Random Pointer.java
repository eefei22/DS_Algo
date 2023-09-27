import java.util.HashMap;

// Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

class CopyListWithRandomPointer{

    public static Node copyRandomList(Node head){
        //edge case
        if (head == null) return null;

        HashMap<Node, Node> old2new = new HashMap<>();

        Node curr = head;
        while (curr != null){
            old2new.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null){
            old2new.get(curr).next = old2new.get(curr.next);
            old2new.get(curr).random = old2new.get(curr.random);
            curr = curr.next;
        }
        return old2new.get(head);

    }

//========================================================================//

    public static void main (String[] args){
         // Create a sample linked list with random pointers
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Set random pointers
        node1.random = node3;
        node2.random = node1;
        node3.random = node2;
        node4.random = node1;

        // Call the copyRandomList method to create a deep copy
        Node copiedHead = copyRandomList(node1);

        // Print the original list with random pointers
        System.out.println("Original List with Random Pointers:");
        printListWithRandomPointers(node1);

        // Print the copied list with random pointers
        System.out.println("\nCopied List with Random Pointers:");
        printListWithRandomPointers(copiedHead);
}

// Helper method to print a linked list with random pointers
    public static void printListWithRandomPointers(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("Node(" + curr.val + ")");
            if (curr.random != null) {
                System.out.print(" -> Random(" + curr.random.val + ")");
            } else {
                System.out.print(" -> Random(null)");
            }
            System.out.println();
            curr = curr.next;
        }
    }

}


/*  Step-by-step Explanation
    Initialization:

    Create an empty hash map, old_to_new, to store the mapping from old nodes to new nodes.
    First Pass - Node Creation:

    Traverse the original list and for each node, create a corresponding new node.
    Store the mapping in old_to_new.
    Second Pass - Setting Pointers:

    Traverse the original list again.
    For each node, set its corresponding new node's next and random pointers based on the hash map. 
*/