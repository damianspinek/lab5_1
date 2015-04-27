package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {
	
	@Rule
	public RepeatRule repeatRule = new RepeatRule();
	
	@Test
	@Repeat( times = 100000 )
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		Executor launchExecutor = new LaunchPatriotExecutor();
		
		BetterRadar radar = new BetterRadar(batteryMock);
		radar.setLaunchExecutor(launchExecutor);
		radar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}

}
