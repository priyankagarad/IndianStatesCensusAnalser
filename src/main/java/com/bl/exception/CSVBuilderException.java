package com.bl.exception;
    public class CSVBuilderException extends Throwable
    {
        public StateCensusAnalyserException.exceptionType type;

        public CSVBuilderException(String message,StateCensusAnalyserException.exceptionType type)
        {
            super(message);
            this.type=type;
        }
    }

