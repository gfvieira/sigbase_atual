<%@page import="src.modelo.Chapa_model"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");%>
<%String temp = (String) request.getAttribute("mensagem");
    String apto = (String) request.getParameter("apto");
    String bloco = (String) request.getParameter("bloco");
    ArrayList<Chapa_model> chapaarray = (ArrayList<Chapa_model>) request.getAttribute("chapa");
    Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);
%>



<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE || CHaPA</title>
        <!--<link rel="shortcut icon" href="assets/images/gt_favicon.png">-->
        <!-- Bootstrap core CSS -->
        <link href="assets2/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets2/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link href="assets2/js/fullcalendar/bootstrap-fullcalendar.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets2/css/style.css" rel="stylesheet">
        <link href="assets2/css/style-responsive.css" rel="stylesheet">
        <script language=javascript type="text/javascript">
            dayName = new Array("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
            monName = new Array("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
            now = new Date;

        </script>

        <script src="assets2/js/time_session.js" type="text/javascript"></script>



        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body onload="time()">

        <section id="container" >
            <!-- **********************************************************************************************************************************************************
            TOP BAR CONTENT & NOTIFICATIONS
            *********************************************************************************************************************************************************** -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="#" class="logo"><b>SIG-BASE || CHaPA</b></a>
                <!--logo end-->
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li>
                            <div style="margin-top: 22px; margin-right: 20px; color: white">
                                <div id="timeout"></div>
                            </div>
                        </li>
                        <li class="dropdown active">
                            <div class="btn-group" style="margin-top: 15px">
                                <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-cog"></i> <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li><a href="#">Perfil</a></li>
                                    <li><a href="#">Alterar Senha</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="/sigbase/LogOff.jsp">Sair</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                </div>
                <!--main content end-->
                <!--footer start-->
                <footer class="site-footer">
                    <div class="text-center">
                        <%out.print(year);%> - BHMN
                    </div>
                </footer>
                <!--footer end-->
            </header>
            <!--header end-->

            <!-- **********************************************************************************************************************************************************
            MAIN SIDEBAR MENU
            *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <aside>
                <div id="sidebar"  class="nav-collapse ">
                    <ul class="sidebar-menu" id="nav-accordion">
                        <li><h5 class="centered"><%out.print(usuario.getPost());%>-<%out.print(usuario.getGuerra());%></h5></li>
                        <li><h5 class="centered"> 
                                <script language=javascript type="text/javascript">
                                    document.write(dayName[now.getDay() ] + ", " + now.getDate() + " de " + monName [now.getMonth() ] + " de " + now.getFullYear());
                                </script>
                            </h5></li>
                        <li><h5 class="centered"></h5></li>
                            <%if (usuario.getPri().equals("TOTAL")) {%>
                        <li class="mt">
                            <a class="active" href="../../cmd_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal <%out.print(usuario.getSetor());%></span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="../bh30_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-30</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="bh30_chapa.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal CHaPA</span>
                            </a>
                        </li>
                        <%} else if (usuario.getPri().equals("BH30")) {%>
                        <li class="mt">
                            <a class="active" href="../bh30_home.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-30</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a  href="bh30_chapa.jsp">
                                <i class="fa fa-desktop"></i>
                                <span>Principal CHaPA</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="bh30_chapa.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-book"></i>
                                <span>Fila</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh30_chapa_cadfila.jsp">Cadastrar</a></li>
                                <li><a href="ExibeFila.jsp?type=home">Listar</a></li>
                            </ul>
                        </li> 
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-book"></i>
                                <span>Apartamentos</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh30_chapa_buscapermissionario.jsp">Buscar Permissionário</a></li>
                                <li><a href="RealocarPerm.jsp">Realocar Permissionário</a></li>
                                <li><a href="ExibirAptos.jsp?blc=223">Bloco 223</a></li>
                                <li><a href="ExibirAptos.jsp?blc=243A">Bloco 243A</a></li>
                                <li><a href="ExibirAptos.jsp?blc=243B">Bloco 243B</a></li>
                                <li><a href="ExibirAptos.jsp?blc=254">Bloco 254</a></li>
                                <li><a href="ExibirAptos.jsp?blc=308A">Bloco 308A</a></li>
                                <li><a href="ExibirAptos.jsp?blc=308B">Bloco 308B</a></li>
                                <li><a href="ExibirAptos.jsp?blc=331A">Bloco 331A</a></li>
                                <li><a href="ExibirAptos.jsp?blc=331B">Bloco 331B</a></li>
                                <li><a href="ExibirAptos.jsp?blc=338">Bloco 338</a></li>
                                <li><a href="ExibirAptos.jsp?blc=372">Bloco 372</a></li>
                                <li><a href="ExibirAptos.jsp?blc=416A">Bloco 416A</a></li>
                                <li><a href="ExibirAptos.jsp?blc=416B">Bloco 416B</a></li>
                            </ul>
                        </li> 
                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="col-md-12 mt">
                        <form enctype="multipart/form-data" class="form-horizontal style-form" name="chapacadastro" action="CadPermissionario.jsp" method="post">
                            <div class="form-panel">
                                <%if (temp != null) {
                                    if (temp.equals("OK")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> Militar cadastrado com sucesso.</div>
                                <%} else if (temp.equals("EXIST")) {%>
                                <div class="alert alert-warning centered"><b>Erro!</b> Militar já cadastrado.</div>
                                <%} else {%>
                                <div class="alert alert-danger centered"><b>Erro!</b> A operação não pode ser concluida.</div>      				
                                <%}
                                }%>

                                <input type="hidden" id="apto" name="apto" value="<%out.print(apto);%>" > 
                                <input type="hidden" id="qtdCarros" name="qtdCarros" value="" > 
                                <input type="hidden" id="qtdDep" name="qtdDep" value="1" > 
                                <input type="hidden" id="bloco" name="bloco" value="<%out.print(bloco);%>" >
                                <input type="hidden" id="nomeHidden" name="nomeHidden"><!--Existe -->
                                <input type="hidden" id="nipHidden" name="nipHidden" ><!--Existe -->
                                <input type="hidden" id="msgHidden" name="msgHidden" ><!--Existe -->
                                <!--input type="hidden" id="rgHidden" name="rgHidden" >
                                <input type="hidden" id="cpfHidden" name="cpfHidden" >
                                <input type="hidden" id="enderecoHidden" name="enderecoHidden" -->
                                <input type="hidden" id="omHidden" name="omHidden" value><!--Existe -->
                                <input type="hidden" id="gradHidden" name="gradHidden" ><!--Existe -->
                                <input type="hidden" id="ramalHidden" name="ramalHidden" ><!--Existe -->
                                <!--input type="hidden" id="telefoneHidden" name="telefoneHidden" >
                                <input type="hidden" id="celularHidden" name="celularHidden" -->

                                <h3 class="centered"><i class="fa fa-angle-double-right"></i><b> Cadastro de Permissionário</b></h3><br><br>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Apartamento</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control" id="aptoText" name="aptoText" required value="<%out.print(apto);%>" disabled>
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Bloco</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control" id="blocoText" name="blocoText" required value="<%out.print(bloco);%>" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Nome</label>
                                    <div class="col-sm-4">
                                        <select class="form-control" name="nome" onchange="buscaInformacoes(document.chapacadastro.nome.value);" required>
                                            <option value="selecione">Selecione!</option>
                                            <%for (int i = 0; i < chapaarray.size(); i++) {
                                            %>
                                            <option value="<%out.print(chapaarray.get(i).getNome());%>"><%out.print(chapaarray.get(i).getNome());%></option>
                                            <%}%>
                                        </select>

                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">NIP</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control" id="nip" name="nip" value="" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Graduação</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" id="grad" name="grad" value="" disabled>
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">OM</label>
                                    <div class="col-sm-2">
                                        <input class="form-control" id="om" name="om" value="" disabled>                                            
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">MSG</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="msg" name="msg" value="" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">RG</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="rg" name="rg" required>
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;" >CPF</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="cpf" name="cpf" required>
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;" >Estado Civil</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="estadoCivil" required>
                                            <option value="">Selecione!</option>
                                            <option value="1">Solteiro(a)</option>
                                            <option value="2">Casado(a)</option>
                                            <option value="3">Divorciado(a)</option>
                                            <option value="4">Viúvo(a)</option>
                                            <option value="5">Separado(a)</option>
                                            <option value="6">Companheiro(a)</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Endereço</label>
                                    <div class="col-sm-7">
                                        <input type="text"  class="form-control" id="endereco" name="endereco" value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Ramal</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="ramal" name="ramal" value="" disabled>
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">Telefone</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="telefone" name="telefone" value="" >
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">Celular</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="celular" name="celular" value="" >
                                    </div>
                                </div>
                            </div>
                            <div class="form-panel">
                                <h3 class="centered"><i class="fa fa-angle-double-right"></i><b> Veículos</b></h3><br><br>
                                <div class="form-group" id="divVei">
                                </div>
                                <button type="button" title="Adicionar Veículo" class="btn btn-primary btn-xs center-block" onclick="addVeiculos();"><i class="glyphicon glyphicon-plus"></i> Veículo</button><br><br>                                
                            </div>
                            <div class="form-panel">
                                <h3 class="centered"><i class="fa fa-angle-double-right"></i><b> Dependentes</b></h3><br><br>
                                <div class="form-group" id="divDep">
                                    <div id="divDep0">
                                        <div class="row">
                                            <label class="col-sm-2  control-label" style="text-align:right;">Nome</label>
                                            <div class="col-sm-3"><input type="text"  class="form-control" id="nomeDep0" name="nomeDep0" value="" required></div>
                                            <label class="col-sm-1 control-label" style="text-align:right;">Parentesco</label>
                                            <div class="col-sm-2"><input type="text"  class="form-control" id="parentescoDep0" name="parentescoDep0" value="" required></div>   
                                            <label class="col-sm-1 control-label" style="text-align:right;">Idade</label>
                                            <div class="col-sm-1"><input type="text"  class="form-control" id="idadeDep0" name="idadeDep0" value="" required></div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" style="text-align:right;">Identidade</label>
                                            <div class="col-sm-3"><input type="text"  class="form-control" id="ident0" name="ident0" value="" required></div>
                                            <label class="col-sm-1 control-label" style="text-align:right;">NIP</label>
                                            <div class="col-sm-3"><input type="text"  class="form-control" id="nip0" name="nip0" value="" required></div>
                                            <!--div class="col-sm-1">
                                                <button type="button" title="Excluir Dependente" class="btn btn-danger btn-xs" onclick="excluiDep('#divDep0');"><i class="fa fa-trash-o"></i></button>
                                            </div-->
                                        </div>
                                        <br>
                                        <br>
                                        <br>
                                    </div>
                                </div>
                                <button type="button" title="Adicionar Dependentes" class="btn btn-primary btn-xs center-block" onclick="addDependentes();"><i class="glyphicon glyphicon-plus"></i> Dependente</button><br><br>
                                <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>">

                            </div>
                            <div class="form-panel">
                                <div class="row">
                                    <div class="col-sm-12" style="color: red;"> 
                                        <h4>Apêndice de Arquivos</h4>
                                        Anexe aqui os seguintes arquivos:
                                        <div class="row"></div>
                                        <div class="col-sm-12" id="declaracaoIRDiv">
                                            1º Declaração de IR do corrente ano do pretendente a permissionário e de seu conjugê;
                                            <input type="file" id="declaracaoIR" name="declaracaoIR"> 
                                        </div>
                                        <br><br><br>
                                        <div class="col-sm-12" id="recDeNaoImovelDiv">
                                            2º Declaração do pretendente a perm. e do conjugê, com firmas reconhecidas, afirmando não serem proprietários de nenhum imóvel residencial localizado no RJ;
                                            <input type="file" id="recDeNaoImovel" name="recDeNaoImovel"> 
                                        </div>
                                        <br><br><br>
                                        <div class="col-sm-12" id="identAnexoDiv">
                                            3º Cópia da identidade e                                           
                                            <input type="file" id="identAnexo" name="identAnexo"> 
                                        </div>
                                        <br><br>
                                        <div class="col-sm-12" id="cpfAnexoDiv">
                                            CPF;
                                            <input type="file" id="cpfAnexo" name="cpfAnexo"> 
                                        </div>
                                        <br><br><br>
                                        <div class="col-sm-12" id="declaracaoAtestDiv">
                                            4º Declaração de atestando conhecimento da OI 30-28B;
                                            <input type="file" id="declaracaoAtest" name="declaracaoAtest"> 
                                        </div>
                                        <br><br><br>
                                        <div class="col-sm-12" id="folhaBDPESDiv">
                                            5º Folha do BDPES onde constam os seus dependentes.
                                            <input type="file" id="folhaBDPES" name="folhaBDPES"> 
                                        </div>
                                        <br><br><br>
                                        Obs.: Caso não possua, ainda, os arquivos a serem anexados cadastre o permissionário e atualize o seu cadastro para inserir os arquivos.
                                        <br>                                        
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-theme center-block">Cadastrar</button>
                        </form>
                    </div>     
                </section>
            </section>            
        </section>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets2/js/jquery.js"></script>
        <script src="assets2/js/jquery-1.8.3.min.js"></script>
        <script src="assets2/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets2/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets2/js/jquery.scrollTo.min.js"></script>
        <script src="assets2/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="assets2/js/jquery.sparkline.js"></script>        
        <script>
                                    var contDep = 1;
                                    var contVei = 0;
                                    function buscaInformacoes(nome) {

                                        var request = $.ajax({
                                            url: "bh30_chapa_buscachapa.jsp",
                                            type: "GET",
                                            data: {nome: nome},
                                            dataType: 'json',
                                            success: function (data) {
                                                if (document.chapacadastro.nome.value === "selecione") {
                                                    document.chapacadastro.nip.value = "Selecione!";
                                                    document.chapacadastro.grad.value = "Selecione!";
                                                    document.chapacadastro.om.value = "Selecione!";
                                                    document.chapacadastro.msg.value = "Selecione!";
                                                    document.chapacadastro.ramal.value = "Selecione!";
                                                } else {
                                                    //document.chapacadastro.nip.value = data.nip.replace(/\./g, "");
                                                    document.chapacadastro.nip.value = data.nip;
                                                    document.chapacadastro.grad.value = data.grad;
                                                    document.chapacadastro.om.value = data.om;
                                                    //alert(data.msg);
                                                    document.chapacadastro.msg.value = data.msg;
                                                    document.chapacadastro.ramal.value = data.ramal;

                                                    //Atributos Hidden
                                                    document.chapacadastro.nipHidden.value = data.nip;
                                                    document.chapacadastro.gradHidden.value = data.grad;
                                                    document.chapacadastro.omHidden.value = data.om;
                                                    document.chapacadastro.msgHidden.value = data.msg;
                                                    document.chapacadastro.ramalHidden.value = data.ramal;
                                                }
                                            },
                                            error: function (data) {
                                                alert("error");
                                            },
                                            complete: function () {
                                                //alert("Fechou Ajax!");
                                            }
                                        });
                                    }

                                    function addVeiculos() {
                                        $('#divVei').append("<div id=\"divVei" + contVei + "\"><label class=\"col-sm-2  control-label\" style=\"text-align: right;\">Veículo/Modelo</label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\"  class=\"form-control\" id=\"veiculo" + contVei + "\" name=\"veiculo" + contVei + "\" value=\"\" required></div>"
                                                + "<label class=\"col-sm-1 control-label\" style=\"text-align: right;\">Placa </label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\"  class=\"form-control\" id=\"placa" + contVei + "\" name=\"placa" + contVei + "\" value=\"\" required></div>"
                                                + "<div class=\"col-sm-1\"><button type=\"button\" title=\"Excluir Veiculo\" class=\"btn btn-danger btn-xs\" onclick=\"excluiVei('#divVei" + contVei + "');\"><i class=\"fa fa-trash-o\"></i></button></div><br><br><br></div>");
                                        ++contVei;
                                        $('#qtdCarros').val(contVei);
                                    }
                                    ;

                                    function addDependentes() {
                                        $('#divDep').append("<div id=\"divDep" + contDep + "\"><div class=\"row\">"
                                                + "<label class=\"col-sm-2  control-label\" style=\"text-align: right;\">Nome</label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\" class=\"form-control\" id=\"nomeDep"
                                                + contDep + "\" name=\"nomeDep" + contDep + "\" value=\"\" required></div>"
                                                + "<label class=\"col-sm-1  control-label\" style=\"text-align: right;\">Parentesco</label>"
                                                + "<div class=\"col-sm-2\"><input type=\"text\"  class=\"form-control\" id=\"parentescoDep"
                                                + contDep + "\" name=\"parentescoDep" + contDep + "\" value=\"\" required></div>"
                                                + "<label class=\"col-sm-1  control-label\" style=\"text-align: right;\">Idade</label>"
                                                + "<div class=\"col-sm-1\"><input type=\"text\"  class=\"form-control\" id=\"idadeDep"
                                                + contDep + "\" name=\"idadeDep" + contDep + "\" value=\"\" required></div>"
                                                + "</div><br>");
                                        var div = '#divDep'.concat(contDep);
                                        $(div).append("<div class=\"row\">"
                                                + "<label class=\"col-sm-2 control-label\" style=\"text-align: right;\">Identidade</label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\"  class=\"form-control\" id=\"ident"
                                                + contDep + "\" name=\"ident" + contDep + "\" value=\"\" required></div>"
                                                + "<label class=\"col-sm-1 control-label\" style=\"text-align:right;\">NIP</label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\"  class=\"form-control\" id=\"nip\""
                                                + contDep + " name=\"nip" + contDep + "\" value=\"\"required></div>"
                                                + "<div class=\"col-sm-1\"><button type=\"button\" title=\"Excluir Dependente\" class=\"btn btn-danger btn-xs\" onclick=\"excluiDep('#divDep" + contDep + "');\"><i class=\"fa fa-trash-o\"></i></button>"
                                                + "</div><br><br><br>");
                                        ++contDep;
                                        $('#qtdDep').val(contDep);
                                    }

                                    function excluiDep(divName) {
                                        $(divName).remove();
                                        contDep--;
                                    }
                                    ;

                                    function excluiVei(divName) {
                                        $(divName).remove();
                                        contVei--;

                                    }
                                    ;


        </script>

        <!--common script for all pages-->
        <script src="assets2/js/common-scripts.js"></script>

        <script type="text/javascript" src="assets2/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="assets2/js/gritter-conf.js"></script>

    </body>
</html>
