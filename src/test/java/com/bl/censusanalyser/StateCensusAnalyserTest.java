package com.bl.censusanalyser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
public class StateCensusAnalyserTest
{
        StateCensusAnalyser stateCensusAnalyser;
        @Before
        public void setUp()
        {
            stateCensusAnalyser = new StateCensusAnalyser();
        }

        /* TC 1.1 : Given the States Census CSV file, Check to ensure the Number of Record matches */
        @Test
        public void givenTheStatesCensusCSVFile_whenNumberOfRecordMatch_shouldReturnTrue() throws IOException
        {
            int totalRecords=stateCensusAnalyser.loadData();
            Assert.assertEquals(29,totalRecords);
        }
    }

