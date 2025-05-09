// Andrii Malakhovtsev
// 05.09.2025
// Final Project - NASA data

import java.util.*;
import java.util.stream.Collectors;

public class UserInterface {
    private Meteorite[] data = new Meteorite[0];
    private final String binaryPath = "data/meteoriteData.bin";
    private final Scanner scanner = new Scanner(System.in);

    public void go() {
        data = FileManager.readFromBinary(binaryPath);

        while (true) {
            showMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "0" -> { return; }
                case "1" -> importJson();
                case "2" -> displayAll();
                case "3" -> FileManager.exportToBinary(data, binaryPath);
                case "4" -> findByName();
                case "5" -> findById();
                case "6" -> listLargest();
                case "7" -> listRecent();
                case "8" -> listClasses();
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("""
            Welcome to the NASA Meteorite tracking database.
            Here's the menu of choices -
                0) Quit
                1) Import meteorite data from a JSON file
                2) Display the meteorite data
                3) Export the meteorite data to a file
                4) Find a meteorite by name
                5) Find a meteorite by ID
                6) List the largest meteorites
                7) List the most recent meteorites by year
                8) List the meteorite classes""");
        System.out.print("Enter your choice: ");
    }

    private void importJson() {
        System.out.print("Enter JSON file name or press <Enter> for default (data/NASA_Meteorite.json): ");
        String filename = scanner.nextLine().trim();

        if (filename.isEmpty()) filename = "data/NASA_Meteorite.json";

        data = FileManager.importFromJson(filename);
        System.out.println(data.length + " records processed.");
    }

    private void displayAll() {
        System.out.println("Meteor data:");
        for (Meteorite m : data) {
            System.out.println(m);
        }
    }

    private void findByName() {
        System.out.print("Enter meteorite name: ");
        String name = scanner.nextLine().trim().toLowerCase();
        System.out.println();

        List<Meteorite> matches = Arrays.stream(data)
                .filter(m -> m.getName().toLowerCase().equals(name))
                .toList();

        if (matches.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            matches.forEach(m -> System.out.println(m.display()));
        }
    }

    private void findById() {
        System.out.print("Enter meteorite ID: ");
        String id = scanner.nextLine().trim();
        System.out.println();

        List<Meteorite> matches = Arrays.stream(data)
                .filter(m -> m.getId().equals(id))
                .toList();

        if (matches.isEmpty()) {
            System.out.println("No entries found.");
        } else {
            matches.forEach(m -> System.out.println(m.display()));
        }
    }

    private void listLargest() {
        System.out.print("How many of the largest meteorites do you want to see? ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("\nLargest " + count + " meteorites:");

        Arrays.stream(data)
                .filter(m -> m.getMass() != null)
                .sorted(Comparator.comparingDouble(m -> -Double.parseDouble(m.getMass())))
                .limit(count)
                .forEach(m -> System.out.println(m.display()));
    }

    private void listRecent() {
        System.out.print("How many of the most recent meteorites do you want to see? ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("\nLast " + count + " meteorites:");

        Arrays.stream(data)
                .filter(m -> m.getYear() != null && m.getYear().length() >= 4)
                .sorted((a, b) -> b.getYear().compareTo(a.getYear()))
                .limit(count)
                .forEach(m -> System.out.println(m.display()));
    }

    private void listClasses() {
        System.out.println("Meteorite Classes:");
        System.out.printf("%-10s%s%n", "Count", "Classification");
        System.out.println("=======   ============");

        Map<String, Long> classCounts = Arrays.stream(data)
                .filter(m -> m.getRecclass() != null && !m.getRecclass().isBlank())
                .collect(Collectors.groupingBy(
                        Meteorite::getRecclass,
                        Collectors.counting()
                ));

        classCounts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .forEach(entry ->
                        System.out.printf("%7d    %s%n", entry.getValue(), entry.getKey())
                );
    }

}
