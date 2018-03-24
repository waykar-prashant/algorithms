/**
 * 
 */
package com.prashant.trees;

import java.util.Stack;

/**
 * @author waykarp
 *
 */
public class PostOrderTraversal {
	private TreeNode root;
	
	public static void main(String[] args) {
		PostOrderTraversal order = new PostOrderTraversal();
		order.root = TreeUtils.getTree();
		System.out.println("Recursive post-order tree traversal");
		order.postOrderTraversalRecursive(order.root);
		System.out.println("\n\nIterative post-order tree traversal");
		order.root = TreeUtils.getTree();
		order.postOrderTraversalIterative(order.root);
	}

	private void postOrderTraversalIterative(TreeNode root) {
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode temp = stack.peek();
			if (temp.getLeft() == null && temp.getRight() == null) {
				stack.pop();
				System.out.print("[" + temp.getData() + "] -->");
				
			} else {
				if (temp.getRight() != null) {
					stack.push(temp.getRight());
					temp.setRight(null);
				}
				if (temp.getLeft() != null) {
					stack.push(temp.getLeft());
					temp.setLeft(null);
				}
			}
		}		
	}

	private void postOrderTraversalRecursive(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrderTraversalRecursive(root.getLeft());
		postOrderTraversalRecursive(root.getRight());
		System.out.print("["+root.getData() + "] -->");
	}

}
