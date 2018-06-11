package io.piano.response;

import io.piano.model.StackExchange;

import java.util.List;

/**
 * Response from Stackexchange
 */
public class StackResponse {

    private List<StackExchange> items;

    public List<StackExchange> getItems() {
        return items;
    }

    public void setItems(List<StackExchange> items) {
        this.items = items;
    }


}
