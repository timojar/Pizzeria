package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fi.omapizzeria.admin.bean.*;
import dao.*;
import fi.omapizzeria.admin.bean.Pizza;

public class Yhteys {

	public static void main(String[] args) {
		String y="";
		Date date=new Date();
		SimpleDateFormat Totimestamp=new SimpleDateFormat("yyy.MM.dd hh:mm");
		
		try {
			y=Totimestamp.format(date);
			
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.print(y+" rr");
	}

}
