import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileIO {

    private static final String FILENAME = "calc.txt";

    public String read() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILENAME), StandardCharsets.UTF_8))) {
            String line;
            if ((line = reader.readLine()) != null) {
                return (line);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    public void write(Double res) {
        try (FileWriter writer = new FileWriter(FILENAME, true)) {
            writer.write("\n" + res.toString());

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
