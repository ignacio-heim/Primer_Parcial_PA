package ar.com.parcialUno.infrastructure.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PDFGenerator {

    public static void generatePDF(Object objeto, String nombreArchivo) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            String contenido = objeto.toString();
            document.add(new Paragraph(contenido));

            System.out.println("PDF generado correctamente en: " + nombreArchivo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

}
