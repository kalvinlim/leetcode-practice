import backtracking.BackTrackingTemplate;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static backtracking.BackTrackingTemplate.findSubsets;
import static org.junit.Assert.assertEquals;

public class BackTrackingTest {

    @Before
    public void setup() {

    }

    @Test
    public void findAllPermutations_Test() {
        int[] nums = new int[]{1, 2, 3};

        List<List<Integer>> result = BackTrackingTemplate.permute(nums);
        System.out.println("FINAL NUMS = " + result);

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(1, 3, 2),
            Arrays.asList(2, 1, 3),
            Arrays.asList(2, 3, 1),
            Arrays.asList(3, 1, 2),
            Arrays.asList(3, 2, 1)
        );

        assertEquals(expected, result);
    }

    @Test
    public void findAllSubsets_standard_Test() {
        // 1. Define the input array
        int[] inputNumbers = {1, 2, 3};
        // 2. Initialize the list to store all subsets
        List<List<Integer>> allSubsets = new ArrayList<>();

        // 3. Call the subset algorithm starting at index 0
        BackTrackingTemplate.backtrackPermuations(allSubsets, new ArrayList<>(), inputNumbers, 0);

        // 4. Assert the final results (expected order produced by the algorithm)
        List<List<Integer>> expectedSubsets = new ArrayList<>(List.of(
                new ArrayList<>(),
                new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(1, 2)),
                new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of(1, 3)),
                new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(2, 3)),
                new ArrayList<>(List.of(3))
        ));

        assertEquals(expectedSubsets, allSubsets);
    }


    @Ignore
    @Test
    public void findAllSubsets_Test() {
        // 1. Define the input array
        int[] inputNumbers = {1, 2, 3};
        // 2. Initialize the list to store all subsets
        List<List<Integer>> allSubsets = new ArrayList<>();

        // 3. Call the subset algorithm starting at index 0
        findSubsets(inputNumbers, 0, new ArrayList<>(), allSubsets);

        // 4. Assert the final results (expected order produced by the algorithm)
        List<List<Integer>> expectedSubsets = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of(1, 2)),
                new ArrayList<>(List.of(1, 3)),
                new ArrayList<>(List.of(1)),
                new ArrayList<>(List.of(2, 3)),
                new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(3)),
                new ArrayList<>()
        ));

        assertEquals(expectedSubsets, allSubsets);
    }

    @Test
    public void permuteUnique_example1_Test() {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> result = new BackTrackingTemplate().permuteUnique(nums);
        System.out.println("permuteUnique result = " + result);
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1,1,2),
            Arrays.asList(1,2,1),
            Arrays.asList(2,1,1)
        );
        assertEquals(expected, result);
    }

    @Test
    public void permuteUnique_example2_Test() {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> result = new BackTrackingTemplate().permuteUnique(nums);
        System.out.println("permuteUnique result = " + result);
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(1,3,2),
            Arrays.asList(2,1,3),
            Arrays.asList(2,3,1),
            Arrays.asList(3,1,2),
            Arrays.asList(3,2,1)
        );
        assertEquals(expected, result);
    }
}
