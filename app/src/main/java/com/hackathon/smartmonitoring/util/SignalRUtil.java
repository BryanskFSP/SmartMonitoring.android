package com.hackathon.smartmonitoring.util;

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
    }

    public void stopConnection() {
        hubConnection.stop();
    }

    public void addOnMessageReceivedListener(MessageReceivedListener listener) {
        hubConnection.on("ReceiveMessage", (user, message) -> {
            listener.onMessageReceived(user, message);
        }, String.class, String.class);
    }

    public void sendMessage(String user, String message) {
        hubConnection.send("SendMessage", user, message);
    }

    public interface MessageReceivedListener {
        void onMessageReceived(String user, String message);
    }
//    public SignalRUtil(String serverUrl) {
//        hubConnection = HubConnectionBuilder.create(serverUrl).build();
//    }
//
//    public void startConnection() {
//        hubConnection.start().subscribe(new CompletableObserver() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onComplete() {
//                String connectionId = hubConnection.getConnectionId();
//                System.out.println("Success");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                System.out.println(e.getLocalizedMessage());
//            }
//        });
//    }
//
//    public void stopConnection() {
//        hubConnection.stop();
//    }
//
//    public void addOnMessageReceivedListener(MessageReceivedListener listener) {
//        hubConnection.on("ReceiveMessage", (user, message) -> {
//            listener.onMessageReceived(user, message);
//        }, String.class, String.class);
//    }
//
//    public void sendMessage(String user, String message) {
//        hubConnection.send("SendMessage", user, message);
//    }
//
//    public interface MessageReceivedListener {
//        void onMessageReceived(String user, String message);
//    }
}

