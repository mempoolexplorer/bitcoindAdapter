package com.mempoolexplorer.bitcoind.adapter.controllers;

import com.mempoolexplorer.bitcoind.adapter.components.containers.smartfees.SmartFeesContainer;
import com.mempoolexplorer.bitcoind.adapter.entities.SmartFees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/smartFees")
public class SmartFeesController {

	@Autowired
	private SmartFeesContainer smartFeesContainer;

	@GetMapping("")
	public SmartFees getSmartFees() {
		return smartFeesContainer.getCurrentSmartFees();
	}
}
