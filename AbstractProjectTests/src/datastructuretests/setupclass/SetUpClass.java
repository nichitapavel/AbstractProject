package datastructuretests.setupclass;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Vector;

import normalization.Normalization;
import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.RareElement;
import datastructures.dependency.ADependency;
import datastructures.dependency.FunctionalDependency;
import datastructures.dependency.PluralDependency;
import datastructures.KeyJoint;
import datastructures.Relation;

public class SetUpClass {

	public void simpleUllmanTest(String[] attr, String[] result, DFJoint dfJoint) {
		AttributeJoint cierre = new AttributeJoint(attr);
		AttributeJoint res = new AttributeJoint(result);
		assertEquals(res, Normalization.simpleUllman(cierre, dfJoint));
	}
	
	//New SetUp Objects for Testing

	/******************/
	//ATTRIBUTES
	/******************/
	
	//Attribute A
	public Attribute attr_A() {
		return new Attribute("A");
	}
	
	//Attribute B
	public Attribute attr_B() {
		return new Attribute("B");
	}
	
	//Attribute C
	public Attribute attr_C() {
		return new Attribute("C");
	}
		
	//Attribute D
	public Attribute attr_D() {
		return new Attribute("D");
	}
	
	//Attribute E
	public Attribute attr_E() {
		return new Attribute("E");
	}
	
	//Attribute F
	public Attribute attr_F() {
		return new Attribute("F");
	}
			
	//Attribute G
	public Attribute attr_G() {
		return new Attribute("G");
	}
		
	//Attribute H
	public Attribute attr_H() {
		return new Attribute("H");
	}
	
	/******************/
	//ATTRIBUTEJOINTS
	/******************/
	
	//AttributeJoint A
	public AttributeJoint attrJnt_A() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		return attrJoint;
	}
	
	//AttributeJoint B
	public AttributeJoint attrJnt_B() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_B());
		return attrJoint;
	}

	//AttributeJoint C
	public AttributeJoint attrJnt_C() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_C());
		return attrJoint;
	}
	
	//AttributeJoint D
	public AttributeJoint attrJnt_D() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_D());
		return attrJoint;
	}

	//AttributeJoint E
	public AttributeJoint attrJnt_E() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint F
	public AttributeJoint attrJnt_F() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_F());
		return attrJoint;
	}
	
	//AttributeJoint G
	public AttributeJoint attrJnt_G() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_G());
		return attrJoint;
	}

	//AttributeJoint H
	public AttributeJoint attrJnt_H() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_H());
		return attrJoint;
	}
	
	//AttributeJoint AB
	public AttributeJoint attrJnt_AB() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		return attrJoint;
	}
	
	//AttributeJoint AC
	public AttributeJoint attrJnt_AC() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_C());
		return attrJoint;
	}
	
	//AttributeJoint AD
	public AttributeJoint attrJnt_AD() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_D());
		return attrJoint;
	}
	
	//AttributeJoint AE
	public AttributeJoint attrJnt_AE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint BC
	public AttributeJoint attrJnt_BC() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_C());
		return attrJoint;
	}
	
	//AttributeJoint BD
	public AttributeJoint attrJnt_BD() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_D());
		return attrJoint;
	}
	
	//AttributeJoint BE
	public AttributeJoint attrJnt_BE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint CD
	public AttributeJoint attrJnt_CD() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		return attrJoint;
	}

	//AttributeJoint CE
	public AttributeJoint attrJnt_CE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint CF
	public AttributeJoint attrJnt_CF() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_F());
		return attrJoint;
	}
	
	//AttributeJoint DE
	public AttributeJoint attrJnt_DE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint DF
	public AttributeJoint attrJnt_DF() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_F());
		return attrJoint;
	}
	
	//AttributeJoint EF
	public AttributeJoint attrJnt_EF() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_E());
		attrJoint.addAttributes(attr_F());
		return attrJoint;
	}

	//AttributeJoint ABC
	public AttributeJoint attrJnt_ABC() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_C());
		return attrJoint;
	}
	
	//AttributeJoint ABD
	public AttributeJoint attrJnt_ABD() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_D());
		return attrJoint;
	}
	
	//AttributeJoint ABE
	public AttributeJoint attrJnt_ABE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint ABF
	public AttributeJoint attrJnt_ABF() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_F());
		return attrJoint;
	}
	
	//AttributeJoint ACD
	public AttributeJoint attrJnt_ACD() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		return attrJoint;
	}
	
	//AttributeJoint ADE
	public AttributeJoint attrJnt_ADE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint BCD
	public AttributeJoint attrJnt_BCD() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		return attrJoint;
	}
	
	//AttributeJoint BDE
	public AttributeJoint attrJnt_BDE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint BEF
	public AttributeJoint attrJnt_BEF() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_E());
		attrJoint.addAttributes(attr_F());
		return attrJoint;
	}
	
	//AttributeJoint CDE
	public AttributeJoint attrJnt_CDE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint ABCD
	public AttributeJoint attrJnt_ABCD() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		return attrJoint;
	}
	
	//AttributeJoint ABDE
	public AttributeJoint attrJnt_ABDE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint ACDE
	public AttributeJoint attrJnt_ACDE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint BCDE
	public AttributeJoint attrJnt_BCDE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint ABCDE
	public AttributeJoint attrJnt_ABCDE() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		return attrJoint;
	}
	
	//AttributeJoint ABCDEF
	public AttributeJoint attrJnt_ABCDEF() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		attrJoint.addAttributes(attr_F());
		return attrJoint;
	}	
	
	//AttributeJoint ABEGH
	public AttributeJoint attrJnt_ABEGH() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_E());
		attrJoint.addAttributes(attr_G());
		attrJoint.addAttributes(attr_H());
		return attrJoint;
	}
	
	//AttributeJoint ABCDEFGH
	public AttributeJoint attrJnt_ABCDEFGH() {
		AttributeJoint attrJoint = new AttributeJoint();
		attrJoint.addAttributes(attr_A());
		attrJoint.addAttributes(attr_B());
		attrJoint.addAttributes(attr_C());
		attrJoint.addAttributes(attr_D());
		attrJoint.addAttributes(attr_E());
		attrJoint.addAttributes(attr_F());
		attrJoint.addAttributes(attr_G());
		attrJoint.addAttributes(attr_H());
		return attrJoint;
	}	
		
	/******************/
	//FUNCTIONAL DEPENDENCY
	/******************/
	
	//Functional Dependency A -> B
	public ADependency funcDep_A_to_B() {
		ADependency funcDep = new FunctionalDependency(attrJnt_A(), attrJnt_B());
		return funcDep;
	}
	
	//Functional Dependency A -> C
	public ADependency funcDep_A_to_C() {
		ADependency funcDep = new FunctionalDependency(attrJnt_A(), attrJnt_C());
		return funcDep;
	}
	
	//Functional Dependency A -> D
	public ADependency funcDep_A_to_D() {
		ADependency funcDep = new FunctionalDependency(attrJnt_A(), attrJnt_D());
		return funcDep;
	}
	
	//Functional Dependency A -> E
	public ADependency funcDep_A_to_E() {
		ADependency funcDep = new FunctionalDependency(attrJnt_A(), attrJnt_E());
		return funcDep;
	}
	
	//Functional Dependency A -> BCD
	public ADependency funcDep_A_to_BCD() {
		ADependency funcDep = new FunctionalDependency(attrJnt_A(), attrJnt_BCD());
		return funcDep;
	}
	
	//Functional Dependency B -> C
	public ADependency funcDep_B_to_C() {
		ADependency funcDep = new FunctionalDependency(attrJnt_B(), attrJnt_C());
		return funcDep;
	}
	
	//Functional Dependency B -> D
	public ADependency funcDep_B_to_D() {
		ADependency funcDep = new FunctionalDependency(attrJnt_B(), attrJnt_D());
		return funcDep;
	}
	
	//Functional Dependency B -> E
	public ADependency funcDep_B_to_E() {
		ADependency funcDep = new FunctionalDependency(attrJnt_B(), attrJnt_E());
		return funcDep;
	}
	
	//Functional Dependency B -> CE
	public ADependency funcDep_B_to_CE() {
		ADependency funcDep = new FunctionalDependency(attrJnt_B(), attrJnt_CE());
		return funcDep;
	}
	
	//Functional Dependency C -> A
	public ADependency funcDep_C_to_A() {
		ADependency funcDep = new FunctionalDependency(attrJnt_C(), attrJnt_A());
		return funcDep;
	}
	
	//Functional Dependency C -> B
	public ADependency funcDep_C_to_B() {
		ADependency funcDep = new FunctionalDependency(attrJnt_C(), attrJnt_B());
		return funcDep;
	}
	
	//Functional Dependency C -> B
	public ADependency funcDep_C_to_D() {
		ADependency funcDep = new FunctionalDependency(attrJnt_C(), attrJnt_D());
		return funcDep;
	}
	
	//Functional Dependency D -> E
	public ADependency funcDep_D_to_E() {
		ADependency funcDep = new FunctionalDependency(attrJnt_D(), attrJnt_E());
		return funcDep;
	}
	
	//Functional Dependency E -> C
	public ADependency funcDep_E_to_C() {
		ADependency funcDep = new FunctionalDependency(attrJnt_E(), attrJnt_C());
		return funcDep;
	}
	
	//Functional Dependency E -> D
	public ADependency funcDep_E_to_D() {
		ADependency funcDep = new FunctionalDependency(attrJnt_E(), attrJnt_D());
		return funcDep;
	}
	
	//Functional Dependency E -> DF
	public ADependency funcDep_E_to_DF() {
		ADependency funcDep = new FunctionalDependency(attrJnt_E(), attrJnt_DF());
		return funcDep;
	}
		
	//Functional Dependency E -> F
	public ADependency funcDep_E_to_F() {
		ADependency funcDep = new FunctionalDependency(attrJnt_E(), attrJnt_F());
		return funcDep;
	}

	//Functional Dependency F -> E
	public ADependency funcDep_F_to_E() {
		ADependency funcDep = new FunctionalDependency(attrJnt_F(), attrJnt_E());
		return funcDep;
	}
	
	//Functional Dependency A -> BC
	public ADependency funcDep_A_to_BC() {
		ADependency funcDep = new FunctionalDependency(attrJnt_A(), attrJnt_BC());
		return funcDep;
	}
	
	//Functional Dependency C -> AB
	public ADependency funcDep_C_to_AB() {
		ADependency funcDep = new FunctionalDependency(attrJnt_C(), attrJnt_AB());
		return funcDep;
	}
	
	//Functional Dependency AB -> B
	public ADependency funcDep_AB_to_B() {
		ADependency funcDep = new FunctionalDependency(attrJnt_AB(), attrJnt_B());
		return funcDep;
	}
	
	//Functional Dependency AB -> C
	public ADependency funcDep_AB_to_C() {
		ADependency funcDep = new FunctionalDependency(attrJnt_AB(), attrJnt_C());
		return funcDep;
	}
	
	//Functional Dependency AB -> D
	public ADependency funcDep_AB_to_D() {
		ADependency funcDep = new FunctionalDependency(attrJnt_AB(), attrJnt_D());
		return funcDep;
	}
	
	//Functional Dependency AB -> CD
	public ADependency funcDep_AB_to_CD() {
		ADependency funcDep = new FunctionalDependency(attrJnt_AB(), attrJnt_CD());
		return funcDep;
	}
	
	//Functional Dependency AB -> BCD
	public ADependency funcDep_AB_to_BCD() {
		ADependency funcDep = new FunctionalDependency(attrJnt_AB(), attrJnt_BCD());
		return funcDep;
	}
	
	//Functional Dependency AD -> C
	public ADependency funcDep_AD_to_C() {
		ADependency funcDep = new FunctionalDependency(attrJnt_AD(), attrJnt_C());
		return funcDep;
	}
	
	//Functional Dependency AD -> E
	public ADependency funcDep_AD_to_E() {
		ADependency funcDep = new FunctionalDependency(attrJnt_AD(), attrJnt_E());
		return funcDep;
	}
	
	//Functional Dependency AE -> D
	public ADependency funcDep_AE_to_D() {
		ADependency funcDep = new FunctionalDependency(attrJnt_AE(), attrJnt_D());
		return funcDep;
	}
	
	//Functional Dependency AE -> F
	public ADependency funcDep_AE_to_F() {
		ADependency funcDep = new PluralDependency(attrJnt_AE(), attrJnt_F());
		return funcDep;
	}
	
	//Functional Dependency BC -> A
	public ADependency funcDep_BC_to_A() {
		ADependency funcDep = new FunctionalDependency(attrJnt_BC(), attrJnt_A());
		return funcDep;
	}
	
	//Functional Dependency BC -> E
	public ADependency funcDep_BC_to_E() {
		ADependency funcDep = new FunctionalDependency(attrJnt_BC(), attrJnt_E());
		return funcDep;
	}
	
	//Functional Dependency BD -> C
	public ADependency funcDep_BD_to_C() {
		ADependency funcDep = new FunctionalDependency(attrJnt_BD(), attrJnt_C());
		return funcDep;
	}
	
	//Functional Dependency CD -> A
	public ADependency funcDep_CD_to_A() {
		ADependency funcDep = new FunctionalDependency(attrJnt_CD(), attrJnt_A());
		return funcDep;
	}
	
	//Functional Dependency CF -> H
	public ADependency funcDep_CF_to_H() {
		ADependency funcDep = new FunctionalDependency(attrJnt_CF(), attrJnt_H());
		return funcDep;
	}
	
	//Functional Dependency DE -> C
	public ADependency funcDep_DE_to_C() {
		ADependency funcDep = new FunctionalDependency(attrJnt_DE(), attrJnt_C());
		return funcDep;
	}
	
	//Functional Dependency ABD -> G
	public ADependency funcDep_ABD_to_G() {
		ADependency funcDep = new FunctionalDependency(attrJnt_ABD(), attrJnt_G());
		return funcDep;
	}
	
	//Functional Dependency ABE -> G
	public ADependency funcDep_ABE_to_G() {
		ADependency funcDep = new FunctionalDependency(attrJnt_ABE(), attrJnt_G());
		return funcDep;
	}
	
	//Functional Dependency ABE -> H
	public ADependency funcDep_ABE_to_H() {
		ADependency funcDep = new FunctionalDependency(attrJnt_ABE(), attrJnt_H());
		return funcDep;
	}

	//Functional Dependency BCD -> E
	public ADependency funcDep_BCD_to_E() {
		ADependency funcDep = new FunctionalDependency(attrJnt_BCD(), attrJnt_E());
		return funcDep;
	}
	
	/******************/
	//Plural Dependency
	/******************/

	//Plural Dependency A ->> CD	
	public ADependency pluDep_A_to_CD() {
		ADependency pluDep = new PluralDependency(attrJnt_A(), attrJnt_CD());
		return pluDep;
	}
	
	//A ->> BEF
	public ADependency pluDep_A_to_BEF() {
		ADependency pluDep = new PluralDependency(attrJnt_A(), attrJnt_BEF());
		return pluDep;
	}

	//A ->> B
	public ADependency pluDep_A_to_B() {
		ADependency pluDep = new PluralDependency(attrJnt_A(), attrJnt_B());
		return pluDep;
	}
	
	//A ->> EF
	public ADependency pluDep_A_to_EF() {
		ADependency pluDep = new PluralDependency(attrJnt_A(), attrJnt_EF());
		return pluDep;
	}
	
	/******************/
	//DFJoint
	/******************/
	
	//DFJoint One = {A -> BC, BC -> A, BCD -> E, E -> C}
	public DFJoint dfJoint_01() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint One");
		dfJoint.addFunctionalDependency(funcDep_A_to_BC());
		dfJoint.addFunctionalDependency(funcDep_BC_to_A());
		dfJoint.addFunctionalDependency(funcDep_BCD_to_E());
		dfJoint.addFunctionalDependency(funcDep_E_to_C());
		return dfJoint;
	}
	
	//DFJoint Two = {A -> BC, BC -> E, CD -> A}
	public DFJoint dfJoint_02() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Two");
		dfJoint.addFunctionalDependency(funcDep_A_to_BC());
		dfJoint.addFunctionalDependency(funcDep_BC_to_E());
		dfJoint.addFunctionalDependency(funcDep_CD_to_A());
		return dfJoint;
	}
	
	//DFJoint Three = {AB -> C, C -> AB, E -> D, D -> E, E -> F, F -> E, ABD -> G, CF -> H}
	public DFJoint dfJoint_03() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Three");
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_AB());
		dfJoint.addFunctionalDependency(funcDep_E_to_D());
		dfJoint.addFunctionalDependency(funcDep_D_to_E());
		dfJoint.addFunctionalDependency(funcDep_E_to_F());
		dfJoint.addFunctionalDependency(funcDep_F_to_E());
		dfJoint.addFunctionalDependency(funcDep_ABD_to_G());
		dfJoint.addFunctionalDependency(funcDep_CF_to_H());
		return dfJoint;
	}
	
	//DFJoint Four = {A -> BC, B -> C, A -> B, AB -> C}
	public DFJoint dfJoint_04() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Four");
		dfJoint.addFunctionalDependency(funcDep_A_to_BC());
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		dfJoint.addFunctionalDependency(funcDep_A_to_B());
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		return dfJoint;
	}
	
	//DFJoint Five = {A -> B, B -> C}
	public DFJoint dfJoint_05() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Five");
		dfJoint.addFunctionalDependency(funcDep_A_to_B());
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		return dfJoint;
	}
	
	//DFJoint Six = {AB -> D, B -> C, C -> B, B -> E}
	public DFJoint dfJoint_06() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Six");
		dfJoint.addFunctionalDependency(funcDep_AB_to_D());
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_B());
		dfJoint.addFunctionalDependency(funcDep_B_to_E());
		return dfJoint;
	}
	
	//DFJoint Seven = {A -> B, B -> C, C -> D}
	public DFJoint dfJoint_07() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Seven");
		dfJoint.addFunctionalDependency(funcDep_A_to_B());
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_D());
		return dfJoint;
	}
	
	//DFJoint Eight = {B -> C, AB -> D, C -> B}
	public DFJoint dfJoint_08() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Eight");
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		dfJoint.addFunctionalDependency(funcDep_AB_to_D());
		dfJoint.addFunctionalDependency(funcDep_C_to_B());
		return dfJoint;
	}
	
	//DFJoint Nine = {AB -> C}
	public DFJoint dfJoint_09() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Nine");
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		return dfJoint;
	}
	
	//DFJoint Ten = {AB -> C, C -> A}
	public DFJoint dfJoint_10() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Ten");
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_A());
		return dfJoint;
	}
	
	//DFJoint Eleven = {C -> A}
	public DFJoint dfJoint_11() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Eleven");
		dfJoint.addFunctionalDependency(funcDep_C_to_A());
		return dfJoint;
	}
	
	//DFJoint Twelve = {A -> B, CD -> A, BD -> C, DE -> C}
	public DFJoint dfJoint_12() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twelve");
		dfJoint.addFunctionalDependency(funcDep_A_to_B());
		dfJoint.addFunctionalDependency(funcDep_CD_to_A());
		dfJoint.addFunctionalDependency(funcDep_BD_to_C());
		dfJoint.addFunctionalDependency(funcDep_DE_to_C());
		return dfJoint;
	}
	
	//DFJoint Thirteen = {A -> B}
	public DFJoint dfJoint_13() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Thirteen");
		dfJoint.addFunctionalDependency(funcDep_A_to_B());
		return dfJoint;
	}
	
	//DFJoint Fourteen = {CD -> A, AD -> C, DE -> C}
	public DFJoint dfJoint_14() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Fourteen");
		dfJoint.addFunctionalDependency(funcDep_CD_to_A());
		dfJoint.addFunctionalDependency(funcDep_AD_to_C());
		dfJoint.addFunctionalDependency(funcDep_DE_to_C());
		return dfJoint;
	}
	
	//DFJoint Fifteen = {CD -> A, AD -> C}
	public DFJoint dfJoint_15() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Fifteen");
		dfJoint.addFunctionalDependency(funcDep_CD_to_A());
		dfJoint.addFunctionalDependency(funcDep_AD_to_C());
		return dfJoint;
	}
	
	//DFJoint Sixteen = {DE -> C}
	public DFJoint dfJoint_16() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Sixteen");
		dfJoint.addFunctionalDependency(funcDep_DE_to_C());
		return dfJoint;
	}
	
	//DFJoint Seventeen = {BCD -> E, E -> C}
	public DFJoint dfJoint_17() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Seventeen");
		dfJoint.addFunctionalDependency(funcDep_BCD_to_E());
		dfJoint.addFunctionalDependency(funcDep_E_to_C());
		return dfJoint;
	}
	
	//DFJoint Eighteen = {E -> C}
	public DFJoint dfJoint_18() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Eighteen");
		dfJoint.addFunctionalDependency(funcDep_E_to_C());
		return dfJoint;
	}
	
	//DFJoint Nineteen = {AB -> C, C -> B}
	public DFJoint dfJoint_19() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Nineteen");
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_B());
		return dfJoint;
	}
	
	//DFJoint Twenty = {C -> B}
	public DFJoint dfJoint_20() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twenty");
		dfJoint.addFunctionalDependency(funcDep_C_to_B());
		return dfJoint;
	}
	
	//DFJoint Twentyone = {A -> C}
	public DFJoint dfJoint_21() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twentyone");
		dfJoint.addFunctionalDependency(funcDep_A_to_C());
		return dfJoint;
	}
	
	//DFJoint Twentytwo = {B -> C}
	public DFJoint dfJoint_22() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twentytwo");
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		return dfJoint;
	}
	
	//DFJoint Twentythree = {AB -> C, C -> AB, E ->DF, D -> E, F -> E, ABD -> G, CF -> H}
	public DFJoint dfJoint_23() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twentythree");
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_AB());
		dfJoint.addFunctionalDependency(funcDep_E_to_DF());
		dfJoint.addFunctionalDependency(funcDep_D_to_E());
		dfJoint.addFunctionalDependency(funcDep_F_to_E());
		dfJoint.addFunctionalDependency(funcDep_ABD_to_G());
		dfJoint.addFunctionalDependency(funcDep_CF_to_H());
		return dfJoint;
	}
	
	//DFJoint Twentyfour = {A -> BC, B -> C, AB -> C}
	public DFJoint dfJoint_24() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twentyfour");
		dfJoint.addFunctionalDependency(funcDep_A_to_BC());
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		return dfJoint;
	}
	
	//DFJoint Twentyfive = {A -> B, A -> C, A -> D, D -> E}
	public DFJoint dfJoint_25() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twentyfive");
		dfJoint.addFunctionalDependency(funcDep_A_to_B());
		dfJoint.addFunctionalDependency(funcDep_A_to_C());
		dfJoint.addFunctionalDependency(funcDep_A_to_D());
		dfJoint.addFunctionalDependency(funcDep_D_to_E());
		return dfJoint;
	}
	
	//DFJoint Twentysix = {A -> BC, D -> E}
	public DFJoint dfJoint_26() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twentysix");
		dfJoint.addFunctionalDependency(funcDep_A_to_BCD());
		dfJoint.addFunctionalDependency(funcDep_D_to_E());
		return dfJoint;
	}
	
	//DFJoint Twentyseven = {AB -> D, B -> CE, C -> B}
	public DFJoint dfJoint_27() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twentyseven");
		dfJoint.addFunctionalDependency(funcDep_AB_to_D());
		dfJoint.addFunctionalDependency(funcDep_B_to_CE());
		dfJoint.addFunctionalDependency(funcDep_C_to_B());
		return dfJoint;
	}
	
	//DFJoint OneMinusAtoBC = {BC -> A, BCD -> E, E -> C}
	public DFJoint dfJoint_1MinusAtoBC() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint One minus A -> BC");
		dfJoint.addFunctionalDependency(funcDep_BC_to_A());
		dfJoint.addFunctionalDependency(funcDep_BCD_to_E());
		dfJoint.addFunctionalDependency(funcDep_E_to_C());
		return dfJoint;
	}
	
	//DFJoint FiveMinusBtoC = {A -> B}
	public DFJoint dfJoint_5MinusBtoC() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Five minus B -> C");
		dfJoint.addFunctionalDependency(funcDep_A_to_B());
		return dfJoint;
	}
	
	//DFJoint Twentyeight = {A -> BCD}
	public DFJoint dfJoint_28() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Twentyeight");
		dfJoint.addFunctionalDependency(funcDep_A_to_BCD());
		return dfJoint;
	}
	
	//DFJoint FourRegroupedWithoutCinAtoBC
	public DFJoint dfJoint_4ReGroupedWithoutCinAtoBC() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Four Regrouped Without C in A->BC");
		dfJoint.addFunctionalDependency(funcDep_A_to_B());
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		return dfJoint;
	}
	
	//DFJoint FourRegroupedWithoutAinABtoC
	public DFJoint dfJoint_4RegroupedWithoutAinABtoC() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint Four Regrouped Without A in AB->C");
		dfJoint.addFunctionalDependency(funcDep_A_to_BC());
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		return dfJoint;
	}
	
	//DFJoint AtoBC = {A -> BC}
	public DFJoint AtoBC() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint AtoBC");
		dfJoint.addFunctionalDependency(funcDep_A_to_BC());
		return dfJoint;
	}
	
	//DFJoint AtoE = {A -> E}
	public DFJoint AtoE() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint AtoE");
		dfJoint.addFunctionalDependency(funcDep_A_to_E());
		return dfJoint;
	}
	
	//DFJoint dfJoint_BtoD = {B -> D}
	public DFJoint BtoD() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint BtoD");
		dfJoint.addFunctionalDependency(funcDep_B_to_D());
		return dfJoint;
	}
	
	//DFJoint dfJoint_BtoE = {B -> E}
	public DFJoint BtoE() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint BtoE");
		dfJoint.addFunctionalDependency(funcDep_B_to_E());
		return dfJoint;
	}
	
	//DFJoint dfJoint_ABtoD_BtoC_CtoB = {AB -> D, B -> C, C -> B}
	public DFJoint ABtoD_BtoC_CtoB() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint ABtoD_BtoC_CtoB");
		dfJoint.addFunctionalDependency(funcDep_AB_to_D());
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_B());
		return dfJoint;
	}
	
	//DFJoint dfJoint_ABtoC_CtoAB = {AB -> C, C -> AB}
	public DFJoint ABtoC_CtoAB() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint ABtoC_CtoAB");
		dfJoint.addFunctionalDependency(funcDep_AB_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_AB());
		return dfJoint;
	}
	
	//DFJoint EtoD_DtoE = {E -> D, D -> E}
	public DFJoint EtoD_DtoE() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint EtoD_DtoE");
		dfJoint.addFunctionalDependency(funcDep_E_to_D());
		dfJoint.addFunctionalDependency(funcDep_D_to_E());
		return dfJoint;
	}

	//DFJoint EtoF_FtoE = {E -> F, F -> E}
	public DFJoint EtoF_FtoE() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint EtoF_FtoE");
		dfJoint.addFunctionalDependency(funcDep_E_to_F());
		dfJoint.addFunctionalDependency(funcDep_F_to_E());
		return dfJoint;
	}
	
	//DFJoint BtoC_CtoB = {B -> C, C -> B}
	public DFJoint BtoC_CtoB() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint BtoC_CtoB");
		dfJoint.addFunctionalDependency(funcDep_B_to_C());
		dfJoint.addFunctionalDependency(funcDep_C_to_B());
		return dfJoint;
	}
	
	//DFJoint ABtoD = {AB -> D}
	public DFJoint ABtoD() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint ABtoD");
		dfJoint.addFunctionalDependency(funcDep_AB_to_D());
		return dfJoint;
	}
	
	//DFJoint AtoBC_BCtoA = {A -> BC, BC -> A}
	public DFJoint AtoBC_BCtoA() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint AtoBC_BCtoA");
		dfJoint.addFunctionalDependency(funcDep_A_to_BC());
		dfJoint.addFunctionalDependency(funcDep_BC_to_A());
		return dfJoint;
	}

	//DFJoint ADtoE = {AD -> E}
	public DFJoint ADtoE() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint ADtoE");
		dfJoint.addFunctionalDependency(funcDep_AD_to_E());
		return dfJoint;
	}
	
	//DFJoint ABEtoGH = {ABE -> GH}
	public DFJoint ABEtoGH() {
		DFJoint dfJoint = new DFJoint();
		dfJoint.setName("DFJoint ABEtoGH");
		dfJoint.addFunctionalDependency(funcDep_ABE_to_G());
		dfJoint.addFunctionalDependency(funcDep_ABE_to_H());
		return dfJoint;
	}
	
	/******************/
	//DPJoints
	/******************/
	
	//DPJoint 30 = {A -> B, CD -> A, BD -> C, AE -> F, DE -> C, A ->> CD}
	public DFJoint dpJoint_30() {
		DFJoint dpJoint = new DFJoint();
		dpJoint.setName("DPJoint {A -> B, CD -> A, BD -> C, AE -> F, DE -> C, A ->> CD}");
		dpJoint.addFunctionalDependency(funcDep_A_to_B());
		dpJoint.addFunctionalDependency(funcDep_CD_to_A());
		dpJoint.addFunctionalDependency(funcDep_BD_to_C());
		dpJoint.addFunctionalDependency(funcDep_AE_to_F());
		dpJoint.addFunctionalDependency(funcDep_DE_to_C());
		dpJoint.addFunctionalDependency(pluDep_A_to_CD());
		return dpJoint;
	}
	
	//DPJoint 31 = {A -> B, CD -> A, BD -> C, AE -> F, DE -> C, AE -> D, A ->> CD}
	public DFJoint dpJoint_31() {
		DFJoint dpJoint = new DFJoint();
		dpJoint.setName("DPJoint {A -> B, CD -> A, BD -> C, AE -> F, DE -> C, AE -> D, A ->> CD}");
		dpJoint.addFunctionalDependency(funcDep_A_to_B());
		dpJoint.addFunctionalDependency(funcDep_CD_to_A());
		dpJoint.addFunctionalDependency(funcDep_BD_to_C());
		dpJoint.addFunctionalDependency(funcDep_AE_to_F());
		dpJoint.addFunctionalDependency(funcDep_DE_to_C());
		dpJoint.addFunctionalDependency(funcDep_AE_to_D());
		dpJoint.addFunctionalDependency(pluDep_A_to_CD());
		return dpJoint;
	}
	
	/******************/
	//KeyJoint
	/******************/
	
	//KeyJoint A
	public KeyJoint keyJoint_A() {
		KeyJoint keyJoint = new KeyJoint();
		keyJoint.addKey(attrJnt_A());
		return keyJoint;
	}
	
	//KeyJoint AB
	public KeyJoint keyJoint_AB() {
		KeyJoint keyJoint = new KeyJoint();
		keyJoint.addKey(attrJnt_AB());
		return keyJoint;
	}
	
	//KeyJoint AB_AC
	public KeyJoint keyJoint_AB_AC() {
		KeyJoint keyJoint = new KeyJoint();
		keyJoint.addKey(attrJnt_AB());
		keyJoint.addKey(attrJnt_AC());
		return keyJoint;
	}
		
	//KeyJoint AD_CD
	public KeyJoint keyJoint_AD_CD() {
		KeyJoint keyJoint = new KeyJoint();
		keyJoint.addKey(attrJnt_AD());
		keyJoint.addKey(attrJnt_CD());
		return keyJoint;
	}
	
	//KeyJoint AD_BCD_BDE
	public KeyJoint keyJoint_AD_BCD_BDE() {
		KeyJoint keyJoint = new KeyJoint();
		keyJoint.addKey(attrJnt_AD());
		keyJoint.addKey(attrJnt_BCD());
		keyJoint.addKey(attrJnt_BDE());
		return keyJoint;
	}
	
	//KeyJoint CD_CE_CF_ABD_ABE_ABF
	public KeyJoint keyJoint_CD_CE_CF_ABD_ABE_ABF() {
		KeyJoint keyJoint = new KeyJoint();
		keyJoint.addKey(attrJnt_CD());
		keyJoint.addKey(attrJnt_CE());
		keyJoint.addKey(attrJnt_CF());
		keyJoint.addKey(attrJnt_ABD());
		keyJoint.addKey(attrJnt_ABE());
		keyJoint.addKey(attrJnt_ABF());
		return keyJoint;
	}

	/******************/
	//Relation
	/******************/
	
	//Relation One = DFJoint One, AttributeJoint ABCDE
	public Relation relation_01() {
		return new Relation(attrJnt_ABCDE(), dfJoint_01());
	}
	
	//Relation Two = DFJoint Two, AttributeJoint ABCDE
	public Relation relation_02() {
		return new Relation(attrJnt_ABCDE(), dfJoint_02());
	}
	
	//Relation Three = DFJoint Three, AttributeJoint ABCDEFGH
	public Relation relation_03() {
		return new Relation(attrJnt_ABCDEFGH(), dfJoint_03());
	}
	
	//Relation Four = DFJoint Four, AttributeJoint ABC
	public Relation relation_04() {
		return new Relation(attrJnt_ABC(), dfJoint_04());
	}
		
	//Relation Five = DFJoint Five, AttributeJoint ABC
	public Relation relation_05() {
		return new Relation(attrJnt_ABC(), dfJoint_05());
	}
	
	//Relation Six = DFJoint Six, AttributeJoint ABCDE -> Key:
		public Relation relation_06() {
			return new Relation(attrJnt_ABCDE(), dfJoint_06());
		}

	//Relation Seven = DFJoint Seven, AttributeJoint ABCD -> Key:
	public Relation relation_07() {
		return new Relation(attrJnt_ABCD(), dfJoint_07());
	}
	
	//Relation Eight = DFJoint Eight, AttributeJoint ABCD -> Key:
	public Relation relation_08() {
		return new Relation(attrJnt_ABCD(), dfJoint_08());
	}
	
	//Relation Nine = DFJoint Nine, AttributeJoint ABC -> Key: AB
	public Relation relation_09() {
		return new Relation(attrJnt_ABC(), dfJoint_09());
	}
	
	//Relation OneABC
	public Relation relation_1ABC() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_ABC());
		return relation;
	}
	
	//Relation OneADE
	public Relation relation_1ADE() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_ADE());
		return relation;
	}
	
	//Relation OneBCDE
	public Relation relation_1BCDE() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_BCDE());
		return relation;
	}
	
	//Relation OneABCD
	public Relation relation_1ABCD() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_ABCD());
		return relation;
	}
	
	//Relation OneCE
	public Relation relation_1CE() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_CE());
		return relation;
	}
	
	//Relation OneABDE
	public Relation relation_1ABDE() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_ABDE());
		return relation;
	}
	
	//Relation AE
	public Relation relationAE() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_AE());
		return relation;
	}
	
	//Relation AD
	public Relation relationAD() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_AD());
		relation.setDFJoint(new DFJoint());
		return relation;
	}
	
	//Relation BC
	public Relation relationBC() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_BC());
		return relation;
	}
	
	//Relation BD
	public Relation relationBD() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_BD());
		return relation;
	}
	
	//Relation AB
	public Relation relationAB() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_AB());
		return relation;
	}
	
	//Relation BE
	public Relation relationBE() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_BE());
		return relation;
	}
	
	//Relation DE
	public Relation relationDE() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_DE());
		return relation;
	}
	
	//Relation EF
	public Relation relationEF() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_EF());
		return relation;
	}
	
	//Relation AEGH
	public Relation relationABEGH() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_ABEGH());
		relation.setDFJoint(ABEtoGH());
		return relation;
	}
	
	//Relation ABD
	public Relation relationABD() {
		Relation relation = new Relation();
		relation.settAttrJoint(attrJnt_ABD());
		return relation;
	}
	
	//Relation ABC_AtoBC
	public Relation ABC_AtoBC() {
		Relation relation = relation_1ABC();
		relation.setDFJoint(AtoBC());;
		return relation;
	}
	
	//Relation AE_AtoE
	public Relation AE_AtoE() {
		Relation relation = relationAE();
		relation.setDFJoint(AtoE());;
		return relation;
	}
	
	//Relation BC_BtoC
	public Relation BC_BtoC() {
		Relation relation = relationBC();
	relation.setDFJoint(dfJoint_22());;
		return relation;
	}
	//Relation BD_BtoD
	public Relation BD_BtoD() {
		Relation relation = relationBD();
		relation.setDFJoint(BtoD());;
		return relation;
	}
	
	//Relation AB_AtoB
	public Relation AB_AtoB() {
		Relation relation = relationAB();
		relation.setDFJoint(dfJoint_5MinusBtoC());;
		return relation;
	}
	
	//Relation BE_BtoE
	public Relation BE_BtoE() {
		Relation relation = relationBE();
		relation.setDFJoint(BtoE());;
		return relation;
	}
	
	//Relation ABCD_ABtoD_BtoC_CtoB
	public Relation ABCD_ABtoD_BtoC_CtoB() {
		Relation relation = relation_07();
		relation.setDFJoint(ABtoD_BtoC_CtoB());;
		return relation;
	}
	
	//Relation ABC_ABtoC_CtoAB
	public Relation ABC_ABtoC_CtoAB() {
		Relation relation = relation_1ABC();
		relation.setDFJoint(ABtoC_CtoAB());
		return relation;
	}
	
	//Relation DE_EtoD_DtoE
	public Relation DE_EtoD_DtoE() {
		Relation relation = relationDE();
		relation.setDFJoint(EtoD_DtoE());
		return relation;
	}
	//Relation EF_EtoF_FtoE
	public Relation EF_EtoF_FtoE() {
		Relation relation = relationEF();
		relation.setDFJoint(EtoF_FtoE());
		return relation;
	}

	//Relation BC_BtoC_CtoB
	public Relation BC_BtoC_CtoB() {
		Relation relation = relationBC();
		relation.setDFJoint(BtoC_CtoB());
		return relation;
	}

	//Relation ABD_ABtoD
	public Relation ABD_ABtoD() {
		Relation relation = relationABD();
		relation.setDFJoint(ABtoD());
		return relation;
	}
	
	//Relation ABC_AtoBC_BCtoA
	public Relation ABC_AtoBC_BCtoA() {
		Relation relation = relation_1ABC();
		relation.setDFJoint(AtoBC_BCtoA());
		return relation;
	}
	
	//Relation 30
	public Relation relation_30() {
		Relation relation = new Relation();
		relation.setDFJoint(dpJoint_30());
		relation.settAttrJoint(attrJnt_ABCDEF());
		return relation;
	}
	
	/******************/
	//RareElement
	/******************/
	
	//C Consequent A->BC DFJoint TwentyFour
	public RareElement rareElementC_AtoBC_DFJoint24_Consequent() {
		return new RareElement(
				attr_C(),
				funcDep_A_to_BC(),
				dfJoint_24(),
				"Consequent");
	}
	
	//A Antecedent AB->C DFJoint TwentyFour
	public RareElement rareElementA_ABtoC_DFJoint24_Antecedent() {
		return new RareElement(
				attr_A(),
				funcDep_AB_to_C(),
				dfJoint_24(),
				"Antecedent");
	}
	
	//B Antecedent AB->C DFJoint TwentyFour
	public RareElement rareElementB_ABtoC_DFJoint24_Antecedent() {
		return new RareElement(
				attr_B(),
				funcDep_AB_to_C(),
				dfJoint_24(),
				"Antecedent");
	}
	
	//C Consequent A->BC DFJoint Four
	public RareElement rareElementC_AtoBC_DFJoint4_Consequent() {
		return new RareElement(
				attr_C(),
				funcDep_A_to_BC(),
				dfJoint_04(),
				"Consequent");
	}
	//A Antecedent AB->C DFJoint Four
	public RareElement rareElementA_ABtoC_DFJoint4_Antecedent() {
		return new RareElement(
				attr_A(),
				funcDep_AB_to_C(),
				dfJoint_04(),
				"Antecedent");
	}

	//B Antecedent AB->C DFJoint Four
	public RareElement rareElementB_ABtoC_DFJoint4_Antecedent() {
		return new RareElement(
				attr_B(),
				funcDep_AB_to_C(),
				dfJoint_04(),
				"Antecedent");
	}
	
	/******************/
	//Vector<FunctionalDependency>
	/******************/
	
	public ArrayList<ADependency> arrayListNonBCNFDFJoint1() {
		ArrayList<ADependency> arrayList = new ArrayList<>();
		arrayList.add(funcDep_A_to_BC());
		arrayList.add(funcDep_BC_to_A());
		arrayList.add(funcDep_E_to_C());
		return arrayList;
	}
	
	public ArrayList<ADependency> arrayListNonBCNFDFJoint2() {
		ArrayList<ADependency> arrayList = new ArrayList<>();
		arrayList.add(funcDep_A_to_BC());
		arrayList.add(funcDep_BC_to_E());
		return arrayList;
	}
	
	public ArrayList<ADependency> arrayListNonBCNFDFJoint3() {
		ArrayList<ADependency> arrayList = dfJoint_03().getDFJoint();
		arrayList.remove(funcDep_ABD_to_G());
		arrayList.remove(funcDep_CF_to_H());
		return arrayList;
	}
	
	public ArrayList<ADependency> arrayListNonBCNFDFJoint4_5() {
		ArrayList<ADependency> arrayList = new ArrayList<>();
		arrayList.add(funcDep_B_to_C());
		return arrayList;
	}
	
	public ArrayList<ADependency> arrayListNonBCNFDFJoint6() {
		ArrayList<ADependency> arrayList = new ArrayList<>();
		arrayList.add(funcDep_B_to_C());
		arrayList.add(funcDep_C_to_B());
		arrayList.add(funcDep_B_to_E());
		return arrayList;
	}
	
	public ArrayList<ADependency> arrayListNonBCNFDFJoint7() {
		ArrayList<ADependency> arrayList = new ArrayList<>();
		arrayList.add(funcDep_B_to_C());
		arrayList.add(funcDep_C_to_D());
		return arrayList;
	}

	public ArrayList<ADependency> arrayListNonBCNFDFJoint8() {
		ArrayList<ADependency> arrayList = new ArrayList<>();
		arrayList.add(funcDep_B_to_C());
		arrayList.add(funcDep_C_to_B());
		return arrayList;
	}
	
	/******************/
	//VectorNormalize
	/******************/
	
	public ArrayList<Relation> VectorR_ABC_AtoBC_AE_AtoE_AD_null() {
		ArrayList<Relation> arrayList = new ArrayList<>();
		arrayList.add(ABC_AtoBC());
		arrayList.add(AE_AtoE());
		arrayList.add(relationAD());
		return arrayList;
	}
	
	public ArrayList<Relation> VectorR_BC_BtoC_AB_AtoB() {
		ArrayList<Relation> arrayList = new ArrayList<>();
		arrayList.add(BC_BtoC());
		arrayList.add(AB_AtoB());
		return arrayList;
	}
	
	public ArrayList<Relation> VectorR_BE_BtoE_ABCD_ABtoD_BtoC_CtoB() {
		ArrayList<Relation> arrayList = new ArrayList<>();
		arrayList.add(BE_BtoE());
		arrayList.add(ABCD_ABtoD_BtoC_CtoB());
		return arrayList;
	}
	
	public ArrayList<Relation> VectorR_BC_BtoC_BD_BtoD_AB_AtoB() {
		ArrayList<Relation> arrayList = new ArrayList<>();
		arrayList.add(BC_BtoC());
		arrayList.add(BD_BtoD());
		arrayList.add(AB_AtoB());
		return arrayList;
	}

	public ArrayList<Relation> VectorR_ABC_ABtoC_CtoAB_DE_EtoD_DtoE_EF_EtoF_FtoE_ABEGH_ABEtoGH() {
		ArrayList<Relation> arrayList = new ArrayList<>();
		arrayList.add(ABC_ABtoC_CtoAB());
		arrayList.add(DE_EtoD_DtoE());
		arrayList.add(EF_EtoF_FtoE());
		arrayList.add(relationABEGH());
		return arrayList;
	}

	public Vector<Relation> VectorR_BC_BtoC_CtoB_BE_BtoE_ABD_ABtoD() {
		Vector<Relation> arrayList = new Vector<>();
		arrayList.add(BC_BtoC_CtoB());
		arrayList.add(BE_BtoE());
		arrayList.add(ABD_ABtoD());
		return arrayList;
	}

	public Vector<Relation> VectorR_BC_BtoC_CtoB_ABD_ABtoD() {
		Vector<Relation> arrayList = new Vector<>();
		arrayList.add(BC_BtoC_CtoB());
		arrayList.add(ABD_ABtoD());
		return arrayList;
	}

	public Vector<Relation> VectorR_ABC_AtoBC_BCtoA_ADE_ADtoE() {
		Vector<Relation> arrayList = new Vector<>();
		arrayList.add(ABC_AtoBC_BCtoA());
		Relation relation = relation_1ADE();
		relation.setDFJoint(ADtoE());
		arrayList.add(relation);
		return arrayList;
	}
}