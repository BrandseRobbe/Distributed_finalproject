package Utilities;

import java.io.IOException;
import java.net.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Multicast extends Thread {

    private DatagramSocket socket;
    private InetAddress group;
    private byte[] buf;
    private String NameOfServer;
    protected MulticastSocket socketRecieve = null;
    protected byte[] bufReceive = new byte[256];

    public Multicast(String nameOfServer) {
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

    public void publishName () {
        try {multicast(NameOfServer); } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void listenMulticast() {
        try {
            socketRecieve = new MulticastSocket(4446);
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
            socketRecieve.joinGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            DatagramPacket packet = new DatagramPacket(bufReceive, bufReceive.length);
            try {
                socketRecieve.receive(packet);
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
    }
}
