<%@page import="src.modelo.Chapa_Permissionario"%>
<%@page import="src.modelo.Chapa_model"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="src.modelo.Usuario"%>
<%@page import="src.modelo.Chapa_Apto_model"%>
<%@page import="src.modelo.Chapa_Apendice"%>
<%@page import="src.modelo.Chapa_Veiculo"%>
<%@page import="java.io.*" %>
<%@page import="src.modelo.Chapa_Dependente"%>
<%@page contentType="text/html; charset=UTF-8" %>
<%Usuario usuario = (Usuario) session.getAttribute("usuario");
    Chapa_Permissionario perm = (Chapa_Permissionario) request.getAttribute("perm");
    String temp = (String) request.getAttribute("mensagem");
    ArrayList<Chapa_Veiculo> veiculos = (ArrayList<Chapa_Veiculo>) request.getAttribute("veiculos");
    ArrayList<Chapa_Dependente> dependentes = (ArrayList<Chapa_Dependente>) request.getAttribute("dependentes");
    Chapa_Apendice apendice = (Chapa_Apendice) request.getAttribute("apendice");
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
    </head>

    <body onload="time()">
        <section id="container" >
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <a href="#" class="logo"><b>SIG-BASE || CHAPA</b></a>
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
            </header>
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
                        <%}
                            if (usuario.getPri().equals("BH30")) {%>
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
                </div>
            </aside>
            <section id="main-content">
                <section class="wrapper">
                    <div class="col-md-12 mt">
                        <form enctype="multipart/form-data" class="form-horizontal style-form" name="chapa_edit_permissionario" action="AtualizaPermissionario.jsp" method="post">
                            <div class="form-panel">
                                <%if (temp != null) {
                                    if (temp.equals("OK")) {%>
                                <div class="alert alert-success centered"><b>Concluido!</b> Permissionário Atualizado com sucesso.</div>
                                <%} else if (temp.equals("EXIST")) {%>
                                <div class="alert alert-warning centered"><b>Erro!</b> Permissionário já Atualizado.</div>
                                <%} else {%>
                                <div class="alert alert-danger centered"><b>Erro!</b> A operação não pode ser concluida.</div>      				
                                <%}
                                }%>

                                <input type="hidden" id="qtdC" name="qtdC" value="<%out.print(veiculos.size());%>" > 
                                <input type="hidden" id="qtdD" name="qtdD" value="<%out.print(dependentes.size());%>"> 
                                <input type="hidden" id="idHidden" name="idHidden" value="<%out.print(perm.getId());%>" >
                                <input type="hidden" id="apto" name="apto" value="<%out.print(perm.getApto());%>" >
                                <input type="hidden" id="bloco" name="bloco" value="<%out.print(perm.getBloco());%>" >
                                <input type="hidden" id="nomeHidden" name="nomeHidden" value="<%out.print(perm.getNome());%>"><!--Existe -->
                                <input type="hidden" id="nipHidden" name="nipHidden" value="<%out.print(perm.getNip());%>"><!--Existe -->
                                <input type="hidden" id="msgHidden" name="msgHidden" value="<%out.print(perm.getMsg());%>"><!--Existe -->
                                <input type="hidden" id="ramalHidden" name="ramalHidden" value="<%out.print(perm.getRamal());%>"><!--Existe -->
                                <h3 class="centered"><i class="fa fa-angle-double-right"></i><b> Dados do Permissionário</b></h3><br><br>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Apartamento</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control" id="aptoText" name="aptoText" required value="<%out.print(perm.getApto());%>" disabled>
                                    </div>
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Bloco</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control" id="blocoText" name="blocoText" required value="<%out.print(perm.getBloco());%>" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Nome</label>
                                    <div class="col-sm-4">
                                        <input type="text" class="form-control" id="nome" name="nome" required value="<%out.print(perm.getNome());%>" disabled>

                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">NIP</label>
                                    <div class="col-sm-2">
                                        <input type="text" class="form-control" id="nip" name="nip" value="<%out.print(perm.getNip());%>" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Graduação</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="grad" required>
                                            <option value="<%out.print(perm.getGrad());%>"><%out.print(Util.Util.graduacao(perm.getGrad()));%></option>
                                            <option value="2" >MN</option>
                                            <option value="4">CB</option>
                                            <option value="5">3ºSG</option>
                                            <option value="6">2ºSG</option>
                                            <option value="7">1ºSG</option>
                                            <option value="8">SO</option>
                                            <option value="9">GM</option>
                                            <option value="10">1ºT</option>
                                            <option value="11">2ºT</option>
                                            <option value="12">CT</option>
                                            <option value="13">CC</option>
                                            <option value="14">CF</option>
                                            <option value="15">CMG</option>
                                            <option value="16">CA</option>
                                            <option value="17">VA</option>
                                            <option value="18">AE</option>
                                        </select>
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">OM</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="om" required>
                                            <option value="<%out.print(perm.getOm());%>"><%out.print(Util.Util.om(perm.getOm()));%></option>
                                            <option value="1">BHMN</option>
                                            <option value="2">DHN</option>
                                            <option value="3">GNHO</option>
                                            <option value="4">CAMR</option>
                                            <option value="5">CHM</option>
                                            <option value="6">NApOc Ary Rongel</option>
                                            <option value="7">NHi Sirius</option>
                                            <option value="8">NHo amorim do Vale</option>
                                            <option value="9">NHo Cruzeiro do Sul</option>
                                            <option value="10">NHo Taurus</option>
                                            <option value="11">NHoF Graça Aranha</option>
                                            <option value="12">NOc Antares</option>
                                            <option value="13">NPo Maximiano</option>
                                            <option value="14">NPqHo Vital de Oliveira</option>
                                        </select>
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">MSG</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="msg" name="msg" value="<%out.print(perm.getMsg());%>" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">RG</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="rg" name="rg" required value="<%out.print(perm.getIdentidade());%>">
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;" >CPF</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="cpf" name="cpf" required value="<%out.print(perm.getCpf());%>">
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;" >Estado Civil</label>
                                    <div class="col-sm-2">
                                        <select class="form-control" size="1" name="estadoCivil" required>
                                            <option value="<%out.print(perm.getEstadoCivil());%>" ><%out.print(Util.Util.estadoCivil(perm.getEstadoCivil()));%></option>
                                            <option value="1" >Solteiro(a)</option>
                                            <option value="2" >Casado(a)</option>
                                            <option value="3" >Divorciado(a)</option>
                                            <option value="4" >Viúvo(a)</option>
                                            <option value="5" >Separado(a)</option>
                                            <option value="6">Companheiro(a)</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Endereço</label>
                                    <div class="col-sm-7">
                                        <input type="text"  class="form-control" id="endereco" name="endereco" value="<%out.print(perm.getEndereco());%>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Ramal</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="ramal" name="ramal" value="<%out.print(perm.getRamal());%>" disabled>
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">Telefone</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="telefone" name="telefone" value="<%out.print(perm.getTelefone());%>" >
                                    </div>
                                    <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">Celular</label>
                                    <div class="col-sm-2">
                                        <input type="text"  class="form-control" id="celular" name="celular" value="<%out.print(perm.getCelular());%>" >
                                    </div>
                                </div>
                            </div>
                            <div class="form-panel">
                                <h3 class="centered"><i class="fa fa-angle-double-right"></i><b> Veículos</b></h3><br><br>
                                <div class="form-group" id="divVei">
                                    <% if (veiculos.size() > 0) {
                                            for (int i = 0; i < veiculos.size(); i++) {%>
                                    <div class="row" id="divVei<%out.print(i);%>">
                                        <input type="hidden" id="id_vei<%out.print(i);%>" name="id_vei<%out.print(i);%>" value="<%out.print(veiculos.get(i).getId_Veiculo());%>" >
                                        <label class="col-sm-2 col-sm-2 control-label" style="text-align: right;">Veículo <%out.print(i);%>/Modelo</label>
                                        <div class="col-sm-3">
                                            <input type="text"  class="form-control" id="veiculo<%out.print(i);%>" name="veiculo<%out.print(i);%>" value="<%out.print(veiculos.get(i).getModelo());%>" >
                                        </div>
                                        <label class="col-sm-1 col-sm-2 control-label" style="text-align: right;">Placa <%out.print(i);%></label>
                                        <div class="col-sm-3">
                                            <input type="text"  class="form-control" id="placa<%out.print(i);%>" name="placa<%out.print(i);%>" value="<%out.print(veiculos.get(i).getPlaca());%>" >
                                        </div>
                                        <div class="col-sm-1"><button type="button" title="Excluir Veículos" class="btn btn-danger btn-xs" onclick="excluiVeis('#divVei<%out.print(i);%>', '<%out.print(veiculos.get(i).getId_Veiculo());%>', '<%out.print(veiculos.get(i).getModelo());%>', '<%out.print(veiculos.get(i).getPlaca());%>');"><i class="fa fa-trash-o"></i></button>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <%}
                                        }%>
                                </div>
                                <button type="button" title="Adicionar Veículo" class="btn btn-primary btn-xs center-block" onclick="addVeiculo();"><i class="glyphicon glyphicon-plus"></i> Veículo</button><br><br>
                            </div>
                            <!--button type="button" title="Adicionar Veículo" class="btn btn-primary btn-xs center-block" onclick="addVeiculos();"><i class="glyphicon glyphicon-plus"></i> Veículo</button><br><br-->
                            <div class="form-panel">
                                <h3 class="centered"><i class="fa fa-angle-double-right"></i><b> Dependentes</b></h3><br><br>
                                <div class="form-group" id="divDep">
                                    <%for (int i = 0; i < dependentes.size(); i++) {%>
                                    <div id="divDep<%out.print(i);%>">
                                        <div class="row">
                                            <input type="hidden" id="id_dep<%out.print(i);%>" name="id_dep<%out.print(i);%>" value="<%out.print(dependentes.get(i).getId_chapa_dependentes());%>" >
                                            <label class="col-sm-2  control-label" style="text-align:right;">Nome</label>
                                            <div class="col-sm-3"><input type="text"  class="form-control" id="nomeDep<%out.print(i);%>" name="nomeDep<%out.print(i);%>" value="<%out.print(dependentes.get(i).getNome());%>" required></div>
                                            <label class="col-sm-1 control-label" style="text-align:right;">Parentesco</label>
                                            <div class="col-sm-2"><input type="text"  class="form-control" id="parentescoDep<%out.print(i);%>" name="parentescoDep<%out.print(i);%>" value="<%out.print(dependentes.get(i).getParentesco());%>" required></div>   
                                            <label class="col-sm-1 control-label" style="text-align:right;">Idade</label>
                                            <div class="col-sm-1"><input type="text"  class="form-control" id="idadeDep<%out.print(i);%>" name="idadeDep<%out.print(i);%>" value="<%out.print(dependentes.get(i).getIdade());%>" required></div>
                                        </div>
                                        <br>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" style="text-align:right;">Identidade</label>
                                            <div class="col-sm-3"><input type="text"  class="form-control" id="ident<%out.print(i);%>" name="ident<%out.print(i);%>" value="<%out.print(dependentes.get(i).getIdent());%>" required></div>
                                            <label class="col-sm-1 control-label" style="text-align:right;">NIP</label>
                                            <div class="col-sm-3"><input type="text"  class="form-control" id="nip<%out.print(i);%>" name="nip<%out.print(i);%>" value="<%out.print(dependentes.get(i).getNip());%>" required></div>
                                                <%if (i > 0) {%>
                                            <div class="col-sm-1">
                                                <button type="button" title="Excluir Dependente" class="btn btn-danger btn-xs" onclick="excluiDeps('#divDep<%out.print(i);%>', <%out.print(dependentes.get(i).getId_chapa_dependentes());%>);"><i class="fa fa-trash-o"></i></button>
                                            </div>
                                            <%}%>
                                        </div>
                                        <br>
                                        <br>
                                        <br>
                                    </div>
                                    <%}%>
                                </div>
                                <button type="button" title="Adicionar Dependentes" class="btn btn-primary btn-xs center-block" onclick="addDependente();"><i class="glyphicon glyphicon-plus"></i> Dependente</button><br><br>
                            </div>
                            <input type="hidden" class="form-control" id="user" name="user" value="<%out.print(usuario.getNip());%>">
                            <div class="form-panel">
                                <div class="row">
                                    <div class="col-sm-12" style="color: red;"> 
                                        <h4>Apêndice de Arquivos</h4>
                                        Anexe aqui os seguintes arquivos:
                                        <div class="row"></div>
                                        <div class="col-sm-12" id="declaracaoIRDiv">
                                            1º Declaração de IR do corrente ano do pretendente a permissionário e de seu conjugê;
                                            <input type="file" name="declaracaoIR">
                                            <%
                                                if (apendice != null && !apendice.getArq1().equals("")) {
                                            %><a href="<%out.print(apendice.getArq1());%>"><%out.print(apendice.getArq1().substring(apendice.getArq1().lastIndexOf("/"), apendice.getArq1().length()));%></a><%
                                            } else {
                                            %>   Não Existe Arquivo adicionado!   <%
                                                }
                                            %>
                                        </div>
                                        <br><br><br>
                                        <div class="col-sm-12" id="recDeNaoImovelDiv">
                                            2º Declaração do pretendente a perm. e do conjugê, com firmas reconhecidas, afirmando não serem proprietários de nenhum imóvel residencial localizado no RJ;
                                            <input type="file" name="recDeNaoImovel"> 
                                            <%
                                                if (apendice != null && !apendice.getArq2().equals("")) {
                                            %><a href="<%out.print(apendice.getArq2());%>"><%out.print(apendice.getArq2().substring(apendice.getArq2().lastIndexOf("/"), apendice.getArq2().length()));%></a><%
                                            } else {
                                            %>   Não Existe Arquivo adicionado!   <%
                                                }
                                            %>
                                        </div>
                                        <br><br><br>
                                        <div class="col-sm-12" id="identAnexoDiv">
                                            3º Cópia da identidade e                                           
                                            <input type="file" name="identAnexo">
                                            <%
                                                if (apendice != null && !apendice.getArq3().equals("")) {
                                            %><a href="<%out.print(apendice.getArq3());%>"><%out.print(apendice.getArq3().substring(apendice.getArq3().lastIndexOf("/"), apendice.getArq3().length()));%></a><%
                                            } else {
                                            %>   Não Existe Arquivo adicionado!   <%
                                                }
                                            %>
                                        </div>
                                        <br><br>
                                        <div class="col-sm-12" id="cpfAnexoDiv">
                                            CPF;
                                            <input type="file" name="cpfAnexo">
                                            <%
                                                if (apendice != null && !apendice.getArq4().equals("")) {
                                            %><a href="<%out.print(apendice.getArq4());%>"><%out.print(apendice.getArq4().substring(apendice.getArq4().lastIndexOf("/"), apendice.getArq4().length()));%></a><%
                                            } else {
                                            %>   Não Existe Arquivo adicionado!   <%
                                                }
                                            %>
                                        </div>
                                        <br><br><br>
                                        <div class="col-sm-12" id="declaracaoAtestDiv">
                                            4º Declaração de atestando conhecimento da OI 30-28B;
                                            <input type="file" name="declaracaoAtest"> 
                                            <%
                                                if (apendice != null && !apendice.getArq5().equals("")) {
                                            %><a href="<%out.print(apendice.getArq5());%>"><%out.print(apendice.getArq5().substring(apendice.getArq5().lastIndexOf("/"), apendice.getArq5().length()));%></a><%
                                            } else {
                                            %>   Não Existe Arquivo adicionado!   <%
                                                }
                                            %>
                                        </div>
                                        <br><br><br>
                                        <div class="col-sm-12" id="folhaBDPESDiv">
                                            5º Folha do BDPES onde constam os seus dependentes.
                                            <input type="file" name="folhaBDPES">
                                            <%
                                                if (apendice != null && !apendice.getArq6().equals("")) {
                                            %><a href="<%out.print(apendice.getArq6());%>"><%out.print(apendice.getArq6().substring(apendice.getArq6().lastIndexOf("/"), apendice.getArq6().length()));%></a><%
                                            } else {
                                            %>   Não Existe Arquivo adicionado!   <%
                                                }
                                            %>
                                        </div>
                                        <br><br><br>
                                        Obs.: Caso não possua, ainda, os arquivos a serem anexados cadastre o permissionário e atualize o seu cadastro para inserir os arquivos.
                                        <br>                                        
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-theme center-block">Atualizar Cadastro</button>
                        </form>
                    </div>
                </section>
            </section>
        </section>

        <script src="assets2/js/jquery.js"></script>
        <script src="assets2/js/jquery-1.8.3.min.js"></script>
        <script src="assets2/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets2/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets2/js/jquery.scrollTo.min.js"></script>
        <script src="assets2/js/jquery.nicescroll.js" type="text/javascript"></script>
        <script src="assets2/js/jquery.sparkline.js"></script>
        <script src="assets2/js/common-scripts.js"></script>
        <script type="text/javascript" src="assets2/js/gritter/js/jquery.gritter.js"></script>
        <script type="text/javascript" src="assets2/js/gritter-conf.js"></script>
        <script src="assets2/js/sparkline-chart.js"></script>    
        <script src="assets2/js/zabuto_calendar.js"></script>	
        <script type="text/javascript">
                                    var cDep = $('#qtdD').val();
                                    var cVei = $('#qtdC').val();
                                    $(document).ready(function () {
                                        var unique_id = $.gritter.add({
                                            // (string | mandatory) the heading of the notification
                                            title: 'Bem-vindo ao SIG-BASE!',
                                            // (string | mandatory) the text inside the notification
                                            //text: 'Hover me to enable the Close Button. You can hide the left sidebar clicking on the button next to the logo. Free version for <a href="http://blacktie.co" target="_blank" style="color:#ffd777">BlackTie.co</a>.',
                                            // (string | optional) the image to display on the left
                                            image: 'assets2/img/CBV.png',
                                            // (bool | optional) if you want it to fade out on its own or just sit there
                                            sticky: true,
                                            // (int | optional) the time you want it to be alive for before fading out
                                            time: '',
                                            // (string | optional) the class name you want to apply to that specific message
                                            class_name: 'my-sticky-class'
                                        });
                                        return false;
                                    });

                                    function addVeiculo() {
                                        $('#divVei').append("<div id=\"divVei" + cVei + "\"><label class=\"col-sm-2  control-label\" style=\"text-align: right;\">Veículo/Modelo</label>"
                                                + "<input type=\"hidden\" id=\"id_vei" + cVei + "\" name=\"id_vei" + cVei + "\" value=\"-1\" required>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\"  class=\"form-control\" id=\"veiculo" + cVei + "\" name=\"veiculo" + cVei + "\" value=\"\" required></div>"
                                                + "<label class=\"col-sm-1 control-label\" style=\"text-align: right;\">Placa </label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\"  class=\"form-control\" id=\"placa" + cVei + "\" name=\"placa" + cVei + "\" value=\"\" required></div>"
                                                + "<div class=\"col-sm-1\"><button type=\"button\" title=\"Excluir Veiculo\" class=\"btn btn-danger btn-xs\" onclick=\"excluiVeis('#divVei" + cVei + "');\"><i class=\"fa fa-trash-o\"></i></button></div><br><br><br></div>");
                                        cVei++;
                                        $('#qtdC').val(cVei);
                                    }
                                    ;

                                    function addDependente() {
                                        console.log(cDep);
                                        $('#divDep').append("<div id=\"divDep" + cDep + "\"><div class=\"row\">"
                                                + "<input type=\"hidden\" id=\"id_dep" + cDep + "\" name=\"id_dep" + cDep + "\" value=\"-1\" required>"
                                                + "<label class=\"col-sm-2  control-label\" style=\"text-align: right;\">Nome</label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\" class=\"form-control\" id=\"nomeDep"
                                                + cDep + "\" name=\"nomeDep" + cDep + "\" value=\"\" required></div>"
                                                + "<label class=\"col-sm-1  control-label\" style=\"text-align: right;\">Parentesco</label>"
                                                + "<div class=\"col-sm-2\"><input type=\"text\"  class=\"form-control\" id=\"parentescoDep"
                                                + cDep + "\" name=\"parentescoDep" + cDep + "\" value=\"\" required></div>"
                                                + "<label class=\"col-sm-1  control-label\" style=\"text-align: right;\">Idade</label>"
                                                + "<div class=\"col-sm-1\"><input type=\"text\"  class=\"form-control\" id=\"idadeDep"
                                                + cDep + "\" name=\"idadeDep" + cDep + "\" value=\"\" required></div>"
                                                + "</div><br>");
                                        var div = '#divDep'.concat(cDep);
                                        $(div).append("<div class=\"row\">"
                                                + "<label class=\"col-sm-2 control-label\" style=\"text-align: right;\">Identidade</label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\"  class=\"form-control\" id=\"ident"
                                                + cDep + "\" name=\"ident" + cDep + "\" value=\"\" required></div>"
                                                + "<label class=\"col-sm-1 control-label\" style=\"text-align:right;\">NIP</label>"
                                                + "<div class=\"col-sm-3\"><input type=\"text\"  class=\"form-control\" id=\"nip" + cDep + "\" name=\"nip" + cDep + "\" value=\"\" required></div>"
                                                + "<div class=\"col-sm-1\"><button type=\"button\" title=\"Excluir Dependente\" class=\"btn btn-danger btn-xs\" onclick=\"excluiDeps('#divDep" + cDep + "');\"><i class=\"fa fa-trash-o\"></i></button>"
                                                + "</div><br><br><br>");
                                        cDep++;
                                        $('#qtdD').val(cDep);
                                    }
                                    ;

                                    function excluiDeps(divName, id_dep) {
                                        $(divName).remove();
                                        cDep--;
                                        $('#qtdD').val(cDep);
                                        $.ajax({
                                            url: "AtualizaPermissionario.jsp",
                                            type: "GET",
                                            data: {action: 'deleteDep',
                                                id_dep: id_dep},
                                            success: function (data) {

                                            },
                                            error: function (data) {
                                                alert("error");
                                            },
                                            complete: function () {
                                                //alert("Fechou Ajax!");
                                            }
                                        });
                                    }
                                    ;

                                    function excluiVeis(divName, id_Veiculo, modelo, placa) {
                                        $(divName).remove();
                                        cVei--;
                                        $('#qtdC').val(cVei);
                                        $.ajax({
                                            url: "AtualizaPermissionario.jsp",
                                            type: "GET",
                                            data: {action: 'deleteVeiculo',
                                                id_Veiculo: id_Veiculo,
                                                modelo: modelo,
                                                placa: placa},
                                            success: function (data) {

                                            },
                                            error: function (data) {
                                                alert("error");
                                            },
                                            complete: function () {
                                                //alert("Fechou Ajax!");
                                            }
                                        });

                                    }
                                    ;
        </script>
    </body>
</html>