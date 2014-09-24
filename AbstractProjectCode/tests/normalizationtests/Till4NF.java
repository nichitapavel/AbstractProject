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
public class Till4NF {
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	public void normalizeRelation_1() {
		ArrayList<Relation> result = Normalization.normalize4NF(this.setUpObject.relation_01(), true);
		assertEquals(this.setUpObject.ArrayListR_ABC_AtoBC_BCtoA_ADE_ADtoE(), result);
	}
	
	@Test
	public void normalizeRelation_30() {
		ArrayList<Relation> result = Normalization.normalize4NF(this.setUpObject.relation_30(), true);
		assertEquals(this.setUpObject.ACD_ADtoC_CDtoA_AB_AtoB_AEF_AEtoF(), result);
	}
	
	@Test
	public void normalizeRelation_32() {
		ArrayList<Relation> result = Normalization.normalize4NF(this.setUpObject.relation_32(), true);
		assertEquals(this.setUpObject.BC_null_AB_AtoB(), result);
	}
	
	@Test
	public void normalizeRelation_34() {
		ArrayList<Relation> result = Normalization.normalize4NF(this.setUpObject.relation_34(), true);
		assertEquals(this.setUpObject.BC_null_AB_null(), result);
	}
	
	@Test
	public void normalizeRelation_35() {
		ArrayList<Relation> result = Normalization.normalize4NF(this.setUpObject.relation_35(), true);
		assertEquals(this.setUpObject.DF_null_AC_CtoA_BC_CtoB_CDE_CDtoE(), result);
	}
	
	@Test
	public void normalizeRelation_36() {
		ArrayList<Relation> result = Normalization.normalize4NF(this.setUpObject.relation_36(), true);
		assertEquals(this.setUpObject.CD_CtoD_ABC_BtoAC_AEF_null(), result);
	}
	
	@Test
	public void normalizeRelation_37() {
		ArrayList<Relation> result = Normalization.normalize4NF(this.setUpObject.relation_37(), true);
		assertEquals(this.setUpObject.AC_AtoC_AB_null_ADE_null(), result);
	}
}
