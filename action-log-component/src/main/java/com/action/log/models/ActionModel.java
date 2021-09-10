package com.action.log.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Objects;

@Document
public class ActionModel {

    @Id
    private String id;
    private Long timeStamp;
    private String customerId;
    private String loggedInUserId;
    private ActionEnum action;

    public ActionModel() {
    }

    public ActionModel(String id, String customerId, String loggedInUserId, ActionEnum action) {
        this.id = id;
        this.timeStamp = new Date().getTime();
        this.customerId = customerId;
        this.loggedInUserId = loggedInUserId;
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getLoggedInUserId() {
        return loggedInUserId;
    }

    public void setLoggedInUserId(String loggedInUserId) {
        this.loggedInUserId = loggedInUserId;
    }

    public ActionEnum getAction() {
        return action;
    }

    public ActionModel setAction(ActionEnum action) {
        this.action = action;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ActionModel that = (ActionModel) o;
        return Objects.equals(id, that.id) && Objects.equals(timeStamp, that.timeStamp) && Objects.equals(customerId, that.customerId) && Objects.equals(
                loggedInUserId, that.loggedInUserId) && action == that.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeStamp, customerId, loggedInUserId, action);
    }

    @Override
    public String toString() {
        return "ActionModel{" +
                "id='" + id + '\'' +
                ", timeStamp=" + timeStamp +
                ", customerId='" + customerId + '\'' +
                ", loggedInUserId='" + loggedInUserId + '\'' +
                ", action=" + action +
                '}';
    }
}
