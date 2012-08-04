package org.jreversepro.reflect.stackmaptable.frames;

import org.jreversepro.reflect.verification.VerificationTypeInfo;

public class LocalOneStackItemFrameExtended extends LocalOneStackItemFrame {
  public static final int LOWER_RANGE = 247;
  public static final int UPPER_RANGE = 247;
  
  protected final short offsetDelta;
  
  public LocalOneStackItemFrameExtended(int frameType, short offsetDelta, VerificationTypeInfo stack) {
    super(frameType, stack);
    this.offsetDelta = offsetDelta;
  }
  
  public short getOffsetDelta() {
    return offsetDelta;
  }
  
}
