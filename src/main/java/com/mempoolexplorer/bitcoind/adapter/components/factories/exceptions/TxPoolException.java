package com.mempoolexplorer.bitcoind.adapter.components.factories.exceptions;


public class TxPoolException extends Exception {

	private static final long serialVersionUID = 1L;

	public TxPoolException(String msg) {
		super(msg);
	}

	public TxPoolException(String msg, Throwable cause) {
		super(msg,cause);
	}
	
	public TxPoolException(Throwable cause) {
		super(cause);
	}

}
