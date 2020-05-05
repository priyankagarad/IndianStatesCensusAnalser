package com.bl.model;
import com.opencsv.bean.CsvBindByName;
public class CSVStateCode {
    @CsvBindByName(column = "SrNo")
    private String SrNo;
    @CsvBindByName(column = "StateName")
    private String StateName;
    @CsvBindByName(column = "StateCode")
    private String StateCode;
    @CsvBindByName(column = "TTN")
    private String TTN;

    public String getSrNo()
    {
        return SrNo;
    }

    public void setSrNo(String SrNo)
    {
        this.SrNo=SrNo;
    }

    public String getStateName()
    {
        return StateName;
    }
    public void setStateName(String StateName)
    {
        this.StateName=StateName;
    }
    public String getTIN()
    {
        return TTN;
    }
    public void setTTN(String TTN)
    {
        this.TTN=TTN;
    }

    public String getStateCode()
    {
        return  StateCode;
    }
    public void setStateCode()
    {
        this.StateCode=StateCode;
    }
}
