package com.mehatab.springboot.Exception;


public class ResourceNotFoundException  extends RuntimeException
{
	

	public ResourceNotFoundException(String me) 
	 {
	        super(me);
	  }

}
