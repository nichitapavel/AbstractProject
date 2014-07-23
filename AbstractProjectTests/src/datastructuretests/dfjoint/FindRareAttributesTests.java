package datastructuretests.dfjoint;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.RareElement;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FindRareAttributesTests {
	private ArrayList<RareElement> rareAttributesVector;
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.rareAttributesVector = new ArrayList<>();
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	public void rareAttributesDFJointOne() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_01().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointTwentyFour() {
		this.rareAttributesVector.add( new RareElement(
				this.setUpObject.attr_C(),
				this.setUpObject.funcDep_A_to_BC(),
				this.setUpObject.dfJoint_24(),
				"Consequent"));
		this.rareAttributesVector.add( new RareElement(
				this.setUpObject.attr_A(),
				this.setUpObject.funcDep_AB_to_C(),
				this.setUpObject.dfJoint_24(),
				"Antecedent"));
		this.rareAttributesVector.add( new RareElement(
				this.setUpObject.attr_B(),
				this.setUpObject.funcDep_AB_to_C(),
				this.setUpObject.dfJoint_24(),
				"Antecedent"));
		
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_24().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointTwo() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_02().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointThree() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_03().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointFour() {
		this.rareAttributesVector.add(new RareElement(
				this.setUpObject.attr_B(),
				this.setUpObject.funcDep_A_to_BC(),
				this.setUpObject.dfJoint_04(),
				"Consequent")
		);
		this.rareAttributesVector.add(new RareElement(
				this.setUpObject.attr_C(),
				this.setUpObject.funcDep_A_to_BC(),
				this.setUpObject.dfJoint_04(),
				"Consequent")
		);
		this.rareAttributesVector.add(new RareElement(
				this.setUpObject.attr_A(),
				this.setUpObject.funcDep_AB_to_C(),
				this.setUpObject.dfJoint_04(),
				"Antecedent")
		);
		this.rareAttributesVector.add(new RareElement(
				this.setUpObject.attr_B(),
				this.setUpObject.funcDep_AB_to_C(),
				this.setUpObject.dfJoint_04(),
				"Antecedent")
		);
		
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_04().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointSix() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_06().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointEight() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_08().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointNine() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_09().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointTen() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_10().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointTwelve() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_12().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointFourteen() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_14().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointFifteen() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_15().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointSixteen() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_16().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointSeventeen() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_17().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointNineteen() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_19().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointTwentyThree() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_23().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointTwentySix() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_26().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointTwentySeven() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_27().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointOneMinusAtoBC() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_1MinusAtoBC().findRareAttributes());
	}
	
	@Test
	public void rareAttributesDFJointTwentyEight() {
		assertEquals(this.rareAttributesVector,
				this.setUpObject.dfJoint_28().findRareAttributes());
	}
}
