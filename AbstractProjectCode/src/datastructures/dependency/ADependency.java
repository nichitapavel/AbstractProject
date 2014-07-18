package datastructures.dependency;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.KeyJoint;
import datastructures.Relation;

public abstract class ADependency {
	protected AttributeJoint antecedent;
	protected AttributeJoint consequent;
	
	//Constructors
	public ADependency() { };
	
	public ADependency(AttributeJoint antecedent, AttributeJoint consequent) {
		this.antecedent = new AttributeJoint(antecedent);
		this.consequent = new AttributeJoint(consequent);
		this.antecedent.removeDuplicatedAttribute();
		this.consequent.removeDuplicatedAttribute();
	}
	
	//Getters
	public AttributeJoint getAntecedent() {
		return this.antecedent;
	};
	
	public AttributeJoint getConsequent() {
		return this.consequent;
	};
	
	//Setters
	public void setAntecedent(AttributeJoint antecedent) {
		this.antecedent = antecedent;
	};
	
	public void setConsequent(AttributeJoint consequent) {
		this.consequent = consequent;
	};
	
	//Remove Attribute from AttributeJoints
	public void removeAttributeFromAntecedent(Attribute attr){
		removeAttributes(attr, this.antecedent);
	};
	
	public void removeAttributeFromAntecedent(AttributeJoint attr) {
		removeAttributes(attr, antecedent);
	};
	
	public void removeAttributeFromConsequent(Attribute attr){
		removeAttributes(attr, this.consequent);
	};
	
	public void removeAttributeFromConsequent(AttributeJoint attr) {
		removeAttributes(attr, this.consequent);
	}
	
	private void removeAttributes(Attribute attr, AttributeJoint attrJoint){
		attrJoint.removeAttributes(attr);		
	}
	
	private void removeAttributes(AttributeJoint attr, AttributeJoint attrJoint){
		attrJoint.removeAttributes(attr);		
	}
	
	public boolean isDestroyable() {
		if (antecedent.getSize() == 0 || consequent.getSize() == 0)
			return true;
		return false;
	}
	
	public void clear() {
		this.antecedent.clear();
		this.consequent.clear();
	}

	public AttributeJoint getAttributeJoint() {
		AttributeJoint attrJoint = new AttributeJoint(this.antecedent);
		attrJoint.addAttributes(consequent);
		return attrJoint;
	}

	public abstract boolean isTrivial(Relation relation);

	public abstract void clearTrivialElements();
	
	public abstract String toString();
	
	public abstract int hashCode();

	public abstract boolean equals(Object obj);
	
	public abstract FunctionalDependency toFunctionalDependency(DFJoint dfJoint);
	
	public abstract boolean belongsTo(DFJoint dfJoint);

	public abstract boolean is2NF(Relation relation, KeyJoint keyJoint);
	
	public abstract boolean is3NF(Relation relation, KeyJoint keyJoint);
	
	public abstract boolean isBCNF(Relation relation);

	public abstract boolean is4NF(Relation relation);
}
