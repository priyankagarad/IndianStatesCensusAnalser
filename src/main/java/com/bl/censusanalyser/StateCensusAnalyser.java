package com.bl.censusanalyser;
import com.bl.exception.StateCensusAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import static java.nio.file.Files.newBufferedReader;
public class StateCensusAnalyser<T>
{
    public int loadIndianData(String csvFilePath,Object T)
    {
        int totalRecords = 0;
        try (Reader reader = newBufferedReader(Paths.get(csvFilePath));)
        {
            Iterator<T> csvStateCensusIterator = (Iterator<T>) new CSVBuilder().getFileIterator(reader,T.getClass());
            while (csvStateCensusIterator.hasNext())
            {
                csvStateCensusIterator.next();
                totalRecords++;
            }
        }
        catch (IOException e)
        {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND);
        }
        catch (RuntimeException e)
        {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.INCORRECT_FILE);
        }
        return totalRecords;
    }
    //OPen Csv Method
    private <E> int getCount(Iterator<E> iterator)
    {
        Iterable<E> iterable=() -> iterator;
        int totalRecords=(int) StreamSupport.stream(iterable.spliterator(),false).count();
        return totalRecords;
    }
    }
