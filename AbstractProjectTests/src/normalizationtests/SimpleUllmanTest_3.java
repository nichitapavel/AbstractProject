package normalizationtests;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.DFJoint;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SimpleUllmanTest_3 {
	private DFJoint dfJoint;
	private SetUpClass testObject;
	
	@Before
	public void setup() {
		this.testObject = new SetUpClass();
		this.dfJoint = this.testObject.dfJoint_03();
	}
	
	@Test
	public void ullmanAIJ() {
		String[] attr = {"A", "I", "J"};
		String[] result = {"A", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBIJ() {
		String[] attr = {"B", "I", "J"};
		String[] result = {"B", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanCIJ() {
		String[] attr = {"C", "I", "J"};
		String[] result = {"A", "B", "C", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanDIJ() {
		String[] attr = {"D", "I", "J"};
		String[] result = {"D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanEIJ() {
		String[] attr = {"E", "I", "J"};
		String[] result = {"D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanFIJ() {
		String[] attr = {"F", "I", "J"};
		String[] result = {"D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABIJ() {
		String[] attr = {"A", "B", "I", "J"};
		String[] result = {"A", "B", "C", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanACIJ() {
		String[] attr = {"A", "C", "I", "J"};		
		String[] result = {"A", "B", "C", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
		
	}
	
	@Test
	public void ullmanAEIJ() {
		String[] attr = {"A", "C", "I", "J"};
		String[] result = {"A", "B", "C", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAFIJ() {
		String[] attr = {"A", "C", "I", "J"};
		String[] result = {"A", "B", "C", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBCIJ() {
		String[] attr = {"B", "C", "I", "J"};
		String[] result = {"A", "B", "C", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBDIJ() {
		String[] attr = {"B", "D", "I", "J"};
		String[] result = {"B", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBEIJ() {
		String[] attr = {"B", "E", "I", "J"};
		String[] result = {"B", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBFIJ() {
		String[] attr = {"B", "F", "I", "J"};
		String[] result = {"B", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanCDIJ() {
		String[] attr = {"C", "D", "I", "J"};
		String[] result = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanCEIJ() {
		String[] attr = {"C", "E", "I", "J"};
		String[] result = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanCFIJ() {
		String[] attr = {"C", "F", "I", "J"};
		String[] result = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanDEIJ() {
		String[] attr = {"D", "E", "I", "J"};
		String[] result = {"D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanDFIJ() {
		String[] attr = {"D", "F", "I", "J"};
		String[] result = {"D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanEFIJ() {
		String[] attr = {"E", "F", "I", "J"};
		String[] result = {"D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABCIJ() {
		String[] attr = {"A", "B", "C", "I", "J"};
		String[] result = {"A", "B", "C", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABDIJ() {
		String[] attr = {"A", "B", "D", "I", "J"};
		String[] result = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABEIJ() {
		String[] attr = {"A", "B", "E", "I", "J"};
		String[] result = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanABFIJ() {
		String[] attr = {"A", "B", "F", "I", "J"};
		String[] result = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanADEIJ() {
		String[] attr = {"A", "D", "E", "I", "J"};
		String[] result = {"A", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanADFIJ() {
		String[] attr = {"A", "D", "F", "I", "J"};
		String[] result = {"A", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanAEFIJ() {
		String[] attr = {"A", "E", "F", "I", "J"};
		String[] result = {"A", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBDEIJ() {
		String[] attr = {"B", "D", "E", "I", "J"};
		String[] result = {"B", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBDFIJ() {
		String[] attr = {"B", "D", "F", "I", "J"};
		String[] result = {"B", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
	
	@Test
	public void ullmanBEFIJ() {
		String[] attr = {"B", "E", "F", "I", "J"};
		String[] result = {"B", "D", "E", "F", "I", "J"};
		testObject.simpleUllmanTest(attr, result, dfJoint);
	}
}
