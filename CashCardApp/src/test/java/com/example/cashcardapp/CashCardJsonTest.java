package com.example.cashcardapp;




import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    void cashCardSeriliaziationTest() throws IOException{
        CashCard cashCard = new CashCard(99L, 123.45);

        //assertThat(json.write(cashCard)).isStrictlyEqualToJson("resources/expected.json");

        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");

        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.id").isEqualTo(99);

        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");

        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);


    }

}

