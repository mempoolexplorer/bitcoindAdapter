package com.mempoolexplorer.bitcoind.adapter.components.containers.bitcoindstate;

import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetBlockChainInfoData;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetNetworkInfoData;

public interface BitcoindStateContainer {

    void setBlockChainInfoData(GetBlockChainInfoData blockChainInfoData);

    GetBlockChainInfoData getBlockChainInfoData();

    void setNetworkInfoData(GetNetworkInfoData networkInfoData);

    GetNetworkInfoData getNetworkInfoData();

    boolean isPruned();
}
