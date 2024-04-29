package server;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import java.io.*;
public class BufferServer {
public static void main(String args[]) {
try {
ORB orb = ORB.init(args, null); // Crea e inicializa el ORB
System.out.println("serverorb: " + orb);
// Crea un hilo (servant) y lo registra en el ORB
BufferImpl bufferRef = new BufferImpl();
orb.connect(bufferRef);
// Obtiene una referencia del objeto
org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

System.out.println("objRef: " + objRef);
NamingContext ncRef = NamingContextHelper.narrow(objRef);
System.out.println("ncRef: " +ncRef);
// Activa la referencia
NameComponent nc = new NameComponent("Buffer", "");
System.out.println("nc: " +nc);
NameComponent path[] = {nc};
ncRef.rebind(path,bufferRef);
System.out.println("Servidor CORBA Buffer preparado y esperando ...");

java.lang.Object sync = new java.lang.Object();
synchronized(sync){
sync.wait();
}
} catch(Exception e) {
System.err.println("ERROR: " + e);
e.printStackTrace(System.out);
}
}
}