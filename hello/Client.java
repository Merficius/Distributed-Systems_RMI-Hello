package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

		String host = (args.length < 1) ? null : args[0];
		try {
			// Communication with name server
	    	Registry registry = LocateRegistry.getRegistry(host);
			// Search for hello object
	    	Hello stub = (Hello) registry.lookup("Hello");
			// Execute the method hello
	    	String response = stub.sayHello();
	    	System.out.println("response: " + response);
			//Execute method goodbye
			response = stub.sayGoodBye();
	    	System.out.println("response: " + response);
		} catch (Exception e) {
	    	System.err.println("Client exception: " + e.toString());
	    	e.printStackTrace();
		}
    }
}
