package com.hackathon.smartmonitoring.network.response;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class NotificationLogResponse{
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("organizationID")
    private String organizationID;

    @SerializedName("organization")
    private OrganizationViewModel organization;

    @SerializedName("dataBaseID")
    private String dataBaseID;

    @SerializedName("dataBase")
    private DataBaseViewModel dataBase;

    @SerializedName("action")
    private String action;

    @SerializedName("logType")
    private String logType;

    @SerializedName("entity")
    private String entity;

    @SerializedName("entityID")
    private String entityID;

    @SerializedName("entityJSON")
    private String entityJSON;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("fixStatus")
    private boolean fixStatus;

    @SerializedName("updatedAt")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganizationID() {
        return organizationID;
    }

    public OrganizationViewModel getOrganization() {
        return organization;
    }

    public String getDataBaseID() {
        return dataBaseID;
    }

    public DataBaseViewModel getDataBase() {
        return dataBase;
    }

    public String getAction() {
        return action;
    }

    public String getLogType() {
        return logType;
    }

    public String getEntity() {
        return entity;
    }

    public String getEntityID() {
        return entityID;
    }

    public String getEntityJSON() {
        return entityJSON;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public boolean isFixStatus() {
        return fixStatus;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public class OrganizationViewModel {
        @SerializedName("id")
        private String id;

        @SerializedName("name")
        private String name;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public class DataBaseViewModel {
        @SerializedName("id")
        private String id;

        @SerializedName("name")
        private String name;

        @SerializedName("database")
        private String database;

        @SerializedName("description")
        private String description;

        @SerializedName("organizationID")
        private String organizationID;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDatabase() {
            return database;
        }

        public String getDescription() {
            return description;
        }

        public String getOrganizationID() {
            return organizationID;
        }
    }
}

