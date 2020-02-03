package gravastar.testing;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GravastarTester
{
    @Test
    public void test() {
        int[] coins = {4, 1, 0, 5};
        int[] change = {5, 1, 2, 1};
        assertArrayEquals(coins, change);
    }
}
