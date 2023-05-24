/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Problem;
import source.*;

/**
 *
 * @author supaschai
 */
public class ProblemView implements BeAbleWorkInMDI {

    private JPanel container = new SuComponent().getPanel(),
            borderPanel = new SuComponent().getPanel(),
            container2 = new SuComponent().getPanel(),
            container3 = new SuComponent().getPanel(),
            container4 = new SuComponent().getPanel(),
            container5 = new SuComponent().getPanel();
    private JLabel name = new SuComponent().getLabel("โจทย์", Theme.Heading),
            author = new SuComponent().getLabel("โจทย์โดย :  ", 10),
            rank = new SuComponent().getLabel("ระดับความยาก :  ", 10),
            itemMustKepp = new SuComponent().getLabel("จำนวนไอเทมทั้งหมดที่ต้องเก็บ :  ", 10);
    private JTextArea description = new SuComponent().getTextArea(6, 40, 12);

    private Problem pb;

    public ProblemView(Problem pb) {
        this.pb = pb;

        container.setLayout(new BorderLayout());
        container2.setLayout(new BorderLayout());
        container3.setLayout(new GridLayout(1, 3));

        borderPanel.setLayout(new BorderLayout());
        borderPanel.setBorder(new javax.swing.border.EmptyBorder(20, 20, 20, 20));

        name.setText(pb.getName());

        description.setText(AllTitle.title.get("Description") + "\n" + pb.getDescription());
        description.setEditable(false);
        description.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(description);
        scrollPane.setVisible(true);
        scrollPane.setBorder(Theme.RoundedBorder);

        author.setText(AllTitle.title.get("Problem by") + " : " + pb.getAuthor());
        itemMustKepp.setText(AllTitle.title.get("Count must keep item") + " : " + pb.getCountMustKeepItem());
        rank.setText(AllTitle.title.get("Rank") + " : ");

        container5.add(rank);
        container5.add(new SuComponent().renderBadgeRank(this.pb.getRank()) );

        container4.add(new Item());
        container4.add(itemMustKepp);

        container3.add(new SuComponent().getPanel(author));
        container3.add(container4);
        container3.add(container5);

        container2.add(name, BorderLayout.NORTH);
        container2.add(scrollPane);
        container2.add(container3, BorderLayout.SOUTH);
        borderPanel.add(container2);
        container.add(borderPanel);

    }

    @Override
    public JPanel getContainer() {
        return this.container;
    }

}
