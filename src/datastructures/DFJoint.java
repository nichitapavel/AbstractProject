package datastructures;

import java.util.Iterator;
import java.util.Vector;

import normalformalgorithms.RareElement;
import datastructures.AFunctionalDependency;

public class DFJoint implements Iterable<AFunctionalDependency> {
	private Vector<AFunctionalDependency> df;
	private String name;

	public DFJoint(Vector<AFunctionalDependency> dfJoint) {
		this.df = new Vector<>(dfJoint);
	}
	
	public DFJoint() {
		this.df = new Vector<AFunctionalDependency>();
	}
	
	public DFJoint(DFJoint dfJoint) {
		this.df = new Vector<>(dfJoint.getDFJoint());
		this.name = dfJoint.getName();
	}

	public void addFunctionalDependency(AFunctionalDependency df) {
		if (!contains(df))
			this.df.add(df);
	}
	
	public Vector<AFunctionalDependency> getDFJoint() {
		return df;
	}

	public void setDFJoint(Vector<AFunctionalDependency> df) {
		this.df = df;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getName() {
		if (this.name == null)
			return "No name";
		return this.name;
	}
	
	public String toString() {
		String msg = "null";
		try {
			msg = "{ (" + this.df.get(0) + ")";
			for (int i = 1; i < this.df.size(); i++){
				msg = msg + ", (" + this.df.get(i) + ")";
			}
			msg += " }";
		}
		catch (ArrayIndexOutOfBoundsException e) { }
		catch (NullPointerException e) { }
		
		return msg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((df == null) ? 0 : df.hashCode());
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
		DFJoint other = (DFJoint) obj;
		if (df == null) {
			if (other.df != null)
				return false;
		} else if (!df.equals(other.df))
			return false;
		return true;
	}

	public int getSize() {
		if (this.df == null)
			return 0;
		return this.df.size();
	}
	
	public Iterator<AFunctionalDependency> iterator() {
		return this.df.iterator();
	}

	public boolean isImplied(DFJoint dfJoint) {
		for (AFunctionalDependency fd : this.df) {
			if (!fd.belongsTo(dfJoint))
				return false;
		}
		return true;
	}
	
	public DFJoint projectionOnAttributeJoint(AttributeJoint attrJoint) {
		DFJoint result = new DFJoint();
		AttributeJoint oldAntecedent;
		AttributeJoint oldConsequent;
		
		for (AFunctionalDependency df : this.df) {
			oldAntecedent = df.getAntecedent();
			oldConsequent = df.getConsequent();
			
			if (oldAntecedent.isContained(attrJoint) && 
					oldConsequent.isContained(attrJoint)) {
				result.addFunctionalDependency(df); // añadir df
			}
			
			if (!oldAntecedent.isContained(attrJoint) && 
					oldConsequent.isContained(attrJoint)) {
				boolean added = false;
				AttributeJoint newAntecedent = oldAntecedent.intersect(attrJoint);
				AttributeJoint substract = oldAntecedent.substract(attrJoint);
				for (AFunctionalDependency dfConsequent : this.df) {
					if (substract.isContained(dfConsequent.getConsequent())) {
						newAntecedent.addAttributes(dfConsequent.getAntecedent());
						added = true;
					}
				}
				
				AFunctionalDependency addDF = new SingleDependency(newAntecedent, oldConsequent);
				addDF.clearTrivialElements();
				
				if (added && !addDF.getAntecedent().isNull()
						&& !addDF.getConsequent().isNull()
						&& addDF.getAntecedent().isContained(attrJoint))
					result.addFunctionalDependency(addDF); // añadir df
			}
			
			if (oldAntecedent.isContained(attrJoint) && 
					!oldConsequent.isContained(attrJoint)) {
				AttributeJoint newConsequent = oldConsequent.intersect(attrJoint);
				
				if (newConsequent.isNull()) {
					AttributeJoint substract = oldConsequent.substract(attrJoint);
					for (AFunctionalDependency dfAntecedent : this.df)
						if (substract.isContained(dfAntecedent.getAntecedent()))
							newConsequent.addAttributes(dfAntecedent.getAntecedent());
				}
				
				AFunctionalDependency addDF = new SingleDependency(oldAntecedent, newConsequent);
				addDF.clearTrivialElements();
				
				if (!addDF.getConsequent().isNull() && newConsequent.isContained(attrJoint))
					result.addFunctionalDependency(addDF); // añadir df
			}
		}
		
		return result;
	}

	public boolean contains(AFunctionalDependency funcDep) {
		for (AFunctionalDependency df : this.df)
			if (df.equals(funcDep))
				return true;
		return false;
	}

	public DFJoint regroupDFJoint() {
		Vector<AFunctionalDependency> copyDFJoint = new Vector<>(this.df); 
		DFJoint regroupedDFJoint = new DFJoint();
		for (int i = 0; i < copyDFJoint.size(); i++) {
			AFunctionalDependency dfI = copyDFJoint.elementAt(i);
			AttributeJoint antecedentI = dfI.getAntecedent();
			AttributeJoint regroupedConsequent = new AttributeJoint(dfI.getConsequent());
			for (int j = i + 1; j < copyDFJoint.size(); j++) {
				AFunctionalDependency dfJ = copyDFJoint.elementAt(j);
				AttributeJoint antecedentJ = dfJ.getAntecedent();
				if (antecedentI.equals(antecedentJ)) {
					regroupedConsequent.addAttributes(dfJ.getConsequent());
					copyDFJoint.remove(j);
					j--;
				}
			}
			regroupedDFJoint.addFunctionalDependency(new SingleDependency(antecedentI, regroupedConsequent));
			copyDFJoint.remove(i);
			i--;
		}
		return regroupedDFJoint;
	}

	public void removeDF(AFunctionalDependency fd) {
		try {
			this.df.remove(fd);
		} catch (NullPointerException ex) { }
	}
	
	public Vector<RareElement> findRareAttributes() {
		Vector<RareElement> rareElVector = new Vector<>();
		
		if (this.df.size() > 1) {
			for(AFunctionalDependency fd : this.df) {
				AttributeJoint antecedent = fd.getAntecedent();
				AttributeJoint consecuent = fd.getConsequent();
				if (antecedent.getSize() != 1) {
					for (Attribute attr : antecedent) {
						if (attr.isRareInAntecedent(fd, this))
							rareElVector.add(new RareElement(attr, fd, this, "Antecedent"));
					}
				}
					
				if (consecuent.getSize() != 1) {	
					for (Attribute attr : consecuent) {
						if (attr.isRareInConsequent(fd, this))
							rareElVector.add(new RareElement(attr, fd, this, "Consequent"));
					}
				}
			}
		}
		
		return rareElVector;
	}
	
	public void removeRareAttributes(boolean auto) { 
		int option = 0;
		 		
		this.df = regroupDFJoint().getDFJoint();
		
		Vector<RareElement> rareAttrVector = findRareAttributes();
		
		while (rareAttrVector.size() != 0) {
			if (!auto) {
				/*
				 * option = get.stdin()
				 */
			}
			
			removeAttribute(rareAttrVector.elementAt(option));
			rareAttrVector = findRareAttributes();
		}
	}

	public void removeAttribute(RareElement rareAttr) {
		int pos = this.df.indexOf(rareAttr.getFD());
		if (rareAttr.getPosition() == "Antecedent")
			this.df.elementAt(pos).removeAttributeFromAntecedent(rareAttr.getAttribute());
		else
			this.df.elementAt(pos).removeAttributeFromConsequent(rareAttr.getAttribute());
		this.df = regroupDFJoint().getDFJoint();
	}
	
	public boolean isMinimal() {
		Vector<RareElement> rareAttributes = findRareAttributes();
		
		if (rareAttributes.size() != 0)
			return false;
		return true;
	}

	public Vector<AFunctionalDependency> getNonBCNF_DFs(Relation relation) {
		Vector<AFunctionalDependency> result = new Vector<>();
		
		for (AFunctionalDependency fd : this.df) {
			if (!fd.isBCNF(relation))
				result.add(fd);
		}
		
		return result;
	}

	public Vector<AFunctionalDependency> getNon3NF_DFs(Relation relation) {
		Vector<AFunctionalDependency> result = new Vector<>();
		
		KeyJoint keyJoint = relation.calculateKeyJoint();
		
		for (AFunctionalDependency fd : this.df) {
			if (!fd.is3NF(relation, keyJoint))
				result.add(fd);
		}
		
		return result;
	}
	
	public AttributeJoint getAttributesDFJoint() {
		AttributeJoint attrJoint = new AttributeJoint();
		for (AFunctionalDependency df : this.df) {
				attrJoint.addAttributes(df.getAntecedent());
				attrJoint.addAttributes(df.getConsequent());
		}
		return attrJoint;
	}
}
