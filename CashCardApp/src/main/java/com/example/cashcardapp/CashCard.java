package com.example.cashcardapp;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public record CashCard (Long id, Double amount){

//    @JsonCreator
//    public CashCard(
//            @JsonProperty("id") Long id,
//            @JsonProperty("amount") Double amount)
//           {
//        this.id = id;
//        this.amount = amount;
//        }



}
