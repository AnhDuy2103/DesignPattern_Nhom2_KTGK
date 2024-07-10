import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConverterView extends JFrame implements TempObserver {

    // Field 
    private JLabel celLabelRemote, fahLabelRemote;
    private static JTextField celTextFieldRemote;
    private static JTextField fahTextFieldRemote;
    private JPanel jPanelRemote;
    private JMenuBar menuBarRemote;

    private TempConverterController tempConverterControllerRemote;
    
    private static TempConverterModel tempConverterModelRemote;

    private MenuController menuControllerRemote;
    private static CommandProcesser commandProcesserRemote;

    // Constructor 
    public TempConverterView(TempConverterModel tempConverterModelRemote, MenuController menuControllerRemote,
    TempConverterController tempConverterControllerRemote, CommandProcesser commandProcesserRemote) {
        this.tempConverterModelRemote = tempConverterModelRemote;
        this.tempConverterControllerRemote = tempConverterControllerRemote;
        this.commandProcesserRemote = commandProcesserRemote;
        this.menuControllerRemote = menuControllerRemote;


        tempConverterModelRemote.attach(this);
        buildPanel();
        buildMenu();
        setJMenuBar(menuBarRemote);
        add(jPanelRemote);

        setTitle("Temperature Converter");
        setSize(400, 150);
        setVisible(true); // Cho cửa sổ nó hiện lên
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ấn x là tắt luôn chương trình
    }

    // Method 

    public void buildPanel() {
        celLabelRemote = new JLabel("Celsius");
        fahLabelRemote = new JLabel("Fahrenheit");
        celTextFieldRemote = new JTextField("0.0", 10);
        fahTextFieldRemote = new JTextField("32.0", 10);
        celTextFieldRemote.addActionListener(tempConverterControllerRemote);
        fahTextFieldRemote.addActionListener(tempConverterControllerRemote);

        jPanelRemote = new JPanel();

        jPanelRemote.add(celLabelRemote);
        jPanelRemote.add(celTextFieldRemote);
        jPanelRemote.add(fahLabelRemote);
        jPanelRemote.add(fahTextFieldRemote);
    };

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        JMenu tempJMenu = new JMenu("Commands");
        menuBarRemote.add(tempJMenu);

        JMenuItem f2cJMenuItemRemote = new JMenuItem("f2c");
        tempJMenu.add(f2cJMenuItemRemote);
        f2cJMenuItemRemote.addActionListener(menuControllerRemote);

        JMenuItem c2fJMenuItemRemote = new JMenuItem("c2f");
        tempJMenu.add(c2fJMenuItemRemote);
        c2fJMenuItemRemote.addActionListener(menuControllerRemote);

        JMenuItem exitRemote = new JMenuItem("exit");
        tempJMenu.add(exitRemote);
        exitRemote.addActionListener(menuControllerRemote);

    }

    public static class TempConverterController implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            double cel = Double.parseDouble(celTextFieldRemote.getText());
            double fah = Double.parseDouble(fahTextFieldRemote.getText());
            Command commandRemote = null;

            if (e.getSource() == celTextFieldRemote) {
                commandRemote = new c2fCommand(tempConverterModelRemote, cel);
                commandProcesserRemote.execute(commandRemote);
            } else {
                commandRemote = new f2cCommand(tempConverterModelRemote, fah);
                commandProcesserRemote.execute(commandRemote);
            }
        }
    }


    public static class MenuController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            double cel = Double.parseDouble(celTextFieldRemote.getText());
            double fah = Double.parseDouble(fahTextFieldRemote.getText());
            String command = e.getActionCommand();
            Command commandRemote = null;
            if (command.equals("f2c")) {
                commandRemote = new f2cCommand(tempConverterModelRemote, fah);
                commandProcesserRemote.execute(commandRemote);
            } else if (command.equals("c2f")) {
                commandRemote = new c2fCommand(tempConverterModelRemote, cel);
                commandProcesserRemote.execute(commandRemote);
            } else {
                System.exit(0);
            }
        }

    }

    @Override
    public void update() {
        double cel = tempConverterModelRemote.getCel();
        double fah = tempConverterModelRemote.getFah();
        celTextFieldRemote.setText(String.valueOf(cel));
        fahTextFieldRemote.setText(String.valueOf(fah));
    }

}
