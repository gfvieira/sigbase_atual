<%@page import="src.modelo.Pessoal_model"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="java.io.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%Pessoal_model servidor = (Pessoal_model) request.getAttribute("ttc");
    Usuario usuario = (Usuario) session.getAttribute("usuario");%>
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

        <title>SIG-BASE</title>

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
                <a href="#" class="logo"><b>SIG-BASE || Sargenteante BH-<%out.print(usuario.getTypeAccess());%></b></a>
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
                            <a class="active" href="Sargenteante.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-desktop"></i>
                                <span>Principal Sargenteante</span>
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
                            <a class="active" href="Sargenteante.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-desktop"></i>
                                <span>Principal Sargenteante</span>
                            </a>
                        </li>
                        <%} else {%>
                        <li class="mt">
                            <a class="active" href="Sargenteante.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">
                                <i class="fa fa-dashboard"></i>
                                <span>Principal</span>
                            </a>
                        </li>
                        <%}%>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-desktop"></i>
                                <span>Tripulação</span>
                            </a>
                            <ul class="sub">
                                <li><a href="SargenteanteListaPessoal.jsp?type=0&access=<%out.print(usuario.getTypeAccess());%>">Tripulação</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=2&access=<%out.print(usuario.getTypeAccess());%>">Oficiais</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=1&access=<%out.print(usuario.getTypeAccess());%>">Praças</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=15&access=<%out.print(usuario.getTypeAccess());%>">SubOficiais</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=14&access=<%out.print(usuario.getTypeAccess());%>">Sargentos</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=13&access=<%out.print(usuario.getTypeAccess());%>">Cabos</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=12&access=<%out.print(usuario.getTypeAccess());%>">Marinheiros</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=3&access=<%out.print(usuario.getTypeAccess());%>">TTC's</a></li>
                                <li><a href="SargenteanteListaPessoal.jsp?type=4&access=<%out.print(usuario.getTypeAccess());%>">Civis</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Controle de férias</span>
                            </a>
                            <ul class="sub">
                                <li><a href="SargenteanteFeriasControle.jsp?type=2&access=<%out.print(usuario.getTypeAccess());%>">Oficiais</a></li>
                                <li><a href="SargenteanteFeriasControle.jsp?type=1&access=<%out.print(usuario.getTypeAccess());%>">Praças</a></li>
                                <li><a href="SargenteanteFeriasControle.jsp?type=3&access=<%out.print(usuario.getTypeAccess());%>">TTC's</a></li>
                                <li><a href="SargenteanteFeriasControle.jsp?type=4&access=<%out.print(usuario.getTypeAccess());%>">Cívis</a></li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;" >
                                <i class="fa fa-cogs"></i>
                                <span>Indicadores</span>
                            </a>
                            <ul class="sub">
                                <li><a href="Sargenteante.jsp?ind=HOME&access=<%out.print(usuario.getTypeAccess());%>">Pessoal</a></li>
                                <li><a href="SargenteanteFerias.jsp?access=<%out.print(usuario.getTypeAccess());%>">Férias</a></li>
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
                            <form class="form-horizontal style-form" action="SargenteanteAttPessoal.jsp" method="post">
                                <h3 class="centered"><i class="fa fa-angle-double-right"></i><b> Atualização de TTC</b></h3><br><br>
                                <i class="center-block"><font color="red">${mensagem}</font></i>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Nome:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="nome" name="nome" value="<%out.print(servidor.getNome());%>" required>
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label">NIP:</label>
                                    <div class="col-sm-3">
                                        <input type="text" class="form-control" id="nip" name="nip" value="<%out.print(servidor.getNip());%>" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Posto/Graduação:</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="grad" required>
                                            <option value="<%out.print(servidor.getGradInt());%>"><%out.print(servidor.getGrad());%></option>
                                            <option value="2">MN</option>
                                            <option value="4">CB</option>
                                            <option value="5">3ºSG</option>
                                            <option value="6">2ºSG</option>
                                            <option value="7">1ºSG</option>
                                            <option value="8">SO</option>
                                            <option value="9">GM</option>
                                            <option value="10">2ºT</option>
                                            <option value="11">1ºT</option>
                                            <option value="12">CT</option>
                                            <option value="13">CC</option>
                                            <option value="14">CF</option>
                                            <option value="15">CMG</option>
                                            <option value="16">CA</option>
                                            <option value="17">VA</option>
                                            <option value="18">AE</option>
                                        </select>
                                    </div> 
                                    <label class="col-sm-1 col-sm-2 control-label">Quadro:</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="quadro" required>
                                            <option value="<%out.print(servidor.getQuadro());%>"><%out.print(servidor.getQuadro());%></option>
                                            <option value="CPA">CPA</option>
                                            <option value="CAP">CAP</option>
                                            <option value="QEPA">QEPA</option>
                                            <option value="CPRM">CPRM</option>
                                            <option value="CA">CA</option>
                                            <option value="T">T</option>
                                            <option value="MD">MD</option>
                                            <option value="QC">QC-IM</option>
                                            <option value="AA">AA</option>
                                            <option value="CD">CD</option>
                                            <option value="EN">EN</option>
                                        </select>
                                    </div>                                            
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Data de embarque:</label>
                                    <div class="col-sm-3"> 
                                        <%String data = String.valueOf(servidor.getEmb());%>
                                        <input name="emb" id="emb" type="date" class="form-control" required="" min="1910-01-01" max="2016-01-01" value="<% out.print(data); %>">
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label">Nome de guerra:</label>
                                    <div class="col-sm-2"> 
                                        <input type="text"  class="form-control" id="guerra" name="guerra" value="<%out.print(servidor.getGuerra());%>">
                                    </div> 

                                </div> 
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Especialidade:</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control" id="esp" name="esp" value="<%out.print(servidor.getEsp());%>">
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label">Ramal:</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="ramal" name="ramal" value="<%out.print(servidor.getRamal());%>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Departamento:</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control" value="<%out.print(servidor.getDep());%>" disabled>
                                        <input type="hidden" class="form-control" name="dep" value="<%out.print(servidor.getDep());%>">
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label">Divisão:</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="div" required>
                                            <option value="<%out.print(servidor.getDiv());%>"><%out.print(servidor.getDiv());%></option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="20">20</option>
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="24">24</option>
                                            <option value="25">25</option>
                                            <option value="30">30</option>
                                            <option value="31">31</option>
                                            <option value="32">32</option>
                                            <option value="33">33</option>
                                            <option value="34">34</option>
                                            <option value="41">41</option>
                                            <option value="42">42</option>
                                            <option value="43">43</option>
                                            <option value="44">44</option>
                                            <option value="50">50</option>
                                            <option value="51">51</option>
                                            <option value="52">52</option>
                                            <option value="53">53</option>
                                            <option value="54">54</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Data de Aniversario:</label>
                                    <div class="col-sm-3"> 
                                        <%String data3 = String.valueOf(servidor.getNasc());%>
                                        <input name="nasc" id="nasc" type="date" class="form-control" required="" min="1910-01-01" max="2016-01-01" value="<%out.print(data3);%>">
                                    </div> 
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">Função:</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="funcao" name="funcao" value="<%out.print(servidor.getFuncao());%>" required>
                                    </div>
                                </div>
                                <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>">
                                <input type="hidden" class="form-control" id="type" name="type" value="3">
                                <input type="hidden" class="form-control" id="id" name="id" value="<%out.print(servidor.getId());%>">
                                <button type="submit" class="btn btn-theme center-block">Cadastrar</button>
                            </form>
                        </div>
                    </div>    
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
