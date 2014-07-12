package datastructuretests.pluraldependency;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import datastructures.AttributeJoint;
import datastructures.dependency.ADependency;
import datastructures.dependency.PluralDependency;
import datastructuretests.setupclass.SetUpClass;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PluralDependencyTests {
	private ADependency fd;
	
	private AttributeJoint antecedent;
	private AttributeJoint consecuent;
	
	private SetUpClass setUpObject;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
		
		String [] antecedentArray = {"A", "B", "C"};
		antecedent = new AttributeJoint(antecedentArray);
		
		String [] consecuentArray = {"D", "E", "F"};
		consecuent = new AttributeJoint(consecuentArray);
		
		fd = new PluralDependency(antecedent, consecuent);
	}
	
	//Test constructors
	@Test
	public void constructorVoid() {
		this.setUpObject.AB_AtoB();
		this.fd.clear();
		fail();
	}
}
