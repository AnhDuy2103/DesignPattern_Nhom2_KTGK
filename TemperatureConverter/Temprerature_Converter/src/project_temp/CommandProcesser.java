
public class CommandProcesser {
    // Mẫu sington https://viblo.asia/p/design-patterns-singleton-pattern-maGK7zra5j2
    private static CommandProcesser commandProcesserRemote = null;

    CommandProcesser(){};

    public static CommandProcesser makeCommandProcesser(){
        if (commandProcesserRemote == null) {
            commandProcesserRemote = new CommandProcesser();
        }
        return commandProcesserRemote;
    }

    public void execute(Command cmd){
        cmd.execute();
    }
}
