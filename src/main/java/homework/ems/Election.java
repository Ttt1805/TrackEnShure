package homework.ems;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Election implements ResultElection{
    private int countPolitParty;
    private int countPollStation;
    private int countCitizen;
    private LocalDate electionsDate;
    private boolean isDone;

    private Set<Citizen> citizens = new HashSet<>();
    private Set<PolitParty> politParties = new HashSet<>();
    private Set<PollStation> pollStations = new HashSet<>();
    private Map<Integer,Integer> results = new LinkedHashMap<>();

    public Election() {
        initialisationParams();
    }

    private void initialisationParams() {
        this.countPolitParty = 0;
        this.countPollStation = 0;
        this.isDone = false;

        LocalDate today = LocalDate.now();
        this.electionsDate = LocalDate.of(today.getYear(),today.getMonthValue(),1 ).plusMonths(6);
    }

    @Override
    public String toString() {
        return "Election{" +
                "countPolitParty=" + countPolitParty +
                ", countPollStation=" + countPollStation +
                ", electionsDate=" + electionsDate +
                ", isDone=" + isDone +
                ", citizens=" + citizens +
                ", politParties=" + politParties +
                ", pollStations=" + pollStations +
                '}';
    }

    public Election(LocalDate electionsDate) {
        this.countPollStation = 0;
        this.countCitizen = 0;
        this.countPolitParty = 0;
        this.electionsDate = electionsDate;
        this.isDone = false;
    }

    public int getCountPolitParty() {
        return countPolitParty;
    }

    public void setCountPolitParty(int countPolitParty) {
        this.countPolitParty = countPolitParty;
    }

    public int getCountPollStation() {
        return countPollStation;
    }

    public void setCountPollStation(int countPollStation) {
        this.countPollStation = countPollStation;
    }

    public LocalDate getElectionsDate() {
        return electionsDate;
    }

    public void setElectionsDate(LocalDate electionsDate) {
        this.electionsDate = electionsDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    private void readConfig() {
        try (BufferedReader reader = new BufferedReader(new FileReader("config.ini"));) {
            this.countPollStation = Integer.parseInt(reader.readLine());
            this.countCitizen = Integer.parseInt(reader.readLine());
            this.countPolitParty = Integer.parseInt(reader.readLine());
            this.electionsDate = LocalDate.parse(reader.readLine());
            this.isDone = Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            initialisationParams();
        }
    }

    private void writeConfig() {
        try (BufferedWriter writer = new BufferedWriter( new FileWriter("config.ini",false))) {
            writer.write(this.countPollStation+"\n");
            writer.write(this.countCitizen+"\n");
            writer.write(this.countPolitParty+"\n");
            writer.write(this.electionsDate+"\n");
            writer.write(this.isDone+"\n");
        } catch (IOException e) {
            System.out.println("Что-то пошло не так");
        }
    }

    private void readCitizen() {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader("citizens.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                Citizen citizen = gson.fromJson(line, Citizen.class);
                addCitizen(citizen);
                line = reader.readLine();
            }
            System.out.println("Данные загружены. Добавлено " + citizens.size() + " граждан");
        }
        catch (IOException e) {
            System.out.println("Что-то с файлом citizens.txt не так...");
        }
    }

    private void writeCitizen() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("citizens.txt")) {
            for (Citizen c: citizens) {
                String s = gson.toJson(c);
                writer.write(s + "\n");
            }
            System.out.println("Граждане сохранены.");
        } catch (IOException e) {
            System.out.println("Что-то с файлом citizens.txt не так...");
        }
    }

    private void readPolitParty() {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader("politParties.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                PolitParty politParty = gson.fromJson(line, PolitParty.class);
                addPolitParty(politParty);

                if (politParty.getSizeDeputiesId() > 0) {
                    for (Map.Entry<Double, Integer> entry : politParty.getDeputiesId().entrySet()) {
                        Optional<Citizen> citizen = findCitizen(entry.getValue());
                        if (citizen.isPresent()) {
                            politParty.addDeputyOnly(entry.getKey(), citizen.get());
                        }
                    }
                }

                line = reader.readLine();
            }
            System.out.println("Данные загружены. Добавлено " + politParties.size() + " партий");
        }
        catch (IOException e) {
            System.out.println("Что-то с файлом citizens.txt не так...");
        }
    }

    private void writePolitParty() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("politParties.txt")) {
            for (PolitParty p: politParties) {
                String s = gson.toJson(p);
                writer.write(s + "\n");
            }
            System.out.println("Партии сохранены.");
        } catch (IOException e) {
            System.out.println("Что-то с файлом politParties.txt не так...");;
        }
    }

    private void readPollStation() {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader("pollStations.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                PollStation pollStation = gson.fromJson(line, PollStation.class);
                addPollStation(pollStation);

                if (pollStation.getSizeCitizenId() > 0) {
                    for (Integer i : pollStation.getCitizensId()) {
                        Optional<Citizen> citizen = findCitizen(i);
                        if (citizen.isPresent()) {
                            pollStation.addCitizenOnly(citizen.get());
                        }
                    }
                }
                line = reader.readLine();
            }
            System.out.println("Данные загружены. Добавлено " + pollStations.size() + " участков");
        }
        catch (IOException e) {
            System.out.println("Что-то с файлом pollStations.txt не так...");
        }
    }

    private void writePollStation() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("pollStations.txt")) {
            for (PollStation p: pollStations) {
                String s = gson.toJson(p);
                writer.write(s + "\n");
//                System.out.println(s);
            }
            System.out.println("Участки сохранены.");
        } catch (IOException e) {
            System.out.println("Что-то с файлом pollStations.txt не так...");;
        }
    }

    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);
    }

    public void addPollStation(PollStation station) {
        pollStations.add(station);
    }

    public void addPolitParty(PolitParty party) {
        politParties.add(party);
    }

    public Optional<Citizen> findCitizen(int id) {
        return citizens.stream()
                .filter(c -> c.getCitizenId()==id).findFirst();
    }

    public Optional<PolitParty> findPolitParty(int id) {
        return politParties.stream()
                .filter(p -> p.getId()==id).findFirst();
    }

    public Optional<PollStation> findPollStation(int id) {
        return pollStations.stream()
                .filter(p -> p.getId() == id).findFirst();
    }

    public void startWork() {
        readConfig();
        readCitizen();
        readPollStation();
        readPolitParty();
        if (isDone) {
            readResult();
        }
    }

    public void endWork() {
        writeConfig();
        writeCitizen();
        writePollStation();
        writePolitParty();
        if (isDone) {
            writeResult();
        }
    }

    private void writeResult() {
        try (ObjectOutputStream writer = new ObjectOutputStream( new FileOutputStream("result.txt",false))) {
            writer.writeObject(results);
        } catch (IOException e) {
            System.out.println("Что-то не так c result.txt");
        }
    }

    private void readResult() {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("result.txt"));) {
            results = (Map<Integer, Integer>) reader.readObject();
        } catch (IOException e) {
            System.out.println("Что-то не так c result.txt");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void listPollStations() {
        pollStations.stream().forEach(System.out::println);
    }

    public void listCitizens() {
        citizens.stream().forEach(System.out::println);
    }

    public void listPolParties() {
        politParties.stream().forEach(System.out::println);
    }

    public int getCountCitizen() {
        return countCitizen;
    }

    public void setCountCitizen(int countCitizen) {
        this.countCitizen = countCitizen;
    }

    public Set<PollStation> getPollStations() {
        return pollStations;
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
        System.out.println("Результаты выборов в целом:");
        showLinkedHashMap(results);
    }

    public String getPartyName(int partyId) {
        Optional<PolitParty> party =findPolitParty(partyId);
        if (party.isPresent()) {
            return party.get().getName();
        } else {
            return "";
        }
    }

    public void prepareToElectionAll() {
       List<Integer> partiesID = politParties.stream().map(p -> p.getId()).collect(Collectors.toList());
        for (PollStation station: pollStations) {
            station.prepareToElection(partiesID);
        }
        prepareToElection(partiesID);
    }


    public String infoAllParty() {
        String info="";
        for (PolitParty party: politParties) {
            info = info + party.getInfo() + ",";
        }
        return info;
    }

    public void showResultStation(int stationId) {
        Optional<PollStation> station = findPollStation(stationId);
        if (station.isPresent()) {
            station.get().showResultElection();
            showLinkedHashMap(station.get().getResults());

        }
    }

    public void showLinkedHashMap(Map<Integer,Integer> lmap) {
        lmap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .forEach(entry -> System.out.println(getPartyName(entry.getKey())
                        .concat(" ---- ")
                        .concat(entry.getValue().toString())));
    }
}
