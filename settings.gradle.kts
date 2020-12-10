rootProject.name = "demo"

sourceControl {
    gitRepository(java.net.URI("https://github.com/opensagres/xdocreport.git")) {
        producesModule("fr.opensagres.xdocreport:xdocreport")
    }
}