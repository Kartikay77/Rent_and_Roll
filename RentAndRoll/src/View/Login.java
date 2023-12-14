/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author erkur
 */
public class Login {
    private final JPanel MiniPanel, MainPanel, ButtonPanel, UnPanel, PwPanel;
    private final JButton Close_Button, Login_Button;
    private final JLabel PW_Label, UN_Label, Image_jLabel, info_Label;
    private final JTextField UN_TextField;
    private final JPasswordField Password_Field;

    public Login() {

        MiniPanel = new JPanel();
        MainPanel = new JPanel(new BorderLayout());
        ButtonPanel = new JPanel();
        UnPanel = new JPanel();
        PwPanel = new JPanel();

        Close_Button = new JButton("Close");
        Login_Button = new JButton("Login");

        PW_Label = new JLabel("Password");
        UN_Label = new JLabel("Username");
        info_Label = new JLabel("Please Enter your Login Details");
        Image_jLabel = new JLabel();

        UN_TextField = new JTextField();
        Password_Field = new JPasswordField();

        MainPanel.setPreferredSize(new Dimension(1366, 730));
        
        UN_TextField.setPreferredSize(new Dimension(200, 20));
        UN_TextField.setMaximumSize(new Dimension(200, UN_TextField.getMinimumSize().height));
        
        Password_Field.setPreferredSize(new Dimension(200, 20));
        Password_Field.setMaximumSize(new Dimension(Password_Field.getPreferredSize().width, Password_Field.getMinimumSize().height));
        
        info_Label.setFont(new Font("Poppins", 1, 18)); // Consolas, Bold , 18pt
        info_Label.setForeground(Color.WHITE);

        UN_Label.setFont(new Font("Poppins", 0, 18));
        UN_Label.setForeground(Color.WHITE);
        UN_Label.setPreferredSize(new Dimension(100, 20));

        PW_Label.setFont(new Font("Poppins", 0, 18));
        PW_Label.setForeground(Color.WHITE);
        PW_Label.setPreferredSize(new Dimension(100, 20));
        
        UnPanel.setLayout(new FlowLayout());
        UnPanel.setBackground(new Color(43,31,80));
        UnPanel.setMaximumSize(new Dimension(683, 50));
        UnPanel.add(UN_Label);
        UnPanel.add(UN_TextField);
        
        PwPanel.setLayout(new FlowLayout());
        PwPanel.setMaximumSize(new Dimension(683, 50));
        PwPanel.setBackground(new Color(43,31,80));
        PwPanel.add(PW_Label);
        PwPanel.add(Password_Field);
        
        Login_Button.setPreferredSize(new Dimension(80, 20));
        Close_Button.setPreferredSize(new Dimension(80, 20));
        ButtonPanel.setBackground(new Color(43,31,80));
        ButtonPanel.setLayout(new FlowLayout());
        ButtonPanel.add(Login_Button);
        ButtonPanel.add(Close_Button);
        
        MiniPanel.setPreferredSize(new Dimension(683, 730));
        MiniPanel.setBackground(new Color(43,31,80));
        MiniPanel.setLayout(new BoxLayout(MiniPanel, BoxLayout.Y_AXIS));
        MiniPanel.add(Box.createRigidArea(new Dimension(0,100)));
        MiniPanel.add(info_Label);
        MiniPanel.add(UnPanel);
        MiniPanel.add(PwPanel);
        MiniPanel.add(ButtonPanel);
        
        Image_jLabel.setPreferredSize(new Dimension(683, 730));
        Image_jLabel.setIcon(new ImageIcon("LoginImage3.jpg"));

        MainPanel.add(MiniPanel, BorderLayout.WEST);
        MainPanel.add(Image_jLabel, BorderLayout.EAST);

        Login_Button.addActionListener(new LoginActionListener());
        Close_Button.addActionListener(new LoginActionListener());
    }

    /**
     * @return the MainPanel
     */
    public JPanel getMainPanel() {
        return MainPanel;
    }

    private class LoginActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "Close": {
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "You are about to terminate the program.\n"
                            + " Are you sure you want to continue ?", "Close Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
                    if (showConfirmDialog == 0) {
                        System.exit(0);
                    }
                    break;
                }
                case "Login": {
                    if (UN_TextField.getText().trim().equalsIgnoreCase("admin")
                            && String.valueOf(Password_Field.getPassword()).equals("123")) {
                        UN_TextField.setText("");
                        Password_Field.setText("");
                        Runner.getFrame().dispose();
                        ParentFrame frame = new ParentFrame();
                        MainMenu menu = new MainMenu();
                        JFrame mainFrame = ParentFrame.getMainFrame();
                        JPanel mainPanel = menu.getMainPanel();
                        mainFrame.add(menu.getMainPanel());
                        mainFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid UserName/Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
        }
    }
}
