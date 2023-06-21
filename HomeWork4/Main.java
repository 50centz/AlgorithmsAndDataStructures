package HomeWork.HomeWork4;

public class Main {
    public static void main(String[] args) {
        // HashMap map = new HashMap();
        //
        // map.push(-1, 2);
        // map.push(17, 3);
        // map.push(3, 4);
        //
        // System.out.println(map.find(-1));
        // System.out.println(map.find(17));
        // System.out.println(map.find(3));
        // System.out.println(map.find(5));
        //
        // map.remove(17);
        // System.out.println(map.find(17));

        Tree tree = new Tree();
        for (int i = 1; i <= 5; i++){
            tree.insert(i);
        }

        tree.insert(50);
        tree.insert(45);
        tree.insert(17);
        tree.insert(10);
        tree.insert(14);

    }
}

class Tree {
    private Node root;

    class Node {
        int value;
        Node left;
        Node right;

        Color color;
    }

    enum Color {
        BLACK,
        RED
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
        } else {
            insert(root, value);
        }
    }

    private void balance(Node node) {

        boolean start = true;
        do {
            start = false;
            if (node.right != null && node.right.color == Color.RED
                    && (node.left == null || node.left.color == Color.BLACK)) {
                start = true;
                rightTurn(node);
            }
            if (node.left != null && node.left.color == Color.RED && node.left.left != null
                    && node.left.left.color == Color.RED) {
                start = true;
                leftTurn(node);
            }
            if (node.left != null && node.left.color == Color.RED && node.right != null
                    && node.right.color == Color.RED) {
                start = true;
                swap(node);
            }
        } while (start);
    }

    private void leftTurn(Node node) {
        Node left = node.left;
        Node temp = left.right;
        left.right = node;
        node.left = temp;
        left.color = node.color;
        node.color = Color.RED;
    }

    private void rightTurn(Node node) {
        Node right = node.right;
        Node temp = right.left;
        right.left = node;
        node.right = temp;
        right.color = node.color;
        node.color = Color.RED;
    }

    private void swap(Node node) {
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;

    }

    private void insert(Node node, int value) {
        if (node.value != value) {
            if (node.value < value) {
                if (node.right == null) {
                    node.right = new Node();
                    node.right.value = value;
                    node.right.color = Color.RED;
                } else {
                    insert(node.right, value);
                    balance(node.right);
                }
            } else {
                if (node.left == null) {
                    node.left = new Node();
                    node.left.value = value;
                    node.left.color = Color.RED;
                } else {
                    insert(node.left, value);
                    balance(node.left);
                }
            }
        }
    }

    public Node find(int value) {
        return find(root, value);
    }

    private Node find(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (node.value < value) {
            return find(node.right, value);
        } else {
            return find(node.left, value);
        }
    }
}
