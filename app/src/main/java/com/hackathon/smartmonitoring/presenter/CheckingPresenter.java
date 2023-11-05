package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.FixResponse;
import com.hackathon.smartmonitoring.network.response.KillLogResponse;
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
                if(fixResponse.getStatus())
                view.checkMemory(fixResponse.getNane());
                else fixProblems(id);
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
                if(fixResponse.getStatus())
                view.checkStates(fixResponse.getNane());
                else fixProblems(id);
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
                if(fixResponse.getStatus())
                view.checkChachingratio(fixResponse.getNane());
                else fixProblems(id);
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
                if(fixResponse.getStatus())
                view.checkChachingratioIndex(fixResponse.getNane());
                else fixProblems(id);
            }
        });
    }

    private void fixProblems(String id){
        model.killLogProccess(id).subscribe(new Subscriber<KillLogResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(KillLogResponse killLogResponse) {
                view.errorMessage("В процессе была обнаружена ошибка\n и была успешно уничтожена");
            }
        });
    }
}
