package org.jreversepro.reflect.localvariabletype;

import java.util.List;

public class LocalVariableTypeTable {

  protected final int attributeLength;
  protected final List<LocalVariableTableTypeEntry> localVariableTable;
  
  public LocalVariableTypeTable(int attributeLength, List<LocalVariableTableTypeEntry> localVariableTable) {
    this.attributeLength = attributeLength;
    this.localVariableTable = localVariableTable;
  }
  
  public int getAttributeLength() {
    return attributeLength;
  }
  public List<LocalVariableTableTypeEntry> getLocalVariableTable() {
    return localVariableTable;
  }
  
}
