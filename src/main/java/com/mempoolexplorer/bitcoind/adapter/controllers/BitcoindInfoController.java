package com.mempoolexplorer.bitcoind.adapter.controllers;

import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetBlockChainInfoData;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetNetworkInfoData;
import com.mempoolexplorer.bitcoind.adapter.components.containers.bitcoindstate.BitcoindStateContainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bitcoindInfo")
public class BitcoindInfoController {

	@Autowired
	private BitcoindStateContainer bitcoindStateContainer;

	@GetMapping("/blockChainInfo")
	public GetBlockChainInfoData getBlockChainInfoData() {
		return bitcoindStateContainer.getBlockChainInfoData();
	}

	@GetMapping("/networkInfo")
	public GetNetworkInfoData getNetworkInfoData() {
		return bitcoindStateContainer.getNetworkInfoData();
	}
}
