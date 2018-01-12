package org.jcontactmanager.util;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.jcontactmanager.model.Contact;
import org.jcontactmanager.model.ContactInformation;
import org.slf4j.*;

import java.io.IOException;


public class BusinessCardGenerator {
    /**
     * Generate PDF file with contact's business card
     * @param contact Contact whose business card will be generated
     * @param path A path under which the business card will be saved
     */
    public void generateBusinessCard(Contact contact, String path){
        try {
            ContactInformation ci = contact.getContactInformation();
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document doc = new Document(pdfDocument);
            doc.add(new Paragraph("\t\t\t" + ci.getName()));
            doc.add(new Paragraph("\t" + ci.getAddress()+", "+ci.getCity()+" "+ci.getCountry()));
            doc.add(new Paragraph("\t" + contact.getEmailAddress().getWorkEmailAddress()));
            doc.add(new Paragraph("\t" + contact.getPhoneNumber().getWorkNumber()));
            doc.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
