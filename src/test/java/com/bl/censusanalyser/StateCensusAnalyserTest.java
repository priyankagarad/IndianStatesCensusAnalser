package com.bl.censusanalyser;
import com.bl.exception.StateCensusAnalyserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
public class StateCensusAnalyserTest
{
    private static String DATA_CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";
    StateCensusAnalyser stateCensusAnalyser;
        @Before
        public void setUp()
        {
            stateCensusAnalyser = new StateCensusAnalyser(DATA_CSV_FILE_PATH);
        }

        /* TC 1.1 : Given the States Census CSV file, Check to ensure the Number of Record matches */
        @Test
        public void givenTheStatesCensusCSVFile_whenNumberOfRecordMatch_shouldReturnTrue() throws IOException,StateCensusAnalyserException
        {
            int totalRecords=stateCensusAnalyser.loadData();
            Assert.assertEquals(29,totalRecords);
        }

    /* TC 1.2 : Given the State Census CSV File if incorrect Returns a custom Exception */
    @Test
    public void givenFileName_whenImproper_shouldThrowException() throws IOException
    {
        try
        {
            stateCensusAnalyser.loadData();
        } catch (StateCensusAnalyserException e)
        {
            Assert.assertEquals(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND,e.exceptionTypeObject);
        }
    }
}

