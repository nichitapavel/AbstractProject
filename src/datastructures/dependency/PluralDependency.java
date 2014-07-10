package datastructures.dependency;

import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.KeyJoint;
import datastructures.Relation;

public class PluralDependency extends ADependency {

	public PluralDependency() {	}

	public PluralDependency(AttributeJoint antecedent, AttributeJoint consequent) {
		super(antecedent, consequent);
	}

	@Override
	public String toString() {
		return super.antecedent.toString() + " ->-> " + super.consequent.toString();
	}

	@Override
	public int hashCode() {		
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((super.antecedent == null) ? 0 : super.antecedent.hashCode());
		result = prime * result
				+ ((super.consequent == null) ? 0 : super.consequent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ADependency other = (ADependency) obj;
		if (super.antecedent == null) {
			if (other.antecedent != null)
				return false;
		} else if (!super.antecedent.equals(other.antecedent))
			return false;
		if (super.consequent == null) {
			if (other.consequent != null)
				return false;
		} else if (super.consequent.equals(other.consequent))
			return false;
		return true;
	}

	@Override
	public boolean isTrivial() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearTrivialElements() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean belongsTo(DFJoint dfJoint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean is2NF(Relation relation, KeyJoint keyJoint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean is3NF(Relation relation, KeyJoint keyJoint) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBCNF(Relation relation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean is4NF(Relation relation) {
		// TODO Auto-generated method stub
		return false;
	}
}
