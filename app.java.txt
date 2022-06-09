package com.zensar.spring_core_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.beans.Address;
import com.zensar.beans.Employee;
import com.zensar.beans.Product;
import com.zensar.beans.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("contex.xml");


    	Employee employee=context.getBean("employee",Employee.class );
    	
    	System.out.println(employee);