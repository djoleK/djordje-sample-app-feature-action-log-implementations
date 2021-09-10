package com.phoenixnap.bmc.events;

import com.phoenixnap.bmc.pojos.Action;
import com.phoenixnap.bmc.pojos.CustomerEntity;
import com.phoenixnap.bmc.pojos.UserEntity;

import java.util.Date;

public class ActionEvent {

    private Long timestamp;
    private CustomerEntity customerEntity;
    private UserEntity loggedInUserEntity;
    private Action action;

    public ActionEvent() {
    }

    public ActionEvent(CustomerEntity customerEntity, UserEntity loggedInUserEntity, Action action) {
        this.timestamp = new Date().getTime();
        this.customerEntity = customerEntity;
        this.loggedInUserEntity = loggedInUserEntity;
        this.action = action;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public UserEntity getLoggedInUser() {
        return loggedInUserEntity;
    }

    public void setLoggedInUser(UserEntity loggedInUserEntity) {
        this.loggedInUserEntity = loggedInUserEntity;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEvent that = (ActionEvent) o;

        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        if (customerEntity != null ? !customerEntity.equals(that.customerEntity) : that.customerEntity != null)
            return false;
        if (loggedInUserEntity != null ? !loggedInUserEntity.equals(that.loggedInUserEntity) : that.loggedInUserEntity != null) return false;
        return action == that.action;
    }

    @Override
    public int hashCode() {
        int result = timestamp != null ? timestamp.hashCode() : 0;
        result = 31 * result + (customerEntity != null ? customerEntity.hashCode() : 0);
        result = 31 * result + (loggedInUserEntity != null ? loggedInUserEntity.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ActionEvent{" +
                "timestamp=" + timestamp +
                ", customerEntity=" + customerEntity +
                ", loggedInUser=" + loggedInUserEntity +
                ", action=" + action +
                '}';
    }
}
