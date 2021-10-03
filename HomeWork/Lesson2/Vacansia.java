package TrackEnShure.HomeWork.Lesson2;

abstract public class Vacansia implements EmployeeType{
    protected String nameVacansia;

    public String getNameVacansia() {
        return nameVacansia;
    }

    public void setNameVacansia(String nameVacansia) {
        this.nameVacansia = nameVacansia;
    }

    @Override
    public void Working() {

    }
}
