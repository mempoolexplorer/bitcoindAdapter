package com.mempoolexplorer.bitcoind.adapter.components.factories.utils;

import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.RawMemPoolEntryData;
import com.mempoolexplorer.bitcoind.adapter.entities.Fees;
import com.mempoolexplorer.bitcoind.adapter.entities.Transaction;
import com.mempoolexplorer.bitcoind.adapter.entities.TxAncestry;
import com.mempoolexplorer.bitcoind.adapter.utils.JSONUtils;

public class TransactionFactory {

	private TransactionFactory() {
		throw new IllegalStateException("Can't instantiate utility class");
	}

	public static Transaction from(String txId, RawMemPoolEntryData getRawMemPoolVerboseData) {

		Transaction tx = new Transaction();
		tx.setTxId(txId);
		TxAncestry txa = new TxAncestry();

		txa.setAncestorCount(getRawMemPoolVerboseData.getAncestorcount());
		txa.setAncestorSize(getRawMemPoolVerboseData.getAncestorsize());
		txa.setDepends(getRawMemPoolVerboseData.getDepends());
		txa.setSpentby(getRawMemPoolVerboseData.getSpentby());
		txa.setDescendantCount(getRawMemPoolVerboseData.getDescendantcount());
		txa.setDescendantSize(getRawMemPoolVerboseData.getDescendantsize());

		tx.setTxAncestry(txa);
		tx.setTimeInSecs(getRawMemPoolVerboseData.getTime());
		tx.setBip125Replaceable(getRawMemPoolVerboseData.getBip125Replaceable());

		Fees fees = new Fees();
		fees.setBase(JSONUtils.jsonToAmount(getRawMemPoolVerboseData.getFees().getBase()));
		fees.setModified(JSONUtils.jsonToAmount(getRawMemPoolVerboseData.getFees().getModified()));
		fees.setAncestor(JSONUtils.jsonToAmount(getRawMemPoolVerboseData.getFees().getAncestor()));
		fees.setDescendant(JSONUtils.jsonToAmount(getRawMemPoolVerboseData.getFees().getDescendant()));
		tx.setFees(fees);
		tx.setWeight(getRawMemPoolVerboseData.getWeight());

		// Estos datos se tienen que rellenar via query a getRawTransaction.
		// tx.setTxInputs(txInputs);
		// tx.setTxOutputs(txOutputs);
		return tx;
	}

}
