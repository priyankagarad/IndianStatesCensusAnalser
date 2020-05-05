package com.bl.censusanalyser;
import com.bl.exception.CSVBuilderException;
import com.bl.exception.StateCensusAnalyserException;
import java.io.Reader;
import java.util.Iterator;
public interface ICSVBuilder {
    public  <E> Iterator<E> getFileIterator(Reader reader, Class<E> csvClass) throws StateCensusAnalyserException, CSVBuilderException;

}
