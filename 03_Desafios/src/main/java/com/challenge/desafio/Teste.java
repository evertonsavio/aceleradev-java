package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Teste{
    @Somar
    BigDecimal v1 = BigDecimal.valueOf(0.1);
    @Somar
    BigDecimal v2 = BigDecimal.valueOf(0.3);
    @Subtrair
    BigDecimal v3 = BigDecimal.valueOf(0.1);


}
