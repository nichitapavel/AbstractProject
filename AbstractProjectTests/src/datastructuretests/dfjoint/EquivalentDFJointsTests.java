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
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EquivalentDFJointsTests {
	private SetUpClass setUpObject;
	
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
		this.setUpObject = new SetUpClass();
		
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
		firstDFJoint.addDependency(new FunctionalDependency(AJoint, BCJoint));
		firstDFJoint.addDependency(new FunctionalDependency(BJoint, CJoint));
		firstDFJoint.addDependency(new FunctionalDependency(AJoint, BJoint));
		firstDFJoint.addDependency(new FunctionalDependency(ABJoint, CJoint));
		
		//secondDFJoint = {A -> B, B -> C}
		secondDFJoint = new DFJoint();
		secondDFJoint.addDependency(new FunctionalDependency(AJoint, BJoint));
		secondDFJoint.addDependency(new FunctionalDependency(BJoint, CJoint));
		
		//thirdDFJoint  = {A -> BC, B -> AC, C -> AB}
		thirdDFJoint = new DFJoint();
		thirdDFJoint.addDependency(new FunctionalDependency(AJoint, BCJoint));
		thirdDFJoint.addDependency(new FunctionalDependency(BJoint, ACJoint));
		thirdDFJoint.addDependency(new FunctionalDependency(CJoint, ABJoint));
		
		//forthDFJoint  = {A -> B, B -> C, C -> A}
		forthDFJoint = new DFJoint();
		forthDFJoint.addDependency(new FunctionalDependency(AJoint, BJoint));
		forthDFJoint.addDependency(new FunctionalDependency(BJoint, CJoint));
		forthDFJoint.addDependency(new FunctionalDependency(CJoint, AJoint));
		
		//fifthDFJoint  = {A -> B, B -> AC, C -> B}
		fifthDFJoint = new DFJoint();
		fifthDFJoint.addDependency(new FunctionalDependency(AJoint, BJoint));
		fifthDFJoint.addDependency(new FunctionalDependency(BJoint, ACJoint));
		fifthDFJoint.addDependency(new FunctionalDependency(CJoint, BJoint));
	}
	
	//Tests
	//First and Second DFJoints are equivalent
	//Third, Forth and Fifth DFJoints are equivalent
	@Test
	public void isEquivalentFirstAndSecondDFJoints() {
		assertTrue(firstDFJoint.isEquivalent(secondDFJoint, null));
	}
	
	@Test
	public void isEquivalentSecondAndFirstDFJoints() {
		assertTrue(secondDFJoint.isEquivalent(firstDFJoint, null));
	}
	
	@Test
	public void isEquivalentThirdAndForthDFJoints() {
		assertTrue(thirdDFJoint.isEquivalent(forthDFJoint, null));
	}
	
	@Test
	public void isEquivalentForthAndThirdDFJoints() {
		assertTrue(forthDFJoint.isEquivalent(thirdDFJoint, null));
	}
	
	@Test
	public void isEquivalentThirdAndFifthDFJoints() {
		assertTrue(thirdDFJoint.isEquivalent(fifthDFJoint, null));
	}
	
	@Test
	public void isEquivalentFifthAndThirdDFJoints() {
		assertTrue(fifthDFJoint.isEquivalent(thirdDFJoint, null));
	}
	
	@Test
	public void isEquivalentForthAndFifthDFJoints() {
		assertTrue(forthDFJoint.isEquivalent(fifthDFJoint, null));
	}


	@Test
	public void isEquivalentFifthAndForthDFJoints() {
		assertTrue(fifthDFJoint.isEquivalent(forthDFJoint, null));
	}
	
	//Negative tests
	@Test
	public void isNotEquivalentFirstAndThirdDFJoints() {
		assertFalse(firstDFJoint.isEquivalent(thirdDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentThirdAndFirstDFJoints() {
		assertFalse(thirdDFJoint.isEquivalent(firstDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentFirstAndForthDFJoints() {
		assertFalse(firstDFJoint.isEquivalent(forthDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentForthAndFirstDFJoints() {
		assertFalse(forthDFJoint.isEquivalent(firstDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentFirstAndFifthDFJoints() {
		assertFalse(firstDFJoint.isEquivalent(fifthDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentFifthAndFirstDFJoints() {
		assertFalse(fifthDFJoint.isEquivalent(firstDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentSecondAndThirdDFJoints() {
		assertFalse(secondDFJoint.isEquivalent(thirdDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentThirdAndSecondDFJoints() {
		assertFalse(thirdDFJoint.isEquivalent(secondDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentSecondAndForthDFJoints() {
		assertFalse(secondDFJoint.isEquivalent(forthDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentForthAndSecondDFJoints() {
		assertFalse(forthDFJoint.isEquivalent(secondDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentSecondAndFifthDFJoints() {
		assertFalse(secondDFJoint.isEquivalent(fifthDFJoint, null));
	}
	
	@Test
	public void isNotEquivalentFifthAndSecondDFJoints() {
		assertFalse(fifthDFJoint.isEquivalent(secondDFJoint, null));
	}

	//DFJoints with plural dependency
	@Test
	public void isEquivalentDPJoint31andDFJoint31_Equi() {
		assertTrue(this.setUpObject.dpJoint_31().isEquivalent(this.setUpObject.dpJoint_31_Equi(), null));
	}
	
	@Test
	public void isEquivalentDPJoint31_EquiandDFJoint31() {
		assertTrue(this.setUpObject.dpJoint_31_Equi().isEquivalent(this.setUpObject.dpJoint_31(), null));
	}
	
	@Test
	public void isEquivalentDPJoint33andDFJointAtoB_BtoC() {
		assertTrue(this.setUpObject.dpJoint_33().isEquivalent(this.setUpObject.dfJoint_05(), null));
	}
	
	@Test
	public void isEquivalentDPJointAtoB_BtoCandDFJoint33() {
		assertTrue(this.setUpObject.dfJoint_05().isEquivalent(this.setUpObject.dpJoint_33(), null));
	}
	
	@Test
	public void isEquivalentDPJoint37andDFJointAtoC() {
		assertFalse(this.setUpObject.dpJoint_37().isEquivalent(this.setUpObject.AtoC(), null));
	}
	
	@Test
	public void isEquivalentDPJointAtoCandDFJoint37() {
		assertFalse(this.setUpObject.dpJoint_37().isEquivalent(this.setUpObject.AtoC(), null));
	}
}
