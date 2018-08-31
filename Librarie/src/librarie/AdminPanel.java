/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarie;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author andrei
 */
public class AdminPanel extends javax.swing.JFrame {

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents(); 
        Show_Student();
        Show_Carte();
        //this.setLocationRelativeTo(null);
    } 
    
     public Connection getConnection()
   {
       Connection con;

       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost/librarie", "root","");
           return con;
       } 
      catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
     
     public ArrayList<student> studentsList()
   {
       ArrayList<student> lista = new ArrayList<student>();
       Connection connection = getConnection();
       String query = "SELECT * FROM  student ";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

           student student;

           while(rs.next())
           {
    student = new student(rs.getString("CNP"),rs.getString("NUME"),rs.getString("PRENUME"),rs.getInt("VARSTA"),rs.getString("TELEFON"));
               lista.add(student);
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return lista;
   }
    
       public void Show_Student()
   {
        ArrayList<student> list = studentsList();
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       Object[] row = new Object[10];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getCNP();
           row[1] = list.get(i).getNUME();
           row[2] = list.get(i).getPRENUME();
           row[3] = list.get(i).getVARSTA();
           row[4] = list.get(i).getTELEFON();

        
           model.addRow(row);
       }
    }
       
       
       
     public ArrayList<carte> booksList()
   {
       ArrayList<carte> lista = new ArrayList<carte>();
       Connection connection = getConnection();
       String query = "SELECT * FROM  carte ";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);

           carte carte;

           while(rs.next())
           {
    carte = new carte(rs.getInt("ID"),rs.getString("NUME"),rs.getString("AUTOR"),rs.getString("GEN"),rs.getString("DESCRIERE"));
               lista.add(carte);
           }

       } 
      catch (Exception e) {
           e.printStackTrace();
       }
       return lista;
   }
    
       public void Show_Carte()
   {
        ArrayList<carte> list = booksList();
       DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
       Object[] row = new Object[10];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getID();
           row[1] = list.get(i).getNUME();
           row[2] = list.get(i).getAUTOR();
           row[3] = list.get(i).getGEN();
           row[4] = list.get(i).getDESCRIERE();

        
           model.addRow(row);
       }
    }
       
    public void executeSQLQuery(String query, String message)
    {
        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
            if((st.executeUpdate(query)) == 1){
                JOptionPane.showMessageDialog(null, "Data "+message+" Successfully");
            } else {
                 JOptionPane.showMessageDialog(null, "Data Not "+message);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
   // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new keeptoo.KGradientPanel();
        TopPanel = new keeptoo.KGradientPanel();
        topLabel = new javax.swing.JLabel();
        StudentPanel = new keeptoo.KGradientPanel();
        studentLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        registerButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        SearchStudent = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CNPText = new javax.swing.JTextField();
        NUMEText = new javax.swing.JTextField();
        PRENUMEText = new javax.swing.JTextField();
        VARSTAText = new javax.swing.JTextField();
        TELText = new javax.swing.JTextField();
        BookPanel = new keeptoo.KGradientPanel();
        bookLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        registerbookButton = new javax.swing.JButton();
        editbookButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        IDCARTEText = new javax.swing.JTextField();
        NUMECARTEText = new javax.swing.JTextField();
        AUTORCARTEText = new javax.swing.JTextField();
        GENCARTEText = new javax.swing.JTextField();
        DESCRIERECARTEText = new javax.swing.JTextField();
        SearchBook = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        STATUSCARTEText = new javax.swing.JTextField();
        bottomPanel = new keeptoo.KGradientPanel();
        logout = new javax.swing.JLabel();
        account = new javax.swing.JLabel();
        logout1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setkEndColor(new java.awt.Color(197, 239, 247));
        Background.setkGradientFocus(90);
        Background.setkStartColor(new java.awt.Color(107, 185, 240));

        TopPanel.setkEndColor(new java.awt.Color(52, 73, 94));
        TopPanel.setkStartColor(new java.awt.Color(103, 128, 159));

        topLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        topLabel.setForeground(new java.awt.Color(228, 241, 254));
        topLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        topLabel.setText("Admin Panel");

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        StudentPanel.setkEndColor(new java.awt.Color(129, 207, 224));
        StudentPanel.setkGradientFocus(90);
        StudentPanel.setkStartColor(new java.awt.Color(44, 62, 80));

        studentLabel.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        studentLabel.setForeground(new java.awt.Color(228, 241, 254));
        studentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentLabel.setText("Student Management");

        registerButton.setText("Register a New Student");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit Student data");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete a Student record");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        SearchStudent.setText("Search a student");
        SearchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchStudentActionPerformed(evt);
            }
        });

        searchButton.setText("Search for a Student");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNP", "NUME", "PRENUME", "VARSTA", "TELEFONl"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jLabel1.setText("CNP");

        jLabel2.setText("NUME");

        jLabel3.setText("PRENUME");

        jLabel4.setText("VARSTA");

        jLabel5.setText("TELEFON");

        CNPText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNPTextActionPerformed(evt);
            }
        });

        NUMEText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUMETextActionPerformed(evt);
            }
        });

        PRENUMEText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRENUMETextActionPerformed(evt);
            }
        });

        VARSTAText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VARSTATextActionPerformed(evt);
            }
        });

        TELText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TELTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StudentPanelLayout = new javax.swing.GroupLayout(StudentPanel);
        StudentPanel.setLayout(StudentPanelLayout);
        StudentPanelLayout.setHorizontalGroup(
            StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(StudentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentPanelLayout.createSequentialGroup()
                        .addComponent(studentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentPanelLayout.createSequentialGroup()
                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(StudentPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(StudentPanelLayout.createSequentialGroup()
                                        .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(StudentPanelLayout.createSequentialGroup()
                                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(StudentPanelLayout.createSequentialGroup()
                                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(StudentPanelLayout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(StudentPanelLayout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CNPText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(NUMEText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PRENUMEText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(VARSTAText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TELText, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21))))
        );
        StudentPanelLayout.setVerticalGroup(
            StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelLayout.createSequentialGroup()
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(studentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(CNPText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NUMEText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(PRENUMEText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(VARSTAText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TELText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(StudentPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(324, 324, 324)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        BookPanel.setkEndColor(new java.awt.Color(129, 207, 224));
        BookPanel.setkGradientFocus(120);
        BookPanel.setkStartColor(new java.awt.Color(44, 62, 80));

        bookLabel.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        bookLabel.setForeground(new java.awt.Color(228, 241, 254));
        bookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bookLabel.setText("Book Management");

        registerbookButton.setText("Register a new Book");
        registerbookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbookButtonActionPerformed(evt);
            }
        });

        editbookButton.setText("Edit a Book data");
        editbookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbookButtonActionPerformed(evt);
            }
        });

        deleteBookButton.setText("Delete a Book record");
        deleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookButtonActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NUME", "AUTOR", "GEN", "DESCRIERE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        jLabel6.setText("ID");

        jLabel7.setText("NUME");

        jLabel8.setText("AUTOR");

        jLabel9.setText("GEN");

        jLabel10.setText("DESCRIERE");

        IDCARTEText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDCARTETextActionPerformed(evt);
            }
        });

        NUMECARTEText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NUMECARTETextActionPerformed(evt);
            }
        });

        AUTORCARTEText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AUTORCARTETextActionPerformed(evt);
            }
        });

        GENCARTEText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GENCARTETextActionPerformed(evt);
            }
        });

        DESCRIERECARTEText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DESCRIERECARTETextActionPerformed(evt);
            }
        });

        SearchBook.setText("Search a book");
        SearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBookActionPerformed(evt);
            }
        });

        jLabel11.setText("STATUS");

        STATUSCARTEText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STATUSCARTETextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BookPanelLayout = new javax.swing.GroupLayout(BookPanel);
        BookPanel.setLayout(BookPanelLayout);
        BookPanelLayout.setHorizontalGroup(
            BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookPanelLayout.createSequentialGroup()
                        .addComponent(bookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addGroup(BookPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookPanelLayout.createSequentialGroup()
                        .addComponent(editbookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(BookPanelLayout.createSequentialGroup()
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerbookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(BookPanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(10, 10, 10)
                                .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IDCARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NUMECARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AUTORCARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GENCARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DESCRIERECARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(STATUSCARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        BookPanelLayout.setVerticalGroup(
            BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BookPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(registerbookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editbookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(BookPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(IDCARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(NUMECARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(AUTORCARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(GENCARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(DESCRIERECARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(BookPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(STATUSCARTEText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(389, Short.MAX_VALUE))
        );

        bottomPanel.setkEndColor(new java.awt.Color(103, 128, 159));
        bottomPanel.setkStartColor(new java.awt.Color(52, 73, 94));

        logout.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        logout.setForeground(new java.awt.Color(246, 71, 71));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Log out");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });

        account.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        account.setForeground(new java.awt.Color(228, 241, 254));
        account.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account.setText("Account");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(StudentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BookPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addComponent(bottomPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StudentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BookPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 500));

        logout1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        logout1.setForeground(new java.awt.Color(246, 71, 71));
        logout1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout1.setText("Log out");
        logout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout1MouseClicked(evt);
            }
        });
        getContentPane().add(logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerbookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbookButtonActionPerformed
        // TODO add your handling code here:
        String query = "INSERT INTO `carte`(`ID`, `NUME`, `AUTOR`, `GEN`, `DESCRIERE`,`STATUS`) VALUES ('"+IDCARTEText.getText()+"' , '"+NUMECARTEText.getText()+"' , '"+AUTORCARTEText.getText()+"' , '"+GENCARTEText.getText()+"' , '"+DESCRIERECARTEText.getText()+"', '"+STATUSCARTEText.getText()+"') ";
        executeSQLQuery(query, "Inserted");
    }//GEN-LAST:event_registerbookButtonActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        this.setVisible(false);
        new AdminLogin().setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        String query = "INSERT INTO `student`(`CNP`, `NUME`, `PRENUME`, `VARSTA`, `TELEFON`) VALUES ('"+CNPText.getText()+"' , '"+NUMEText.getText()+"' , '"+PRENUMEText.getText()+"' , '"+VARSTAText.getText()+"' , '"+TELText.getText()+"')  ";

        executeSQLQuery(query, "Inserted");
    }//GEN-LAST:event_registerButtonActionPerformed

    private void CNPTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNPTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNPTextActionPerformed

    private void NUMETextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUMETextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NUMETextActionPerformed

    private void PRENUMETextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRENUMETextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRENUMETextActionPerformed

    private void VARSTATextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VARSTATextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VARSTATextActionPerformed

    private void TELTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TELTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TELTextActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         // Afisare date rand in text fields
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        CNPText.setText(model.getValueAt(i,0).toString());
        NUMEText.setText(model.getValueAt(i,1).toString());
        PRENUMEText.setText(model.getValueAt(i,2).toString());
        VARSTAText.setText(model.getValueAt(i,3).toString());
        TELText.setText(model.getValueAt(i,4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        String query = "UPDATE `student` SET `NUME`='"+NUMEText.getText()+"' , `PRENUME`='"+PRENUMEText.getText()+"', `VARSTA`='"+VARSTAText.getText()+"', `TELEFON`='"+TELText.getText()+"'  WHERE `CNP`='"+CNPText.getText()+"' ";
        executeSQLQuery(query, "Updated");
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        String query = "DELETE FROM `student` WHERE `CNP` = '"+CNPText.getText()+"' ";
        executeSQLQuery(query, "Deleted");
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int i = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();
        IDCARTEText.setText(model.getValueAt(i,0).toString());
        NUMECARTEText.setText(model.getValueAt(i,1).toString());
        AUTORCARTEText.setText(model.getValueAt(i,2).toString());
        GENCARTEText.setText(model.getValueAt(i,3).toString());
        DESCRIERECARTEText.setText(model.getValueAt(i,4).toString());
    }//GEN-LAST:event_jTable2MouseClicked

    private void IDCARTETextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDCARTETextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDCARTETextActionPerformed

    private void NUMECARTETextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NUMECARTETextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NUMECARTETextActionPerformed

    private void AUTORCARTETextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUTORCARTETextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AUTORCARTETextActionPerformed

    private void GENCARTETextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GENCARTETextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GENCARTETextActionPerformed

    private void DESCRIERECARTETextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DESCRIERECARTETextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DESCRIERECARTETextActionPerformed

    private void editbookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbookButtonActionPerformed
        // TODO add your handling code here:
         String query = "UPDATE `carte` SET `NUME`='"+NUMECARTEText.getText()+"' , `AUTOR`='"+AUTORCARTEText.getText()+"', `GEN`='"+GENCARTEText.getText()+"', `DESCRIERE`='"+DESCRIERECARTEText.getText()+"' , `STATUS`='"+STATUSCARTEText.getText()+"'  WHERE `ID`='"+IDCARTEText.getText()+"' ";
        executeSQLQuery(query, "Updated");
    }//GEN-LAST:event_editbookButtonActionPerformed

    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        // TODO add your handling code here:
        String query = "DELETE FROM `carte` WHERE `ID` = '"+IDCARTEText.getText()+"' ";
        executeSQLQuery(query, "Deleted");
    }//GEN-LAST:event_deleteBookButtonActionPerformed

    private void SearchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchStudentActionPerformed
        // TODO add your handling code here:
        
         int ok = 0;
         
        TableModel model = jTable1.getModel();
        int nr = model.getRowCount();
        for(int i = 0; i<nr;i++){
            if(CNPText.getText().equals(model.getValueAt(i,0).toString()) || NUMEText.getText().equals(model.getValueAt(i,1).toString())){
                ok = 1;
                NUMEText.setText(model.getValueAt(i,1).toString());
                PRENUMEText.setText(model.getValueAt(i,2).toString());
                VARSTAText.setText(model.getValueAt(i,3).toString());
                TELText.setText(model.getValueAt(i,4).toString());
            }
        }
        
        if(ok == 0){
            JOptionPane.showMessageDialog(null, "The student is not in the list");
        }
    }//GEN-LAST:event_SearchStudentActionPerformed

    private void SearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBookActionPerformed
        // TODO add your handling code here:
         int ok = 0;
         
        TableModel model = jTable2.getModel();
        int nr = model.getRowCount();
        for(int i = 0; i<nr;i++){
            if(NUMECARTEText.getText().equals(model.getValueAt(i,1).toString()) || AUTORCARTEText.getText().equals(model.getValueAt(i,2).toString())){
                ok = 1;
                NUMECARTEText.setText(model.getValueAt(i,1).toString());
                AUTORCARTEText.setText(model.getValueAt(i,2).toString());
                GENCARTEText.setText(model.getValueAt(i,3).toString());
                DESCRIERECARTEText.setText(model.getValueAt(i,4).toString());
                STATUSCARTEText.setText(model.getValueAt(i,5).toString());
            }
        }
        
        if(ok == 0){
            JOptionPane.showMessageDialog(null, "The student is not in the list");
        }
    }//GEN-LAST:event_SearchBookActionPerformed

    private void STATUSCARTETextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STATUSCARTETextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_STATUSCARTETextActionPerformed

    private void logout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout1MouseClicked
        this.setVisible(false);
        new StudentLogin().setVisible(true);
    }//GEN-LAST:event_logout1MouseClicked
 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AUTORCARTEText;
    private keeptoo.KGradientPanel Background;
    private keeptoo.KGradientPanel BookPanel;
    private javax.swing.JTextField CNPText;
    private javax.swing.JTextField DESCRIERECARTEText;
    private javax.swing.JTextField GENCARTEText;
    private javax.swing.JTextField IDCARTEText;
    private javax.swing.JTextField NUMECARTEText;
    private javax.swing.JTextField NUMEText;
    private javax.swing.JTextField PRENUMEText;
    private javax.swing.JTextField STATUSCARTEText;
    private javax.swing.JButton SearchBook;
    private javax.swing.JButton SearchStudent;
    private keeptoo.KGradientPanel StudentPanel;
    private javax.swing.JTextField TELText;
    private keeptoo.KGradientPanel TopPanel;
    private javax.swing.JTextField VARSTAText;
    private javax.swing.JLabel account;
    private javax.swing.JLabel bookLabel;
    private keeptoo.KGradientPanel bottomPanel;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editbookButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logout1;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton registerbookButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JLabel topLabel;
    // End of variables declaration//GEN-END:variables
}
