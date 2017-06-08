package src.bh50.pedido;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import src.dao.DaoOficina50;
import src.modelo.Pedido_model;

public class UploadFile50 extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private final int maxFileSize = 1000000 * 1024;
    private final int maxMemSize = 1000000 * 1024;
    //private File file;
    private int mes = 0, ano = 0;
    private String nome = "", ip = "", user = "";
    private String os = "", of = "";
    DaoOficina50 daooficina = null;
    String time = "";

    @Override
    public void init() {
        //Get the file location where it would be stored.
        //filePath = getServletContext().getInitParameter("file-upload");
        filePath = "/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/bh50/";
        //filePath = "/home/gustavo/Área de Trabalho/SIG-BASE/sigbase/web/secom/docs/";
    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, java.io.IOException {
        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        if (!isMultipart) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>No file uploaded</p>");
            out.println("</body>");
            out.println("</html>");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/bh50/"));
        //factory.setRepository(new File("/home/gustavo/Área de Trabalho/SIG-BASE/sigbase/web/secom/docs/"));
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum file size to be uploaded.
        upload.setSizeMax(maxFileSize);

        try {
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);
            // Process the uploaded file items
            Iterator i = fileItems.iterator();
            File file;
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    Timestamp tm = new Timestamp(System.currentTimeMillis());
                    time = new SimpleDateFormat("yyyy").format(tm);
                    filePath = "/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/bh50/" + of.toLowerCase() + "/" + time + "/" + os + "_";
                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    daooficina = new DaoOficina50();
                    String temp = "/docs_sigbase/bh50/" + of.toLowerCase() + "/" + time + "/" + os + "_" + fileName;
                    //boolean check = daooficina.inseredoc(temp, fileName, of, ano, contentType, request.getRemoteAddr(), user);
                    Pedido_model oficina = new Pedido_model();
                    oficina = daooficina.buscaOficinaOs(os);
                    Boolean check2 = false;
                    user = daooficina.buscaUsuario(user);
                    oficina.setMove(user + " || Inseriu: <a href=\""+temp+"\" target=\"_blank\"> "+fileName+"</a>"); // o pulo do gato apontando para o arquivo
                    oficina.setIp(request.getRemoteAddr());
                    check2 = daooficina.insereMov(oficina);
                    if (check2 == false) {
                        RequestDispatcher rd = request.getRequestDispatcher("503.html");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("os", os);
                        request.setAttribute("user", user);
                        RequestDispatcher rd = request.getRequestDispatcher("/bhmn/bh50/OsManage50.jsp");
                        rd.forward(request, response);
                    }

                } else {
                    if (fi.getFieldName().equals("os")) {
                        os = fi.getString();
                    }
                    if (fi.getFieldName().equals("of")) {
                        of = fi.getString();
                    }
                    if (fi.getFieldName().equals("user")) {
                        user = fi.getString();
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("status", ex);
            RequestDispatcher rd = request.getRequestDispatcher("#");
            rd.forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with "
                + getClass().getName() + ": POST method required.");
    }
}
