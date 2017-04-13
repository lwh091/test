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
      System.out.println("도서 관리 프로그램");
      System.out.println("0. 프로그램 종료");
      System.out.println("1. 도서 목록");
      System.out.println("2. 도서 검색");
      System.out.println("3. 도서 추가");
      System.out.println("4. 도서 폐기");
   }

   public void deletebook() throws IOException {
      System.out.println("도서 삭제");
      String tmpfilePath = filePath + ".tmp";
      int count = 1;
      System.out.print("삭제할 책 번호 입력 ");
      int deleteLineNumber = scan.nextInt();
      System.out.println("책 번호 : " + deleteLineNumber);

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
      System.out.println("책 제목 : ");
      e.setbook(scan.nextLine());

      System.out.println("저자 : ");
      e.setAuthor(scan.nextLine());

      System.out.println("출판사 :");
      e.setPublisher(scan.nextLine());

      System.out.println("가격 : ");
      e.setCost(scan.nextLine());
      
      System.out.println(e.toString());

      bw.write(e.getbook() + "\t" + e.getAuthor() + "\t" + e.getPublisher() + "\t" + e.getCost());
      bw.newLine();
      bw.close();
      System.out.println("");
   }

   public void searchbook() throws IOException {
      System.out.println("검색목록 (1. 제목 2. 저자 3. 전체목록)");
      int count=1;
      int choice = scan.nextInt();
      scan.nextLine();
      String[] writer = new String[4];
      String[] title = new String[4];
      String keyword, str = "";
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      switch (choice) {
      case 3:
    	 System.out.println("전체출력");
         while ((str = br.readLine()) != null) {
            if (str.contains(str));
               System.out.println("(" + count + ")"+str);
               count++;
         }
  	   System.out.println("총 " + (count - 1) + "권");
  	   System.out.println("");

         break;
      case 2:
         System.out.println("저자 입력");
         keyword = scan.nextLine();
         while ((str = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(str, "\t");
            for (int i = 0; i < 4; i++) {
               writer[i] = token.nextToken();
            }
            if (writer[1].contains(keyword))
        	    System.out.println("(" + count++ +") " + str);
         }
  	   System.out.println("총 " + (count - 1) + "권");
  	   System.out.println("");
         break;
      case 1:
         System.out.println("제목 입력");
         keyword = scan.nextLine();
         while ((str = br.readLine()) != null) {
            StringTokenizer token = new StringTokenizer(str, "\t");
            for (int i = 0; i < 4; i++) {
               title[i] = token.nextToken();
            }
            if (title[0].contains(keyword))
        	    System.out.println("(" + count ++ + ") " + str);
         }
  	   System.out.println("총 " + (count - 1) + "권");
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
	   System.out.println("전체 권수 : " + (count - 1) + "권");
	   System.out.println("");
	   br.close();
	  }
	 }