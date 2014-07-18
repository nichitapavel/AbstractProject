package datastructures;

import java.util.ArrayList;

import datastructures.dependency.ADependency;
import normalization.Normalization;


public class Relation {
	private AttributeJoint attrJoint;
	private DFJoint dfJoint;

	public Relation() { }

	public Relation(AttributeJoint attrJoint, DFJoint dfJoint) {
		this.attrJoint = new AttributeJoint(attrJoint);
		this.dfJoint = new DFJoint(dfJoint);
	}

	public AttributeJoint getAttrJoint() {
		return this.attrJoint;
	}

	public DFJoint getDFJoint() {
		return this.dfJoint;
	}

	public void settAttrJoint(AttributeJoint attrJoint) {
		this.attrJoint = new AttributeJoint(attrJoint);
	}

	public void setDFJoint(DFJoint dfJoint) {
		this.dfJoint = new DFJoint(dfJoint);
	}

	public boolean isBCNF() {
		try {
			for (ADependency funcDep : this.dfJoint) {
				if (!funcDep.isBCNF(this, null))
					return false;
			}
		}
		catch (NullPointerException ex) { }
		return true;
	};
	
	//toString
	@Override
	public String toString() {
		String noAttr = "Sin Atributos";
		String noFuncDep = "Sin Dependencias Funcionales";
		String msg = "";
		
		if (this.attrJoint != null)
			msg += "Atributos: " + this.attrJoint.toString() + "";
		else
			msg += noAttr;
		
		if (this.dfJoint != null)
			msg += " Dependencias Funcionales: " + this.dfJoint.toString();
		else
			msg += " " + noFuncDep;
		
		if (this.attrJoint == null && this.dfJoint == null)
			return noAttr + " " + noFuncDep;
		
		return msg;
	}

	public KeyJoint calculateKeyJoint() {

		KeyJoint result = new KeyJoint();

		AttributeJoint attrJointToCheck;
		AttributeJoint ullman;

		AttributeJoint nonKeyAttributes = new AttributeJoint();
		
		ArrayList<AttributeJoint> list = new ArrayList<>();
		
		for(Attribute attr : this.attrJoint) {
			attrJointToCheck = new AttributeJoint();
			attrJointToCheck.addAttributes(attr);
			ullman = Normalization.simpleUllman(attrJointToCheck, this.dfJoint);
			if(!ullman.equals(this.attrJoint)) {
				nonKeyAttributes.addAttributes(attr);
				list.add(attrJointToCheck);
			}
			else {
				result.addKey(attrJointToCheck);
			}
		}
		
		int i = 0;
		do {
			AttributeJoint attrJoint = list.get(i);
			Attribute lastAttribute = attrJoint.getLastAttribute();
			
			for (int j = nonKeyAttributes.getAttributePosition(lastAttribute) + 1;
					j < nonKeyAttributes.getSize();
					j++) {
				attrJointToCheck = new AttributeJoint(attrJoint);
				attrJointToCheck.addAttributes(nonKeyAttributes.getAttributeAt(j));
				
				if (!attrJointToCheck.containsJoinsFrom(result)) {
					ullman = Normalization.simpleUllman(attrJointToCheck, this.dfJoint);
					if (ullman.equals(this.attrJoint))
						result.addKey(attrJointToCheck);
					else
						list.add(attrJointToCheck);
				}
			}
			i++;
		} while (i < list.size());

		return result;
	}

	public boolean is3NF() {
		if(this.isBCNF())
			return true;
		
		KeyJoint keyJoint = this.calculateKeyJoint();
		
		for (ADependency funcDep : this.dfJoint) {
			if (!funcDep.is3NF(this, keyJoint))
					return false;
		}
				
		return true;
	}

	public boolean is2NF() {
		if(this.isBCNF() || this.is3NF())
			return true;
		
		KeyJoint keyJoint = this.calculateKeyJoint();
		
		
		for (ADependency funcDep : this.dfJoint) {
			if (!funcDep.is2NF(this, keyJoint))
				return false;
		}
		
		return true;
	}

	public Relation splitByKey(AttributeJoint attrJoint) {
		Relation r = new Relation();
		
		r.settAttrJoint(attrJoint);
		r.setDFJoint(this.dfJoint.projectionOnAttributeJoint(attrJoint));
		
		return r;
	}
	
	
	public ArrayList<Relation> split(ADependency fd) {
		ArrayList<Relation> relationVector = new ArrayList<>();
		
		Relation first = new Relation();
		first.settAttrJoint(fd.getAttributeJoint());
		relationVector.add(first);
		
		first.setDFJoint(this.dfJoint.projectionOnAttributeJoint(fd.getAttributeJoint()));
		
		Relation second = new Relation();
		AttributeJoint newAttrJoint = new AttributeJoint(this.attrJoint);
		newAttrJoint.removeAttributes(fd.getConsequent());
		second.settAttrJoint(newAttrJoint);
		relationVector.add(second);
		
		second.setDFJoint(this.dfJoint.projectionOnAttributeJoint(newAttrJoint));
		
		return relationVector;
	}
	
	public ArrayList<ADependency> getNonBCNF_DFs() {
		return this.dfJoint.getNonBCNF_DFs(this);
	}
	
	public ArrayList<ADependency> getNon3NF_DFs() {
		return this.dfJoint.getNon3NF_DFs(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relation other = (Relation) obj;
		if (attrJoint == null) {
			if (other.attrJoint != null)
				return false;
		} else if (!attrJoint.equals(other.attrJoint))
			return false;
		if (dfJoint == null) {
			if (other.dfJoint != null)
				return false;
		} else if (!dfJoint.equals(other.dfJoint))
			return false;
		return true;
	}
}
