import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileFinder  implements TextFinder{

    private int findSubstring(String line, String substring){
        int lastIndex = 0;
        int count = 0;
        while(lastIndex != -1) {
            lastIndex = line.indexOf(substring,lastIndex);
            if(lastIndex != -1){
                count++;
                lastIndex++;
            }
        }
        return count;
    }

    @Override
    public int getSubstringCount(String fileName, String substring) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                 count += findSubstring(line,substring);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return count;
    }


}
