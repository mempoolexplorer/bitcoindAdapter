package com.mempoolexplorer.bitcoind.adapter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mempoolexplorer.bitcoind.adapter.components.alarms.AlarmLogger;

@RestController
@RequestMapping("/alarms")
public class AlarmsController {

	@Autowired
	private AlarmLogger alarmLogger;

	@GetMapping("/list")
	public List<String> getAlarms() {
		return alarmLogger.getAlarmList();
	}

}
