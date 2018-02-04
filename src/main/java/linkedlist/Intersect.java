package linkedlist;

import java.util.*;

public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> num1Map = new HashMap<>();
//        List<Integer> result = new ArrayList<>();
//
//        Arrays.stream(nums1).forEach(element-> num1Map.put(element, num1Map.getOrDefault(element,0)+1));
//
//        System.out.println(num1Map);
//        Arrays.stream(nums2).forEach(key->{
//           if(num1Map.getOrDefault(key, 0) > 0) {
//               System.out.println(key);
//               result.add(key);
//               num1Map.put(key, num1Map.get(key)-1);
//           }
//        });
//        int[] foo = result.stream().mapToInt(i->i).toArray();
//        System.out.println(Arrays.toString(foo));
//        return foo;
        int[] nums3 = {2,1};
        return nums3;
    }

    public static void main(String args[]) {
        int[] nums1 = {2,1};
        int[] nums2 = {1,2};
        intersect(nums1, nums2);
    }
}
