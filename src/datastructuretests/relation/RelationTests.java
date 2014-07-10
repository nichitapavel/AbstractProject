package datastructuretests.relation;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructuretests.setupclass.SetUpClass;
import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.dependency.ADependency;
import datastructures.KeyJoint;
import datastructures.Relation;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RelationTests {
	private Relation nullRelation;
	//AB -> D, B -> C, C -> B, B -> E
	private Relation firstFormRelation;
	//A -> B, B -> C, C -> D
	private Relation secondFormRelation;
	//B -> C, AB -> D, C -> B
	private Relation thirdFormRelation;
	//AB -> C
	private Relation boyceCoddFormRelation;
	//A -> BC, BC -> A, BCD -> E, E -> C
	private Relation one;
	
	//DFJoints
	private DFJoint secondFormRelationDFJoint;
	private DFJoint thirdFormRelationDFJoint;
	private DFJoint boyceCoddFormRelationDFJoint;
	
	//AttributesJoints of relations attributes
	private AttributeJoint secondAndThirdFormRelationAttributes;
	private AttributeJoint boyceCoddFormRelationAttributes;
	
	//KeyJoint
	private KeyJoint secondFormRelationKeyJoint;
	private KeyJoint thirdFormRelationKeyJoint;
	private KeyJoint boyceCoddFormRelationKeyJoint;
	
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
		
		this.nullRelation = new Relation();
		
		SetUpClass setUpObject = new SetUpClass();
		
		//DFJoints
		this.secondFormRelationDFJoint = setUpObject.dfJoint_07();
				
		this.thirdFormRelationDFJoint = setUpObject.dfJoint_08();
		
		this.boyceCoddFormRelationDFJoint = setUpObject.dfJoint_09();
		
		//AttributeJoints attributes of a relation
		this.secondAndThirdFormRelationAttributes = setUpObject.attrJnt_ABCD();
				
		this.boyceCoddFormRelationAttributes = setUpObject.attrJnt_ABC();

		//Relations
		this.firstFormRelation = new Relation(setUpObject.attrJnt_ABCDE(), setUpObject.dfJoint_06());
		this.secondFormRelation = new Relation(secondAndThirdFormRelationAttributes, secondFormRelationDFJoint);
		this.thirdFormRelation = new Relation(secondAndThirdFormRelationAttributes, thirdFormRelationDFJoint);
		this.boyceCoddFormRelation = new Relation(boyceCoddFormRelationAttributes, boyceCoddFormRelationDFJoint);
		this.one = this.setUpObject.relation_01();
		
		//KeyJoint
		ArrayList<AttributeJoint> keysVector = new ArrayList<>();
		keysVector.add(setUpObject.attrJnt_AB());
		
		this.boyceCoddFormRelationKeyJoint = new KeyJoint(keysVector);
		
		keysVector.add(setUpObject.attrJnt_AC());
		this.thirdFormRelationKeyJoint = new KeyJoint(keysVector);
				
		keysVector.clear();
		keysVector.add(setUpObject.attrJnt_A());
		
		this.secondFormRelationKeyJoint = new KeyJoint(keysVector);
	}
	
	//Test Constructors
	@Test
	public void constructorVoid() {
		assertNotNull(this.nullRelation);
	}
	
	@Test
	public void constructorBothArguments() {
		assertEquals(secondAndThirdFormRelationAttributes, secondFormRelation.getAttrJoint());
		assertEquals(secondFormRelationDFJoint, secondFormRelation.getDFJoint());
	}
	
	//Test getters
	@Test
	public void getterAttrJoint() {
		assertEquals(secondAndThirdFormRelationAttributes, secondFormRelation.getAttrJoint());
		assertEquals(secondAndThirdFormRelationAttributes, thirdFormRelation.getAttrJoint());
		assertEquals(boyceCoddFormRelationAttributes, boyceCoddFormRelation.getAttrJoint());
		assertNull(nullRelation.getAttrJoint());
	}
	
	@Test
	public void getterDFJoint() {
		assertEquals(secondFormRelationDFJoint, secondFormRelation.getDFJoint());
		assertEquals(thirdFormRelationDFJoint, thirdFormRelation.getDFJoint());
		assertEquals(boyceCoddFormRelationDFJoint, boyceCoddFormRelation.getDFJoint());
		assertNull(nullRelation.getDFJoint());
	}
	
	//Test setters
	@Test
	public void setterAttrJoint() {
		this.nullRelation.settAttrJoint(boyceCoddFormRelationAttributes);
		assertEquals(boyceCoddFormRelationAttributes, this.nullRelation.getAttrJoint());
	}
	
	@Test
	public void setterDFJoint() {
		this.nullRelation.setDFJoint(boyceCoddFormRelationDFJoint);
		assertEquals(boyceCoddFormRelationDFJoint, this.nullRelation.getDFJoint());
	}
	
	//Test FNBC
	@Test
	public void boyceCoddNormalFormTrue() {
		assertTrue(this.boyceCoddFormRelation.isBCNF());
	}
	
	@Test
	public void boyceCoddNormalFormFalse3NF() {
		assertFalse(this.thirdFormRelation.isBCNF());
	}
	
	@Test
	public void boyceCoddNormalFormFalse2NF() {
		assertFalse(this.secondFormRelation.isBCNF());
	}
	
	@Test
	public void boyceCoddNormalFormFalse1NF() {
		assertFalse(this.firstFormRelation.isBCNF());
	}
	
	@Test
	public void boyceCoddNormalFormTrueNullRelation() {
		assertTrue(this.nullRelation.isBCNF());
	}
	
	//Test toString()
	@Test
	public void toStringTest() {
		String msg2FN = "Atributos: {A, B, C, D} Dependencias Funcionales: { ({A} -> {B}), ({B} -> {C}), ({C} -> {D}) }";
		String msg3FN = "Atributos: {A, B, C, D} Dependencias Funcionales: { ({B} -> {C}), ({A, B} -> {D}), ({C} -> {B}) }";
		String msgBCFN = "Atributos: {A, B, C} Dependencias Funcionales: { ({A, B} -> {C}) }";
		assertEquals(msg2FN, this.secondFormRelation.toString());
		assertEquals(msg3FN, this.thirdFormRelation.toString());
		assertEquals(msgBCFN, this.boyceCoddFormRelation.toString());
	}
	
	@Test
	public void toStringTestNullAttrJoint() {
		String msg = "Sin Atributos Dependencias Funcionales: { ({A, B} -> {C}) }";
		this.nullRelation.setDFJoint(boyceCoddFormRelationDFJoint);
		assertEquals(msg, this.nullRelation.toString());
	}
	
	@Test
	public void toStringTestNullDFJoint() {
		String msg = "Atributos: {A, B, C} Sin Dependencias Funcionales";
		this.nullRelation.settAttrJoint(boyceCoddFormRelationAttributes);
		assertEquals(msg, this.nullRelation.toString());
	}
	
	@Test
	public void toStringTestVoidValuesRelation() {
		String msg = "Sin Atributos Sin Dependencias Funcionales";
		assertEquals(msg, this.nullRelation.toString());
	}
	//Test calculateKeyJoint
	@Test
	public void calculateKeySecondFormRelation() {
		//Clave = {A}
		KeyJoint result = this.secondFormRelation.calculateKeyJoint();
		assertEquals(this.secondFormRelationKeyJoint, result);
	}
	
	@Test
	public void calculateKeyThirdFormRelation() {
		//Clave = {AB, AC}
		KeyJoint result = this.thirdFormRelation.calculateKeyJoint();
		assertEquals(this.thirdFormRelationKeyJoint, result);
	}
	
	@Test
	public void calculateKeyBoyceCoddFormRelation() {
		//Clave = {AB}
		KeyJoint result = this.boyceCoddFormRelation.calculateKeyJoint();
		assertEquals(this.boyceCoddFormRelationKeyJoint, result);
	}
	
	//Test 3FN
	@Test
	public void normalForm3TrueFNBC() {
		assertTrue(this.boyceCoddFormRelation.is3NF());
	}
	
	@Test
	public void normalForm3True3FN() {
		assertTrue(this.thirdFormRelation.is3NF());
	}
	
	@Test
	public void normalForm3False2FN() {
		assertFalse(this.secondFormRelation.is3NF());
	}
	
	@Test
	public void normalForm3False1FN() {
		assertFalse(this.firstFormRelation.is3NF());
	}
	
	//Test 2FN
	@Test
	public void normalForm2TrueFNBC(){
		assertTrue(this.boyceCoddFormRelation.is2NF());
	}
	
	@Test
	public void normalForm2True3FN(){
		assertTrue(this.thirdFormRelation.is2NF());
	}
	
	@Test
	public void normalForm2True2FN(){
		assertTrue(this.secondFormRelation.is2NF());
	}
	
	@Test
	public void normalForm2True1FN(){
		assertFalse(this.firstFormRelation.is2NF());
	}
	
	@Test
	public void splitRelation_1_UsingAtoBC() {
		ArrayList<Relation> expected = new ArrayList<>();
		expected.add(this.setUpObject.relation_1ABC());
		expected.add(this.setUpObject.relation_1ADE());
		ArrayList<Relation> result = this.one.split(this.setUpObject.funcDep_A_to_BC());
		assertEquals(expected, result);
	}
	
	@Test
	public void splitRelation_1_UsingBCtoA() {
		ArrayList<Relation> expected = new ArrayList<>();
		expected.add(this.setUpObject.relation_1ABC());
		expected.add(this.setUpObject.relation_1BCDE());
		ArrayList<Relation> result = this.one.split(this.setUpObject.funcDep_BC_to_A());
		assertEquals(expected, result);
	}
	
	@Test
	public void splitRelation_1_UsingBCDtoE() {
		ArrayList<Relation> expected = new ArrayList<>();
		expected.add(this.setUpObject.relation_1BCDE());
		expected.add(this.setUpObject.relation_1ABCD());
		ArrayList<Relation> result = this.one.split(this.setUpObject.funcDep_BCD_to_E());
		assertEquals(expected, result);
	}
	
	@Test
	public void splitRelation_1_UsingEtoC() {
		ArrayList<Relation> expected = new ArrayList<>();
		expected.add(this.setUpObject.relation_1CE());
		expected.add(this.setUpObject.relation_1ABDE());
		ArrayList<Relation> result = this.one.split(this.setUpObject.funcDep_E_to_C());
		assertEquals(expected, result);
	}
	
	//Test getNonBCNF_DFs
	@Test
	public void getNonBCNF_DFs_DFJoint1() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint1();
		Relation relation = this.setUpObject.relation_01();
		assertEquals(expected, relation.getNonBCNF_DFs());	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint2() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint2();		
		Relation relation  = this.setUpObject.relation_02();
		assertEquals(expected, relation.getNonBCNF_DFs());	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint3() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint3();		
		Relation relation  = this.setUpObject.relation_03();
		assertEquals(expected, relation.getNonBCNF_DFs());	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint4() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint4_5();		
		Relation relation  = this.setUpObject.relation_04();
		assertEquals(expected, relation.getNonBCNF_DFs());
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint5() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint4_5();		
		Relation relation  = this.setUpObject.relation_05();
		assertEquals(expected, relation.getNonBCNF_DFs());	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint6() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint6();		
		Relation relation  = this.setUpObject.relation_06();
		assertEquals(expected, relation.getNonBCNF_DFs());	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint7() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint7();		
		Relation relation  = this.setUpObject.relation_07();
		assertEquals(expected, relation.getNonBCNF_DFs());
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint8() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint8();		
		Relation relation  = this.setUpObject.relation_08();
		assertEquals(expected, relation.getNonBCNF_DFs());	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint9() {
		ArrayList<ADependency> expected = new ArrayList<>();
		Relation relation  = this.setUpObject.relation_09();
		assertEquals(expected, relation.getNonBCNF_DFs());
	}
	
	//Test getNon3NF_DFs
	@Test
	public void getNon3NF_DFs_DFJoint1() {
		ArrayList<ADependency> expected = new ArrayList<>();
		Relation relation = this.setUpObject.relation_01();
		assertEquals(expected, relation.getNon3NF_DFs());
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint2() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint2();		
		Relation relation  = this.setUpObject.relation_02();
		assertEquals(expected, relation.getNon3NF_DFs());
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint3() {
		ArrayList<ADependency> expected = new ArrayList<>();
		Relation relation  = this.setUpObject.relation_03();
		assertEquals(expected, relation.getNon3NF_DFs());
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint4() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint4_5();
		Relation relation  = this.setUpObject.relation_04();
		assertEquals(expected, relation.getNon3NF_DFs());
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint5() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint4_5();
		Relation relation  = this.setUpObject.relation_05();
		assertEquals(expected, relation.getNonBCNF_DFs());
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint6() {
		ArrayList<ADependency> expected = new ArrayList<>();
		expected.add(this.setUpObject.funcDep_B_to_E());
		Relation relation  = this.setUpObject.relation_06();
		assertEquals(expected, relation.getNon3NF_DFs());
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint7() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint7();
		Relation relation  = this.setUpObject.relation_07();
		assertEquals(expected, relation.getNon3NF_DFs());
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint8() {
		ArrayList<ADependency> expected = new ArrayList<>();
		Relation relation  = this.setUpObject.relation_08();
		assertEquals(expected, relation.getNon3NF_DFs());
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint9() {
		ArrayList<ADependency> expected = new ArrayList<>();
		Relation relation  = this.setUpObject.relation_09();
		assertEquals(expected, relation.getNon3NF_DFs());
	}
}