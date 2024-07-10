import java.util.ArrayList;
import java.util.List;

public class TempSubject {
    private List<TempObserver> observers = new ArrayList<TempObserver>();

    public void attach(TempObserver observer){
        observers.add(observer);
        System.out.println("observer: " + observers.size());
    }
    public void detach(TempObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(){
        for(TempObserver observer : observers){
            observer.update();
        }
    }
}
