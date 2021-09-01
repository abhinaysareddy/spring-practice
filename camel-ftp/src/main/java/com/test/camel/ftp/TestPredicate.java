package com.test.camel.ftp;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;


public class TestPredicate implements Predicate {
    @Override
    public boolean matches(Exchange ex) {
        ex.getIn().getBody();
        System.out.println();
        return false;
    }
}
