package datastructuretests.dfjoint;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructuretests.setupclass.SetUpClass;
import datastructures.DFJoint;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReGroupDFJointsTests {
	private DFJoint dfJoint;
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	public void testTemplate(DFJoint expected, DFJoint dfJoint) {
		DFJoint result = dfJoint.regroupDFJoint();
		assertEquals(expected, result);
	}
	
	@Test
	public void reGroupDFJointOne() {
		this.dfJoint = this.setUpObject.dfJoint_1();
		testTemplate(this.dfJoint, this.dfJoint);
	}
	
	@Test
	public void reGroupDFJointTwo() {
		this.dfJoint = this.setUpObject.dfJoint_2();
		testTemplate(this.dfJoint, this.dfJoint);
	}
	
	@Test
	public void reGroupDFJointThree() {
		testTemplate(this.setUpObject.dfJoint_23(), this.setUpObject.dfJoint_3()); 
	}
	
	@Test
	public void reGroupDFJointFour() {
		testTemplate(this.setUpObject.dfJoint_24(), this.setUpObject.dfJoint_4());
	}
	
	@Test
	public void reGroupDFJointTwentyFive() {
		testTemplate(this.setUpObject.dfJoint_26(), this.setUpObject.dfJoint_25());
	}
	
	@Test
	public void reGroupDFJointSix() {
		testTemplate(this.setUpObject.dfJoint_27(), this.setUpObject.dfJoint_6());
	}
	
	@Test
	public void reGroupDFJointNine() {
		this.dfJoint = this.setUpObject.dfJoint_9();
		testTemplate(this.dfJoint, this.dfJoint);
	}
}
