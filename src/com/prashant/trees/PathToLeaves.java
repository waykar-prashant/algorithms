package com.prashant.trees;

import java.util.ArrayList;
import java.util.List;

public class PathToLeaves {
	private TreeNode root;
	
	public static void main(String[] args) {
		PathToLeaves pathToLeaves = new PathToLeaves();
		pathToLeaves.root = TreeUtils.getTree();
		List<TreeNode> list = new ArrayList<TreeNode>();
		pathToLeaves.listPathToLeaves(list, pathToLeaves.root);
	}

	private void listPathToLeaves(List<TreeNode> list, TreeNode root) {
		if(root == null) {
			return;
		}
		
		if(root.getLeft() == null && root.getRight() == null) {
			// Print the node and return
			if(list.size() > 0) {
				System.out.print("\n\nPath to leaf : ");
			}

			for(int i = 0; i < list.size(); i++) {
				TreeNode node = list.get(i);
				System.out.print(node.getData() + " - ");
			}
			System.out.print(root.getData());
			return;
		}
		
		list.add(root);
		if(root.getLeft() != null)
			listPathToLeaves(list, root.getLeft());
		
		if(root.getRight() != null)
			listPathToLeaves(list, root.getRight());
		
		//Remove the root node from the list since both its left and right child are done traversing 
		removeTraversedNode(list, root);

	}

	private void removeTraversedNode(List<TreeNode> list, TreeNode root) {
		TreeNode lastItem = list.get(list.size()-1);
		if(lastItem == root) {
			System.out.println("\nRemoving from list : " + lastItem.getData());
			list.remove(list.size() - 1);
		}
		
	}


}
