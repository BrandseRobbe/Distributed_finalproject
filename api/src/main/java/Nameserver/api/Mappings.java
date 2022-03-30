package Nameserver.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

<<<<<<< HEAD:api/src/main/java/Nameserver/api/Mappings.java
import static java.lang.Math.abs;
=======
public class FileMapping {
    // Map of names to Person instances.
    // Private Map<String, User> idMap = new HashMap<>();
    private Map<Integer, String> fileMap = new HashMap<>();
>>>>>>> 50487c91a6c2c1708702a73d5e9b09326fbd93b1:api/src/main/java/Nameserver/api/FileMapping.java

public class Mappings {
    private Map<Integer, String> fileMap = new HashMap<>();
    private Map<Integer, String> ipMap = new HashMap<>();

    Mappings() {}

    public List<String> getFiles() {
        return new ArrayList<String>(fileMap.values());
    }

    public String getFileIp(String filePath) {
        int fileHash = HashFile(filePath);
        int requiredIpHash = ipMap.keySet().stream().map(s -> abs(s - fileHash)).min(Integer::compare).get();
        return fileMap.get(requiredIpHash);
    }

    public static int HashFile(String toHash){
//        stuff for seppe
        long max = 2147483647;
        long min =  -2147483648;
        long A = toHash.hashCode();
        A += (max + 1) ;
        long B = max+ abs(min) + 1;
        return (int) (A*32768/B);
    }

    public void addFile() {
    }

    public void removeFile() {
    }

    private void saveHashMap() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(fileMap);

            // Create the JSON-file
            File saveFile = new File("data.json");
            if (saveFile.createNewFile()) {
                System.out.println("File created: " + saveFile.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Write to the JSON file
            FileWriter writer = new FileWriter("data.json");
            writer.write(json);
            writer.close();

            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadHashMap(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                json = scanner.nextLine();
            }

            if (json != null) {
                this.fileMap = mapper.readValue(json, HashMap.class);
            } else {
                this.fileMap = new HashMap<Integer, String>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
