package com.bl.censusanalyser;
import com.bl.exception.StateCensusAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Iterator;
import static java.nio.file.Files.newBufferedReader;
public class StateCensusAnalyser<T>
{
    public int loadIndianData(String csvFilePath,Object T)
    {
        int totalRecords = 0;
        try (Reader reader = newBufferedReader(Paths.get(csvFilePath));)
        {
            Iterator<T> csvStateCensusIterator = (Iterator<T>) this.getFileIterator(reader,T.getClass());
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
    public <E> Iterator<E> getFileIterator(Reader reader, Class<E> csvClass)
    {
        CsvToBeanBuilder csvToBeanBuilder = new CsvToBeanBuilder(reader);
        csvToBeanBuilder.withType(csvClass);
        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean csvToBean = csvToBeanBuilder.build();
        return csvToBean.iterator();
    }
}