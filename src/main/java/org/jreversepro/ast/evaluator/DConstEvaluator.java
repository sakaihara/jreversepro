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
package org.jreversepro.ast.evaluator;


import java.util.Arrays;

import org.jreversepro.ast.expression.Constant;
import org.jreversepro.reflect.instruction.Instruction;


public class DConstEvaluator extends AbstractInstructionEvaluator {

  public DConstEvaluator(EvaluatorContext context) {
    super(context);
  }

  @Override
  void evaluate(Instruction ins) {
    switch (ins.opcode) {
    case OPCODE_DCONST_0: {
      evalMachine.push(Constant.DOUBLE_0);
      break;
    }
    case OPCODE_DCONST_1: {
      evalMachine.push(Constant.DOUBLE_1);
      break;
    }
    default:
      throw new RuntimeException("Opcode " + ins.opcode + " not supported");
    }
  }

  @Override
  Iterable<Integer> getProcessingOpcodes() {
    return Arrays.asList(OPCODE_DCONST_0, OPCODE_DCONST_1);
  }

}
