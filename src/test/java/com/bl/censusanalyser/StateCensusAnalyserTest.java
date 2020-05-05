package com.bl.censusanalyser;
import com.bl.exception.StateCensusAnalyserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
public class StateCensusAnalyserTest
{
    private static String DATA_CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";
    private static String IMPROPER_FILE_NAME = "./src/test/resources/StateCensusData1.csv";
    private static String IMPROPER_FILE_TYPE = "./src/test/resources/StateCensusData.txt";
    private static String WRONG_DELIMITER1 = "./src/test/resources/DelimiterIncorrect.csv";
    private static String WRONG_FILE_FORMATE = "./src/test/resources/DelimiterIncorrect.csv";
    public static String STATE_CODE_FILE = "./src/test/resources/StateCode.csv";
    private static String WRONG_STATE_CODE_FILE = "./src/test/resources/StateCodeWrongFormat.csv";


    StateCensusAnalyser stateCensusAnalyser;

    @Before
    public void setUp() {
        stateCensusAnalyser = new StateCensusAnalyser();
    }

    @Test
    public void givenTheStatesCensusCSVFile_whenNumberOfRecordMatch_shouldReturnTrue() throws IOException, StateCensusAnalyserException {
        try {
            int totalRecords = stateCensusAnalyser.loadIndianCensusData(DATA_CSV_FILE_PATH);
            Assert.assertEquals(29, totalRecords);
        } catch (StateCensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFileName_whenImproper_shouldThrowException() throws IOException {
        try {
            stateCensusAnalyser.loadIndianCensusData(IMPROPER_FILE_NAME);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND, e.exceptionTypeObject);
        }
    }

    @Test
    public void givenTheStateCensusCSVFile_whenCorrectButTypeIncorrect_shouldReturnCustomException() throws IOException {
        try {
            stateCensusAnalyser.loadIndianCensusData(IMPROPER_FILE_TYPE);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND, e.exceptionTypeObject);
        }
    }

    @Test
    public void givenTheStateCensusFile_WhenCorrectButDelimiterIncorrect_shouldReturnCustomException() throws IOException {
        try {
            stateCensusAnalyser.loadIndianCensusData(WRONG_DELIMITER1);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND, e.exceptionTypeObject);
        }
    }

    @Test
    public void givenFileData_whenIncorrect_shouldThrowException() throws IOException {
        try {
            stateCensusAnalyser.loadIndianCensusData(WRONG_FILE_FORMATE);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND, e.exceptionTypeObject);
        }
    }

    @Test
    public void givenTotalRecordsFromStateCsvDataFile_whenMatch_shouldReturnTrue() throws StateCensusAnalyserException {
        try {
            int totalRecords = stateCensusAnalyser.loadIndianCensusData(STATE_CODE_FILE);
            Assert.assertEquals(37, totalRecords);
        } catch (Exception e) {
        }
    }

    @Test
    public void givenStateCodeCSVFileNameType_whenImproper_shouldThrowException() throws IOException {
        try {
            stateCensusAnalyser.loadIndianCensusData(IMPROPER_FILE_NAME);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.exceptionType.FILE_NOT_FOUND, e.exceptionTypeObject);
        }
    }

    @Test
    public void givenStateCodeCSVFileData_whenIncorrect_shouldThrowException() throws IOException {
        try {
            stateCensusAnalyser.loadIndianCensusData(WRONG_STATE_CODE_FILE);
        } catch (StateCensusAnalyserException e) {
            Assert.assertEquals(StateCensusAnalyserException.exceptionType.INCORRECT_FILE, e.exceptionTypeObject);
        }
    }
}