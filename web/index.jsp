<%@ page import="org.diorite.web.client.Index" %>
<%!
    public static final int GAME_SIZE_X = Index.GAME_SIZE_X;
    public static final int GAME_SIZE_Z = Index.GAME_SIZE_Z;
%>
<html>
<head>
    <title>#OnlyDiorite</title>
    <link rel="stylesheet" href="Index.css">
    <script type="text/javascript" language="javascript"
            src="org.diorite.web.Index/org.diorite.web.Index.nocache.js"></script>
    <link rel="stylesheet" href="./mdl/material.min.css">
    <script src="./mdl/material.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>

<div>
    <div id="topBar" class="wide mdl-color--light-blue-400">
        <img src="Diorite.png" id="logo">

        <p>#OnlyDiorite</p>
    </div>
    <div id="pageContent">
            <%
                for (int x = 0; x < GAME_SIZE_X; x++)
                {
                    for (int z = 0; z < GAME_SIZE_Z; z++)
                    {
            %>
            <div class="square">
                <div class="content">
                    <div class="table">
                        <div class="table-cell" id="<%out.print(x+":"+z);%>">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </div>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>
    </div>
</div>
</body>
</html>
