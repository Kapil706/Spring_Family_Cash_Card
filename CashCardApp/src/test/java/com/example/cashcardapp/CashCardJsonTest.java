package com.example.cashcardapp;




import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


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

/*
    @Test
    void cashCardDeserializationTest() throws IOException{



//        String expected = """
//                "id" : 99,
//                "amount" : 123.45
//                """;
//
//        assertThat(json.parse(expected))
//                .isEqualTo(new CashCard(99L, 123.45));
//        assertThat(json.parseObject(expected).id()).isEqualTo(99);
//        assertThat(json.parseObject(expected).amount()).isEqualTo(123.45);


        ObjectMapper mapper = new ObjectMapper();

        // Register Java 16+ module for records
        mapper.findAndRegisterModules();

        String expected2 = """
                "id" : 99,
                "amount" : 123.45
                """;

//        String jsonn = "{\"id\":99,\"amount\":123.45}";
        CashCard cashCard = mapper.readValue(expected2, CashCard.class);
//
        assertEquals(99L, cashCard.id());
        assertEquals(123.45, cashCard.amount());
        
        /* not resloving issue --

        com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot construct instance of `com.example.cashcardapp.CashCard` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('id')
 at [Source: REDACTED (`StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION` disabled); line: 1, column: 1]
         */

//}

}

