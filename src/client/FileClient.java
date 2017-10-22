package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileClient {

    private JFrame frame;
    private JTextArea txtConsole;
    private JTextArea txtCommand;
    private JTextPane directoryPane;
    private Socket socketClient;

    public FileClient() {
        initUIComponent();
    }

    public static void main(String[] args) {
        new FileClient();
    }

    private void initTxtConsole() {
        txtConsole = new JTextArea();
        txtConsole.setBounds(0,0,500,350);
        txtConsole.setBackground(new Color(119,41,83));
        txtConsole.setEditable(false);
        Font f  = txtConsole.getFont();
        txtConsole.setFont(f.deriveFont(Font.BOLD));
        txtConsole.setLineWrap(true);
        txtConsole.setWrapStyleWord(true);
        KeyUtil.disableKey(txtConsole.getInputMap(), new String[] {"ENTER"});
    }

    private void initTxtCommand() {
        txtCommand = new JTextArea();
        txtCommand.setBounds(0,370,500,50);
        txtCommand.setBackground(new Color(119,41,83));
        txtCommand.setLineWrap(true);
        txtCommand.setWrapStyleWord(true);

        txtCommand.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    String command = getCommand(txtCommand);
                    String[] args = convertCommandToAgv(command);
                    txtCommand.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
    }

    private void initDirectoryPane() {
        directoryPane = new JTextPane();
        directoryPane.setBounds(0, 350, 500, 20);
        directoryPane.setText(System.getProperty("user.home"));
        directoryPane.setEditable(false);
    }

    private void initMainFrame() {
        frame = new JFrame("Console");
        frame.setVisible(true);
        frame.setBounds(50, 30, 500, 420);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initUIComponent() {
        initTxtConsole();
        initTxtCommand();
        initDirectoryPane();
        initMainFrame();
        frame.add(txtConsole);
        frame.add(txtCommand);
        frame.add(directoryPane);
    }

    private String getCommand(JTextArea commandTA) {
        String command = commandTA.getText();
        return command;
    }

    private String[] convertCommandToAgv(String command) {
        String agvs[] = command.split(" ");
        return agvs;
    }

    private void initConnect(String address, int port ) throws IOException{
        socketClient = new Socket(address, port);ocal
    }
}
