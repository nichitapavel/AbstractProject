package normalization;

import java.util.ArrayList;

import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.Relation;
import datastructures.dependency.ADependency;

public class Normalization {
	
	public static AttributeJoint simpleUllman(AttributeJoint attrJoint, DFJoint dfJoint){
		AttributeJoint result = new AttributeJoint(attrJoint);
		boolean isChanged;
		
		do {
			isChanged = false;
			for (ADependency df:dfJoint) {
				if (df.getAntecedent().isContained(result) && !(df.getConsequent().isContained(result))) {
					result.addAttributes(df.getConsequent());
					isChanged = true;
				}
			}
		} while (isChanged);
		
		return result;
	}

	public static ArrayList<Relation> normalizeBCNF(Relation relation, boolean auto) {
		Normalization object = new Normalization();
		return object.normalize(1, relation, auto);
	}
	
	public static ArrayList<Relation> normalize3NF(Relation relation, boolean auto) {
		Normalization object = new Normalization();
		return object.normalize(0, relation, auto);
	}
	
	private ArrayList<Relation> normalize(int whatToDo, Relation relation, boolean auto) {
		ArrayList<Relation> normalizedRelation = new ArrayList<>();
		normalizedRelation.add(relation);
		ArrayList<Relation> newRelations = null;
		
		int option = 0;
		
		for (int i = 0; i < normalizedRelation.size(); i++) {
			boolean  currentState = false;
			Relation newRelation = normalizedRelation.get(i);
			ArrayList<ADependency> nonNF_DFs;
			
			if (whatToDo == 0) {
				if (!newRelation.is3NF()) {
					nonNF_DFs = newRelation.getNon3NF_DFs();
					
					if (!auto) {
						/*
						 * option = get.stdin()
						 */
					}
					
					newRelations = newRelation.split(nonNF_DFs.get(option));
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
					
					newRelations = newRelation.split(nonNF_DFs.get(option));
					currentState = true;
				}
			}
							
			if (currentState) {
				Relation R1 = newRelations.get(0);
				Relation R2 = newRelations.get(1);
				
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
