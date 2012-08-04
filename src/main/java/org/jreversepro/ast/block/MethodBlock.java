/**
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
 * 
 */
package org.jreversepro.ast.block;

import java.util.Map;


public class MethodBlock extends Block {

  protected Map<String, Boolean> localVariableInitialized;
  
  public MethodBlock(int lengthOfByteArray) {
    // There is no parent for this - because it is the main block
    super(null);
    this.lengthOfByteArray = lengthOfByteArray;
  }
  
  public Map<String, Boolean> getLocalVariableInitialized() {
    return localVariableInitialized;
  }

  @Override
  public int endOfBlock() {
    return lengthOfByteArray;
  }

  private final int lengthOfByteArray;

}
