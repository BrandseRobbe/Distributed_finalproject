package Nameserver.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/FileService")
public class FileController {

    private final AtomicLong counter = new AtomicLong();
    private final FileMapping datastore = new FileMapping();

    @GetMapping("/GetFiles")
    public List<FileObj> getAccounts(){
        return datastore.getFiles();
    }

    @PutMapping("/UpdateServerFiles")
    public List<FileObj> updateServerFiles(){
        return datastore.getFiles();
    }

    @GetMapping("/GetFileIp/{filename}")
//    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public String getfileIp(@PathVariable("filename") String fileName){
        return datastore.getFileIp(fileName);
    }
}
