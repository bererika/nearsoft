package com.javaschool.util;

import org.apache.commons.validator.routines.UrlValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLValidator {

    public static boolean isUrlValid(String url) {
//        Pattern p = Pattern.compile(Constants.URL_VALID);
//        Matcher m;
//        m=p.matcher(url);
//
//        return  m.matches();

        if(url.startsWith(Constants.DEFAULT_SCHEME_LOWER)
                ||url.startsWith(Constants.DEFAULT_SCHEME_UPPER)){
            url= "http://"+url;
        }

       UrlValidator urlValidator = new UrlValidator();
       if (urlValidator.isValid(url)) {
         return true;
       } else {
          return false;
      }
    }
}
