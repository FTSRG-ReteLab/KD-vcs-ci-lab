package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockController;
    TrainUser mockUser;
    TrainSensorImpl sensor;

    @Before
    public void before() {
    	mockController = mock(TrainController.class);
        mockUser = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockController, mockUser);
    }

    @Test
    public void Test_SensorAbs_False() {
    	int[] testData = {0, 1, 250, 499, 500};
    	for (int d : testData) {
    		sensor.overrideSpeedLimit(d);
    	}
    	verify(mockUser, times(testData.length)).setAlarmState(false);
    	verify(mockUser, times(0)).setAlarmState(true);
    }
    
    @Test
    public void Test_SensorAbs_True() {
    	int[] testData = {-1, 501};
    	for (int d : testData) {
    		sensor.overrideSpeedLimit(d);
    	}
    	verify(mockUser, times(testData.length)).setAlarmState(true);
    	verify(mockUser, times(0)).setAlarmState(false);
    }
    
    @Test
    public void Test_SensorRel_False() {
    	int[] testData = {50, 51};
    	when(mockController.getReferenceSpeed()).thenReturn(100);
    	for (int d : testData) {
    		sensor.overrideSpeedLimit(d);
    	}
    	verify(mockUser, times(testData.length)).setAlarmState(false);
    }
    
    @Test
    public void Test_SensorRel_True() {
    	int[] testData = {49};
    	when(mockController.getReferenceSpeed()).thenReturn(100);
    	for (int d : testData) {
    		sensor.overrideSpeedLimit(d);
    	}
    	verify(mockUser, times(testData.length)).setAlarmState(true);
    }
}
