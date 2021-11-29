package com.order;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    @Override
    public LocalDateTime unmarshal(String s) throws Exception {
        System.out.println("unmarshal...");// string into date
    	return LocalDateTime.parse(s);  // while adding Order - '2021-11-28T11:30:9:987'
    }
    @Override
    public String marshal(LocalDateTime dateTime) throws Exception {
    	 System.out.println("marshal..."); //date unto string 
    	return dateTime.toString();
    }   
}