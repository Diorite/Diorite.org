<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <title>#OnlyDiorite</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.min.css" type="text/css" rel="stylesheet" media="screen,projection"/>
    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
<nav class="white" role="navigation">
    <div class="nav-wrapper container">
        <a id="logo-container" href="http://diorite.org/" class="brand-logo">#OnlyDiorite</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="http://diorite.org/SorryWeDoNotHaveFormYet/">Forum</a></li>
            <li><a href="http://ci.diorite.org/job/Diorite/">Jenkins</a></li>
            <li><a href="https://github.com/Diorite/Diorite/">GitHub</a></li>
            <li><a href="http://diorite.org/nexus/">Nexus</a></li>
            <li><a href="http://diorite.org/snake/">Snake</a></li>
        </ul>

        <ul id="nav-mobile" class="side-nav">
            <li><a href="http://diorite.org/SorryWeDoNotHaveFormYet/">Forum</a></li>
            <li><a href="http://ci.diorite.org/job/Diorite/">Jenkins</a></li>
            <li><a href="https://github.com/Diorite/Diorite/">GitHub</a></li>
            <li><a href="http://diorite.org/nexus/">Nexus</a></li>
            <li><a href="http://diorite.org/snake/">Snake</a></li>
        </ul>
        <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
</nav>

<div id="index-banner" class="parallax-container">
    <div class="section no-pad-bot">
        <div class="container">
            <br><br>

            <h1 class="header center blue-text">Diorite project</h1>

            <div class="row center">
                <h4 class="header col s12 light-blue-text lighten-5 imgtext-h">New Minecraft server software!</h4>
            </div>
            <div class="row center">
                <a href="https://github.com/Diorite/Diorite" class="btn-large waves-effect waves-light teal lighten-1">GitHub</a>
                <a href="http://dl.diorite.org" class="btn-large waves-effect waves-light teal lighten-1">Download
                    Diorite</a>
            </div>
            <br><br>

        </div>
    </div>
    <div class="parallax"><img src="mc1.jpg" alt="Unsplashed background img 1"></div>
</div>


<div class="container">
    <div class="section">

        <div class="wrapper">
            <div class="h_iframe">
                <!-- a transparent image is preferable -->
                <img class="ratio" src="ilovehtml.png"/>
                <iframe src="https://www.youtube.com/embed/sQb_vy0SLZY?autoplay=1&vq=hd720" frameborder="0"
                        allowfullscreen></iframe>
            </div>
        </div>
        <!--   Icon Section   -->
        <div class="row">
            <div class="col s12">
                <div class="icon-block">
                    <h2 class="center brown-text"><i class="material-icons">settings</i></h2>
                    <h5 class="center">About Diorite:</h5>

                    <p class="light">Diorite is a new minecaft server software, it isn't ready yet but our main goals
                        are:</p>
                    <ul>
                        <li>
                            Be scalable: <br>

                            <p class="tabulator">Diorite use tick-regions, where all entities can be handled by separate
                                thread. One region can hold multiple maps, or single 32x32 chunk section. If your map is
                                small and empty, only one thread will be used, but if this thread starts having
                                troubles handling all actions, Diorite will detect that and add split the current region
                                into 2 new regions. It will also connect them again if they are using less than 50% of
                                tick time. <br>
                                With Diorite you can even control TPS, you may set that zombies are updated 5 times per
                                second, without slowing them down!</p>
                        </li>
                        <li>
                            Be plugin friendly: <br>

                            <p class="tabulator">All types of plugin should be easy to make. Like instead of listening
                                to drop events, you can just change drops for given block or mob.</p>
                        </li>
                        <li>
                            Be open: <br>

                            <p class="tabulator">We don't use any part of Mojang code. So even if something isn't
                                in our API, it is easy to find the needed features in core code, or add it to API.</p>
                        </li>
                        <li>
                            Be extensible: <br>

                            <p class="tabulator">In Diorite you can use special core-mods that are loaded even before
                                Diorite, allowing you to change much more stuff.
                                Most of Diorite code is based on pipelines (pipelines work like a queue of named runnable
                                elements), so you can add/replace/remove elements that are used on Diorite start,
                                like replace an element that init the worlds with your own one.</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>


<div class="parallax-container valign-wrapper">
    <div class="section no-pad-bot">
        <div class="container">
            <div class="row center">
                <h4 class="header col s12 light-blue-text lighten-5 imgtext">Diorite Minecraft test server:
                    diorite.org</h4>
            </div>
        </div>
    </div>
    <div class="parallax"><img src="mc2.jpg" alt="Unsplashed background img 2"></div>
</div>

<div class="container">
    <div class="section">

        <!--   Icon Section   -->
        <div class="row">
            <div class="col s12">
                <div class="icon-block">
                    <h2 class="center brown-text"><i class="material-icons">settings</i></h2>
                    <h5 class="center">Other Goals:</h5>

                    <p class="light">Other goals that we want to achieve: </p>
                    <ul>
                        <li>
                            Be independent but compatible: <br>

                            <p class="tabulator">We want to always be able to support vanilla Minecraft, but we also want
                                to create own client. <br>
                                Server admins will be able to choose: support both players, where players using Diorite
                                client may be able to see/use additional stuff, or allow only Diorite clients to create
                                a much more advanced server, and better gameplay</p>
                        </li>
                        <li>
                            Support existing platforms: <br>

                            <p class="tabulator">We want support Forge mods (on both client and server side), and Spigot
                                plugins, that may not be a built-in feature, but an additional module of Diorite, installed
                                as a
                                plugin/core-mod.</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="parallax-container valign-wrapper">
    <div class="section no-pad-bot">
        <div class="container">
            <div class="row center">
                <h4 class="header col s12 light-blue-text lighten-5 imgtext">Diorite Minecraft test server:
                    diorite.org</h4>
            </div>
        </div>
    </div>
    <div class="parallax"><img src="mc3.jpg" alt="Unsplashed background img 3"></div>
</div>

<div class="container">
    <div class="section">

        <div class="row">
            <div class="col s12 center">
                <h3><i class="mdi-content-send brown-text"></i></h3>
                <h4>Help Us:</h4>

                <p class="left-align light">We are looking for people that will help us with project, we need people
                    for graphics, code, webpage, everything.<br>
                    You can contact the author of this project by e-mail: gotofinaldev@gmail.com</p>
                <h4>Donate To Us</h4>

                <p class="left-align light">Hosting all this stuff also cost a bit of money, so we would be very happy
                    if you donate something to us!</p>

                <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
                    <input type="hidden" name="cmd" value="_s-xclick">
                    <input type="hidden" name="hosted_button_id" value="9BE4PLYR56QT4">
                    <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif" border="0"
                           name="submit" alt="PayPal - The safer, easier way to pay online!">
                </form>

            </div>
        </div>

    </div>
</div>


<div class="parallax-container valign-wrapper">
    <div class="section no-pad-bot">
        <div class="container">
            <div class="row center">
                <h4 class="header col s12 light-blue-text lighten-5 imgtext">Diorite Minecraft test server:
                    diorite.org</h4>
            </div>
        </div>
    </div>
    <div class="parallax"><img src="mc4.jpg" alt="Unsplashed background img 3"></div>
</div>

<footer class="page-footer teal">
    <%
        //        <div class="container">
//        <div class="row">
//        <div class="col l6 s12">
//        <h5 class="white-text">Company Bio</h5>
//
//        <p class="grey-text text-lighten-4">We are a team of college students working on this project like
//        it's
//        our full time job. Any amount would help support and continue development on this project and is
//        greatly appreciated.</p>
//
//
//        </div>
//        <div class="col l3 s12">
//        <h5 class="white-text">Settings</h5>
//        <ul>
//        <li><a class="white-text" href="#!">Link 1</a></li>
//        <li><a class="white-text" href="#!">Link 2</a></li>
//        <li><a class="white-text" href="#!">Link 3</a></li>
//        <li><a class="white-text" href="#!">Link 4</a></li>
//        </ul>
//        </div>
//        <div class="col l3 s12">
//        <h5 class="white-text">Connect</h5>
//        <ul>
//        <li><a class="white-text" href="#!">Link 1</a></li>
//        <li><a class="white-text" href="#!">Link 2</a></li>
//        <li><a class="white-text" href="#!">Link 3</a></li>
//        <li><a class="white-text" href="#!">Link 4</a></li>
//        </ul>
//        </div>
//        </div>
//        </div>
    %>
</footer>


<!--  Scripts-->
<script src="js/jquery.min.js"></script>
<script src="js/materialize.min.js"></script>
<script src="js/init.js"></script>

</body>
</html>
