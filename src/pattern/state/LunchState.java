package pattern.state;

public class LunchState implements State {
	
	private static LunchState singleton = new LunchState();
	
	private LunchState() {
	}
	
	public static LunchState getInstance() {
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {
		if ((9 <= hour && hour < 12)
				|| (12 <= hour && hour < 17)) {
			context.changeState(DayState.getInstance());
		} else if (hour < 9 || 17 <= hour) {
			context.changeState(NightState.getInstance());
		}
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("非常：昼食時の金庫使用！");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル(昼食時)");
		context.changeState(EmergencyState.getInstance());
	}

	@Override
	public void doPhone(Context context) {
		context.recordLog("昼食時の通話記録");

	}
	
	public String toString() {
		return "[昼食時]";
	}
}
