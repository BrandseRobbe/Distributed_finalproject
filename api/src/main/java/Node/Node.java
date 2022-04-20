package Node;

public class Node {
    private String previous_node;
    private String next_node;
    private String nodename;

    public void Run() {
        while (true) {

        }
    }

    public void Discovery() {
        // nodes ophalen van api
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
