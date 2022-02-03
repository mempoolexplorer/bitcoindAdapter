package com.mempoolexplorer.bitcoind.adapter;

import com.mempoolexplorer.bitcoind.adapter.components.factories.exceptions.TxPoolException;
import com.mempoolexplorer.bitcoind.adapter.threads.MainThread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.stream.binder.Binding;
import org.springframework.cloud.stream.binder.BindingCreatedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * This is the main class where everything is started, uses spring events to
 * know when to start or end the application gracefully. Listen for
 * ApplicationReadyEvent and BindingCreatedEvent to start application,
 * ContextClosedEvent to shutdown. I think this is a better approach
 * to @DependsOn or @Order
 */
@Component
@Profile(value = { AppProfiles.DEV, AppProfiles.PROD })
public class AppLifeCycle {

    // It seems that Spring aplicaton events are thrown more than once, so these are
    // the flags to avoid calling clean-up methods more than once.
    private boolean hasInitializated = false;// Avoids intialization more than once
    private boolean isShutingdown = false; // Avoids finalization more than once
    private boolean onApplicationReadyEvent = false;
    private boolean onBindingCreatedEvent = false;

    // Kafka topic
    @Value("${spring.cloud.stream.bindings.txMemPoolEvents.destination}")
    private String topic;

    @Autowired
    private MainThread mainThread;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent(ApplicationReadyEvent event) throws TxPoolException {
        onApplicationReadyEvent = true;
        checkInitialization();
    }

    // Sent when kafka binding is done. Wait for it since we don't want to send
    // things before kafka initialization.
    @EventListener(BindingCreatedEvent.class)
    public void onBindingCreatedEvent(BindingCreatedEvent event) throws TxPoolException {
        @SuppressWarnings("unchecked") // Since we are receving this event we know it's type
        Binding<Object> binding = (Binding<Object>) event.getSource();
        // Checks that event.source is the same as our kafka topic
        if (binding.getName().compareTo(topic) == 0) {
            onBindingCreatedEvent = true;
            checkInitialization();
        }
    }

    // @PreDestroy <- This is not good, better use this:
    @EventListener(ContextClosedEvent.class)
    public void finalization() {
        if (isShutingdown)
            return;// No more than once
        isShutingdown = true;
        mainThread.finalization();
    }

    public void checkInitialization() throws TxPoolException {
        if (onApplicationReadyEvent && onBindingCreatedEvent && !hasInitializated) {
            hasInitializated = true;
            mainThread.start();
        }
    }

}
