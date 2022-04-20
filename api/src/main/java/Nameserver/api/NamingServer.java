package Nameserver.api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import static java.lang.Math.abs;


public class NamingServer {

    /* FIELDS */

    private static NamingServer instance = null;

    private HashMap<Integer, String> ipMap = new HashMap<>();

    /* CONSTRUCTOR (SINGLETON) */

    private NamingServer() {
        /* Testing values */
        ipMap.put(100, "testipadress");
    }

    public static NamingServer getInstance() {
        if (NamingServer.instance == null) {
            NamingServer.instance = new NamingServer();
        }
        return NamingServer.instance;
    }

    /* METHODS */

    public static int HashFile(String toHash) {
        long max = 2147483647;
        long min = -2147483648;
        long A = toHash.hashCode();
        A += (max + 1);
        long B = max + abs(min) + 1;
        return (int) (A * 32768 / B);
    }

    public String getFileIp(String filePath) {
        int fileHash = HashFile(filePath);
        // int requiredIpHash = ipMap.keySet().stream().map(s -> abs(s - fileHash)).min(Integer::compare).get();
        int min_diff = 32768;
        String ip = "";
        int diff;
        for (int key : ipMap.keySet()){
            diff = abs(key - fileHash);
            if (diff < min_diff){
                min_diff = diff;
                ip = ipMap.get(key);
            }
        }
        return ip;
    }

    public void addIp(String ip) {
        ipMap.put(HashFile(ip), ip);
    }

    public void removeIp(String ip) {
        ipMap.remove(HashFile(ip));
    }

    public boolean ipCheck(String ip){
        return ipMap.containsKey(HashFile(ip));
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
                ipMap = mapper.readValue(json, new TypeReference<>() {});
            } else {
                ipMap = new HashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
