package com.javaschool.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AliasGeneratorUtil {


    public String generate(String url){
        if(url.indexOf(Constants.GOOGLE) != -1
                || url.indexOf(Constants.GOOGLE.toUpperCase()) != -1){
            return caseOne();
        }else if(url.indexOf(Constants.YAHOO) != -1
        || url.indexOf(Constants.YAHOO.toUpperCase()) != -1){
            return caseTwo();
        }else{
            return caseThree(url);
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

    private String caseTwo(){
        StringBuilder result = new StringBuilder();
        Random rand = new Random();
        for (int i =0; i< Constants.CASE_TWO_LEGTH ; i++) {
            result.append(
                    Constants.alphaNumericCharacters.
                            charAt(rand.nextInt(Constants.alphaNumericCharacters.length())));
        }
        return result.toString();
    }

    public String caseThree(String url){
        String str = url.replaceAll(Constants.ABC, "");
        return str.replaceAll(Constants.VOWELS, "");
    }




}
