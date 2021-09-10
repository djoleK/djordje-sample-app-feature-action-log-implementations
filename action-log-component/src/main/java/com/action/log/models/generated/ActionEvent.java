package com.action.log.models.generated;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Action event.
 */
@ApiModel(description = "Action event.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-09-07T09:17:33.543942+02:00[Europe/Belgrade]")
public class ActionEvent   {
  @JsonProperty("customerId")
  private String customerId;

  @JsonProperty("loggedInUserId")
  private String loggedInUserId;

  @JsonProperty("id")
  private String id;

  @JsonProperty("action")
  private String action;

  public ActionEvent customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Unique ID for the customer.
   * @return customerId
  */
  @ApiModelProperty(value = "Unique ID for the customer.")


  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public ActionEvent loggedInUserId(String loggedInUserId) {
    this.loggedInUserId = loggedInUserId;
    return this;
  }

  /**
   * Logged in user ID.
   * @return loggedInUserId
  */
  @ApiModelProperty(value = "Logged in user ID.")


  public String getLoggedInUserId() {
    return loggedInUserId;
  }

  public void setLoggedInUserId(String loggedInUserId) {
    this.loggedInUserId = loggedInUserId;
  }

  public ActionEvent id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique ID for the action event.
   * @return id
  */
  @ApiModelProperty(value = "Unique ID for the action event.")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ActionEvent action(String action) {
    this.action = action;
    return this;
  }

  /**
   * Action performed on the customer.
   * @return action
  */
  @ApiModelProperty(value = "Action performed on the customer.")


  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActionEvent actionEvent = (ActionEvent) o;
    return Objects.equals(this.customerId, actionEvent.customerId) &&
        Objects.equals(this.loggedInUserId, actionEvent.loggedInUserId) &&
        Objects.equals(this.id, actionEvent.id) &&
        Objects.equals(this.action, actionEvent.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, loggedInUserId, id, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionEvent {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    loggedInUserId: ").append(toIndentedString(loggedInUserId)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

