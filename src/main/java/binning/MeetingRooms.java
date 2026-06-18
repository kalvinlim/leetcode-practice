package binning;

import java.util.Arrays;

public class MeetingRooms {
    /**
     * Determines if a person can attend all meetings without any time conflicts.
     *
     * @param intervals 2D array where each element is [startTime, endTime] of a meeting
     * @return true if all meetings can be attended (no overlaps), false otherwise
     */
    public static boolean canAttendMeetings(int[][] intervals) {
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
}
