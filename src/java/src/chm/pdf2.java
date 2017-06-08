package src.chm;

import src.modelo.ModeloGraficoItem;
import java.io.ByteArrayOutputStream;
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import src.dao.DaoIndicadores;
 
public class pdf2 extends HttpServlet {
    
    String id  = "ALL";
    String param = "";
    StringBuffer sbFilename         = null;
    StringBuffer sbContentDispValue = null;
    Timestamp tm                    = null;
    DocumentException ex            = null;
    ByteArrayOutputStream baosPDF   = null;
    int i = 0;
    DaoIndicadores daoindic = null;
    ArrayList<ModeloGraficoItem> sate = null;
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        try {
//            id = req.getParameter("ind");
            baosPDF = generatePDFDocumentBytes(this.getServletContext());
            sbFilename = new StringBuffer();
            sbFilename.append("Relatorio_");
            tm = new Timestamp(System.currentTimeMillis());
            String d = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss").format(tm);
            sbFilename.append(d);
            sbFilename.append(".pdf");
            resp.setHeader("Cache-Control", "max-age=30");
            resp.setContentType("application/pdf");
            sbContentDispValue = new StringBuffer();
            sbContentDispValue.append("inline");
            sbContentDispValue.append("; filename=");
            sbContentDispValue.append(sbFilename);
            resp.setContentType("application/pdf");      
            resp.setHeader("Content-disposition", sbContentDispValue.toString());
            resp.setContentLength(baosPDF.size());
            ServletOutputStream sos;
            sos = resp.getOutputStream();
            //resp.getOutputStream().write(baosPDF);
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
            doc.addTitle("Sample Report");
            doc.setPageSize(PageSize.LETTER);
            doc.open();
            String strServerInfo = ctx.getServerInfo();
            if (strServerInfo != null) {
            }
            //String imageUrl = "C:\\Users\\Vania\\Desktop\\Tcc02_06_15_20\\Tcc02_06_15_20\\web\\img\\logo2.png";
            //Image img = Image.getInstance(imageUrl);
            //img.setAlignment(Element.ALIGN_CENTER);
            //doc.add(img);
            Font f = new Font(Font.FontFamily.TIMES_ROMAN, 14);
            Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 12);
            Font f3 = new Font(Font.FontFamily.TIMES_ROMAN, 10);            
            Font f4 = new Font(Font.FontFamily.TIMES_ROMAN, 8);
            Paragraph p1 = new Paragraph("MARINHA DO BRASIL", f);
            p1.setAlignment(Element.ALIGN_CENTER);
            //p1.setSpacingAfter(10);
            doc.add(p1);
            Paragraph p2 = new Paragraph("DIRETORIA DE HIDROGRAFIA E NAVEGAÇÃO", f);
            p2.setAlignment(Element.ALIGN_CENTER);
            //p1.setSpacingAfter(10);
            doc.add(p2);
            Paragraph p3 = new Paragraph("CENTRO DE HIDROGRAFIA DA MARINHA", f);
            p3.setAlignment(Element.ALIGN_CENTER);
            p3.setSpacingAfter(6);
            doc.add(p3);
            Paragraph p412 = new Paragraph("SIS-MARE", f);
            p412.setAlignment(Element.ALIGN_CENTER);
            doc.add(p412);
            Paragraph p413 = new Paragraph("Sistema de Maré", f3);
            p413.setAlignment(Element.ALIGN_CENTER);
            p413.setSpacingAfter(10);
            doc.add(p413);
            Paragraph p41 = new Paragraph("SUPERINTENDÊNCIA DE INFORMAÇÕES AMBIENTAIS", f);
            p41.setAlignment(Element.ALIGN_CENTER);
            p41.setSpacingAfter(10);
            doc.add(p41);
            Paragraph p6 = new Paragraph("INDICADORES DE MARÉ", f2);
            p6.setAlignment(Element.ALIGN_CENTER);
            doc.add(p6);
            tm = new Timestamp(System.currentTimeMillis());
            String d = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(tm);
            Paragraph p7 = new Paragraph("Emitido em: " + d, f4);
            p7.setAlignment(Element.ALIGN_CENTER);
            p7.setSpacingAfter(14);
            doc.add(p7);
            if(id.equals("ALL"))
                id = "ANUAL";
            else{
                int M =Integer.parseInt(new SimpleDateFormat("MM").format(tm));
                switch(M){  
                    case 1: id = "Janeiro de";break;  
                    case 2: id = "Fevereiro de";break;  
                    case 3: id = "Marco de";break;  
                    case 4: id = "Abril de";break;  
                    case 5: id = "Maio de";break;  
                    case 6: id = "Junho de";break;  
                    case 7: id = "Julho de";break;  
                    case 8: id = "agosto de";break;  
                    case 9: id = "setembro de";break;  
                    case 10: id = "outubro de";break;  
                    case 11: id = "novembro de";break;  
                    case 12: id = "dezembro de";break;  
                }
                M =Integer.parseInt(new SimpleDateFormat("yyyy").format(tm));
                id = "DO MÊS DE " +id.toUpperCase()+" "+M;

            }
//            Paragraph p81 = new Paragraph("DEMOSTRATIVO " + id, f3);
//            p81.setAlignment(Element.ALIGN_CENTER);
//            p81.setSpacingAfter(12);
//            doc.add(p81);
//            Paragraph p8 = new Paragraph("BH-34 TELEMÁTICA", f3);
//            p8.setAlignment(Element.ALIGN_CENTER);
//            p8.setSpacingAfter(12);
//            doc.add(p8);
            //ComposicaoDadosItemGrafico composicao = new ComposicaoDadosItemGrafico();
            //ArrayList array = composicao.getArray();
            daoindic = new DaoIndicadores();
            sate = new ArrayList<>();
            if(id.equals("ANUAL"))
                sate = daoindic.buscaindbh34();
            else
                sate = daoindic.buscaindbh34Mes();
            if(sate.isEmpty())
                sate = GeradorItens.IsEmpty();
            int rd = 0, hw = 0, te = 0, lo = 0;
            for(ModeloGraficoItem sate1 : sate){
                if(sate1.getOficina().equals("REDE"))       rd = 1;
                if(sate1.getOficina().equals("HARDWARE"))   hw = 1;
                if(sate1.getOficina().equals("LOTUS"))      lo = 1;
                if(sate1.getOficina().equals("TELEFONIA"))  te = 1;
            }
            sate = GeradorItens.IsComplete(sate,rd,hw,te,lo);
            BufferedImage imagem = GeradorGrafico.gerarGraficoLinha3D("", "Periodo", "Altura em cm", sate);
            Image image = Image.getInstance(imagem , null);

            image.setAlignment(Element.ALIGN_CENTER);
            doc.add(image);
            
                doc.close();
            } catch (DocumentException dex) {
                baosPDF.reset();
                throw dex;
            } catch (Exception ex) {
                Logger.getLogger(pdf2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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