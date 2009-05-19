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
package net.sf.jrevpro.ast.block;

import net.sf.jrevpro.ast.expression.ConditionExpression;

public class ConditionalBlock extends Block {

	public enum ConditionalType {
		CONDITION_IF, CONDITION_ELSE_IF, CONDITION_RETURN
	};

	public ConditionalBlock(Block _parent, ConditionExpression _expr,
			ConditionalType _type) {
		super(_parent);
		expr = _expr;
		type = _type;
	}

	private ConditionExpression expr;

	private ConditionalType type;

}