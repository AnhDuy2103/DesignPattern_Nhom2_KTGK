public class TempConverterModel extends TempSubject {
    private double resultCel;
    private double resultFah;

    public TempConverterModel(){}

    public void f2c(double fah){
        resultCel = 0.556 * (fah - 32);
        resultFah = fah;
        notifyObservers();
    }

    public void c2f(double cel){
        resultFah = 1.8 * cel + 32;
        resultCel = cel;
        notifyObservers();
    }

    public double getCel(){
        return resultCel;
    }

    public double getFah(){
        return resultFah;
    }
}
