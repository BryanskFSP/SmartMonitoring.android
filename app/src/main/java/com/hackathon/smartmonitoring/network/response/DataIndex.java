package com.hackathon.smartmonitoring.network.response;

import com.google.gson.annotations.SerializedName;

public class DataIndex {
    @SerializedName("relName") String relName;
    @SerializedName("seqScan") int seqScan;
    @SerializedName("idxScan") int idxScan;
    @SerializedName("indexStat") int indexStat;

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public int getSeqScan() {
        return seqScan;
    }

    public void setSeqScan(int seqScan) {
        this.seqScan = seqScan;
    }

    public int getIdxScan() {
        return idxScan;
    }

    public void setIdxScan(int idxScan) {
        this.idxScan = idxScan;
    }

    public int getIndexStat() {
        return indexStat;
    }

    public void setIndexStat(int indexStat) {
        this.indexStat = indexStat;
    }

    public DataIndex(String relName, int seqScan, int idxScan, int indexStat) {
        this.relName = relName;
        this.seqScan = seqScan;
        this.idxScan = idxScan;
        this.indexStat = indexStat;
    }
}
