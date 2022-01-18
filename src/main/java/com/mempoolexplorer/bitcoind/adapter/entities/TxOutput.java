package com.mempoolexplorer.bitcoind.adapter.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TxOutput {
	private String address;// Can be null
	private Long amount;// In Satoshis.
	private Integer index;// Begins in 0
}
