/**
 *  @(#) CustomLoggerFactory.java
 *
 * JReversePro - Java Decompiler / Disassembler.
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
 **/
package org.jreversepro;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * Creates a custom logger
 * 
 * @author akkumar
 */
public class CustomLoggerFactory {

  public static Logger createLogger() {
    final Logger logger = Logger.getLogger("JReversePro");
    final SimpleFormatter formatter = new SimpleFormatter();
    final StreamHandler handler = new StreamHandler(System.out, formatter);
    logger.addHandler(handler);
    logger.setLevel(Level.WARNING);
    return logger;
  }

}
