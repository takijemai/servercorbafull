package server;

import org.omg.CORBA.ORB;
import org.omg.CORBA.StringHolder;

import BufferApp._BufferImplBase;

class BufferImpl extends _BufferImplBase {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ORB orb;
private String buf[];
private int elementos;
private static int maxElementos = 10;
BufferImpl (){
buf = new String[maxElementos];
elementos = 0;
}
// implement el metod put()
public boolean put (String elemento){
if(elementos<maxElementos) {
buf[elementos]=elemento;
elementos++;
System.out.println(buf[elementos-1]+"\tElementos: "+elementos);
return true;
} else {
elemento="PILA LLENA";
System.out.println("PILA LLENA");
return false;
}
}
// implementa el metodo get()
public boolean get (org.omg.CORBA.StringHolder elemento){
int i;
if(elementos>4) {
elemento.value=buf[0];
for(i=0;i<maxElementos-1;i++)
buf[i]=buf[i+1];
elementos--;
return true;
} else { elemento.value="SOLO INTRODUCIR O LEER"; return false;}
}
// implementa el metodo read()
public boolean read (org.omg.CORBA.StringHolder elemento){
if(elementos!=0) {
elemento.value=buf[0];
return true;
} else return false;
}
// implementa el metodo shutdown()
public void shutdown() {
orb.shutdown(false);
}
@Override
public boolean readAll(StringHolder elemento) {
	// TODO Auto-generated method stub
	return false;
}
}



