package darkRealm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

//  #40. Combination Sum II   :::   Complexity  -   Time : O(2^N)   :::   Space  : DFS Stack : O(N)
//  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
//  candidate numbers sums to T.
//  Each number in C may only be used once in the combination.
//  Note:
//  All numbers (including target) will be positive integers.
//  The solution set must not contain duplicate combinations.
//  For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
//  A solution set is:
//      [
//      [1, 7],
//      [1, 2, 5],
//      [2, 6],
//      [1, 1, 6]
//      ]

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0 || target < 1) return res;
    // sorting and always moving in forward dir guarantees that if 2,7 tuple is generated, 7,2 tuple will not generate
    Arrays.sort(candidates);
    helper(0, candidates, target, new ArrayList<>(), res);
    return res;
  }

  private static void helper(int start, int[] nums, int target, List<Integer> list, List<List<Integer>> res) {
    if (target < 0) return;
    if (target == 0) {
      List<Integer> temp = new ArrayList<>();
      temp.addAll(list);
      res.add(temp);
      return;
    }
    for (int i = start; i < nums.length; i++) {
      //  if for the given starting index we have already included this element then dont include duplicates
      if (i > start && nums[i] == nums[i - 1]) continue;
      list.add(nums[i]);
      helper(i + 1, nums, target - nums[i], list, res);
      list.remove(list.size() - 1);
    }
  }

  public static void main(String[] args) {
//    int[] nums = new int[]{10, 1, 2, 7, 6, 1, 5};
    int[] nums = new int[]{1, 2, 7, 6, 1, 5};
    int target = 8;
    List<List<Integer>> res = combinationSum2(nums, target);
    System.out.println(Arrays.toString(nums));
    System.out.println("---------------------");
    for (List<Integer> l : res)
      System.out.println(l);
  }
}
