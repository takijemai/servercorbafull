package client;

import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import BufferApp.Buffer;
import BufferApp.BufferHelper;

public class Client {
	 static Buffer bufferImpl;
	 public static void main(String args[]) {
	 try{
	 ORB orb = ORB.init(args, null);
	 org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	 NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	 String name = "Buffer";
	 bufferImpl = BufferHelper.narrow(ncRef.resolve_str(name));
	 StringHolder elem=new StringHolder();
	 System.out.println("Referencia:" + bufferImpl);
	 System.out.println(bufferImpl.put("Elemento 1"));
	 System.out.println(bufferImpl.put("Elemento 2"));
	 System.out.println(bufferImpl.put("Elemento 3"));
	 System.out.println(bufferImpl.put("Elemento 4"));
	 System.out.println(bufferImpl.put("Elemento 5"));
	 System.out.println(bufferImpl.put("Elemento 6"));
	 System.out.println(bufferImpl.get(elem)+"\t"+elem.value);
	 System.out.println(bufferImpl.read(elem)+"\t"+elem.value);
	 System.out.println(bufferImpl.get(elem)+"\t"+elem.value);
	 System.out.println(bufferImpl.read(elem)+"\t"+elem.value);
	 bufferImpl.shutdown();
	 } catch (Exception e) {
	 System.out.println("ERROR : " + e) ;
	 e.printStackTrace(System.out);
	 }
	 }
	}

