package ua.study.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.study.datastore.MockDataStore;
import ua.study.domain.TreeNode;
import ua.study.servide.TreeNodeManager;

public class TreeNodeManagerTest {
	
	private TreeNodeManager treeNodeManager;
	
	@Before
	public void setUp(){
		treeNodeManager = new TreeNodeManager();
		TreeNode treeNode = MockDataStore.loadMockStore();
		treeNodeManager.setMainTreeNode(treeNode);
		
	} 
	
	@Test
	public void searchTest(){
		TreeNode result = null;
		result = treeNodeManager.search("2 Leaf 1 Level");
		
		assertEquals(result.getDeep(), 12);
		
	}
	
}
