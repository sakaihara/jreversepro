package org.jreversepro.reflect.stackmaptable.frames;

import org.jreversepro.reflect.stackmaptable.StackMapFrame;
import org.jreversepro.reflect.verification.VerificationTypeInfo;

public class LocalOneStackItemFrame extends StackMapFrame {
  public static final int LOWER_RANGE = 64;
  public static final int UPPER_RANGE = 127;
  
  protected final VerificationTypeInfo stack;
  
  public LocalOneStackItemFrame(int frameType, VerificationTypeInfo stack) {
    super(frameType);
    
    this.stack = stack;
  }
  
  public VerificationTypeInfo getStack() {
    return stack;
  }
  
}
