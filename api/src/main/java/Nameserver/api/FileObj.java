package Nameserver.api;

import java.util.List;

import static java.lang.Math.abs;

public class FileObj {
    private String ipAdress;
    private List<String> filePaths;

    public FileObj() {
    }

    public FileObj(String ipAdress, List<String> filePaths) {
        this.ipAdress = ipAdress;
        this.filePaths = filePaths;
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
