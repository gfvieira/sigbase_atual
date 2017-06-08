package src.chm;

 
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import src.modelo.ModeloGraficoItem;
 
public class pdf extends HttpServlet {
    
    String id = "";
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        DocumentException ex = null;
        ByteArrayOutputStream baosPDF = null;
        try {
            id = req.getParameter("0");
            baosPDF = generatePDFDocumentBytes(this.getServletContext());
            StringBuffer sbFilename = new StringBuffer();
            sbFilename.append("TESTANDO ARQUIVOS");
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String d = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss").format(tm);
            sbFilename.append(d);
            sbFilename.append(".pdf");
            resp.setHeader("Cache-Control", "max-age=30");
            resp.setContentType("application/pdf");
            StringBuffer sbContentDispValue = new StringBuffer();
            sbContentDispValue.append("inline");
            sbContentDispValue.append("; filename=");
            sbContentDispValue.append(sbFilename);
            resp.setHeader("Content-disposition", sbContentDispValue.toString());
            resp.setContentLength(baosPDF.size());
            ServletOutputStream sos;
            sos = resp.getOutputStream();
            baosPDF.writeTo(sos);
            sos.flush();
        } catch (DocumentException dex) {
            resp.setContentType("text/html");
            PrintWriter writer = resp.getWriter();
            writer.println(this.getClass().getName() + " caught an exception: "
                    + dex.getClass().getName() + "<br>");
            writer.println("<pr>");
            dex.printStackTrace(writer);
            writer.println("</pr>");
        } finally {
            if (baosPDF != null) {
                baosPDF.reset();
            }
        }
    }
    protected ByteArrayOutputStream generatePDFDocumentBytes(
            final ServletContext ctx)
            throws DocumentException
    {
        Document doc = new Document();
        ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();
        PdfWriter docWriter = null;
        try {
            
            docWriter = PdfWriter.getInstance(doc, baosPDF);
            doc.addAuthor("Sample");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("Sample");
            doc.addTitle("TESTANDO ARQUIVOS");
            doc.setPageSize(PageSize.LETTER);
            doc.open();
            String strServerInfo = ctx.getServerInfo();
            if (strServerInfo != null) {
            }
            Font f = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font f3 = new Font(Font.FontFamily.TIMES_ROMAN, 10);            
            Font f4 = new Font(Font.FontFamily.TIMES_ROMAN, 8);
            Paragraph p1 = new Paragraph("MARINHA DO BRASIL", f);
            p1.setAlignment(Element.ALIGN_CENTER);
//            p1.setSpacingAfter(3);
            doc.add(p1);
            Paragraph p2 = new Paragraph("DIRETORIA DE HIDROGRAFIA E NAVEGAÇÃO", f2);
            p2.setAlignment(Element.ALIGN_CENTER);
            p2.setSpacingAfter(10);
            doc.add(p2);
            Paragraph p3 = new Paragraph("CENTRO DE HIDROGRAFIA DA MARINHA", f);
            p3.setAlignment(Element.ALIGN_CENTER);
            p3.setSpacingAfter(10);
            doc.add(p3);
            Paragraph p412 = new Paragraph("SIS-MARÉ", f);
            p412.setAlignment(Element.ALIGN_CENTER);
            doc.add(p412);
            Paragraph p413 = new Paragraph("Sistema de Maré", f3);
            p413.setAlignment(Element.ALIGN_CENTER);
            p413.setSpacingAfter(10);
            doc.add(p413);
//            Paragraph p41 = new Paragraph("BH-05 ASSESSORIA DE PLANEJAMENTO", f);
//            p41.setAlignment(Element.ALIGN_CENTER);
//            p41.setSpacingAfter(10);
//            doc.add(p41);
            Paragraph p6 = new Paragraph("MARÉS DO DIA 01/08/2016 A 31/08/2016", f2);
            p6.setAlignment(Element.ALIGN_CENTER);
            doc.add(p6);
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String d = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(tm);
            Paragraph p7 = new Paragraph("Emitido em: " + d, f4);
            p7.setAlignment(Element.ALIGN_CENTER);
            p7.setSpacingAfter(14);
            doc.add(p7);
            ModeloGraficoItem teste = new ModeloGraficoItem();
            ArrayList<ModeloGraficoItem> list = new ArrayList<>();
            teste.setOficina("teste");
            teste.setTipo("teste2");
            teste.setQuantidade(2);
            list.add(teste);
            list.add(teste);
            list.add(teste);
            try {
                BufferedImage imagem = GeradorGrafico.gerarGraficoBarraVertical3D("Titulo", "Mes","Quantidade", list);
            } catch (Exception ex) {
                Logger.getLogger(pdf.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (DocumentException dex) {
            baosPDF.reset();
            throw dex;
        }finally {
            if (doc != null) {
                doc.close();
            }
            if (docWriter != null) {
                docWriter.close();
            }
        }

        if (baosPDF.size() < 1) {
            throw new DocumentException("document has " + baosPDF.size()
                    + " bytes");
        }
        return baosPDF;
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}