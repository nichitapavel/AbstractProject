package normalformalgorithms;

import java.util.Vector;

import normalformalgorithms.ApareceElement;
import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.AFunctionalDependency;
import datastructures.Relation;

public class NormalFormAlgorithms {
	
	public static AttributeJoint ullman(AttributeJoint a, DFJoint dfJoint) {
		AttributeJoint result = new AttributeJoint();
		
		int dfJointSize = dfJoint.getSize();
		
		int cuentadf[]  = new int[dfJointSize];
		
		for(int i = 0; i < dfJointSize; i++)
			cuentadf[i] = dfJoint.getDFJoint().get(i).getAntecedent().getSize();
		
		AttributeJoint attrJoint = dfJoint.getAttributesDFJoint();
		
	
		Vector<ApareceElement> aparece = new Vector<ApareceElement>();
		
		for (Attribute attr : attrJoint) {
			ApareceElement obj = new ApareceElement(attr);
			aparece.add(obj);
			
			for (int i = 0; i < dfJointSize; i++) {
				if (attr.isContained(dfJoint.getDFJoint().get(i).getAntecedent()))
					aparece.lastElement().addIndex(i);
			}
		}
		
		agregar(a, result, aparece, cuentadf, dfJoint);
					
		return result;
	}
	
	public static void agregar(
			AttributeJoint attrJoint, 
			AttributeJoint result, 
			Vector<ApareceElement> aparece, 
			int [] cuentadf, 
			DFJoint dfJoint) {
		
		for (Attribute attr : attrJoint) {
			if (!attr.isContained(result)) {
				result.addAttributes(attr);
				for (ApareceElement apEl : aparece) {
					if (apEl.getAttr().equals(attr)) {
						for (int i = 0; i < apEl.getSize(); i++){
							int ENTERO = apEl.getElementAt(i);
							cuentadf[ENTERO] = cuentadf[ENTERO] - 1;
							if (cuentadf[ENTERO] == 0) {
								AttributeJoint aux = dfJoint.getDFJoint().elementAt(ENTERO).getConsequent();
								agregar(aux, result, aparece, cuentadf, dfJoint);
							}
						}
					}
				}
			}
		}
	}
	
	public static AttributeJoint simpleUllman(AttributeJoint attrJoint, DFJoint dfJoint){
		AttributeJoint result = new AttributeJoint(attrJoint);
		boolean isChanged;
		
		do {
			isChanged = false;
			for (AFunctionalDependency df:dfJoint) {
				if (df.getAntecedent().isContained(result) && !(df.getConsequent().isContained(result))) {
					result.addAttributes(df.getConsequent());
					isChanged = true;
				}
			}
		} while (isChanged);
		
		return result;
	}
	
	public static boolean isEquivalentDFJoints(DFJoint A, DFJoint B) {
		if (A.isImplied(B) && B.isImplied(A))
			return true;
		return false;		
	}
	
	public static Vector<Relation> normalizeBCNF(Relation relation, boolean auto) {
		NormalFormAlgorithms object = new NormalFormAlgorithms();
		return object.normalize(1, relation, auto);
	}
	
	public static Vector<Relation> normalize3NF(Relation relation, boolean auto) {
		NormalFormAlgorithms object = new NormalFormAlgorithms();
		return object.normalize(0, relation, auto);
	}
	
	private Vector<Relation> normalize(int whatToDo, Relation relation, boolean auto) {
 		Vector<Relation> normalizedRelation = new Vector<>();
		normalizedRelation.add(relation);
		Vector<Relation> newRelations = null;
		
		int option = 0;
		
		for (int i = 0; i < normalizedRelation.size(); i++) {
			boolean  currentState = false;
			Relation newRelation = normalizedRelation.elementAt(i);
			Vector<AFunctionalDependency> nonNF_DFs;
			
			if (whatToDo == 0) {
				if (!newRelation.is3NF()) {
					nonNF_DFs = newRelation.getNon3NF_DFs();
					
					if (!auto) {
						/*
						 * option = get.stdin()
						 */
					}
					
					newRelations = newRelation.split(nonNF_DFs.elementAt(option));
					currentState = true;
				}
			}
			else {
				if (!newRelation.isBCNF()) {
					nonNF_DFs = newRelation.getNonBCNF_DFs();
					
					if (!auto) {
						/*
						 * option = get.stdin()
						 */
					}
					
					newRelations = newRelation.split(nonNF_DFs.elementAt(option));
					currentState = true;
				}
			}
							
			if (currentState) {
				Relation R1 = newRelations.elementAt(0);
				Relation R2 = newRelations.elementAt(1);
				
				AttributeJoint attrJoint_R1 = R1.getAttrJoint(); 
				AttributeJoint attrJoint_R2 = R2.getAttrJoint();
				
				R1.setDFJoint(newRelation.getDFJoint().projectionOnAttributeJoint(attrJoint_R1));
				R2.setDFJoint(newRelation.getDFJoint().projectionOnAttributeJoint(attrJoint_R2));
				
				normalizedRelation.remove(newRelation);
				normalizedRelation.addAll(newRelations);
				i--;
			}
		}
		
		return normalizedRelation;
	}
}
