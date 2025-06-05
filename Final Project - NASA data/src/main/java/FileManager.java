import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    // Sometimes can't find needed file without explicit addition of directory name
    private static final String ProjectDirectoryName = "Final Project\\";

    public static Meteorite[] importFromJson(String filePath) {
        try {
            filePath = ProjectDirectoryName + filePath;

            System.out.println("Looking for file: " + new File(filePath).getAbsolutePath());

            String json = new String(Files.readAllBytes(Paths.get(filePath)));

            Gson gson = new GsonBuilder().create();
            return gson.fromJson(json, Meteorite[].class);
        } catch (IOException e) {
            System.out.println("Error reading JSON: " + e.getMessage());
            return new Meteorite[0];
        }
    }

    public static void exportToBinary(Meteorite[] data, String binaryPath) {
        if (data == null || data.length == 0) {
            System.out.println("No data to write. The binary file was not created.");
            return;
        }

        binaryPath = ProjectDirectoryName + binaryPath;

        File binaryFile = new File(binaryPath);
        File parentDir = binaryFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (parentDir.mkdirs()) {
                System.out.println("Directory created: " + parentDir.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory: " + parentDir.getAbsolutePath());
                return;
            }
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(binaryPath))) {
            out.writeObject(data);
            System.out.println("Meteorite data has been successfully exported to " + binaryPath);
        } catch (IOException e) {
            System.out.println("Error writing to binary file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Meteorite[] readFromBinary(String binaryPath) {
        binaryPath = ProjectDirectoryName + binaryPath;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(binaryPath))) {
            return (Meteorite[]) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new Meteorite[0];
        }
    }
}
