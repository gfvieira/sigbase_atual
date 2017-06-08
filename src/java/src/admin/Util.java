/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.admin;

/**
 *
 * @author gustavo
 */
public class Util {
    
     protected static String privilegio(String typeAccess) {
        String privilegio = "";
        if (typeAccess.equals("ADMIN")) {
            privilegio = "ADMIN";
        } else if (typeAccess.equals("IDENTIFICADOR")) {
            privilegio = "IDENTIFICADOR";
        } else if (typeAccess.equals("TOTAL")
                || typeAccess.equals("BH05")) {
            privilegio = "TOTAL";
        } else if (typeAccess.equals("BH04")) {
            privilegio = "BH04";
        } else if (typeAccess.equals("BH08")) {
            privilegio = "BH08";
        } else if (typeAccess.equals("CHEFEBH10")
                || typeAccess.equals("NACIONAL")
                || typeAccess.equals("ESTRANGEIRA")
                || typeAccess.equals("FOLHAN")) {
            privilegio = "BH10";
        } else if (typeAccess.equals("CHEFEBH20")
                || typeAccess.equals("MUNICIAMENTO")) {
            privilegio = "BH25";
        } else if (typeAccess.equals("CHEFEBH30")) {
            privilegio = "BH30";
        } else if (typeAccess.equals("CHAPA")) {
            privilegio = "CHAPA";
        } else if (typeAccess.equals("ENCARREGADOBH31")
                || typeAccess.equals("PESSOAL")) {
            privilegio = "BH31";
        } else if (typeAccess.equals("ENCARREGADOBH32")) {
            privilegio = "BH32";
        } else if (typeAccess.equals("ENCARREGADOBH33")) {
            privilegio = "BH33";
        } else if (typeAccess.equals("ENCARREGADOBH34")
                || typeAccess.equals("SUPERVISORBH34")
                || typeAccess.equals("HARDWARE")
                || typeAccess.equals("REDE")
                || typeAccess.equals("LOTUS")
                || typeAccess.equals("TELEFONIA")) {
            privilegio = "BH34";
        } else if (typeAccess.equals("CHEFEBH40")) {
            privilegio = "BH40";
        } else if (typeAccess.equals("CHEFEBH50")
                || typeAccess.equals("ENCARREGADOBH52")
                || typeAccess.equals("ENCARREGADOBH53")
                || typeAccess.equals("ELETRICA")
                || typeAccess.equals("AGUADA")
                || typeAccess.equals("REFRIGERACAO")
                || typeAccess.equals("CARPINTARIA")
                || typeAccess.equals("METALURGIA")
                || typeAccess.equals("GARAGEM")
                || typeAccess.equals("PREFEITURA")) {
            privilegio = "BH50";
        } else if (typeAccess.equals("01")
                || typeAccess.equals("04")
                || typeAccess.equals("08")
                || typeAccess.equals("10")
                || typeAccess.equals("11")
                || typeAccess.equals("12")
                || typeAccess.equals("20")
                || typeAccess.equals("21")
                || typeAccess.equals("22")
                || typeAccess.equals("23")
                || typeAccess.equals("24")
                || typeAccess.equals("25")
                || typeAccess.equals("30")
                || typeAccess.equals("31")
                || typeAccess.equals("32")
                || typeAccess.equals("33")
                || typeAccess.equals("34")
                || typeAccess.equals("40")
                || typeAccess.equals("41")
                || typeAccess.equals("42")
                || typeAccess.equals("43")
                || typeAccess.equals("44")) {
            privilegio = "SARGENTEANTE";
        }
        return privilegio;
    }

    protected static String setor(String typeAccess) {
        String setor = "";
        if (typeAccess.equals("ADMIN")) {
            setor = "BH-34";
        } else if (typeAccess.equals("IDENTIFICADOR")) {
            setor = "IDENTIFICADOR";
        } else if (typeAccess.equals("TOTAL")
                || typeAccess.equals("BH05")
                || typeAccess.equals("01")) {
            setor = "BH-01";
        } else if (typeAccess.equals("BH04") || typeAccess.equals("04")) {
            setor = "BH-04";
        } else if (typeAccess.equals("BH08") || typeAccess.equals("08")) {
            setor = "BH-08";
        } else if (typeAccess.equals("CHEFEBH10")
                || typeAccess.equals("NACIONAL")
                || typeAccess.equals("ESTRANGEIRA")
                || typeAccess.equals("FOLHAN")
                || typeAccess.equals("10")
                || typeAccess.equals("11")
                || typeAccess.equals("12")) {
            setor = "BH-10";
        } else if (typeAccess.equals("CHEFEBH20")
                || typeAccess.equals("20")
                || typeAccess.equals("21")
                || typeAccess.equals("22")
                || typeAccess.equals("23")
                || typeAccess.equals("24")
                || typeAccess.equals("25")
                || typeAccess.equals("")) {
            setor = "BH-20";
        } else if (typeAccess.equals("CHEFEBH30")
                || typeAccess.equals("CHAPA")
                || typeAccess.equals("ENCARREGADOBH31")
                || typeAccess.equals("PESSOAL")
                || typeAccess.equals("ENCARREGADOBH32")
                || typeAccess.equals("ENCARREGADOBH33")
                || typeAccess.equals("ENCARREGADOBH34")
                || typeAccess.equals("SUPERVISORBH34")
                || typeAccess.equals("HARDWARE")
                || typeAccess.equals("REDE")
                || typeAccess.equals("LOTUS")
                || typeAccess.equals("TELEFONIA")
                || typeAccess.equals("30")
                || typeAccess.equals("31")
                || typeAccess.equals("32")
                || typeAccess.equals("33")
                || typeAccess.equals("34")) {
            setor = "BH-30";
        } else if (typeAccess.equals("CHEFEBH40")
                || typeAccess.equals("40")
                || typeAccess.equals("41")
                || typeAccess.equals("42")
                || typeAccess.equals("43")
                || typeAccess.equals("44")) {
            setor = "BH-40";
        } else if (typeAccess.equals("CHEFEBH50")
                || typeAccess.equals("ENCARREGADOBH52")
                || typeAccess.equals("ENCARREGADOBH53")
                || typeAccess.equals("ELETRICA")
                || typeAccess.equals("AGUADA")
                || typeAccess.equals("REFRIGERACAO")
                || typeAccess.equals("CARPINTARIA")
                || typeAccess.equals("METALURGIA")
                || typeAccess.equals("GARAGEM")
                || typeAccess.equals("PREFEITURA")
                || typeAccess.equals("50")
                || typeAccess.equals("51")
                || typeAccess.equals("52")
                || typeAccess.equals("53")) {
            setor = "BH-50";
        }
        return setor;
    }
    
}
