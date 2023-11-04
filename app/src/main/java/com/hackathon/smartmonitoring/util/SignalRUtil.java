package com.hackathon.smartmonitoring.util;

import com.hackathon.smartmonitoring.network.response.NotificationLogResponse;
import com.microsoft.signalr.HubConnection;
import com.microsoft.signalr.HubConnectionBuilder;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class SignalRUtil {
    private HubConnection hubConnection;

    public SignalRUtil(String serverUrl) {
        hubConnection = HubConnectionBuilder.create(serverUrl).build();
    }

    public void startConnection() {
        hubConnection.start().blockingAwait();
        System.out.println(hubConnection.getConnectionState());
    }

    public void stopConnection() {
        hubConnection.stop();
    }

    public void addOnAddListener(AddListener listener) {
        hubConnection.on("Add", (data) -> {
            listener.onAdd(data);
        }, NotificationLogResponse.class);
    }

    public interface AddListener {
        void onAdd(NotificationLogResponse data);
    }
}

