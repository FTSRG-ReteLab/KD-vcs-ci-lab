package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockTrainController;
    TrainUser mockTrainUser;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        mockTrainController = mock(TrainController.class);
        mockTrainUser = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTrainController, mockTrainUser);
    }

    @Test
    public void AbsoluteMargin1() {
        trainSensor.overrideSpeedLimit(-50);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void AbsoluteMargin2() {
        trainSensor.overrideSpeedLimit(550);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void RelativeMargin1() {
        trainSensor.overrideSpeedLimit(1);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void RelativeMargin2() {
        trainSensor.overrideSpeedLimit(4);
        verify(mockTrainUser, times(0)).setAlarmState(false);
    }

}
