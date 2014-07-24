package datastructures.dependency;

import java.util.ArrayList;

import normalization.Normalization;
import datastructures.AttributeJoint;
import datastructures.Attribute;
import datastructures.DFJoint;
import datastructures.KeyJoint;
import datastructures.Relation;

public class FunctionalDependency extends PluralDependency {

	public FunctionalDependency() {
		super();
	};

	public FunctionalDependency(AttributeJoint antecedent, AttributeJoint consequent) {
		super(antecedent, consequent);
	};

	@Override
	public String toString() {
		try {
			return super.antecedent.toString() + " -> " + super.consequent.toString();			
		}
		catch (NullPointerException ex) { };
		return "null -> null";
	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((super.antecedent == null) ? 0 : super.antecedent.hashCode());
		result = prime * result
				+ ((super.consequent == null) ? 0 : super.consequent.hashCode());
		return result;
	};

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
		} else if (!super.consequent.equals(other.consequent))
			return false;
		return true;
	};

	@Override
	public boolean isTrivial(Relation relation) {
		if (super.antecedent.isNull() || super.consequent.isNull())
			return true;

		for (Attribute attr : super.consequent)
			if (attr.isContained(super.antecedent))
				return true;

		return false;
	};

	@Override
	public void clearTrivialElements() {
		try {
			AttributeJoint newConsequent = new AttributeJoint();
			for (Attribute attr : super.consequent)
				if (!attr.isContained(super.antecedent))
					newConsequent.addAttributes(attr);
			super.consequent = newConsequent;
		}
		catch (NullPointerException e) { }
	};

	@Override
	public boolean belongsTo(DFJoint dfJoint, Relation relation) {
		DFJoint hiddenDF = dfJoint.getHiddenDF();
		AttributeJoint equivalentAttrJoint = Normalization.simpleUllman(super.antecedent, hiddenDF);
		return super.consequent.isContained(equivalentAttrJoint);
	};

	@Override
	public boolean is2NF(Relation relation, KeyJoint keyJoint) {
		if (keyJoint == null)
			keyJoint = relation.calculateKeyJoint();

		AttributeJoint ullman = Normalization.simpleUllman(super.antecedent, relation.getDFJoint());
		if (!relation.getAttrJoint().equals(ullman) &&
				!super.consequent.isPartOf(keyJoint) &&
				super.antecedent.isPartOf(keyJoint))
					return false;
		return true;
	};

	@Override
	public boolean is3NF(Relation relation, KeyJoint keyJoint) {
		if (keyJoint == null)
			keyJoint = relation.calculateKeyJoint();

		AttributeJoint ullman = Normalization.simpleUllman(super.antecedent, relation.getDFJoint());

		if (!relation.getAttrJoint().equals(ullman) && !super.consequent.isPartOf(keyJoint))
			return false;

		return true;
	};
	
	@Override
	public boolean isBCNF(Relation relation, KeyJoint keyJoint) {
		AttributeJoint ullmanResult = Normalization.simpleUllman(super.antecedent, relation.getDFJoint());
		if (!relation.getAttrJoint().equals(ullmanResult))
			return false;
		return true;
	};

	@Override
	public boolean is4NF(Relation relation, KeyJoint keyJoint) {
		return isBCNF(relation, null);
	};
	
	@Override
	public ArrayList<ADependency> toFunctionalDependency(DFJoint dfJoint) {
		ArrayList<ADependency> result = new ArrayList<>();
		result.add(this);
		return result;
	}
}