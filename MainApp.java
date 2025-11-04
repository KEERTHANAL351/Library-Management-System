package librarymanagementsystem.main;

import java.util.List;
import java.util.Scanner;

import librarymanagementsystem.dao.BookDAO;
import librarymanagementsystem.dao.MemberDAO;
import librarymanagementsystem.model.Book;
import librarymanagementsystem.model.Member;

public class MainApp {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        MemberDAO memberDAO = new MemberDAO();

        int choice;
        do {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = sc.nextLine();
                    System.out.print("Enter Available Copies: ");
                    int copies = sc.nextInt();
                    sc.nextLine();

                    Book book = new Book(title, author, publisher, copies);
                    bookDAO.addBook(book);
                    break;

                case 2:
                    List<Book> books = bookDAO.getAllBooks();
                    System.out.println("\n--- BOOK LIST ---");
                    for (Book b : books) {
                        System.out.println("ID: " + b.getId() + " | Title: " + b.getTitle() +
                                " | Author: " + b.getAuthor() +
                                " | Publisher: " + b.getPublisher() +
                                " | Available: " + b.getAvailableCopies());
                    }
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Member member = new Member(name, email, phone);
                    memberDAO.addMember(member);
                    break;

                case 4:
                    List<Member> members = memberDAO.getAllMembers();
                    System.out.println("\n--- MEMBER LIST ---");
                    for (Member m : members) {
                        System.out.println("ID: " + m.getId() + " | Name: " + m.getName() +
                                " | Email: " + m.getEmail() +
                                " | Phone: " + m.getPhone());
                    }
                    break;

                case 5:
                    System.out.println(" Exiting...");
                    break;

                default:
                    System.out.println(" Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
