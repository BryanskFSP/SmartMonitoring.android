package com.hackathon.smartmonitoring.network.response;

import com.google.gson.annotations.SerializedName;

import kotlin.jvm.internal.SerializedIr;

public class LogsResponse {
    @SerializedName("id")
    String id;
    @SerializedName("description")
    String description;
    @SerializedName("organizationID")
    String organizationID;
    @SerializedName("dataBaseID")
    String dataBaseID;
    @SerializedName("action")
    String action;
    @SerializedName("logType")
    String logType;
    @SerializedName("entity")
    String entity;
    @SerializedName("createdAt")
    String entityID;
    @SerializedName("fixStatus")
    boolean fixStatus;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
        this.entityID = entityID;
    }

    public boolean isFixStatus() {
        return fixStatus;
    }

    public void setFixStatus(boolean fixStatus) {
        this.fixStatus = fixStatus;
    }

    public LogsResponse(String id, String description, String organizationID, String dataBaseID, String action, String logType, String entity, String entityID, boolean fixStatus) {
        this.id = id;
        this.description = description;
        this.organizationID = organizationID;
        this.dataBaseID = dataBaseID;
        this.action = action;
        this.logType = logType;
        this.entity = entity;
        this.entityID = entityID;
        this.fixStatus = fixStatus;
    }
}