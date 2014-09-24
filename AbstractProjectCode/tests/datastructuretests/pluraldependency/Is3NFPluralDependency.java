package datastructuretests.pluraldependency;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.KeyJoint;
import datastructures.Relation;
import datastructures.dependency.ADependency;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Is3NFPluralDependency {
	private SetUpClass setUpObject;
	private ADependency pd;
	private KeyJoint keyJoint;
	private Relation relation;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	//3FN
	public void BtooC_R32() {
		this.pd = this.setUpObject.pluDep_B_to_C();
		this.relation = this.setUpObject.relation_32();
		this.keyJoint = this.setUpObject.keyJoint_AC();
		assertTrue(this.pd.is3NF(this.relation, this.keyJoint));
	}

	@Test
	//3FN
	public void BtooC_R34() {
		this.pd = this.setUpObject.pluDep_B_to_C();
		this.relation = this.setUpObject.relation_34();
		this.keyJoint = this.setUpObject.keyJoint_ABC();
		assertTrue(this.pd.is3NF(this.relation, this.keyJoint));
	}
	
	@Test
	//3FN
	public void DtooF_R35() {
		this.pd = this.setUpObject.pluDep_D_to_F();
		this.relation = this.setUpObject.relation_35();
		this.keyJoint = this.setUpObject.keyJoint_CDF();
		assertTrue(this.pd.is3NF(this.relation, this.keyJoint));
	}
	
	@Test
	//3FN
	public void DtooF_R35WithOutKeyJoint() {
		this.pd = this.setUpObject.pluDep_D_to_F();
		this.relation = this.setUpObject.relation_35();
		assertTrue(this.pd.is3NF(this.relation, null));
	}
	
	@Test
	//4FN
	public void DtooF_R38WithOutKeyJoint() {
		this.pd = this.setUpObject.pluDep_BC_to_AD();
		this.relation = this.setUpObject.relation_38();
		assertTrue(this.pd.is3NF(this.relation, null));
	}
}
