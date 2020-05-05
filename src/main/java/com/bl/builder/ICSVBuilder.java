package com.bl.builder;
import com.bl.exception.CSVBuilderException;
import com.bl.exception.StateCensusAnalyserException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder {
    public  <E> Iterator<E> getFileIterator(Reader reader, Class<E> csvClass) throws StateCensusAnalyserException, CSVBuilderException;
    public  <E> List<E> getFileList(Reader reader, Class<E> csvClass) throws CSVBuilderException;

}
