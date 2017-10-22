package UI;


import client.KeyUtil;
import utility.Management;
import utility.ManagementFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static java.lang.System.out;

public class Main {
    private JFrame frame;
    private JTextArea textArea;
    private JTextArea commandTextArea;
    private JTextPane directoryPane;
    private final String userName = "User:~$";
    ManagementFactory factory = new ManagementFactory();
    Management fileManagement = factory.getManagement("FileManagement");

    public Main() {
        out.println(System.getProperty("user.home"));
        String[] a =  "/home/minhat".split("/");
        out.println(a[1] + " " + a[2]);

        frame = new JFrame("Console");
        frame.setBounds(50, 30, 500, 420);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        commandTextArea = initCommandTextArea();
        directoryPane = initDirectoryPane();
        textArea = initConsoleTextArea();
        textArea = moveCursorToEnd(textArea);
        commandTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    String command = getCommand(commandTextArea);
                    String[] args = convertCommandToAgv(command);
                    excuteCommand(args);
                    commandTextArea.setText("");
                }

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        frame.add(textArea);
        frame.add(commandTextArea);
        frame.setVisible(true);
        frame.add(directoryPane);
        Path path = FileSystems.getDefault().getPath("/home/minhat/workspace/node");
        File file = new File(path.toString());

        System.out.println(file.getName());
    }
    public static void main(String[] args) {
        new Main();

//        try {
//            PrintWriter printWriter = new PrintWriter("home/minhat/workspace/abc.jpg");
//        } catch (FileNotFoundException ex) {
//
//        }
//
//        ManagementFactory management = new ManagementFactory();
//        Management fileManagement = management.getManagement("FileManagement");
//        try {
//            fileManagement.copy("/home/minhat/workspace/coffee1.jpg", "/home/minhat/workspace/abc.jpg");
//        } catch (IOException e) {
//            System.out.println("throws IO");
//        }
    }

    public JTextArea initConsoleTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0,0,500,350);
        textArea.setBackground(new Color(119,41,83));
        textArea.setEditable(false);
        Font f  = textArea.getFont();
        textArea.setFont(f.deriveFont(Font.BOLD));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        KeyUtil.disableKey(textArea.getInputMap(), new String[] {"ENTER"});
        return textArea;
    }

    public JTextArea initCommandTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0,370,500,50);
        textArea.setBackground(new Color(119,41,83));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    public JTextPane initDirectoryPane() {
        JTextPane textPane = new JTextPane();
        textPane.setBounds(0, 350, 500, 20);
        textPane.setText(System.getProperty("user.home"));
        textPane.setEditable(false);
        return textPane;
    }


    public JTextArea moveCursorToEnd(JTextArea textArea) {
        textArea.setCaretPosition(textArea.getCaretPosition() + textArea.getText().length());
        return textArea;
    }

    public String getCommand(JTextArea commandTA) {
        String command = commandTA.getText();
        return command;
    }

    public String[] convertCommandToAgv(String command) {
        String agvs[] = command.split(" ");
        return agvs;
    }

    public void excuteCopy(String src, String des) {
        String[] arr = src.split("/");
        for(String item : arr) {
            out.println(item);

        }
        String fileName = arr[arr.length - 1];
        des = des + "/" + fileName;
        try {
            fileManagement.copy(src, des);
            textArea.setText("Copy success");
        } catch (IOException ex) {
            textArea.setText("Copy is stuck");
            out.println("Khong copy dc file");
        }
    }

    public void excuteCommand(String[] commandAgvs) {
        switch (commandAgvs[0]) {
            case "cp":
                excuteCopy(commandAgvs[1], commandAgvs[2]);
                break;
            case "remove":
                excuteDelete(commandAgvs[commandAgvs.length-1]);
                break;
            default:
                out.println("Khong dung cu phap");
                break;
        }
    }

    public void excuteDelete(String fileName) {
        if(fileManagement.delete(fileName)) {
            System.out.println("Xoa thanh cong");
            return;
        }
        System.out.println("Xoa fail");
    }

}
