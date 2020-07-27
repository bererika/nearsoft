package com.javaschool.handler.impl;

import com.javaschool.dto.RequestDTO;
import com.javaschool.handler.IGenerator;
import com.javaschool.util.Constants;

import java.util.Random;

public class AliasGoogle implements IGenerator {
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
            return caseOne();
        } else {
            return next.generate(solicitud);
        }
    }

    private String caseOne(){
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        for (int i =0; i< Constants.CASE_ONE_LEGTH ; i++) {
            result.append(
                    Constants.alphaCharacters.
                            charAt(rand.nextInt(Constants.alphaCharacters.length())));
        }
        return result.toString();
    }
}
