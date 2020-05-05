package com.bl.censusanalyser;

public class CSVStateCensusDAO
{
    public String state;
    public String densityPerSqKm;
    public String areaInSqKm;
    public String population;
    public String stateCode;

    public CSVStateCensusDAO(CSVStateCensus indiaCensusCSV)
    {
        densityPerSqKm = indiaCensusCSV.getDensityPerSqKm();
        areaInSqKm = indiaCensusCSV.getAreaInSqKm();
        population = indiaCensusCSV.getPopulation();
        state = indiaCensusCSV.getState();
    }
    public CSVStateCensusDAO(CSVStateCode indiaCensusCSV)
    {
        stateCode = indiaCensusCSV.getStateCode();
    }
}