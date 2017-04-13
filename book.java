package book;

public class book {
 private String book;
 private String author;
 private String publisher;
 private String cost;

 String getbook() {
  return book;
 }

 public void setbook(String book) {
  this.book = book;
 }

 public String getAuthor() {
  return author;
 }

 public void setAuthor(String author) {
  this.author = author;
 }

 public String getPublisher() {
  return publisher;
 }

 public void setPublisher(String publisher) {
  this.publisher = publisher;
 }

 public String getCost() {
  return cost;
 }

 public void setCost(String cost) {
  this.cost = cost;
 }

 public String toString() {
  System.out.println("name : " + book);
  System.out.println("author : " + author);
  System.out.println("publisher : " + publisher);
  System.out.println("cost : " + cost);

  return book + ", " + author + ", " + publisher + ", " + cost;
 }
}