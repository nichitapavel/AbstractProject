package datastructuretests.dfjoint;

import static org.junit.Assert.*;

import java.util.ArrayList;

import datastructuretests.setupclass.SetUpClass;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;


import org.junit.runners.MethodSorters;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.dependency.ADependency;
import datastructures.dependency.FunctionalDependency;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DFJointTests {
	private DFJoint nullDFJoint;
	private ArrayList<ADependency> DFJointVector;
	private ADependency one;
	private ADependency two;
	
	// DFJoint = {A -> BC, BC -> A, BCD -> E, E -> C}
	private DFJoint dfJoint;
	//firstDFJoint  = {A -> BC, B -> C, A -> B, AB -> C}
	private DFJoint firstDFJoint;
	//secondDFJoint = {A -> B, B -> C}
	private DFJoint secondDFJoint;
	
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
		nullDFJoint = new DFJoint();
		dfJoint = this.setUpObject.dfJoint_01();
		
		this.one = this.setUpObject.funcDep_A_to_B();
		this.two = this.setUpObject.funcDep_C_to_A();
		
		DFJointVector = new ArrayList<ADependency>();
		DFJointVector.add(this.one);
		DFJointVector.add(this.two);
		
		//firstDFJoint  = {A -> BC, B -> C, A -> B, AB -> C}
		firstDFJoint = this.setUpObject.dfJoint_04();
		
		//secondDFJoint = {A -> B, B -> C}
		secondDFJoint = this.setUpObject.dfJoint_05();
	}
	
	@Test
	public void constructorVoid() {
		assertEquals(0, nullDFJoint.getDFJoint().size());
	}
	
	@Test
	public void constructorArgumentVector() {
		DFJoint auxDFJoint = new DFJoint(DFJointVector);
		
		assertEquals(2, auxDFJoint.getDFJoint().size());
		assertEquals(this.one, auxDFJoint.getDFJoint().get(0));
		assertEquals(this.two, auxDFJoint.getDFJoint().get(1));
	}
	
	@Test
	public void constructorArgumentDFJoint() {
		DFJoint auxDFJoint = new DFJoint(DFJointVector);
		DFJoint testDFJoint = new DFJoint(auxDFJoint);
		assertEquals(DFJointVector, testDFJoint.getDFJoint());
		assertEquals(auxDFJoint.getName(), testDFJoint.getName());
	}
	
	//Test getter
	@Test
	public void getDFJointNotEqualZero() {
		assertNotEquals(0, dfJoint.getDFJoint().size());
	}
	
	@Test
	public void getDFJointEqual() {
		assertEquals(4, dfJoint.getDFJoint().size());
	}
	
	@Test
	public void getDFJointNotNull() {
		for (ADependency item : dfJoint.getDFJoint())
			assertNotNull(item);
	}
	
	@Test
	public void getDFJoint() {
		String [] antecedent = {"A"};
		String [] consequent = {"B", "C"};
		FunctionalDependency expected = new FunctionalDependency(
				new AttributeJoint(antecedent), new AttributeJoint(consequent)
				);
		
		assertEquals(expected, dfJoint.getDFJoint().get(0));
	}
	
	//Test setter
	@Test
	public void setDFJoint() {
		nullDFJoint.setDFJoint(DFJointVector);
		assertEquals(DFJointVector, nullDFJoint.getDFJoint());
	}
	
	@Test
	public void setDFJointAssertSize() {
		nullDFJoint.setDFJoint(DFJointVector);
		assertEquals(2, nullDFJoint.getDFJoint().size());
	}
	
	@Test
	public void setDFJointAssertFunctionalDependencies() {
		nullDFJoint.setDFJoint(DFJointVector);
		assertEquals(this.one, nullDFJoint.getDFJoint().get(0));
		assertEquals(this.two, nullDFJoint.getDFJoint().get(1));
	}
	
	//Test toString()
	@Test
	public void toStringTest() {
		String msg = "{ ({A} -> {B, C}), ({B, C} -> {A}), ({B, C, D} -> {E}), ({E} -> {C}) }";
		assertEquals(msg, dfJoint.toString());
	}
	
	@Test
	public void toStringNullValuesObject() {
		assertEquals("null", nullDFJoint.toString());
	}
	
	//Test iterator
	@Test
	public void iterator() {
		for (ADependency item : dfJoint)
			assertNotNull(item);
	}
	
	//Test addFunctionalDependency()
	@Test
	public void addFuncDepToEmptyDFJoint() {
		nullDFJoint.addFunctionalDependency(this.one);
		assertEquals(1, nullDFJoint.getDFJoint().size());
		assertEquals(this.one, nullDFJoint.getDFJoint().get(0));
	}
	
	@Test
	public void addFuncDepToNormalDFJoint() {
		dfJoint.addFunctionalDependency(this.one);
		assertEquals(5, dfJoint.getDFJoint().size());
		assertEquals(this.one, dfJoint.getDFJoint().get(4));
	}
	
	@Test
	public void addFuncDepThatExist() {
		DFJoint expected = this.setUpObject.dfJoint_04();
		this.firstDFJoint.addFunctionalDependency(this.setUpObject.funcDep_A_to_BC());
		assertEquals(expected, this.firstDFJoint);
	}
	
	//Test getSize()
	@Test
	public void getSizeDFJoint() {
		assertEquals(4, dfJoint.getSize());
	}
	
	@Test
	public void getSizeNullDFJoint() {
		assertEquals(0, nullDFJoint.getSize());
	}
	
	@Test
	public void getSizeNullDfJointVector() {
		nullDFJoint.setDFJoint(null);
		assertEquals(0, nullDFJoint.getSize());
	}
	
	//Test hashCode()
	@Test
	public void hashCodeDFJointsWithSameValues() {
		DFJoint auxDFJoint = new SetUpClass().dfJoint_01();
		assertEquals(dfJoint.hashCode(), auxDFJoint.hashCode());
	}
	
	@Test
	public void hashCodeDifferentDFJoints() {
		assertNotEquals(dfJoint.hashCode(), nullDFJoint.getDFJoint());
	}
	
	@Test
	public void hashCodeEmptyValueDFJoint() {
		nullDFJoint.setDFJoint(null);
		assertEquals(31, nullDFJoint.hashCode());
	}
	
	//Test equals()
	@Test
	public void equalsTrueSameObject() {
		assertTrue(dfJoint.equals(dfJoint));
	}
	
	@Test
	public void equalsFalseNullObject() {
		assertFalse(dfJoint.equals(null));
	}
	
	@Test
	public void equalsFalseDifferentClassObject() {
		Attribute A = new Attribute("A");
		assertFalse(dfJoint.equals(A));
	}
	
	@Test
	public void equalsFalseDFJointWithNullValue() {
		nullDFJoint.setDFJoint(null);
		assertFalse(nullDFJoint.equals(dfJoint));
	}
	
	@Test
	public void equalsFalseDFJointWithDifferentValues() {
		nullDFJoint.addFunctionalDependency(this.one);
		assertFalse(dfJoint.equals(nullDFJoint));
	}
	
	@Test
	public void equalsTrueDFJoints() {
		DFJoint auxDFJoint = new SetUpClass().dfJoint_01();
		assertTrue(dfJoint.equals(auxDFJoint));
	}
	
	@Test
	public void equalsTrueNullDFJoint() {
		nullDFJoint.setDFJoint(null);
		dfJoint.setDFJoint(null);
		assertTrue(dfJoint.equals(nullDFJoint));
	}
	
	//Test isImplied()
	@Test
	public void isImpliedTrueFirstToSecondDFJoint() {
		assertTrue(firstDFJoint.isImplied(secondDFJoint));
	}
	
	@Test
	public void isImpliedTrueSecondToFirstDFJoint() {
		assertTrue(secondDFJoint.isImplied(firstDFJoint));
	}
	
	@Test
	public void isImpliedFalseDFJointObjectToFirsDFJoint() {
		assertFalse(dfJoint.isImplied(firstDFJoint));
	}
	
	//Test contains()
	@Test
	public void containsTrue() {
		assertTrue(this.firstDFJoint.contains(this.setUpObject.funcDep_A_to_BC()));
	}
	
	@Test
	public void containsFalse() {
		assertFalse(this.firstDFJoint.contains(this.setUpObject.funcDep_E_to_C()));
	}
	
	//Test removeDF()
	@Test 
	public void removeDFJoint_OneMinusAtoBC() {
		this.dfJoint.removeDF(this.setUpObject.funcDep_A_to_BC());
		assertEquals(this.setUpObject.dfJoint_1MinusAtoBC(), this.dfJoint);
	}
	
	@Test
	public void removeDFJoint_FiveMinusBtoC() {
		this.dfJoint = this.setUpObject.dfJoint_05();
		this.dfJoint.removeDF(this.setUpObject.funcDep_B_to_C());
		assertEquals(this.setUpObject.dfJoint_5MinusBtoC(), this.dfJoint);
	}
	
	@Test
	public void removeDFJoint_AnNonExistentFD() {
		DFJoint dfJointCopy = new DFJoint(this.dfJoint);
		this.dfJoint.removeDF(this.setUpObject.funcDep_DE_to_C());
		assertEquals(dfJointCopy, this.dfJoint);
	}
	
	@Test
	public void removeDFJointTwentyTwoAndLeaveItEmpty() {
		this.dfJoint = this.setUpObject.dfJoint_22();
		this.dfJoint.removeDF(this.setUpObject.funcDep_B_to_C());
		assertEquals("null", this.dfJoint.toString());
		assertEquals(this.nullDFJoint, this.dfJoint);
	}
	
	@Ignore
	public void removeDFJointException() {
		this.nullDFJoint.removeDF(this.one);
	}
	
	//Test getName() and setName()
	@Test
	public void setNameDFJointOne() {
		String expected = "DFJoint";
		this.nullDFJoint.setName(expected);
		assertEquals(expected, this.nullDFJoint.getName());
	}
	
	@Test
	public void getNameDFJointVoid() {
		String expected = "No name";
		assertEquals(expected, this.nullDFJoint.getName());
	}
	
	//Test removeAttribute()
	@Test
	public void removeAttributeC_AtoBC_DFJoint4_Consequent() {
		this.firstDFJoint.removeAttribute(this.setUpObject.rareElementC_AtoBC_DFJoint4_Consequent());
		assertEquals(this.setUpObject.dfJoint_4ReGroupedWithoutCinAtoBC(), this.firstDFJoint);
	}
	
	@Test
	public void removeAttributeA_ABtoC_DFJoint4_Antecedent() {
		this.firstDFJoint.removeAttribute(this.setUpObject.rareElementA_ABtoC_DFJoint4_Antecedent());
		assertEquals(this.setUpObject.dfJoint_4RegroupedWithoutAinABtoC(), this.firstDFJoint);
	}
	
	@Test
	public void removeAttributeB_ABtoC_DFJoint4_Antecedent() {
		this.firstDFJoint.removeAttribute(this.setUpObject.rareElementB_ABtoC_DFJoint4_Antecedent());
		assertEquals(this.setUpObject.dfJoint_4RegroupedWithoutAinABtoC(), this.firstDFJoint);
	}
	
	@Test
	public void removeAttributeC_AtoBC_DFJoint24_Consequent() {
		DFJoint newDFjoint = this.setUpObject.dfJoint_24();
		newDFjoint.removeAttribute(this.setUpObject.rareElementC_AtoBC_DFJoint24_Consequent());
		assertEquals(this.setUpObject.dfJoint_4ReGroupedWithoutCinAtoBC(), newDFjoint);
	}
	
	@Test
	public void removeAttributeA_ABtoC_DFJoint24_Antecedent() {
		DFJoint newDFjoint = this.setUpObject.dfJoint_24();
		newDFjoint.removeAttribute(this.setUpObject.rareElementA_ABtoC_DFJoint24_Antecedent());
		assertEquals(this.setUpObject.dfJoint_4RegroupedWithoutAinABtoC(), newDFjoint);
	}
	
	@Test
	public void removeAttributeB_ABtoC_DFJoint24_Antecedent() {
		DFJoint newDFjoint = this.setUpObject.dfJoint_24();
		newDFjoint.removeAttribute(this.setUpObject.rareElementB_ABtoC_DFJoint24_Antecedent());
		assertEquals(this.setUpObject.dfJoint_4RegroupedWithoutAinABtoC(), newDFjoint);
	}
	
	//Test removeRareAttributesAuto()
	@Test
	public void removeRareAttributesAutoDFJoint24() {
		DFJoint expected = this.setUpObject.dfJoint_05();
		DFJoint toBeMinimal = this.setUpObject.dfJoint_24();
		toBeMinimal.removeRareAttributes(true);
		assertEquals(expected, toBeMinimal);
	}
	
	@Test
	public void removeRareAttributesAutoDFJoint4() {
		DFJoint expected = this.setUpObject.dfJoint_05();
		DFJoint toBeMinimal = this.setUpObject.dfJoint_04();
		toBeMinimal.removeRareAttributes(true);
		assertEquals(expected, toBeMinimal);
	}
	
	//Test isMinimal()
	@Test
	public void isMinimalDFJoint4() {
		assertFalse(this.firstDFJoint.isMinimal());
	}
	
	@Test
	public void isMinimalDFJoint24() {
		this.dfJoint = this.setUpObject.dfJoint_24();
		assertFalse(this.dfJoint.isMinimal());
	}
	
	@Test
	public void isMinimalDFJoint1() {
		this.dfJoint = this.setUpObject.dfJoint_01();
		assertTrue(this.dfJoint.isMinimal());
	}
	
	@Test
	public void isMinimalDFJoint2() {
		this.dfJoint = this.setUpObject.dfJoint_02();
		assertTrue(this.dfJoint.isMinimal());
	}
	
	@Test
	public void isMinimalDFJoint3() {
		this.dfJoint = this.setUpObject.dfJoint_03();
		assertTrue(this.dfJoint.isMinimal());
	}
	
	@Test
	public void isMinimalDFJoint23() {
		this.dfJoint = this.setUpObject.dfJoint_23();
		assertTrue(this.dfJoint.isMinimal());
	}
	
	@Test
	public void isMinimalDFJoint28() {
		this.dfJoint = this.setUpObject.dfJoint_28();
		assertTrue(this.dfJoint.isMinimal());
	}
	
	//Test getNonBCNF_DFs
	@Test
	public void getNonBCNF_DFs_DFJoint1() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint1();
		this.dfJoint = this.setUpObject.dfJoint_01();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_01()));	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint2() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint2();		
		this.dfJoint = this.setUpObject.dfJoint_02();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_02()));	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint3() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint3();		
		this.dfJoint = this.setUpObject.dfJoint_03();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_03()));	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint4() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint4_5();		
		this.dfJoint = this.setUpObject.dfJoint_04();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_04()));
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint5() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint4_5();		
		this.dfJoint = this.setUpObject.dfJoint_05();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_05()));	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint6() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint6();		
		this.dfJoint = this.setUpObject.dfJoint_06();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_06()));	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint7() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint7();		
		this.dfJoint = this.setUpObject.dfJoint_07();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_07()));
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint8() {
		ArrayList<ADependency> expected = this.setUpObject.arrayListNonBCNFDFJoint8();		
		this.dfJoint = this.setUpObject.dfJoint_08();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_08()));	
	}
	
	@Test
	public void getNonBCNF_DFs_DFJoint9() {
		ArrayList<ADependency> expected = new ArrayList<>();
		
		this.dfJoint = this.setUpObject.dfJoint_09();
		assertEquals(expected, this.dfJoint.getNonBCNF_DFs(this.setUpObject.relation_09()));
	}
	
	//Test getNon3NF_DFs
	@Test
	public void getNon3NF_DFs_DFJoint1() {
		ArrayList<ADependency> expected = new ArrayList<>();
				
		this.dfJoint = this.setUpObject.dfJoint_01();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_01()));	
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint2() {
		ArrayList<ADependency> expected = new ArrayList<>();
		expected.add(this.setUpObject.funcDep_A_to_BC());
		expected.add(this.setUpObject.funcDep_BC_to_E());
		
		this.dfJoint = this.setUpObject.dfJoint_02();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_02()));	
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint3() {
		ArrayList<ADependency> expected = new ArrayList<>();
				
		this.dfJoint = this.setUpObject.dfJoint_03();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_03()));	
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint4() {
		ArrayList<ADependency> expected = new ArrayList<>();
		expected.add(this.setUpObject.funcDep_B_to_C());
		
		this.dfJoint = this.setUpObject.dfJoint_04();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_04()));
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint5() {
		ArrayList<ADependency> expected = new ArrayList<>();
		expected.add(this.setUpObject.funcDep_B_to_C());
		
		this.dfJoint = this.setUpObject.dfJoint_05();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_05()));	
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint6() {
		ArrayList<ADependency> expected = new ArrayList<>();
		expected.add(this.setUpObject.funcDep_B_to_E());
		
		this.dfJoint = this.setUpObject.dfJoint_06();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_06()));	
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint7() {
		ArrayList<ADependency> expected = new ArrayList<>();
		expected.add(this.setUpObject.funcDep_B_to_C());
		expected.add(this.setUpObject.funcDep_C_to_D());
		
		this.dfJoint = this.setUpObject.dfJoint_07();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_07()));
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint8() {
		ArrayList<ADependency> expected = new ArrayList<>();
		
		this.dfJoint = this.setUpObject.dfJoint_08();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_08()));	
	}
	
	@Test
	public void getNon3NF_DFs_DFJoint9() {
		ArrayList<ADependency> expected = new ArrayList<>();
		
		this.dfJoint = this.setUpObject.dfJoint_09();
		assertEquals(expected, this.dfJoint.getNon3NF_DFs(this.setUpObject.relation_09()));
	}
	
	//getAttributesDFJoint
	@Test
	public void getAttributesDFJointTest() {
		AttributeJoint attrJointFromDF = dfJoint.getAttributesDFJoint();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ABCDE();
		
		assertEquals(attrJoint, attrJointFromDF);
	}
	
	@Test
	public void getAttributesFirstDFJointTest() {
		AttributeJoint attrJointFromDF = firstDFJoint.getAttributesDFJoint();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ABC();
		
		assertEquals(attrJoint, attrJointFromDF);
	}
	
	@Test
	public void getAttributesSecondDFJointTest() {
		AttributeJoint attrJointFromDF = secondDFJoint.getAttributesDFJoint();
		AttributeJoint attrJoint = this.setUpObject.attrJnt_ABC();
		
		assertEquals(attrJoint, attrJointFromDF);
	}
}
