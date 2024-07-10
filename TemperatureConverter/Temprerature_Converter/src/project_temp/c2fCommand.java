public class c2fCommand extends Command{
    private double cel;

    
    public c2fCommand(TempConverterModel tempConverterModelRemote, double cel) {
        super(tempConverterModelRemote);
        this.cel = cel;
    }

    @Override
    public void execute() {
        tempConverterModelRemote.c2f(cel);
    }

}
