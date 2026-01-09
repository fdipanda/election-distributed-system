import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;

public class ElectionServer extends UnicastRemoteObject implements ElectionInterface {

    private int candidateA;
    private int candidateB;

    public ElectionServer() throws RemoteException {
        super();
        candidateA = 0;
        candidateB = 0;
    }

    @Override
    public synchronized void castVote(String candidateName) throws RemoteException {
        if (candidateName.equalsIgnoreCase("A")) { // Make sure entries are not case-sensitive
            candidateA++;
            System.out.println("Vote cast for Candidate A");
        }
        else if (candidateName.equalsIgnoreCase("B")) {
            candidateB++;
            System.out.println("Vote cast for Candidate B");
        }
        else {
            System.out.println("Invalid candidate: " + candidateName);
        }
    }

    @Override
    public synchronized int[] getResult() throws RemoteException {
        return new int[] { candidateA, candidateB };
    }

    public static void main(String[] args) {
        try {
            int port = 1099;

            // Start RMI registry
            LocateRegistry.createRegistry(port);
            System.out.println("RMI Registry started on port " + port);

            // Create server object
            ElectionServer server = new ElectionServer();

            // Binds object to registry under name "Election"
            Naming.rebind("rmi://localhost:" + port + "/Election", server);
            System.out.println("Election Server is running...");

        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}
