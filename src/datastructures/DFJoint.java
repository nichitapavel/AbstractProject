package datastructures;

import java.util.ArrayList;
import java.util.Iterator;

import datastructures.dependency.ADependency;
import datastructures.dependency.FunctionalDependency;

public class DFJoint implements Iterable<ADependency> {
	private ArrayList<ADependency> df;
	private String name;

	public DFJoint(ArrayList<ADependency> dfJoint) {
		this.df = new ArrayList<>(dfJoint);
	}
	
	public DFJoint() {
		this.df = new ArrayList<>();
	}
	
	public DFJoint(DFJoint dfJoint) {
		this.df = new ArrayList<>(dfJoint.getDFJoint());
		this.name = dfJoint.getName();
	}

	public void addFunctionalDependency(ADependency df) {
		if (!contains(df))
			this.df.add(df);
	}
	
	public ArrayList<ADependency> getDFJoint() {
		return df;
	}

	public void setDFJoint(ArrayList<ADependency> df) {
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
		catch (IndexOutOfBoundsException e) { }
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
	
	public Iterator<ADependency> iterator() {
		return this.df.iterator();
	}

	public boolean isImplied(DFJoint dfJoint) {
		for (ADependency fd : this.df) {
			if (!fd.belongsTo(dfJoint))
				return false;
		}
		return true;
	}
	
	public DFJoint projectionOnAttributeJoint(AttributeJoint attrJoint) {
		DFJoint result = new DFJoint();
		AttributeJoint oldAntecedent;
		AttributeJoint oldConsequent;
		
		for (ADependency df : this.df) {
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
				for (ADependency dfConsequent : this.df) {
					if (substract.isContained(dfConsequent.getConsequent())) {
						newAntecedent.addAttributes(dfConsequent.getAntecedent());
						added = true;
					}
				}
				
				ADependency addDF = new FunctionalDependency(newAntecedent, oldConsequent);
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
					for (ADependency dfAntecedent : this.df)
						if (substract.isContained(dfAntecedent.getAntecedent()))
							newConsequent.addAttributes(dfAntecedent.getAntecedent());
				}
				
				ADependency addDF = new FunctionalDependency(oldAntecedent, newConsequent);
				addDF.clearTrivialElements();
				
				if (!addDF.getConsequent().isNull() && newConsequent.isContained(attrJoint))
					result.addFunctionalDependency(addDF); // añadir df
			}
		}
		
		return result;
	}

	public boolean contains(ADependency funcDep) {
		for (ADependency df : this.df)
			if (df.equals(funcDep))
				return true;
		return false;
	}

	public DFJoint regroupDFJoint() {
		ArrayList<ADependency> copyDFJoint = new ArrayList<>(this.df); 
		DFJoint regroupedDFJoint = new DFJoint();
		for (int i = 0; i < copyDFJoint.size(); i++) {
			ADependency dfI = copyDFJoint.get(i);
			AttributeJoint antecedentI = dfI.getAntecedent();
			AttributeJoint regroupedConsequent = new AttributeJoint(dfI.getConsequent());
			for (int j = i + 1; j < copyDFJoint.size(); j++) {
				ADependency dfJ = copyDFJoint.get(j);
				AttributeJoint antecedentJ = dfJ.getAntecedent();
				if (antecedentI.equals(antecedentJ)) {
					regroupedConsequent.addAttributes(dfJ.getConsequent());
					copyDFJoint.remove(j);
					j--;
				}
			}
			regroupedDFJoint.addFunctionalDependency(new FunctionalDependency(antecedentI, regroupedConsequent));
			copyDFJoint.remove(i);
			i--;
		}
		return regroupedDFJoint;
	}

	public void removeDF(ADependency fd) {
		try {
			this.df.remove(fd);
		} catch (NullPointerException ex) { }
	}
	
	public ArrayList<RareElement> findRareAttributes() {
		ArrayList<RareElement> rareElVector = new ArrayList<>();
		
		if (this.df.size() > 1) {
			for(ADependency fd : this.df) {
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
		
		ArrayList<RareElement> rareAttrVector = findRareAttributes();
		
		while (rareAttrVector.size() != 0) {
			if (!auto) {
				/*
				 * option = get.stdin()
				 */
			}
			
			removeAttribute(rareAttrVector.get(option));
			rareAttrVector = findRareAttributes();
		}
	}

	public void removeAttribute(RareElement rareAttr) {
		int pos = this.df.indexOf(rareAttr.getFD());
		if (rareAttr.getPosition() == "Antecedent")
			this.df.get(pos).removeAttributeFromAntecedent(rareAttr.getAttribute());
		else
			this.df.get(pos).removeAttributeFromConsequent(rareAttr.getAttribute());
		this.df = regroupDFJoint().getDFJoint();
	}
	
	public boolean isMinimal() {
		ArrayList<RareElement> rareAttributes = findRareAttributes();
		
		if (rareAttributes.size() != 0)
			return false;
		return true;
	}

	public ArrayList<ADependency> getNonBCNF_DFs(Relation relation) {
		ArrayList<ADependency> result = new ArrayList<>();
		
		for (ADependency fd : this.df) {
			if (!fd.isBCNF(relation))
				result.add(fd);
		}
		
		return result;
	}

	public ArrayList<ADependency> getNon3NF_DFs(Relation relation) {
		ArrayList<ADependency> result = new ArrayList<>();
		
		KeyJoint keyJoint = relation.calculateKeyJoint();
		
		for (ADependency fd : this.df) {
			if (!fd.is3NF(relation, keyJoint))
				result.add(fd);
		}
		
		return result;
	}
	
	public AttributeJoint getAttributesDFJoint() {
		AttributeJoint attrJoint = new AttributeJoint();
		for (ADependency df : this.df) {
				attrJoint.addAttributes(df.getAntecedent());
				attrJoint.addAttributes(df.getConsequent());
		}
		return attrJoint;
	}
	
	public boolean isEquivalent(DFJoint dfJoint) {
		if (this.isImplied(dfJoint) && dfJoint.isImplied(this))
			return true;
		return false;		
	}
}
