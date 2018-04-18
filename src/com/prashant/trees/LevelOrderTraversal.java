package com.prashant.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	private TreeNode root;
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<Integer> levelNodes = new ArrayList<>();
		List<List<Integer>> level = new ArrayList<>();
		level.add(levelNodes);
		if(root == null)
			return level;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print("["+temp.getData() + "] -->");
			if(temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if(temp.getRight() != null) {
				queue.add(temp.getRight());
			}
			
		}
		return null;
    }
	
	public void levelwiseOrder(TreeNode root) {
		//List<Integer> levelNodes = new ArrayList<>();
		//List<List<Integer>> level = new ArrayList<>();
		//level.add(levelNodes);
		if(root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int level = queue.size();
			System.out.println("\nLevel : " + level);
			for(int i = 0; i < level; i++) {
				TreeNode temp = queue.peek();
				if(temp.getLeft() != null) {
					queue.add(temp.getLeft());
				}
				if(temp.getRight() != null) {
					queue.add(temp.getRight());
				}
				System.out.print("["+temp.getData() + "] -->");
				queue.poll();
			}
			
		}
    }
	
	
	public static void main(String[] args) {
		LevelOrderTraversal levelOrder = new LevelOrderTraversal();
		levelOrder.root = TreeUtils.getTree();
		levelOrder.levelOrder(levelOrder.root);
		System.out.println("\n\n Level wise display of nodes\n");
		levelOrder.levelwiseOrder(levelOrder.root);
	}

}
