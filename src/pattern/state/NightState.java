package pattern.state;

public class NightState implements State {
	
	private static NightState singleton = new NightState();
	
	private NightState() {
	}
	
	public static NightState getInstance() {
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {
		if (9 <= hour && hour < 17) {
			context.changeState(DayState.getInstance());
		} else if (12 <= hour && hour < 13) {
			context.changeState(LunchState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("非常：夜間の金庫使用！");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル(夜間)");
		context.changeState(EmergencyState.getInstance());
	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("夜間の通話記録");
	}
	
	public String toString() {
		return "[夜間]";
	}
}
