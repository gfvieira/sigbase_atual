package src.filtro;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.modelo.Usuario;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    private ServletContext context;
    private Usuario usuario;

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        if (session != null) {
            usuario = (Usuario) session.getAttribute("usuario"); ///verificar excessao 
        }

        String uri = req.getRequestURI();
        this.context.log("Requested Resource:: " + uri);

        String url = "/sigbase/";

        boolean check;
        if (uri.equals(url + "loginSigbase.jsp") //pagina
                || uri.equals(url + "ErrorPage.jsp")//servlet/ErrorPage.jsp
                || uri.equals(url + "LoginSig.jsp")//servlet
                || uri.equals(url + "bhmn/bh05/InsereMsg.jsp")//servlet
                || uri.equals(url + "bhmn/bh30/chapa/ExibeFila.jsp") //
                || uri.equals(url + "pesquisa/ResultadoPremiomais.jsp")//servlet
                || uri.equals(url + "pesquisa/ClimaOrg.jsp")//servlet
                || uri.equals(url + "pesquisa/ResultadoClimaOrg.jsp")//servlet
                //----------------------------------------------------------------------- pedidos
                || uri.equals(url + "telematica/Sate.jsp")//servlet
                || uri.equals(url + "telematica/ConsultOs.jsp")//servlet
                || uri.equals(url + "telematica/SateConsult.jsp")//servlet
                || uri.equals(url + "oficina/OficinaBh50.jsp")//servlet
                || uri.equals(url + "oficina/OficinaBh50Consult.jsp")//servlet
                || uri.equals(url + "oficina/OficinaBh50ConsultOs.jsp")//servlet
                //----------------------------------------------------------------------- end pedidos
                || uri.equals(url + "secom/ListarFile.jsp")//servlet
                || uri.equals(url + "/sigbase/bhmn/bh08/teste3.jsp")//servlet //verificar
                || uri.equals(url + "sistemas/servico/trocadeServico.jsp") //pagina
                || uri.equals(url + "sistemas/servico/logintrocaServico.jsp")//pagina 
                || uri.equals(url + "chm/mare/mare.jsp")//pagina 
                || uri.equals(url + "chm/mare/pdf.jsp")//pagina 
                || uri.equals(url + "chm/mare/pdf2.jsp")//pagina 
                || uri.equals(url + "chm/Mare.jsp")
                || uri.equals(url + "chm/Tempo.jsp")) {
            check = true;
        } else if (usuario != null) {
            if ((uri.equals(url + "admin/admin_home.jsp")
                    || uri.equals(url + "admin/admin_cadastro.jsp")
                    || uri.equals(url + "admin/ListarUsuariosAdmin.jsp")
                    || uri.equals(url + "admin/ListarUsuariosLogon.jsp")
                    || uri.equals(url + "admin/LogOff.jsp")
                    || uri.equals(url + "admin/ExibirUsuarioAdmin.jsp")
                    || uri.equals(url + "admin/AttUsuarioAdmin.jsp")
                    || uri.equals(url + "admin/CadastroAdmin.jsp"))
                    && usuario.getPri().equals("ADMIN")) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh08/bh08_home.jsp")
                    || uri.equals(url + "bhmn/bh08/ChartsEl.jsp")
                    || uri.equals(url + "bhmn/bh08/ChartsAg.jsp")
                    || uri.equals(url + "bhmn/bh08/ChartsAno.jsp")
                    || uri.equals(url + "bhmn/bh08/bh08_inserir.jsp")
                    || uri.equals(url + "bhmn/bh08/CadConsumo.jsp"))
                    && (usuario.getPri().equals("BH08")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh10/bh10_home.jsp") //
                    || uri.equals(url + "bhmn/bh10/bh10_meta_inserir.jsp")//
                    || uri.equals(url + "bhmn/bh10/InsereMeta.jsp")//
                    || uri.equals(url + "bhmn/bh10/ListaMeta.jsp")//
                    || uri.equals(url + "bhmn/bh10/UpdateMeta.jsp")//
                    || uri.equals(url + "bhmn/bh10/pessoal/ListPessoal.jsp") //
                    || uri.equals(url + "bhmn/bh10/pessoal/ExibePessoal.jsp") //
                    || uri.equals(url + "bhmn/bh10/pessoal/FeriasControlePessoal.jsp") //
                    || uri.equals(url + "bhmn/bh10/folhaN/folhan_home.jsp") //
                    || uri.equals(url + "bhmn/bh10/folhaN/folhan_exibe.jsp") //
                    || uri.equals(url + "bhmn/bh10/folhaN/ExibeFolha.jsp") //
                    || uri.equals(url + "bhmn/bh10/folhaN/ExibeOM.jsp") //
                    || uri.equals(url + "bhmn/bh10/folhaN/teste.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/Cad_Indicador.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/Exibe_indicador.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/Att_indicador.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/Update_indicador.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indicador_bh11_iaeq.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indicador_bh11_iaer.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indicador_bh11_iaso.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indicador_bh12_iid.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indicador_bh12_imnp.jsp")
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indicador_bh12_imnq.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indicadores.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indi_cad.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indi_list.jsp") //
                    || uri.equals(url + "bhmn/bh10/indicadores/bh10_indi_update.jsp")) //
                    && (usuario.getPri().equals("BH10")
                    || usuario.getPri().equals("BH10")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh30/bh30_home.jsp")//
                    || uri.equals(url + "bhmn/bh30/bh30_meta_inserir.jsp")//
                    || uri.equals(url + "bhmn/bh30/InsereMeta.jsp")//
                    || uri.equals(url + "bhmn/bh30/ListaMeta.jsp")//
                    || uri.equals(url + "bhmn/bh30/UpdateMeta.jsp")//
                    || uri.equals(url + "bhmn/bh30/indicador/bh30_indicadores.jsp")//
                    || uri.equals(url + "bhmn/bh30/indicador/Exibe_indicador_30.jsp")//Exibe_indicador_30.jsp
                    )
                    && (usuario.getPri().equals("BH30")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh30/bh31/BH31.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/bh31_ferias.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh31/bh31_dbq.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh31/bh31_buscar.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh31/bh31_cadastrar_civil.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh31/bh31_cadastrar_praca.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh31/bh31_cadastrar_oficial.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh31/bh31_cadastrar_ttc.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh31/trocar.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/BuscarPessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/ListPessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/ExibePessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/AttPessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/AttBusca.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/DBQPessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/FeriasPessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/FeriasControlePessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/bh31_buscar_ferias.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh31/BuscarFerias.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/Ferias.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/ListarFerias.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/DeleteFerias.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh31/CadPessoal.jsp"))//servlet
                    && (usuario.getPri().equals("BH31")
                    || usuario.getPri().equals("BH30")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh30/sargenteante/Sargenteante.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteListaPessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteExibePessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteAttPessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteAttBusca.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteListarFerias.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteDeleteFerias.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteFeriasPessoal.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteFeriasControle.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/sargenteante/SargenteanteFerias.jsp"))//servlet
                    && (usuario.getPri().equals("SARGENTEANTE")
                    || usuario.getPri().equals("BH30")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh30/bh33/bh33_home.jsp")//pagina
                    //|| uri.equals(url + "bhmn/bh30/bh34/oficina34_host_cadastro_1.jsp")//pagina
                    ) //servlet
                    && (usuario.getPri().equals("BH33")
                    || usuario.getPri().equals("BH30")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh30/bh34/oficina34_host_cadastro.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh34/oficina34_host_cadastro_1.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh34/oficina34_host_alterar.jsp")// pagina
                    || uri.equals(url + "bhmn/bh30/bh34/oficina34_sate.jsp")// pagina
                    || uri.equals(url + "bhmn/bh30/bh34/oficina34_por_periodo.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh34/oficina34_sw.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/bh34/ListarFile34.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/UploadFile34.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/RetiraSw.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/InsertSate.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/List.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/Hosts.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/BH34.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/bh34/BH34_anual.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/bh34/BH34_periodo.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/bh34/Exibe_indicador_34.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/bh34/OsManage.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/Movimentacao.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/Finaly.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/trocarbh34.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/TrocarOf.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/Priori34.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/Hosts.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/HostIp.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/Feedback.jsp")//servlet
                    || uri.equals(url + "bhmn/bh30/bh34/RecusarOs.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/bh34/AlterarIp.jsp")) //servlet
                    && (usuario.getPri().equals("BH34")
                    || usuario.getPri().equals("BH30")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh30/chapa/bh30_chapa.jsp")//pagina
                    || uri.equals(url + "bhmn/bh30/chapa/bh30_chapa_cadfila.jsp") //pagina
                    || uri.equals(url + "bhmn/bh30/chapa/CadFila.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/chapa/ExibeFila.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/chapa/ExibirAptos.jsp") //servlet                    
                    || uri.equals(url + "bhmn/bh30/chapa/RetiraFila.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/chapa/EditMilitar.jsp") //servletbh30_chapa_cadpermissionario
                    || uri.equals(url + "bhmn/bh30/chapa/bh30_chapa_cadpermissionario.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/chapa/bh30_chapa_buscapermissionario.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/CadPermissionario.jsp") //servlet
                    || uri.equals(url + "bhmn/bh30/chapa/RealocarPerm.jsp") //servlet//RealocarPerm//bh30_chapa_rel_permissionario.jsp
                    || uri.equals(url + "bhmn/bh30/chapa/bh30_chapa_rel_permissionario.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/ExibePermissionario.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/bh30_chapa_exibepermissionario.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/bh30_resp_busca_perm.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/BuscarChapaCadastrado.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/ExibePessoal.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/AtualizaPermissionario.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/RetiraPermissionario.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/ListaCadPermissionario.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/bh30_chapa_buscachapa.jsp")
                    || uri.equals(url + "bhmn/bh30/chapa/bh30_chapa_exibeApto.jsp")
                    )
                    && (usuario.getPri().equals("CHAPA")
                    || usuario.getPri().equals("BH30")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh50/BH50.jsp")//
                    || uri.equals(url + "bhmn/bh50/bh50_meta_inserir.jsp")//
                    || uri.equals(url + "bhmn/bh50/InsereMeta.jsp")//
                    || uri.equals(url + "bhmn/bh50/ListaMeta.jsp")//
                    || uri.equals(url + "bhmn/bh50/UpdateMeta.jsp")//
                    || uri.equals(url + "bhmn/bh50/OfList.jsp")//
                    || uri.equals(url + "bhmn/bh50/OsManage50.jsp")//
                    || uri.equals(url + "bhmn/bh50/Movi50.jsp")//
                    || uri.equals(url + "bhmn/bh50/Finaly50.jsp")//
                    || uri.equals(url + "bhmn/bh50/TrocarOf50.jsp")//
                    || uri.equals(url + "bhmn/bh50/UploadFile50.jsp")//
                    || uri.equals(url + "bhmn/bh50/oficina50_por_periodo.jsp")//
                    || uri.equals(url + "bhmn/bh50/bh50_pedidos_por_oficina.jsp")///bhmn/bh50/ListarPorOficina.jsp
                    || uri.equals(url + "bhmn/bh50/ListarPorOficina.jsp")///
                    || uri.equals(url + "bhmn/bh50/BH50_periodo.jsp")//
                    || uri.equals(url + "bhmn/bh50/Priori50.jsp")//
                    || uri.equals(url + "bhmn/bh50/RecusaOs50.jsp")//
                    || uri.equals(url + "bhmn/bh50/bh50_indicadores.jsp")//
                    || uri.equals(url + "bhmn/bh50/BH50_anual.jsp")//
                    || uri.equals(url + "bhmn/bh50/oficina50_cad_viatura.jsp")
                    || uri.equals(url + "bhmn/bh50/OficinaBh50_cadViatura.jsp"))//
                    && (usuario.getPri().equals("BH50")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/secom/secom_home.jsp")//
                    || uri.equals(url + "bhmn/secom/secom_enviar.jsp")//
                    || uri.equals(url + "bhmn/secom/UploadFile.jsp")//
                    || uri.equals(url + "bhmn/secom/RetiraDoc.jsp")//
                    || uri.equals(url + "bhmn/secom/ListarFile.jsp"))//
                    && (usuario.getPri().equals("BH04")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "bhmn/cmd_home.jsp")
                    || uri.equals(url + "bhmn/ListaMeta.jsp")
                    || uri.equals(url + "bhmn/ListarOuvidoria.jsp")
                    || uri.equals(url + "cmd/teste2.jsp"))//
                    && usuario.getPri().equals("TOTAL")) {
                check = true;
            } else if ((uri.equals(url + "bhmn/bh20/bh25/Contador25.jsp")//SERVLET
                    || uri.equals(url + "bhmn/bh20/bh20_home.jsp")//Servlet
                    || uri.equals(url + "bhmn/bh20/bh25/bh25_home.jsp")//JSP
                    || uri.equals(url + "bhmn/bh20/bh25/bh25_diario.jsp")//JSP
                    || uri.equals(url + "bhmn/bh20/bh25/bh25_semanal.jsp")//JSP
                    || uri.equals(url + "bhmn/bh20/bh20_meta_inserir.jsp")//JSP
                    || uri.equals(url + "bhmn/bh20/InsereMeta.jsp")//Servlet
                    || uri.equals(url + "bhmn/bh20/ListaMeta.jsp")//Servlet
                    || uri.equals(url + "bhmn/bh20/UpdateMeta.jsp")//Servlet
                    || uri.equals(url + "bhmn/bh20/bh25/Pergunta.jsp")//Servlet
                    || uri.equals(url + "bhmn/bh20/bh25/Controle.jsp")//Servlet
                    || uri.equals(url + "bhmn/bh20/bh25/History.jsp")//Servlet
                    || uri.equals(url + "bhmn/bh20/bh25/ContadorDiario.jsp")//Servlet
                    || uri.equals(url + "bhmn/bh20/bh25/ContadorSemanal.jsp"))//Servlet
                    && (usuario.getPri().equals("BH25")
                    || usuario.getPri().equals("BH20")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if ((uri.equals(url + "identificador/Contador.jsp") //
                    || uri.equals(url + "identificador/Cad_Identi.jsp")//
                    || uri.equals(url + "identificador/Listar_identi.jsp")//
                    || uri.equals(url + "identificador/identi_cad_estacionamento.jsp")
                    || uri.equals(url + "identificador/identi_cad_cracha.jsp"))
                    && (usuario.getPri().equals("BH")
                    || usuario.getPri().equals("BH")
                    || usuario.getPri().equals("TOTAL"))) {
                check = true;
            } else if (uri.equals(url + "redefinir_senha.jsp")
                    || uri.equals(url + "AltSenha.jsp")) {
                check = true;
            } else if (uri.equals(url + "LogOff.jsp")) {
                session.invalidate();
                check = false;
            } else {
                check = false;
            }
        } else {
            check = false;
        }
        if (check == false) {// implementar log de recusa de acesso
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String d = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(tm);
            this.context.log("====== ACESSO NAO AUTORIZADO PARA IP: " + request.getRemoteAddr() + " "
                    + "AS " + d);
            res.sendRedirect(url + "loginSigbase.jsp");
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        //close any resources here
    }

}
