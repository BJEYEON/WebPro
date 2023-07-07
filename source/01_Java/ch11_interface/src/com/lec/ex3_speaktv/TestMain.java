package com.lec.ex3_speaktv;

public class TestMain {
	public static void main(String[] args) {
		IVolume speaker = new Speaker();
		/* IVolume */ TV tv = new TV();
		// IVolume tv = new TV();
		IVolume[] devices = { speaker, tv };
		for (IVolume device : devices) {
			device.volumeUp();
			device.volumeUp(50);
			device.volumeDown();
			device.volumeDown(50);
			device.setMute(true);
			device.setMute(false);
		}
		IVolume.changeBattery();
	}

}
