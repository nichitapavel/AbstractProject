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
public class Is2NFFunctionaDependencyTests {
	private SetUpClass setUpObject;

	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	//Test is2NF
	@Test
	public void is2NFTrue_BCD_E_InRelationOne() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_BCD_to_E();
		Relation relationOne = this.setUpObject.relation_01(); 
		assertTrue(funcDep.is2NF(relationOne, this.setUpObject.keyJoint_AD_BCD_BDE()));
	}
	
	@Test
	public void is2NFTrue_CD_A_InRelationTwo() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_CD_to_A();
		Relation relation = this.setUpObject.relation_02(); 
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AD_CD()));
	}
	
	@Test
	public void is2NFTrue_ABD_G_InRelationThree() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_ABD_to_G();
		Relation relation = this.setUpObject.relation_03(); 
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is2NFTrue_CF_H_InRelationThree() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_CF_to_H();
		Relation relation = this.setUpObject.relation_03(); 
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is2NFTrue_A_BC_InRelationFour() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relation_04(); 
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is2NFTrue_A_B_InRelationFour() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relation_04(); 
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is2NFTrue_AB_C_InRelationFour() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relation_04(); 
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is2NFTrue_A_B_InRelationFive() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relation_05(); 
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is2NFTrue_AB_D_InRelationSix() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_D();
		Relation relation = this.setUpObject.relation_06(); 
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is2NFTrue_A_B_InRelationSeven() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relation_07();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is2NFTrue_AB_D_InRelationEight() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_D();
		Relation relation = this.setUpObject.relation_08();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is2NFTrue_AB_C_InRelationNine() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relation_09();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AB()));
	}
	
	@Test
	public void is2NFTrue_A_BC_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relation_01();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AD_BCD_BDE()));
	}
	
	@Test
	public void is2NFTrue_BC_A_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_A();
		Relation relation = this.setUpObject.relation_01();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AD_BCD_BDE()));
	}
	
	@Test
	public void is2NFTrue_E_C_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_C();
		Relation relation = this.setUpObject.relation_01();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AD_BCD_BDE()));
	}

	@Test
	public void is2NFTrue_AB_C_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relation_03();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is2NFTrue_C_AB_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_AB();
		Relation relation = this.setUpObject.relation_03();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is2NFTrue_E_D_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_D();
		Relation relation = this.setUpObject.relation_03();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is2NFTrue_D_E_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_D_to_E();
		Relation relation = this.setUpObject.relation_03();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is2NFTrue_E_F_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_F();
		Relation relation = this.setUpObject.relation_03();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}
	
	@Test
	public void is2NFTrue_F_E_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_F_to_E();
		Relation relation = this.setUpObject.relation_03();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_CD_CE_CF_ABD_ABE_ABF()));
	}

	@Test
	public void is2NFTrue_B_C_InRelationSix() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_06();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is2NFTrue_C_B_InRelationSix() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_B();
		Relation relation = this.setUpObject.relation_06();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is2NFTrue_B_C_InRelationEight() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_08();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is2NFTrue_C_B_InRelationEight() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_B();
		Relation relation = this.setUpObject.relation_08();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void is2NFTrue_BC_E_InRelationTwo() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_E();
		Relation relation = this.setUpObject.relation_02();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_AD_CD()));
	}

	@Test
	public void is2NFTrue_B_C_InRelationFour() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_04();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is2NFTrue_B_C_InRelationFive() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_05();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}	

	@Test
	public void is2NFTrue_B_C_InRelationSeven() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_07();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is2NFTrue_C_D_InRelationSeven() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_D();
		Relation relation = this.setUpObject.relation_07();
		assertTrue(funcDep.is2NF(relation, this.setUpObject.keyJoint_A()));
	}
	
	@Test
	public void is2NFFalse_A_BC_InRelationTwo() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relation_02();
		assertFalse(funcDep.is2NF(relation, this.setUpObject.keyJoint_AD_CD()));
	}
	
	@Test
	public void is2NFFalse_B_E_InRelationSix() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_E();
		Relation relation = this.setUpObject.relation_06();
		assertFalse(funcDep.is2NF(relation, this.setUpObject.keyJoint_AB_AC()));
	}
	
	@Test
	public void nullKeyJointIs2NFTrue_BCD_E_InRelationOne() {
		//BCFN
		ADependency funcDep = this.setUpObject.funcDep_BCD_to_E();
		Relation relationOne = this.setUpObject.relation_01(); 
		assertTrue(funcDep.is2NF(relationOne, null));
	}
	
	@Test
	public void nullKeyJointIs2NFTrue_A_BC_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relation_01();
		assertTrue(funcDep.is2NF(relation, null));
	}
	
	@Test
	public void nullKeyJointIs2NFTrue_BC_E_InRelationTwo() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_E();
		Relation relation = this.setUpObject.relation_02();
		assertTrue(funcDep.is2NF(relation, null));
	}
	
	@Test
	public void nullKeyJointIs2NFFalse_A_BC_InRelationTwo() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relation_02();
		assertFalse(funcDep.is2NF(relation, null));
	}
}
