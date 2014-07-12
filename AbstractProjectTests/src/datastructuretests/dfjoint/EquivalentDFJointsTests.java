package datastructuretests.dfjoint;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;


import org.junit.runners.MethodSorters;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.dependency.FunctionalDependency;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EquivalentDFJointsTests {
	private DFJoint firstDFJoint;
	private DFJoint secondDFJoint;
	private DFJoint thirdDFJoint;
	private DFJoint forthDFJoint;
	private DFJoint fifthDFJoint;
	
	//First and Second DFJoints are equivalent
	//Third, Forth and Fifth DFJoints are equivalent
	//firstDFJoint  = {A -> BC, B -> C, A -> B, AB -> C}
	//secondDFJoint = {A -> B, B -> C}
	//thirdDFJoint  = {A -> BC, B -> AC, C -> AB}
	//forthDFJoint  = {A -> B, B -> C, C -> A}
	//fifthDFJoint  = {A -> B, B -> AC, C -> B }
	@Before
	public void setUp() {
		Attribute A = new Attribute("A");
		Attribute B = new Attribute("B");
		Attribute C = new Attribute("C");
		
		AttributeJoint AJoint = new AttributeJoint();
		AJoint.addAttributes(A);
		
		AttributeJoint BJoint = new AttributeJoint();
		BJoint.addAttributes(B);
		
		AttributeJoint CJoint = new AttributeJoint();
		CJoint.addAttributes(C);
		
		AttributeJoint ABJoint = new AttributeJoint();
		ABJoint.addAttributes(A); ABJoint.addAttributes(B);
		
		AttributeJoint ACJoint = new AttributeJoint();
		ACJoint.addAttributes(A); ACJoint.addAttributes(C);
		
		AttributeJoint BCJoint = new AttributeJoint();
		BCJoint.addAttributes(B); BCJoint.addAttributes(C);
		
		//firstDFJoint  = {A -> BC, B -> C, A -> B, AB -> C}
		firstDFJoint = new DFJoint();
		firstDFJoint.addFunctionalDependency(new FunctionalDependency(AJoint, BCJoint));
		firstDFJoint.addFunctionalDependency(new FunctionalDependency(BJoint, CJoint));
		firstDFJoint.addFunctionalDependency(new FunctionalDependency(AJoint, BJoint));
		firstDFJoint.addFunctionalDependency(new FunctionalDependency(ABJoint, CJoint));
		
		//secondDFJoint = {A -> B, B -> C}
		secondDFJoint = new DFJoint();
		secondDFJoint.addFunctionalDependency(new FunctionalDependency(AJoint, BJoint));
		secondDFJoint.addFunctionalDependency(new FunctionalDependency(BJoint, CJoint));
		
		//thirdDFJoint  = {A -> BC, B -> AC, C -> AB}
		thirdDFJoint = new DFJoint();
		thirdDFJoint.addFunctionalDependency(new FunctionalDependency(AJoint, BCJoint));
		thirdDFJoint.addFunctionalDependency(new FunctionalDependency(BJoint, ACJoint));
		thirdDFJoint.addFunctionalDependency(new FunctionalDependency(CJoint, ABJoint));
		
		//forthDFJoint  = {A -> B, B -> C, C -> A}
		forthDFJoint = new DFJoint();
		forthDFJoint.addFunctionalDependency(new FunctionalDependency(AJoint, BJoint));
		forthDFJoint.addFunctionalDependency(new FunctionalDependency(BJoint, CJoint));
		forthDFJoint.addFunctionalDependency(new FunctionalDependency(CJoint, AJoint));
		
		//fifthDFJoint  = {A -> B, B -> AC, C -> B}
		fifthDFJoint = new DFJoint();
		fifthDFJoint.addFunctionalDependency(new FunctionalDependency(AJoint, BJoint));
		fifthDFJoint.addFunctionalDependency(new FunctionalDependency(BJoint, ACJoint));
		fifthDFJoint.addFunctionalDependency(new FunctionalDependency(CJoint, BJoint));
	}
	
	//Tests
	//First and Second DFJoints are equivalent
	//Third, Forth and Fifth DFJoints are equivalent
	@Test
	public void isEquivalentFirstAndSecondDFJoints() {
		assertTrue(firstDFJoint.isEquivalent(secondDFJoint));
	}
	
	@Test
	public void isEquivalentSecondAndFirstDFJoints() {
		assertTrue(secondDFJoint.isEquivalent(firstDFJoint));
	}
	
	@Test
	public void isEquivalentThirdAndForthDFJoints() {
		assertTrue(thirdDFJoint.isEquivalent(forthDFJoint));
	}
	
	@Test
	public void isEquivalentForthAndThirdDFJoints() {
		assertTrue(forthDFJoint.isEquivalent(thirdDFJoint));
	}
	
	@Test
	public void isEquivalentThirdAndFifthDFJoints() {
		assertTrue(thirdDFJoint.isEquivalent(fifthDFJoint));
	}
	
	@Test
	public void isEquivalentFifthAndThirdDFJoints() {
		assertTrue(fifthDFJoint.isEquivalent(thirdDFJoint));
	}
	
	@Test
	public void isEquivalentForthAndFifthDFJoints() {
		assertTrue(forthDFJoint.isEquivalent(fifthDFJoint));
	}


	@Test
	public void isEquivalentFifthAndForthDFJoints() {
		assertTrue(fifthDFJoint.isEquivalent(forthDFJoint));
	}
	
	//Negative tests
	@Test
	public void isNotEquivalentFirstAndThirdDFJoints() {
		assertFalse(firstDFJoint.isEquivalent(thirdDFJoint));
	}
	
	@Test
	public void isNotEquivalentThirdAndFirstDFJoints() {
		assertFalse(thirdDFJoint.isEquivalent(firstDFJoint));
	}
	
	@Test
	public void isNotEquivalentFirstAndForthDFJoints() {
		assertFalse(firstDFJoint.isEquivalent(forthDFJoint));
	}
	
	@Test
	public void isNotEquivalentForthAndFirstDFJoints() {
		assertFalse(forthDFJoint.isEquivalent(firstDFJoint));
	}
	
	@Test
	public void isNotEquivalentFirstAndFifthDFJoints() {
		assertFalse(firstDFJoint.isEquivalent(fifthDFJoint));
	}
	
	@Test
	public void isNotEquivalentFifthAndFirstDFJoints() {
		assertFalse(fifthDFJoint.isEquivalent(firstDFJoint));
	}
	
	@Test
	public void isNotEquivalentSecondAndThirdDFJoints() {
		assertFalse(secondDFJoint.isEquivalent(thirdDFJoint));
	}
	
	@Test
	public void isNotEquivalentThirdAndSecondDFJoints() {
		assertFalse(thirdDFJoint.isEquivalent(secondDFJoint));
	}
	
	@Test
	public void isNotEquivalentSecondAndForthDFJoints() {
		assertFalse(secondDFJoint.isEquivalent(forthDFJoint));
	}
	
	@Test
	public void isNotEquivalentForthAndSecondDFJoints() {
		assertFalse(forthDFJoint.isEquivalent(secondDFJoint));
	}
	
	@Test
	public void isNotEquivalentSecondAndFifthDFJoints() {
		assertFalse(secondDFJoint.isEquivalent(fifthDFJoint));
	}
	
	@Test
	public void isNotEquivalentFifthAndSecondDFJoints() {
		assertFalse(fifthDFJoint.isEquivalent(secondDFJoint));
	}
}
