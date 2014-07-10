package datastructuretests.rareelements;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.Attribute;
import datastructures.DFJoint;
import datastructures.RareElement;
import datastructures.dependency.ADependency;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RareElementTests {
	private RareElement rareElement;
	private RareElement rareElementVoid;
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
		Attribute attr = this.setUpObject.attr_A();
		ADependency fd = this.setUpObject.funcDep_A_to_B();
		DFJoint dfJoint = this.setUpObject.dfJoint_04();
		this.rareElement = new RareElement(attr, fd, dfJoint, "Antecedent");
		this.rareElementVoid = new RareElement();
	}

	@Test
	public void constructorRareElementVoid() {
		assertNull(this.rareElementVoid.getAttribute());
		assertNull(this.rareElementVoid.getFD());
		assertNull(this.rareElementVoid.getDFJoint());
		assertNull(this.rareElementVoid.getPosition());
	}
	
	@Test
	public void ConstructorRareElement() {
		assertEquals(this.setUpObject.attr_A(), this.rareElement.getAttribute());
		assertEquals(this.setUpObject.funcDep_A_to_B(), this.rareElement.getFD());
		assertEquals(this.setUpObject.dfJoint_04(), this.rareElement.getDFJoint());
		assertEquals("Antecedent", this.rareElement.getPosition());
	}
	
	@Test
	public void toStringRareElement() {
		String expected = "//** A, Antecedent, {A} -> {B}, DFJoint Four";
		assertEquals(expected, this.rareElement.toString());
	}
	
	@Test
	public void toStringNull() {
		String expected = "Null";
		assertEquals(expected, this.rareElementVoid.toString());
	}
}
