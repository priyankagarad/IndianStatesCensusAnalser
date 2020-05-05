package com.bl.censusanalyser;
import com.bl.exception.CSVBuilderException;
import com.bl.exception.StateCensusAnalyserException;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.nio.file.Files.newBufferedReader;
public class StateCensusAnalyser<T>
{
    List<T> csvFileList=null;
    public int loadIndianData(String csvFilePath,Object T) throws CSVBuilderException
    {
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder icsvBuilder = CSVBuilderFactory.icsBuilder();
            csvFileList= (List<T>) icsvBuilder.getFileList(reader,T.getClass());
            return csvFileList.size();
        }
        catch (IOException e)
        {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND);
        }
        catch (RuntimeException e)
        {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.INCORRECT_FILE);
        }
    }
    //OPen Csv Method
    public  <E> int getCount(Iterator<E> iterator)
    {
        Iterable<E> iterable=() -> iterator;
        int totalRecords=(int) StreamSupport.stream(iterable.spliterator(),false).count();
        return totalRecords;
    }


    public String getSortData(Object T) throws StateCensusAnalyserException
    {
        if (csvFileList.size() == 0 | csvFileList == null)
        {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.NO_CENSUS_DATA);
        }
        Comparator<T>stateCensusAnalyserComparator = Comparator.comparing(CSVStateCensus->CSVStateCensus.toString());
        this.sort(stateCensusAnalyserComparator);
        String stateCensusSortedJson = new Gson().toJson(csvFileList);
        return stateCensusSortedJson;
    }

    public void sort(Comparator<T> censusComparator)
    {
        for (int i = 0; i < csvFileList.size(); i++)
        {
            for (int j = 0; j < csvFileList.size() - i - 1; j++)
            {
                T census1 = csvFileList.get(j);
                T census2 = csvFileList.get(j + 1);
                if (censusComparator.compare(census1, census2) > 0)
                {
                    csvFileList.set(j, census2);
                    csvFileList.set(j + 1, census1);
                }
            }
        }
    }
}


