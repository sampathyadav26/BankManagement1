package com.example;

import java.io.*;

class Bank {
  
  final int max_limit = 20;
  final int min_limit = 1;
  final double min_bal = 500;

  private String name[] = new String[20];
  private int accNo[] = new int[20];
  private String accType[] = new String[20];
  private double balamount[] = new double[20];

  static int totRec = 0;

  
  Bank() {
    for (int i = 0; i < max_limit; i++) {
      name[i] = "";
      accNo[i] = 0;
      accType[i] = "";
      balamount[i] = 0.0;
    }
  }

  
  public void newEntry() {
    String str;

    int account;
    double amount;
    boolean permit;
    permit = true;

    if (totRec > max_limit) {
      System.out.println("\n\n\nSorry we cannot admit you in our bank...\n\n\n");
      permit = false;
    }

    
    if (permit = true) {
      totRec++;

                    
      System.out.println("\n\n\n=====SAVING NEW ENTRY=====");
      try {
        accNo[totRec] = totRec; 
        System.out.println("Account Number :  " + accNo[totRec]);

        
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

        
        System.out.print("Enter the name of the Customer : ");
        System.out.flush();

        name[totRec] = obj.readLine();

        
        System.out.print("Enter Account Type : ");
        System.out.flush();

        accType[totRec] = obj.readLine();
        do {
         
          System.out.print("Enter Initial  Amount to be deposited : ");
          System.out.flush();
          str = obj.readLine();

          balamount[totRec] = Double.parseDouble(str);
        }
        while (balamount[totRec] < min_bal);

        System.out.println("\n\n\n");
      } catch (Exception e) {
        System.out.println("Exception in Entering a record.....");
      }
    }
  }

  
  public void display() {
    String str;
    int account = 0;
    boolean valid = true;

    System.out.println("\n\n=====DISPLAYING THE RECORDS=====\n");
    try {
      
      BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

      
      System.out.print("Enter the account number for display record : ");
      System.out.flush();

      str = obj.readLine();
      account = Integer.parseInt(str);

     
      if (account < min_limit || account > totRec) {
        System.out.println("\n\n\nInvalid Account Number \n\n");
        valid = false;
      }

      if (valid == true) {
        System.out.println("\n\nAccount Number : " + accNo[account]);
        System.out.println("Name : " + name[account]);
        System.out.println("Account Type : " + accType[account]);
        System.out.println("Balance Amount : " + balamount[account] + "\n\n\n");
      }
    } catch (Exception e) {
      System.out.println("Exception in Displaying record.....");
    }
  }

  // create method to deposit amount.
  public void deposit() {
    String str;
    double amount;
    int account;
    boolean valid = true;
    System.out.println("\n\n\n=====DEPOSIT AMOUNT=====");

    try {
      // create object.
      BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

      System.out.print("Enter Account No : ");
      System.out.flush();

      str = obj.readLine();
      account = Integer.parseInt(str);

      // check valid account number.
      if (account < min_limit || account > totRec) {
        System.out.println("\n\n\nInvalid Account Number \n\n");
        valid = false;
      }

      if (valid == true) {
        System.out.print("Enter Amount you want to Deposit  : ");
        System.out.flush();

        str = obj.readLine();
        amount = Double.parseDouble(str);

        balamount[account] = balamount[account] + amount;

        //Displaying Depsit Details
        System.out.println("\nAfter Updation...");
        System.out.println("Account Number :  " + account);
        System.out.println("Balance Amount :  " + balamount[account] + "\n\n\n");
      }
    } catch (Exception e) {
      System.out.println("Exception in Depositing record.....");
    }
  }

  
  public void withdraw() {
    String str;

    double amount, checkamount;
    int account;
    boolean valid = true;

    System.out.println("\n\n\n=====WITHDRAW MONEY=====");
    try {
      
      BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

      
      System.out.print("Enter the account number to deposit money : ");
      System.out.flush();

      str = obj.readLine();
      account = Integer.parseInt(str);

      
      if (account < min_limit || account > totRec) {
        System.out.println("\n\n\nInvalid Account Number \n\n");
        valid = false;
      }

      if (valid == true) {
        System.out.println("Balance is : " + balamount[account]);
        System.out.print("Enter Amount you want to withdraw  : ");
        System.out.flush();

        str = obj.readLine();
        amount = Double.parseDouble(str);
        checkamount = balamount[account] - amount;

        if (checkamount >= min_bal) {
          balamount[account] = checkamount;

          
          System.out.println("\nAfter Updation...");
          System.out.println("Account Number :  " + account);
          System.out.println("Balance Amount :  " + balamount[account] + "\n\n\n");
        } else {
          System.out.println("\n\nAs per Bank Rule you should maintain minimum balance of Rs 500\n\n\n");
        }
      }
    } catch (Exception e) {
      System.out.println("Exception in Withdrawing record.....");
    }
  }
};
