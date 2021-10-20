import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Calculator{

 private JFrame framecalc;
 private JTextField UppertextField;
 private JTextField LowertextField;
 
 String resultText, triggerOn= "on";
 double btnTrigNum=0;
 double result, initial;
 String tempAnswer, firstNum=null, nextNum=null, operand=null;
 double secondFactor=0, x, y;
 String operationFunction=null, originalText;
 boolean triggeropsBtn;

 /**
  * Launch the application.
  */
 public static void main(String[] args) {
  EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     Calculator window = new Calculator();
     window.framecalc.setVisible(true);
    } catch (Exception e) {
     e.printStackTrace();
    }
   }
  });
 }

 /**
  * Create the application.
  */
 public Calculator() {
  initialize();
 }

 /**
  * Initialize the contents of the frame.
  */
 private void initialize() {
  framecalc = new JFrame();
  framecalc.setBounds(100, 100, 309, 480);
  framecalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  framecalc.getContentPane().setLayout(null);
  
  JMenuItem mntmNewMenuItem = new JMenuItem("File");
  mntmNewMenuItem.setBounds(10, 0, 60, 22);
  framecalc.getContentPane().add(mntmNewMenuItem);
  
  JMenuItem mntmNewMenuItem_1 = new JMenuItem("Help");
  mntmNewMenuItem_1.setBounds(66, 0, 69, 22);
  framecalc.getContentPane().add(mntmNewMenuItem_1);
  
  UppertextField = new JTextField();
  UppertextField.setEditable(false);
  UppertextField.setBounds(32, 46, 211, 20);
  framecalc.getContentPane().add(UppertextField);
  UppertextField.setColumns(10);
  
  LowertextField = new JTextField();
  LowertextField.setBounds(32, 64, 211, 29);
  framecalc.getContentPane().add(LowertextField);
  LowertextField.setColumns(10);
  
  JButton btnNewButton = new JButton("C");
  btnNewButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    UppertextField.setText(null);
    LowertextField.setText(null);
    result = 0;
    firstNum =null;
    nextNum=null;
    operand = null;
    operationFunction = null;
    triggerOn = "on";
   }
  });
  btnNewButton.setBounds(75, 114, 46, 38);
  framecalc.getContentPane().add(btnNewButton);
  
  JButton btnCe = new JButton("CE");
  btnCe.setFont(new Font("Tahoma", Font.PLAIN, 8));
  btnCe.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    LowertextField.setText(null);
   }
  });
  btnCe.setBounds(128, 114, 46, 38);
  framecalc.getContentPane().add(btnCe);
  
  JButton button = new JButton("+");
  button.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    StringBuilder changeOps = new StringBuilder(UppertextField.getText());
    if (changeOps.length() !=0 && operationFunction!= "add"){
     changeOps.replace(changeOps.length()-1, changeOps.length(), "");
     changeOps.toString();  
   
    }
 
  operationFunction = "add";
           
  while ("on".equals(operand) || operationFunction != "add"){
   
   
   if (firstNum == null){
   
   firstNum = LowertextField.getText();
   UppertextField.setText(UppertextField.getText()+ LowertextField.getText()+ "+");
    
   triggerOn = "off";
        
   }else{
   
   nextNum = tempAnswer;
   UppertextField.setText(String.valueOf(changeOps)+ LowertextField.getText()+ "+");
   LowertextField.setText(String.valueOf(result));
   firstNum = String.valueOf(result);
   triggerOn = "off";
   
  }
  operand = "off";
  }
   }
  });
  button.setBounds(182, 114, 46, 68);
  framecalc.getContentPane().add(button);
  
  JButton button_1 = new JButton("-");
  button_1.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    StringBuilder changeOps = new StringBuilder(UppertextField.getText());
    if (changeOps.length() !=0 && operationFunction!= "subtract"){
     changeOps.replace(changeOps.length()-1, changeOps.length(), "");
     changeOps.toString();  
     UppertextField.setText(String.valueOf(changeOps));
    }
    
    operationFunction = "subtract";
           
    while ("on".equals(operand) || operationFunction != "subtract"){
    
    if (firstNum == null){
     
     firstNum = tempAnswer;
     UppertextField.setText(UppertextField.getText()+ LowertextField.getText()+ "-");
     triggerOn = "off";
     
    }else{
     
     nextNum = tempAnswer;
     UppertextField.setText(UppertextField.getText()+ LowertextField.getText()+ "-");
     LowertextField.setText(String.valueOf(result));
     firstNum = String.valueOf(result);
     triggerOn = "off";
     
    }
    operand = "off";
    }
   }
  });
  button_1.setBounds(238, 114, 46, 68);
  framecalc.getContentPane().add(button_1);
  
  JButton button_2 = new JButton("*");
  button_2.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    StringBuilder changeOps = new StringBuilder(UppertextField.getText());
    if (changeOps.length() !=0 && operationFunction!= "multiply"){
    changeOps.replace(changeOps.length()-2, changeOps.length(), "*");
    changeOps.toString();  
    UppertextField.setText(String.valueOf(changeOps));
    }
    
    operationFunction = "multiply";
           
    while ("on".equals(operand) || operationFunction != "multiply"){
    
    if (firstNum == null){
     
     firstNum = tempAnswer;
     UppertextField.setText(UppertextField.getText()+ LowertextField.getText()+ "*");
     triggerOn = "off";
     
    }else{
     
     nextNum = tempAnswer;
     UppertextField.setText(UppertextField.getText()+ LowertextField.getText()+ "*");
        
     LowertextField.setText(String.valueOf(result));
     firstNum = String.valueOf(result);
     triggerOn = "off";
     
    }
    operand = "off";
    }
   }
  });
  button_2.setBounds(182, 186, 46, 68);
  framecalc.getContentPane().add(button_2);
  
  JButton button_3 = new JButton("/");
  button_3.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    StringBuilder changeOps = new StringBuilder(UppertextField.getText());
    if (changeOps.length() !=0 && operationFunction!= "divide"){
    changeOps.replace(changeOps.length()-2, changeOps.length(), "/");
    changeOps.toString();  
    UppertextField.setText(String.valueOf(changeOps));
    }
    
    operationFunction = "divide";
    
    while ("on".equals(operand) || operationFunction != "divide"){
    
    if (firstNum == null){
     
     firstNum = tempAnswer;
     UppertextField.setText(UppertextField.getText()+ LowertextField.getText()+ "/");
     triggerOn = "off";
     
    }else{
     
     nextNum = tempAnswer;
     UppertextField.setText(UppertextField.getText()+ LowertextField.getText()+ "/");
        
     LowertextField.setText(String.valueOf(result));
     firstNum = String.valueOf(result);
     triggerOn = "off";
     
    }
    operand = "off";
    }
   }
  });
  button_3.setBounds(238, 186, 46, 68);
  framecalc.getContentPane().add(button_3);
  
  JButton button_4 = new JButton("7");
  button_4.addActionListener(new ActionListener() {
   
    public void keyPressed(KeyEvent arg0) {
     if ("off".equals(triggerOn)) {
      LowertextField.setText("7");
      triggerOn = "on";
      tempAnswer = LowertextField.getText();
      
     }else{
      LowertextField.setText(LowertextField.getText()+ button_4.getText());
      tempAnswer = LowertextField.getText();
      
     }
     if ("add".equals(operationFunction)){
      result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
     }else if ("multiply".equals(operationFunction)){
      result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
     }else if ("subtract".equals(operationFunction)){
      result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
     }else if ("divide".equals(operationFunction)){
      result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
     }
     operand = "on";
   }

 {
     
     
    }

@Override
 // TODO Auto-generated method stubbtn7.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
  if ("off".equals(triggerOn)) {
   LowertextField.setText("7");
   triggerOn = "on";
   tempAnswer = LowertextField.getText();
   
  }else{
   LowertextField.setText(LowertextField.getText()+ button_4.getText());
   tempAnswer = LowertextField.getText();
   
  }
  if ("add".equals(operationFunction)){
   result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
  }else if ("multiply".equals(operationFunction)){
   result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
  }else if ("subtract".equals(operationFunction)){
   result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
  }else if ("divide".equals(operationFunction)){
   result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
  }
  operand = "on";
 }
});
 
  button_4.setBounds(10, 166, 46, 50);
  framecalc.getContentPane().add(button_4);
  
  JButton button_5 = new JButton("8");
  button_5.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("8");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_5.getText());
     tempAnswer = LowertextField.getText();
     
    }
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_5.setBounds(66, 166, 46, 50);
  framecalc.getContentPane().add(button_5);
  
  JButton button_6 = new JButton("9");
  button_6.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("9");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_6.getText());
     tempAnswer = LowertextField.getText();
     
    }
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_6.setBounds(122, 166, 46, 50);
  framecalc.getContentPane().add(button_6);
  
  JButton button_7 = new JButton("4");
  button_7.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("4");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_7.getText());
     tempAnswer = LowertextField.getText();
     
    }
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum) * Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum) / Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_7.setBounds(10, 227, 46, 50);
  framecalc.getContentPane().add(button_7);
  
  JButton button_8 = new JButton("5");
  button_8.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("5");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_8.getText());
     tempAnswer = LowertextField.getText();
     
    }
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_8.setBounds(66, 227, 46, 50);
  framecalc.getContentPane().add(button_8);
  
  JButton button_9 = new JButton("6");
  button_9.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("6");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_9.getText());
     tempAnswer = LowertextField.getText();
     
    }
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_9.setBounds(122, 227, 46, 50);
  framecalc.getContentPane().add(button_9);
  
  JButton button_10 = new JButton("3");
  button_10.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("3");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_10.getText());
     tempAnswer = LowertextField.getText();
     
    }
    
  
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_10.setBounds(10, 288, 46, 50);
  framecalc.getContentPane().add(button_10);
  
  JButton button_11 = new JButton("2");
  button_11.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("2");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_11.getText());
     tempAnswer = LowertextField.getText();
     
    }
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_11.setBounds(66, 288, 46, 50);
  framecalc.getContentPane().add(button_11);
  
  JButton button_12 = new JButton("1");
  button_12.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("1");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_12.getText());
     tempAnswer = LowertextField.getText();
     
    }
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_12.setBounds(122, 288, 46, 50);
  framecalc.getContentPane().add(button_12);
  
  JButton button_13 = new JButton("0");
  button_13.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if ("off".equals(triggerOn)) {
     LowertextField.setText("0");
     triggerOn = "on";
     tempAnswer = LowertextField.getText();
     
    }else{
     LowertextField.setText(LowertextField.getText()+ button_13.getText());
     tempAnswer = LowertextField.getText();
     
    }
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(firstNum) + Double.parseDouble(tempAnswer); 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(firstNum)* Double.parseDouble(tempAnswer);
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(firstNum)-Double.parseDouble(tempAnswer);
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(firstNum)/Double.parseDouble(tempAnswer);
    }
    operand = "on";
   }
  });
  button_13.setBounds(10, 349, 46, 50);
  framecalc.getContentPane().add(button_13);
  
  JButton button_14 = new JButton("%");
  button_14.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    tempAnswer = LowertextField.getText();
    double prcntNum = (Double.parseDouble(tempAnswer) /100) * Double.parseDouble(tempAnswer);
    LowertextField.setText(String.valueOf(prcntNum));
    if ("add".equals(operationFunction)){
     result = Double.parseDouble(tempAnswer) + prcntNum; 
    }else if ("multiply".equals(operationFunction)){
     result = Double.parseDouble(tempAnswer)* prcntNum;
    }else if ("subtract".equals(operationFunction)){
     result = Double.parseDouble(tempAnswer)- prcntNum;
    }else if ("divide".equals(operationFunction)){
     result = Double.parseDouble(tempAnswer) / prcntNum;
    }
    triggerOn="off";
    operationFunction =null;
    operand = "on";
    tempAnswer= "";
   }
  });
  button_14.setBounds(66, 349, 46, 50);
  framecalc.getContentPane().add(button_14);
  
  JButton button_15 = new JButton(".");
  button_15.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    
   }
  });
  button_15.setBounds(122, 349, 46, 50);
  framecalc.getContentPane().add(button_15);
  
  JButton button_16 = new JButton("\u00B1");
  button_16.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    tempAnswer = LowertextField.getText();
    double negateNum = Double.parseDouble(tempAnswer) * (-1);
    LowertextField.setText(String.valueOf(negateNum));
    triggerOn="off";
    operationFunction =null;
    operand = "on";
   }
  });
  button_16.setBounds(182, 260, 46, 50);
  framecalc.getContentPane().add(button_16);
  
  JButton button_17 = new JButton("\u221A");
  button_17.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    tempAnswer = LowertextField.getText();
    double sqrtNum = Math.sqrt(Double.parseDouble(tempAnswer));
    UppertextField.setText(UppertextField.getText()+ LowertextField.getText()+ "\u221A"+"(" + tempAnswer + ")");
    LowertextField.setText(String.valueOf(sqrtNum));
    
   }
  });
  button_17.setBounds(238, 260, 46, 50);
  framecalc.getContentPane().add(button_17);
  
  JButton btnX = new JButton("\u03C72 ");
  btnX.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    result =Double.parseDouble(LowertextField.getText()) * Double.parseDouble(LowertextField.getText());
    UppertextField.setText("sqr" + "("+ LowertextField.getText() + ")");
    LowertextField.setText(String.valueOf(result));
    triggerOn="off";
  
   }
  });
  btnX.setFont(new Font("Tahoma", Font.PLAIN, 8));
  btnX.setBounds(182, 316, 46, 50);
  framecalc.getContentPane().add(btnX);
  
  JButton btnx = new JButton("1/x");
  btnx.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    Double recip = 1 / Double.parseDouble(LowertextField.getText());
    UppertextField.setText("1" + "("+ LowertextField.getText() + ")");
    LowertextField.setText(String.valueOf(recip));
    triggerOn="off";
  
   }
  });
  btnx.setFont(new Font("Tahoma", Font.PLAIN, 8));
  btnx.setBounds(238, 316, 46, 50);
  framecalc.getContentPane().add(btnx);
  
  JButton button_18 = new JButton("=");
  button_18.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    UppertextField.setText("");
    LowertextField.setText(String.valueOf(result));
    firstNum =null; 
    triggerOn="off";
    operationFunction =null;
    operand = "on";
    tempAnswer= "";
         
    
    
   }
  });
  button_18.setFont(new Font("Tahoma", Font.PLAIN, 10));
  button_18.setBounds(182, 370, 102, 29);
  framecalc.getContentPane().add(button_18);
 }
}
