
/**  Fait par jad gerges */

•	On a 3 type d’utilisateurs: 
o	Coordinateur 
o	Gestionnaire d’inventaire
o	Gestionnaire de l'entrepôt.



1.	Créer un bien
1.1.	Le gestionnaire d'inventaire est responsable de la création d'éléments dans le système. Chaque article a un code, une description, un code à barres, un coût, un prix, une quantité, une durée de conservation, place_dans_entrepot {numero_de_ligne, étagère, direction}

2.	Receptionner un bien et le placer dans un lieu
2.1.	Lorsque les articles sont reçus dans l'entrepôt, le gestionnaire d'entrepôt doit faire un scan de code à barres pour savoir  place_dans_entrepot des objets reçus afin de les remplirs.
2.2.	Le gestionnaire de l'entrepôt doit entrer le code de l'élément dans le système et la description de l'article et la quantité reçue.
2.3.	Si l'élément reçu n'existe pas, ils doivent retourner à (1. Cree un bien)


3.	Promotion sur un bien (entrepôt virtuelle)
3.1.	Choisissez la description de l'élément du nouveau produit (coordinateur)
3.2.	Assigne un nouveau code à barres (coordinateur)
3.3.	Envoie le coût et le prix de la description des codes barres au (inventaire) afin de publier le produit sur le système
3.4.	Exécutez un bont de commerce pour transférer de l'entrepôt principal à l'entrepôt de promotion afin d'avoir les articles prêts dans l'entrepôt de promotion pour la manipulation.
3.5.	Après avoir fini la manipulation, le coordonnateur doit obtenir le nombre exact des offres effectuées (certaines offres exiperées, endommagées, perdues)
3.6.	Assembler le composant de la offre (1 ou plus) en un produit final
3.7.	L'inventaire doit afficher le produit sur le système avec ses quantités.
3.8.	Le coordinateur doit envoyer un bont de transfert à l'entrepôt pour transférer les quantités de l'entrepôt promotion à l'entrepôt principal (en main).
3.9.	Mettez à jour un nouveau bont de commerce contenant le produit afin de pouvoir le vendre.


4.	Produits endommagés (entrepôt virtuelle)
4.1.	L'entrepôt doit faire un bon de transfert de l'entrepôt principal à l'entrepôt endommagé en déduisant la quantité.

5.	Déplacer un bien
5.1.	Si vous devez déplacer un produit de l'entrepôt principal vers n'importe quel autre emplacement ou entrepôt, le gestionnaire de l'entrepôt doit recevoir (bon de comande bdc par courrier électronique) du coordinateur, en demandant le mouvement du produit
5.2.	De plus, il peut être surveillé par le GPS (par le téléphone du pilote)


6.	Vendre un bien
6.1.	Après avoir reçu un ordre puchase du client, ou remplir un bdc (bon de commerce). Il sera envoyé à l'entrepôt pour préparer la commande. Le bdc contient le code, la description de l'article, le prix et la quantité gratuite si disponible
6.2.	Le travailleur de l'entrepôt doit entrer le code de l'élément dans l'application afin de montrer les informations sur le produit specialise (la rangée, l'étagère, la direction).
6.3.	Lorsque le travailleur de l'entrepôt trouve que le produit sur l'étagère doit analyser le code à barres et entrer la quantité déduite du stock. Et qu'il prépare les articles à envoyer au client au lendemain.

7.	Bien consommable fin de vie
7.1.	Le système doit mettre en évidence le produit dans le tableau avant la date de péremption dans un délai précis.
