package homework.ems;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Citizen {
    private int citizenId;
    private String fullName;
    private String passportID;
    private long inn;
    private String birthday;
    private boolean isMilitary;
    private boolean isQuarantine;
    private boolean isDeputy;
    private int stationId;

    public Citizen() {
    }

    public Citizen(int citizenId, String fullName, String passportID, long inn, LocalDate birthday, boolean isMilitary, boolean isQuarantine, int stationId) {
        this.citizenId = citizenId;
        this.fullName = fullName;
        this.passportID = passportID;
        this.inn = inn;
        this.birthday = birthday.toString();
        this.isMilitary = isMilitary;
        this.isQuarantine = isQuarantine;
        this.stationId = stationId;
    }

    public boolean isDeputy() {
        return isDeputy;
    }

    public void setDeputy(boolean deputy) {
        isDeputy = deputy;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public LocalDate getBirthday() {
        return LocalDate.parse(birthday);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday.toString();
    }

    public boolean isFlMilitary() {
        return isMilitary;
    }

    public void setFlMilitary(boolean isMilitary) {
        this.isMilitary = isMilitary;
    }

    public boolean isFlQuarantine() {
        return isQuarantine;
    }

    public void setFlQuarantine(boolean isQuarantine) {
        this.isQuarantine = isQuarantine;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getCitizenId() {
        return citizenId;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "Id=" + citizenId +
                ", fullName='" + fullName + '\'' +
                ", passportID='" + passportID + '\'' +
                ", inn=" + inn +
                ", birthday='" + birthday + '\'' +
                ", isMilitary=" + isMilitary +
                ", isQuarantine=" + isQuarantine +
                ", isDeputy=" + isDeputy +
                ", stationId=" + stationId +
                '}';
    }

    public void showInfo() {
        String info = citizenId + "\\"
               + fullName + "\\"
               + birthday + "\\"
               +  passportID ;
        System.out.println(info);
    }
}
