package com.savsh.web;

import com.savsh.dto.MessageDTO;
import com.savsh.dto.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class ValidationHandlerController {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public List<MessageDTO> processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> error = result.getFieldErrors();
        return processFieldError(error);
    }

    private List<MessageDTO> processFieldError(List<FieldError> errors) {
        List<MessageDTO> messages = new ArrayList<>();
        if (errors != null) {
            Locale currentLocale = LocaleContextHolder.getLocale();
            errors.forEach(
                    error -> {
                        String msg = messageSource.getMessage(error.getDefaultMessage(), null, currentLocale);
                        messages.add(new MessageDTO(MessageType.ERROR, msg));
                    });
        }
        return messages;
    }
}
