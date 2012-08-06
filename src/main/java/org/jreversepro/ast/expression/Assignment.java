/**
 *  @(#) Assignment.java
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
package org.jreversepro.ast.expression;

import org.apache.commons.lang.StringUtils;
import org.jreversepro.jls.JLSConstants;
import org.jreversepro.jls.emitter.java14.DefaultSourceEmitter;
import org.jreversepro.reflect.Import;
import org.jreversepro.reflect.LocalVariableTable;

/**
 * @author akkumar
 * 
 */
public class Assignment extends Expression {

  private final Expression lhs;

  private final Expression rhs;
  
  /**
   * @param _lhs L.H.S of the given expression
   * @param _rhs R.H.S of the given expression
   * 
   */
  public Assignment(Expression _lhs, Expression _rhs) {
    super(_rhs.getType(), L_EVAL);
    lhs = _lhs;
    rhs = _rhs;
  }

  /*
   * (non-Javadoc)
   * 
   * @see net.sf.jrevpro.jls.expression.Expression#getJLSRepresentation()
   */
  @Override
  public String getJLSCode() {
    
    String lhsVal = lhs.getJLSCode();

    //this checks to see whether the variable has been resolved, and if not, it puts the name of the variable type in
    //front of the variable.  Ex:  *VariableType* var = ...
    if(lhs instanceof Variable) {
      Variable varLhs = (Variable)lhs;
      String variableName = varLhs.getVarTable().getName(varLhs.getVariableIndex(), varLhs.getInstructionIndex());
      if (null != variableName) {
        boolean isResolved = DefaultSourceEmitter.isResolved(DefaultSourceEmitter.getCurrentBlock(), variableName);
        if(!isResolved) {
          DefaultSourceEmitter.setResolved(DefaultSourceEmitter.getCurrentBlock(), variableName);
          String variableType = ((LocalVariableTable)varLhs.getVarTable()).getType(varLhs.getVariableIndex(), varLhs.getInstructionIndex());
          variableType = StringUtils.removeEnd(variableType, ";");
          variableType = StringUtils.replace(variableType, "/", ".");
          variableType = StringUtils.removeStart(variableType, "L");
          variableType = Import.getClassName(variableType);
          
          lhsVal = variableType + " " + variableName;
        }
      }
    }
    else if(lhs instanceof StaticFieldAccessExpression) {
      //determine if the static field is the same class.  remove reference to the class.
      
      
    }
    
    
    return lhsVal + JLSConstants.EQUALTO + rhs.getJLSCode();

  }



}
