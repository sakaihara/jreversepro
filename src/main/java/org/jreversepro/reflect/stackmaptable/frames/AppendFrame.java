package org.jreversepro.reflect.stackmaptable.frames;

import org.jreversepro.reflect.stackmaptable.StackMapFrame;

public class AppendFrame extends StackMapFrame {
  public static final int LOWER_RANGE = 252;
  public static final int UPPER_RANGE = 254;
  
  protected final short offsetDelta;
  
  public AppendFrame(int frameType, short offsetDelta) {
    super(frameType);
    
    this.offsetDelta = offsetDelta;
  }
  
}
