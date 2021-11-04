package com.mempoolexplorer.bitcoind.adapter.controllers;

import java.util.List;

import com.mempoolexplorer.bitcoind.adapter.components.containers.blocktemplate.BlockTemplateContainer;
import com.mempoolexplorer.bitcoind.adapter.entities.blocktemplate.BlockTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blockTemplate")
public class BlockTemplateController {

	@Autowired
	private BlockTemplateContainer blockTemplateContainer;

	@GetMapping("/blockTemplates")
	public List<BlockTemplate> getBlockTemplates() {
		return blockTemplateContainer.peekBlockTemplates();
	}

}
