package com.lagerweij;

import org.junit.Assert;
import org.junit.Test;

public class TestGearBox {

    @Test
    public void testNoShift() {
        GearBox gearbox = new GearBox();
        gearbox.gear = GearBox.MIN_GEAR + 1;

        gearbox.shiftGear(GearBox.LOWER_RPM_BOUND);
        Assert.assertEquals(GearBox.MIN_GEAR + 1, gearbox.gear);

        gearbox.shiftGear(GearBox.UPPER_RPM_BOUND);
        Assert.assertEquals(GearBox.MIN_GEAR + 1, gearbox.gear);
    }

    @Test
    public void testShiftUp() {
        GearBox gearbox = new GearBox();
        gearbox.gear = GearBox.MAX_GEAR - 1;
        gearbox.shiftGear(GearBox.UPPER_RPM_BOUND + 1);
        Assert.assertEquals(GearBox.MAX_GEAR, gearbox.gear);
    }

    @Test
    public void testShiftDown() {
        GearBox gearbox = new GearBox();
        gearbox.gear = GearBox.MIN_GEAR + 1;
        gearbox.shiftGear(GearBox.LOWER_RPM_BOUND - 1);
        Assert.assertEquals(GearBox.MIN_GEAR, gearbox.gear);
    }

    @Test
    public void testNoShiftUpInMaxGear() {
        GearBox gearbox = new GearBox();
        gearbox.gear = GearBox.MAX_GEAR;
        gearbox.shiftGear(GearBox.UPPER_RPM_BOUND + 1);
        Assert.assertEquals(GearBox.MAX_GEAR, gearbox.gear);
    }

    @Test
    public void testNoShiftDownInMinGear() {
        GearBox gearbox = new GearBox();
        gearbox.gear = GearBox.MIN_GEAR;
        gearbox.shiftGear(GearBox.LOWER_RPM_BOUND - 1);
        Assert.assertEquals(GearBox.MIN_GEAR, gearbox.gear);
    }

    @Test
    public void testNoShiftInNeutral() {
        GearBox gearbox = new GearBox();
        gearbox.gear = 0;

        gearbox.shiftGear(GearBox.LOWER_RPM_BOUND - 1);
        Assert.assertEquals(0, gearbox.gear);

        gearbox.shiftGear(GearBox.UPPER_RPM_BOUND + 1);
        Assert.assertEquals(0, gearbox.gear);
    }

    @Test
    public void testNoShiftInReverse() {
        GearBox gearbox = new GearBox();
        gearbox.gear = -1;

        gearbox.shiftGear(GearBox.LOWER_RPM_BOUND - 1);
        Assert.assertEquals(-1, gearbox.gear);

        gearbox.shiftGear(GearBox.UPPER_RPM_BOUND + 1);
        Assert.assertEquals(-1, gearbox.gear);
    }

}
