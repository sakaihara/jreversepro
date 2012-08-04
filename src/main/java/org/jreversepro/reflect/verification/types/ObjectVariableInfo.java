package org.jreversepro.reflect.verification.types;

import org.jreversepro.reflect.verification.VerificationTypeInfo;

public class ObjectVariableInfo extends VerificationTypeInfo {

  protected short clazzPoolIndex;
  
  public ObjectVariableInfo(byte itemTop, short clazzPoolIndex) {
    super(itemTop);
    this.clazzPoolIndex = clazzPoolIndex;
  }
  
  public short getClazzPoolIndex() {
    return clazzPoolIndex;
  }
}
