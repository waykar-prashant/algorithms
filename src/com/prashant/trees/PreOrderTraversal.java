package com.prashant.trees;

import java.util.Stack;

public class PreOrderTraversal {
	private TreeNode root;
	
	private void preOrderTraversalRecursive(TreeNode root) {
		if(root == null)
			return;
		System.out.print("["+root.getData() + "] -->");
		preOrderTraversalRecursive(root.getLeft());
		preOrderTraversalRecursive(root.getRight());
	}
	
	private void preOrderTraversalIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		TreeNode tempRoot = root;
		while(!stack.isEmpty()) {
			tempRoot = stack.pop();
			System.out.print("["+tempRoot.getData() + "] -->");

			if(tempRoot.getRight() != null) {
				stack.push(tempRoot.getRight());
			}
			if(tempRoot.getLeft() != null) {
				stack.push(tempRoot.getLeft());
			}
		}
	}
	
	public static void main(String[] args) {
		PreOrderTraversal order = new PreOrderTraversal();
		order.root = TreeUtils.getTree();
		order.preOrderTraversalRecursive(order.root);
		System.out.println();
		order.root = TreeUtils.getTree();
		order.preOrderTraversalIterative(order.root);
		
	}

}
