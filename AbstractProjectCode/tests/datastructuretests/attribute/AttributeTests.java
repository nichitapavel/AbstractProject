package datastructuretests.attribute;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AttributeTests {
	private Attribute nullAttribute;
	private Attribute namedAttribute;
	private Attribute characterlessAttribute;
	private Attribute stringAttr;
	private String namedAttr;
	private SetUpClass setUpObject;
		
	@Before
	public void setUp(){
		nullAttribute = new Attribute();
		namedAttribute = new Attribute("Name");
		characterlessAttribute = new Attribute("");
		namedAttr = "Atributo";
		stringAttr = new Attribute(namedAttr);
		
		this.setUpObject = new SetUpClass();
	}
	
	//Constructors Tests	
	@Test
	public void testVoidConstructor(){
		assertNull(nullAttribute.getAttribute());
	}

	@Test
	public void testParameterConstructor(){
		assertEquals("Name", namedAttribute.getAttribute());
	}
	
	@Test
	public void testConstructorWithObject() {
		Attribute obj = new Attribute(namedAttribute);
		assertEquals(namedAttribute.getAttribute(), obj.getAttribute());
	}
	
	//Setter Test
	@Test
	public void testSetter(){
		String[] arrayAttributeWithNames = {"A", "Nombre"};
		for (String name : arrayAttributeWithNames){
			nullAttribute.setAttribute(name);
			assertEquals(name, nullAttribute.getAttribute());
		}
	}
	
	//isNull Tests
	@Test
	public void testIsNullTrue(){
		assertTrue(nullAttribute.isNull());
	}
	
	@Test
	public void testIsNullFalse() {
		assertFalse(namedAttribute.isNull());
	}
	
	@Test
	public void testNameWithoutCharacters() {
		assertTrue(characterlessAttribute.isNull());
	}
	
	//Equals Test
	@Test
	public void testEqualsNullValue() {
		assertTrue(nullAttribute.equals(characterlessAttribute));
	}
	
	@Test
	public void testNotEquals() {
		assertFalse(nullAttribute.equals(namedAttribute));
	}
	
	@Test
	public void testEqualsWithValue() {
		Attribute anotherNamedAttribute = new Attribute("Name");
		assertTrue(namedAttribute.equals(anotherNamedAttribute));
	}
	
	@Test
	public void testEqualsSameObject() {
		assertTrue(namedAttribute.equals(namedAttribute));
	}
	
	@Test
	public void testEqualsNullObject() {
		assertFalse(namedAttribute.equals(null));
	}
	
	@Test
	public void testEqualsOtherClassObject() {
		String fail = "This test must fail";
		assertFalse(namedAttribute.equals(fail));
	}
	
	@Test
	public void testEqualsCharacterLessAttributeIsEqualToNulAttribute() {
		assertTrue(characterlessAttribute.equals(nullAttribute));
	}
	
	//Test toString method
	@Test
	public void testToString() {
		assertEquals(namedAttr, stringAttr.toString());
	}
	
	//Test hashCode()
	@Test
	public void testHashCode() {
		Attribute compareHash = new Attribute("Name");
		assertEquals(namedAttribute.hashCode(), compareHash.hashCode());
	}
	
	@Test
	public void testHashCodeDifferent() {
		Attribute compareHash = new Attribute("name");
		assertNotEquals(namedAttribute.hashCode(), compareHash.hashCode());
	}
	
	@Test
	public void testHashCodeNullAttribute() {
		assertEquals(31, nullAttribute.hashCode());
	}
	
	//Test compareTo()
	@Test
	public void testCompareToNegativeValue() {
		Attribute a = new Attribute("a");
		Attribute b = new Attribute("b");
		
		int result = a.compareTo(b);
		assertTrue(result < 0);
	}
	
	@Test
	public void testCompareToPositiveValue() {
		Attribute a = new Attribute("a");
		Attribute b = new Attribute("b");
		
		int result = b.compareTo(a);
		assertTrue(result > 0);
	}
	
	@Test
	public void testCompareToEqualValue() {
		Attribute a = new Attribute("a");
		
		int result = a.compareTo(a);
		assertTrue(result == 0);
	}
	
	//Test isContained()
	@Test
	public void testIsContained() {
		String [] attributes = {"Name", "Atributo", "A"};
		AttributeJoint attrJoint = new AttributeJoint(attributes);
		
		assertTrue(namedAttribute.isContained(attrJoint));
		assertTrue(stringAttr.isContained(attrJoint));
		
		Attribute A = new Attribute("A");
		assertTrue(A.isContained(attrJoint));
	}
	
	@Test
	public void testIsContainedFalseAttrJoint() {
		String [] attributes = {"Atributo", "A"};
		AttributeJoint attrJoint = new AttributeJoint(attributes);
		
		assertFalse(namedAttribute.isContained(attrJoint));
	}
	
	@Test
	public void testIsContainedNullAttrJoint() {
		AttributeJoint attrJoint = new AttributeJoint();
		
		assertFalse(namedAttribute.isContained(attrJoint));
	}
	
	//Test isRareInAntecedent()
	@Test
	public void isRare_A_InAntecedentInDFJointFour_ABtoC() {
		Attribute A = this.setUpObject.attr_A();
		assertTrue(A.isRareInAntecedent(this.setUpObject.funcDep_AB_to_C(),
				this.setUpObject.dfJoint_04()));
	}
	
	@Test
	public void isRare_B_InAntecedentInDFJointFour_ABtoC() {
		Attribute B = this.setUpObject.attr_B();
		assertTrue(B.isRareInAntecedent(this.setUpObject.funcDep_AB_to_C(),
				this.setUpObject.dfJoint_04()));
	}
	
	@Test
	public void isRare_A_InAntecedentInDFJointTwentyFour_ABtoC() {
		Attribute A = this.setUpObject.attr_A();
		assertTrue(A.isRareInAntecedent(this.setUpObject.funcDep_AB_to_C(),
				this.setUpObject.dfJoint_24()));
	}
	
	@Test
	public void isRare_B_InAntecedentInDFJointTwentyFour_ABtoC() {
		Attribute B = this.setUpObject.attr_B();
		assertTrue(B.isRareInAntecedent(this.setUpObject.funcDep_AB_to_C(),
				this.setUpObject.dfJoint_24()));
	}
	
	@Test
	public void isRareFalse_B_InAntecedentInDFJointOne_BCtoA() {
		Attribute B = this.setUpObject.attr_B();
		assertFalse(B.isRareInAntecedent(this.setUpObject.funcDep_BC_to_A(),
				this.setUpObject.dfJoint_01()));
	}
	
	@Test
	public void isRareFalse_C_InAntecedentInDFJointOne_BCtoA() {
		Attribute C = this.setUpObject.attr_C();
		assertFalse(C.isRareInAntecedent(this.setUpObject.funcDep_BC_to_A(),
				this.setUpObject.dfJoint_01()));
	}

	//Test isRareInConsequent()
	@Test
	public void isRare_B_InConsequentInDFJointFour_AtoBC() {
		Attribute B = this.setUpObject.attr_B();
		assertTrue(B.isRareInConsequent(this.setUpObject.funcDep_A_to_BC(),
				this.setUpObject.dfJoint_04()));
	}
	
	@Test
	public void isRare_C_InConsequentInDFJointFour_AtoBC() {
		Attribute C = this.setUpObject.attr_C();
		assertTrue(C.isRareInConsequent(this.setUpObject.funcDep_A_to_BC(),
				this.setUpObject.dfJoint_04()));
	}
	
	@Test
	public void isRareFalse_C_InConsequentInDFJointOne_AtoBC() {
		Attribute C = this.setUpObject.attr_C();
		assertFalse(C.isRareInConsequent(this.setUpObject.funcDep_A_to_BC(),
				this.setUpObject.dfJoint_01()));
	}
	
	@Test
	public void isRareFalse_B_InConsequentInDFJointOne_AtoBC() {
		Attribute B = this.setUpObject.attr_B();
		assertFalse(B.isRareInConsequent(this.setUpObject.funcDep_A_to_BC(),
				this.setUpObject.dfJoint_01()));
	}
}