/**
 * 
 */
package com.prashant.recursion;

/**
 * @author prashant waykar
 *
 */
public class FloodFillAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FloodFillAlgorithm ff = new FloodFillAlgorithm();
		int screen[][] = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 0, 0, 1, 1, 0, 1, 1 }, { 1, 2, 2, 2, 2, 0, 1, 0 }, { 1, 1, 1, 2, 2, 0, 1, 0 },
				{ 1, 1, 1, 2, 2, 2, 2, 0 }, { 1, 1, 1, 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1, 2, 2, 1 } };
		int x = 4, y = 4, newC = 5;
		ff.floodFill(screen, x, y, newC);
		System.out.println("Updated screen after call to floodFill: \n");;
		for (int i = 0; i < screen.length; i++) {
			for (int j = 0; j < screen[0].length; j++) {
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * flood fill
	 * 
	 * @param screen
	 * @param x
	 * @param y
	 * @param newC
	 */
	private void floodFill(int[][] screen, int x, int y, int newC) {
		// -----[ Get current color at pixel ]----- //
		int oldC = screen[x][y];
		floodFill(screen, x, y, oldC, newC);
	}

	private void floodFill(int[][] screen, int x, int y, int oldC, int newC) {
		// -----[ Base case ]----- //
		if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length || screen[x][y] != oldC)
			return;

		screen[x][y] = newC;
		floodFill(screen, x + 1, y, oldC, newC);
		floodFill(screen, x - 1, y, oldC, newC);
		floodFill(screen, x, y + 1, oldC, newC);
		floodFill(screen, x, y - 1, oldC, newC);
	}

}
