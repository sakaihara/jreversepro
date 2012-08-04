package org.jreversepro.reflect.stackmaptable.frames;

public class SameFrameExtended extends SameFrame {
  public static final int LOWER_RANGE = 251;
  public static final int UPPER_RANGE = 251;

  protected final short offsetDelta;
  public SameFrameExtended(int type, short offsetDelta) {
    super(type);
    
    this.offsetDelta = offsetDelta;
  }
  
  public short getOffsetDelta() {
    return offsetDelta;
  }
}
