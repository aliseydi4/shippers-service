package com.demo.shippers.business.responses;

public class CreatedCustomerResponse {
    private long id;



    public CreatedCustomerResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
