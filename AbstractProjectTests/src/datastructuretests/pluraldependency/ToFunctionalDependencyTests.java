package datastructuretests.pluraldependency;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.DFJoint;
import datastructures.dependency.ADependency;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ToFunctionalDependencyTests {

	private SetUpClass setUpObject;
	private DFJoint dpJoint;
	private ADependency pluDep;
	private ArrayList<ADependency> funcDepList;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
		this.funcDepList = new ArrayList<ADependency>();
	}
	
	@Test
	public void AtooCD_In_DPJoint30_ProduceNull() {
		this.pluDep = this.setUpObject.pluDep_A_to_CD();
		this.dpJoint = this.setUpObject.dpJoint_30();
		assertEquals(this.funcDepList, this.pluDep.toFunctionalDependency(this.dpJoint));
	}
	
	@Test
	public void AtooCD_In_DPJoint31_ProduceAtoD() {
		this.pluDep = this.setUpObject.pluDep_A_to_CD();
		this.dpJoint = this.setUpObject.dpJoint_31();
		this.funcDepList.add(this.setUpObject.funcDep_A_to_D());
		assertEquals(this.funcDepList, this.pluDep.toFunctionalDependency(this.dpJoint));
	}
	
	@Test
	public void BtooC_In_DPJoint32_ProduceNull() {
		this.pluDep = this.setUpObject.pluDep_B_to_C();
		this.dpJoint = this.setUpObject.dpJoint_32();
		assertEquals(this.funcDepList, this.pluDep.toFunctionalDependency(this.dpJoint));
	}
	
	@Test
	public void BtooC_In_DPJoint33_ProduceBtoC() {
		this.pluDep = this.setUpObject.pluDep_B_to_C();
		this.dpJoint = this.setUpObject.dpJoint_33();
		this.funcDepList.add(this.setUpObject.funcDep_B_to_C());
		assertEquals(this.funcDepList, this.pluDep.toFunctionalDependency(this.dpJoint));
	}
	
	@Test
	public void BtooC_In_DPJoint34_ProduceNull() {
		this.pluDep = this.setUpObject.pluDep_B_to_C();
		this.dpJoint = this.setUpObject.dpJoint_34();
		assertEquals(this.funcDepList, this.pluDep.toFunctionalDependency(this.dpJoint));
	}
	
	@Test
	public void DtooF_In_DPJoint35_ProduceNull() {
		this.pluDep = this.setUpObject.pluDep_D_to_F();
		this.dpJoint = this.setUpObject.dpJoint_35();
		assertEquals(this.funcDepList, this.pluDep.toFunctionalDependency(this.dpJoint));
	}
	
	@Test
	public void AtooBCD_In_DPJoint36_ProduceNull() {
		this.pluDep = this.setUpObject.pluDep_A_to_BCD();
		this.dpJoint = this.setUpObject.dpJoint_36();
		assertEquals(this.funcDepList, this.pluDep.toFunctionalDependency(this.dpJoint));
	}
	
	@Test
	public void AtooBC_In_DPJoint37_ProduceAtoC() {
		this.pluDep = this.setUpObject.pluDep_A_to_BC();
		this.dpJoint = this.setUpObject.dpJoint_37();
		this.funcDepList.add(this.setUpObject.funcDep_A_to_C());
		assertEquals(this.funcDepList, this.pluDep.toFunctionalDependency(this.dpJoint));
	}
}
