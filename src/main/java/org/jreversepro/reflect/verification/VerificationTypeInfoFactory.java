package org.jreversepro.reflect.verification;

import java.io.DataInputStream;
import java.io.IOException;

import org.jreversepro.reflect.verification.types.DoubleVariableInfo;
import org.jreversepro.reflect.verification.types.FloatVariableInfo;
import org.jreversepro.reflect.verification.types.IntegerVariableInfo;
import org.jreversepro.reflect.verification.types.LongVariableInfo;
import org.jreversepro.reflect.verification.types.NullVariableInfo;
import org.jreversepro.reflect.verification.types.ObjectVariableInfo;
import org.jreversepro.reflect.verification.types.TopVariableInfo;
import org.jreversepro.reflect.verification.types.UninitializedThisVariableInfo;
import org.jreversepro.reflect.verification.types.UninitializedVariableInfo;

public class VerificationTypeInfoFactory {

  public static VerificationTypeInfo parseVerificationTypeInfo(DataInputStream dis) throws IOException {
    byte vti = dis.readByte();
    
    if(vti == 0) {
      return new TopVariableInfo(vti);
    }
    else if(vti == 1) {
      return new IntegerVariableInfo(vti);
    }
    else if(vti == 2) {
      return new FloatVariableInfo(vti);
    }
    else if(vti == 4) {
      return new LongVariableInfo(vti);
    }
    else if(vti == 3) {
      return new DoubleVariableInfo(vti);
    }
    else if(vti == 5) {
      return new NullVariableInfo(vti);
    }
    else if(vti == 6) {
      return new UninitializedThisVariableInfo(vti);
    }
    else if(vti == 7) {
      short clazzPoolIndex = dis.readShort();
      return new ObjectVariableInfo(vti, clazzPoolIndex);
    }
    else if(vti == 8) {
      return new UninitializedVariableInfo(vti);
    }
    else {
      throw new IllegalStateException("Verification type should not be outside of 0-8");
    }
    
  }
}
