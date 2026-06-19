package binning;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    /**
     * Determines if a person can attend all meetings without any time conflicts.
     *
     * @param intervals 2D array where each element is [startTime, endTime] of a meeting
     * @return true if all meetings can be attended (no overlaps), false otherwise
     */
    public static boolean meetingRoomsI(int[][] intervals) {
        // Sort meetings by start time in ascending order
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Check for overlapping meetings
        for (int i = 1; i < intervals.length; i++) {
            // If previous meeting's end time is after current meeting's start time,
            // there is an overlap
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }

        // No overlaps found, all meetings can be attended
        return true;
    }

    public static int minMeetingRoomsII(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Step 1: Sort meetings chronologically by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Min-heap stores end times of active meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Allocate a room for the first meeting
        minHeap.add(intervals[0][1]);

        // Step 3: Process the remaining meetings
        for (int i = 1; i < intervals.length; i++) {
            // If the earliest ending room is free, reuse it
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            // Put the current meeting's end time into the heap
            minHeap.add(intervals[i][1]);
        }

        // The remaining size of the heap is the min rooms required
        return minHeap.size();
    }
}
