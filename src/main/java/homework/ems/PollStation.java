package homework.ems;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class PollStation implements ResultElection{
    private int id;
    private String address;
    private TypeStation typeStation;
    private transient List<Citizen> citizens = new ArrayList<>();
    private List<Integer> citizensId = new ArrayList<>();
    private Map<Integer,Integer> results = new LinkedHashMap<>();

    public PollStation() {
    }

    public PollStation(int id) {
        this.id = id;
    }

    public PollStation(int id, String address, TypeStation typeStation) {
        this.address = address;
        this.typeStation = typeStation;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCitizen (Citizen citizen) {
        LocalDate curDate = LocalDate.now();
        int age = Period.between(citizen.getBirthday(), LocalDate.now()).getYears();
        try {
            if (age >= 18 && age <= 150) {
                this.citizens.add(citizen);
                this.citizensId.add(citizen.getCitizenId());
            } else {
                throw new ValidationException("Не соответствует возраст гражданина для участия в выборах");
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());;
        }
    }
    public void addCitizenOnly (Citizen citizen) {
        this.citizens.add(citizen);
    }

    public void delCitizen(Citizen citizen) {
        citizens.remove(citizen);
        citizensId.remove(citizen.getCitizenId());
    }

    public TypeStation getTypeStation() {
        return typeStation;
    }

    public void setTypeStation(TypeStation typeStation) {
        this.typeStation = typeStation;
    }

    public List<Integer> getCitizensId() {
        return citizensId;
    }

    public void listCitizens() {
        citizens.stream().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "PollStation{" +
                "id=" + id +
                ", typeStation='" + typeStation + '\'' +
                ", address='" + address + '\'' +
                ", citizens=" + citizens +
                '}';
    }

    public int getSizeCitizenId() {
        if (citizensId == null) {
            return 0;
        } else {
            return citizensId.size();
        }
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public Map<Integer, Integer> getResults() {
        return results;
    }

    @Override
    public void addVoice(int partyId) {
        int count = 1;
        if (results.containsKey(partyId)) {
            count = results.get(partyId) + 1;
            results.put(partyId,count);
        }
    }

    @Override
    public void prepareToElection(List<Integer> list) {
        results.clear();
        for (Integer i: list) {
            results.put(i,0);
        }
    }

    @Override
    public void showResultElection() {
        System.out.println("Результаты выборов на участке: " + getAddress());
    }
}

