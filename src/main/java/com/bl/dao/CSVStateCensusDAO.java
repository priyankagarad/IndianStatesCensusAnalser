package com.bl.dao;
import com.bl.model.CSVStateCensus;
public class CSVStateCensusDAO<E> {
    private String State;
    private int Population;
    private int AreaInSqKm;
    private int DensityPerSqKm;
    private String StateCode;
    private String PopulationDensity;
    private String Area;

    public CSVStateCensusDAO(CSVStateCensus indiaCensusCSV) {
        this.State = indiaCensusCSV.getState();
        this.Population = indiaCensusCSV.getPopulation();
        this.AreaInSqKm = indiaCensusCSV.getAreaInSqKm();
        this.DensityPerSqKm = indiaCensusCSV.getDensityPerSqKm();
    }

    public String getState() {
        return State;
    }

    public int getPopulation() {
        return Population;
    }

    public int getAreaInSqKm() {
        return AreaInSqKm;
    }

    public int getDensityPerSqKm() {
        return DensityPerSqKm;
    }

    public String getStateCode() {
        return StateCode;
    }

    public String getPopulationDensity() {
        return PopulationDensity;
    }

    public String getArea() {
        return Area;
    }

    @Override
    public String toString() {
        return
                ", " + State +
                        "," + Population +
                        "," + AreaInSqKm +
                        "," + DensityPerSqKm +
                        "," + StateCode +
                        "," + PopulationDensity +
                        "," + Area;
    }
}