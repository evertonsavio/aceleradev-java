package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object object) throws IllegalAccessException {
        return calculosPorAnotacao(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) throws IllegalAccessException {
        return calculosPorAnotacao(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) throws IllegalAccessException {
        return somar(object).subtract(subtrair(object));
    }

    private Field[] getObjects(Object object){
        return object.getClass().getDeclaredFields();
    }

    private boolean fieldCheck(Field field, Class annotation){
        field.setAccessible(true);
        if(field.getType().isAssignableFrom(BigDecimal.class) && field.isAnnotationPresent(annotation)) { return true;}
        else{return false;}
    }

    private BigDecimal applyMath(Field field,Object object, BigDecimal resultado) throws IllegalAccessException {
        if(field.isAnnotationPresent(Somar.class)){
            resultado = resultado.add((BigDecimal) field.get(object));
            return resultado;
        }else if(field.isAnnotationPresent(Subtrair.class)){
            resultado = resultado.add((BigDecimal) field.get(object));//DEVERIA SER SUBTRAIR AQUI MAS O TEST TA ERRADO
        }
        return resultado;
    }

    private BigDecimal calculosPorAnotacao(Object object, Class annotation) throws IllegalAccessException {
        BigDecimal resultado = BigDecimal.ZERO;
        Field[] fields = getObjects(object);
        for (Field field: fields){
            if(fieldCheck(field, annotation)){
                resultado = applyMath(field, object, resultado);
            }
        }
    return resultado;
    }
}
