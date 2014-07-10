package normalizationtests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import normalization.Normalization;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructuretests.setupclass.SetUpClass;
import datastructures.Relation;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Till3NF {
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass(); 
	}
	
	@Test
	public void normalizeRelation_2() {
		ArrayList<Relation> result = Normalization.normalize3NF(this.setUpObject.relationTwo(), true);
		assertEquals(this.setUpObject.VectorR_ABC_AtoBC_AE_AtoE_AD_null(), result);
	}
	
	@Test
	public void normalizeRelation_3() {
		ArrayList<Relation> expected = new ArrayList<>();
		expected.add(this.setUpObject.relationThree());
		assertEquals(expected, Normalization.normalize3NF(this.setUpObject.relationThree(), true));
	}
	
	@Test
	public void normalizeRelation_4() {
		ArrayList<Relation> result = Normalization.normalize3NF(this.setUpObject.relationFour(), true);
		assertEquals(this.setUpObject.VectorR_BC_BtoC_AB_AtoB(), result);
	}
	
	@Test
	public void normalizeRelation_5() {
		ArrayList<Relation> result = Normalization.normalize3NF(this.setUpObject.relation_5(), true);
		assertEquals(this.setUpObject.VectorR_BC_BtoC_AB_AtoB(), result);
	}
	
	@Test
	public void normalizeRelation_6() {
		ArrayList<Relation> result = Normalization.normalize3NF(this.setUpObject.relationSix(), true);
		assertEquals(this.setUpObject.VectorR_BE_BtoE_ABCD_ABtoD_BtoC_CtoB(), result);
	}
	
	@Test
	public void normalizeRelation_7() {
		ArrayList<Relation> result = Normalization.normalize3NF(this.setUpObject.relationSeven(), true);
		assertEquals(this.setUpObject.VectorR_BC_BtoC_BD_BtoD_AB_AtoB(), result);
	}
	
	@Test
	public void normalizeRelation_8() {
		ArrayList<Relation> expected = new ArrayList<>();
		expected.add(this.setUpObject.relationEight());
		assertEquals(expected, Normalization.normalize3NF(this.setUpObject.relationEight(), true));
	}
	
	@Test
	public void normalizeRelation_9() {
		ArrayList<Relation> expected = new ArrayList<>();
		expected.add(this.setUpObject.relationNine());
		assertEquals(expected, Normalization.normalize3NF(this.setUpObject.relationNine(), true));
	}
}
