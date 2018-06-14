package io.piano.response;

import io.piano.dto.StackDto;

import java.util.List;

/**
 * Response to client
 */
public class StackResponse {

    private List<StackDto> items;

    public StackResponse(List<StackDto> items) {
        this.items = items;
    }

    public List<StackDto> getItems() {
        return items;
    }

    public void setItems(List<StackDto> items) {
        this.items = items;
    }
}
