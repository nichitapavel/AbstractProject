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
public class TillBCNF {
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	public void normalizeRelation_1() {
		ArrayList<Relation> result = Normalization.normalizeBCNF(this.setUpObject.relationOne(), true);
		assertEquals(this.setUpObject.VectorR_ABC_AtoBC_BCtoA_ADE_ADtoE(), result);
	}
	
	@Test
	public void normalizeRelation_2() {
		ArrayList<Relation> result = Normalization.normalizeBCNF(this.setUpObject.relationTwo(), true);
		assertEquals(this.setUpObject.VectorR_ABC_AtoBC_AE_AtoE_AD_null(), result);
	}
	
	@Test
	public void normalizeRelation_3() {
		ArrayList<Relation> result = Normalization.normalizeBCNF(this.setUpObject.relationThree(), true);
		assertEquals(this.setUpObject.VectorR_ABC_ABtoC_CtoAB_DE_EtoD_DtoE_EF_EtoF_FtoE_ABEGH_ABEtoGH(), result);
	}
	
	@Test
	public void normalizeRelation_4() {
		ArrayList<Relation> result = Normalization.normalizeBCNF(this.setUpObject.relationFour(), true);
		assertEquals(this.setUpObject.VectorR_BC_BtoC_AB_AtoB(), result);
	}
	
	@Test
	public void normalizeRelation_5() {
		ArrayList<Relation> result = Normalization.normalizeBCNF(this.setUpObject.relation_5(), true);
		assertEquals(this.setUpObject.VectorR_BC_BtoC_AB_AtoB(), result);
	}
	
	@Test
	public void normalizeRelation_6() {
		ArrayList<Relation> result = Normalization.normalizeBCNF(this.setUpObject.relationSix(), true);
		assertEquals(this.setUpObject.VectorR_BC_BtoC_CtoB_BE_BtoE_ABD_ABtoD(), result);
	}
	
	@Test
	public void normalizeRelation_7() {
		ArrayList<Relation> result = Normalization.normalizeBCNF(this.setUpObject.relationSeven(), true);
		assertEquals(this.setUpObject.VectorR_BC_BtoC_BD_BtoD_AB_AtoB(), result);
	}
	
	@Test
	public void normalizeRelation_8() {
		ArrayList<Relation> result = Normalization.normalizeBCNF(this.setUpObject.relationEight(), true);
		assertEquals(this.setUpObject.VectorR_BC_BtoC_CtoB_ABD_ABtoD(), result);
	}
	
	@Test
	public void normalizeRelation_9() {
		ArrayList<Relation> expected = new ArrayList<>();
		expected.add(this.setUpObject.relationNine());
		assertEquals(expected, Normalization.normalizeBCNF(this.setUpObject.relationNine(), true));
	}
}
