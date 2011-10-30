package ua.study.servide;

import ua.study.domain.TreeNode;

public class TreeNodeManager {

	private TreeNode mainTreeNode;

	public TreeNode getMainTreeNode() {
		return mainTreeNode;
	}

	public void setMainTreeNode(TreeNode mainTreeNode) {
		this.mainTreeNode = mainTreeNode;
	}

	public TreeNode search(String treeNodeName) {
		return search(this.mainTreeNode, treeNodeName);
	}

	public TreeNode search(TreeNode treeNode, String treeNodeName) {
		TreeNode result = null;
		for (TreeNode node : treeNode.getChild()) {
			if (node.getName().equals(treeNodeName)) {
				result = node;
				break;
			}
			if (!node.getChild().isEmpty()) {
				result = search(node, treeNodeName);
				if (result != null) {
					return result;
				}
			}
		}
		return result;
	}

	public void delete(TreeNode treeNode) {
		TreeNode parent = treeNode.getParent();
		parent.getChild().remove(treeNode);
	}

	public void add(TreeNode treeNodeParent, TreeNode treeNodeChild) {
		treeNodeParent.getChild().add(treeNodeChild);
	}
}
