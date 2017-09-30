package UI;


import utility.KeyUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    private JFrame frame;
    private JTextArea textArea;
    private final String userName = "User:~$";

    public Main() {
        frame = new JFrame("Console");
        frame.setBounds(50, 30, 500, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        textArea = initTextArea();
        textArea = moveCursorToEnd(textArea);
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Success");
                    textArea.append("\n" + userName);
                    textArea.setCaretPosition(textArea.getCaretPosition());

                    String[] s = textArea.getText().split("U");
                    for (String item: s) {
                        System.out.println(item);
                        System.out.println("----");
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        frame.add(textArea);

        frame.setVisible(true);
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

    public JTextArea initTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(0,0,500,400);
        textArea.append(userName);
        textArea.setBackground(new Color(119,41,83));
        Font f  = textArea.getFont();
        textArea.setFont(f.deriveFont(Font.BOLD));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        KeyUtil.disableKey(textArea.getInputMap(), new String[] {"ENTER"});

        return textArea;
    }

    public JTextArea moveCursorToEnd(JTextArea textArea) {
        textArea.setCaretPosition(textArea.getCaretPosition() + textArea.getText().length());
        return textArea;
    }
}
