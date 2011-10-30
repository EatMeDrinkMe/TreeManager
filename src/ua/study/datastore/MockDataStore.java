package ua.study.datastore;

import ua.study.domain.TreeNode;

public class MockDataStore {

	public static TreeNode loadMockStore(){
		TreeNode result = new TreeNode("Main Leaf", 0);
		TreeNode leaf1 = new TreeNode("1 Leaf 1 Level", 1);
		TreeNode leaf2 = new TreeNode("2 Leaf 1 Level", 12);
		TreeNode leaf3 = new TreeNode("1 Leaf 2 Level", 2);
		TreeNode leaf4 = new TreeNode("1 Leaf 3 Level", 3);
		TreeNode leaf5 = new TreeNode("1 Leaf 4 Level", 4);
		
		result.addChild(leaf1);
		result.addChild(leaf2);
		leaf2.addChild(leaf3);
		leaf3.addChild(leaf4);
		leaf4.addChild(leaf5);
		
		return result;
		
	}
}
