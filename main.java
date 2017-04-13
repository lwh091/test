package book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class main {
   static String filePath = "d:\\book\\book.txt";
   static Scanner scan = new Scanner(System.in);

   public void printMenu() {
      System.out.println("���� ���� ���α׷�");
      System.out.println("0. ���α׷� ����");
      System.out.println("1. ���� ���");
      System.out.println("2. ���� �˻�");
      System.out.println("3. ���� �߰�");
      System.out.println("4. ���� ���");
   }

   public void deletebook() throws IOException {
      System.out.println("���� ����");
      String tmpfilePath = filePath + ".tmp";
      int count = 1;
      System.out.print("������ å ��ȣ �Է� ");
      int deleteLineNumber = scan.nextInt();
      System.out.println("å ��ȣ : " + deleteLineNumber);

      BufferedReader br = new BufferedReader(new FileReader(filePath));
      BufferedWriter bw = new BufferedWriter(new FileWriter(tmpfilePath));
      String str = "";
      while ((str = br.readLine()) != null) {
         if (count != deleteLineNumber) {
            bw.write(str);
            bw.write("\r\n");
         }
         count++;
      }
      bw.close();
      bw.close();

      FileInputStream fis = new FileInputStream(tmpfilePath);
      FileOutputStream fos = new FileOutputStream(filePath);
      int data = 0;
      while ((data = fis.read()) != -1) {
         fos.write(data);
      }
      fis.close();
      fos.close();

      File f = new File(tmpfilePath);
      f.deleteOnExit();
   }

   public void insertbook() throws IOException, InterruptedException {

      book e = new book();
      BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
      System.out.println("å ���� : ");
      e.setbook(scan.nextLine());

      System.out.println("���� : ");
      e.setAuthor(scan.nextLine());

      System.out.println("���ǻ� :");
      e.setPublisher(scan.nextLine());

      System.out.println("���� : ");
      e.setCost(scan.nextLine());
      
      System.out.println(e.toString());

      bw.write(e.getbook() + "\t" + e.getAuthor() + "\t" + e.getPublisher() + "\t" + e.getCost());
      bw.newLine();
      bw.close();
      System.out.println("");
   }

   public void searchbook() throws IOException {
      System.out.println("�˻���� (1. ���� 2. ���� 3. ��ü���)");
      int count=1;
      int choice = scan.nextInt();
      scan.nextLine();
      String[] writer = new String[4];
      String[] title = new String[4];
      String keyword, str = "";
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      switch (choice) {
      case 3:
    	 System.out.println("��ü���");
         while ((str = br.readLine()) != null) {
            if (str.contains(str));
               System.out.println("(" + count + ")"+str);
               count++;
         }
  	   System.out.println("�� " + (count - 1) + "��");
  	   System.out.println("");

         break;
      case 2:
         System.out.println("���� �Է�");
         keyword = scan.nextLine();
         while ((str = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(str, "\t");
            for (int i = 0; i < 4; i++) {
               writer[i] = token.nextToken();
            }
            if (writer[1].contains(keyword))
        	    System.out.println("(" + count++ +") " + str);
         }
  	   System.out.println("�� " + (count - 1) + "��");
  	   System.out.println("");
         break;
      case 1:
         System.out.println("���� �Է�");
         keyword = scan.nextLine();
         while ((str = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(str, "\t");
            for (int i = 0; i < 4; i++) {
               title[i] = token.nextToken();
            }
            if (title[0].contains(keyword))
        	    System.out.println("(" + count ++ + ") " + str);
         }
  	   System.out.println("�� " + (count - 1) + "��");
  	   System.out.println("");
         break;
      }
   }
   public void printbook() throws IOException {
	   BufferedReader br = new BufferedReader(new FileReader(filePath));
	   int count = 1;
	   String str;
	   while ((str = br.readLine()) != null) {
	    System.out.println("(" + count ++ +") " + str);
	   }
	   System.out.println("��ü �Ǽ� : " + (count - 1) + "��");
	   System.out.println("");
	   br.close();
	  }
	 }