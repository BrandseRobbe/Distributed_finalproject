package Nameserver.api;

import java.io.File;
import java.util.HashMap;
import java.util.*;
import java.util.stream.Collectors;

public class FileMapping {
    //Map of names to Person instances.
//    private Map<String, User> idMap = new HashMap<>();
    private Map<String, FileObj> fileMap = new HashMap<String, FileObj>();

    //private constructor so people know to use the getInstance() function instead
    FileMapping() {
    }

    public List<FileObj> getFiles() {
        return new ArrayList<>(fileMap.values());
    }

    public String getFileIp(String filePath) {
        return fileMap.values().stream().filter(e -> e.getFilePaths().contains(filePath)).findFirst().orElse(null).getIpAdress();
    }
}