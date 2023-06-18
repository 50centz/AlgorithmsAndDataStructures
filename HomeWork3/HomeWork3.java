

package HomeWork.HomeWork3;

/**
 * HomeWork3
 */
public class HomeWork3 {

    
}

class List{

    static  Node head;
    
    static class Node{
        int value;
        Node next;
    }

    


    public  static void reverse(){
        Node prev = null;
        Node cur = head;
        Node next = null;

        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }
}
