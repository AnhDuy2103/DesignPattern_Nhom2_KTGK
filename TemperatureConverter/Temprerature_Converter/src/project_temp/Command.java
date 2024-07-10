public abstract class Command {

    protected TempConverterModel tempConverterModelRemote = null;
    
    public Command(TempConverterModel tempConverterModelRemote){
        this.tempConverterModelRemote = tempConverterModelRemote;
    }

    public abstract void execute();
}
