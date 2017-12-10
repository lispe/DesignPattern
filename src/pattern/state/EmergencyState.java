package pattern.state;

/**
 * 非常時の状態を表すStateインターフェースの実装クラス<br>
 * 問題点：非常時から通常に復帰する手段がない。
 */
public class EmergencyState implements State {
	
	private static EmergencyState singleton = new EmergencyState();
	
	private EmergencyState() {
	}
	
	public static EmergencyState getInstance() {
		return singleton;
	}

	@Override
	public void doClock(Context context, int hour) {
		// 時刻による状態変化はしない
	}

	@Override
	public void doUse(Context context) {
		context.callSecurityCenter("非常：非常時の金庫使用");
	}

	@Override
	public void doAlarm(Context context) {
		context.callSecurityCenter("非常ベル(非常時)");
	}

	@Override
	public void doPhone(Context context) {
		context.callSecurityCenter("通常の通話(非常時)");
	}

}
