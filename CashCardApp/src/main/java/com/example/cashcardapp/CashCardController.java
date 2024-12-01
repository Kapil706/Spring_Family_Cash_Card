package com.example.cashcardapp;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {


    private final CashCardRepository cashCardRepository;

    public CashCardController(CashCardRepository cashCardRepository) {
        this.cashCardRepository = cashCardRepository;
    }



/*
    @GetMapping("/{requestId}")
    private ResponseEntity<String> findById(){



        return ResponseEntity.ok("{}");
    }
*/
    @GetMapping("/{requestId}")
    private ResponseEntity<CashCard> findById(@PathVariable Long requestId){

       Optional<CashCard> cashCardOptional = cashCardRepository.findById(requestId);

       if(cashCardOptional.isPresent()){
           return ResponseEntity.ok(cashCardOptional.get());
       }
       else
           return ResponseEntity.notFound().build();


/*

        if(requestId.equals(99L)){
            CashCard cashCard = new CashCard(99L,123.45);
            return ResponseEntity.ok(cashCard);
        }
        else{
            return ResponseEntity.notFound().build();
        }

*/
    }



}
