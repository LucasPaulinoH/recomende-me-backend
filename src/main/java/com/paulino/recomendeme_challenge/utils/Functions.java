package com.paulino.recomendeme_challenge.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Functions {
    public static ResponseEntity<Object> returnNotFoundResponseEntity(String entityName) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entityName + " not found");
    }

    public static ResponseEntity<Object> returnOkResponseEntity(Object bodyObject) {
        return ResponseEntity.status(HttpStatus.OK).body(bodyObject);
    }
}
