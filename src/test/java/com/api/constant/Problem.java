package com.api.constant;

public enum Problem {
	 SMARTPHONE_IS_RUNNING_SLOW(1),
	 Poor_battery_life(2),
	 Phone_or_app_crashes(3),
	 Sync_issue(4),
	 MicroSD_card_is_not_working_on_your_phone(5),
	 Overheating(6),
	 Connecting_problem_with_Bluetooth_Wifi_Cellular_network(7),
	 Cracked_screen(8);
	
	int code;
	private Problem(int code) {
		this.code=code;
	}
public int getCode() {
	return code;
}
}
