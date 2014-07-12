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
public class Is4NFFunctionalDependencyTests {
	private SetUpClass setUpObject;

	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	//Test is4NF
	@Test
	public void is4NFTrue_BCD_E_InRelationOne() {
		ADependency funcDep = this.setUpObject.funcDep_BCD_to_E();
		Relation relationOne = this.setUpObject.relation_01(); 
		assertTrue(funcDep.is4NF(relationOne));
	}
	
	@Test
	public void is4NFTrue_CD_A_InRelationTwo() {
		ADependency funcDep = this.setUpObject.funcDep_CD_to_A();
		Relation relation = this.setUpObject.relation_02(); 
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_ABD_G_InRelationThree() {
		ADependency funcDep = this.setUpObject.funcDep_ABD_to_G();
		Relation relation = this.setUpObject.relation_03(); 
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_CF_H_InRelationThree() {
		ADependency funcDep = this.setUpObject.funcDep_CF_to_H();
		Relation relation = this.setUpObject.relation_03(); 
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_A_BC_InRelationFour() {
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relation_04(); 
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_A_B_InRelationFour() {
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relation_04(); 
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_AB_C_InRelationFour() {
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relation_04(); 
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_A_B_InRelationFive() {
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relation_05(); 
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_AB_D_InRelationSix() {
		ADependency funcDep = this.setUpObject.funcDep_AB_to_D();
		Relation relation = this.setUpObject.relation_06(); 
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_A_B_InRelationSeven() {
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relation_07();
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_AB_D_InRelationEight() {
		ADependency funcDep = this.setUpObject.funcDep_AB_to_D();
		Relation relation = this.setUpObject.relation_08();
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFTrue_AB_C_InRelationNine() {
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relation_09();
		assertTrue(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_A_BC_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relation_01();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_BC_A_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_A();
		Relation relation = this.setUpObject.relation_01();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_E_C_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_C();
		Relation relation = this.setUpObject.relation_01();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_A_BC_InRelationTwo() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relation_02();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_BC_E_InRelationTwo() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_E();
		Relation relation = this.setUpObject.relation_02();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_AB_C_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relation_03();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_C_AB_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_AB();
		Relation relation = this.setUpObject.relation_03();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_E_D_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_D();
		Relation relation = this.setUpObject.relation_03();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_D_E_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_D_to_E();
		Relation relation = this.setUpObject.relation_03();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_E_F_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_F();
		Relation relation = this.setUpObject.relation_03();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_F_E_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_F_to_E();
		Relation relation = this.setUpObject.relation_03();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_B_C_InRelationFour() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_04();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_B_C_InRelationFive() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_05();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_B_C_InRelationSix() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_06();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_C_B_InRelationSix() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_B();
		Relation relation = this.setUpObject.relation_06();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_B_E_InRelationSix() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_E();
		Relation relation = this.setUpObject.relation_06();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_B_C_InRelationSeven() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_07();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_C_D_InRelationSeven() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_D();
		Relation relation = this.setUpObject.relation_07();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_B_C_InRelationEight() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_08();
		assertFalse(funcDep.is4NF(relation));
	}
	
	@Test
	public void is4NFFalse_C_B_InRelationEight() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_B();
		Relation relation = this.setUpObject.relation_08();
		assertFalse(funcDep.is4NF(relation));
	}
	
}
