package com.cashman.interfaces.Money;

import java.math.BigDecimal;
import java.util.Currency;

public interface Money {

    BigDecimal getValue();

    Currency getCurrency();

}
