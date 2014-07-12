package datastructures;

import java.util.ArrayList;
import java.util.Iterator;

public class KeyJoint implements Iterable<AttributeJoint> {
	private ArrayList<AttributeJoint> keyJoint;

	//Constructors
	public KeyJoint() {	}
	
	public KeyJoint(ArrayList<AttributeJoint> keyJoint) {
		this.keyJoint = new ArrayList<>(keyJoint);
	}
	
	//Getter
	public ArrayList<AttributeJoint> getKeyJoint() {
		return this.keyJoint;
	}
	
	//toString()
	public String toString() {
		String msg = "null";
		
		try {
			msg = "{" + this.keyJoint.get(0);
			for (int i = 1; i < this.keyJoint.size(); i++)
				msg += ", " + this.keyJoint.get(i);
			msg += "}";
		}
		catch(NullPointerException e){ }
		
		return msg;
	}
	
	//equals()
	@Override
	public boolean equals(Object keyJoint) {
		if (getClass() != keyJoint.getClass())
			return false;
		else {
			KeyJoint other = (KeyJoint) keyJoint;
			if (this.keyJoint == null && other.keyJoint != null)
				return false;
			if (other.keyJoint == null && this.keyJoint != null)
				return false;
			if (this.keyJoint == null && other.keyJoint == null) 
				return true;
			return this.keyJoint.equals(other.getKeyJoint());
		}
	}

	public void addKey(AttributeJoint key) {
		if (this.keyJoint == null)
			this.keyJoint = new ArrayList<>();
		this.keyJoint.add(key);
	}

	@Override
	public Iterator<AttributeJoint> iterator() {
		return this.keyJoint.iterator();
	}

	public int getSize() {
		try {
			return this.keyJoint.size();			
		}
		catch (NullPointerException e) { }
		return 0;
	}
	
}
