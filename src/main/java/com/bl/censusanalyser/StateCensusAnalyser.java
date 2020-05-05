package com.bl.censusanalyser;
import com.bl.exception.CSVBuilderException;
import com.bl.exception.StateCensusAnalyserException;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class StateCensusAnalyser<T> {
    List<T> csvFileList = null;
    Map<String, T> csvStateCodeMap = new HashMap<>();

    /* Read State Census Data CSV file */
    public int loadIndianData(String csvFilePath, Class<T> csvClass) throws CSVBuilderException, IOException {
        try
        {
            BufferedReader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            ICSVBuilder icsvBuilder=CSVBuilderFactory.icsBuilder();
                Iterator<T> csvStateCensusIterator = icsvBuilder.getFileIterator(reader, csvClass);
                Iterable<T> csvFileIterable =()-> csvStateCensusIterator;
                while (csvStateCensusIterator.hasNext()) {
                    CSVStateCensusDAO value =new CSVStateCensusDAO((CSVStateCensus) csvStateCensusIterator.next());
                    this.csvStateCodeMap.put(value.getState(), (T) value);
                    csvFileList = csvStateCodeMap.values().stream().collect(Collectors.toList());
                }
                int totalRecords = csvStateCodeMap.size();
                return totalRecords;

            }  catch (IOException e)
            {
                throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND);
            } catch (RuntimeException e)
            {
                throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.INCORRECT_FILE);
            }
        }

    /* Sort The Data From Csv File */
    public String getSortData(Object T) throws StateCensusAnalyserException {
        if (csvFileList.size() == 0 | csvFileList == null) {
            throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.NO_CENSUS_DATA);
        }
        Comparator<T> stateCensusAnalyserComparator = Comparator.comparing(csvCounter -> T.toString());
        this.sort(csvFileList,stateCensusAnalyserComparator);
        String sortedData =new Gson().toJson(csvFileList);
        return  sortedData;
    }

    public void sort(List<T> csvFileList, Comparator<T> censusComparator) {
        for (int i = 0; i < this.csvFileList.size(); i++) {
            for (int j = 0; j < this.csvFileList.size() - i - 1; j++) {
                T census1 = this.csvFileList.get(j);
                T census2 = this.csvFileList.get(j + 1);
                if (censusComparator.compare(census1, census2) > 0) {
                    this.csvFileList.set(j, census2);
                    this.csvFileList.set(j + 1, census1);
                }
            }
        }
    }
}
