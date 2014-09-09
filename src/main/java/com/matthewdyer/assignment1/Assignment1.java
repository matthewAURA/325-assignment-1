package com.matthewdyer.assignment1;


import org.springframework.context.support.GenericXmlApplicationContext;
import com.matthewdyer.assignment1.domain.Media;
import com.matthewdyer.assignment1.persistance.MediaDAO;


public class Assignment1 {
	/*
	public static void main (String[] args){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:app-context.xml");
		ctx.refresh();
		
		MediaDAO mediaDAO = ctx.getBean("mediaDAO",MediaDAO.class);
		if (mediaDAO == null){
			System.out.println("Null");
		}else{
			System.out.println(mediaDAO.findAll().size());
		}
	}*/
}
