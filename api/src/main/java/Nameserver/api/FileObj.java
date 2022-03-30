package Nameserver.api;

import static java.lang.Math.abs;

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

    public int HashFile(String toHash){
//        stuff for seppe
        long max = 2147483647;
        long min =  -2147483648;
        long A = toHash.hashCode();
        A += (max + 1) ;
        long B = max+ abs(min) + 1;
        return (int) (A*32768/B);
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
