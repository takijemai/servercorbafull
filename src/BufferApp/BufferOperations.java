package BufferApp;


/**
* BufferApp/BufferOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Buffer.idl
* dimanche 28 avril 2024 16 h 36 CEST
*/

public interface BufferOperations 
{
  boolean put (String elemento);
  boolean get (org.omg.CORBA.StringHolder elemento);
  boolean read (org.omg.CORBA.StringHolder elemento);
  boolean readAll (org.omg.CORBA.StringHolder elemento);
  void shutdown ();
} // interface BufferOperations
