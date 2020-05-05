package com.bl.exception;
public class StateCensusAnalyserException extends RuntimeException
{
        public enum  exceptionType
        {
            FILE_NOT_FOUND ,INCORRECT_FILE,NO_CENSUS_DATA;
        }
        public exceptionType exceptionTypeObject;
        public StateCensusAnalyserException(exceptionType exceptionTypeObject)
        {
            this.exceptionTypeObject=exceptionTypeObject;
        }
    }