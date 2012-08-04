package org.jreversepro.reflect.localvariabletype;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jreversepro.reflect.ConstantPool;

public class LocalVariableTableTypeFactory {

  private LocalVariableTableTypeFactory() {
    //seal
  }
  
  public static LocalVariableTypeTable parseLocalVariableTable(DataInputStream dis, ConstantPool aCpInfo) throws IOException { 
    int attributeLength = dis.readInt();
    final int localVariableTableLength = dis.readUnsignedShort();
    
    List<LocalVariableTableTypeEntry> localVariableTable = new ArrayList<LocalVariableTableTypeEntry>(localVariableTableLength);
    for(int i=0; i<localVariableTableLength; i++) {
      LocalVariableTableTypeEntry lve = parseLocalVariableTableEntry(dis, aCpInfo);
      localVariableTable.add(lve);
    }
    
    LocalVariableTypeTable lvt = new LocalVariableTypeTable(attributeLength, localVariableTable);
    return lvt;
  }
  
  public static LocalVariableTableTypeEntry parseLocalVariableTableEntry(DataInputStream dis, ConstantPool aCpInfo) throws IOException {
    short startPC = dis.readShort();
    short length = dis.readShort();
    short nameIndex = dis.readShort();
    short signatureIndex = dis.readShort();
    short index = dis.readShort();
    
    String name = aCpInfo.getEntryValue(nameIndex);
    String signature = aCpInfo.getEntryValue(signatureIndex);
    
    
    LocalVariableTableTypeEntry lve = new LocalVariableTableTypeEntry(startPC, length, name, signature, index);
    return lve;
  }
}
