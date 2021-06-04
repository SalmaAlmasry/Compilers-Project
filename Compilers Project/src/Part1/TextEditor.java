/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part1;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dalia
 */
public class TextEditor extends javax.swing.JFrame {
    private final JFileChooser openFileChooser;
    private BufferedReader file;
    /**
     * Creates new form TextEditor
     */
    public TextEditor() {
        initComponents();
        openFileChooser= new JFileChooser();
        openFileChooser.setCurrentDirectory(new File("F:\\Level 3"));
        openFileChooser.setFileFilter(new FileNameExtensionFilter("text files", "txt"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Editor = new javax.swing.JTextArea();
        Scan = new javax.swing.JButton();
        Browse = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Scanner #3");

        Editor.setColumns(20);
        Editor.setRows(5);
        jScrollPane1.setViewportView(Editor);

        Scan.setText("Scan");
        Scan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScanActionPerformed(evt);
            }
        });

        Browse.setText("Browse");
        Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(jTable1);

        errorLabel.setText("   ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(Scan, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 535, Short.MAX_VALUE)
                .addComponent(Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Scan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Browse, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScanActionPerformed
        // TODO add your handling code here:       
        try{
            PrintWriter outputStream =new PrintWriter("In.txt");//to write the text in the editor in a text file called In 
           
            String Text=Editor.getText();//get the text in string variable Text
            
            outputStream.print(Text);//to write the text in the text file
            outputStream.close();//close the output stream
            part1.Lexical_Analyser.main("In.txt");//pass the file  to lexical analyser            
            Table();//call table method to show output in the gui
        }catch(FileNotFoundException e){
            
        } catch (IOException ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        errorLabel.setText("Errors : "+part1.Lexical_Analyser.x );//display number of errors
       
    }//GEN-LAST:event_ScanActionPerformed

    private void BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseActionPerformed
       JFileChooser fs = new JFileChooser(new File("c:\\"));//default folder when openning a file will be c drive
       fs.setDialogTitle("Open a file");//title of the dialog page
       fs.setFileFilter(new FileNameExtensionFilter("Text file", "txt"));//filter file type to txt extension
       fs.setFileFilter(new FileNameExtensionFilter("Word file","doc"));//filter file type to doc extension
       fs.setFileFilter(new FileNameExtensionFilter("Word file", "docx"));//filter file type to docx extension
       int result = fs.showOpenDialog(null);//show the dialog frame
       if(result == JFileChooser.APPROVE_OPTION){// if it is approved
           try{
               File fi =fs.getSelectedFile();//put the selectef file in fi
               part1.Lexical_Analyser.main(fi.getPath());//give the path to the lexical analyser
               Table();//call table method to create table of the output  in the frame
           }catch(Exception e){
               
           }
      errorLabel.setText("Errors : "+part1.Lexical_Analyser.x );//display number of errors
       }
    
            
    }//GEN-LAST:event_BrowseActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditor().setVisible(true);
            }
        });
    }
    private void Table(){
        
        try { 
            File file=new File("output.txt");//make it read from output file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String[] columnsName = {"Line NO","Lexeme","Return Token","Lexeme NO in Line","Matchability"};//columns names array
            //jTable1.setModel(new DefaultTableModel(null,columnsName)); //to make a refreshed table and don't overwrite it
            DefaultTableModel model =(DefaultTableModel)jTable1.getModel();
            int rowsDelete=model.getRowCount();
            emptyTable(model,rowsDelete);
//            if(rowsDelete>0){
//                for(int i=rowsDelete-1;i>=0;i--){
//                model.removeRow(i);
//            }
//            }
            model.setColumnIdentifiers(columnsName);//set table headers            
            String [] rowData= new String[5];//array for row data
            Scanner scan = new Scanner(file);//scanner to scan the file line by line
            int lexemeNo=0;//counter for lexeme number in line
            while(scan.hasNextLine()){//while file still has lines
                String line=scan.nextLine().trim();//scan next line and put it in line string
                if(line.contains("Line")){//if the scanned 
                  String [] splitter =line.split("#");//split the line at # symbol
                  rowData[0]=splitter[1];  //put the number of line in first index of array
                  continue;
                }
                else if(line.contains("----------------")){
                    lexemeNo=0;//because it means we will start a new line
                    continue;
                }
                else if(line.isEmpty()){
                    continue;
                }
                else{
                    String [] splitter =line.split(":");//split line at : symbol to get lexeme and return token
                    rowData[1]=splitter[0];//put lexeme in the array 
                    rowData[2]=line.substring(line.indexOf(':') + 1);//put return token in the array
                    lexemeNo++;//increment lexeme number by one
                    rowData[3]= String.valueOf(lexemeNo);//put number of lexeme innline value in the array
                    rowData[4]="matched";
                    model.addRow(rowData);//add row in the table by array data
                }
                
                
            }
        } catch (Exception ex) {
            Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }
    private void emptyTable(DefaultTableModel model,int rowsDelete){
        if(rowsDelete>0){
                for(int i=rowsDelete-1;i>=0;i--){
                model.removeRow(i);
            }
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Browse;
    private javax.swing.JTextArea Editor;
    private javax.swing.JButton Scan;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
