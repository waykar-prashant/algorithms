/**
 * 
 */
package com.prashant.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author waykarp
 *
 */
public class SubsetsOfSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubsetsOfSet solution = new SubsetsOfSet();
		List<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		List<ArrayList<Integer>> allSubsets = solution.findSubsets(set);
		for (int i = 0; i < allSubsets.size(); i++) {
			ArrayList<Integer> tempSet = allSubsets.get(i);
			for (int j = 0; j < tempSet.size(); j++) {
				System.out.print(tempSet.get(j) + ", ");
			}
			System.out.print("\n");
		}
	}

	private List<ArrayList<Integer>> findSubsets(List<Integer> set) {
		List<ArrayList<Integer>> allSubsets = new ArrayList<>();
		allSubsets.add(new ArrayList<Integer>());
		findSubsets(allSubsets, set, 0);
		return allSubsets;
	}

	private void findSubsets(List<ArrayList<Integer>> allSubsets, List<Integer> set, int currentIndex) {

		if (currentIndex == set.size()) {
			return;
		}

		int allSubSetsSize = allSubsets.size();  
		for (int i = 0; i < allSubSetsSize; i++) {
			// Clone + Add
			ArrayList<Integer> newSet = colneList(allSubsets.get(i));
			newSet.add(set.get(currentIndex));
			allSubsets.add(newSet);
		}

		findSubsets(allSubsets, set, currentIndex + 1);

	}

	private ArrayList<Integer> colneList(ArrayList<Integer> arrayList) {
		ArrayList<Integer> clone = new ArrayList<>();
		for (int i = 0; i < arrayList.size(); i++) {
			clone.add(arrayList.get(i));
		}
		return clone;
	}

}
