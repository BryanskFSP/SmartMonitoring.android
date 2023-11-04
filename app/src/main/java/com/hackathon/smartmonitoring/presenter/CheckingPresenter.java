package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.FixResponse;
import com.hackathon.smartmonitoring.view.ChekingView;

import rx.Subscriber;

public class CheckingPresenter {
    public ChekingView view;
    public DataBaseModel model = new DataBaseModel();

    public CheckingPresenter(ChekingView view) {
        this.view = view;
    }

    public void checkMemory(String id){
        model.checkMemory(id).subscribe(new Subscriber<FixResponse>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(FixResponse fixResponse) {
                view.checkMemory(fixResponse.getNane());
            }
        });
    }

    public void checkStates(String id){
        model.checkStates(id).subscribe(new Subscriber<FixResponse>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(FixResponse fixResponse) {
                view.checkStates(fixResponse.getNane());
            }
        });
    }

    public void checkChachingratio(String id){
        model.checkChachingratio(id).subscribe(new Subscriber<FixResponse>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(FixResponse fixResponse) {
                view.checkChachingratio(fixResponse.getNane());
            }
        });
    }

    public void checkChachingratioIndex(String id){
        model.checkChachingratioIndex(id).subscribe(new Subscriber<FixResponse>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(FixResponse fixResponse) {
                view.checkChachingratioIndex(fixResponse.getNane());
            }
        });
    }
}
