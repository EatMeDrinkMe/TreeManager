package ua.study.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import ua.study.datastore.MockDataStore;
import ua.study.domain.TreeNode;
import ua.study.servide.TreeNodeManager;

public class TreeGui {

	JFrame mainFrame;
	TreeNodeManager tnm;
	JTree mainTree;
	
	public TreeGui(){
		tnm = new TreeNodeManager();
		mainFrame = new JFrame("Дерево");
		mainFrame.setSize(500, 500);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setJMenuBar(menuBarInit());
		mainFrame.setVisible(true);
	}
	
	
	public JMenuBar menuBarInit(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem loadItem = new JMenuItem("Load");
		JMenuItem exitItem = new JMenuItem("Exit");
		saveItem.addActionListener(new MenuFileListener());
		loadItem.addActionListener(new MenuFileListener());
		exitItem.addActionListener(new MenuFileListener());
		JMenuItem addItem = new JMenuItem("Add");
		JMenuItem deleteItem = new JMenuItem("Delete");
		addItem.addActionListener(new MenuEditListener());
		deleteItem.addActionListener(new MenuEditListener());
		menuFile.add(saveItem);
		menuFile.add(loadItem);
		menuFile.add(exitItem);
		menuEdit.add(addItem);
		menuEdit.add(deleteItem);
		return menuBar;
	}
	
	public static DefaultMutableTreeNode init(TreeNode tree){
		
		DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode(tree.getName());
		for(TreeNode treeNode:tree.getChild()){
			DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(treeNode.getName());
			childNode = init(treeNode);
			parentNode.add(childNode);
		}
		return parentNode;
	}
	

	
	
	public class MenuFileListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("Load")){
				TreeNode parentNode = MockDataStore.loadMockStore();
				tnm.setMainTreeNode(parentNode);
				mainTree = new JTree(init(tnm.getMainTreeNode()));
				mainFrame.add(mainTree);
				mainFrame.validate();
			}
			if(ae.getActionCommand().equals("Save")){}
			if(ae.getActionCommand().equals("Exit")){
				System.exit(0);
			}
		}
		
	}
	
	public class MenuEditListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("Add")){
				DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode)mainTree.getSelectionPath().getLastPathComponent();
				String newTreeNodeName = (String)JOptionPane.showInputDialog(mainFrame, "Введите название нового узла:");
				tnm.add(tnm.search(dmtn.toString()), new TreeNode(newTreeNodeName));
				DefaultTreeModel dtm = (DefaultTreeModel) mainTree.getModel();
				dtm.insertNodeInto(new DefaultMutableTreeNode(newTreeNodeName), dmtn, 0);
			}
			
			if(ae.getActionCommand().equals("Delete")){
				DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode)mainTree.getSelectionPath().getLastPathComponent();
				tnm.delete(tnm.search(dmtn.toString()));
				DefaultTreeModel dtm = (DefaultTreeModel) mainTree.getModel();
				dtm.removeNodeFromParent(dmtn);
			}
			
			
		}
		
	}
}
