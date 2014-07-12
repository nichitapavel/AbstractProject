package datastructuretests.keyjoint;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.AttributeJoint;
import datastructures.KeyJoint;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KeyJointTests {
	private KeyJoint nullKeyJoint;
	private KeyJoint keyJoint;
	
	private ArrayList<AttributeJoint> keysVector;
	
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.nullKeyJoint = new KeyJoint();
		
		this.setUpObject = new SetUpClass();
		
		this.keysVector = new ArrayList<>();
		this.keysVector.add(this.setUpObject.attrJnt_AB());
		this.keysVector.add(this.setUpObject.attrJnt_AC());
				
		this.keyJoint = new KeyJoint(this.keysVector);
	}
	
	//Getter
	@Test
	public void getterNullKeyJoint() {
		assertNull(this.nullKeyJoint.getKeyJoint());
	}
	
	@Test
	public void getterKeyJoint() {
		assertEquals(this.keysVector, this.keyJoint.getKeyJoint());
	}
	
	@Test
	public void getterKeyJointNotEqual() {
		String [] keyStringAB = {"A", "B"};
		AttributeJoint attrJnt_AB = new AttributeJoint(keyStringAB);
				
		String [] keyStringAC = {"A", "C"};
		AttributeJoint attrJnt_AC = new AttributeJoint(keyStringAC);
				
		ArrayList<AttributeJoint> keysVector = new ArrayList<>();
		keysVector.add(attrJnt_AB);
		keysVector.add(attrJnt_AC);
		
		KeyJoint keyJoint = new KeyJoint(this.keysVector);
		
		assertEquals(keyJoint, this.keyJoint);
	}
	
	//Test toString()
	@Test
	public void toStringTest() {
		String msg = "{{A, B}, {A, C}}";
		assertEquals(msg, this.keyJoint.toString());
	}
	
	@Test
	public void toStringTestFail() {
		assertEquals("null", this.nullKeyJoint.toString());
	}
	
	//equals()
	@Test
	public void equalsTrue() {
		String [] keyStringAB = {"A", "B"};
		AttributeJoint attrJnt_AB = new AttributeJoint(keyStringAB);
				
		String [] keyStringAC = {"A", "C"};
		AttributeJoint attrJnt_AC = new AttributeJoint(keyStringAC);
				
		ArrayList<AttributeJoint> keysVector = new ArrayList<>();
		keysVector.add(attrJnt_AB);
		keysVector.add(attrJnt_AC);
		
		KeyJoint keyJoint = new KeyJoint(this.keysVector);
		assertTrue(this.keyJoint.equals(keyJoint));
	}
	
	@Test
	public void equalsFalseDifferentClassObjects() {
		assertFalse(this.keyJoint.equals("fail"));
	}
	
	@Test
	public void equalsFalseNullObject() {
		assertFalse(this.nullKeyJoint.equals(this.keyJoint));
	}
	
	@Test
	public void equalsFalseNullKeyJointNotNullObject() {
		assertFalse(this.keyJoint.equals(this.nullKeyJoint));
	}
	
	@Test
	public void equalsTrueNullKeyJoints() {
		KeyJoint anotherNullJoint = new KeyJoint();
		assertTrue(this.nullKeyJoint.equals(anotherNullJoint));
	}
	
	//Test addKey()
	@Test
	public void addKeyToNullKeyJoint() {
		this.nullKeyJoint.addKey(this.setUpObject.attrJnt_B());
				
		ArrayList<AttributeJoint> keyVector = new ArrayList<>();
		keyVector.add(this.setUpObject.attrJnt_B());
		
		assertEquals(keyVector, this.nullKeyJoint.getKeyJoint());
	}
	
	@Test
	public void addKeyToKeyJoint() {
		this.keysVector.add(this.setUpObject.attrJnt_B());
		this.keyJoint.addKey(this.setUpObject.attrJnt_B());
		
		KeyJoint otherKeyJoint = new KeyJoint(this.keysVector); 
		
		assertEquals(this.keysVector, this.keyJoint.getKeyJoint());
		assertEquals(otherKeyJoint, this.keyJoint);
	}
	
	//Test iterator
	@Test
	public void iteratorTest() {
		for (AttributeJoint key : this.keyJoint) {
			assertNotNull(key);
		}
	}
	
	//Test getSize()
	@Test
	public void getSizeNormalKeyJoint() {
		assertEquals(2, this.keyJoint.getSize());
	}
	
	@Test
	public void getSizeVoidkeyJoint() {
		assertEquals(0, this.nullKeyJoint.getSize());
	}
	
}
