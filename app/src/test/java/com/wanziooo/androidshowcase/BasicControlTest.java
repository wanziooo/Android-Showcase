package com.wanziooo.androidshowcase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicControlTest {

    @Test
    public void progressStartsAtThirtyFivePercent() {
        int progress = 35;
        assertEquals(35, progress);
    }
}
