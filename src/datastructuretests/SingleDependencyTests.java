package datastructuretests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


//import setupobjects.SetUpClass;
import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.AFunctionalDependency;
import datastructures.SingleDependency;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SingleDependencyTests {
	private AFunctionalDependency fd;
	
	private AttributeJoint antecedent;
	private AttributeJoint consecuent;
	
	private DFJoint firstDFJoint;
	private DFJoint secondDFJoint;
	
	//private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		//this.setUpObject = new SetUpClass();
		
		String [] antecedentArray = {"A", "B", "C"};
		antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"D", "E", "F"};
		consecuent = new AttributeJoint(consecuentArray);
		
		fd = new SingleDependency(antecedent, consecuent);
		
		//firstDFJoint  = {A -> BC, B -> C, A -> B, AB -> C}
		//firstDFJoint = this.setUpObject.dfJoint_Four();
		
		//secondDFJoint = {A -> B, B -> C}
		//secondDFJoint = this.setUpObject.dfJoint_Five();
	}
	
	//Test constructors
	@Test
	public void constructorVoid() {
		AFunctionalDependency voidFD = new SingleDependency();
		assertNull(voidFD.getAntecedent());
		assertNull(voidFD.getConsequent());
	}
	
	@Test
	public void constructorAttributeJoints() {
		assertNotNull(fd.getAntecedent());
		assertNotNull(fd.getConsequent());
	}
	
	//Test getters
	@Test
	public void getTest() {
		assertEquals(this.antecedent, fd.getAntecedent());
		assertEquals(this.consecuent, fd.getConsequent());
	}
	
	//Test setters
	@Test
	public void setTest() {
		String [] antecedentSetterArray = {"A", "B", "D"};
		AttributeJoint antecedentSetter = new AttributeJoint(antecedentSetterArray);
		
		String [] consequentSetterArray = {"C", "E"};
		AttributeJoint consequentSetter = new AttributeJoint(consequentSetterArray);
		
		fd.setAntecedent(antecedentSetter);
		fd.setConsequent(consequentSetter);
		
		assertEquals(antecedentSetter, fd.getAntecedent());
		assertEquals(consequentSetter, fd.getConsequent());		
	}
	
	//Test removeAttributeFrom...( Attribute )
	@Test
	public void removeAttributeFromAntecedent() {
		String [] attr = {"A", "C"}; 
		AttributeJoint expected = new AttributeJoint(attr);
		
		fd.removeAttributeFromAntecedent(new Attribute("B"));
		
		assertEquals(expected, fd.getAntecedent());
	}
	
	@Test
	public void removeAttributeFromConsequent() {
		String [] attr = {"D", "F"}; 
		AttributeJoint expected = new AttributeJoint(attr);
		
		fd.removeAttributeFromConsequent(new Attribute("E"));
		
		assertEquals(expected, fd.getConsequent());
	}
	
	//Test removeAttributeFrom...( AttributeJoint )
	@Test
	public void removeAttributeJointFromAntecedent() {
		String [] attr = {"C"}; 
		AttributeJoint expected = new AttributeJoint(attr);
		
		String [] toBeRemovedArray = {"B", "A"}; 
		AttributeJoint toBeRemoved = new AttributeJoint(toBeRemovedArray);
		
		fd.removeAttributeFromAntecedent(toBeRemoved);
		
		assertEquals(expected, fd.getAntecedent());
	}
	
	@Test
	public void removeAttributeJointFromConsequent() {
		String [] attr = {"F"}; 
		AttributeJoint expected = new AttributeJoint(attr);
		
		String [] toBeRemovedArray = {"E", "D"}; 
		AttributeJoint toBeRemoved = new AttributeJoint(toBeRemovedArray);
		
		fd.removeAttributeFromConsequent(toBeRemoved);
		
		assertEquals(expected, fd.getConsequent());
	}
	
	//Test toString()
	@Test
	public void toStringFunctionalDependency() {
		String expected = "{A, B, C} -> {D, E, F}";
		
		assertEquals(expected, fd.toString());
	}
	
	//Test isDestroyable()
	@Test
	public void funcDepIsNotDestroyable() {
		assertFalse(fd.isDestroyable());
	}
	
	@Test
	public void funcDepIsDestroyableAntecedent() {
		String [] antecedentArray = {"A", "B", "C"};
		this.antecedent = new AttributeJoint(antecedentArray);
		
		fd.removeAttributeFromAntecedent(this.antecedent);
		
		assertTrue(fd.isDestroyable());
	}
	
	@Test
	public void funcDepIsDestroyableConsequent() {
		String [] consecuentArray = {"D", "E", "F"};
		this.consecuent = new AttributeJoint(consecuentArray);
		
		fd.removeAttributeFromConsequent(this.consecuent);
		
		assertTrue(fd.isDestroyable());
	}
	
	
	//Test clear()
	@Test
	public void clearFunctionalDependency() {
		this.fd.clear();
		
		assertEquals(0, this.fd.getAntecedent().getSize());
		assertEquals(0, this.fd.getConsequent().getSize());
	}
	
	//Test hashCode()
	@Test
	public void hashCodeEquals() {
		String [] antecedentArray = {"A", "B", "C"};
		antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"D", "E", "F"};
		consecuent = new AttributeJoint(consecuentArray);
		
		AFunctionalDependency auxFD = new SingleDependency(antecedent, consecuent);
		
		assertEquals(fd.hashCode(), auxFD.hashCode());
	}
	
	@Test
	public void hashCodeSameFD() {
		assertEquals(fd.hashCode(), fd.hashCode());
	}
	
	@Test
	public void hashCodeDifferent() {
		String [] antecedentArray = {"A"};
		antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"E", "F"};
		consecuent = new AttributeJoint(consecuentArray);
		
		AFunctionalDependency auxFD = new SingleDependency(antecedent, consecuent);
		
		assertNotEquals(fd.hashCode(), auxFD.hashCode());
	}
	
	@Test
	public void hashCodeNullValues() {
		AFunctionalDependency funcDep = new SingleDependency();
		assertEquals(961, funcDep.hashCode());
	}
	
	//Test equals()
	@Test
	public void equalsSameObject() {
		assertTrue(fd.equals(fd));
	}
	
	@Test
	public void equalsSameValues() {
		String [] antecedentArray = {"A", "B", "C"};
		antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"D", "E", "F"};
		consecuent = new AttributeJoint(consecuentArray);
		
		AFunctionalDependency auxFD = new SingleDependency(antecedent, consecuent);
		
		assertTrue(fd.equals(auxFD));
		assertTrue(auxFD.equals(fd));
	}
	
	@Test
	public void equalsOtherClassObject() {
		Attribute A = new Attribute("A");
		assertFalse(fd.equals(A));
	}
	
	@Test
	public void equalsNotDifferentValues() {
		String [] antecedentArray = {"A"};
		antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"E", "F"};
		consecuent = new AttributeJoint(consecuentArray);
		
		AFunctionalDependency auxFD = new SingleDependency(antecedent, consecuent);
		
		assertFalse(fd.equals(auxFD));
	}
	
	@Test
	public void equalsNotNullObject() {
		assertFalse(fd.equals(null));
	}
	
	@Test
	public void equalsNotObjectWithNullValues() {
		AFunctionalDependency funcDep = new SingleDependency();
		assertFalse(funcDep.equals(fd));
	}
	
	@Test
	public void equalsBothObjectsWithNullValues() {
		AFunctionalDependency funcDep1 = new SingleDependency();
		AFunctionalDependency funcDep2 = new SingleDependency();
		assertTrue(funcDep1.equals(funcDep2));
	}
	
	@Test
	public void equalsNotConsquentWithNullValues() {
		AFunctionalDependency funcDep = new SingleDependency();
		
		String [] attrString = { "A", "B", "C" };
		AttributeJoint attrJoint = new AttributeJoint(attrString);
		
		funcDep.setAntecedent(attrJoint);
		
		assertFalse(fd.equals(funcDep));
	}
	
	@Test
	public void equalsConsequentWithNullValues() {
		AFunctionalDependency funcDep = new SingleDependency();
		
		String [] attrString = { "A", "B", "C" };
		AttributeJoint attrJoint = new AttributeJoint(attrString);
		
		funcDep.setAntecedent(attrJoint);
			
		assertFalse(funcDep.equals(fd));
	}
	
	//Test belongsTo()
	@Test
	public void belongsToTrueSecondDFJoint() {
		for (AFunctionalDependency fd : firstDFJoint)
			assertTrue(fd.belongsTo(secondDFJoint));
	}
	
	@Test
	public void belongsToTrueFirstDFJoint() {
		for (AFunctionalDependency fd : secondDFJoint)
			assertTrue(fd.belongsTo(firstDFJoint));
	}
	
	@Test
	public void belongsToFalseFD() {
		assertFalse(fd.belongsTo(firstDFJoint));
		assertFalse(fd.belongsTo(secondDFJoint));
	}
	
	@Test
	public void belongsToFalseFirstFD() {
		String [] antecedentArray = {"C"};
		AttributeJoint antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"A", "B"};
		AttributeJoint consequent = new AttributeJoint(consecuentArray);
		
		AFunctionalDependency fundDep = new SingleDependency(antecedent, consequent);
		
		assertFalse(fundDep.belongsTo(firstDFJoint));
	}
	
	@Test
	public void belongsFalseSecondFD() {
		String [] antecedentArray = {"C"};
		AttributeJoint antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"A"};
		AttributeJoint consequent = new AttributeJoint(consecuentArray);
		
		AFunctionalDependency fundDep = new SingleDependency(antecedent, consequent);
		
		assertFalse(fundDep.belongsTo(firstDFJoint));
	}
	
	//Test getAttributeJoint()
	/*
	@Test
	public void getAttributeJoint() {
		this.fd = this.setUpObject.functionalDependency_A_to_BCD();
		AttributeJoint expected = this.setUpObject.attributeJoint_ABCD();
		assertEquals(expected, this.fd.getAttributeJoint());
	}
	
	//Test isTrivial
	@Test
	public void isTrivialFalseAtoB() {
		assertFalse(this.setUpObject.functionalDependency_A_to_B().isTrivial());
	}
	
	@Test
	public void isTrivialTrueABtoB() {
		assertTrue(this.setUpObject.functionalDependency_AB_to_B().isTrivial());
	}
	*/
	
	@Test
	public void isTrivialTrueVoidAntedent() {
		this.fd.setAntecedent(new AttributeJoint());
		assertTrue(this.fd.isTrivial());
	}
	
	@Test
	public void isTrivialTrueVoidConsequent() {
		this.fd.setConsequent(new AttributeJoint());
		assertTrue(this.fd.isTrivial());
	}
	
	//Test clearTrivialElements()
	@Test
	public void clearTrivialElementsABCtoCDE() {
		AFunctionalDependency newFD = new SingleDependency(this.fd.getAntecedent(), this.fd.getConsequent());
		this.fd.clearTrivialElements();
		assertEquals(newFD, this.fd);
	}
	/*
	@Test
	public void clearTrivialElementsABtoB() {
		FunctionalDependency newFD = this.setUpObject.functionalDependency_AB_to_BCD();
		FunctionalDependency expected = this.setUpObject.functionalDependency_AB_to_CD();
		newFD.clearTrivialElements();
		assertEquals(expected, newFD);
	}
	*/
	@Test
	public void clearTrivialElementsABCtoVoid() {
		this.fd.setConsequent(new AttributeJoint());
		this.fd.clearTrivialElements();
		assertEquals(this.fd, this.fd);
	}
}
