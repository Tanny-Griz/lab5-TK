package week_5;

import org.junit.Before;
import org.junit.Test;
import test_utils.ArrayListUtils;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by clara on 2019-09-10.
 */
public class Question_4_Camping_ReservationsTest {
    
    static final int TIMEOUT = 3000;

    @Before
    public void useOriginalMaps() {
        Map<String, String> site1 = Map.of("type", "RV", "has_water", "YES", "not_allowed", "", "availability", "RESERVED", "all_year", "AVAILABLE");
        Map<String, String> site2 = Map.of("type", "RV", "has_water", "YES", "not_allowed", "", "availability", "AVAILABLE", "all_year", "AVAILABLE");
        Map<String, String> site3 = Map.of("type", "TENT", "has_water", "YES", "not_allowed", "RV", "availability", "RESERVED", "all_year", "AVAILABLE");
        Map<String, String> site4 = Map.of("type", "TENT", "has_water", "NO", "not_allowed", "RV", "availability", "AVAILABLE", "all_year", "AVAILABLE");
        Map<String, String> site5 = Map.of("type", "TENT", "has_water", "NO", "not_allowed", "RV", "availability", "AVAILABLE", "all_year", "AVAILABLE");
        Map<String, String> site6 = Map.of("type", "TENT", "has_water", "NO", "not_allowed", "", "availability", "RESERVED", "all_year", "SUMMER_ONLY");
        Map<String, String> site7 = Map.of("type", "RV", "has_water", "NO", "not_allowed", "", "availability", "AVAILABLE", "all_year", "SUMMER_ONLY");
        Map<String, String> site8 = Map.of("type", "RV", "has_water", "YES", "not_allowed", "", "availability", "AVAILABLE", "all_year", "SUMMER_ONLY");
        Map<String, String> site9 = Map.of("type", "RV", "has_water", "NO", "not_allowed", "", "availability", "RESERVED", "all_year", "SUMMER_ONLY");
        Map<String, String> site10 = Map.of("type", "RV", "has_water", "YES", "not_allowed", "", "availability", "AVAILABLE", "all_year", "SUMMER_ONLY");

         Map<String, Map<String, String>> siteInfo = Map.of("one", site1, "two", site2, "three", site3, "four", site4, "five", site5, "six", site6, "seven", site7, "eight", site8, "nine", site9, "ten", site10);

         Question_4_Camping_Reservations.siteInfo = siteInfo;
    }

    @Test(timeout = TIMEOUT)
    public void testSearchTentWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("TENT", true);
        List<String> expected = List.of();
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    }
    
    
    @Test(timeout = TIMEOUT)
    public void testSearchTentNoWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("TENT", false);
        List<String> expected = List.of("four", "five");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    
    }
    
    @Test(timeout = TIMEOUT)
    public void testSearchRVWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("RV", true);
        List<String> expected = List.of("two", "eight", "ten");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    
    }
    
    @Test(timeout = TIMEOUT)
    public void testSearchRVNoWater() {
        List<String> results = Question_4_Camping_Reservations.getMatchingSites("RV", false);
        List<String> expected = List.of("seven");
        assertTrue(ArrayListUtils.stringListSameElementsAnyOrder(results, expected, true));
    }
    
    
}