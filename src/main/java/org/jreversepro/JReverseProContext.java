/**
 *  * JReversePro - Java Decompiler / Disassembler.
 * Copyright (C) 2008 Karthik Kumar.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *  
 *  	http://www.apache.org/licenses/LICENSE-2.0 
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 

 */
package org.jreversepro;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.jreversepro.output.AbstractOutputter;
import org.jreversepro.output.DecompilerOutputter;
import org.jreversepro.output.DisassemblerOutputter;
import org.jreversepro.parser.ClassFileParser;
import org.jreversepro.parser.ClassFileParserFactory;
import org.jreversepro.parser.ClassParserException;
import org.jreversepro.reflect.ClassInfo;

/**
 * 
 * @author akkumar Karthik Kumar
 * 
 */
public class JReverseProContext {

  public enum OutputType {
    NONE, DISASSEMBLER, DECOMPILER, VIEW_CONSTANTPOOL,
  }
  
  /**
   * Version of the software.
   */
  public static final String VERSION = "1.6.0";

  /**
   * GPL Information.
   */
  public static String GPL_INFO = "// JReversePro v " + VERSION + " "
      + (new Date()) + "\n// http://jrevpro.sourceforge.net"
      + "\n// Copyright (C)2000-2009 Karthik Kumar."
      + "\n// JReversePro comes with ABSOLUTELY NO WARRANTY;"
      + "\n// This is free software, and you are welcome to redistribute"
      + "\n// it under certain conditions;See the File 'COPYING' for "
      + "more details.\n";

  private final Logger logger = CustomLoggerFactory.createLogger();  

  /**
   * 
   * @param pathToClass
   *          Path to the class for which resource needs to be loaded
   * @throws FileNotFoundException
   * @throws ClassParserException
   * @return Returns the Parsed Class information for the class represented by
   *         pathToClass.
   */
  public ClassInfo loadResource(final String pathToClass)
      throws FileNotFoundException, IOException, ClassParserException {
    FileInputStream fis = null;
    ClassInfo info = null;
    try {
      fis = new FileInputStream(pathToClass);
      final DataInputStream dis = new DataInputStream(fis);

      final ClassFileParser cfp = ClassFileParserFactory
          .getClassFileParser(dis);
      info = cfp.parseInputStream(dis, pathToClass);

    } finally {
      IOUtils.closeQuietly(fis);
    }
    return info;
  }

  public String print(final OutputType outputType, final ClassInfo info) {
    AbstractOutputter printer = null;
    switch (outputType) {
    case DISASSEMBLER:
      printer = new DisassemblerOutputter();
      break;
    case DECOMPILER:
      printer = new DecompilerOutputter();
      break;
    }
    return printer.output(info);
  }

  public static void checkJREVersion() {
    if (!VersionChecker.versionCheck()) {
      System.exit(1);
    }
    System.out.println(GPL_INFO);
  }


}
