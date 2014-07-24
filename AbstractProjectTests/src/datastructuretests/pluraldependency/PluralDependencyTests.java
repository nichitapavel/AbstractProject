package datastructuretests.pluraldependency;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.AttributeJoint;
import datastructures.dependency.ADependency;
import datastructures.dependency.PluralDependency;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PluralDependencyTests {
	private ADependency pd;
	
	private AttributeJoint antecedent;
	private AttributeJoint consecuent;
	
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
		
		String [] antecedentArray = {"A", "B", "C"};
		antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"D", "E", "F"};
		consecuent = new AttributeJoint(consecuentArray);
		
		pd = new PluralDependency(antecedent, consecuent);
	}

	//Test toString()
	@Test
	public void toStringPluralDependency() {
		String expected = "{A, B, C} ->> {D, E, F}";
		assertEquals(expected, this.pd.toString());
	}
	
	@Test
	public void toStringNullPluralDependency() {
		this.pd = new PluralDependency();
		String expected = "null ->> null";
		assertEquals(expected, this.pd.toString());
	}
	
	//Test isTrivial()
	@Test
	public void isTrivialAtooCDinRelation30() {
		this.pd = this.setUpObject.pluDep_A_to_CD();
		assertFalse(this.pd.isTrivial(this.setUpObject.relation_30()));
	}

	@Test
	public void isTrivialAtooBCDEFinRelation30() {
		this.pd = this.setUpObject.pluDep_A_to_BCDEF();
		assertTrue(this.pd.isTrivial(this.setUpObject.relation_30()));
	}
	
	@Test
	public void isTrivialAtooBEFinRelation30() {
		this.pd = this.setUpObject.pluDep_A_to_BEF();
		assertFalse(this.pd.isTrivial(this.setUpObject.relation_30()));
	}
	
	@Test
	public void isTrivialBEtooBinRelation30() {
		this.pd = this.setUpObject.pluDep_BE_to_B();
		assertTrue(this.pd.isTrivial(this.setUpObject.relation_30()));
	}
	
	@Test
	public void isTrivialAtooCDinRelation30_A() {
		this.pd = this.setUpObject.pluDep_A_to_CD();
		assertTrue(this.pd.isTrivial(this.setUpObject.relation_30_A()));
	}
	
	@Test
	public void isTrivialAtooCDinRelation31() {
		this.pd = this.setUpObject.pluDep_A_to_CD();
		assertFalse(this.pd.isTrivial(this.setUpObject.relation_31()));
	}
	
	@Test
	public void isTrivialBtooCinRelationBC() {
		this.pd = this.setUpObject.pluDep_B_to_C();
		assertTrue(this.pd.isTrivial(this.setUpObject.relationBC()));
	}
	
	@Test
	public void isTrivialBtooCinRelation32() {
		this.pd = this.setUpObject.pluDep_B_to_C();
		assertFalse(this.pd.isTrivial(this.setUpObject.relation_32()));
	}
	
	@Test
	public void isTrivialBtooAinRelationAB() {
		this.pd = this.setUpObject.pluDep_B_to_A();
		assertTrue(this.pd.isTrivial(this.setUpObject.relationAB()));
	}
	
	@Test
	public void isTrivialDtooFinRelationDF() {
		this.pd = this.setUpObject.pluDep_D_to_F();
		assertTrue(this.pd.isTrivial(this.setUpObject.relationDF()));
	}
	
	@Test
	public void isTrivialAtooBCDinRelationABCD() {
		this.pd = this.setUpObject.pluDep_A_to_BCD();
		assertTrue(this.pd.isTrivial(this.setUpObject.r_ABCD_BtoAC_CtoD()));
	}
	
	@Test
	public void isTrivialAtooBCinRelationABC() {
		this.pd = this.setUpObject.pluDep_A_to_BC();
		assertTrue(this.pd.isTrivial(this.setUpObject.r_ABC_AtoC()));
	}
	
	//Test equals()
	@Test
	public void equalsAtooBandAtooB() {
		this.pd = this.setUpObject.pluDep_A_to_B();
		ADependency pd2 = this.setUpObject.pluDep_A_to_B();
		assertTrue(this.pd.equals(pd2));
	}
	
	//Test belongsTo()
	@Test
	public void belongsToAtooCDinDFJoint30() {
		this.pd = this.setUpObject.pluDep_A_to_CD();
		assertTrue(this.pd.belongsTo(this.setUpObject.dpJoint_30(), null));
	}
	
	@Test
	public void belongsToAtooBEFinDFJoint30() {
		this.pd = this.setUpObject.pluDep_A_to_BEF();
		assertTrue(this.pd.belongsTo(this.setUpObject.dpJoint_30(), null));
	}
	
	@Test
	public void belongsToAtooBinDFJoint30() {
		this.pd = this.setUpObject.pluDep_A_to_B();
		assertTrue(this.pd.belongsTo(this.setUpObject.dpJoint_30(), null));
	}
	
	@Test
	public void belongsToAtooEFinDFJoint30() {
		this.pd = this.setUpObject.pluDep_A_to_EF();
		assertTrue(this.pd.belongsTo(this.setUpObject.dpJoint_30(), null));
	}
	
	@Test
	public void belongsToBtooAinDFJoint34() {
		this.pd = this.setUpObject.pluDep_B_to_A();
		assertTrue(this.pd.belongsTo(this.setUpObject.dpJoint_34(), null));
	}
	
	@Test
	public void belongsToAtooEFinDFJoint36() {
		this.pd = this.setUpObject.pluDep_A_to_EF();
		assertTrue(this.pd.belongsTo(this.setUpObject.dpJoint_36(), null));
	}
	
	@Test
	public void belongsToAtooDEinDFJoint37() {
		this.pd = this.setUpObject.pluDep_A_to_DE();
		assertTrue(this.pd.belongsTo(this.setUpObject.dpJoint_37(), null));
	}
}
