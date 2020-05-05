package com.bl.censusanalyser;
import com.bl.exception.StateCensusAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Iterator;
import static java.nio.file.Files.newBufferedReader;
public class StateCensusAnalyser
{
    private static String DATA_CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";
    public StateCensusAnalyser(String path)
    {
        this.DATA_CSV_FILE_PATH=path;
    }
    public static void main(String[] args) throws IOException, StateCensusAnalyserException
    {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser(DATA_CSV_FILE_PATH);
        stateCensusAnalyser.loadData();
    }
    public int loadData() throws IOException,StateCensusAnalyserException {
        int totalRecords = 0;
            try (Reader reader = newBufferedReader(Paths.get(DATA_CSV_FILE_PATH));) {
                CsvToBean<CSVStateCensus> csvStateCensusBeanObj = new CsvToBeanBuilder(reader)
                        .withType(CSVStateCensus.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                Iterator<CSVStateCensus> csvStateCensusIterator = csvStateCensusBeanObj.iterator();
                while (csvStateCensusIterator.hasNext()) {
                    CSVStateCensus csvStateCensus = csvStateCensusIterator.next();
                    totalRecords++;
                }
            } catch (IOException e) {
                throw new StateCensusAnalyserException(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND);
            }
            return totalRecords;
        }
    }
