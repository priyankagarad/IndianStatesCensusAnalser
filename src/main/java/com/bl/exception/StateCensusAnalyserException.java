package com.bl.exception;
public class StateCensusAnalyserException extends Exception
{
    public enum exceptionType
    {
        FILE_NOT_FOUND ,WRONG_DELIMITER,WRONG_FILE_FORMATE
    }
    public exceptionType exceptionTypeObject;
    public StateCensusAnalyserException(exceptionType exceptionTypeObject)
    {
        this.exceptionTypeObject=exceptionTypeObject;
    }
}