package com.bl.censusanalyser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Iterator;
import static java.nio.file.Files.newBufferedReader;

public class CSVStates {
    public static String STATE_CODE_FILE = "./src/test/resources/StateCode.csv";

    public static void main(String args[]) throws IOException {
        CSVStates csvState = new CSVStates();
        csvState.loadStateCodes(STATE_CODE_FILE);
    }

    public int loadStateCodes(String FILE_PATH) throws IOException
    {
        int totalRecords = 0;
        try (Reader reader = newBufferedReader(Paths.get(FILE_PATH)))
        {
            CsvToBean<CSVStateCode> csvStateCodeBeanObject = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVStateCode> csvStateCodePojoIterator = csvStateCodeBeanObject.iterator();
            while (csvStateCodePojoIterator.hasNext())
            {
                totalRecords++;
            }
        }
        return totalRecords;
    }
}

