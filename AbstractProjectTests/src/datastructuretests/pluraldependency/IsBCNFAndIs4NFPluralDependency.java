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
public class IsBCNFAndIs4NFPluralDependency {
	private SetUpClass setUpObject;
	private ADependency pd;
	private KeyJoint keyJoint;
	private Relation relation;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	
	@Test
	//1FN
	public void AtooBC_R37() {
		this.pd = this.setUpObject.pluDep_A_to_BC();
		this.relation = this.setUpObject.relation_37();
		this.keyJoint = this.setUpObject.keyJoint_ABDE();
		assertFalse(this.pd.isBCNF(this.relation, this.keyJoint));
		assertFalse(this.pd.is4NF(this.relation, this.keyJoint));
	}
	
	@Test
	//1FN
	public void AtooCD_R31() {
		this.pd = this.setUpObject.pluDep_A_to_CD();
		this.relation = this.setUpObject.relation_31();
		this.keyJoint = this.setUpObject.keyJoint_AE_DE();
		assertFalse(this.pd.isBCNF(this.relation, this.keyJoint));
		assertFalse(this.pd.is4NF(this.relation, this.keyJoint));
	}
	
	@Test
	//2FN
	public void AtooCD_R30() {
		this.pd = this.setUpObject.pluDep_A_to_CD();
		this.relation = this.setUpObject.relation_30();
		this.keyJoint = this.setUpObject.keyJoint_DE();
		assertFalse(this.pd.isBCNF(this.relation, this.keyJoint));
		assertFalse(this.pd.is4NF(this.relation, this.keyJoint));
	}
	
	@Test
	//2FN
	public void BtooC_R33() {
		this.pd = this.setUpObject.pluDep_B_to_C();
		this.relation = this.setUpObject.relation_33();
		this.keyJoint = this.setUpObject.keyJoint_A();
		assertFalse(this.pd.isBCNF(this.relation, this.keyJoint));
		assertFalse(this.pd.is4NF(this.relation, this.keyJoint));
	}
	
	@Test
	//2FN
	public void AtooBCD_R36() {
		this.pd = this.setUpObject.pluDep_A_to_BCD();
		this.relation = this.setUpObject.relation_36();
		this.keyJoint = this.setUpObject.keyJoint_BEF();
		assertFalse(this.pd.isBCNF(this.relation, this.keyJoint));
		assertFalse(this.pd.is4NF(this.relation, this.keyJoint));
	}
	
	@Test
	//3FN
	public void BtooC_R32() {
		this.pd = this.setUpObject.pluDep_B_to_C();
		this.relation = this.setUpObject.relation_32();
		this.keyJoint = this.setUpObject.keyJoint_AC();
		assertFalse(this.pd.isBCNF(this.relation, this.keyJoint));
		assertFalse(this.pd.is4NF(this.relation, this.keyJoint));
	}

	@Test
	//3FN
	public void BtooC_R34() {
		this.pd = this.setUpObject.pluDep_B_to_C();
		this.relation = this.setUpObject.relation_34();
		this.keyJoint = this.setUpObject.keyJoint_ABC();
		assertFalse(this.pd.isBCNF(this.relation, this.keyJoint));
		assertFalse(this.pd.is4NF(this.relation, this.keyJoint));
	}
	
	@Test
	//3FN
	public void DtooF_R35() {
		this.pd = this.setUpObject.pluDep_D_to_F();
		this.relation = this.setUpObject.relation_35();
		this.keyJoint = this.setUpObject.keyJoint_CDF();
		assertFalse(this.pd.isBCNF(this.relation, this.keyJoint));
		assertFalse(this.pd.is4NF(this.relation, this.keyJoint));
	}
	
	@Test
	//3FN
	public void DtooF_R35WithOutKeyJoint() {
		this.pd = this.setUpObject.pluDep_D_to_F();
		this.relation = this.setUpObject.relation_35();
		assertFalse(this.pd.isBCNF(this.relation, null));
		assertFalse(this.pd.is4NF(this.relation, null));
	}
	
	@Test
	//4FN
	public void DtooF_R38WithOutKeyJoint() {
		this.pd = this.setUpObject.pluDep_BC_to_AD();
		this.relation = this.setUpObject.relation_38();
		assertTrue(this.pd.isBCNF(this.relation, null));
		assertTrue(this.pd.is4NF(this.relation, null));
	}
}