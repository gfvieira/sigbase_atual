/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.chapa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.*;
import java.time.LocalTime;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import src.dao.DaoApendiceChapa;
import src.modelo.Chapa_Apendice;

/**
 *
 * @author admin
 */
public class Uploader {

    private Map<String, String> textParams;
    private List<FileItem> uploadedFiles;
    private final int maxFileSize = 1000000 * 1024;
    private final int maxMemSize = 1000000 * 1024;
    private HttpServletRequest req;
    private int id_chapa;
    private DaoApendiceChapa daoAp;

    public Uploader(List<FileItem> items, HttpServletRequest req, int id_chapa) throws Exception {

        this.textParams = new HashMap<String, String>();
        this.uploadedFiles = new ArrayList<FileItem>();
        this.req = req;
        this.id_chapa = id_chapa;
        try {

            trataUpload(items);

        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public Map<String, String> getTextParameters() {
        return textParams;
    }

    public List<FileItem> getUploadedFiles() {
        return uploadedFiles;
    }

    private void trataRequisicao(HttpServletRequest request) throws Exception {
        String nome = null;
        String valor = null;
        Enumeration<String> nomes = request.getParameterNames();
        while (nomes.hasMoreElements()) {
            nome = nomes.nextElement();
            valor = request.getParameter(nome);
            textParams.put(nome, valor);
        }
    }

    private void trataUpload(List<FileItem> items) {
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //factory.setRepository(new File("/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/bh30/"));
            factory.setRepository(new File("/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/bh30/"));
            factory.setSizeThreshold(maxMemSize);
            ServletFileUpload upload = new ServletFileUpload(factory);

            // maximum file size to be uploaded.
            upload.setSizeMax(maxFileSize);
            String nip = "";

            //captura o nip para colocar no nome do arquivo
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getFieldName().equals("nipHidden")) {
                    nip = items.get(i).getString();
                }
            }

            DaoApendiceChapa daoAp = new DaoApendiceChapa();
            Chapa_Apendice apNovo = new Chapa_Apendice();

            apNovo.setHora_cad(LocalTime.now().toString());
            apNovo.setUser_cad("teste");
            apNovo.setIp_cad(req.getRemoteAddr());
            apNovo.setNip(nip);

            List<FileItem> itens = items;

            for (FileItem item : items) {
                // É um campo texto?
                if (item.isFormField()) {
                    // SIM, é um campo texto, tratar normalmente!!!
                    textParams.put(item.getName(), item.getString());

                } else {
                    // NÃO, não é um campo texto, é um arquivo!!!
                    uploadedFiles.add(item);

                    try {
                        //salvar arquivo em algum caminho... Verificar caminho que Gustavo pediu para UPAR
//                      filePath = "/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/bh50/" + of.toLowerCase() + "/" + time + "/" + os + "_";
//                      // Write the file
//                      if (fileName.lastIndexOf("\\") >= 0) {
//                          file = new File(filePath
//                                  + fileName.substring(fileName.lastIndexOf("\\")));
//                      } else {
//                          file = new File(filePath
//                                  + fileName.substring(fileName.lastIndexOf("\\") + 1));
//                      }
//                      fi.write(file);
                        String caminhoPC = "/opt/tomcat/apache-tomcat-8.0.30/webapps";
                        String caminhoWeb = "/docs_sigbase/bh30/arquivoschapa/" + nip + "/";
//                        String caminhoArquivo = "/bhmn/bh30/chapa/arquivoschapa/" + nip + "/";
                        File local = new File(caminhoPC + caminhoWeb);

                        if (!local.exists()) {
                            local.mkdir();
                        }

                        if (item.getSize() > 0) {
                            //File local = new File("/opt/tomcat/apache-tomcat-8.0.30/webapps/docs_sigbase/bh30/");
                            String nomeArquivo = "/" + nip + "_" + item.getFieldName() + "_" + item.getName();
                            File local2 = new File(caminhoPC + caminhoWeb + nomeArquivo);

                            item.write(local2);

                            switch (item.getFieldName()) {
                                case "declaracaoIR":
                                    apNovo.setArq1(caminhoWeb + nomeArquivo);
                                    break;
                                case "recDeNaoImovel":
                                    apNovo.setArq2(caminhoWeb + nomeArquivo);
                                    break;
                                case "identAnexo":
                                    apNovo.setArq3(caminhoWeb + nomeArquivo);
                                    break;
                                case "cpfAnexo":
                                    apNovo.setArq4(caminhoWeb + nomeArquivo);
                                    break;
                                case "declaracaoAtest":
                                    apNovo.setArq5(caminhoWeb + nomeArquivo);
                                    break;
                                case "folhaBDPES":
                                    apNovo.setArq6(caminhoWeb + nomeArquivo);
                                    break;
                            }
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }

            Chapa_Apendice apVelho = daoAp.buscaApendiceChapa(nip);

            apNovo.setId_chapa(id_chapa);
            //primeiro cadastro
            if (apVelho == null) {
                if (apNovo.getArq1() == null) {
                    apNovo.setArq1("");
                }
                if (apNovo.getArq2() == null) {
                    apNovo.setArq2("");
                }
                if (apNovo.getArq3() == null) {
                    apNovo.setArq3("");
                }
                if (apNovo.getArq4() == null) {
                    apNovo.setArq4("");
                }
                if (apNovo.getArq5() == null) {
                    apNovo.setArq5("");
                }
                if (apNovo.getArq6() == null) {
                    apNovo.setArq6("");
                }
                daoAp.insereApendiceChapa(apNovo);
            } else {
                if (apNovo.getArq1() != null) {
                    apVelho.setArq1(apNovo.getArq1());
                    daoAp.attApendiceChapa(nip, 1, apNovo.getArq1());
                }
                if (apNovo.getArq2() != null) {
                    apVelho.setArq2(apNovo.getArq2());
                    daoAp.attApendiceChapa(nip, 2, apNovo.getArq2());
                }
                if (apNovo.getArq3() != null) {
                    apVelho.setArq3(apNovo.getArq3());
                    daoAp.attApendiceChapa(nip, 3, apNovo.getArq3());
                }
                if (apNovo.getArq4() != null) {
                    apVelho.setArq4(apNovo.getArq4());
                    daoAp.attApendiceChapa(nip, 4, apNovo.getArq4());
                }
                if (apNovo.getArq5() != null) {
                    apVelho.setArq5(apNovo.getArq5());
                    daoAp.attApendiceChapa(nip, 5, apNovo.getArq5());
                }
                if (apNovo.getArq6() != null) {
                    apVelho.setArq6(apNovo.getArq6());
                    daoAp.attApendiceChapa(nip, 6, apNovo.getArq6());
                }
            }

            
        } catch (Exception fue) {
            fue.printStackTrace();

        } finally {
            //this.escritor.close();
        }
    }

}
