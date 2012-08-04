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
package org.jreversepro.ast.expression;

/**
 *
 * 
 */

import org.apache.commons.lang.StringUtils;
import org.jreversepro.jls.emitter.java14.DefaultSourceEmitter;
import org.jreversepro.reflect.Import;
import org.jreversepro.reflect.LocalVariableTable;
import org.jreversepro.reflect.variabletable.VariableTable;

public class Variable extends Expression {
  /**
   * 
   * @param _varTable
   *          The symbol table within which the variable is going to be live.
   * 
   * @param _jvmType
   *          Type of the variable loaded onto the stack.
   * 
   * @param _variableIndex
   *          index of the variable into the symbol table.
   * @param _instructionIndex
   *          index of the instruction into the bytecode array.
   * 
   */
  public Variable(VariableTable _varTable, String _jvmType, int _variableIndex,
      int _instructionIndex) {
    super(_jvmType, VALUE);
    logger.info("Creating Variable at instruction " + _instructionIndex
        + " with type " + _jvmType + " for variable " + _variableIndex);
    varTable = _varTable;
    instructionIndex = _instructionIndex;
    variableIndex = _variableIndex;

  }

  /**
   * 
   * @param _varTable
   *          The symbol table within which the variable is going to be live.
   * 
   * @param _jvmType
   *          Type of the variable loaded onto the stack.
   * 
   * @param _variableIndex
   *          index of the variable into the symbol table.
   * @param _instructionIndex
   *          index of the instruction into the bytecode array.
   * 
   */
  public Variable(VariableTable _varTable, char _jvmType, int _variableIndex,
      int _instructionIndex) {
    super(_jvmType, VALUE);
    varTable = _varTable;
    instructionIndex = _instructionIndex;
    variableIndex = _variableIndex;

  }

  @Override
  public String getJLSCode() {
    
    // Try to get the optional debug information. if it is there follow the
    // happy path.
    String variableName = varTable.getName(variableIndex, instructionIndex);
    if (null != variableName) {
      
      boolean isResolved = DefaultSourceEmitter.isResolved(DefaultSourceEmitter.getCurrentBlock(), variableName);
      if(!isResolved) {
        String variableType = ((LocalVariableTable)varTable).getType(variableIndex, instructionIndex);
        variableType = StringUtils.removeEnd(variableType, ";");
        variableType = StringUtils.replace(variableType, "/", ".");
        variableType = StringUtils.removeStart(variableType, "L");
        variableType = Import.getClassName(variableType);
        
        return variableType + " " + variableName;
      }
      
      
      
      return variableName;
    }
    
    // If the code was not compiled using debug information, use the Symbol
    // Table for a custom generated name
    return varTable.getName(variableIndex, instructionIndex);
  }

  private final VariableTable varTable;

  private final int variableIndex;

  private final int instructionIndex;

}
