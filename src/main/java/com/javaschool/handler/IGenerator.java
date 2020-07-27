package com.javaschool.handler;

import com.javaschool.dto.RequestDTO;

public interface IGenerator {

    public void setGenerator(IGenerator conductor);
    public IGenerator getGenerator();
    public String generate(String solicitud);

}
