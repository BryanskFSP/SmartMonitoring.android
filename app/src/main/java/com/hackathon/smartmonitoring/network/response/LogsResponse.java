package com.hackathon.smartmonitoring.network.response;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;

public class LogsResponse {
    @SerializedName("id") String id;
    @SerializedName("name") String name;
    @SerializedName("description") String description;
    @SerializedName("organizationID") String organizationID;
    @SerializedName("dataBaseID") String dataBaseID;
    @SerializedName("action") int action;
    @SerializedName("logType") int logType;
    @SerializedName("entity") int entity;
    @SerializedName("entityID") int entityID;
    @SerializedName("entityJSON") String entityJSON;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(String organizationID) {
        this.organizationID = organizationID;
    }

    public String getDataBaseID() {
        return dataBaseID;
    }

    public void setDataBaseID(String dataBaseID) {
        this.dataBaseID = dataBaseID;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getLogType() {
        return logType;
    }

    public void setLogType(int logType) {
        this.logType = logType;
    }

    public int getEntity() {
        return entity;
    }

    public void setEntity(int entity) {
        this.entity = entity;
    }

    public int getEntityID() {
        return entityID;
    }

    public void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    public LogsResponse(String id, String description, String organizationID, String dataBaseID, int action, int logType, int entity, int entityID) {
        this.id = id;
        this.description = description;
        this.organizationID = organizationID;
        this.dataBaseID = dataBaseID;
        this.action = action;
        this.logType = logType;
        this.entity = entity;
        this.entityID = entityID;
    }
}
