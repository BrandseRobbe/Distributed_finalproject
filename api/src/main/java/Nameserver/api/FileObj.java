package Nameserver.api;

import java.util.List;

public class FileObj {
    private String ipAdress;
    private List<String> filePaths;

    public FileObj() {
    }

    public FileObj(String ipAdress, List<String> filePaths) {
        this.ipAdress = ipAdress;
        this.filePaths = filePaths;
    }

    public void HashFile(){
//        stuff for seppe
        return;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public List<String> getFilePaths() {
        return filePaths;
    }

    public void setFilePaths(List<String> filePaths) {
        this.filePaths = filePaths;
    }
}
