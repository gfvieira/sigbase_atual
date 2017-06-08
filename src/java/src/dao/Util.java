/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.bh30.bh31.pessoal.CadPessoal;

/**
 *
 * @author gustavo
 */
public class Util {

    static DaoBh30Pessoal daobh30 = new DaoBh30Pessoal();

    protected static String setData(String date) {
        if (!date.equals("")) {
            String dia = "", mes = "", ano = "";
            date = date.replaceAll("[^a-zZ-Z0-9 ]", "");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            if (!date.equals("")) {
                ano = date.substring(0, 4);
                mes = date.substring(4, 6);
                dia = date.substring(6, 8);
            }
            date = (dia + "/" + mes + "/" + ano);
        }
        return date;
    }

    protected static String graduacao(int graduacao) {
        String grad = "";
        switch (graduacao) {
            case 1:
                grad = "MN-RC";
                break;
            case 2:
                grad = "MN";
                break;
            case 3:
                grad = "MNE";
                break;
            case 4:
                grad = "CB";
                break;
            case 5:
                grad = "3SG";
                break;
            case 6:
                grad = "2SG";
                break;
            case 7:
                grad = "1SG";
                break;
            case 8:
                grad = "SO";
                break;
            case 9:
                grad = "GM";
                break;
            case 10:
                grad = "2T";
                break;
            case 11:
                grad = "1T";
                break;
            case 12:
                grad = "CT";
                break;
            case 13:
                grad = "CC";
                break;
            case 14:
                grad = "CF";
                break;
            case 15:
                grad = "CMG";
                break;
            case 16:
                grad = "CA";
                break;
            case 17:
                grad = "VA";
                break;
            case 18:
                grad = "AE";
                break;
        }
        return grad;
    }

    protected static Date setData2(String date) {
        String dia = "", mes = "", ano = "";
        date = date.replaceAll("[^a-zZ-Z0-9 ]", "");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        if (!date.equals("")) {
            ano = date.substring(4, 8);
            mes = date.substring(2, 4);
            dia = date.substring(0, 2);
        }
        date = (dia + "/" + mes + "/" + ano);
        Date data = null;
        try {
            data = new Date(format.parse(date).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(CadPessoal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
