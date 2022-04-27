package Node;

import Utilities.Multicast;
import org.springframework.stereotype.Service;


public class Node {
    private String previous_node;
    private String next_node;
    private String nodename;
    private Multicast multicast;
    private MulticastReceiver multicastReceiver = new MulticastReceiver();

    public Node(String nodename) {
        this.nodename = nodename;
    }


    public void Run() {
        while (true) {

        }
    }

    public void Discovery() {
        // nodes ophalen van api
     //   multicast = new Multicast();
      //  System.out.println("ervoor");
        multicast.listenMulticast();
        System.out.println("erin");
        multicast.publishName();
        System.out.println("alallaa");
    }

    public void Bootstrap() {
        // local parameters initialiseren met nodedata
    }

    public void Shutdown() {
        // ExitNetwork endpoint op api oproepen
        // previous en next node inlichten
    }

    public void Failure() {

    }
}
