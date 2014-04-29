/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Write a description of class ExampleGUIOne here.
 * 
 * @author Chris
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.event.*;

public class ExampleGUIOne extends JFrame {

    /**
     * Constructor for objects of class ExampleGUIOne
     */
    private final int WINDOW_WIDTH = 320;
    private final int WINDOW_HEIGHT = 150;
    private JPanel listPanel;
    private JPanel instructionsPanel;
    private JPanel resultsPanel;
    private JList planetList;
    private JTextField earthWeight;
    private JLabel instructions;
    private JLabel earthLabel;
    private JLabel otherPlanetLabel;
    private JLabel selectedPlanet;
    private JTextField weightElseWhere;
    private JTextField weightOnEarth;
    private String[] planets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter",
        "Saturn", "Uranus", "Neptune", "Pluto"};

    public ExampleGUIOne() {

        super("Fun with Weights");

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.setSize(500, 300);

        instructions = new JLabel("Enter a Weight Below, then select a " +
                "planet from the list");

        this.add(instructions, BorderLayout.NORTH);
        buildListPanel();
        this.add(listPanel, BorderLayout.CENTER);
        buildResultsPanel();

        this.add(resultsPanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);

    } // end constructor

    private void buildListPanel() {
        listPanel = new JPanel();
        listPanel.setBackground(Color.BLUE);

        planetList = new JList(planets);
        planetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        planetList.addListSelectionListener(new ListListener());

        listPanel.add(planetList);
    } // end buildListPanel()

    private void buildResultsPanel() {
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new FlowLayout());
        resultsPanel.setBackground(Color.CYAN);
        resultsPanel.setSize(400, 300);

        earthLabel = new JLabel("Enter the wieght on Earth");
        resultsPanel.add(earthLabel);

        weightOnEarth = new JTextField(5);
        resultsPanel.add(weightOnEarth);

        selectedPlanet = new JLabel();
        resultsPanel.add(selectedPlanet);

        weightElseWhere = new JTextField(5);
        weightElseWhere.setEditable(false);

        resultsPanel.add(weightElseWhere);

    } // end buildResultsPanel()

    public void valuesChanged(ListSelectionEvent e) {
        double otherWeight = 0;
        String planet = (String) planetList.getSelectedValue();
        double earthWeight = Double.parseDouble(weightOnEarth.getText());
        selectedPlanet.setText("Weight on " + planet);

        switch (planet) {
            case "Mercury":
                otherWeight = earthWeight * .38;
                break;
            case "Venus":
                otherWeight = earthWeight * .91;
                break;
            case "Mars":
                otherWeight = earthWeight * .38;
                break;
            case "Jupiter":
                otherWeight = earthWeight * 2.34;
                break;
            case "Saturn":
                otherWeight = earthWeight * 1.06;
                break;
            case "Uranus":
                otherWeight = earthWeight * .92;
                break;
            case "Neptune":
                otherWeight = earthWeight * 1.19;
                break;
            case "Pluto":
                otherWeight = earthWeight * .06;
                break;
            case "Earth":
                otherWeight = earthWeight;
        } // end switch
        weightElseWhere.setText("" + otherWeight);
    } // end valuesChanged(ListSelectionEvent e)
}
