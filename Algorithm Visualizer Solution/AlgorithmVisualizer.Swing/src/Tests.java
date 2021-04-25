package test;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Tests implements ActionListener {
    private int count = 0;
    private JLabel label0, label2, label3, label4, label5, label6, label7, label8;

    private JFrame frame;
    private JPanel panel;
    private JTextField jTextField;

    public Tests() {

        frame = new JFrame("Panel Example");
        panel = new JPanel();
        // panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        label0 = new JLabel("Learning Algorithms :)");
        label0.setBounds(200, 20, 400, 30);//not working yet
        label0.setForeground(Color.white);
        label0.setBackground(Color.black);
        label0.setOpaque(true);
        label0.setFont(new Font("L A", Font.BOLD, 25));

        label2 = new JLabel("Making learning algorithms fun");
        label2.setBounds(250, 60, 400, 30);//not working yet
        label2.setForeground(Color.white);
        label2.setBackground(Color.black);
        label2.setOpaque(true);
        label2.setFont(new Font("L A", Font.BOLD, 15));

        label3 = new JLabel("TYPE YOUR DATASET IN..");
        label3.setBounds(50, 100, 400, 30);//not working yet
        label3.setForeground(Color.white);
        label3.setBackground(Color.black);
        label3.setOpaque(true);
        label3.setFont(new Font("L A", Font.BOLD, 15));

        label4 = new JLabel("For Example:1,2,3,4,5");
        label4.setBounds(50, 140, 400, 30);//not working yet
        label4.setForeground(Color.white);
        label4.setBackground(Color.black);
        label4.setOpaque(true);
        label4.setFont(new Font("L A", Font.BOLD, 15));


        jTextField = new JTextField();
        jTextField.setBackground(Color.white);
        jTextField.setBounds(50, 190, 600, 40);
        jTextField.setForeground(Color.black);
        jTextField.setFont(new Font("L A", Font.BOLD, 15));

        label5 = new JLabel("PLEASE SELECT A SORTING  ALGORITHM TO LEARN");
        label5.setBounds(150, 235, 500, 30);//not working yet
        label5.setForeground(Color.white);
        label5.setBackground(Color.black);
        label5.setOpaque(true);
        label5.setFont(new Font("L A", Font.BOLD, 15));

        label6 = new JLabel("You can type your DATASETS in and select an algorithim to learn");
        label6.setBounds(150, 270, 500, 30);//not working yet
        label6.setForeground(Color.white);
        label6.setBackground(Color.black);
        label6.setOpaque(true);
        label6.setFont(new Font("L A", Font.BOLD, 15));

        label7 = new JLabel("OR");
        label7.setBounds(300, 310, 40, 30);//not working yet
        label7.setForeground(Color.white);
        label7.setBackground(Color.black);
        label7.setOpaque(true);
        label7.setFont(new Font("L A", Font.BOLD, 20));

        label8 = new JLabel("Select One of the Algorithim to see how it works");
        label8.setBounds(200, 350, 350, 30);//not working yet
        label8.setForeground(Color.white);
        label8.setBackground(Color.black);
        label8.setOpaque(true);
        label8.setFont(new Font("L A", Font.BOLD, 15));


        JButton btnBubbleSorting = new JButton("Bubble Sort");
        btnBubbleSorting.setBackground(Color.black);
        btnBubbleSorting.setBounds(50, 390, 150, 40);
        btnBubbleSorting.setForeground(Color.black);
        btnBubbleSorting.setBackground(Color.white);
        btnBubbleSorting.setOpaque(true);
        btnBubbleSorting.setFont(new Font("L A", Font.BOLD, 15));
        frame.getContentPane().add(btnBubbleSorting, BorderLayout.WEST);
        btnBubbleSorting.addActionListener(this);


        JButton linkedlist = new JButton("Linked List ");
        linkedlist.setBackground(Color.black);
        linkedlist.setBounds(300, 390, 150, 40);
        linkedlist.setForeground(Color.black);
        linkedlist.setBackground(Color.white);
        linkedlist.setOpaque(true);
        linkedlist.setFont(new Font("L A", Font.BOLD, 15));
        frame.getContentPane().add(linkedlist, BorderLayout.WEST);
        linkedlist.addActionListener(this);


        JButton btnInsertionSorting = new JButton("Insertion Sort");
        btnInsertionSorting.setBackground(Color.white);
        btnInsertionSorting.setBounds(550, 390, 150, 40);
        btnInsertionSorting.setForeground(Color.black);
        btnInsertionSorting.setOpaque(true);
        btnInsertionSorting.setFont(new Font("L A", Font.BOLD, 15));
        frame.getContentPane().add(btnInsertionSorting, BorderLayout.WEST);
        btnInsertionSorting.addActionListener(this);


        panel.setBounds(0, 80, 800, 400);
        panel.setBackground(Color.black);
        //panel.add(label0);

        //frame.add(panel);

        frame.add(label0);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(jTextField);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);
        frame.add(label8);
        frame.add(btnBubbleSorting);
        frame.add(linkedlist);
        frame.add(btnInsertionSorting);
        frame.getContentPane().setBackground(Color.black);
        frame.setBackground(Color.black);
        frame.setSize(800, 700);
        frame.setLayout(null);
        frame.setVisible(true);


    }


    public static void main(String[] args) {
        new Tests();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        jTextField.setText("count" + count);
    }
}
