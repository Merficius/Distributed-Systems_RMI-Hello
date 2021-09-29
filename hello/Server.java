package example.hello;
	
import java.util.Date;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
	
public class Server implements Hello {
	
    public Server() {}

    public String sayHello() {
		return "Hello, world!";
    }
	
	public String sayGoodBye() {
		return "GoodBye!";
    }

	public Date sendDate(Date d) {
		System.out.println("Inicia: " + d);
		return new Date();
    }
	
    public static void main(String args[]) {
	
		try {
			// Creation of servant
	    	Server obj = new Server();
	    	Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

	    	// Bind the remote object's stub in the registry
	    	Registry registry = LocateRegistry.getRegistry();
	    	registry.bind("Hello", stub);

	    	System.err.println("Server ready");
		} catch (Exception e) {
	    	System.err.println("Server exception: " + e.toString());
	    	e.printStackTrace();
		}
    }
}
