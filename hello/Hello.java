package example.hello;

import java.util.Date;
import java.rmi.Remote;
import java.rmi.RemoteException;

/* 
Reglas:
1.- Interfaz pública
2.- Extender remote 
3.- Cada método lanza exepción remote
4.- Si pasan parámetros, deben de ser de clases serializables (Date y String es serializable)
*/
public interface Hello extends Remote {
    String sayHello() throws RemoteException;
    String sayGoodBye() throws RemoteException;
    Date sendDate(Date d) throws RemoteException;
    Oferta sendOferta(Oferta o) throws RemoteException; // copy-restore, le mandas el objeto clonado y te regresa el objeto modificado clonado
}
