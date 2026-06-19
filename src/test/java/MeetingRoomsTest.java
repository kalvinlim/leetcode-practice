import binning.MeetingRooms;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeetingRoomsTest {
    @Before
    public void setup() {
    }

    @Test
    public void meetingRoomsITest_true() {
        int[][] intervals = new int[][]{{0,5}, {10,15}, {20,25}};
        assertTrue(MeetingRooms.meetingRoomsI(intervals));
    }

    @Test
    public void meetingRoomsITest_false() {
        int[][] intervals = new int[][]{{0,30}, {5,10}, {20,25}};
        assertFalse(MeetingRooms.meetingRoomsI(intervals));
    }

    // Test cases for minMeetingRoomsII
    @Test
    public void minMeetingRoomsII_empty() {
        int[][] intervals = new int[][]{};
        assertEquals(0, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_null() {
        assertEquals(0, MeetingRooms.minMeetingRoomsII(null));
    }

    @Test
    public void minMeetingRoomsII_singleMeeting() {
        int[][] intervals = new int[][]{{0, 30}};
        assertEquals(1, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_noOverlaps() {
        int[][] intervals = new int[][]{{0, 5}, {10, 15}, {20, 25}};
        assertEquals(1, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_allOverlap() {
        int[][] intervals = new int[][]{{0, 30}, {5, 20}, {10, 15}};
        assertEquals(3, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_boundaryTouching() {
        // Meeting ends exactly when another starts (should reuse room)
        int[][] intervals = new int[][]{{0, 5}, {5, 10}, {10, 15}};
        assertEquals(1, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_partialOverlap() {
        // Two groups: first group 3 overlaps, second group 2 overlaps
        int[][] intervals = new int[][]{{0, 10}, {3, 8}, {5, 12}, {25, 35}, {28, 30}};
        assertEquals(3, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_twoMeetingsOverlap() {
        int[][] intervals = new int[][]{{0, 30}, {5, 25}};
        assertEquals(2, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_unsortedInput() {
        // Test that function handles unsorted intervals
        int[][] intervals = new int[][]{{5, 10}, {0, 5}, {10, 15}};
        assertEquals(1, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_complexOverlap() {
        // Multiple overlapping meetings at different times
        int[][] intervals = new int[][]{{1, 5}, {2, 6}, {3, 7}, {4, 8}, {5, 9}, {15, 20}};
        assertEquals(4, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_sameStartTimes() {
        // Multiple meetings starting at the same time
        int[][] intervals = new int[][]{{0, 10}, {0, 15}, {0, 5}};
        assertEquals(3, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_sameStartAndEndTimes() {
        // Identical meetings
        int[][] intervals = new int[][]{{5, 10}, {5, 10}, {5, 10}};
        assertEquals(3, MeetingRooms.minMeetingRoomsII(intervals));
    }

    @Test
    public void minMeetingRoomsII_largeGapsWithOverlaps() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {100, 105}, {101, 106}, {102, 107}};
        assertEquals(3, MeetingRooms.minMeetingRoomsII(intervals));
    }

}
