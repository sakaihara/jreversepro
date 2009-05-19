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
package net.sf.jrevpro.ast.evaluator;

import net.sf.jrevpro.ast.intermediate.LineOfCodeList;
import net.sf.jrevpro.reflect.ConstantPool;
import net.sf.jrevpro.reflect.variabletable.VariableTable;

public class EvaluatorContext {

	public EvaluatorContext(ConstantPool _pool, VariableTable _varTable) {

		pool = _pool;
		varTable = _varTable;
		opStack = new EvaluatorStack();
		statements = new LineOfCodeList();
	}

	public void setPreviousOpcode(int opcode) {
		opStack.setPreviousOpcode(opcode);
	}

	public LineOfCodeList getStatements() {
		return statements;
	}

	LineOfCodeList statements;
	ConstantPool pool;
	VariableTable varTable;
	EvaluatorStack opStack;

}