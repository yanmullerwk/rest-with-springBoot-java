package com.yan.restcomspringbootejava;

import com.yan.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.yan.utils.NumberUtils.convertToDouble;
import static com.yan.utils.NumberUtils.isNumeric;

@RestController
public class AdvancedMathController{
    @RequestMapping(value = "/sqr/{number}", method = RequestMethod.GET)
    public double sqrt(@PathVariable(value = "number") String number) throws Exception {
        if (!isNumeric(number)){
            new UnsupportedMathOperationException("Please set a numeric value");
        }

        return Math.sqrt(convertToDouble(number));
    }

    @RequestMapping(value = "/av/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public double averege(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            new UnsupportedMathOperationException("Please set a numeric value");
        }

        return (convertToDouble(numberOne)+convertToDouble(numberTwo))/2D;
    }


}
