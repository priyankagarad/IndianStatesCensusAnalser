package com.bl.model;
import com.opencsv.bean.CsvBindByName;
public class CSVUSCensusData
{
    @CsvBindByName(column = "State Id")
    private String StateID;
    @CsvBindByName(column = "State")
    private String State;
    @CsvBindByName(column = "Population Density")
    private String PopulationDensity;
    @CsvBindByName(column = "Population")
    private String Population;
    @CsvBindByName(column = "Total area")
    private String Area;
    @CsvBindByName(column = "Housing units")
    private String HousingUnits;
    @CsvBindByName(column = "Water area")
    private String WaterArea;
    @CsvBindByName(column = "Land Area")
    private String LandArea;
    @CsvBindByName(column = "Housing Density")
    private String HousingDensity;
}

