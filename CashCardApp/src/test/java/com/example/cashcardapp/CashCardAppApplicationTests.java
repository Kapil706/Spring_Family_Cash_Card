package com.example.cashcardapp;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CashCardAppApplicationTests {

   @Autowired
   private TestRestTemplate restTemplate;

   @Test
    void shouldReturnACardCashWhenDataSaved(){

       ResponseEntity<String> response  = restTemplate.getForEntity("/cashcards/100", String.class);

       assertEquals(response.getStatusCode() , HttpStatus.OK);

       DocumentContext documentContext = JsonPath.parse(response.getBody());

       Number id = documentContext.read("$.id");

       assertThat(id).isNotNull();
       assertThat(id).isEqualTo(100);

       Double amount = documentContext.read("$.amount");

       assertThat(amount).isNotNull();
       assertThat(amount).isEqualTo(123.45);


   }

   @Test
    void shouldNotReturnACardCashWithUnknownId(){

      ResponseEntity<String> response =restTemplate.getForEntity("/cashcards/1000",String.class);

      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

      assertThat(response.getBody()).isBlank();

   }


}
