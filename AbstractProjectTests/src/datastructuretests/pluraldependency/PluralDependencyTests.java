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
	
	//Test constructors
	@Test
	public void constructorVoid() {
		this.setUpObject.AB_AtoB();
		this.pd.clear();
		fail();
	}
	
	//Test toString()
	@Test
	public void toStringPluralDependency() {
		String expected = "{A, B, C} ->> {D, E, F}";
		assertEquals(expected, this.pd.toString());
	}
	
	//Test isTrivial()
	@Test
	public void isTrivialAtoCDinRelation30() {
		this.pd = this.setUpObject.pluDep_A_to_CD();
		assertFalse(this.pd.isTrivial(this.setUpObject.relation_30()));
	}
}
