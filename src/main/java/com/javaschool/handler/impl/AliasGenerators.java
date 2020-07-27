package com.javaschool.handler.impl;


import com.javaschool.handler.IGenerator;
import org.springframework.stereotype.Component;

@Component
public class AliasGenerators implements IGenerator {
    private IGenerator next;
    @Override
    public void setGenerator(IGenerator generator) {
        this.next = generator;
    }

    @Override
    public IGenerator getGenerator() {
        return next;
    }

    @Override
    public String generate(String solicitud) {
        AliasGoogle aliasGoogle = new AliasGoogle();
        this.setGenerator(aliasGoogle);
        AliasYahoo aliasYahoo = new AliasYahoo();
        aliasGoogle.setGenerator(aliasYahoo);
        AliasAny aliasAny = new AliasAny();
        aliasYahoo.setGenerator(aliasAny);

       return next.generate(solicitud);
    }
}
