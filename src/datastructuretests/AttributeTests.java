package datastructuretests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.Attribute;
import datastructures.AttributeJoint;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AttributeTests {
	private Attribute nullAttribute;
	private Attribute namedAttribute;
	private Attribute characterlessAttribute;
	private Attribute stringAttr;
	private String namedAttr;
		
	@Before
	public void setUp(){
		nullAttribute = new Attribute();
		namedAttribute = new Attribute("Name");
		characterlessAttribute = new Attribute("");
		namedAttr = "Atributo";
		stringAttr = new Attribute(namedAttr);
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
}