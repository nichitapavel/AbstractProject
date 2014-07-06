package datastructures;

import datastructures.AFunctionalDependency;
import datastructures.AttributeJoint;

public class PluralDependency extends AFunctionalDependency {

	public PluralDependency() {	}

	public PluralDependency(AttributeJoint antecedent, AttributeJoint consequent) {
		super(antecedent, consequent);
	}

	@Override
	public String toString() {
		return super.getAntecedent().toString() + " ->-> " + super.getConsequent().toString();
	}

	@Override
	public int hashCode() {
		AttributeJoint antecedent = super.getAntecedent();
		AttributeJoint consequent = super.getConsequent();
		
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((antecedent == null) ? 0 : antecedent.hashCode());
		result = prime * result
				+ ((consequent == null) ? 0 : consequent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		AttributeJoint antecedent = super.getAntecedent();
		AttributeJoint consequent = super.getConsequent();
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AFunctionalDependency other = (AFunctionalDependency) obj;
		if (antecedent == null) {
			if (other.getAntecedent() != null)
				return false;
		} else if (!antecedent.equals(other.getAntecedent()))
			return false;
		if (consequent == null) {
			if (other.getConsequent() != null)
				return false;
		} else if (!consequent.equals(other.getConsequent()))
			return false;
		return true;
	}

}
