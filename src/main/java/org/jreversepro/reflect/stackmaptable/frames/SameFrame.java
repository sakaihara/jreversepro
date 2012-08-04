package org.jreversepro.reflect.stackmaptable.frames;

import org.jreversepro.reflect.stackmaptable.StackMapFrame;

public class SameFrame extends StackMapFrame {
  public static final int LOWER_RANGE = 0;
  public static final int UPPER_RANGE = 63;
  
  public SameFrame(int frameType) {
    super(frameType);
  }
  
}
