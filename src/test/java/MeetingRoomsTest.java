import binning.MeetingRooms;
import org.junit.Before;
import org.junit.Test;
import stacksAndHeaps.StackAndHeaps;

import static org.junit.Assert.*;

public class MeetingRoomsTest {
    @Before
    public void setup() {
    }

    @Test
    public void canAttendMeetingsTest_true() {
        int[][] intervals = new int[][]{{0,5}, {10,15}, {20,25}};
        assertTrue(MeetingRooms.canAttendMeetings(intervals));
    }

    @Test
    public void canAttendMeetingsTest_false() {
        int[][] intervals = new int[][]{{0,30}, {5,10}, {20,25}};
        assertFalse(MeetingRooms.canAttendMeetings(intervals));
    }


}
