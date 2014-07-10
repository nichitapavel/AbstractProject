package normalizationtests;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.DFJoint;
import datastructuretests.setupclass.SetUpClass;

/*
 * R(U) = (A, B, C, D, E)
 * DF = {(A -> BC), (BC -> A), (BCD -> E), (E -> C)}
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleUllmanTest_1 {
	private DFJoint dfJoint;
	private SetUpClass testObject;
	
	@Before
	public void setup() {
		this.testObject = new SetUpClass();
		this.dfJoint = this.testObject.dfJoint_1();
		
	}
	
	@Test
	public void ullmanBC() {
		String[] attr = {"B", "C"};
		String[] result = {"A", "B", "C"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanA() {
		String[] attr = {"A"};
		String[] result = {"A", "B", "C"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanE() {
		String[] attr = {"E"};
		String[] result = {"C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAB() {
		String[] attr = {"A", "B"};
		String[] result = {"A", "B", "C"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAC() {
		String[] attr = {"A", "C"};
		String[] result = {"A", "B", "C"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAD() {
		String[] attr = {"A", "D"};
		String[] result = {"A", "B", "C", "D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAE() {
		String[] attr = {"A", "E"};
		String[] result = {"A", "B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAEF() {
		String[] attr = {"A", "E", "F"};
		String[] result = {"A", "B", "C", "E", "F"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABC() {
		String[] attr = {"A", "B", "C"};
		String[] result = {"A", "B", "C"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABD() {
		String[] attr = {"A", "B", "D"};
		String[] result = {"A", "B", "C", "D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABE() {
		String[] attr = {"A", "B", "E"};
		String[] result = {"A", "B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanACD() {
		String[] attr = {"A", "C", "D"};
		String[] result = {"A", "B", "C", "D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanACE() {
		String[] attr = {"A", "C", "E"};
		String[] result = {"A", "B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanADE() {
		String[] attr = {"A", "D", "E"};
		String[] result = {"A", "B", "C", "D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
}
