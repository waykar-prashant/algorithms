package com.prashant.trees;

import java.util.Stack;

public class InOrderTraversal {
	private TreeNode root;
	
	public static void main(String[] args) {
		InOrderTraversal order = new InOrderTraversal();
		order.root = TreeUtils.getTree();
		System.out.println("Recursive pre-order tree traversal");
		order.inOrderTraversalRecursive(order.root);
		System.out.println("\n\nIterative pre-order tree traversal");
		order.root = TreeUtils.getTree();
		order.inOrderTraversalIterative(order.root);
	}

	private void inOrderTraversalRecursive(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversalRecursive(root.getLeft());
		System.out.print("["+root.getData() + "] -->");
		inOrderTraversalRecursive(root.getRight());
	}

	private void inOrderTraversalIterative(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = root;
		while(!stack.isEmpty() || currentNode != null) {
			if(currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				TreeNode temp = stack.pop();
				System.out.print("["+temp.getData() + "] -->");
				currentNode = temp.getRight();
			}
		}
	}

}
