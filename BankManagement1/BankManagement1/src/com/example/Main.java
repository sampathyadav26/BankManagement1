package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	  public static void main(String args[]) {
	    String str;
	    int choice;
	    choice = 0;

	    Bank BW_obj = new Bank();

	    do {
	      
	      System.out.println("Choose Your Choices ...");
	      System.out.println("1) New Record Entry ");
	      System.out.println("2) Display Record Details ");
	      System.out.println("3) Deposit...");
	      System.out.println("4) Withdraw...");
	      System.out.println("5) Exit");
	      System.out.print("Enter your choice :  ");
	      System.out.flush();
	      try {
	        
	        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
	        str = obj.readLine();
	        choice = Integer.parseInt(str);

	        switch (choice) {
	        case 1:
	         
	          BW_obj.newEntry();
	          break;

	        case 2:
	         
	          BW_obj.display();
	          break;

	        case 3:
	          
	          BW_obj.deposit();
	          break;

	        case 4:
	          
	          BW_obj.withdraw();
	          break;

	        case 5:
	          System.out.println("\n\n.....THANKS FOR VISITING.....");
	          break;

	        default:
	          System.out.println("\nInvalid Choice \n\n");
	        }
	      } catch (Exception e) {
	        System.out.println("Exception in Main....");
	      }
	    }
	    while (choice != 5);
	  }
	}




