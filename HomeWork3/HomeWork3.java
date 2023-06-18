

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

    public static void pushFront(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    public static void popFront(){
        if(head != null) {
            head = head.next;
        }
    }

    public static void print(){
        Node cur = head;

        while (cur != null){
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    public static boolean contains(int value){
        Node cur = head;
        while (cur != null){
            if(cur.value == value){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public  static void pushBack(int value) {
        Node node = new Node();
        node.value = value;

        if(head == null){
            head = node;
        }else{
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;

            }
            cur.next = node;
        }
    }

    public  static void popBack(){
        if(head != null){
            if(head.next == null){
                head = null;
            }else{
                Node cur = head;
                while (cur.next.next != null){
                    cur = cur.next;
                }
                cur.next = null;
            }

        }
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
