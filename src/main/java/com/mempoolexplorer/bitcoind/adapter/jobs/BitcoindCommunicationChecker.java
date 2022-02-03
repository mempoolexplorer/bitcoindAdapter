package com.mempoolexplorer.bitcoind.adapter.jobs;

import com.mempoolexplorer.bitcoind.adapter.BitcoindAdapterApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitcoindCommunicationChecker {
    private static int MAX_FAILED = 5;
    private int failed = 0;

    public void addFail() {
        failed++;
        if (failed >= MAX_FAILED) {
            log.error("Can't communicate with bitcoind after 5 retries, Will exit inmediately...");
            BitcoindAdapterApplication.exit();// No comunication, force fail.
        }
    }

    public void addOk() {
        failed = 0;
    }
}
