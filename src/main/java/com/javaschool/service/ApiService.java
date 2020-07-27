package com.javaschool.service;


import com.javaschool.entity.Alias;
import com.javaschool.handler.impl.AliasGenerators;
import com.javaschool.repository.AliasRepository;
import com.javaschool.util.AliasGeneratorUtil;
import com.javaschool.util.URLValidator;
import javassist.tools.web.BadHttpRequest;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@Data
public class ApiService {


    private AliasRepository aliasRepository;
    private AliasGeneratorUtil aliasGeneratorUtil;

    public ApiService(AliasRepository aliasRepository,
                      AliasGeneratorUtil aliasGeneratorUtil){
        this.aliasRepository = aliasRepository;
        this.aliasGeneratorUtil = aliasGeneratorUtil;
    }

    public String createAlias(String url) throws BadHttpRequest {

        URLValidator urlValidator = new URLValidator();
        if(!urlValidator.isUrlValid(url)){
            throw  new BadHttpRequest();
        }


        Alias nAlias = new Alias();
        nAlias.setUrl(url);
        Optional<Alias> optionalAlias = aliasRepository.findByUrl(url);
        if(optionalAlias.isPresent()){
            return optionalAlias.get().getAlias();
        }
         /*  Usin AliasGeneratorUtil - All in one File
            nAlias.setAlias(url);
            nAlias.setAlias(aliasGeneratorUtil.generate(url));
         */

        /* With AliasGenerators - ChainOfResponsability Pattern*/
        AliasGenerators aliasGenerators = new AliasGenerators();
        nAlias.setAlias(aliasGenerators.generate(url));

        Alias a = aliasRepository.save(nAlias);
        return a.getAlias();
    }

    public String getFromAlias(String alias) throws BadHttpRequest {
        Optional<Alias> optionalAlias = aliasRepository.findByAlias(alias);
        if(!optionalAlias.isPresent()){
            throw  new BadHttpRequest();
        }
        return optionalAlias.get().getUrl();
    }

}
