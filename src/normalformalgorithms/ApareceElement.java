package normalformalgorithms;

import java.util.Vector;

import datastructures.Attribute;

public class ApareceElement {
	private Attribute attr;
	private Vector<Integer> intList;
	
	public ApareceElement(Attribute attr) {
		this.attr = new Attribute(attr);
		this.intList = new Vector<Integer>();
	}
	
	public void addIndex(int i) {
		this.intList.add(i);
	}

	public Attribute getAttr() {
		return attr;
	}

	public void setAttr(Attribute attr) {
		this.attr = attr;
	}
	
	public int getSize() {
		return this.intList.size();
	}
	
	public void setElementAt(int index, int number) {
		this.intList.set(index, number);
	}
	
	public int getElementAt(int index) {
		return this.intList.elementAt(index);
	}
	
	public String toString() {
		String msg = attr.toString() + "/" + intList.toString();
		return msg;
	}

	public Vector<Integer> getIntList() {
		return this.intList;
	}
	
}
