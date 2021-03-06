package com.example.TSNotes.TSNotes.exceptions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ServiceException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public JsonNode formattedResponse() {
        ObjectNode jsonNode = JsonNodeFactory.instance.objectNode();
        jsonNode.put("status", status.toString());
        jsonNode.put("message", message);
        return jsonNode;
    }

}