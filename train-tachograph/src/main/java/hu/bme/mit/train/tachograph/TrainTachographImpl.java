package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TrainTachographImpl {
	Table<String, String, String> tachographTable = HashBasedTable.create();

	public TrainTachographImpl(String currentTime, String joystickPostition, String referenceSpeed) {
		tachographTable.put(currentTime, joystickPosition, referenceSpeed);
	}
}
