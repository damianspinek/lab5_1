package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class LaunchPatriotExecutor implements Executor {

	@Override
	public void execute(Runnable arg0) {
		arg0.run();

	}

}
