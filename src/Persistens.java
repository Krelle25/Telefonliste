import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Persistens {
    public static void gemTelefonbog(Map<String, String> telefonbog) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("telefonliste_data.txt"))) {
            for (Map.Entry<String, String> entry : telefonbog.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Fejl ved gemning af data: " + e.getMessage());
        }
    }

    public static Map<String, String> indlaesTelefonbog() {
        Map<String, String> telefonbog = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("telefonliste_data.txt"))) {
            String linje;
            while ((linje = reader.readLine()) != null) {
                String[] parts = linje.split(",");
                if (parts.length == 2) {
                    telefonbog.put(parts[0], parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved indlæsning af data: " + e.getMessage());
        }
        return telefonbog;
    }
}

