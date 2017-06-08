/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.bh30.sargenteante;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import src.bh30.bh31.pessoal.CadPessoal;
import src.dao.DaoBh30Pessoal;
import src.dao.DaoSargenteante;
import src.modelo.Pessoal_busca;
import src.modelo.Pessoal_model;
import src.modelo.Pessoal_movi;

public class Util {

    static DaoSargenteante daosargenteante = new DaoSargenteante();

    static DaoBh30Pessoal daobh30 = new DaoBh30Pessoal();

    protected static ArrayList<Pessoal_model> listarPessoalSargenteanteDivisao(int tipo, String access) {
        ArrayList<Pessoal_model> servidorarray = new ArrayList<>();

        switch (tipo) {
            case 0:
                servidorarray = daosargenteante.buscaOficialDivisao(access);
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(access));
                servidorarray.addAll(daosargenteante.buscaTTCDivisao(access));
                servidorarray.addAll(daosargenteante.buscaCivilDivisao(access));
                break;
            case 1:
                servidorarray = daosargenteante.buscaPracaDivisao(access);
                break;
            case 2:
                servidorarray = daosargenteante.buscaOficialDivisao(access);
                break;
            case 3:
                servidorarray = daosargenteante.buscaTTCDivisao(access);
                break;
            case 4:
                servidorarray = daosargenteante.buscaCivilDivisao(access);
                break;
            case 12:
                servidorarray = daosargenteante.buscaPracaDivisao(3, access);
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(2, access));
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(1, access));
                break;
            case 13:
                servidorarray = daosargenteante.buscaPracaDivisao(4, access);
                break;
            case 14:
                servidorarray = daosargenteante.buscaPracaDivisao(7, access);
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(6, access));
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(5, access));
                break;
            case 15:
                servidorarray = daosargenteante.buscaPracaDivisao(8, access);
                break;
            default:
                break;
        }
        return servidorarray;
    }

    protected static ArrayList<Pessoal_model> listarPessoalSargenteanteDep(int tipo, String access) {
        ArrayList<Pessoal_model> servidorarray = new ArrayList<>();

        switch (tipo) {
            case 0:
                servidorarray = daosargenteante.buscaOficialDep(access);
                servidorarray.addAll(daosargenteante.buscaPracaDep(access));
                servidorarray.addAll(daosargenteante.buscaTTCDep(access));
                servidorarray.addAll(daosargenteante.buscaCivilDep(access));
                break;
            case 1:
                servidorarray = daosargenteante.buscaPracaDep(access);
                break;
            case 2:
                servidorarray = daosargenteante.buscaOficialDep(access);
                break;
            case 3:
                servidorarray = daosargenteante.buscaTTCDep(access);
                break;
            case 4:
                servidorarray = daosargenteante.buscaCivilDep(access);
                break;
            case 12:
                servidorarray = daosargenteante.buscaPracaDep(3, access);
                servidorarray.addAll(daosargenteante.buscaPracaDep(2, access));
                servidorarray.addAll(daosargenteante.buscaPracaDep(1, access));
                break;
            case 13:
                servidorarray = daosargenteante.buscaPracaDep(4, access);
                break;
            case 14:
                servidorarray = daosargenteante.buscaPracaDep(7, access);
                servidorarray.addAll(daosargenteante.buscaPracaDep(6, access));
                servidorarray.addAll(daosargenteante.buscaPracaDep(5, access));
                break;
            case 15:
                servidorarray = daosargenteante.buscaPracaDep(8, access);
                break;
            default:
                break;
        }
        return servidorarray;
    }

    protected static ArrayList<Pessoal_model> listarPessoalSargenteanteDiv(int tipo, String access) {
        ArrayList<Pessoal_model> servidorarray = new ArrayList<>();

        switch (tipo) {
            case 0:
                servidorarray = daosargenteante.buscaOficialDivisao(access);
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(access));
                servidorarray.addAll(daosargenteante.buscaTTCDivisao(access));
                servidorarray.addAll(daosargenteante.buscaCivilDivisao(access));
                break;
            case 1:
                servidorarray = daosargenteante.buscaPracaDivisao(access);
                break;
            case 2:
                servidorarray = daosargenteante.buscaOficialDivisao(access);
                break;
            case 3:
                servidorarray = daosargenteante.buscaTTCDivisao(access);
                break;
            case 4:
                servidorarray = daosargenteante.buscaCivilDivisao(access);
                break;
            case 12:
                servidorarray = daosargenteante.buscaPracaDivisao(3, access);
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(2, access));
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(1, access));
                break;
            case 13:
                servidorarray = daosargenteante.buscaPracaDivisao(4, access);
                break;
            case 14:
                servidorarray = daosargenteante.buscaPracaDivisao(7, access);
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(6, access));
                servidorarray.addAll(daosargenteante.buscaPracaDivisao(5, access));
                break;
            case 15:
                servidorarray = daosargenteante.buscaPracaDivisao(8, access);
                break;
            default:
                break;
        }
        return servidorarray;
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

    protected static Pessoal_busca setBusca(String nip, int type) {
        Pessoal_busca busca = new Pessoal_busca();
        busca.setNip(nip);
        busca.setCep("");
        busca.setLogradouro("");
        busca.setNumero("");
        busca.setBairro("");
        busca.setComplemento("");
        busca.setCidade("");
        busca.setMunicipio("");
        busca.setUf("");
        busca.setTelefone("");
        busca.setCelular("");
        switch (type) {
            case 21:
                busca.setTipo(1);
                break;
            case 22:
                busca.setTipo(2);
                break;
            case 23:
                busca.setTipo(3);
                break;
            case 24:
                busca.setTipo(4);
                break;
        }
        busca.setEncontrou(0);
        return busca;
    }

    protected static boolean insereBusca(Pessoal_busca pessoaBusca) {
        boolean check = false;
        switch (pessoaBusca.getTipo()) {
            case 1:
                check = daobh30.inserePlanodebuscaPraca(pessoaBusca);
                break;
            case 2:
                check = daobh30.inserePlanodebuscaOficial(pessoaBusca);
                break;
            case 3:
                check = daobh30.inserePlanodebuscaTTC(pessoaBusca);
                break;
            case 4:
                check = daobh30.inserePlanodebuscaCivil(pessoaBusca);
                break;
            default:
                break;
        }
        if (check == true) {
            Pessoal_movi servidormove = new Pessoal_movi();
            servidormove.setUsercadmov(pessoaBusca.getUser());
            servidormove.setIpcadmov(pessoaBusca.getIpcad());
            servidormove.setNip(pessoaBusca.getNip());
            servidormove.setDesc_mov("CADASTRADO PLANO DE BUSCA");
            check = daobh30.insereMov(servidormove, pessoaBusca.getTipo());
        } else {
            return false;
        }
        return check;
    }

    protected static boolean attBusca(Pessoal_busca pessoalBusca) {
        Pessoal_busca busca = new Pessoal_busca();
        boolean check = false;
        switch (pessoalBusca.getTipo()) {
            case 1:
                busca = daobh30.planodebuscaPraca(pessoalBusca.getNip());
                check = daobh30.attPlanodebuscaPraca(pessoalBusca);
                break;
            case 2:
                busca = daobh30.planodebuscaOficial(pessoalBusca.getNip());
                check = daobh30.attPlanodebuscaOficial(pessoalBusca);
                break;
            case 3:
                busca = daobh30.planodebuscaTTC(pessoalBusca.getNip());
                check = daobh30.attPlanodebuscaTTC(pessoalBusca);
                break;
            case 4:
                busca = daobh30.planodebuscaCivil(pessoalBusca.getNip());
                check = daobh30.attPlanodebuscaCivil(pessoalBusca);
                break;
            default:
                break;
        }
        if (check == true) {
            Pessoal_movi servidormove = new Pessoal_movi();
            servidormove.setUsercadmov(pessoalBusca.getUser());
            servidormove.setIpcadmov(pessoalBusca.getIpcad());
            servidormove.setNip(pessoalBusca.getNip());
            if (!busca.getCep().equals(pessoalBusca.getCep())) {
                servidormove.setDesc_mov("CEP ALTERADO DE: " + busca.getCep() + " PARA: " + pessoalBusca.getCep());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
            if (!busca.getLogradouro().equals(pessoalBusca.getLogradouro())) {
                servidormove.setDesc_mov("LOGRADOURO ALTERADO DE: " + busca.getLogradouro() + " PARA: " + pessoalBusca.getLogradouro());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
            if (!busca.getNumero().equals(pessoalBusca.getNumero())) {
                servidormove.setDesc_mov("NUMERO ALTERADO DE: " + busca.getNumero() + " PARA: " + pessoalBusca.getNumero());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
            if (!busca.getComplemento().equals(pessoalBusca.getComplemento())) {
                servidormove.setDesc_mov("COMPLEMENTO ALTERADO DE: " + busca.getComplemento() + " PARA: " + pessoalBusca.getComplemento());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
            if (!busca.getBairro().equals(pessoalBusca.getBairro())) {
                servidormove.setDesc_mov("BAIRRO ALTERADO DE: " + busca.getBairro() + " PARA: " + pessoalBusca.getBairro());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
            if (!busca.getCidade().equals(pessoalBusca.getCidade())) {
                servidormove.setDesc_mov("CIDADE ALTERADO DE: " + busca.getCidade() + " PARA: " + pessoalBusca.getCidade());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
            if (!busca.getUf().equals(pessoalBusca.getUf())) {
                servidormove.setDesc_mov("UF ALTERADO DE: " + busca.getUf() + " PARA: " + pessoalBusca.getUf());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
            if (!busca.getTelefone().equals(pessoalBusca.getTelefone())) {
                servidormove.setDesc_mov("TELEFONE ALTERADO DE: " + busca.getTelefone() + " PARA: " + pessoalBusca.getTelefone());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
            if (!busca.getCelular().equals(pessoalBusca.getCelular())) {
                servidormove.setDesc_mov("CELULAR ALTERADO DE: " + busca.getCelular() + " PARA: " + pessoalBusca.getCelular());
                check = daobh30.insereMov(servidormove, pessoalBusca.getTipo());
            }
        } else {
            return false;
        }
        return check;
    }

    protected static Pessoal_busca getBuscar(HttpServletRequest request) {
        Map mapRequest = request.getParameterMap();
        Map.Entry entryRequest;
        Iterator iteratorRequest = mapRequest.entrySet().iterator();
        String key;
        Pessoal_busca RetornoBusca = new Pessoal_busca();
        while (iteratorRequest.hasNext()) {
            entryRequest = (Map.Entry) iteratorRequest.next();
            key = (String) entryRequest.getKey();
            if (key.equals("nip")) {
                RetornoBusca.setNip(request.getParameterValues(key)[0]);
            }
            if (key.equals("cep")) {
                RetornoBusca.setCep(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("numero")) {
                RetornoBusca.setNumero(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("logradouro")) {
                RetornoBusca.setLogradouro(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("complemento")) {
                RetornoBusca.setComplemento(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("bairro")) {
                RetornoBusca.setBairro(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("cidade")) {
                RetornoBusca.setCidade(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("uf")) {
                RetornoBusca.setUf(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("telefone")) {
                RetornoBusca.setTelefone(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("celular")) {
                RetornoBusca.setCelular(request.getParameterValues(key)[0]);
            }
            if (key.equals("type")) {
                RetornoBusca.setTipo(Integer.parseInt(request.getParameterValues(key)[0]));
            }
            if (key.equals("encontrou")) {
                RetornoBusca.setEncontrou(Integer.parseInt(request.getParameterValues(key)[0]));
            }
            if (key.equals("user")) {
                RetornoBusca.setUser(request.getParameterValues(key)[0]);
            }
        }
        RetornoBusca.setIpcad(request.getRemoteAddr());
        return RetornoBusca;
    }

    protected static boolean encontrou(int tipo, String nip) {
        boolean check = false;
        switch (tipo) {
            case 1:
                check = daobh30.checkPlanodebuscaPraca(nip);
                break;
            case 2:
                check = daobh30.checkPlanodebuscaOficial(nip);
                break;
            case 3:
                check = daobh30.checkPlanodebuscaTTC(nip);
                break;
            case 4:
                check = daobh30.checkPlanodebuscaCivil(nip);
                break;
        }
        return check;
    }

    protected static Pessoal_model getBusca(HttpServletRequest request) {
        Pessoal_model servidor = new Pessoal_model();
        String dia = "", mes = "", ano = "", nasc = "";
        Map mapRequest = request.getParameterMap();
        Map.Entry entryRequest;
        Iterator iteratorRequest = mapRequest.entrySet().iterator();
        String key;
        while (iteratorRequest.hasNext()) {
            entryRequest = (Map.Entry) iteratorRequest.next();
            key = (String) entryRequest.getKey();
            if (key.equals("nome")) {
                servidor.setNome(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("nip")) {
                servidor.setNip(request.getParameterValues(key)[0]);
            }
            if (key.equals("grad")) {
                servidor.setGrad(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("quadro")) {
                servidor.setQuadro(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("esp")) {
                servidor.setEsp(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("ramal")) {
                servidor.setRamal(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("dep")) {
                servidor.setDep(Integer.parseInt(request.getParameterValues(key)[0]));
            }
            if (key.equals("div")) {
                servidor.setDiv(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("guerra")) {
                servidor.setGuerra(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("promo")) {
                servidor.setPromo(request.getParameterValues(key)[0]);
            }
            if (key.equals("nasc")) {
                servidor.setNasc(request.getParameterValues(key)[0]);
            }
            if (key.equals("emb")) {
                servidor.setEmb(request.getParameterValues(key)[0]);
            }
            if (key.equals("funcao")) {
                servidor.setFuncao(request.getParameterValues(key)[0].toUpperCase());
            }
            if (key.equals("os")) {
                servidor.setOs(request.getParameterValues(key)[0]);
            }
            if (key.equals("ass")) {
                servidor.setAss(request.getParameterValues(key)[0]);
            }
            if (key.equals("user")) {
                servidor.setUsercad(request.getParameterValues(key)[0]);
            }
            if (key.equals("id")) {
                servidor.setId(Integer.parseInt(request.getParameterValues(key)[0]));
            }
            if (key.equals("type")) {
                servidor.setType(Integer.parseInt(request.getParameterValues(key)[0]));
            }
        }
        servidor.setIpcad(request.getRemoteAddr());
        return servidor;
    }

    protected static Pessoal_model attPessoal(Pessoal_model servidor) {
        boolean check = false;
        Pessoal_model servidor2;
        switch (servidor.getType()) {
            case 1:
                servidor2 = daobh30.buscaPraca(servidor.getNip());
                check = daobh30.attPraca(servidor);
                if (check == true) {
                    check = setAlteracao(servidor, servidor2);
                }
                break;
            case 2:
                servidor2 = daobh30.buscaOficial(servidor.getNip());
                check = daobh30.attOficial(servidor);
                if (check == true) {
                    check = setAlteracao(servidor, servidor2);
                }
                break;
            case 3:
                servidor2 = daobh30.buscaTTC(servidor.getNip());
                check = daobh30.attTTC(servidor);
                if (check == true) {
                    check = setAlteracao(servidor, servidor2);
                }
                break;
            case 4:
                servidor2 = daobh30.buscaCivil(servidor.getNip());
                check = daobh30.attCivil(servidor);
                if (check == true) {
                    check = setAlteracao(servidor, servidor2);
                }
                break;
            default:
                break;
        }
        if (check) {
            return servidor;
        } else {
            return null;
        }
    }

    private static boolean setAlteracao(Pessoal_model servidor, Pessoal_model servidor2) {
        Pessoal_movi servidormove = new Pessoal_movi();
        servidormove.setUsercadmov(servidor.getUsercad());
        servidormove.setIpcadmov(servidor.getIpcad());
        servidormove.setNip(servidor.getNip());
        boolean check = false;
        if (!servidor2.getNome().equals(servidor.getNome())) {
            servidormove.setDesc_mov("NOME ALTERADO DE: " + servidor2.getNome() + " PARA: " + servidor.getNome());
            check = daobh30.insereMov(servidormove, servidor.getType());
        }
        if (!servidor2.getNip().equals(servidor.getNip())) {
            servidormove.setDesc_mov("NIP ALTERADO DE: " + servidor2.getNip() + " PARA: " + servidor.getNip());
            check = daobh30.insereMov(servidormove, servidor.getType());
        }
        if (!servidor2.getGrad().equals(servidor.getGrad())) {
            servidormove.setDesc_mov("POSTO/GRADUAÇÃO DE: " + graduacao(servidor2.getGradInt()) + " ALTERADO PARA: " + graduacao(Integer.parseInt(servidor.getGrad())));
            check = daobh30.insereMov(servidormove, servidor.getType());
        }
        if (servidor.getType() != 4) {
            if (!servidor2.getQuadro().equals(servidor.getQuadro())) {
                servidormove.setDesc_mov("QUADRO ALTERADO DE: " + servidor2.getQuadro() + " PARA: " + servidor.getQuadro());
                check = daobh30.insereMov(servidormove, servidor.getType());
            }
            if (!servidor2.getEsp().equals(servidor.getEsp())) {
                servidormove.setDesc_mov("ESPECIALIDADE ALTERADO DE: " + servidor2.getEsp() + " PARA: " + servidor.getEsp());
                check = daobh30.insereMov(servidormove, servidor.getType());
            }

            if (!servidor2.getGuerra().equals(servidor.getGuerra())) {
                servidormove.setDesc_mov("NOME DE GUERRA ALTERADO DE: " + servidor2.getGuerra() + " PARA: " + servidor.getGuerra());
                check = daobh30.insereMov(servidormove, servidor.getType());
            }

            if (!servidor2.getPromo().equals(servidor.getPromo())) {
                servidormove.setDesc_mov("DATA DE PROMOÇÃO ALTERADO DE: " + servidor2.getPromoCad() + " PARA: " + servidor.getPromoCad());
                check = daobh30.insereMov(servidormove, servidor.getType());
            }
        }

        if (!servidor2.getRamal()
                .equals(servidor.getRamal())) {
            servidormove.setDesc_mov("RAMAL ALTERADO DE: " + servidor2.getRamal() + " PARA: " + servidor.getRamal());
            check = daobh30.insereMov(servidormove, servidor.getType());
        }

        if (servidor2.getDep()
                != servidor.getDep()) {
            servidormove.setDesc_mov("DEPARTAMENTO ALTERADO DE: " + servidor2.getDep() + " PARA: " + servidor.getDep());
            check = daobh30.insereMov(servidormove, servidor.getType());
        }

        if (!servidor2.getDiv()
                .equals(servidor.getDiv())) {
            servidormove.setDesc_mov("DIVISÃO ALTERADO DE: " + servidor2.getDiv() + " PARA: " + servidor.getDiv());
            check = daobh30.insereMov(servidormove, servidor.getType());
        }

        if (!servidor2.getNasc()
                .equals(servidor.getNasc())) {
            servidormove.setDesc_mov("DATA DE NASCIMENTO ALTERADO DE: " + servidor2.getNascCad() + " PARA: " + servidor.getNascCad());
            check = daobh30.insereMov(servidormove, servidor.getType());
        }

        if (!servidor2.getEmb()
                .equals(servidor.getEmb())) {
            servidormove.setDesc_mov("DATA DE EMBARQUE ALTERADO DE: " + servidor2.getEmbCad() + " PARA: " + servidor.getEmbCad());
            check = daobh30.insereMov(servidormove, servidor.getType());
        }

        if (!servidor2.getFuncao()
                .equals(servidor.getFuncao())) {
            servidormove.setDesc_mov("FUNÇÃO ALTERADO DE: " + servidor2.getFuncao() + " PARA: " + servidor.getFuncao());
            check = daobh30.insereMov(servidormove, servidor.getType());
        }

        if (servidor2.getOs()
                != null) {
            if (!servidor2.getOs().equals(servidor.getOs())) {
                servidormove.setDesc_mov("OS ALTERADO DE: " + servidor2.getOs() + " PARA: " + servidor.getOs());
                check = daobh30.insereMov(servidormove, servidor.getType());
            }
        }
        return check;
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

}
