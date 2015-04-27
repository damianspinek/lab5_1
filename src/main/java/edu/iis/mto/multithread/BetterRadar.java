package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {
	private PatriotBattery battery;
	private Executor launchExecutor;

	public BetterRadar(PatriotBattery missle) {
		this.battery = missle;
	}

	public void notice(Scud enemyMissle) {
		launchPatriot();
	}

	private void launchPatriot() {
		Runnable launchPatriotTask = new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) 
					battery.launchPatriot();
				
			}
		};
		launchExecutor.execute(launchPatriotTask);
	}



	public void setLaunchExecutor(Executor launchExecutor) {
		this.launchExecutor = launchExecutor;
	}
}
