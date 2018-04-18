package com.prashant.trees;

public class FindMaxOrMinInATree {
	private TreeNode root;
	public static void main(String[] args) {
		FindMaxOrMinInATree max = new FindMaxOrMinInATree();
		max.root = TreeUtils.getTree();
		int maxNode = max.findMax(max.root);
		System.out.println("Max value of Node : " + maxNode);
	}
	
	private int findMax(TreeNode root) {
		
		if(root == null)
			return Integer.MIN_VALUE;
		int max = root.getData();
		int left = findMax(root.getLeft());
		int right = findMax(root.getRight());
		if(left > max) {
			max = left;
		} 
		if (right > max) {
			max = right;
		}
		
		return max;
	}

}
