package com.hackathon.smartmonitoring.network.response;

import com.google.gson.annotations.SerializedName;

public class DataIndexOld {
    @SerializedName("indexrelname") String indexrelname;
    @SerializedName("relname") String relname;
    @SerializedName("stats") int stats;

    public String getIndexrelname() {
        return indexrelname;
    }

    public void setIndexrelname(String indexrelname) {
        this.indexrelname = indexrelname;
    }

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname;
    }

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public DataIndexOld(String indexrelname, String relname, int stats) {
        this.indexrelname = indexrelname;
        this.relname = relname;
        this.stats = stats;
    }
}
