package datastructuretests.functionaldependency;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.dependency.ADependency;
import datastructures.Relation;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Is3FNFunctionalDependencyTests {
	private SetUpClass setUpObject;

	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	//Test is3NF
	@Test
	public void is3NFTrue_BCD_E_InRelationOne() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_BCD_to_E();
		Relation relationOne = this.setUpObject.relationOne(); 
		assertTrue(funcDep.is3NF(relationOne, this.setUpObject.keyJoint_AD_BCD_BDE()));
	}
	
	@Test
	public void is3NFTrue_CD_A_InRelationTwo() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_CD_to_A();
		Relation relation = this.setUpObject.relationTwo(); 
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AD_CD()));
	}
	
	@Test
	public void is3NFTrue_ABD_G_InRelationThree() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_ABD_to_G();
		Relation relation = this.setUpObject.relationThree(); 
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is3NFTrue_CF_H_InRelationThree() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_CF_to_H();
		Relation relation = this.setUpObject.relationThree(); 
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is3NFTrue_A_BC_InRelationFour() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relationFour(); 
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is3NFTrue_A_B_InRelationFour() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relationFour(); 
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is3NFTrue_AB_C_InRelationFour() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relationFour(); 
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is3NFTrue_A_B_InRelationFive() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relation_5(); 
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is3NFTrue_AB_D_InRelationSix() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_D();
		Relation relation = this.setUpObject.relationSix(); 
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is3NFTrue_A_B_InRelationSeven() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relationSeven();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is3NFTrue_AB_D_InRelationEight() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_D();
		Relation relation = this.setUpObject.relationEight();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is3NFTrue_AB_C_InRelationNine() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relationNine();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AB()));
	}
	
	@Test
	public void is3NFTrue_A_BC_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relationOne();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AD_BCD_BDE()));
	}
	
	@Test
	public void is3NFTrue_BC_A_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_A();
		Relation relation = this.setUpObject.relationOne();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AD_BCD_BDE()));
	}
	
	@Test
	public void is3NFTrue_E_C_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_C();
		Relation relation = this.setUpObject.relationOne();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AD_BCD_BDE()));
	}

	@Test
	public void is3NFTrue_AB_C_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relationThree();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is3NFTrue_C_AB_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_AB();
		Relation relation = this.setUpObject.relationThree();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is3NFTrue_E_D_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_D();
		Relation relation = this.setUpObject.relationThree();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is3NFTrue_D_E_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_D_to_E();
		Relation relation = this.setUpObject.relationThree();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is3NFTrue_E_F_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_F();
		Relation relation = this.setUpObject.relationThree();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is3NFTrue_F_E_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_F_to_E();
		Relation relation = this.setUpObject.relationThree();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}

	@Test
	public void is3NFTrue_B_C_InRelationSix() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relationSix();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is3NFTrue_C_B_InRelationSix() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_B();
		Relation relation = this.setUpObject.relationSix();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is3NFTrue_B_C_InRelationEight() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relationEight();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is3NFTrue_C_B_InRelationEight() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_B();
		Relation relation = this.setUpObject.relationEight();
		assertTrue(funcDep.is3NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is3NFFalse_BC_E_InRelationTwo() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_E();
		Relation relation = this.setUpObject.relationTwo();
		assertFalse(funcDep.is3NF(relation, this.setUpObject.keyJoint_AD_CD()));
	}

	@Test
	public void is3NFFalse_B_C_InRelationFour() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relationFour();
		assertFalse(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is3NFFalse_B_C_InRelationFive() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_5();
		assertFalse(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}	

	@Test
	public void is3NFFalse_B_C_InRelationSeven() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relationSeven();
		assertFalse(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is3NFFalse_C_D_InRelationSeven() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_D();
		Relation relation = this.setUpObject.relationSeven();
		assertFalse(funcDep.is3NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is3NFFalse_A_BC_InRelationTwo() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relationTwo();
		assertFalse(funcDep.is3NF(relation, this.setUpObject.keyJoint_AD_CD()));
	}
	
	@Test
	public void is3NFFalse_B_E_InRelationSix() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_E();
		Relation relation = this.setUpObject.relationSix();
		assertFalse(funcDep.is3NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void nullKeyJointIs3NFTrue_BCD_E_InRelationOne() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_BCD_to_E();
		Relation relationOne = this.setUpObject.relationOne(); 
		assertTrue(funcDep.is3NF(relationOne, null));
	}
	
	@Test
	public void nullKeyJointIs3NFTrue_A_BC_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relationOne();
		assertTrue(funcDep.is3NF(relation, null));
	}
	
	@Test
	public void nullKeyJointIs3NFFalse_BC_E_InRelationTwo() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_E();
		Relation relation = this.setUpObject.relationTwo();
		assertFalse(funcDep.is3NF(relation, null));
	}
	
	@Test
	public void nullKeyJointIs3NFFalse_A_BC_InRelationTwo() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relationTwo();
		assertFalse(funcDep.is3NF(relation, null));
	}
}
