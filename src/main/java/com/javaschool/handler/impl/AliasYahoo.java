package com.javaschool.handler.impl;

import com.javaschool.handler.IGenerator;
import com.javaschool.util.Constants;

import java.util.Random;

public class AliasYahoo implements IGenerator {
    private IGenerator next;

    @Override
    public void setGenerator(IGenerator conductor) {
        this.next = conductor;
    }

    @Override
    public IGenerator getGenerator() {
        return next;
    }

    @Override
    public String generate(String solicitud) {
        if (solicitud.indexOf(Constants.GOOGLE) != -1
                || solicitud.indexOf(Constants.GOOGLE.toUpperCase()) != -1) {
            return caseTwo();
        } else {
            return next.generate(solicitud);
        }
    }
    private String caseTwo(){
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i< Constants.CASE_TWO_LEGTH ; i++) {
            result.append(
                    Constants.alphaNumericCharacters.
                            charAt(rand.nextInt(Constants.alphaNumericCharacters.length())));
        }
        return result.toString();
    }
}
