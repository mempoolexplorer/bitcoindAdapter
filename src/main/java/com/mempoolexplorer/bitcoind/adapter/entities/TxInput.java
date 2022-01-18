package com.mempoolexplorer.bitcoind.adapter.entities;

public class TxInput {
	private String address;// Can be null
	// coinBase transaction
	private Long amount;// In Satoshis.
	private String txId;// Transaction where output is being spent by this input
	private Integer vOutIndex;// The output index number (vout) of the outpoint being spent. The first output
	// in a transaction has an index of 0. Not present if this is a coinbase
	// transaction
	private String coinbase;// Coinbase, normally null.

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public void setVOutIndex(Integer vOutIndex) {
		this.vOutIndex = vOutIndex;
	}

	public Long getAmount() {
		return amount;
	}

	public String getTxId() {
		return txId;
	}

	public Integer getVOutIndex() {
		return vOutIndex;
	}

	public String getCoinbase() {
		return coinbase;
	}

	public void setCoinbase(String coinbase) {
		this.coinbase = coinbase;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TxInput [addressIds=");
		builder.append(address);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", txId=");
		builder.append(txId);
		builder.append(", vOutIndex=");
		builder.append(vOutIndex);
		builder.append(", coinbase=");
		builder.append(coinbase);
		builder.append("]");
		return builder.toString();
	}

}
