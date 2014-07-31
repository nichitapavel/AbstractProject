package datastructures;

import datastructures.dependency.ADependency;
import datastructures.dependency.FunctionalDependency;
import normalization.Normalization;

public class Attribute implements Comparable<Attribute>{
	private String attribute;

	//Constructors
	public Attribute() { };
	
	public Attribute(String attribute) {
		this.attribute = attribute;
	}
	
	public Attribute(Attribute obj) {
		attribute = obj.getAttribute();
	}
	
	//Getter
	public String getAttribute() {
		return attribute;
	};

	//Setter
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	};
	
	public boolean isNull() {
		if ((attribute == null) || (attribute.length() == 0))
			return true;
		return false;
	}
	
	//HasCode, necessary for equals() method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attribute == null) ? 0 : attribute.hashCode());
		return result;
	}

	//equals(), determines if two objects have same values
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attribute other = (Attribute) obj;
		if (attribute == null || attribute == "") {
			if (other.attribute != null && other.attribute != "")
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		return true;
	}
	
	//Convert Attribute to String
	@Override
	public String toString() {
		return attribute;
	}
	
	public int compareTo(Attribute obj) {
		return attribute.compareTo(obj.getAttribute());
	}
	
	public boolean isContained(AttributeJoint attrJoint) {
		if (attrJoint.getAttributeJoint() == null)
			return false;
		for (Attribute attr : attrJoint.getAttributeJoint())
			if (attr.equals(this))
				return true;
		return false;
	}

	public boolean isRareInAntecedent(ADependency fd, DFJoint dfJoint) {
		AttributeJoint ullman = new AttributeJoint(fd.getAntecedent());
		ullman.removeAttributes(this);
		
		AttributeJoint ullmanResult = Normalization.simpleUllman(ullman, dfJoint);
		
		if (fd.getConsequent().isContained(ullmanResult))
			return true;
		
		return false;
	}

	public boolean isRareInConsequent(ADependency fd, DFJoint dfJoint) {
		AttributeJoint consequent = fd.getConsequent();
		AttributeJoint antecedent = fd.getAntecedent();
		AttributeJoint newConsecuent = new AttributeJoint(consequent);
		newConsecuent.removeAttributes(this);
		
		DFJoint dfJointPrima = new DFJoint(dfJoint);					
		dfJointPrima.removeDF(fd);
		
		ADependency newFD = new FunctionalDependency(antecedent, newConsecuent);
		dfJointPrima.addDependency(newFD);
		
		AttributeJoint ullmanResult = Normalization.simpleUllman(antecedent, dfJointPrima);
		
		if (consequent.isContained(ullmanResult))
			return true;
		return false;
	}
}
