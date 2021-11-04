package com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class BitcoindErrorResult extends BitcoindResult {

	@JsonProperty("result")
	private String result = null;

}