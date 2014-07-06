package datastructures;

import normalformalgorithms.NormalFormAlgorithms;

public abstract class AFunctionalDependency {
	private AttributeJoint antecedent;
	private AttributeJoint consequent;
	
	//Constructors
	public AFunctionalDependency() { };
	
	public AFunctionalDependency(AttributeJoint antecedent, AttributeJoint consequent) {
		this.antecedent = new AttributeJoint(antecedent);
		this.consequent = new AttributeJoint(consequent);
		this.antecedent.removeDuplicatedAttribute();
		this.consequent.removeDuplicatedAttribute();
	}
	
	//Getters
	public AttributeJoint getAntecedent() {
		return antecedent;
	};
	
	public AttributeJoint getConsequent() {
		return consequent;
	};
	
	//Setters
	public void setAntecedent(AttributeJoint antecedent) {
		this.antecedent = antecedent;
	};
	
	public void setConsequent(AttributeJoint consequent) {
		this.consequent = consequent;
	};
	
	//Remove Attribute from AttributeJoints
	public void removeAttributeFromAntecedent(Attribute toBeRemoved){
		removeAttributes(toBeRemoved, this.antecedent);
	};
	
	public void removeAttributeFromAntecedent(AttributeJoint toBeRemoved) {
		removeAttributes(toBeRemoved, antecedent);
	};
	
	public void removeAttributeFromConsequent(Attribute toBeRemoved){
		removeAttributes(toBeRemoved, this.consequent);
	};
	
	public void removeAttributeFromConsequent(AttributeJoint toBeRemoved) {
		removeAttributes(toBeRemoved, this.consequent);
	}
	
	private void removeAttributes(Attribute attributeSearchFor, AttributeJoint searchIn){
		searchIn.removeAttributes(attributeSearchFor);		
	}
	
	private void removeAttributes(AttributeJoint attributeSearchFor, AttributeJoint searchIn){
		searchIn.removeAttributes(attributeSearchFor);		
	}
	
	public abstract String toString();
	
	public boolean isDestroyable() {
		if (antecedent.getSize() == 0 || consequent.getSize() == 0)
			return true;
		return false;
	}
	
	public void clear() {
		this.antecedent.clear();
		this.consequent.clear();
	}

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public boolean belongsTo(DFJoint dfJoint) {
		AttributeJoint equivalentAttrJoint = NormalFormAlgorithms.simpleUllman(this.antecedent, dfJoint);
		return this.consequent.isContained(equivalentAttrJoint);
	}

	public boolean is4NF(Relation relation) {
		AttributeJoint ullmanResult = NormalFormAlgorithms.simpleUllman(this.antecedent, relation.getDFJoint());
		if (!relation.getAttrJoint().equals(ullmanResult))
			return false;
		return true;
	}
	
	public boolean isBCNF(Relation relation) {
		AttributeJoint ullmanResult = NormalFormAlgorithms.simpleUllman(this.antecedent, relation.getDFJoint());
		if (!relation.getAttrJoint().equals(ullmanResult))
			return false;
		return true;
	}

	public boolean is3NF(Relation relation, KeyJoint keyJoint) {
		if (keyJoint == null)
			keyJoint = relation.calculateKeyJoint();
		
		AttributeJoint ullman = NormalFormAlgorithms.simpleUllman(this.antecedent, relation.getDFJoint());
		
		if (!relation.getAttrJoint().equals(ullman) && !this.consequent.isPartOf(keyJoint))
			return false;
		
		return true;
	}

	public boolean is2NF(Relation relation, KeyJoint keyJoint) {
		if (keyJoint == null)
			keyJoint = relation.calculateKeyJoint();
		
		AttributeJoint ullman = NormalFormAlgorithms.simpleUllman(antecedent, relation.getDFJoint());
		if (!relation.getAttrJoint().equals(ullman) &&
				!consequent.isPartOf(keyJoint) &&
				antecedent.isPartOf(keyJoint))
					return false;
		return true;
	}

	public AttributeJoint getAttributeJoint() {
		AttributeJoint attrJoint = new AttributeJoint(this.antecedent);
		attrJoint.addAttributes(consequent);
		return attrJoint;
	}

	public boolean isTrivial() {
		if (this.antecedent.isNull() || this.consequent.isNull())
			return true;
		
		for (Attribute attr : this.consequent)
			if (attr.isContained(this.antecedent))
				return true;
		
		return false;
	}

	public void clearTrivialElements() {
		try {
			AttributeJoint newConsequent = new AttributeJoint();
			for (Attribute attr : this.consequent)
				if (!attr.isContained(this.antecedent))
					newConsequent.addAttributes(attr);
			this.consequent = newConsequent;
		}
		catch (NullPointerException e) { }		
	}
}
