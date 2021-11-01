package homework.ems;

import java.time.LocalDate;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PolitParty {
    private  int id;
    private String name;
    private Fraction fraction;
    private String creationDate;
    private transient Map<Double, Citizen> deputies = new TreeMap<>();
    private Map<Double, Integer> deputiesId = new TreeMap<>(Collections.reverseOrder());

    public PolitParty() {}

    public PolitParty(int id) {
        this.id = id;
    }

    public PolitParty(int id, String name, Fraction fraction, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.fraction = fraction;
        this.creationDate = creationDate.toString();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate.toString();
    }

    public void addDeputy (Double rating, Citizen citizen) {
        if (!citizen.isDeputy()) {
            deputies.put(rating, citizen);
            deputiesId.put(rating, citizen.getCitizenId());
            citizen.setDeputy(true);
        } else {
            System.out.println("Гражданин уже депутат");
        }
    }

    public void addDeputyOnly (Double rating, Citizen citizen) {
        if (citizen.isDeputy()) {
            deputies.put(rating, citizen);
        }
    }

    public void delDeputy(Citizen citizen){
        Optional<Double> rating = deputies.entrySet().stream()
                .filter(c -> c.getValue().equals(citizen))
                .map(c -> c.getKey()).findFirst();
        if (rating.isPresent()) {
            deputies.remove(rating.get());
            deputiesId.remove(rating.get());
            citizen.setDeputy(false);
        }
    }


    @Override
    public String toString() {
        return "PolitParty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fraction=" + fraction +
                ", creationDate=" + creationDate +
                ", deputies=" + deputies +
                '}';
    }


    public Map<Double, Integer> getDeputiesId() {
        return deputiesId;
    }

    public int getSizeDeputiesId() {
        return deputiesId.size();
    }

    public void listDeputies() {
        for (Map.Entry<Double, Citizen> entry : deputies.entrySet()) {
            System.out.println("Депутат - " + entry.getValue() + "\n" + "рейтинг - " + entry.getKey());
        }
    }

    public String getInfo() {
        return id + " - " + name;
    }

}
