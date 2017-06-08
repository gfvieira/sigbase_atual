package src.secom;

import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import src.dao.DaoSecom;

public class UploadFile extends HttpServlet {

    private boolean isMultipart;
    private String filePath;
    private final int maxFileSize = 10000 * 1024;
    private final int maxMemSize = 10000 * 1024;
    //private File file;
    private int mes = 0, ano = 0;
    private String nome = "", ip = "", user = "";
    DaoSecom daosecom = null;

    @Override
    public void init() {
        //Get the file location where it would be stored.
        //filePath = getServletContext().getInitParameter("file-upload");
        filePath = "/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/secom";
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
        factory.setRepository(new File("/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/secom"));
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
                    filePath = "/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/secom/" + ano + "/" + mes + "/";
                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath
                                + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    daosecom = new DaoSecom();
                    String temp = "/docs_sigbase/" + ano + "/" + mes + "/" + fileName;
                    boolean check = daosecom.inseredoc(temp, mes, ano, nome, request.getRemoteAddr(), user, contentType);
                    if (check == true) {
                        request.setAttribute("status", "OK");
                        RequestDispatcher rd = request.getRequestDispatcher("secom_enviar.jsp");
                        rd.forward(request, response);
                    } else {
                        request.setAttribute("status", "NOT");
                        RequestDispatcher rd = request.getRequestDispatcher("secom_enviar.jsp");
                        rd.forward(request, response);
                    }
                } else {
                    if (fi.getFieldName().equals("mes")) {
                        mes = Integer.parseInt(fi.getString());
                    }
                    if (fi.getFieldName().equals("ano")) {
                        ano = Integer.parseInt(fi.getString());
                    }
                    if (fi.getFieldName().equals("nome")) {
                        nome = fi.getString();
                    }if (fi.getFieldName().equals("user")) {
                        user = fi.getString();
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("status", ex);
            RequestDispatcher rd = request.getRequestDispatcher("secom_enviar.jsp");
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
