package se.gu.ltl;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import se.gu.ltl.visitors.LTLVisitor;

public class LTLSince  implements BinaryFormula<LTLFormula>,LTLFormula {

	private final LTLFormula subformula1;
	private final LTLFormula subformula2;

	private final String operator = "S";

	public LTLSince(LTLFormula subformula1, LTLFormula subformula2) {
		super();
		Preconditions.checkNotNull(subformula1, "The first subformula cannot be null");
		Preconditions.checkNotNull(subformula2, "The second subformula cannot be null");
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(LTLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LTLFormula getLeftChild() {
		return subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LTLFormula getRightChild() {
		return subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.subformula1 + ") " + operator + " (" + this.subformula2 + ")";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<LTLFormula> getChildren() {
		Set<LTLFormula> formulae=new HashSet<>();
		formulae.add(subformula1);
		formulae.add(subformula2);
		return formulae;
	}
}
