package Nameserver.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/FileService")
public class FileController {

    private final AtomicLong counter = new AtomicLong();
    private NamingServer namingServer = NamingServer.getInstance();
    private RequestService requestService;


    @PutMapping("/UpdateServerFiles")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public ResponseEntity UpdateServerFiles(){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/JoinNetwork")
//    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public ResponseEntity JoinNetwork(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        System.out.println(ip + " has joined the network");
        namingServer.addIp(ip);
        return new ResponseEntity<>("Successfully joined the network", HttpStatus.ACCEPTED);
    }

    @GetMapping("/ExitNetwork")
    public ResponseEntity ExitNetwork(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        if (namingServer.ipCheck(ip)){
            System.out.println(ip + " has quit the network");
            namingServer.removeIp(ip);
            return new ResponseEntity<>("Successfully exited the network", HttpStatus.ACCEPTED);
        }
        System.out.println(ip + " is not in the network");
        return new ResponseEntity<>("Found nothing to remove", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/GetFileIp/{filename}")
    public String GetfileIp(@PathVariable("filename") String fileName){
        return namingServer.getFileIp(fileName);
    }
}
