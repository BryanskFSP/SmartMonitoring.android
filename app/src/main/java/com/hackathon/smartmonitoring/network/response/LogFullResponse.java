    package com.hackathon.smartmonitoring.network.response;

    import com.google.gson.annotations.SerializedName;

    public class LogFullResponse {
        @SerializedName("id") String id;
        @SerializedName("description") String description;
        @SerializedName("organizationID") String organizationID;
        @SerializedName("organization") Organization organization;
        @SerializedName("dataBaseID") String dataBaseID;
        @SerializedName("dataBase") DataBase dataBase;
        @SerializedName("action") String action;
        @SerializedName("logType") String logType;
        @SerializedName("createdAt") String createdAt;
        @SerializedName("fixStatus") boolean fixStatus;


        public String getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getOrganizationID() {
            return organizationID;
        }

        public Organization getOrganization() {
            return organization;
        }

        public String getDataBaseID() {
            return dataBaseID;
        }

        public DataBase getDataBase() {
            return dataBase;
        }

        public String getAction() {
            return action;
        }

        public String getLogType() {
            return logType;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public LogFullResponse(String id, String description, String organizationID, Organization organization, String dataBaseID, DataBase dataBase, String action, String logType, String createdAt, boolean fixStatus) {
            this.id = id;
            this.description = description;
            this.organizationID = organizationID;
            this.organization = organization;
            this.dataBaseID = dataBaseID;
            this.dataBase = dataBase;
            this.action = action;
            this.logType = logType;
            this.createdAt = createdAt;
            this.fixStatus = fixStatus;
        }

        public boolean isFixStatus() {
            return fixStatus;


        }

        public class Organization {
            @SerializedName("id") String id;
            @SerializedName("name") String name;


            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public Organization(String id, String name) {
                this.id = id;
                this.name = name;
            }
        }

        public class DataBase {

            public DataBase(String id, String name, String database, String description, String organizationID) {
                this.id = id;
                this.name = name;
                this.database = database;
                this.description = description;
                this.organizationID = organizationID;
            }

            @SerializedName("id") String id;
            @SerializedName("name") String name;
            @SerializedName("database") String database;
            @SerializedName("description") String description;
            @SerializedName("organizationID") String organizationID;


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