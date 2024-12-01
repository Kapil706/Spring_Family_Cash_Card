package com.example.cashcardapp;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;


public record CashCard (@Id Long id, Double amount){

//    @JsonCreator
//    public CashCard(
//            @JsonProperty("id") Long id,
//            @JsonProperty("amount") Double amount)
//           {
//        this.id = id;
//        this.amount = amount;
//        }



}
