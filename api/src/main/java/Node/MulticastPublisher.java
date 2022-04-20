package Node;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MulticastPublisher {
    private DatagramSocket socket;
    private InetAddress group;
    private byte[] buf;
    private String NameOfServer;

    public MulticastPublisher(String nameOfServer) {
        NameOfServer = nameOfServer;
    }

    public void multicast(
            String multicastMessage) throws IOException {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        group = InetAddress.getByName("230.0.0.0");
        buf = multicastMessage.getBytes();

        DatagramPacket packet
                = new DatagramPacket(buf, buf.length, group, 4446);
        socket.send(packet);
        socket.close();
    }

    /*
    public static void main(String[] args) throws IOException {
        MulticastPublisher multicastPublisher = new MulticastPublisher(nameOfServer);
        multicastPublisher.multicast("naamvanserver");

    }
*/

    public void publishName () {
      try {multicast(NameOfServer); } catch (IOException e) {
          e.printStackTrace();
      }
    }
}
