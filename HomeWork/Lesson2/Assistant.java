package TrackEnShure.HomeWork.Lesson2;

public class Assistant extends Vacansia {
    Assistant(){
        setNameVacansia("Ассистент");
    }

    @Override
    public void Working() {
        System.out.println("чинит компьютер");
    }
}
