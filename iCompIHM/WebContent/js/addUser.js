 //<![CDATA[

function estVide(s)
{
	return ((s == null) || (s.length == 0));
}

//Le caractere est-il une lettre ?
function estLettre(c)
{
	return ( ((c >= "a") && (c <= "z")) || ((c >= "A") && (c <= "Z")) );
}

// Le caractere est-il une lettre minuscule ?
function estMinuscule(c)
{
	return ( (c >= "a") && (c <= "z") );
}

// Le caractere est-il une lettre majuscule ?
function estMajuscule(c)
{
	return ( (c >= "A") && (c <= "Z") );
}

function estNumerique(c)
{ 
	return ((c >= "0") && (c <= "9"));
}

//Le caractere est-il soit un chiffre, soit une lettre ?
function estAlphaNumerique(c)
{
	return (estLettre(c) || estNumerique(c));
}

function estBlanc(c)
{
	var blancs = " \t\n\r";
	if (c == '') return false;
	return (blancs.indexOf(c) != -1);
}

function estDesNumeriques(s,bool)
{   
    // chaine vide ?
    if (estVide(s)) return bool;
	//Recherche caractere par caractere jusqu'a un caractere non numerique
	for (i = 0; i < s.length; i++)
	{
		if (!estNumerique(s.charAt(i))) return false;
    }
	return true;
}

// La chaine est-elle une annee ?
// Option : opt=0 => aa ou aaaa, opt=1 => aa et opt=2 => aaaa
function estAnnee(s,opt,bool)
{  
    // chaine vide ?
    if (estVide(s)) return bool;
	if ( (!estDesNumeriques(s,bool)) || ((s.length != 2) && (s.length != 4)) ) return false;
	if ( ((opt == 1) && (s.length != 2)) || ((opt == 2) && (s.length != 4)) ) return false;
	return true;
}

// La chaine est-elle un mois (entier entre 1 et 12) ?
// Option : opt=0 => m ou mm, opt=1 => mm
function estMois(s,opt,bool)
{  
    // chaine vide ?
    if (estVide(s)) return bool; 
	if ( (!estDesNumeriques(s,bool)) || (s.length > 2) ) return false;
	if ( (opt == 1) && (s.length == 1) ) return false;
	lemois=parseInt(s,10);
	if ( (lemois < 1) || (lemois > 12) ) return false;
	return true;
}

// La chaine est-elle un jour (entier entre 1 et 31) ?
// Option : opt=0 => j ou jj, opt=1 => jj
function estJour(s,opt,bool)
{  
    // chaine vide ?
    if (estVide(s)) return bool; 
	if ( (!estDesNumeriques(s,bool)) || (s.length > 2) ) return false;
	if ( (opt == 1) && (s.length == 1) ) return false;
	lejour=parseInt(s,10);
	if ( (lejour < 1) || (lejour > 31) ) return false;
	return true;
}

function joursDansLeMoisDeFevrier(annee)
{
	
	//Fevrier contient 29 jours les annees divisibles par 4, sauf les centenaires
	//Fevrier contient aussi 29 jours les centenaires divisibles par 400
    return (  ((annee % 4 == 0) && ( (!(annee % 100 == 0)) || (annee % 400 == 0) ) ) ? 29 : 28 );
}

function estDateCoherente(jour,mois,annee)
{
	//Attention, le mois de fevrier devra etre recalcule!
	var joursDansLeMois = new Array(0,31,29,31,30,31,30,31,31,30,31,30,31);
    intJour = parseInt(jour,10);
    intMois = parseInt(mois,10);
    intAnnee = parseInt(annee,10);
	//Test sur le nombre de jousr dans le mois (traitement en plus a faire pour Fevrier)
    if (intJour > joursDansLeMois[intMois]) return false; 
    if ((intMois == 2) && (intJour > joursDansLeMoisDeFevrier(intAnnee))) return false;
    return true;
}

function estDate(s,optjour,optmois,optannee,bool)
{   
    // chaine vide ?
    if (estVide(s)) return bool;
	//Decoupage de la chaine en jour/mois/annee
	i=0;
    len=s.length;
    while ( (i < len) && (s.charAt(i) != '/') ) i++;
	jour=s.substring(0,i);
	i++;
    while ( (i < len) && (s.charAt(i) != '/') ) i++;
	mois=s.substring(jour.length+1,i);
	if (i <= len) annee=s.substring(i+1,len);
	else annee="";
	//test des options d longueur des champs (si l'un des champs est vide, retourner une erreur)
	if ( (!estJour(jour,1,false)) || (!estMois(mois,1,false)) || (!estAnnee(annee,2,false)) ) return false;
	//Test de coherence du triplet
	return estDateCoherente(jour,mois,annee);
}

function estEmail(s,bool)
{   
    // chaine vide ?
    if (estVide(s)) return bool;
	//Recherche caractere par caractere jusqu'a un caractere '@'
	i=1;
    len=s.length;
    while ( (i < len) && (s.charAt(i) != '@') ) {
		if (estBlanc(s.charAt(i))) return false; 
		i++;
	}
    if ( (i >= len) || (s.charAt(i) != '@') ) return false;
    else i += 2;//Il doit y avoir au moins  caractere entre le '@' et le '.', d'ou le +2
	//Recherche caractere par caractere jusqu'a un caractere '.'
    while ( (i < len) && (s.charAt(i) != '.') ) {
		if (estBlanc(s.charAt(i))) return false; 
		i++;
	}
    if ( (i >= len-1) || (s.charAt(i) != '.')) return false;//Au moins 1 caractere apres le '.'
    else return true;
}

//Controle de la validite du masque
function verifierMasqueQuelconque(msq) {
	if (estVide(msq)) return false;
	return true;
}

// Controle d'un champ de saisie caractere par caractere selon le masque de saisie
// types de caracteres : L => Majuscule ou Minuscule, M => Majuscule, m => Majuscule,
//                       9 => Numerique, A => Numerique, Majuscule ou Minuscule, ? => quelconque
//                       P => Numerique ou Majuscule, p = > Numerique ou Minuscule
// Les autres caracteres du format sont a respecter en dur
// Ex : AAMM99mmm
function verifierFormatQuelconque(s,masque,bool) {
	if (!verifierMasqueQuelconque(masque)) return bool;
	if (estVide(s)) return bool;
	if (s.length != masque.length) return false;
	for (i=0; i<s.length; i++) {
		carM=masque.charAt(i);
		carS=s.charAt(i);
		if (carM == 'L') {
			if (!estLettre(carS)) return false;
		}
		else if (carM == 'M') {
			if (!estMajuscule(carS)) return false;
		}
		else if (carM == 'm') {
			if (!estMinuscule(carS)) return false;
		}
		else if (carM == '9') {
			if (!estNumerique(carS)) return false;
		}
		else if (carM == 'A') {
			if (!estAlphaNumerique(carS)) return false;
		}
		else if (carM == 'P') {
			if ( (!estNumerique(carS)) && (!estMajuscule(carS)) ) return false;
		}
		else if (carM == 'p') {
			if ( (!estNumerique(carS)) && (!estMinuscule(carS)) ) return false;
		}
		else if (carM == '?') {}
		else {
			if (carS != carM) return false;
		}
	}
	return true;
}

function valider(form){
  
  // Controle Nom
  if(form.elements['nom'].value == "") {
    alert("Saisissez le nom");
    return false;
  }
  
  // Controle Prenom
  if(form.elements['prenom'].value == "") {
    alert("Saisissez le prénom");
    return false;
  }
  
  // Controle Date de Naissance
  if(form.elements['dateNaissance'].value != "") {
    if(!estDate(form.elements['dateNaissance'].value,1,1,2,false)){
    	alert("Format de date de naissance incorrect (JJ/MM/AAAA) ou date inexistante");
        return false;
    }
  }
  
  // Controle E-Mail
  if(form.elements['mail'].value != "") {
    if(!estEmail(form.elements['mail'].value,false)) {
    	alert("Format d'email incorrect");
        return false;
    }
  } else {
	  alert("Saisissez l'e-mail");
	  return false;
  }
  
  // Controle Tel
  if(form.elements['tel'].value != "") {
	 if(!verifierFormatQuelconque(form.elements['tel'].value,'0999999999',false)){
		 alert("Format de numero de telephone incorrect (0XXXXXXXXX)");
	     return false;
	 }
  }

  
  // Controle Fax
  if(form.elements['fax'].value != "") {
	  if(!verifierFormatQuelconque(form.elements['fax'].value,'0999999999',false)){
		  alert("Format de numero de fax incorrect (0XXXXXXXXX)");
		  return false;
	  }
  }
  
  // Controle Identifiant
  if(form.elements['identifiant'].value == "") {
    alert("Saisissez le login");
    return false;
  }
  
  // Controle Mot de Passe
  if(form.elements['password'].value == "") {
    alert("Saisissez le mot de passe");
    return false;
  } else {
	  if (form.elements['password'].value.length < 6){
		  alert("Le mot de passe doit contenir au minimum 6 caractères");
		  return false;
	  }
  }
  
  // Controle Confirmer le Mot de Passe
  if(form.elements['confirmpassword'].value == "") { 
      alert("Confirmez le mot de passe");
	  return false;
  }
  else {
       if(form.elements['confirmpassword'].value != form.elements['password'].value) {
    	   alert("Le mot de passe est different de la confirmation");
    	   return false; 
       }
  }
  
  return true;
  
 
}

//]]>
