package Nameserver.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileMapping {
    // Map of names to Person instances.
    // Private Map<String, User> idMap = new HashMap<>();
    private Map<Integer, String> fileMap = new HashMap<>();

    //private constructor so people know to use the getInstance() function instead
    FileMapping() {
//        List<String> filePaths = new ArrayList<String>();
//        filePaths.add("putput_saves_the_zoo");
//
//        FileObj test = new FileObj("1240.2039", filePaths);
//        fileMap.put(97432, test);

//        saveHashMap();
        loadHashMap("data.json");
    }

    public List<FileObj> getFiles() {
        return new ArrayList<>(fileMap.values());
    }

    public String getFileIp(String filePath) {
        return fileMap.values().stream().filter(e -> e.getFilePaths().contains(filePath)).findFirst().orElse(null).getIpAdress();
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
