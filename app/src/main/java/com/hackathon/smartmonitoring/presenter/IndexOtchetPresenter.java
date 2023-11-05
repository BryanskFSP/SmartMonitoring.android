package com.hackathon.smartmonitoring.presenter;

import com.hackathon.smartmonitoring.model.DataBaseModel;
import com.hackathon.smartmonitoring.network.response.DataIndex;
import com.hackathon.smartmonitoring.network.response.DataIndexOld;
import com.hackathon.smartmonitoring.network.response.OtchetIndexOldResponse;
import com.hackathon.smartmonitoring.network.response.OtchetIndexResponse;
import com.hackathon.smartmonitoring.view.IndexOtchetView;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class IndexOtchetPresenter {

    private IndexOtchetView view;
    public DataBaseModel model  = new DataBaseModel();

    public IndexOtchetPresenter(IndexOtchetView view) {
        this.view = view;
    }

    public void getSimpleIndexes(String id){
        model.getIndexOtchet(id).subscribe(new Subscriber<OtchetIndexResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(OtchetIndexResponse otchetIndexResponse) {
                List<DataIndex> dataIndexList = new ArrayList<>();
                if(otchetIndexResponse.getDataIndex()!=null){
                    for(int  i = 0 ; i < otchetIndexResponse.getDataIndex().size(); i++){
                        dataIndexList.add(otchetIndexResponse.getDataIndex().get(i));
                    }
                }
                view.getIndexSimple(dataIndexList);
            }
        });

    }

    public void getOldIndexes(String id){
        model.getIndexOldOtchet(id).subscribe(new Subscriber<OtchetIndexOldResponse>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.errorMessage(e.getLocalizedMessage());
            }

            @Override
            public void onNext(OtchetIndexOldResponse otchetIndexOldResponse) {
                List<DataIndexOld> dataIndexList = new ArrayList<>();
                if(otchetIndexOldResponse.getDataIndexOld()!=null){
                    for(int  i = 0 ; i < otchetIndexOldResponse.getDataIndexOld().size(); i++){
                        dataIndexList.add(otchetIndexOldResponse.getDataIndexOld().get(i));
                    }
                }
                view.getIndexOld(dataIndexList);
            }
        });
    }
}
