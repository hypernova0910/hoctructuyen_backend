package com.spring.backend.common;

public class ServiceResult {
	private Long id;
    
    private String error;
    
    private String errorType;
    
    private String constraintName;
    
    private boolean hasError = false;
    
    public ServiceResult() {
        // Default constructor
    }
    
    public ServiceResult(String error, String errorType) {
        this.error = error;
        this.errorType = errorType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
        this.hasError = error != null && !"".equals(error);
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public boolean isHasError() {
        return hasError;
    }

    public String getConstraintName() {
        return constraintName;
    }

    public void setConstraintName(String constraintName) {
        this.constraintName = constraintName;
    }
}
