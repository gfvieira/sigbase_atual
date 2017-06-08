<%@page import="java.sql.Timestamp"%>
<%@page import="src.modelo.Pessoal_busca"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="src.modelo.Pessoal_movi"%>
<%@page import="src.modelo.Pessoal_model"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%Pessoal_model servidor = (Pessoal_model) request.getAttribute("oficial");
Pessoal_busca busca = (Pessoal_busca) request.getAttribute("busca");
    ArrayList<Pessoal_movi> servidorarray = (ArrayList<Pessoal_movi>) request.getAttribute("oficialarray");
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    String temp = (String) request.getAttribute("mensagem");%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Timestamp tm = new Timestamp(System.currentTimeMillis());
    String year = new SimpleDateFormat("yyyy").format(tm);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">

        <title>SIG-BASE || DEPARTAMENTO PESSOAL</title>

        <!-- Bootstrap core CSS -->
        <!-- Bootstrap core CSS -->
        <link href="../../assets3/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="../../assets3/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="../../assets3/css/zabuto_calendar.css">
        <link rel="stylesheet" type="text/css" href="../../assets3/js/gritter/css/jquery.gritter.css" />
        <link rel="stylesheet" type="text/css" href="../../assets3/lineicons/style.css">    

        <!-- Custom styles for this template -->
        <link href="../../assets3/css/style.css" rel="stylesheet">
        <link href="../../assets3/css/style-responsive.css" rel="stylesheet">

        <script src="../../assets3/js/chart-master/Chart.js"></script>
        <script language=javascript type="text/javascript">
            dayName = new Array("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado");
            monName = new Array("janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro", "dezembro");
            now = new Date;
        </script>
        <script src="../../assets3/js/time_session.js" type="text/javascript"></script>

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
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Clique Aqui Para Abrir/Fechar Menu"></div>
                </div>
                <!--logo start-->
                <a href="#" class="logo"><b>SIG-BASE || Divisão de Pessoal BH-31</b></a>
                <!--logo end-->
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li>
                            <div style="margin-top: 22px; margin-right: 20px; color: white">
                                <div id="timeout"></div>
                            </div>
                        </li>
                        <li>
                            <div class="btn-group" style="margin-top: 15px">
                                <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
            </header>
            <!--header end-->

            <!-- **********************************************************************************************************************************************************
            MAIN SIDEBAR MENU
            *********************************************************************************************************************************************************** -->
            <!--sidebar start-->
            <aside>
                <div id="sidebar"  class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">
                        <h5 class="centered"><%out.print(usuario.getPost());%>-<%out.print(usuario.getGuerra());%></h5>
                        <h5 class="centered"> 
                            <script language=javascript type="text/javascript">
                                document.write(dayName[now.getDay() ] + ", " + now.getDate() + " de " + monName [now.getMonth() ] + " de " + now.getFullYear());
                            </script>
                        </h5>
                        <h5 class="centered"><div id="txt"></div></h5>
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
                            <a  href="BH31.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-31</span>
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
                            <a  href="BH31.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-desktop"></i>
                                <span>Principal BH-31</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="BH31.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal BH-31</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Cadastro</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh31_cadastrar_oficial.jsp">Oficiais</a></li>
                                <li><a href="bh31_cadastrar_praca.jsp">Praças</a></li>
                                <li><a href="bh31_cadastrar_ttc.jsp">TTC's</a></li>
                                <li><a href="bh31_cadastrar_civil.jsp">Cívis</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Tripulação</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh31_buscar.jsp">Buscar</a></li>
                                <li><a href="ListPessoal.jsp?type=0">Tripulação</a></li>
                                <li><a href="ListPessoal.jsp?type=2">Oficiais</a></li>
                                <li><a href="ListPessoal.jsp?type=1">Praças</a></li>
                                <li><a href="ListPessoal.jsp?type=15">SubOficiais</a></li>
                                <li><a href="ListPessoal.jsp?type=14">Sargentos</a></li>
                                <li><a href="ListPessoal.jsp?type=13">Cabos</a></li>
                                <li><a href="ListPessoal.jsp?type=12">Marinheiros</a></li>
                                <li><a href="ListPessoal.jsp?type=3">TTC's</a></li>
                                <li><a href="ListPessoal.jsp?type=4">Civis</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Por Departamento</span>
                            </a>
                            <ul class="sub">
                                <li><a href="ListPessoal.jsp?type2=01">BH-01</a></li>
                                <li><a href="ListPessoal.jsp?type2=02">BH-02</a></li>
                                <li><a href="ListPessoal.jsp?type2=03">BH-03</a></li>
                                <li><a href="ListPessoal.jsp?type2=04">BH-04</a></li>
                                <li><a href="ListPessoal.jsp?type2=05">BH-05</a></li>
                                <li><a href="ListPessoal.jsp?type2=06">BH-06</a></li>
                                <li><a href="ListPessoal.jsp?type2=07">BH-07</a></li>
                                <li><a href="ListPessoal.jsp?type2=08">BH-08</a></li>
                                <li><a href="ListPessoal.jsp?type2=10">BH-10</a></li>
                                <li><a href="ListPessoal.jsp?type2=20">BH-20</a></li>
                                <li><a href="ListPessoal.jsp?type2=30">BH-30</a></li>
                                <li><a href="ListPessoal.jsp?type2=40">BH-40</a></li>
                                <li><a href="ListPessoal.jsp?type2=50">BH-50</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Controle de férias</span>
                            </a>
                            <ul class="sub">
                                <li><a href="bh31_buscar_ferias.jsp">Buscar</a></li>
                                <li><a href="FeriasControlePessoal.jsp?type=2">Oficiais</a></li>
                                <li><a href="FeriasControlePessoal.jsp?type=1">Praças</a></li>
                                <li><a href="FeriasControlePessoal.jsp?type=3">TTC's</a></li>
                                <li><a href="FeriasControlePessoal.jsp?type=4">Cívis</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Indicadores</span>
                            </a>
                            <ul class="sub">
                                <li><a href="BH31.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">Pessoal</a></li>
                                <li><a href="Ferias.jsp?type=1">Férias</a></li>
                            </ul>
                        </li>
                    </ul>
                    <footer class="site-footer">
                        <div class="text-center">
                            <%out.print(year);%> - BHMN
                        </div>
                    </footer>
                </div>
            </aside>
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
            MAIN CONTENT
            *********************************************************************************************************************************************************** -->
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <%if (temp != null) {
                                    if (temp.equals("OK")) {%>
                            <div class="alert alert-success centered"><b>Concluido!</b> As Férias foram cadastradas com sucesso.</div>
                            <%} else if (temp.equals("NO2")) {%>
                            <div class="alert alert-danger"><b>Erro!</b> O somátorio das datas não coincidem com os dias informado.</div>      				
                            <%} else if (temp.equals("NO3")) {%>
                            <div class="alert alert-danger"><b>Erro!</b> O Militar/Servidor Não poosuí saldo de férias suficiente.</div>      				
                            <%} else if (temp.equals("NO4")) {%>
                            <div class="alert alert-danger"><b>Erro!</b> O Militar/Servidor já conclui as férias para o ano informado!</div>      				
                            <%} else {%>
                            <div class="alert alert-danger"><b>Erro!</b> A operação não pode ser concluida.</div>      				
                            <%}
                                }%>
                            <form class="form-horizontal style-form" action="ExibePessoal.jsp" method="post">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Nome Completo:</b></font></label>
                                    <div class="col-sm-3">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getNome());%></p>
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>NIP:</b></font></label>
                                    <div class="col-sm-3">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getNip());%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Posto:</b></font></label>
                                    <div class="col-sm-2">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getGrad());%></p>
                                    </div> 
                                    <label class="col-sm-2 col-sm-1 control-label" style="text-align: right;"><font color="black"><b>Quadro:</b></font></label>
                                    <div class="col-sm-1">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getQuadro());%></p>
                                    </div>   
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Especialidade:</b></font></label>
                                    <div class="col-sm-2">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getEsp());%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Data de Embarque:</b></font></label>
                                    <div class="col-sm-2"> 
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getEmb());%></p>
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Nome de Guerra:</b></font></label>
                                    <div class="col-sm-2"> 
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getGuerra());%></p>
                                    </div> 
                                </div> 
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Departamento:</b></font></label>
                                    <div class="col-sm-2">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getDep());%></p>
                                    </div>
                                    <label class="col-sm-2 col-sm-1 control-label" style="text-align: right;"><font color="black"><b>Divisão:</b></font></label>
                                    <div class="col-sm-1">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getDiv());%></p>
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Ramal:</b></font></label>
                                    <div class="col-sm-2">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getRamal());%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Data de Promoção:</b></font></label>
                                    <div class="col-sm-2"> 
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getPromo());%></p>
                                    </div> 
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Data de Aniversario:</b></font></label>
                                    <div class="col-sm-2"> 
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getNasc());%></p>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Função:</b></font></label>
                                    <div class="col-sm-8">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(servidor.getFuncao());%></p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <form class="form-horizontal style-form" action="ExibePessoal.jsp" method="post">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>CEP:</b></font></label>
                                    <div class="col-sm-1">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getCep());%></p>
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Numero:</b></font></label>
                                    <div class="col-sm-3">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getNumero());%></p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Logradouro:</b></font></label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getLogradouro());%></p>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Complemento:</b></font></label>
                                    <div class="col-sm-6">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getComplemento());%></p>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Bairro:</b></font></label>
                                    <div class="col-sm-2"> 
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getBairro());%></p>
                                    </div>
                                    <label class="col-sm-2 col-sm-1 control-label" style="text-align: right;"><font color="black"><b>Cidade:</b></font></label>
                                    <div class="col-sm-2"> 
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getCidade());%></p>
                                    </div>
                                    <label class="col-sm-2 col-sm-1 control-label" style="text-align: right;"><font color="black"><b>UF:</b></font></label>
                                    <div class="col-sm-1"> 
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getUf());%></p>
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Telefone:</b></font></label>
                                    <div class="col-sm-2">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getTelefone());%></p>
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;"><font color="black"><b>Celular:</b></font></label>
                                    <div class="col-sm-2">
                                        <p class="form-control-static" style="text-align: left;"><%out.print(busca.getCelular());%></p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>  
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <%if (servidor.getAfast() == 0) {%>
                            <form  class="col-sm-2 control-label" action="ExibePessoal.jsp" method="post">
                                <input type="hidden" class="form-control" id="nip" name="nip" value="<%out.print(servidor.getNip());%>">
                                <input type="hidden" class="form-control" id="type" name="type" value="12">
                                <button type="submit" class="btn btn-theme center-block">Editar Militar</button>
                            </form>
                            <form  class="col-sm-2 control-label" action="ExibePessoal.jsp" method="post">
                                <input type="hidden" class="form-control" id="nip" name="nip" value="<%out.print(servidor.getNip());%>">
                                <input type="hidden" class="form-control" id="type" name="type" value="22">
                                <button type="submit" class="btn btn-theme center-block">Editar Busca</button>
                            </form>
                            <form class="col-sm-2 control-label" action="ListarFerias.jsp" method="post">
                                <input type="hidden" class="form-control" name="serv" value="<%out.print(servidor.getNip());%>">
                                <input type="hidden" class="form-control" name="typeServ" value="2">
                                <button type="submit" class="btn btn-theme center-block">Cadastrar Ferias</button>
                            </form>
                            <form class="col-sm-2 control-label" action="bh31_dbq.jsp" method="post">
                                <input type="hidden" class="form-control" id="dbq" name="dbq" value="<%out.print(servidor.getNip());%>">
                                <button type="submit" class="btn btn-theme center-block">Desembarque</button>
                            </form>
                            <%} else {%>
                            <span class="label label-danger label-mini">DBQ em: <%out.print(new SimpleDateFormat("dd/MM/yyyy").format(servidor.getDbq()));%></span>
                            <%}%>
                            <br>
                            <br>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <table class="table table-hover">
                                <h4><i class="fa fa-angle-right centered"></i> HISTORICO</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-angle-double-right text-center"></i> DATA</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> MOVIMENTAÇÃO</th>
                                        <th><i class="fa fa-angle-double-right text-center"></i> IP</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (Pessoal_movi move : servidorarray) {%>
                                    <tr>
                                        <td><%out.print(move.getDatacadmov());%> às <%out.print(move.getHoracadmov());%></td>
                                        <td><%out.print(move.getUsercadmov());%> | <%out.print(move.getDesc_mov());%></td>
                                        <td><%out.print(move.getIpcadmov());%></td>
                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                        </div><!--/content-panel -->
                    </div><!-- /col-md-12 -->
                </section>
            </section>

            <!--main content end-->
        </section>

        <script src="../../assets3/js/jquery.js"></script>
        <script src="../../assets3/js/jquery-1.8.3.min.js"></script>
        <script src="../../assets3/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="../../assets3/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="../../assets3/js/jquery.scrollTo.min.js"></script>
        <script src="../../assets3/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="../../assets3/js/jquery.sparkline.js"></script>

        <!--common script for all pages-->
        <script src="../../assets3/js/common-scripts.js"></script>

        <script type="text/javascript" src="../../assets3/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="../../assets3/js/gritter-conf.js"></script>	


    </body>
</html>
