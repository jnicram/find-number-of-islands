package com.jnicram.islands;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IslandsCounterImplTest {

    private final int[][] map;
    private final int expectedCount;

    private IslandsCounter classUnderTest;

    public IslandsCounterImplTest(int[][] map, int count) {
        this.map = map;
        this.expectedCount = count;
    }

    @Parameterized.Parameters( name = "{index}: should find {1} island(s)" )
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { new int[][] {} , 0 },
                { new int[][] { { 1 } }, 1},
                { new int[][] { { 0 } }, 0},
                { new int[][] {
                        { 1, 1, 0 },
                        { 0, 1, 0 },
                        { 1, 0, 0 }
                }, 1},
                { new int[][] {
                        { 1, 0, 1 },
                        { 0, 0, 1 },
                }, 2},
                { new int[][] {
                        { 1, 0, 1 },
                        { 0, 0, 1 },
                        { 1, 0, 0 }
                }, 3},
                { new int[][] {
                        { 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 1, 0, 1 },
                        { 1, 0, 0, 0, 1 }
                }, 2},
                { new int[][] {
                        { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0 },
                        { 1, 0, 1, 0, 1 }
                }, 5}
        };
        return Arrays.asList(data);
    }

    @Before
    public void init() {
        classUnderTest = new IslandsCounterImpl();
    }

    @Test
    public void shouldCountsIslandsForGivenBinaryMap() {
        // given

        // when
        final int result = classUnderTest.count(map);

        // then
        Assert.assertEquals(expectedCount, result);
    }
}