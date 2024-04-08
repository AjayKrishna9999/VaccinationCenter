package com.example.vaccination.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ParamsValueValidator implements ConstraintValidator<ParamValuesAllowed, String> {

    private List<String> expectedValues;
    private String returnMessage;

    @Override
    public void initialize(ParamValuesAllowed paramValuesAllowed) {
        expectedValues= Arrays.asList(paramValuesAllowed.values());
        returnMessage=paramValuesAllowed.message().concat(expectedValues.toString());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid=expectedValues.contains(value);
        if(!valid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(returnMessage).addConstraintViolation();
        }
        return false;
    }
}
