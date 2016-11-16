//package webautomation;
//
//import com.sun.mail.smtp.SMTPTransport;
//import org.apache.commons.mail.EmailException;
//import org.testng.ISuite;
//import org.testng.xml.XmlSuite;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import java.util.Properties;
//
//
//public class Reports extends org.testng.reporters.EmailableReporter{
//	Properties props = System.getProperties();
//	@Override
//	public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) {
//	    super.generateReport(xml, suites, outdir);
//	    try {
//			emailResults("C://Users//rahasan//Desktop//TestReport.pdf");
//		} catch (EmailException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public boolean emailResults(String fileAttachment)
//		throws EmailException, MessagingException {
//		//Customize the code as per requirement
//		Properties props = System.getProperties();
//		props.put("mail.smtps.host", "smtp.gmail.com");
//		props.put("mail.smtps.auth", "true");
//
//		InputStream inputStream = LoginSuccess.class.getResourceAsStream("metadata.properties");
//
//		try {
//			props.load(inputStream);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		String recipients = props.getProperty("test.emailto");
//		String sender =props.getProperty("test.emailuser");
//		String accountEmail =props.getProperty("test.emailuser");
//		String acctPwd = props.getProperty("test.emailpwd");
//
//
//		Session session = Session.getInstance(props, null);
//		Message msg = new MimeMessage(session);
//		msg.setFrom(new InternetAddress(sender));
//		;
//		msg.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse(recipients, false));
//		msg.setSubject("Web Regression Test Result - UNATION");
//
//		// create the message part
//		MimeBodyPart messageBodyPart = new MimeBodyPart();
//		// fill message
//		messageBodyPart.setText("Attached herewith the execution report of automated regression suite.");
//		Multipart multipart = new MimeMultipart();
//		multipart.addBodyPart(messageBodyPart);
//		// Part two is attachment
//		messageBodyPart = new MimeBodyPart();
//		DataSource source = new FileDataSource(fileAttachment);
//		messageBodyPart.setDataHandler(new DataHandler(source));
//		messageBodyPart.setFileName(fileAttachment);
//		fileAttachment.substring(19);
//		multipart.addBodyPart(messageBodyPart);
//		// Put parts in message
//		msg.setContent(multipart);
//
//		msg.setHeader("X-Mailer", "Test Results");
//		SMTPTransport t = (SMTPTransport) session.getTransport("smtps");
//		t.connect("smtp.gmail.com", accountEmail, acctPwd);
//		t.sendMessage(msg, msg.getAllRecipients());
//		t.close();
//		return true;
//		}
//
//	public static String readPropertiesFile(String propFile, String property) {
//
//		String value = null;
//
//		Properties prop = new Properties();
//
//		try {
//			// load a properties file
//			prop.load(new FileInputStream(propFile));
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//
//		value = prop.getProperty(property);
//
//		return value;
//	}
//
//}