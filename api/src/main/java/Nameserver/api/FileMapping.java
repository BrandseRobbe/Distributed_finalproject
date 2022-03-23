package Nameserver.api;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileMapping {
    // Map of names to Person instances.
    // Private Map<String, User> idMap = new HashMap<>();
    private Map<Integer, FileObj> fileMap = new HashMap<>();

    //private constructor so people know to use the getInstance() function instead
    FileMapping() {
    }

    public List<FileObj> getFiles() {
        return new ArrayList<>(fileMap.values());
    }

    public void addFile() {}

    public void removeFile() {}

    public void saveHashMap(HashMap<Integer, FileObj> hashMap) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(hashMap);

            // Save the JSON to a file
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, FileObj> loadHashMap(String json) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            HashMap<Integer, FileObj> hashMap = mapper.readValue(json, HashMap.class);

            return hashMap;
        }
        catch (JsonGenerationException e) {
            e.printStackTrace();
        }
        catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
