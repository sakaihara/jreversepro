package org.jreversepro.reflect.stackmaptable;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jreversepro.reflect.stackmaptable.frames.AppendFrame;
import org.jreversepro.reflect.stackmaptable.frames.ChopFrame;
import org.jreversepro.reflect.stackmaptable.frames.FullFrame;
import org.jreversepro.reflect.stackmaptable.frames.LocalOneStackItemFrame;
import org.jreversepro.reflect.stackmaptable.frames.LocalOneStackItemFrameExtended;
import org.jreversepro.reflect.stackmaptable.frames.SameFrame;
import org.jreversepro.reflect.stackmaptable.frames.SameFrameExtended;
import org.jreversepro.reflect.verification.VerificationTypeInfo;
import org.jreversepro.reflect.verification.VerificationTypeInfoFactory;



public class StackMapFactory {

  
  private StackMapFactory() {
    //seal
  }
  
  
  public static StackMapTable parseStackMapTable(DataInputStream dis) throws IOException {
    int len = dis.readInt();
    short numEntries = dis.readShort();
    
    
    List<StackMapFrame> frames = new ArrayList<StackMapFrame>(numEntries);
    //parse all of the frames of the table.
    for(int i=0; i<numEntries ; i++) {
      StackMapFrame smf = parseStackMapFrame(dis);
      frames.add(smf);
    }
    
    StackMapTable smt = new StackMapTable(0, frames);
    return smt;
  }
  
  private static StackMapFrame parseStackMapFrame(DataInputStream dis) throws IOException {
    
//    short ex = dis.readShort();
    int type = dis.readUnsignedByte();
    
    //determine if it is within a given range, defining its type.
    if(inRange(type, AppendFrame.LOWER_RANGE, AppendFrame.UPPER_RANGE)) {
      return parseAppendFrame(type, dis);
    }
    else if (inRange(type, ChopFrame.LOWER_RANGE, ChopFrame.UPPER_RANGE)) {
      return parseChopFrame(type, dis);
    }
    else if (inRange(type, FullFrame.LOWER_RANGE, FullFrame.UPPER_RANGE)) {
      return parseFullFrame(type, dis);
    }
    else if(inRange(type, LocalOneStackItemFrame.LOWER_RANGE, LocalOneStackItemFrame.UPPER_RANGE)) {
      return parseLocalOneStackItemFrame(type, dis);
    }
    else if(inRange(type, LocalOneStackItemFrameExtended.LOWER_RANGE, LocalOneStackItemFrameExtended.UPPER_RANGE)) {
      return parseLocalOneStackItemFrameExtended(type, dis);
    }
    else if(inRange(type, SameFrame.LOWER_RANGE, SameFrame.UPPER_RANGE)) {
      return parseSameFrame(type, dis);
    }
    else if(inRange(type, SameFrameExtended.LOWER_RANGE, SameFrameExtended.UPPER_RANGE)) {
      return parseSameFrameExtended(type, dis);
    }
    else {
      throw new IllegalArgumentException("StackMapFrame Type not valid: "+type);
    }
  }
  
  private static AppendFrame parseAppendFrame(int type, DataInputStream dis) throws IOException {
    short offsetDelta = dis.readShort();
    
    int numLocals = type - 251;
    List<VerificationTypeInfo> locals = new ArrayList<VerificationTypeInfo>(numLocals);
    for(int i=0; i<numLocals; i++) {
      locals.add(VerificationTypeInfoFactory.parseVerificationTypeInfo(dis));
    }
    
    AppendFrame smf = new AppendFrame(type, offsetDelta);
    return smf;
  }
  
  private static ChopFrame parseChopFrame(int type, DataInputStream dis) throws IOException {
    short offsetDelta = dis.readShort();

    ChopFrame smf = new ChopFrame(type, offsetDelta);
    return smf;
  }
  
  private static FullFrame parseFullFrame(int type, DataInputStream dis) throws IOException {
    short offsetDelta = dis.readShort();
    short numLocals = dis.readShort();
    
    List<VerificationTypeInfo> locals = new ArrayList<VerificationTypeInfo>(numLocals);
    for(int i=0; i<numLocals; i++) {
      locals.add(VerificationTypeInfoFactory.parseVerificationTypeInfo(dis));
    }
    
    
    short numStackItems = dis.readShort();
    List<VerificationTypeInfo> stack = new ArrayList<VerificationTypeInfo>(numStackItems);
    for(int i=0; i<numStackItems; i++) {
      stack.add(VerificationTypeInfoFactory.parseVerificationTypeInfo(dis));
    }

    FullFrame smf = new FullFrame(type, offsetDelta, locals, stack);
    return smf;
  }
  private static LocalOneStackItemFrame parseLocalOneStackItemFrame(int type, DataInputStream dis) throws IOException {
    VerificationTypeInfo stack = VerificationTypeInfoFactory.parseVerificationTypeInfo(dis);
    
    LocalOneStackItemFrame smf = new LocalOneStackItemFrame(type, stack);
    return smf;
  }
  private static LocalOneStackItemFrameExtended parseLocalOneStackItemFrameExtended(int type, DataInputStream dis) throws IOException {
    short offsetDelta = dis.readShort();
    VerificationTypeInfo stack = VerificationTypeInfoFactory.parseVerificationTypeInfo(dis);

    LocalOneStackItemFrameExtended smf = new LocalOneStackItemFrameExtended(type, offsetDelta, stack);
    return smf;
  }
  
  private static SameFrame parseSameFrame(int type, DataInputStream dis) {
    SameFrame smf = new SameFrame(type);
    return smf;
  }
  private static SameFrameExtended parseSameFrameExtended(int type, DataInputStream dis) throws IOException {
    short offsetDelta = dis.readShort();

    SameFrameExtended smf = new SameFrameExtended(type, offsetDelta); 
    return smf; 
  }


  
  
  
  
  private static boolean inRange(int val, int lower, int upper) {
    return (val >= lower && val <= upper);
  }
}
