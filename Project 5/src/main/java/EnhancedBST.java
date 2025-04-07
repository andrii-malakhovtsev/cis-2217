// Andrii Malakhovtsev
// Enhanced Binary Search Tree

import java.util.*;
import java.io.*;

public class EnhancedBST extends BinarySearchTree {
    public EnhancedBST() {
        super();
    }

    public void buildTreeFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextInt()) {
                add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("no such file found");
        }
    }

    @Override
    public void print() {
        System.out.print("Inorder: ");
        printInOrder(getRoot());
        System.out.println();

        System.out.print("Preorder: ");
        printPreOrder(getRoot());
        System.out.println();

        System.out.print("Postorder: ");
        printPostOrder(getRoot());
        System.out.println();
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public int getTreeHeight() {
        return calculateHeight(getRoot());
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
    }

    public int getInternalPathLength() {
        return calculateInternalPathLength(getRoot(), 0);
    }

    private int calculateInternalPathLength(Node node, int depth) {
        if (node == null) {
            return 0;
        }
        return depth + calculateInternalPathLength(node.left, depth + 1)
                + calculateInternalPathLength(node.right, depth + 1);
    }

    public int countAbsentChildren() {
        return countAbsentNodes(getRoot());
    }

    private int countAbsentNodes(Node node) {
        if (node == null) {
            return 1;
        }
        return countAbsentNodes(node.left) + countAbsentNodes(node.right);
    }

    public boolean hasPathSum(int targetSum) {
        return checkPathSum(getRoot(), targetSum);
    }

    private boolean checkPathSum(Node node, int remainingSum) {
        if (node == null) {
            return false;
        }

        int currentValue = (Integer) node.data;
        remainingSum -= currentValue;

        if (node.left == null && node.right == null) {
            return remainingSum == 0;
        }

        return checkPathSum(node.left, remainingSum) || checkPathSum(node.right, remainingSum);
    }

    public void exportToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            exportPreOrder(getRoot(), writer);
        } catch (FileNotFoundException e) {
            System.out.println("Error exporting to the file");
        }
    }

    private void exportPreOrder(Node node, PrintWriter writer) {
        if (node != null) {
            writer.println(node.data);
            exportPreOrder(node.left, writer);
            exportPreOrder(node.right, writer);
        }
    }

    public Iterator<Integer> getPreOrderIterator() {
        List<Integer> elements = new ArrayList<>();
        collectPreOrder(getRoot(), elements);

        return elements.iterator();
    }

    private void collectPreOrder(Node node, List<Integer> elements) {
        if (node != null) {
            elements.add((Integer) node.data);
            collectPreOrder(node.left, elements);
            collectPreOrder(node.right, elements);
        }
    }
}