package Nameserver.api;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
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

    public FileController() {
        // multicasts asynchroon lezen en beantwoorden

    }

    public void handleMulticasts() {
        while (true) {
            String[] message = readMulticastMessage();

        }
    }

    public String[] readMulticastMessage() {
        MulticastSocket socket = null;
        try {
            socket = new MulticastSocket(4446);
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] buf = new byte[256];
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
                String adress = String.valueOf(packet.getAddress());
                String msg = new String(packet.getData(), packet.getOffset(), packet.getLength());
                return new String[]{adress, msg};
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @PutMapping("/UpdateServerFiles")
    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public ResponseEntity<String> updateServerFiles() {
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/JoinNetwork")
//    @ResponseStatus(code = HttpStatus.OK, reason = "OK")
    public ResponseEntity<String> joinNetwork(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        System.out.println(ip + " has joined the network");
        namingServer.addIp(ip);
        return new ResponseEntity<>("Successfully joined the network", HttpStatus.ACCEPTED);
    }

    @GetMapping("/ExitNetwork/{ip}")
    public ResponseEntity<String> exitNetworkByIP(@PathVariable("ip") String ip) {
        if (namingServer.ipCheck(ip)) {
            namingServer.removeIp(ip);
            System.out.println(ip + " has quit the network");
            return new ResponseEntity<>("Successfully exited the network", HttpStatus.ACCEPTED);
        }
        System.out.println(ip + " is not in the network");
        return new ResponseEntity<>("Found nothing to remove", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/GetFileIp/{filename}")
    public String getfileIp(@PathVariable("filename") String fileName) {
        return namingServer.getFileIp(fileName);
    }
}
