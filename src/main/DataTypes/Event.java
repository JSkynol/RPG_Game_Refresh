package main.DataTypes;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Event {
	private KeyEvent oldKey, newKey;
	private ActionEvent oldAction, newAction;
	private boolean keyUpdate;
	private boolean actionUpdate;

	public Event(KeyEvent ke, ActionEvent ae) {
		oldKey = newKey;
		oldAction = newAction;
		newKey = ke;
		newAction = ae;
	}

	public KeyEvent getKeyEvent() {
		return oldKey;
	}

	public ActionEvent getActionEvent() {
		return oldAction;
	}

	public boolean updatedKey() {
		boolean tr = false;
		if (oldKey != null) {
			if (oldKey.getKeyChar() != newKey.getKeyChar()) {
				tr = true;
			}
		}

//		System.out.println("Updated Key: "+tr + " " + (oldKey!=null)+ " " );
		return true;
	}

	public boolean updatedAction() {
		boolean tr = false;
		if (oldAction != null) {
			if (oldAction.getActionCommand() != newAction.getActionCommand()) {
				tr = true;
			}
		}
		return true;
	}

}
