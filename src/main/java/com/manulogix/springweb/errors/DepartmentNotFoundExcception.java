package com.manulogix.springweb.errors;

public class DepartmentNotFoundExcception extends Exception {

	public DepartmentNotFoundExcception() {
        super();
    }

    
    public DepartmentNotFoundExcception(String message) {
        super(message);
    }
    
    public DepartmentNotFoundExcception(String message, Throwable cause) {
        super(message, cause);
    }
    
    public DepartmentNotFoundExcception(Throwable cause) {
        super(cause);
    }
    
    protected DepartmentNotFoundExcception(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) 
    {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
    
}
