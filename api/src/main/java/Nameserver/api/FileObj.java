package Nameserver.api;

public class FileObj {
    private String fileName;
    private String hashval;
    private String ipAdress;

    public FileObj() {
    }

    public FileObj(String fileName, String hashval, String ipAdress) {
        this.fileName = fileName;
        this.hashval = hashval;
        this.ipAdress = ipAdress;
    }

    public void HashFile(){
//        stuff for seppe
        return;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getHashval() {
        return hashval;
    }

    public void setHashval(String hashval) {
        this.hashval = hashval;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }
}
