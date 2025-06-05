public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(Comparable obj) {
        if (root == null) {
            root = new Node(obj);
        } else {
            root.addNode(new Node(obj));
        }
    }

    public void remove(Comparable obj) {
        root = remove(root, obj);
    }

    private Node remove(Node node, Comparable obj) {
        if (node == null) {
            return null;
        }

        int cmp = obj.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, obj);
        } else if (cmp > 0) {
            node.right = remove(node.right, obj);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node smallest = findSmallest(node.right);
            node.data = smallest.data;
            node.right = remove(node.right, smallest.data);
        }
        return node;
    }

    private Node findSmallest(Node node) {
        return node.left == null ? node : findSmallest(node.left);
    }

    public void print() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    protected Node getRoot() {
        return root;
    }

    protected class Node {
        public Comparable data;
        public Node left;
        public Node right;

        public Node(Comparable data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void addNode(Node newNode) {
            if (newNode.data.compareTo(this.data) < 0) {
                if (this.left == null) {
                    this.left = newNode;
                } else {
                    this.left.addNode(newNode);
                }
            } else if (newNode.data.compareTo(this.data) > 0) {
                if (this.right == null) {
                    this.right = newNode;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }
    }
}