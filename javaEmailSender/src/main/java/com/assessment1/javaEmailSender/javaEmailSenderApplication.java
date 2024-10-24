package com.assessment1.javaEmailSender;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class javaEmailSenderApplication {
    public static void main(String[] args) {

        String dbUrl = "jdbc:mysql://localhost:3306/transport";
        String username = "root";
        String password = "Qwerty@2024";

        String query = "SELECT * FROM dataexport";

        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<table border='1'>");
        htmlTable.append("<tr><th>Column 1</th><th>Column 2</th></tr>");

        try {
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            Statement stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                String column1 = results.getString(1);
                String column2 = results.getString(5);
                htmlTable.append("<tr><td>").append(column1).append("</td><td>").append(column2).append("</td></tr>");
            }
            htmlTable.append("</table>");

            sendEmail(htmlTable.toString());

        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }

    // Method to send email
    private static void sendEmail(String htmlTable) {
        String fromEmail = "tharundeepika.m@conduent.com";
        String toEmail = "deepika77@gmail.com";
        String password = "Ytrewq@2024";

        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Query Results");
            message.setContent(htmlTable, "text/html");

            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}