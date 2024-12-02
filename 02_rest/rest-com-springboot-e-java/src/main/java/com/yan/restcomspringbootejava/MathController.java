package com.yan.restcomspringbootejava;

import com.yan.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.yan.utils.NumberUtils.convertToDouble;
import static com.yan.utils.NumberUtils.isNumeric;


@RestController
public class MathController {
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    Double sum(@PathVariable(value = "numberOne") String numberOne,
               @PathVariable(value = "numberTwo") String numberTwo) throws Exception{

        if(!isNumeric(numberOne)||!isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    Double subtracts(@PathVariable(value = "numberOne") String numberOne,
                     @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!isNumeric(numberOne)||!isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    Double multiply(@PathVariable(value = "numberOne") String numberOne,
                    @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!isNumeric(numberOne)||!isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return  convertToDouble(numberOne)*convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    Double divide(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!isNumeric(numberOne)||!isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne)/convertToDouble(numberTwo);
    }


}
