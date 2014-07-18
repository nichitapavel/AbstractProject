package normalization;

import java.util.ArrayList;

import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.KeyJoint;
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
		ArrayList<Relation> normalizedRelation = new ArrayList<>();
		normalizedRelation.add(relation);
		ArrayList<Relation> newRelations = null;
		
		int option = 0;
		
		for (int i = 0; i < normalizedRelation.size(); i++) {
			Relation newRelation = normalizedRelation.get(i);
			ArrayList<ADependency> nonNF_DFs;
			
			if (!newRelation.isBCNF()) {
				nonNF_DFs = newRelation.getNonBCNF_DFs();
					
				if (!auto) {
					/*
					 * option = get.stdin()
					 */
				}
					
				newRelations = newRelation.split(nonNF_DFs.get(option));
				normalizedRelation.remove(newRelation);
				normalizedRelation.addAll(i, newRelations);
				i--;
			}
		}						
			
		return normalizedRelation;
	}

	public static ArrayList<Relation> normalize3NF(Relation relation, boolean auto) {
		ArrayList<Relation> normalizedRelation = new ArrayList<>();
		normalizedRelation.add(relation);
		ArrayList<Relation> newRelations = null;
		
		KeyJoint keyJoint = relation.calculateKeyJoint();
				
		int option = 0;
		
		for (int i = 0; i < normalizedRelation.size(); i++) {
			Relation newRelation = normalizedRelation.get(i);
			ArrayList<ADependency> nonNF_DFs;

			if (!newRelation.is3NF()) {
				nonNF_DFs = newRelation.getNon3NF_DFs();
					
				if (!auto) {
					/*
					 * option = get.stdin()
					 */
				}
					
				newRelations = newRelation.split(nonNF_DFs.get(option));
				normalizedRelation.remove(newRelation);
				normalizedRelation.addAll(i, newRelations);
				i--;
			}
		}
		
		boolean projectionOnKey = false;
		for (Relation r : normalizedRelation) {
			if (r.getAttrJoint().containsJoinsFrom(keyJoint))
				projectionOnKey = true;
		}

		if (!projectionOnKey) {
			AttributeJoint key = keyJoint.getKey(0);
			normalizedRelation.add(relation.splitByKey(key));
		}
		
		return normalizedRelation;
	}
}
