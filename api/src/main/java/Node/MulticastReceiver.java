package Node;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class MulticastReceiver extends Thread {
    protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];

    public void run() {
        try {
            socket = new MulticastSocket(4446);
        } catch (IOException e) {
            e.printStackTrace();
        }
        InetAddress group = null;

        try {
            group = InetAddress.getByName("230.0.0.0");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            socket.joinGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String adress = String.valueOf(packet.getAddress());
            String msg = new String(packet.getData(), packet.getOffset(), packet.getLength());

            if ("end".equals(adress)) {
                break;
            }

            System.out.println("message address: " + adress);
            System.out.println("message content: " + msg);
        }
      //  socket.leaveGroup(group);
      //  socket.close();
    }

    public static void main(String[] args) {
        MulticastReceiver multicastReceiver = new MulticastReceiver();
        multicastReceiver.run();
    }
}
