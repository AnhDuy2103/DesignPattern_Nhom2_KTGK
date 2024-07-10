public class f2cCommand extends Command{

    private double fah;

    public f2cCommand(TempConverterModel tempConverterModelRemote, double fah) {
        super(tempConverterModelRemote);
        this.fah = fah;
    }

    @Override
    public void execute() {
        tempConverterModelRemote.f2c(fah);
    }

}
