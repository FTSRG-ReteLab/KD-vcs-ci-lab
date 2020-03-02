package hu.bme.mit.train.tachograph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.google.common.collect.Table;
import com.google.common.collect.HashBasedTable;

public class TrainSensorTest {

    @Before
    public void before() {
        // TODO Add initializations
	TrainTachographImpl t = new TrainTachographImpl("a", "a", "a");
    }

    @Test
    public void CheckingIfTachographHasElements() {
        // TODO Delete this and add test cases based on the issues
	Assert.assertEquals(false, t.isEmpty());
    }
}
