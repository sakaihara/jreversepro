package org.jreversepro.reflect.stackmaptable;

public abstract class StackMapFrame {
  
  protected final int frameType;
  
  public StackMapFrame(int frameType) {
    this.frameType = frameType;
  }
  
  public int getFrameType() {
    return frameType;
  }
  
  
}
