/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loonstrookcalc;

import database.DatabaseConnection;
import model.WorkHour;
import model.User;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import helpers.HelperFunctions;

/**
 *
 * @author Amar Tursic
 */
public class MainFrame extends javax.swing.JFrame {

    private DefaultTableModel myModel;
    private User user;

    public MainFrame() {
        initComponents();
        initializeFrame();
        myModel = (DefaultTableModel) workTimeTable.getModel();
        getDate();

        setUser();
    }

    private void initializeFrame() {
        for (double j = 1; j <= 80; j++) {
            urenCombo.addItem(j / 4);
        }
        int year = Calendar.getInstance().get(Calendar.YEAR) + 4;
        for (int i = 2013; i <= year; i++) {
            filterJaarCombo.addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            String month = Integer.toString(i);
            if (i < 10) {
                month = "0" + i;
            }
            filterMaandCombo.addItem(month);
        }
        nettoLoonField.setText("0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workTimeTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dayField = new javax.swing.JTextField();
        monthField = new javax.swing.JTextField();
        yearField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        urenCombo = new javax.swing.JComboBox();
        addWorkhours = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        factorBox = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        inkomstenMaand = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filterMaandCombo = new javax.swing.JComboBox();
        filterJaarCombo = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        brutoLoonField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nettoLoonField = new javax.swing.JTextField();
        opslaanButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        workTimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Datum", "Uren", "Euro (N)", "Factor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workTimeTable);
        workTimeTable.getColumnModel().getColumn(0).setResizable(false);
        workTimeTable.getColumnModel().getColumn(1).setMinWidth(60);
        workTimeTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        workTimeTable.getColumnModel().getColumn(1).setMaxWidth(60);
        workTimeTable.getColumnModel().getColumn(2).setMinWidth(80);
        workTimeTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        workTimeTable.getColumnModel().getColumn(2).setMaxWidth(0);
        workTimeTable.getColumnModel().getColumn(3).setMinWidth(70);
        workTimeTable.getColumnModel().getColumn(3).setPreferredWidth(70);
        workTimeTable.getColumnModel().getColumn(3).setMaxWidth(70);

        jLabel1.setText("Datum:");

        jLabel3.setText("Aantal uren gewerkt:");

        urenCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        addWorkhours.setText("Voeg toe");
        addWorkhours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkhoursActionPerformed(evt);
            }
        });

        jLabel8.setText("Loonfactor");

        factorBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200", "210", "220", "230", "240", "250", "260", "270", "280", "290", "300", "310", "320", "330", "340", "350" }));

        jLabel14.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(urenCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(factorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearField))
                    .addComponent(addWorkhours, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(urenCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(factorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(addWorkhours, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel4.setText("(Netto) Inkomsten deze maand:");

        inkomstenMaand.setText("€ 0,-");

        jLabel6.setText("Filter op maand:");

        jButton5.setText("Go");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inkomstenMaand))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterMaandCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filterJaarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inkomstenMaand))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(filterMaandCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterJaarCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Edit -->");

        jButton3.setText("Delete -->");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jTabbedPane1.addTab("Uren registratie", jPanel1);

        jLabel2.setText("Naam:");

        jLabel9.setText("Bruto uurloon:");

        jLabel10.setText("Netto uurloon:");

        opslaanButton.setText("Gegevens opslaan");
        opslaanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opslaanButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("€");

        jLabel12.setText("€");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("*Let erop dat alle bedragen die in het programma worden berekend indicaties zijn, en niet altijd zullen kloppen!");

        jLabel13.setText("*Optioneel, laat 0 staan als u het bedrag niet weet!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel9)
                        .addComponent(nameField)
                        .addComponent(brutoLoonField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nettoLoonField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addComponent(opslaanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(0, 240, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brutoLoonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nettoLoonField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(opslaanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Gebruikers Info", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opslaanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opslaanButtonActionPerformed
        // TODO add your handling code here:  
        try {
            if (nameField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "U heeft uw naam niet ingevuld");
            } else if (brutoLoonField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "U heeft uw bruto loon niet ingevuld");
            } else if (nettoLoonField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "U heeft uw netto loon niet ingevuld, laat 0 staan als u het niet weet.");
            } else if (HelperFunctions.convertToDouble(brutoLoonField.getText()) <= 0 || HelperFunctions.convertToDouble(nettoLoonField.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Vul A.U.B. een correct bedrag in.");
            } else {



                user = createUser();
                DatabaseConnection.insertUser(user);
                JOptionPane.showMessageDialog(null, "Uw gegevens zijn opgeslagen");


            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Voer alleen nummers in bij uw loon!");
        }

        //METHODE , naar . CONVERTEN!

    }//GEN-LAST:event_opslaanButtonActionPerformed

    private void addWorkhoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkhoursActionPerformed

        try {
            int dag = Integer.parseInt(dayField.getText());
            int maand = Integer.parseInt(monthField.getText());
            int jaar = Integer.parseInt(yearField.getText());
            double uren = HelperFunctions.convertToDouble(urenCombo.getSelectedItem().toString());
            int factor = Integer.parseInt(factorBox.getSelectedItem().toString());
            double euros = (uren * HelperFunctions.convertToDouble(nettoLoonField.getText()) / 100 * factor);

            if (monthGotCorrectValues(maand) && dayGotCorrectValues(dag)) {
                JOptionPane.showMessageDialog(null, "Voer een correcte datum in.");
            } else {
                WorkHour h = new WorkHour(dag, maand, jaar, uren, euros, factor);
                saveWorkHour(h);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Selecteer het aantal uur dat u heeft gewerkt.");
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "U heeft nog geen gebruiker aangemaakt!");
            jTabbedPane1.setSelectedIndex(1);
        }

    }//GEN-LAST:event_addWorkhoursActionPerformed

    private boolean monthGotCorrectValues(int maand) {
        return maand < 1 || maand > 12;
    }

    private boolean dayGotCorrectValues(int dag) {
        return dag < 1 || dag > 31;
    }

    private void saveWorkHour(WorkHour h) {
        if (DatabaseConnection.insertWorkHour(h)) {
            user.addWorkHour(h);
            urenCombo.setSelectedIndex(0);
            fillTable();
        } else {
            JOptionPane.showMessageDialog(null, "Er is iets misgegaan bij het opslaan");
        }
    }

    private void fillTable() {
        double euros = 0;
        myModel.setRowCount(0);

        for (WorkHour workhour : user.getWorkHours()) {
            myModel.addRow(new Object[]{createDate(workhour.getDay(), workhour.getMonth(), workhour.getYear()), workhour.getHours(), HelperFunctions.round(workhour.getEuro(), 2), workhour.getFactor()});
            euros += HelperFunctions.round(workhour.getEuro(), 2);
        }

        inkomstenMaand.setText("€ " + String.valueOf(euros));
    }

    public static String createDate(int dag, int maand, int jaar) {
        return createDateNotation(dag) + "-" + createDateNotation(maand) + "-" + jaar;
    }

    public static String createDateNotation(int date) {
        if (date < 10) {
            return "0" + date;
        }
        return String.valueOf(date);
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DatabaseConnection.openConnection();
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
                mf.setResizable(false);
                mf.setLocationRelativeTo(null);
            }
        });
    }

    private void setUser() {
         user = DatabaseConnection.getUser();
         if (user == null) {
             checkIfNewUser();
         }
         else {
             nameField.setText(user.getName());
             nettoLoonField.setText(String.valueOf(user.getNettoUurloon()));
             brutoLoonField.setText(String.valueOf(user.getBrutoUurloon()));
             opslaanButton.setEnabled(false);
             
         }
    }

    private User createUser() {

        if (HelperFunctions.convertToDouble(nettoLoonField.getText()) == 0) {
            double netto = HelperFunctions.round(HelperFunctions.convertToDouble(brutoLoonField.getText()) / 100 * 70, 2);
            String nettoEind = String.valueOf(netto);

            nettoLoonField.setText(nettoEind);
        }

        User user = new User(nameField.getText(), HelperFunctions.convertToDouble(brutoLoonField.getText()), HelperFunctions.convertToDouble(nettoLoonField.getText()));
        return user;
    }

    private void getDate() {
        Calendar cal = Calendar.getInstance();  // Create new calendar instance      
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //Create format for day : Day

        String date = dateFormat.format(cal.getTime());
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6, 10);

        dayField.setText(day);
        monthField.setText(month);
        yearField.setText(year);
    }

    private void checkIfNewUser() {
        new Thread(getTimer()).start();
    }

    private Runnable getTimer() {
        return new Runnable() {
            @Override
            public void run() {
                if (isNewUser()) {
                    firstTimeMessage();
                }
            }
        };
    }

    private boolean isNewUser() {
        return (nameField.getText().equals(""));
    }

    private void firstTimeMessage() {
        JOptionPane.showMessageDialog(null, "Welkom! Vul A.U.B. eerst uw informatie in.");
        jTabbedPane1.setSelectedIndex(1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWorkhours;
    private javax.swing.JTextField brutoLoonField;
    private javax.swing.JTextField dayField;
    private javax.swing.JComboBox factorBox;
    private javax.swing.JComboBox filterJaarCombo;
    private javax.swing.JComboBox filterMaandCombo;
    private javax.swing.JLabel inkomstenMaand;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField monthField;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nettoLoonField;
    private javax.swing.JButton opslaanButton;
    private javax.swing.JComboBox urenCombo;
    private javax.swing.JTable workTimeTable;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
