package ua.study.domain;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {

	private String name;
	private TreeNode parent;
	private List<TreeNode> child = new LinkedList<TreeNode>();
	private int deep;
	
	public TreeNode(String name){
		this.name = name;
	}
	
	public TreeNode(String name, int deep){
		this(name);
		this.deep = deep;
	}
	
	public void addChild(TreeNode treeNode){
		child.add(treeNode);
		treeNode.setParent(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}

	public List<TreeNode> getChild() {
		return child;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	
	
}
