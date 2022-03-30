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
    private Mappings mappings = new Mappings();

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
