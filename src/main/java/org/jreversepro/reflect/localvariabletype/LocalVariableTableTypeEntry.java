package org.jreversepro.reflect.localvariabletype;

public class LocalVariableTableTypeEntry {

  private final short startPC;
  private final short length;
  private final String name;
  private final String signature;
  private final short index;
  
  public LocalVariableTableTypeEntry(short startPC, short length, String name, String signature, short index) {
    this.startPC = startPC;
    this.length = length;
    this.name = name;
    this.signature = signature;
    this.index = index;
  }

  public short getStartPC() {
    return startPC;
  }

  public short getLength() {
    return length;
  }

  public String getName() {
    return name;
  }

  public String getSignature() {
    return signature;
  }

  public short getIndex() {
    return index;
  }
  
  
}
