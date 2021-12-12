package homework.ems;

public enum TypeStation {
    USUALLY(1),
    MILITARY(2),
    QUARANTINE(3);

    private int index;

    TypeStation(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
