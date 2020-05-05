package com.bl.censusanalyser;

public class CSVStateCensusDAO
{
    private String SrNo;
    private String State;
    private int Population;
    private int AreaInSqKm;
    private int DensityPerSqKm;
    private String StateCode;
    private String TIN;

    public CSVStateCensusDAO(CSVStateCensus indiaCensusCSV) {
        this.State = indiaCensusCSV.getState();
        this.Population = indiaCensusCSV.getPopulation();
        this.AreaInSqKm = indiaCensusCSV.getAreaInSqKm();
        this.DensityPerSqKm = indiaCensusCSV.getDensityPerSqKm();
    }
    public CSVStateCensusDAO(CSVStateCode indiaStateCodeCSV) {
        this.SrNo = indiaStateCodeCSV.getSrNo();
        this.State = indiaStateCodeCSV.getStateName();
        this.StateCode = indiaStateCodeCSV.getStateCode();
        this.TIN = indiaStateCodeCSV.getTIN();
    }
    public String getSrNo() {
        return SrNo;
    }
    public void setSrNo(String srNo) {
        this.SrNo = srNo;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        this.State = state;
    }
    public int getPopulation() {
        return Population;
    }
    public void setPopulation(int population) {
        this.Population = population;
    }
    public int getAreaInSqKm() {
        return AreaInSqKm;
    }
    public void setAreaInSqKm(int areaInSqKm) {
        this.AreaInSqKm = areaInSqKm;
    }
    public int getDensityPerSqKm() {
        return DensityPerSqKm;
    }
    public void setDensityPerSqKm(int densityPerSqKm) {
        this.DensityPerSqKm = densityPerSqKm;
    }
    public String getStateCode() {
        return StateCode;
    }
    public void setStateCode(String stateCode) {
        this.StateCode = stateCode;
    }
    public String getTin() {
        return TIN;
    }
    public void setTin(String TIN) {
        this.TIN = TIN;
    }
}