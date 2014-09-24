package datastructuretests.dfjoint;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.DFJoint;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetHiddenDFTest {
	private SetUpClass setUpObject;
	private DFJoint dfJoint_ex;
	private DFJoint dfJoint_original;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	public void hiddenDFDFJoint30() {
		this.dfJoint_ex = this.setUpObject.dpJoint_30();
		this.dfJoint_original = this.setUpObject.dpJoint_30();
		assertEquals(this.dfJoint_ex, this.dfJoint_original.getHiddenDF());
	}
	
	@Test
	public void hiddenDFDFJoint31() {
		this.dfJoint_ex = this.setUpObject.dpJoint_31();
		this.dfJoint_original = this.setUpObject.dpJoint_31();
		this.dfJoint_ex.addDependency(this.setUpObject.funcDep_A_to_D());
		assertEquals(this.dfJoint_ex, this.dfJoint_original.getHiddenDF());
	}
	
	@Test
	public void hiddenDFDFJoint33() {
		this.dfJoint_ex = this.setUpObject.dpJoint_33();
		this.dfJoint_original = this.setUpObject.dpJoint_33();
		this.dfJoint_ex.addDependency(this.setUpObject.funcDep_B_to_C());
		assertEquals(this.dfJoint_ex, this.dfJoint_original.getHiddenDF());
	}
}
