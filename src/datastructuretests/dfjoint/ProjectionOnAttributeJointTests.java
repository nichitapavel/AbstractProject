package datastructuretests.dfjoint;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructuretests.setupclass.SetUpClass;
import datastructures.AttributeJoint;
import datastructures.DFJoint;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectionOnAttributeJointTests {
	private SetUpClass setUpObject;
	
	@Before
	public void setup() {
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	public void projectionDFJointTenToAttributeJointBC() {
		DFJoint dfJoint = this.setUpObject.dfJoint_10();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_BC();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointTenToAttributeJointAC() {
		DFJoint dfJoint = this.setUpObject.dfJoint_10();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AC();
		
		DFJoint expected = this.setUpObject.dfJoint_11();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointTwelveToAttributeJointAB() {
		DFJoint dfJoint = this.setUpObject.dfJoint_12();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB();
		
		DFJoint expected = this.setUpObject.dfJoint_13();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointTwelveToAttributeJointACDE() {
		DFJoint dfJoint = this.setUpObject.dfJoint_12();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ACDE();
		
		DFJoint expected = this.setUpObject.dfJoint_14();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}

	@Test
	public void projectionDFJointFourteenToAttributeJointACD() {
		DFJoint dfJoint = this.setUpObject.dfJoint_14();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ACD();
		
		DFJoint expected = this.setUpObject.dfJoint_15();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointFourteenToAttributeJointCDE() {
		DFJoint dfJoint = this.setUpObject.dfJoint_14();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_CDE();
		
		DFJoint expected = this.setUpObject.dfJoint_16();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointSeventeenToAttributeJointCE() {
		DFJoint dfJoint = this.setUpObject.dfJoint_17();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_CE();
		
		DFJoint expected = this.setUpObject.dfJoint_18();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointSeventeenToAttributeJointBDE() {
		DFJoint dfJoint = this.setUpObject.dfJoint_17();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_BDE();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointNineteenToAttributeJointBC() {
		DFJoint dfJoint = this.setUpObject.dfJoint_19();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_BC();
		
		DFJoint expected = this.setUpObject.dfJoint_20();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointNineteenToAttributeJointAC() {
		DFJoint dfJoint = this.setUpObject.dfJoint_19();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AC();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointFourToAttributeJointAC() {
		DFJoint dfJoint = this.setUpObject.dfJoint_4();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AC();
		
		DFJoint expected = this.setUpObject.dfJoint_21();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointFourToAttributeJointAB() {
		DFJoint dfJoint = this.setUpObject.dfJoint_4();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB();
		
		DFJoint expected = this.setUpObject.dfJoint_13();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointFourToAttributeJointBC() {
		DFJoint dfJoint = this.setUpObject.dfJoint_4();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_BC();
		
		DFJoint expected = this.setUpObject.dfJoint_22();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
}
