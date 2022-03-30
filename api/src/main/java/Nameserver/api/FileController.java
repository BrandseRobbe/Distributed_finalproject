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
<<<<<<< HEAD
    private Mappings mappings = new Mappings();
=======
    private final FileMapping datastore = new FileMapping();
>>>>>>> 50487c91a6c2c1708702a73d5e9b09326fbd93b1

    @GetMapping("/GetFiles")
    public List<String> getAccounts(){
        return mappings.getFiles();
    }

    @PutMapping("/UpdateServerFiles")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public ResponseEntity updateServerFiles(){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/GetFileIp/{filename}")
    public String getfileIp(@PathVariable("filename") String fileName){
        return mappings.getFileIp(fileName);
    }
}
