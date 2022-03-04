package com.lagerweij;

import org.junit.Assert;
import org.junit.Test;

public class TestGearBox {

    @Test
    public void testNormalRPM() {
        GearBox gearbox = new GearBox();
        gearbox.gear = 3;
        gearbox.shiftGear(1000);
        Assert.assertEquals(3, gearbox.gear);
    }

    @Test
    public void testShiftUp() {
        GearBox gearbox = new GearBox();
        gearbox.gear = 3;
        gearbox.shiftGear(3000);
        Assert.assertEquals(4, gearbox.gear);
    }

    @Test
    public void testShiftDown() {
        GearBox gearbox = new GearBox();
        gearbox.gear = 3;
        gearbox.shiftGear(400);
        Assert.assertEquals(2, gearbox.gear);
    }
}
