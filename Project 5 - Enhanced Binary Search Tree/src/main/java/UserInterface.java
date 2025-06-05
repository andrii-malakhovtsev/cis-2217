import java.util.Scanner;
import java.util.InputMismatchException;

public class UserInterface {
    private EnhancedBST tree;
    private Scanner scanner;

    public UserInterface() {
        tree = new EnhancedBST();
        scanner = new Scanner(System.in);
    }

    public void go() {
        int choice;
        do {
            displayMenu();
            try {
                choice = scanner.nextInt();
                handleChoice(choice);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nWelcome to Enhanced BST Tester.\n");
        System.out.println("Here's the menu of choices -");
        System.out.println("\t0) Quit");
        System.out.println("\t1) Build a BST from a text file");
        System.out.println("\t2) Print the tree");
        System.out.println("\t3) Add data");
        System.out.println("\t4) Remove data");
        System.out.println("\t5) Show tree height");
        System.out.println("\t6) Show internal path length");
        System.out.println("\t7) Count absent children");
        System.out.println("\t8) Find a path sum");
        System.out.println("\t9) Export a BST to a text file");
        System.out.print("Enter your choice: ");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Exiting...");
                break;
            case 1:
                buildFromFile();
                break;
            case 2:
                tree.print();
                break;
            case 3:
                addData();
                break;
            case 4:
                removeData();
                break;
            case 5:
                System.out.println("Tree height: " + tree.getTreeHeight());
                break;
            case 6:
                System.out.println("Internal path length: " + tree.getInternalPathLength());
                break;
            case 7:
                System.out.println("Absent children count: " + tree.countAbsentChildren());
                break;
            case 8:
                findPathSum();
                break;
            case 9:
                exportToFile();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void buildFromFile() {
        System.out.print("Enter filename: ");
        String filename = scanner.next();
        tree.buildTreeFromFile(filename);
    }

    private void addData() {
        System.out.print("Enter integer to add: ");
        int value = scanner.nextInt();

        tree.add(value);
    }

    private void removeData() {
        System.out.print("Enter integer to remove: ");
        int value = scanner.nextInt();

        tree.remove(value);
    }

    private void findPathSum() {
        System.out.print("Enter path sum to find: ");
        int sum = scanner.nextInt();

        System.out.println(tree.hasPathSum(sum) ?
                "Path sum exits in the tree" : "Path sum doesn't exist in the tree");
    }

    private void exportToFile() {
        System.out.print("Enter filename to export to: ");
        String filename = scanner.next();
        tree.exportToFile(filename);

        System.out.println("Tree exported successfully!");
    }
}