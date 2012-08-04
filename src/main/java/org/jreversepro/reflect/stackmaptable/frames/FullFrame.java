package org.jreversepro.reflect.stackmaptable.frames;

import java.util.List;

import org.jreversepro.reflect.stackmaptable.StackMapFrame;
import org.jreversepro.reflect.verification.VerificationTypeInfo;

public class FullFrame extends StackMapFrame {
  public static final int LOWER_RANGE = 255;
  public static final int UPPER_RANGE = 255;
  
  
  protected final short offsetDelta;
  protected final List<VerificationTypeInfo> locals; 
  protected final List<VerificationTypeInfo> stack;
  
  public FullFrame(int frameType, short offsetDelta, List<VerificationTypeInfo> locals, List<VerificationTypeInfo> stack) {
    super(frameType);
    
    this.offsetDelta = offsetDelta;
    this.locals = locals; 
    this.stack = stack;
  }
  
  public short getOffsetDelta() {
    return offsetDelta;
  }
  
  public List<VerificationTypeInfo> getLocals() {
    return locals;
  }
  
  public List<VerificationTypeInfo> getStack() {
    return stack;
  }
}
