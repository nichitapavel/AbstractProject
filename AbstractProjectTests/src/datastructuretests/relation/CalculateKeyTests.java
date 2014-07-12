package datastructuretests.relation;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculateKeyTests {
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	public void relationOne() {
		assertEquals(this.setUpObject.keyJoint_AD_BCD_BDE(), this.setUpObject.relation_01().calculateKeyJoint());
	}
	
	@Test
	public void relationTwo() {
		assertEquals(this.setUpObject.keyJoint_AD_CD(), this.setUpObject.relation_02().calculateKeyJoint());
	}
	
	@Test
	public void relationThree() {
		assertEquals(this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF(), this.setUpObject.relation_03().calculateKeyJoint());
	}
	
	@Test
	public void relationFour() {
		assertEquals(this.setUpObject.keyJoint_A(), this.setUpObject.relation_04().calculateKeyJoint());
	}
	
	@Test
	public void relationFive() {
		assertEquals(this.setUpObject.keyJoint_A(), this.setUpObject.relation_05().calculateKeyJoint());
	}
	
	@Test
	public void relationSix() {
		assertEquals(this.setUpObject.keyJoint_AB_AC(), this.setUpObject.relation_06().calculateKeyJoint());
	}
	
	@Test
	public void relationSeven() {
		assertEquals(this.setUpObject.keyJoint_A(), this.setUpObject.relation_07().calculateKeyJoint());
	}
	
	@Test
	public void relationEight() {
		assertEquals(this.setUpObject.keyJoint_AB_AC(), this.setUpObject.relation_08().calculateKeyJoint());
	}
	
	@Test
	public void relationNine() {
		assertEquals(this.setUpObject.keyJoint_AB(), this.setUpObject.relation_09().calculateKeyJoint());
	}
}
