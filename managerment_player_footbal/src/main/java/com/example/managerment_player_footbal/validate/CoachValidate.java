package com.example.managerment_player_footbal.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CoachValidate implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
