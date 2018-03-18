/**
 * 
 */
package com.prashant.trees;

/**
 * @author waykarp
 *
 */
public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	public TreeNode() {
		//
	}
	
	public TreeNode(int data) {
		this.data = data;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @return the right
	 */
	public TreeNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
}

