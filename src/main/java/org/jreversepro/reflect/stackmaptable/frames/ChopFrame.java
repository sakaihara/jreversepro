package org.jreversepro.reflect.stackmaptable.frames;

import org.jreversepro.reflect.stackmaptable.StackMapFrame;

public class ChopFrame extends StackMapFrame {
  public static final int LOWER_RANGE = 248;
  public static final int UPPER_RANGE = 250;
  
  protected final short offsetDelta;
  
  public ChopFrame(int frameType, short offsetDelta) {
    super(frameType);
    this.offsetDelta = offsetDelta;
  }
}
