/**
 * Copyright (C) SEI, PKU, PRC. - All Rights Reserved.
 * Unauthorized copying of this file via any medium is
 * strictly prohibited Proprietary and Confidential.
 * Written by Jiajun Jiang<jiajun.jiang@pku.edu.cn>.
 */

package cofix.core.match;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.Statement;

import cofix.common.util.Pair;

public class ASTMatcher {
	
	private ASTNode source = null; 
	private List<Strategy> strategies = null;
	
	public ASTMatcher(ASTNode astNode) {
		this.source = astNode;
	}
	
	public void setStrategies(List<Strategy> stys){
		this.strategies = stys;
	}
	
	public void addStrategy(Strategy sty){
		this.strategies.add(sty);
	}
	
	public float match(Expression exp, Expression otherExp){
		float similarScore = 0.0f;
		for(Strategy strategy : strategies){
			similarScore += strategy.match(exp, otherExp);
		}
		return similarScore;
	}
	
	public float match(Statement statement, Statement otherStatement){
		float similarScore = 0.0f;
		for(Strategy strategy : strategies){
			similarScore += strategy.match(statement, otherStatement);
		}
		return similarScore;
	}
	
	public Pair<ASTNode, Float> match(CompilationUnit compilationUnit){

		return new Pair<>();
	}
	
}