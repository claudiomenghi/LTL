package se.gu.ltl.atoms;

import java.util.HashSet;
import java.util.Set;

import se.gu.ltl.LTLFormula;
import se.gu.ltl.visitors.LTLVisitor;

public class LTLPAAtom extends PAAtom implements LTLFormula {

	
	public LTLPAAtom(PAAtom atom){
		super(atom.getRobotName(), atom.getActionName());
	}
	public LTLPAAtom(String robotName, String actionName) {
		super(robotName, actionName);
	}
	
	@Override
	public Set<LTLFormula> getChildren() {

		Set<LTLFormula> formulae = new HashSet<>();
		formulae.add(this);
		return formulae;
	}

	@Override
	public <T> T accept(LTLVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
