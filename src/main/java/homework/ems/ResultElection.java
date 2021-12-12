package homework.ems;

import java.util.List;

public interface ResultElection {
    void addVoice(int partyId);
    void prepareToElection(List <Integer> list);
    void showResultElection();
}
