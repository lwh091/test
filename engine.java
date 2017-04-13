package book;

import java.io.*;
import java.util.*;

public class engine {

 static Scanner scan = new Scanner(System.in);
 main s3 = new main();

 public static void main(String[] args) throws IOException, InterruptedException {
  while (true) {
   main e = new main();
   e.printMenu();

   int a = inputscan();

   switch (a) {

   case 5:
    System.out.println("종료");
    System.exit(0);
    break;
   case 1:
    e.printbook();
    break;
   case 2:
    e.searchbook();
    break;
   case 3:
    e.insertbook();
    break;
   case 4:
    e.deletebook();
    break;
   default:
    System.out.println("재 입력");
    System.out.println("");
   }
  }
 }

 private static int inputscan() {
  int a = -1;
  System.out.print("번호 입력 : ");
  a = scan.nextInt();
  return a;
 }

}