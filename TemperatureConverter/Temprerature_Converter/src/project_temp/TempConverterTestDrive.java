
public class TempConverterTestDrive {
    public static void main(String[] args) {
        CommandProcesser commandProcesserRemote = CommandProcesser.makeCommandProcesser();

        TempConverterModel modelRemote = new TempConverterModel();
        TempConverterView.TempConverterController tempConverterController = new TempConverterView.TempConverterController();
        TempConverterView.MenuController menuController = new TempConverterView.MenuController();
        TempConverterView tempConverterView = new TempConverterView(modelRemote, menuController, tempConverterController, commandProcesserRemote);
    }
}
