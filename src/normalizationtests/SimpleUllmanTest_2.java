package normalizationtests;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.DFJoint;
import datastructuretests.setupclass.SetUpClass;

/*
 * R(U) = (A, B, C, D, E)
 * DF = {(A -> BC), (BC -> E), (CD -> A)}
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleUllmanTest_2 {
	private DFJoint dfJoint;
	private SetUpClass testObject;
	
	@Before
	public void setup() {
		this.testObject = new SetUpClass();
		this.dfJoint = this.testObject.dfJoint_02();
		
	}
	
	@Test
	public void ullmanA() {
		String[] attr = {"A"};
		String[] result = {"A", "B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanB() {
		String[] attr = {"B"};		
		String[] result = {"B"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanC() {
		String[] attr = {"C"};
		String[] result = {"C"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanD() {
		String[] attr = {"D"};
		String[] result = {"D"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanE() {
		String[] attr = {"E"};
		String[] result = {"E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAB() {
		String[] attr = {"A", "B"};
		String[] result = {"A", "B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAC() {
		String[] attr = {"A", "C"};
		String[] result = {"A", "B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAD() {
		String[] attr = {"A", "D"};
		String[] result = {"A", "B", "C", "D","E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAE() {
		String[] attr = {"A", "E"};
		String[] result = {"A", "B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBC() {
		String[] attr = {"B", "C"};
		String[] result = {"B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBD() {
		String[] attr = {"B", "D"};
		String[] result = {"B", "D"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBE() {
		String[] attr = {"B", "E"};
		String[] result = {"B", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanCD() {
		String[] attr = {"C", "D"};
		String[] result = {"A", "B", "C", "D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanCE() {
		String[] attr = {"C", "E"};
		String[] result = {"C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanDE() {
		String[] attr = {"D", "E"};
		String[] result = {"D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABC() {
		String[] attr = {"A", "B", "C"};
		String[] result = {"A", "B", "C", "E"};
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
	
	@Test
	public void ullmanBCD() {
		String[] attr = {"B", "C", "D"};
		String[] result = {"A", "B", "C", "D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBCE() {
		String[] attr = {"B", "C", "E"};
		String[] result = {"B", "C", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBDE() {
		String[] attr = {"B", "D", "E"};
		String[] result = {"B", "D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanCDE() {
		String[] attr = {"C", "D", "E"};
		String[] result = {"A", "B", "C", "D", "E"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
}