package datastructuretests.attributejoint;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Vector;

import org.junit.FixMethodOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.KeyJoint;
import datastructuretests.setupclass.SetUpClass;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AttributeJointTests {
	private AttributeJoint mainAttributeJoint;
	private SetUpClass setUpObject;
		
	@Before
	public void setUp() {
		String [] attrArray = {"A", "B", "C"};
		mainAttributeJoint = new AttributeJoint(attrArray);
		
		this.setUpObject = new SetUpClass();
	}
	
	//Constructors Tests	
	@Test
	public void constructorVoid() {
		AttributeJoint voidConstructor = new AttributeJoint();
		assertNull(voidConstructor.getAttributeJoint());
	}
	
	@Test
	public void constructorArray() {
		String [] attrArray = {"A", "B", "C"};
		AttributeJoint arrayConstructor = new AttributeJoint(attrArray);
		ArrayList<Attribute> getterJoint = arrayConstructor.getAttributeJoint();
		assertEquals(attrArray.length, getterJoint.size());
		for (int i = 0; i < attrArray.length; i++)
			assertEquals(attrArray[i], getterJoint.get(i).getAttribute());
	}
	
	@Test
	public void constructorVector() {
		ArrayList<Attribute> attrVector = new ArrayList<>();
		attrVector.add(new Attribute("A"));
		attrVector.add(new Attribute("B"));
		
		AttributeJoint arrayListConstructor = new AttributeJoint(attrVector);
		ArrayList<Attribute> getterJoint = arrayListConstructor.getAttributeJoint();
		assertEquals(attrVector.size(), getterJoint.size());
		for (int i = 0; i < getterJoint.size(); i++)
			assertEquals(attrVector.get(i).getAttribute(), getterJoint.get(i).getAttribute());	
	}
	
	@Test
	public void constructorObj() {
		AttributeJoint objConstructor = new AttributeJoint(mainAttributeJoint);
		assertEquals(mainAttributeJoint, objConstructor);
	}
	
	//Test getAttributeJoint()
	@Test
	public void getAttributeJointEquals() {
		String [] stringAttr = {"A", "B", "C"};
		Vector<Attribute> auxVector = new Vector<Attribute>();
		for (String str : stringAttr)
			auxVector.add(new Attribute(str));

		assertEquals(mainAttributeJoint.getAttributeJoint(), auxVector);
	}
	
	@Test
	public void getAttributeJointNotEquals() {
		String [] stringAttr = {"A", "C"};
		Vector<Attribute> auxVector = new Vector<Attribute>();
		for (String str : stringAttr)
			auxVector.add(new Attribute(str));
		
		assertNotEquals(mainAttributeJoint.getAttributeJoint(), auxVector);
	}
	
	//Test setAttributeJoint()
	@Test
	public void setAttributeEquals() {
		String [] stringAttr = {"B", "C", "D"};
		ArrayList<Attribute> auxVector = new ArrayList<>();
		for (String str : stringAttr)
			auxVector.add(new Attribute(str));
		
		mainAttributeJoint.setAttributeJoint(auxVector);
		
		assertEquals(mainAttributeJoint.getAttributeJoint(), auxVector);
	}
	
	@Test
	public void setAttributeNotEquals() {
		String [] stringAttr = {"B", "C", "D"};
		ArrayList<Attribute> auxVector = new ArrayList<>();
		for (String str : stringAttr)
			auxVector.add(new Attribute(str));
		
		AttributeJoint auxAttrJoint = new AttributeJoint();
		auxAttrJoint.setAttributeJoint(auxVector);
		
		assertNotEquals(mainAttributeJoint.getAttributeJoint(), auxAttrJoint.getAttributeJoint());
	}
	
	//Testing the remove Repeated Attribute from Joint
	@Test
	public void clearDuplicatedAttribute() {
		String [] repeatedAttrArray = {"A", "B", "B", "C"};
		AttributeJoint repeatedAttr = new AttributeJoint(repeatedAttrArray);
		repeatedAttr.removeDuplicatedAttribute();
		
		assertEquals(mainAttributeJoint, repeatedAttr);
	}
	
	@Test
	public void clearMoreThanOneDuplicatedAttribute() {
		String [] expectedArray = {"A", "B", "C"};
		AttributeJoint expectedResult = new AttributeJoint(expectedArray);
		
		String [] duplicatedAttr = {"A", "B", "A", "A", "C", "B"};
		AttributeJoint duplicatedResult = new AttributeJoint(duplicatedAttr);
		
		duplicatedResult.removeDuplicatedAttribute();
		
		assertEquals(expectedResult, duplicatedResult);
	}
	
	//Test the toString method
	@Test
	public void toStringAttributeJoint() {
		String expected = "{A, B, C}";
		assertEquals(expected, mainAttributeJoint.toString());		
	}
	
	@Test
	public void toStringVoidValueAttributeJoint() {
		String expected = "null";
		AttributeJoint nullAttrJoint = new AttributeJoint();
		assertEquals(expected, nullAttrJoint.toString());
	}
	
	@Test
	public void toStringAttributeJointSizeZero() {
		ArrayList<Attribute> attrJointVector = new ArrayList<>();
		AttributeJoint attrJoint = new AttributeJoint(attrJointVector);
		assertEquals("null", attrJoint.toString());
	}
	
	//Test if a joint is contained in another Joint
	@Test
	public void singleElementAttributeJointIsContained() {
		String [] containedJointArray = {"A"};
		AttributeJoint containedJoint = new AttributeJoint(containedJointArray);
		assertTrue(containedJoint.isContained(mainAttributeJoint));
	}
	
	@Test
	public void attributeJointIsContained() {
		String [] containedJointArray = {"A", "C"};
		AttributeJoint containedJoint = new AttributeJoint(containedJointArray);
		assertTrue(containedJoint.isContained(mainAttributeJoint));
	}
	
	@Test
	public void nullAttributeJointIsNotContained() {
		AttributeJoint nullJoint = new AttributeJoint();
		
		assertFalse(mainAttributeJoint.isContained(nullJoint));
	}
	
	@Test
	public void nullAttributeJointDoesNotContainAnyAttributeJoint() {
		AttributeJoint nullJoint = new AttributeJoint();
		
		assertFalse(nullJoint.isContained(mainAttributeJoint));
	}
	
	@Test
	public void singleElementAttributeJointIsNotContained() {
		String [] containedJointArray = {"D"};
		AttributeJoint containedJoint = new AttributeJoint(containedJointArray);
		assertFalse(containedJoint.isContained(mainAttributeJoint));
	}
	
	@Test
	public void attributeJointIsNotContained() {
		String [] containedJointArray = {"D", "E"};
		AttributeJoint containedJoint = new AttributeJoint(containedJointArray);
		assertFalse(containedJoint.isContained(mainAttributeJoint));
	}
	
	//Test addAttribute()
	@Test
	public void attributeJointWithSimilarAttributesIsNotContained() {
		String [] containedJointArray = {"A", "C", "D"};
		AttributeJoint containedJoint = new AttributeJoint(containedJointArray);
		assertFalse(containedJoint.isContained(mainAttributeJoint));
	}
	
	@Test
	public void addAttribute() {
		Attribute attr = new Attribute("D");
		
		String [] attrArray = {"A", "B", "C", "D"};
		AttributeJoint expectedAttrJoint = new AttributeJoint(attrArray);
		
		mainAttributeJoint.addAttributes(attr);
		
		assertEquals(expectedAttrJoint, mainAttributeJoint);
	}
	
	@Test
	public void addAttributeJoint() {
		String [] arrayJoint = {"D", "E"};
		AttributeJoint attrJoint = new AttributeJoint(arrayJoint);
		
		String [] attrArray = {"A", "B", "C", "D", "E"};
		AttributeJoint expectedAttrJoint = new AttributeJoint(attrArray);
		
		mainAttributeJoint.addAttributes(attrJoint);
		
		assertEquals(expectedAttrJoint, mainAttributeJoint);
	}
	
	@Test
	public void addAttributeJointWithRepeatedAttributes() {
		String [] arrayJoint = {"A", "E"};
		AttributeJoint attrJoint = new AttributeJoint(arrayJoint);
		
		String [] attrArray = {"A", "B", "C", "E"};
		AttributeJoint expectedAttrJoint = new AttributeJoint(attrArray);
		
		mainAttributeJoint.addAttributes(attrJoint);
		
		assertEquals(expectedAttrJoint, mainAttributeJoint);	
	}
	
	@Test
	public void addNullJointToAttributeJoint() {
		AttributeJoint nullJoint = new AttributeJoint();
		this.mainAttributeJoint.addAttributes(nullJoint);
		
		AttributeJoint result = new AttributeJoint(this.mainAttributeJoint);
		
		assertEquals(mainAttributeJoint, result);
	}
	
	@Test
	public void addIdenticalAttributeJoint() {
		String [] expectedAttrArray = {"A", "B", "C"};
		AttributeJoint expectedAttributeJoint = new AttributeJoint(expectedAttrArray);
		
		mainAttributeJoint.addAttributes(expectedAttributeJoint);
		
		assertEquals(expectedAttributeJoint, mainAttributeJoint);
	}
	
	@Test
	public void addAttributeToNullJoint() {
		String [] expectedAttrArray = {"A"};
		AttributeJoint expectedAttributeJoint = new AttributeJoint(expectedAttrArray);
		
		Attribute attr = new Attribute("A");
		AttributeJoint nullJoint = new AttributeJoint();
		nullJoint.addAttributes(attr);
		
		assertEquals(expectedAttributeJoint, nullJoint);
	}
	
	@Test
	public void addAttributeJointToNullJoint() {		
		AttributeJoint nullJoint = new AttributeJoint();
		nullJoint.addAttributes(mainAttributeJoint);
		
		assertEquals(mainAttributeJoint, nullJoint);
	}
	
	//Test removeAttribute()
	@Test
	public void removeAttribute() {
		String [] expectedAttrArray = {"A", "B"};
		AttributeJoint expectedAttributeJoint = new AttributeJoint(expectedAttrArray);
		
		Attribute attr = new Attribute("C");
		mainAttributeJoint.removeAttributes(attr);
		
		assertEquals(expectedAttributeJoint, mainAttributeJoint);
	}
	
	@Test
	public void removeAttributeFromNullJoint() {
		AttributeJoint nullJoint = new AttributeJoint();
		
		Attribute attr = new Attribute("C");
		nullJoint.removeAttributes(attr);
		
		assertNull(nullJoint.getAttributeJoint());
	}
	
	@Test
	public void removeAttributeJoint() {
		String [] expArray = {"B"};
		AttributeJoint expectedJoint = new AttributeJoint(expArray);
		
		String [] removeArray = {"A", "C"};
		AttributeJoint removedJoint = new AttributeJoint(removeArray);
		
		mainAttributeJoint.removeAttributes(removedJoint);
		
		assertEquals(expectedJoint, mainAttributeJoint);
	}
	
	@Test
	public void removeAttributeJointFromNullJoint() {
		AttributeJoint nullJoint = new AttributeJoint();
		
		nullJoint.removeAttributes(mainAttributeJoint);
		
		assertNull(nullJoint.getAttributeJoint());
	}
	
	//Test equals()
	@Test
	public void equalsSameObject() {
		assertTrue(mainAttributeJoint.equals(mainAttributeJoint));
	}
	
	@Test
	public void notEqualsNullObject() {
		assertFalse(mainAttributeJoint.equals(null));
	}
	
	@Test
	public void notEqualsDifferentClassObj() {
		Attribute A = new Attribute("A");
		assertFalse(mainAttributeJoint.equals(A));
	}
	
	@Test
	public void equalsNullAttributeJoint() {
		AttributeJoint A = new AttributeJoint();
		AttributeJoint B = new AttributeJoint();
		
		assertTrue(A.equals(B));
	}
	
	@Test
	public void notEqualsNullAttributeJoint() {
		AttributeJoint A = new AttributeJoint();
		
		assertFalse(A.equals(mainAttributeJoint));
	}
	
	@Test
	public void notEqualsNullAttributeJointInverse() {
		AttributeJoint A = new AttributeJoint();
		
		assertFalse(mainAttributeJoint.equals(A));
	}
	
	@Test
	public void equalsAttributeJoint() {
		String [] secondaryArray = {"A", "B", "C"};
		AttributeJoint secondaryJoint = new AttributeJoint(secondaryArray);
		
		assertTrue(secondaryJoint.equals(mainAttributeJoint));
	}
	
	//Test sort()
	@Test
	public void sortMethod() {
		String [] unsortedArray = {"B", "A", "C"};
		AttributeJoint unsortedJoint = new AttributeJoint(unsortedArray);
		
		unsortedJoint.sort();
		
		assertTrue(mainAttributeJoint.equals(unsortedJoint));
	}

	@Test
	public void sortContructor() {
		String [] unsortedArray_A = {"B", "A", "C"};
		AttributeJoint unsortedJoint_A = new AttributeJoint(unsortedArray_A);
		assertEquals(mainAttributeJoint, unsortedJoint_A);
		
		ArrayList<Attribute> unsortedVector_B = new ArrayList<>();
		unsortedVector_B.add(new Attribute("C"));
		unsortedVector_B.add(new Attribute("B"));
		unsortedVector_B.add(new Attribute("A"));
		AttributeJoint unsortedJoint_B = new AttributeJoint(unsortedVector_B);
		assertEquals(mainAttributeJoint, unsortedJoint_B);
	}
	
	@Test
	public void sortAddAttribute() {
		String [] unsortedArray = {"B", "C"};
		AttributeJoint unsortedJoint = new AttributeJoint(unsortedArray);
		unsortedJoint.addAttributes(new Attribute("A"));
		
		assertEquals(mainAttributeJoint, unsortedJoint);
	}
	
	@Test
	public void sortAddAttributeJoint() {
		String [] unsortedArray = {"B"};
		AttributeJoint unsortedJoint = new AttributeJoint(unsortedArray);
		
		String [] unsortedArray_B = {"A", "C"};
		AttributeJoint unsortedJoint_B = new AttributeJoint(unsortedArray_B);
		
		unsortedJoint.addAttributes(unsortedJoint_B);
		
		assertEquals(mainAttributeJoint, unsortedJoint);
	}
	
	//Test getSize()
	@Test
	public void getSizeAssert() {
		assertEquals(mainAttributeJoint.getSize(), 3);
	}
	
	@Test
	public void getSizeFail() {
		assertNotEquals(mainAttributeJoint.getSize(), 0);
	}
	
	@Test
	public void getSizeNullAttributeJoint() {
		assertEquals(0, new AttributeJoint().getSize());
	}
	
	//Test clear()
	@Test
	public void clearJoint() {
		this.mainAttributeJoint.clear();
		
		assertEquals(0, this.mainAttributeJoint.getSize());
	}
	
	//Test iterator()
	@Test
	public void iterableInterface() {
		for (Attribute attr : this.mainAttributeJoint)
			assertNotNull(attr);
	}
	
	//Test hashCode()
	@Test
	public void hashCodeObj() {
		String [] stringAttr = {"A", "B", "C"};
		AttributeJoint hashCodeAttrJoint = new AttributeJoint(stringAttr);

		assertEquals(mainAttributeJoint.hashCode(), hashCodeAttrJoint.hashCode());
	}
	
	@Test
	public void hashCodeNullObj() {
		AttributeJoint hashCodeAttrJoint = new AttributeJoint();

		assertEquals(31, hashCodeAttrJoint.hashCode());
	}
	
	//Test getAttributeAt()
	@Test
	public void getAttributeAt(){
		assertEquals(new Attribute("A"), this.mainAttributeJoint.getAttributeAt(0));
		assertEquals(new Attribute("C"), this.mainAttributeJoint.getAttributeAt(2));
	}
	
	//Test changeAttributeAt
	@Test
	public void changeAttributeAtTest() {
		Attribute G = new Attribute("G");
		this.mainAttributeJoint.changeAttributeAt(this.mainAttributeJoint.getSize()-1, G);
		assertEquals(G, this.mainAttributeJoint.getAttributeAt(this.mainAttributeJoint.getSize() - 1));		
	}
	
	//Test union()
	@Test
	public void unionNormalAttributeJoints() {
		String [] stringAttr = {"D", "E", "F"};
		AttributeJoint attrJoint = new AttributeJoint(stringAttr);
		
		AttributeJoint result = this.mainAttributeJoint.union(attrJoint);
		
		String [] expectedStringAttr = {"A", "B", "C", "D", "E", "F"};
		AttributeJoint expected = new AttributeJoint(expectedStringAttr);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void unionVoidAttributeJoint() {
		AttributeJoint voidAttrJoint = new AttributeJoint();
		AttributeJoint result = this.mainAttributeJoint.union(voidAttrJoint);
		assertEquals(this.mainAttributeJoint, result);
	}
	
	@Test
	public void unionRepetedAttributes() {
		String [] stringAttr = {"A", "C", "F"};
		AttributeJoint attrJoint = new AttributeJoint(stringAttr);
		
		AttributeJoint result = this.mainAttributeJoint.union(attrJoint);
		
		String [] expectedStringAttr = {"A", "B", "C", "F"};
		AttributeJoint expected = new AttributeJoint(expectedStringAttr);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void unionRepeatedAllAttributes() {
		String [] stringAttr = {"A", "B", "C"};
		AttributeJoint attrJoint = new AttributeJoint(stringAttr);
		
		AttributeJoint result = this.mainAttributeJoint.union(attrJoint);
		
		String [] expectedStringAttr = {"A", "B", "C"};
		AttributeJoint expected = new AttributeJoint(expectedStringAttr);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void unionVoidAttributeJointWithAttributeJoint() {
		AttributeJoint voidAttrJoint = new AttributeJoint();
		AttributeJoint result = voidAttrJoint.union(this.mainAttributeJoint);
		assertEquals(this.mainAttributeJoint, result);
	}
	
	//Test getLastAttribute();
	@Test
	public void getLastAttributeAttributeJoint() {
		Attribute C = new Attribute("C");
		assertEquals(C, this.mainAttributeJoint.getLastAttribute());
	}
	
	@Test
	public void getLastAttributeNullAttributeJoint() {
		AttributeJoint attrJoint = new AttributeJoint();
		assertNull(attrJoint.getLastAttribute());
	}
	
	//Test getAttributePosition()
	@Test
	public void getAttributePositionNormalAttributeJoint() {
		assertEquals(0, this.mainAttributeJoint.getAttributePosition(new Attribute("A")));
		assertEquals(1, this.mainAttributeJoint.getAttributePosition(new Attribute("B")));
		assertEquals(2, this.mainAttributeJoint.getAttributePosition(new Attribute("C")));
	}
	
	@Test
	public void getAttributePositionVoidAttributeJoint() {
		AttributeJoint nullAttrJoint = new AttributeJoint();
		assertEquals(-1, nullAttrJoint.getAttributePosition(new Attribute("A")));
	}
	
	@Test
	public void getAttributePositionThatDoesNotExistInNormalAttributeJoint() {
		assertEquals(-1, this.mainAttributeJoint.getAttributePosition(new Attribute("D")));
	}
	
	//Test intersect
	@Test
	public void intersectAFromAB() {
		AttributeJoint expected = this.setUpObject.attrJnt_A();
		AttributeJoint firstJoined = this.setUpObject.attrJnt_AB();
		AttributeJoint secondJoined = this.setUpObject.attrJnt_A();
		assertEquals(expected, firstJoined.intersect(secondJoined));
	}
	
	@Test
	public void intersectNullFromA() {
		AttributeJoint expected = new AttributeJoint();
		AttributeJoint firstJoined = this.setUpObject.attrJnt_A();
		AttributeJoint secondJoined = new AttributeJoint();
		assertEquals(expected, firstJoined.intersect(secondJoined));
	}
	
	@Test
	public void intersectDromABCDEandDF() {
		AttributeJoint expected = this.setUpObject.attrJnt_D();
		AttributeJoint firstJoined = this.setUpObject.attrJnt_ABCDE();
		AttributeJoint secondJoined = this.setUpObject.attrJnt_DF();
		assertEquals(expected, firstJoined.intersect(secondJoined));
	}
	
	//Test substract
	@Test
	public void substracABFromABC() {
		AttributeJoint expected = this.setUpObject.attrJnt_C();
		AttributeJoint firstJoined = this.setUpObject.attrJnt_ABC();
		AttributeJoint secondJoined = this.setUpObject.attrJnt_AB();
		assertEquals(expected, firstJoined.substract(secondJoined));
	}
	
	@Test
	public void substracBCFromADE() {
		AttributeJoint expected = this.setUpObject.attrJnt_ADE();
		AttributeJoint firstJoined = this.setUpObject.attrJnt_ADE();
		AttributeJoint secondJoined = this.setUpObject.attrJnt_BC();
		assertEquals(expected, firstJoined.substract(secondJoined));
	}
	
	@Test
	public void substracBCFromAB() {
		AttributeJoint expected = this.setUpObject.attrJnt_A();
		AttributeJoint firstJoined = this.setUpObject.attrJnt_AB();
		AttributeJoint secondJoined = this.setUpObject.attrJnt_BC();
		assertEquals(expected, firstJoined.substract(secondJoined));
	}
	
	@Test
	public void substracBCFromNull() {
		AttributeJoint expected = new AttributeJoint();
		AttributeJoint firstJoined = new AttributeJoint();
		AttributeJoint secondJoined = this.setUpObject.attrJnt_BC();
		assertEquals(expected, firstJoined.substract(secondJoined));
	}
	
	//Test isNull()
	@Test
	public void isNullNullAttributeJoint() {
		assertTrue(new AttributeJoint().isNull());
	}
	
	@Test
	public void isNullAttributeJointAB() {
		assertFalse(this.setUpObject.attrJnt_AB().isNull());
	}
	
	@Test
	public void isNullAttributeJointAMinusA() {
		AttributeJoint attrJnt = this.setUpObject.attrJnt_A();
		attrJnt.removeAttributes(this.setUpObject.attr_A());
		assertTrue(attrJnt.isNull());
	}
	
	//Test isKey()
	@Test
	public void isKeyResult_0_ABCRelationFive() {
		assertEquals(0, this.mainAttributeJoint.isKey(this.setUpObject.relation_05()));
	}
	
	@Test
	public void isKeyResult_1_ARelationFive() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_A();
		assertEquals(1, attrJoint.isKey(this.setUpObject.relation_05()));
	}
	
	@Test
	public void isKeyResult_neg1_ARelationFive() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_C();
		assertEquals(-1, attrJoint.isKey(this.setUpObject.relation_05()));
	}
	
	//Test isPartOf()
	@Test
	public void isPartOfTrue_AB_in_AB() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB(); 
		assertTrue(attrJoint.isPartOf(this.setUpObject.keyJoint_AB()));
	}
	
	@Test
	public void isPartOfTrue_AB_in_AB_AC() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB(); 
		assertTrue(attrJoint.isPartOf(this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void isPartOfFalse_AB_in_A() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB();
		assertFalse(attrJoint.isPartOf(this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void isPartOfTrue_A_in_AB() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_A();
		assertTrue(attrJoint.isPartOf(this.setUpObject.keyJoint_AB()));
	}
	
	@Test
	public void isPartOfFalse_A_in_NullKeyJoint() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_A();
		assertFalse(attrJoint.isPartOf(new KeyJoint()));
	}
	
	//Test containsJointsFrom()
	@Test
	public void containsJointsFromTrue_AB_From_A() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB();
		assertTrue(attrJoint.containsJoinsFrom(this.setUpObject.keyJoint_A()));
	}

	@Test
	public void containsJointsFromTrue_ABCD_From_CD_CE_CF_ABD_ABE_ABF() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ABCD();
		assertTrue(attrJoint.containsJoinsFrom(this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void containsJointsFromFalse_AB_From_CD_CE_CF_ABD_ABE_ABF() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_AB();
		assertFalse(attrJoint.containsJoinsFrom(this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void containsJointsFromFalse_B_From_A() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_B();
		assertFalse(attrJoint.containsJoinsFrom(this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void containsJointFromFalseNullKeyJoint() {
		AttributeJoint attrJoint = this.setUpObject.attrJnt_B();
		assertFalse(attrJoint.containsJoinsFrom(new KeyJoint()));
	}
}