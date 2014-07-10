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
public class IsBCNFFunctionalDependencyTests {
	private SetUpClass setUpObject;

	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	//Test isBCNF
	@Test
	public void isBCNFTrue_BCD_E_InRelationOne() {
		ADependency funcDep = this.setUpObject.funcDep_BCD_to_E();
		Relation relationOne = this.setUpObject.relationOne(); 
		assertTrue(funcDep.isBCNF(relationOne));
	}
	
	@Test
	public void isBCNFTrue_CD_A_InRelationTwo() {
		ADependency funcDep = this.setUpObject.funcDep_CD_to_A();
		Relation relation = this.setUpObject.relationTwo(); 
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_ABD_G_InRelationThree() {
		ADependency funcDep = this.setUpObject.funcDep_ABD_to_G();
		Relation relation = this.setUpObject.relationThree(); 
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_CF_H_InRelationThree() {
		ADependency funcDep = this.setUpObject.funcDep_CF_to_H();
		Relation relation = this.setUpObject.relationThree(); 
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_A_BC_InRelationFour() {
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relationFour(); 
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_A_B_InRelationFour() {
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relationFour(); 
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_AB_C_InRelationFour() {
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relationFour(); 
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_A_B_InRelationFive() {
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relation_5(); 
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_AB_D_InRelationSix() {
		ADependency funcDep = this.setUpObject.funcDep_AB_to_D();
		Relation relation = this.setUpObject.relationSix(); 
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_A_B_InRelationSeven() {
		ADependency funcDep = this.setUpObject.funcDep_A_to_B();
		Relation relation = this.setUpObject.relationSeven();
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_AB_D_InRelationEight() {
		ADependency funcDep = this.setUpObject.funcDep_AB_to_D();
		Relation relation = this.setUpObject.relationEight();
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFTrue_AB_C_InRelationNine() {
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relationNine();
		assertTrue(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_A_BC_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relationOne();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_BC_A_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_A();
		Relation relation = this.setUpObject.relationOne();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_E_C_InRelationOne() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_C();
		Relation relation = this.setUpObject.relationOne();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_A_BC_InRelationTwo() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_A_to_BC();
		Relation relation = this.setUpObject.relationTwo();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_BC_E_InRelationTwo() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_BC_to_E();
		Relation relation = this.setUpObject.relationTwo();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_AB_C_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_AB_to_C();
		Relation relation = this.setUpObject.relationThree();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_C_AB_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_AB();
		Relation relation = this.setUpObject.relationThree();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_E_D_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_D();
		Relation relation = this.setUpObject.relationThree();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_D_E_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_D_to_E();
		Relation relation = this.setUpObject.relationThree();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_E_F_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_E_to_F();
		Relation relation = this.setUpObject.relationThree();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_F_E_InRelationThree() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_F_to_E();
		Relation relation = this.setUpObject.relationThree();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_B_C_InRelationFour() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relationFour();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_B_C_InRelationFive() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relation_5();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_B_C_InRelationSix() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relationSix();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_C_B_InRelationSix() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_B();
		Relation relation = this.setUpObject.relationSix();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_B_E_InRelationSix() {
		//1FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_E();
		Relation relation = this.setUpObject.relationSix();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_B_C_InRelationSeven() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relationSeven();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_C_D_InRelationSeven() {
		//2FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_D();
		Relation relation = this.setUpObject.relationSeven();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_B_C_InRelationEight() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_B_to_C();
		Relation relation = this.setUpObject.relationEight();
		assertFalse(funcDep.isBCNF(relation));
	}
	
	@Test
	public void isBCNFFalse_C_B_InRelationEight() {
		//3FN
		ADependency funcDep = this.setUpObject.funcDep_C_to_B();
		Relation relation = this.setUpObject.relationEight();
		assertFalse(funcDep.isBCNF(relation));
	}
	
}
