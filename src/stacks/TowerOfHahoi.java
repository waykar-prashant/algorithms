package stacks;

public class TowerOfHahoi {

	public void moveDisksUsingRecursion(int n, String src, String dest, String aux) {
		if (n == 1) {
			// When n==1, it means we are left with only one disk, so directly
			// move it from source to destination.
			System.out.println("Disk : 1 , " + src + " -> " + dest);
		} else {
			moveDisksUsingRecursion(n - 1, src, aux, dest);
			System.out.println("Disk : " + n + " , " + src + " -> " + dest);
			moveDisksUsingRecursion(n - 1, aux, dest, src);
		}
	}

	
	public void moveDisksUsingIteration() {
		
	}
}
