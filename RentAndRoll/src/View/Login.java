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
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author erkur
 */
public class Login {
    private final JPanel MiniPanel, MainPanel, ButtonPanel;
    private final JButton Close_Button, Login_Button;
    private final JLabel PW_Label, UN_Label, Image_jLabel, info_Label;
    private final JTextField UN_TextField;
    private final JPasswordField Password_Field;

    public Login() {

        MiniPanel = new JPanel();
        MainPanel = new JPanel(new BorderLayout());
        ButtonPanel = new JPanel();

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
        UN_TextField.setMaximumSize(new Dimension(UN_TextField.getPreferredSize().width, UN_TextField.getMinimumSize().height));
        Password_Field.setPreferredSize(new Dimension(200, 20));
        Password_Field.setMaximumSize(new Dimension(Password_Field.getPreferredSize().width, Password_Field.getMinimumSize().height));
        MiniPanel.setPreferredSize(new Dimension(683, 730));
        MiniPanel.setBackground(new Color(43,31,80));
        MiniPanel.setLayout(new BoxLayout(MiniPanel, BoxLayout.PAGE_AXIS));
        MiniPanel.add(info_Label);
        MiniPanel.add(UN_Label);
        MiniPanel.add(UN_TextField);
        MiniPanel.add(PW_Label);
        MiniPanel.add(Password_Field);
        MiniPanel.add(ButtonPanel);
        
        
        Login_Button.setPreferredSize(new Dimension(80, 20));
        Close_Button.setPreferredSize(new Dimension(80, 20));
        ButtonPanel.setBackground(new Color(43,31,80));
        ButtonPanel.setLayout(new FlowLayout());
        ButtonPanel.add(Login_Button);
        ButtonPanel.add(Close_Button);

        info_Label.setFont(new Font("Poppins", 1, 18)); // Consolas, Bold , 18pt
        info_Label.setForeground(Color.WHITE);

        UN_Label.setFont(new Font("Poppins", 0, 18));
        UN_Label.setForeground(Color.WHITE);
        UN_Label.setPreferredSize(new Dimension(100, 20));

        PW_Label.setFont(new Font("Poppins", 0, 18));
        PW_Label.setForeground(Color.WHITE);
        PW_Label.setPreferredSize(new Dimension(100, 20));


        Image_jLabel.setPreferredSize(new Dimension(683, 730));
        Image_jLabel.setIcon(new ImageIcon("LoginImage3.jpg"));

//        UN_TextField.setPreferredSize(new Dimension(200, 20));
//        Password_Field.setPreferredSize(new Dimension(200, 20));

        
//        MiniPanel.add(Login_Button);
//        MiniPanel.add(Close_Button);

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
//                        Runner.getFrame().dispose();
//                        Parent_JFrame frame = new Parent_JFrame();
//                        MainMenu menu = new MainMenu();
//                        JFrame mainFrame = Parent_JFrame.getMainFrame();
//                        JPanel mainPanel = menu.getMainPanel();
//                        mainFrame.add(menu.getMainPanel());
//                        mainFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid UserName/Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
        }
    }
}
