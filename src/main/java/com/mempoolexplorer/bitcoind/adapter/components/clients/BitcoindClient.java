package com.mempoolexplorer.bitcoind.adapter.components.clients;

import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.requests.EstimateType;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.EstimateSmartFeeResult;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetBlockResult;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetBlockTemplateResult;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetMemPoolEntry;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetMemPoolInfo;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetRawMemPoolNonVerbose;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetRawMemPoolVerbose;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetVerboseRawTransactionResult;

public interface BitcoindClient {

	GetRawMemPoolNonVerbose getRawMemPoolNonVerbose();

	GetRawMemPoolVerbose getRawMemPoolVerbose();

	GetMemPoolEntry getMempoolEntry(String txId);

	GetBlockTemplateResult getBlockTemplateResult();

	GetMemPoolInfo getMemPoolInfo();

	GetVerboseRawTransactionResult getVerboseRawTransaction(String txId);

	Integer getBlockCount();

	GetBlockResult getBlock(Integer blockHeight);

	GetBlockResult getBlock(String blockHash);

	EstimateSmartFeeResult estimateSmartFee(EstimateType estimateType, int blocks);

}
