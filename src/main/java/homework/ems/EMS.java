package homework.ems;

import homework.ems.menu.Menu;
import homework.ems.menu.SubMenuParty;
import homework.ems.menu.SubMenuStation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class EMS {
    private Scanner scanner;
    private Election election;
    private Menu menu;

    public EMS() {
        scanner = new Scanner(System.in);
        election = new Election();
        menu = new Menu();
    }


    public void start() {
        election.startWork();
        menu.createMenu(!election.isDone());
    }

    public void run() {
        int menuNumber;
        scanner.useDelimiter("\\n");

        menu.showMenu();
        menuNumber = scanner.hasNextInt() ? scanner.nextInt() : 0;
        while (menuNumber != 12) {
            switch (menuNumber) {
                case 1 -> addPollStation();
                case 2 -> addCitizen();
                case 3 -> addPolParty();
                case 4 -> election.listPollStations();
                case 5 -> election.listCitizens();
                case 6 -> election.listPolParties();
                case 7 -> menu.setMenu(SubMenuStation.getMenu());
                case 8 -> menu.setMenu(SubMenuParty.getMenu());
                case 9 -> holdElection();
                case 10 -> showResult();
                case 11 -> election.showResultElection();
                case 71 -> listCitizen();
                case 72 -> addCitizenToStation();
                case 73 -> delCitizenFromStation();
                case 81 -> listDeputies();
                case 82 -> addDeputyToParty();
                case 83 -> delDeputyFromPaty();
                case 74, 84 -> menu.createMenu(!election.isDone());
            }
            System.out.println("Для продолжения работы нажмте Enter...");
            scanner.next();
            menu.showMenu();
            menuNumber = scanner.hasNextInt() ? scanner.nextInt() : 0;
        }

    }

    private void addDeputyToParty() {
        int partyId = 0;
        int citizenId = 0;
        double rating = 0.0;
        System.out.println("Введите ID партии");
        if (scanner.hasNextInt()) {
            partyId = scanner.nextInt();
        }

        System.out.println("Введите ID гражданина");
        if (scanner.hasNextInt()) {
            citizenId = scanner.nextInt();
        }

        System.out.println("Введите рейтинг депутата");
        if (scanner.hasNextDouble()) {
            rating = scanner.nextDouble();
        }

        if (citizenId > 0 && partyId >0) {
            Optional<Citizen> citizen = election.findCitizen(citizenId);
            Optional<PolitParty> party = election.findPolitParty(partyId);
            if (citizen.isPresent() && party.isPresent()) {
                party.get().addDeputy(rating, citizen.get());
                System.out.println("Депутат добавлен в партию.");
            } else {
                System.out.println("Партии или гражданина с такими данными не существует.");
            }
        }
    }

    private void delDeputyFromPaty() {
        int partyId = 0;
        int citizenId = 0;

        System.out.println("Введите ID партии");
        if (scanner.hasNextInt()) {
            partyId = scanner.nextInt();
        }

        System.out.println("Введите ID гражданина-депутата");
        if (scanner.hasNextInt()) {
            citizenId = scanner.nextInt();
        }


        if (citizenId > 0 && partyId >0) {
            Optional<Citizen> citizen = election.findCitizen(citizenId);
            Optional<PolitParty> party = election.findPolitParty(partyId);
            if (citizen.isPresent() && party.isPresent()) {
                party.get().delDeputy(citizen.get());
                System.out.println("Депутат удален из партии");
            } else {
                System.out.println("Партии или гражданина с такими данными не существует");
            }
        }
    }

    private void listDeputies() {
        int partyId = 0;
        System.out.println("Введите ID партии");
        if (scanner.hasNextInt()) {
            partyId = scanner.nextInt();
            Optional<PolitParty> party = election.findPolitParty(partyId);
            if (party.isPresent()) {
                party.get().listDeputies();
            }
        }
    }

    private void delCitizenFromStation() {
        int stationId = 0;
        int citizenId = 0;
        System.out.println("Введите номер избирательного участка");
        if (scanner.hasNextInt()) {
            stationId = scanner.nextInt();
        }

        System.out.println("Введите ID гражданина");
        if (scanner.hasNextInt()) {
            citizenId = scanner.nextInt();
        }

        if (citizenId > 0 && stationId >0) {
            Optional<Citizen> citizen = election.findCitizen(citizenId);
            Optional<PollStation> station = election.findPollStation(stationId);
            if (citizen.isPresent() && station.isPresent()) {
                station.get().delCitizen(citizen.get());
                System.out.println("Гражданина удален из участка.");
            } else {
                System.out.println("Участка или гражданина с такими данными не существует.");
            }
        }

    }

    private void addCitizenToStation() {
        int stationId = 0;
        int citizenId = 0;
        System.out.println("Введите номер избирательного участка");
        if (scanner.hasNextInt()) {
            stationId = scanner.nextInt();
        }

        System.out.println("Введите ID гражданина");
        if (scanner.hasNextInt()) {
            citizenId = scanner.nextInt();
        }

        if (citizenId > 0 && stationId >0) {
            Optional<Citizen> citizen = election.findCitizen(citizenId);
            Optional<PollStation> station = election.findPollStation(stationId);
            if (citizen.isPresent() && station.isPresent()) {
                PollStation st = station.get();
                st.addCitizen(citizen.get());
                System.out.println("Гражданин зарегистрирован на участке");
            } else {
                System.out.println("Участка или гражданина с такими данными не существует");
            }
        }
    }

    private void listCitizen() {
        int stationId = 0;
        System.out.println("Введите номер избирательного участка");
        if (scanner.hasNextInt()) {
            stationId = scanner.nextInt();
            Optional<PollStation> pollStation = election.findPollStation(stationId);
            if (pollStation.isPresent()) {
                pollStation.get().listCitizens();
            }
        }
    }

    private void showResult() {
        int stationId = 0;
        System.out.println("Введите номер избирательного участка");
        if (scanner.hasNextInt()) {
            stationId = scanner.nextInt();
            election.showResultStation(stationId);
        }
    }

    private void holdElection() {
        election.prepareToElectionAll();
        String partyInfo = "Проголосуйте: " + election.infoAllParty() + "0 - против всех";
        for (PollStation station: election.getPollStations()) {
            System.out.println("Выборы на участке " + station.getAddress());
            for (Citizen citizen: station.getCitizens()) {
                citizen.showInfo();
                System.out.println(partyInfo);
                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    if (choice != 0) {
                        station.addVoice(choice);
                        election.addVoice(choice);
                    }
                }
            }
        }
        System.out.println("Выборы проведены. Идет подсчет результатов...");
        election.setDone(true);
        menu.createMenu(election.isDone());
    }

    private void addPolParty() {
        String name = "";
        Fraction fraction = Fraction.LEFT;
        LocalDate creationDate = LocalDate.of(1,1,1);

        System.out.print("Введите название партии:\t");
        name = scanner.next();

        System.out.print("Введите дату создания(гггг-мм-дд): ");
        creationDate = LocalDate.parse(scanner.next());

        System.out.print("Введите Тип партии(1: Левая; 2: Правая; 3: Центр) ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            fraction = switch (num) {
                case 2 -> Fraction.RIGHT;
                case 3 -> Fraction.CENTRAL;
                default -> Fraction.LEFT;
            };
        }
        election.setCountPolitParty(election.getCountPolitParty()+1);
        PolitParty party = new PolitParty(election.getCountPolitParty(),name,fraction,creationDate);
        election.addPolitParty(party);
        System.out.println("Партия добавлена.");
    }

    private void addPollStation() {
        String address = "";
        TypeStation typeStation = TypeStation.USUALLY;

        System.out.print("Введите Адрес участка:\t");
        address = scanner.next();

        System.out.print("Введите Тип участка(1: обычный; 2: для спец.служб; 3: карантинный) ");
        if (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            typeStation = switch (num) {
                case 2 -> TypeStation.MILITARY;
                case 3 -> TypeStation.QUARANTINE;
                default -> TypeStation.USUALLY;
            };
        }

        election.setCountPollStation(election.getCountPollStation()+1);
        PollStation station = new PollStation(election.getCountPollStation(),address,typeStation);
        election.addPollStation(station);
        System.out.println("Избирательный участок добавлен");
    }

    private void addCitizen() {
        String fullName = "";
        String passportId ="";
        long inn = 1000000000L;
        LocalDate birthday = LocalDate.of(1,1,1);
        boolean isMilitary = false;
        boolean isQuarantine = false;
        int stationId = 0;

        boolean isError = false;

        System.out.print("Введите ФИО:\t");
        fullName = scanner.next();

        System.out.print("Введите номер паспорта:\t");
        passportId = scanner.next();

        System.out.print("Введите ИНН: ");
        if (scanner.hasNextLong()) {
            inn = scanner.nextLong();
        }

        System.out.print("Введите дату рождения(гггг-мм-дд): ");
        birthday = LocalDate.parse(scanner.next());

        System.out.print("Является ли гражданин сотрудником спец.служб или военным: ");
        if (scanner.hasNextBoolean()) {
            isMilitary = scanner.nextBoolean();
        }

        System.out.print("Находится ли гражданин на карантине: ");
        if (scanner.hasNextBoolean()) {
            isQuarantine = scanner.nextBoolean();
        }

        System.out.print("Введите номер участка: ");
        if (scanner.hasNextInt()) {
            stationId = scanner.nextInt();
        }

        try {
            if (inn < 1000000000L || inn > 9999999999L) {
                throw new ValidationException("Неверный ИНН");
            }
            if (fullName.length()==0) {
                throw new ValidationException("Пустое ФИО");
            }
            Optional<PollStation> station = election.findPollStation(stationId);
            if (station.isPresent()) {
                if (isQuarantine && station.get().getTypeStation() != TypeStation.QUARANTINE) {
                    throw new ValidationException("Гражданин в карантине. Участок не соответствует");
                } else if (isMilitary && station.get().getTypeStation() != TypeStation.MILITARY) {
                    throw new ValidationException("Гражданин сотрудник спец.служб. Участок не соответствует");
                }
            } else {
                throw new ValidationException("Избирательный участок не найден");
            }
            election.setCountCitizen(election.getCountCitizen()+1);
            Citizen citizen = new Citizen(election.getCountCitizen(),fullName,passportId,inn,birthday,isMilitary,isQuarantine,stationId);
            election.addCitizen(citizen);
            station.get().addCitizen(citizen);
            System.out.println("Введен новый гражданин");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void end() {
        election.endWork();
        scanner.close();
    }
}