package org.example.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Order with given id doesn't exist")
public class OrderNotFoundException extends RuntimeException {
}
