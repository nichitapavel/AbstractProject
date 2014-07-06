package datastructures;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import normalformalgorithms.NormalFormAlgorithms;

public class AttributeJoint implements Iterable<Attribute> {
	private Vector<Attribute> joint;
	
	//Constructors
	public AttributeJoint() { };
	
	public AttributeJoint(String [] stringArray) {
		joint = new Vector<Attribute>();
		for (String attr : stringArray)
			joint.addElement(new Attribute(attr));
		sort();
	}
	
	public AttributeJoint(Vector<Attribute> joint) {
		this.joint = new Vector<Attribute>(joint) ;
		sort();
	}
	
	public AttributeJoint(AttributeJoint obj) {
		joint = new Vector<Attribute>(obj.getAttributeJoint());
	}
	
	//Getter
	public Vector<Attribute> getAttributeJoint() {
		return this.joint;
	}
	
	public void setAttributeJoint(Vector<Attribute> joint) {
		this.joint = new Vector<Attribute>(joint);
	}

	//Remove Duplicated Attribute
	public void removeDuplicatedAttribute() {
		int j;
		for (int i = 0; i < joint.size(); i++){
			j = i + 1;
			while (j < joint.size()) {
				if (joint.elementAt(i).equals(joint.elementAt(j))) {
					joint.remove(j);
					j--;
				}
				j++;
			}
		}
	}
	
	//Object to String
	public String toString() {
		
		if (this.joint == null || this.joint.size() == 0)
			return "null";
		
		String stringJoint = "{" + joint.firstElement().toString();
		for (int i = 1; i < joint.size(); i++)
			stringJoint = stringJoint + ", " + joint.elementAt(i).toString();
		return stringJoint + "}";
	}
	
	//HasCode, necessary for equals() method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joint == null) ? 0 : joint.hashCode());
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
		AttributeJoint other = (AttributeJoint) obj;
		if (joint == null) {
			if (other.joint != null)
				return false;
		} else if (!joint.equals(other.joint))
			return false;
		return true;
	}

	//
	public boolean isContained(AttributeJoint attr) {
		if (attr.getAttributeJoint() == null || joint == null)
			return false;
		
		for (Attribute attribute : joint){
			if (attr.getAttributeJoint().indexOf(attribute) == -1)
				return false;
		}
		return true;
	}
	
	//Add a new Attribute or AttributeJoint at the end of current join
	public void addAttributes(Attribute attr) {
		//Attribute newAttr = 
		if (joint == null)
			joint = new Vector<Attribute>();
		
		if (joint.indexOf(attr) == -1)
			joint.addElement(attr);
		
		sort();
	}
	
	public void addAttributes(AttributeJoint attrJoint) {
		if (joint == null)
			joint = new Vector<Attribute>();
		
		if (attrJoint.getAttributeJoint() != null)		
			for (Attribute attr : attrJoint)
				addAttributes(attr);
	}

	public int getSize() {
		try {
			return this.joint.size();			
		}
		catch (NullPointerException ex) { };
		return 0;
		
	}

	public void clear() {
		this.joint.clear();
	}


	public void removeAttributes(Attribute attr) {
		if (joint == null)
			{}
		else
			joint.remove(attr);
	}

	public void removeAttributes(AttributeJoint removedJoint) {
		for (Attribute attr : removedJoint.getAttributeJoint())
			removeAttributes(attr);
	}

	public void sort() {
		Collections.sort(joint);
	}

	
	public Iterator<Attribute> iterator() {
		return this.joint.iterator();
	}

	public Attribute getAttributeAt(int position) {
		return this.joint.get(position);
	}

	public void changeAttributeAt(int i, Attribute attr) {
		this.joint.set(i, attr);
	}

	public AttributeJoint union(AttributeJoint attrJoint) {
		AttributeJoint result = new AttributeJoint();
		result.addAttributes(this);
		result.addAttributes(attrJoint);
		return result;
	}

	public Attribute getLastAttribute() {
		try {
			return this.joint.lastElement();
		}
		catch (NullPointerException ex) { }
		
		return null;
	}

	public int getAttributePosition(Attribute attribute) {
		if (this.joint == null)
			return -1;
		
		for (int i = 0; i < this.joint.size(); i++)
			if (attribute.equals(this.joint.elementAt(i)))
				return i;
		return -1;
	}
	
	//isPartOf in a KeyJoint
	public boolean isPartOf(KeyJoint keyJoint) {
		
		if (keyJoint.getKeyJoint() == null)
			return false;
		
		for (AttributeJoint key : keyJoint)
			if (this.isContained(key))
				return true;
		return false;
	}
	
	//isKey in a relation
	/*
	 * -1 is not key
	 * 0  superkey
	 * +1 key
	 */
	public int isKey(Relation relation) {
		AttributeJoint ullman = NormalFormAlgorithms.simpleUllman(this, relation.getDFJoint());
		KeyJoint keyJoint = relation.calculateKeyJoint();
		
		if (ullman.equals(relation.getAttrJoint()))
			if(this.isPartOf(keyJoint))
				return 1;
			else
				return 0;
		return -1;
	}
	
	//isSubJoint in a KeyJoint
	public boolean containsJoinsFrom(KeyJoint keyJoint) {
		
		if (keyJoint.getKeyJoint() == null)
			return false;
		
		for (AttributeJoint key : keyJoint)
			if (key.isContained(this))
				return true;
		return false;
	}

	public AttributeJoint intersect(AttributeJoint consequent) {
		try {
			AttributeJoint resultAttrJoint = new AttributeJoint();
			
			Vector<Attribute> auxJoint = new Vector<>(this.joint);
			auxJoint.retainAll(consequent.getAttributeJoint());
			
			resultAttrJoint.setAttributeJoint(auxJoint);
			return resultAttrJoint;			
		}
		catch (NullPointerException ex) { }
		return new AttributeJoint();
	}

	public AttributeJoint substract(AttributeJoint attrJoint) {
		try {
			AttributeJoint resultAttrJoint = new AttributeJoint();
			
			Vector<Attribute> auxJoint = new Vector<>(this.joint);
			auxJoint.removeAll(attrJoint.getAttributeJoint());
			
			resultAttrJoint.setAttributeJoint(auxJoint);
			return resultAttrJoint;			
		}
		catch (NullPointerException ex) { }
		return new AttributeJoint();
	}
	
	public boolean isNull() {
		if (this.joint == null || this.joint.size() == 0)
			return true;
		return false;
	}
}
