package com.mempoolexplorer.bitcoind.adapter.components.containers.bitcoindstate;

import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetBlockChainInfoData;
import com.mempoolexplorer.bitcoind.adapter.bitcoind.entities.results.GetNetworkInfoData;

import org.springframework.stereotype.Component;

@Component
public class BitcoindStateContainerImpl implements BitcoindStateContainer {

    private GetBlockChainInfoData blockChainInfoData;
    private GetNetworkInfoData networkInfoData;

    @Override
    public void setBlockChainInfoData(GetBlockChainInfoData blockChainInfoData) {
        this.blockChainInfoData = blockChainInfoData;
    }

    @Override
    public GetBlockChainInfoData getBlockChainInfoData() {
        return blockChainInfoData;
    }

    @Override
    public void setNetworkInfoData(GetNetworkInfoData networkInfoData) {
        this.networkInfoData = networkInfoData;
    }

    @Override
    public GetNetworkInfoData getNetworkInfoData() {
        return networkInfoData;
    }

    @Override
    public boolean isPruned() {
        return blockChainInfoData.isPruned();
    }
}
