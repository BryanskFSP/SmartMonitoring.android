package com.hackathon.smartmonitoring.network.response;

import com.google.gson.annotations.SerializedName;

public class DataBaseResponse {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("host")
    String host;
    @SerializedName("database")
    String database;
    @SerializedName("user")
    String user;
    @SerializedName("password")
    String password;
    @SerializedName("description")
    String description;
    @SerializedName("organizationID")
    String organizationID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public DataBaseResponse(String id, String name, String host, String database, String user, String password, String description, String organizationID) {
        this.id = id;
        this.name = name;
        this.host = host;
        this.database = database;
        this.user = user;
        this.password = password;
        this.description = description;
        this.organizationID = organizationID;
    }
}
