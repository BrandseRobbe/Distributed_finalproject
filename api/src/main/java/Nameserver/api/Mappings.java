package Nameserver.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.lang.Math.abs;


public class Mappings {
    private Map<Integer, String> ipMap = new HashMap<>();

    Mappings() {
    }

    public String getFileIp(String filePath) {
        int fileHash = HashFile(filePath);
        int requiredIpHash = ipMap.keySet().stream().map(s -> abs(s - fileHash)).min(Integer::compare).get();
        return ipMap.get(requiredIpHash);
    }

    public static int HashFile(String toHash) {
//        stuff for seppe
        long max = 2147483647;
        long min = -2147483648;
        long A = toHash.hashCode();
        A += (max + 1);
        long B = max + abs(min) + 1;
        return (int) (A * 32768 / B);
    }

    public void addIp(String ip) {
        ipMap.put(HashFile(ip), ip);
    }
    public void removeIp(String ip) {
        ipMap.remove(HashFile(ip));
    }

    private void saveHashMap() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(ipMap);

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
                this.ipMap = mapper.readValue(json, HashMap.class);
            } else {
                this.ipMap = new HashMap<Integer, String>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
