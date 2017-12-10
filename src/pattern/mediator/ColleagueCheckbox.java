package pattern.mediator;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements Colleague, ItemListener {

	private Mediator mediator;

	public ColleagueCheckbox(String label, CheckboxGroup group, boolean state)
			throws HeadlessException {
		super(label, state, group);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged();
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}

}
