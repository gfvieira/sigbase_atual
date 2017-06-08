package src.sistemas;

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
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import src.dao.DaoIndicadores;

public class TrocadeServico extends HttpServlet {

    String id = "";
    String param = "";
    StringBuffer sbFilename = null;
    StringBuffer sbContentDispValue = null;
    Timestamp tm = null;
    DocumentException ex = null;
    ByteArrayOutputStream baosPDF = null;
    int i = 0;
    DaoIndicadores daoindic = null;
    ArrayList<ModeloGraficoItem> sate = null;
    String gradreq = "", namereq = "", ramalreq = "", diareq = "";
    String omreq = "", gradreqdo = "", namereqdo = "", ramalreqdo = "";
    String diareqdo = "", omreqdo = "", escala = "", motivo = "";

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            Map mapRequest = req.getParameterMap();
            Map.Entry entryRequest;
            Iterator iteratorRequest = mapRequest.entrySet().iterator();
            String key;
            while (iteratorRequest.hasNext()) {
                entryRequest = (Map.Entry) iteratorRequest.next();
                key = (String) entryRequest.getKey();
                if (key.equals("gradreq")) {
                    gradreq = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("namereq")) {
                    namereq = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("ramalreq")) {
                    ramalreq = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("diareq")) {
                    diareq = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("omreq")) {
                    omreq = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("gradreqdo")) {
                    gradreqdo = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("namereqdo")) {
                    namereqdo = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("ramalreqdo")) {
                    ramalreqdo = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("diareqdo")) {
                    diareqdo = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("omreqdo")) {
                    omreqdo = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("escala")) {
                    escala = req.getParameterValues(key)[0].toUpperCase();
                }
                if (key.equals("motivo")) {
                    motivo = req.getParameterValues(key)[0].toUpperCase();
                }
            }
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
            throws DocumentException {
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
            Paragraph p3 = new Paragraph("BASE DE HIDROGRAFIA DA MARINHA EM NITERÓI", f);
            p3.setAlignment(Element.ALIGN_CENTER);
            p3.setSpacingAfter(15);
            doc.add(p3);
            Paragraph p412 = new Paragraph("COMPLEXO NAVAL DA PONTA DA ARMAÇÃO", f);
            p412.setAlignment(Element.ALIGN_CENTER);
            p412.setSpacingAfter(20);
            doc.add(p412);
            Paragraph p413 = new Paragraph("SOLICITAÇÃO DE TROCA DE SERVIÇO DE PRAÇAS", f);
            p413.setAlignment(Element.ALIGN_CENTER);
            p413.setSpacingAfter(15);
            doc.add(p413);
            Paragraph p41 = new Paragraph("Solicito a V.Sª autorizar a troca de serviço abaixo especificada:", f2);
            p41.setAlignment(Element.ALIGN_CENTER);
            p41.setSpacingAfter(10);
            doc.add(p41);
            Paragraph p6 = new Paragraph("Requerente:", f2);
            p6.setAlignment(Element.ALIGN_LEFT);
            p6.setSpacingAfter(10);
            doc.add(p6);
            PdfPTable table = new PdfPTable(new float[]{2, 3, 1, 4});
            table.setWidthPercentage(100f);
            table.getDefaultCell().setPadding(3);
            table.getDefaultCell().setUseAscender(true);
            table.getDefaultCell().setUseDescender(true);
            table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setColspan(1);
            table.getDefaultCell().setGrayFill(0.7f);
            table.addCell("Grad/Espc");
            table.getDefaultCell().setGrayFill(095f);
            table.addCell(gradreq);
            table.getDefaultCell().setGrayFill(0.7f);
            table.addCell("Nome");
            table.getDefaultCell().setGrayFill(0.95f);
            table.addCell(namereq);
            doc.add(table);
            PdfPTable table2 = new PdfPTable(new float[]{2, 3, 2, 2, 1, 1});
            table2.setWidthPercentage(100f);
            table2.getDefaultCell().setPadding(3);
            table2.getDefaultCell().setUseAscender(true);
            table2.getDefaultCell().setUseDescender(true);
            table2.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
            table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table2.getDefaultCell().setColspan(1);
            table2.getDefaultCell().setGrayFill(0.7f);
            table2.addCell("Dia do serviço");
            table2.getDefaultCell().setGrayFill(095f);
            table2.addCell(diareq);
            table2.getDefaultCell().setGrayFill(0.7f);
            table2.addCell("OM/DIV");
            table2.getDefaultCell().setGrayFill(0.95f);
            table2.addCell(omreq);
            table2.getDefaultCell().setGrayFill(0.7f);
            table2.addCell("Ramal");
            table2.getDefaultCell().setGrayFill(0.95f);
            table2.addCell(ramalreq);
            doc.add(table2);
            Paragraph p61 = new Paragraph("Requerido:", f2);
            p61.setAlignment(Element.ALIGN_LEFT);
            p61.setSpacingAfter(10);
            p61.setSpacingBefore(10);
            doc.add(p61);
            PdfPTable table3 = new PdfPTable(new float[]{2, 3, 1, 4});
            table3.setWidthPercentage(100f);
            table3.getDefaultCell().setPadding(3);
            table3.getDefaultCell().setUseAscender(true);
            table3.getDefaultCell().setUseDescender(true);
            table3.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
            table3.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table3.getDefaultCell().setColspan(1);
            table3.getDefaultCell().setGrayFill(0.7f);
            table3.addCell("Grad/Espc");
            table3.getDefaultCell().setGrayFill(095f);
            table3.addCell(gradreqdo);
            table3.getDefaultCell().setGrayFill(0.7f);
            table3.addCell("Nome");
            table3.getDefaultCell().setGrayFill(0.95f);
            table3.addCell(namereqdo);
            doc.add(table3);
            PdfPTable table4 = new PdfPTable(new float[]{2, 3, 2, 2, 1, 1});
            table4.setWidthPercentage(100f);
            table4.getDefaultCell().setPadding(3);
            table4.getDefaultCell().setUseAscender(true);
            table4.getDefaultCell().setUseDescender(true);
            table4.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
            table4.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table4.getDefaultCell().setColspan(1);
            table4.getDefaultCell().setGrayFill(0.7f);
            table4.addCell("Dia do serviço");
            table4.getDefaultCell().setGrayFill(095f);
            table4.addCell(diareqdo);
            table4.getDefaultCell().setGrayFill(0.7f);
            table4.addCell("OM/DIV");
            table4.getDefaultCell().setGrayFill(0.95f);
            table4.addCell(omreqdo);
            table4.getDefaultCell().setGrayFill(0.7f);
            table4.addCell("Ramal");
            table4.getDefaultCell().setGrayFill(0.95f);
            table4.addCell(ramalreqdo);
            doc.add(table4);
            Paragraph p62 = new Paragraph(" ", f2);
            p62.setAlignment(Element.ALIGN_LEFT);
            p62.setSpacingAfter(5);
            doc.add(p62);
            PdfPTable table5 = new PdfPTable(new float[]{2, 6});
            table5.setWidthPercentage(100f);
            table5.getDefaultCell().setPadding(3);
            table5.getDefaultCell().setUseAscender(true);
            table5.getDefaultCell().setUseDescender(true);
            table5.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
            table5.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table5.getDefaultCell().setColspan(1);
            table5.getDefaultCell().setGrayFill(0.7f);
            table5.addCell("Escala");
            table5.getDefaultCell().setGrayFill(095f);
            table5.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            table5.addCell(escala);
            doc.add(table5);
            PdfPTable table6 = new PdfPTable(new float[]{2, 6});
            table6.setWidthPercentage(100f);
            table6.getDefaultCell().setPadding(3);
            table6.getDefaultCell().setUseAscender(true);
            table6.getDefaultCell().setUseDescender(true);
            table6.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
            table6.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table6.getDefaultCell().setColspan(1);
            table6.getDefaultCell().setGrayFill(0.7f);
            table6.addCell("Motivo");
            table6.getDefaultCell().setGrayFill(095f);
            table6.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            table6.addCell(motivo);
            doc.add(table6);
            Paragraph p71 = new Paragraph("OBS: Caso esta solicitação de troca resulte em “dobra de serviço” o militar não será atendido. "
                    + "O requerente obrigatoriamente restituirá o serviço do requerido no dia assumido nesta papeleta.", f2);
            p71.setAlignment(Element.ALIGN_CENTER);
            p71.setSpacingBefore(10);
            p71.setSpacingAfter(10);
            doc.add(p71);
            tm = new Timestamp(System.currentTimeMillis());
            String d = new SimpleDateFormat("dd").format(tm);
            String d1 = "";
            int d2 = Integer.parseInt(new SimpleDateFormat("MM").format(tm));
            String d4 = new SimpleDateFormat("yyyy").format(tm);
            switch (d2) {
                case 1:
                    d1 = "Janeiro";
                    break;
                case 2:
                    d1 = "Fevereiro";
                    break;
                case 3:
                    d1 = "Março";
                    break;
                case 4:
                    d1 = "Abril";
                    break;
                case 5:
                    d1 = "Maio";
                    break;
                case 6:
                    d1 = "Junho";
                    break;
                case 7:
                    d1 = "Julho";
                    break;
                case 8:
                    d1 = "Agosto";
                    break;
                case 9:
                    d1 = "Setembro";
                    break;
                case 10:
                    d1 = "Outubro";
                    break;
                case 11:
                    d1 = "Novembro";
                    break;
                case 12:
                    d1 = "Dezembro";
                    break;
            }
            Paragraph p7 = new Paragraph("Niterói, " + d + " de " + d1 + " de " + d4, f2);
            p7.setAlignment(Element.ALIGN_RIGHT);
            p7.setSpacingBefore(10);
            p7.setSpacingAfter(15);
            doc.add(p7);

            Paragraph p91 = new Paragraph("_______________________________________                    ________________________________", f2);
            p91.setAlignment(Element.ALIGN_JUSTIFIED);
            p91.setSpacingBefore(10);
            doc.add(p91);
            Paragraph p92 = new Paragraph("                    Assinatura do Requerente                                                                            Assinatura do Requerido", f3);
            p92.setAlignment(Element.ALIGN_JUSTIFIED);
            p92.setSpacingAfter(20);
            doc.add(p92);

            Paragraph p911 = new Paragraph("_______________________________________                    ________________________________", f2);
            p911.setAlignment(Element.ALIGN_JUSTIFIED);
            p911.setSpacingBefore(10);
            doc.add(p911);
            Paragraph p922 = new Paragraph("                    Assinatura do Enc. do Requerente                                                           Assinatura do Enc. do Requerido", f3);
            p922.setAlignment(Element.ALIGN_JUSTIFIED);
            p922.setSpacingAfter(20);
            doc.add(p922);

            Paragraph p81 = new Paragraph("_______________________________________", f2);
            p81.setAlignment(Element.ALIGN_CENTER);
            p81.setSpacingBefore(20);
            doc.add(p81);
            Paragraph p82 = new Paragraph("WILSON LINS DE MELLO FILHO", f3);
            p82.setAlignment(Element.ALIGN_CENTER);
            doc.add(p82);
            Paragraph p83 = new Paragraph("Capitão de Fragata", f3);
            p83.setAlignment(Element.ALIGN_CENTER);
            doc.add(p83);
            Paragraph p8 = new Paragraph("Imediato", f3);
            p8.setAlignment(Element.ALIGN_CENTER);
            doc.add(p8);
            doc.close();
        } catch (DocumentException dex) {
            baosPDF.reset();
            throw dex;
        } catch (Exception ex) {
            Logger.getLogger(TrocadeServico.class.getName()).log(Level.SEVERE, null, ex);
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
