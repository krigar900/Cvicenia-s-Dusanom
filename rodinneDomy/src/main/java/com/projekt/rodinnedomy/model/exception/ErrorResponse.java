package com.projekt.rodinnedomy.model.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Message that Moowio Java servers send to the client in Response body.
 * Note: Client is either ReactClient or other Java server (via WebClient synchro implementation)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private int code;           // Message Code the client uses for translation
    private Date timestamp;     // Message timestamp, generated on server for easier finding in log trace
    private String requestId;   // Server generates UUID for every incoming request. We sent it back to the client.
    private String message;     // Message text, theoretically obsolete for the client as Code refers to translated text
    private String description; // Detail message the client can show in detail part.
    private String type = "E";        // E,W
    private Object object;      // can be any object e.g. Client with the requested email but in different tenant

    public ErrorResponse() {
    }

    public ErrorResponse(String requestId) {
        this.requestId = requestId;
    }

    public ErrorResponse(int code, String requestId, String message) {
        this(code, new Date(), requestId, message);
    }

    public ErrorResponse(int code, String requestId, String message, String description) {
        this(code, new Date(), requestId, message);
        this.description = description;
    }

    public ErrorResponse(int code, Date timestamp, String requestId, String message) {
        this.code = code;
        this.timestamp = timestamp;
        this.requestId = requestId;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResponseErrorMessage{" +
                "code=" + code +
                ", timestamp=" + timestamp +
                ", requestId='" + requestId +
                ", message='" + message +
                ", description='" + description +
                ", type='" + type +
                ", object=" + object +
                '}';
    }
}
