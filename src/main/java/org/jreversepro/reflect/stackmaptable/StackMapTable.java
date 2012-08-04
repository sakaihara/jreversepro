package org.jreversepro.reflect.stackmaptable;

import java.util.List;

/**
 * http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.7.4
 * StackMapTable_attribute {
    u2              attribute_name_index;
    u4              attribute_length;
    u2              number_of_entries;
    stack_map_frame entries[number_of_entries];
 * @author brad
 *
 */
public class StackMapTable {
  private final int attributeLength;

  
  private final List<StackMapFrame> stackMapFrames;
  
  public StackMapTable(int attributeLength, List<StackMapFrame> frames) {
    this.attributeLength = attributeLength;
    
    this.stackMapFrames = frames;
  }
  
  public int getAttributeLength() {
    return attributeLength;
  }
  
  public List<StackMapFrame> getStackMapFrames() {
    return stackMapFrames;
  }
  
  
}