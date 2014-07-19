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
		DFJoint dfJoint = this.setUpObject.dfJoint_04();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AC();
		
		DFJoint expected = this.setUpObject.dfJoint_21();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointFourToAttributeJointAB() {
		DFJoint dfJoint = this.setUpObject.dfJoint_04();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB();
		
		DFJoint expected = this.setUpObject.dfJoint_13();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJointFourToAttributeJointBC() {
		DFJoint dfJoint = this.setUpObject.dfJoint_04();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_BC();
		
		DFJoint expected = this.setUpObject.dfJoint_22();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint35_AToAttributeJointAC() {
		DFJoint dfJoint = this.setUpObject.dpJoint_35_A();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AC();
		
		DFJoint expected = this.setUpObject.CtoA();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	//Projection with PluralDependency
	@Test
	public void projectionDFJoint30ToAttributeJointACD() {
		DFJoint dfJoint = this.setUpObject.dpJoint_30();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ACD();
		
		DFJoint expected = this.setUpObject.dpJoint_30_A();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint30ToAttributeJointABEF() {
		DFJoint dfJoint = this.setUpObject.dpJoint_30();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ABEF();
		
		DFJoint expected = this.setUpObject.dpJoint_30_B();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint32ToAttributeJointBC() {
		DFJoint dfJoint = this.setUpObject.dpJoint_32();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_BC();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint32ToAttributeJointAB() {
		DFJoint dfJoint = this.setUpObject.dpJoint_32();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB();
		
		DFJoint expected = this.setUpObject.AtoB();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint34ToAttributeJointBC() {
		DFJoint dfJoint = this.setUpObject.dpJoint_34();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_BC();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint34ToAttributeJointAB() {
		DFJoint dfJoint = this.setUpObject.dpJoint_34();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint35ToAttributeJointDF() {
		DFJoint dfJoint = this.setUpObject.dpJoint_35();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_DF();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint35ToAttributeJointABCDE() {
		DFJoint dfJoint = this.setUpObject.dpJoint_35();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ABCDE();
		
		DFJoint expected = this.setUpObject.dpJoint_35_A();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint36ToAttributeJointABCD() {
		DFJoint dfJoint = this.setUpObject.dpJoint_36();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ABCD();
		
		DFJoint expected = this.setUpObject.BtoAC_CtoD();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint36ToAttributeJointAEF() {
		DFJoint dfJoint = this.setUpObject.dpJoint_36();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AEF();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint37ToAttributeJointABC() {
		DFJoint dfJoint = this.setUpObject.dpJoint_37();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ABC();
		
		DFJoint expected = this.setUpObject.AtoC();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
	
	@Test
	public void projectionDFJoint37ToAttributeJointADE() {
		DFJoint dfJoint = this.setUpObject.dpJoint_37();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ADE();
		
		DFJoint expected = new DFJoint();
		assertEquals(expected, dfJoint.projectionOnAttributeJoint(attrJoint));
	}
}
