package Node;

public class Failure {

    /* FIELDS */
    private static Failure instance = null;

    /* CONSTRUCTOR */

    private Failure() {}

    public static Failure getInstance() {
        if(Failure.instance == null) {
            Failure.instance = new Failure();
        }

        return Failure.instance;
    }

    /* METHODS */

    public void removeNode(String ip) {
        
    }

}
