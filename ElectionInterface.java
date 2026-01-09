import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ElectionInterface extends Remote {
    // Client casts a vote for a specific candidate
    void castVote(String candidateName) throws RemoteException;

    // returns current counts in order
    int[] getResult() throws RemoteException;
}
