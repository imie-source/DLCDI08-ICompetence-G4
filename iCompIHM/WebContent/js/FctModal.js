//<SCRIPT LANGUAGE=javascript>

// Ecrit le titre de la page de façons homogène pour toutes les pages
// Ajoute des blancs pour les fenêtres modales
function ecrireTitre(psTitre, psNom, pbBlancs) { 
    var sTitre = "IMIE - iCompetences - " + psTitre + psNom;
    if (pbBlancs) {
        var sBlanc = String.fromCharCode(160); 
        for(var i=0;i<100; i++) sTitre += sBlanc;
    }
    document.write("<TITLE>" + sTitre + "</TITLE>");
}