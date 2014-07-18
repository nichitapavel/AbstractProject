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
}
