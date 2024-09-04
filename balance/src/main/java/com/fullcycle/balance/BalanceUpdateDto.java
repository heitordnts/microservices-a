package com.fullcycle.balance;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceUpdateDto {
    @JsonProperty
    String Name;
    @JsonProperty
    Payload Payload;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Payload getPayload() {
        return Payload;
    }

    public void setPayload(Payload payload) {
        Payload = payload;
    }

    @Override
    public String toString() {
        return "BalanceUpdateDto [Name=" + Name + ", Payload=" + Payload + "]";
    }
    

    

}
