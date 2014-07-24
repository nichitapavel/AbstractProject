package datastructures.dependency;

import java.util.ArrayList;

import datastructures.Attribute;
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
		try {
			return super.antecedent.toString() + " ->> " + super.consequent.toString();			
		}
		catch (NullPointerException ex) { }
		return "null ->> null";
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
		} else if (!super.consequent.equals(other.consequent))
			return false;
		return true;
	}

	@Override
	public boolean isTrivial(Relation relation) {
		if (super.antecedent.isNull() || super.consequent.isNull())
			return true;

		for (Attribute attr : super.consequent)
			if (attr.isContained(super.antecedent))
				return true;

		if (super.antecedent.union(super.consequent).equals(relation.getAttrJoint()))
			return true;
		
		return false;
	}

	@Override
	public void clearTrivialElements() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean belongsTo(DFJoint dfJoint, Relation relation) {
		DFJoint hiddenDF = dfJoint.getHiddenDF().regroupDFJoint();

		//pertenece al conjunto?
		if (hiddenDF.contains(this))
			return true;

		//paso de df a dp
		for (ADependency fd: hiddenDF) {
			if (fd.getClass() != this.getClass()) {
				if (fd.getAntecedent().equals(this.antecedent) &&
						this.consequent.isContained(fd.getConsequent()))
						return true;
			}
		}

		//es el complimentario de alguna del conjunto?
		for (ADependency fd : hiddenDF)
			if (fd.getClass() == this.getClass())
				if (this.antecedent.equals(fd.getAntecedent())) {
					AttributeJoint substract = relation.getAttrJoint().substract(fd.getAttributeJoint());
					if (substract.equals(this.consequent))
						return true;
				}

		return false;
	}

	@Override
	public boolean is2NF(Relation relation, KeyJoint keyJoint) {
		if (keyJoint == null)
			keyJoint = relation.calculateKeyJoint();
		
		if (super.antecedent.containsJoinsFrom(keyJoint) ||
				super.consequent.isPartOf(keyJoint) ||
				!super.antecedent.isPartOf(keyJoint))
			return true;
		return false;
	}

	@Override
	public boolean is3NF(Relation relation, KeyJoint keyJoint) {
		if (keyJoint == null)
			keyJoint = relation.calculateKeyJoint();
		
		if (super.antecedent.containsJoinsFrom(keyJoint) ||
			super.consequent.isPartOf(keyJoint))
			return true;
		return false;
	}

	@Override
	public boolean isBCNF(Relation relation, KeyJoint keyJoint) {
		if (keyJoint == null)
			keyJoint = relation.calculateKeyJoint();
		
		if (super.antecedent.containsJoinsFrom(keyJoint))
			return true;
		return false;
	}

	@Override
	public boolean is4NF(Relation relation, KeyJoint keyJoint) {
		return isBCNF(relation, keyJoint);
	}

	@Override
	public ArrayList<ADependency> toFunctionalDependency(DFJoint dfJoint) {
		ArrayList<ADependency> result = new ArrayList<>();		
		
		AttributeJoint intersect;
		for (ADependency fd : dfJoint) {
			if (fd.getClass() == new FunctionalDependency().getClass()) {
				intersect = fd.getAntecedent().intersect(super.consequent);
				if ( fd.getConsequent().isContained(super.consequent) && intersect.isNull())
					result.add(new FunctionalDependency(super.antecedent, fd.getConsequent()));
			}
		}
		return result;
	}
}
