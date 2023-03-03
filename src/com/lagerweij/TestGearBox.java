package com.lagerweij;

import org.junit.Assert;
import org.junit.Test;

public class TestGearBox {

    @Test
    public void testShiftUpWhenHighRPM() {
        // setup
        GearBox gearBox = new GearBox();
        gearBox.gear = 3;

        // execute
        gearBox.shiftGear(2500);

        // validate / test
        Assert.assertEquals(4, gearBox.gear);
    }

    @Test
    public void testShiftDownWhenLowRPM() {
        GearBox gearBox = new GearBox();
        gearBox.gear = 3;
        gearBox.shiftGear(400);
        Assert.assertEquals(2, gearBox.gear);
    }

    @Test
    public void testNoShiftDownInGearOne() {
        GearBox gearBox = new GearBox();
        gearBox.gear = 1;
        gearBox.shiftGear(400);
        Assert.assertEquals(1, gearBox.gear);
    }

    @Test
    public void testNoShiftUpInGearSix() {
        GearBox gearBox = new GearBox();
        gearBox.gear = 6;
        gearBox.shiftGear(3000);
        Assert.assertEquals(6, gearBox.gear);
    }

    @Test
    public void testRemainInNeutral() {
        GearBox gearBox = new GearBox();
        gearBox.gear = 0;
        gearBox.shiftGear(2500);
        Assert.assertEquals(0, gearBox.gear);
    }

    @Test
    public void testRemainInCurrentGear() {
        GearBox gearBox = new GearBox();
        gearBox.gear = 4;
        gearBox.shiftGear(1500);
        Assert.assertEquals(4, gearBox.gear);
    }
}
