package com.javaschool.handler.impl;

import com.javaschool.dto.RequestDTO;
import com.javaschool.handler.IGenerator;
import com.javaschool.util.Constants;

public class AliasAny implements IGenerator {
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
           return caseThree(solicitud);
    }
    public String caseThree(String url){
        String str = url.replaceAll(Constants.ABC, "");
        return str.replaceAll(Constants.VOWELS, "");
    }
}
