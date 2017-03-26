package com.prashant.recursion;

public class NumberOfIslands {
	private static int ROW = 5;
	private static int COL = 5;
	private boolean visited[][] = new boolean[ROW][COL];
	
	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		int M[][] = new int[][]{{1, 1, 1, 1, 1},
            					{0, 1, 0, 0, 0},
					            {0, 1, 0, 1, 1},
					            {0, 1, 0, 0, 0},
					            {1, 1, 1, 1, 1}};
		ROW = M.length;
		COL = M[0].length;
		System.out.println("Number of isLands  : " + noi.getIslandCount(M));

	}

	private int getIslandCount(int[][] M) {
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(M[i][j] == 1 && !visited[i][j]) {
					// -----[ Visit all the adjacent islands ]----- //
					visitAdjacentIslands(M, i, j);
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Visit all the adjacent islands and mark it as visited
	 * @param m
	 * @param i
	 * @param j
	 */
	private void visitAdjacentIslands(int[][] m, int i, int j) {
		if(i < 0 || j < 0 || i >= m.length || j >= m[0].length || m[i][j] != 1 || visited[i][j])
			return;
		
		if(m[i][j] == 1 && !visited[i][j]) {
			// -----[ Mark as visited ]----- //
			visited[i][j] = true;
		}
		
		visitAdjacentIslands(m, i-1, j);
		visitAdjacentIslands(m, i+1, j);
		visitAdjacentIslands(m, i, j-1);
		visitAdjacentIslands(m, i, j+1);
	}

}
