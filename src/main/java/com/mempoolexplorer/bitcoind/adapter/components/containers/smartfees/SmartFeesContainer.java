package com.mempoolexplorer.bitcoind.adapter.components.containers.smartfees;

import com.mempoolexplorer.bitcoind.adapter.entities.SmartFees;

import org.springframework.stereotype.Component;

@Component
public interface SmartFeesContainer {

    void refresh(SmartFees smartfees);

    SmartFees getCurrentSmartFees();
}
