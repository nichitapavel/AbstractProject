package datastructures;

import datastructures.dependency.ADependency;

public class RareElement {
	private Attribute attr;
	private ADependency fd;
	private DFJoint dfJoint;
	private String position;
	
	public RareElement() {}

	public RareElement(Attribute attr, ADependency fd, DFJoint dfJoint, String position) {
		this.attr = new Attribute(attr);
		this.fd = fd;
		this.dfJoint = new DFJoint(dfJoint);
		this.position = position;
	}
	
	public Attribute getAttribute() {
		return this.attr;
	}

	public ADependency getFD() {
		return this.fd;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RareElement other = (RareElement) obj;
		if (attr == null) {
			if (other.attr != null)
				return false;
		} else if (!attr.equals(other.attr))
			return false;
		if (dfJoint == null) {
			if (other.dfJoint != null)
				return false;
		} else if (!dfJoint.equals(other.dfJoint))
			return false;
		if (fd == null) {
			if (other.fd != null)
				return false;
		} else if (!fd.equals(other.fd))
			return false;
		return true;
	}

	public DFJoint getDFJoint() {
		return this.dfJoint;
	};
	
	public String getPosition() {
		return this.position;
	}
	
	@Override
	public String toString() {
		if (this.attr != null)
			return "//** " + this.attr.toString() + ", " + this.position + ", "
				+ this.fd.toString() + ", " + this.dfJoint.getName();
		return "Null";
	}

}
