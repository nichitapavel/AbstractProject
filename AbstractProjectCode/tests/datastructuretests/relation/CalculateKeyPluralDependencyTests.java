package datastructuretests.relation;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.KeyJoint;
import datastructures.Relation;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculateKeyPluralDependencyTests {
	private SetUpClass setUpObject;
	private Relation relation;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	public void keyR30() {
		this.relation = this.setUpObject.relation_30();
		KeyJoint expected = this.setUpObject.keyJoint_DE();
		assertEquals(expected, this.relation.calculateKeyJoint());
	}
	
	@Test
	public void keyR31() {
		this.relation = this.setUpObject.relation_31();
		KeyJoint expected = this.setUpObject.keyJoint_AE_DE();
		assertEquals(expected, this.relation.calculateKeyJoint());
	}
	
	@Test
	public void keyR32() {
		this.relation = this.setUpObject.relation_32();
		KeyJoint expected = this.setUpObject.keyJoint_AC();
		assertEquals(expected, this.relation.calculateKeyJoint());
	}
	
	@Test
	public void keyR33() {
		this.relation = this.setUpObject.relation_33();
		KeyJoint expected = this.setUpObject.keyJoint_A();
		assertEquals(expected, this.relation.calculateKeyJoint());
	}
	
	@Test
	public void keyR34() {
		this.relation = this.setUpObject.relation_34();
		KeyJoint expected = this.setUpObject.keyJoint_ABC();
		assertEquals(expected, this.relation.calculateKeyJoint());
	}
	
	@Test
	public void keyR35() {
		this.relation = this.setUpObject.relation_35();
		KeyJoint expected = this.setUpObject.keyJoint_CDF();
		assertEquals(expected, this.relation.calculateKeyJoint());
	}
	
	@Test
	public void keyR36() {
		this.relation = this.setUpObject.relation_36();
		KeyJoint expected = this.setUpObject.keyJoint_BEF();
		assertEquals(expected, this.relation.calculateKeyJoint());
	}
	
	@Test
	public void keyR37() {
		this.relation = this.setUpObject.relation_37();
		KeyJoint expected = this.setUpObject.keyJoint_ABDE();
		assertEquals(expected, this.relation.calculateKeyJoint());
	}
}
