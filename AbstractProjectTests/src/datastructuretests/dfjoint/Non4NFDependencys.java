package datastructuretests.dfjoint;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import datastructures.Relation;
import datastructures.dependency.ADependency;
import datastructuretests.setupclass.SetUpClass;

public class Non4NFDependencys {
	private SetUpClass setUpObject;
	private ArrayList<ADependency> non4NFList;
	private Relation relation;
	
	@Before
	public void setUp() {
		this.setUpObject = new SetUpClass();
	}
	
	@Test
	public void getNon4NFDFJoint_01() {
		this.non4NFList = this.setUpObject.arrayListNonBCNFDFJoint1();
		this.relation = this.setUpObject.relation_01();
		assertEquals(this.non4NFList, this.setUpObject.dfJoint_01().getNon4NF_DFs(relation));
	}
	
	@Test
	public void getNon4NFDPJoint_30() {
		this.non4NFList = this.setUpObject.arrayListNon4NFDPJoint30();
		this.relation = this.setUpObject.relation_30();
		assertEquals(this.non4NFList, this.setUpObject.dpJoint_30().getNon4NF_DFs(relation));
	}
	
	@Test
	public void getNon4NFDPJoint_32() {
		this.non4NFList = this.setUpObject.arrayListNon4NFDPJoint32();
		this.relation = this.setUpObject.relation_32();
		assertEquals(this.non4NFList, this.setUpObject.dpJoint_32().getNon4NF_DFs(relation));
	}
	
	@Ignore
	public void getNon4NFDPJoint_33() {
		this.non4NFList = this.setUpObject.arrayListNon4NFDPJoint33();
		this.relation = this.setUpObject.relation_33();
		assertEquals(this.non4NFList, this.setUpObject.dpJoint_33().getNon4NF_DFs(relation));
	}
	
	@Test
	public void getNon4NFDPJoint_34() {
		this.non4NFList = this.setUpObject.arrayListNon4NFDPJoint34();
		this.relation = this.setUpObject.relation_34();
		assertEquals(this.non4NFList, this.setUpObject.dpJoint_34().getNon4NF_DFs(relation));
	}
	
	@Test
	public void getNon4NFDPJoint_35() {
		this.non4NFList = this.setUpObject.arrayListNon4NFDPJoint35();
		this.relation = this.setUpObject.relation_35();
		assertEquals(this.non4NFList, this.setUpObject.dpJoint_35().getNon4NF_DFs(relation));
	}
	
	@Test
	public void getNon4NFDPJoint_36() {
		this.non4NFList = this.setUpObject.arrayListNon4NFDPJoint36();
		this.relation = this.setUpObject.relation_35();
		assertEquals(this.non4NFList, this.setUpObject.dpJoint_36().getNon4NF_DFs(relation));
	}
	
	@Test
	public void getNon4NFDPJoint_37() {
		this.non4NFList = this.setUpObject.arrayListNon4NFDPJoint37();
		this.relation = this.setUpObject.relation_37();
		assertEquals(this.non4NFList, this.setUpObject.dpJoint_37().getNon4NF_DFs(relation));
	}
}
