<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Cadastro de Cartórios</title>
    
  <style type="text/css">
	    .titulo{text-align: center;font-size: 30px;}
	 	#conteudo{text-align:center;}
	 	#titulo-lista{margin-top: 50px; font-family: sans-serif}
	 	#btn-novo{background-color: #e8921d;padding: 25px;border-radius: 25px;font-family: sans-serif;font-size: 20px;margin-top: 50px;}
	 	table{margin-top: 2%;border-collapse: collapse;width: 100%;}
	 	th,td{padding: 10px; text-align: left; border-bottom: 1px solid #ddd; font-family: sans-serif} 	
	 	.btn-acoes{padding: 7px;border-radius: 10px;font-size: 18px;background-color: #e8921d;margin: 10px;}
   </style>

</head>

<body>
    <div>
        <div>
        <div id="topo">
        <p class="titulo">Bem vindo ao sitema de Cartórios</p>
            <hr/>
        </div>
            <div id="conteudo">
            <a href="/novo-cartorio">
                <button type="submit" id="btn-novo">Novo Cartório</button>
            </a>
            <br/><br/>
            <div>
                <div id="titulo-lista">
                    <h2>Lista de Cartórios</h2>
                </div>
                <div id="tabela">
                    <table>
                        <tr>
                     		<th>Id</th>
                            <th>Cartório</th>
                        </tr>
                        <c:forEach var="cartorio" items="${cartorios}">
                            <tr>
                               <td>${cartorio.id}</td>
                                <td>${cartorio.nomeCartorio}</td>
                                <td>
                                <a href="/edit/${cartorio.id}">
                                	<button type="submit" class="btn-acoes">Atualizar Cartório</button>
                                 </a>
                                    <form action="/${cartorio.id}/delete" method="post">
                                        <button type="submit" class="btn-acoes"> Excluir Cartório</button>
                                    </form>
                                    
                                    <a href="/${cartorio.id}">
                                	<button type="submit" class="btn-acoes">Visualizar Cartório</button>
                                 </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        </div>
    </div>
</body>
</html>