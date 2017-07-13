
# Introduction
## Descriptions succincte:

Une entitée (entreprise) style association ou a but non lucratif où le financement est multiple (Public: étatique ou collectivité locale, privée par vente de service et dons). Cette entité est constitué de centres situés sur des sites physiquement différent et distant. Le financement d'un centre est couvert au moins de deux façons, un financement collectif de la part de l'entité centrale et un financement propre (en général des dons et collectivités locales)

Chaque centre a la liberté de commander des marchandises ou produits. Il existe au moins deux sources de financement des biens: Financement local ou financement collectif. A l'arrivée de la commande (bordereaux de commande) la marchandise est entrée dans le stock dit "stock principal". Les marchandises, matériels ou articles ne peuvent pas sortir directement du stock principal, ils doivent transiter par un guichet avant d'être distribuées aux utilisateur finaux.

Nous parlerons de biens pour décrire toute possession ou ressource disponible pour l’entité.

Les biens sont localisés dans l’entreprise (Sites / Salle / Hangard / guichet / tiroire / coffre / etc ...)

Les biens sont déplacés d'une position vers une autre  au moyen d'une opération ou transaction de transfert (un mouvement)

Un utilisateur final (celui qui à besoin d'utilisation du bien) se procure le bien à un guichet où le bien demandé est disponible.

Il existe plusieurs types de bien (matériel, produit, marchandise, consommable, immatériel, etc...) :  les biens consommables et les articles amortissables

Le bien consommable est pris par un utilisateur et n'est plus jamais restitué. Par contre un bien amortissable est restitué après utilisation.

Un bien immatériel ou ressource peut être disponible sur une période de temps donnée

## Ce que l'on souhaiterait réaliser.

Développer une application permettant, au moins, de suivre l'état global du patrimoine: 

* Quantités globale dans l'entreprise (tous les sites)
* Quantités globale par sites
* Quantités en magasin
* Position (lieu) ou référence des biens dans une "cartographie de l'entreprise"
* Suivie des matériels consommable (consommation par utilisateur ou catégorie d'utilisateurs)
* Suivie des articles non périssable (amortissable) : ou se trouve l'article (avec qui et lieu d'utilisation), quand est prévue le retour, etc..

Ce système devrait permettre d'une part la gestion des opérations du stock (utilisateurs: le gestionnaire du stock et les magasiniers) et d'autre part la consultation et l'information concernant le stock (utilisateurs: La direction, l'utilisateur final, ...)

---

### On a 3 type d’utilisateurs:  TODO il y en a encore plein d'autre
* Coordinateur 
* Gestionnaire d’inventaire
* Gestionnaire de l'entrepôt.


# Backlog produit : initial TODO a géré plutot dans des issue...
1. Créer un bien
     1.	Le gestionnaire d'inventaire est responsable de la création d'éléments dans le système. Chaque article a un code, une description, un code à barres, un coût, un prix, une quantité, une durée de conservation, place_dans_entrepot {numero_de_ligne, étagère, direction}
  
2. Receptionner un bien et le placer dans un lieu
    1. Lorsque les articles sont reçus dans l'entrepôt, le gestionnaire d'entrepôt doit faire un scan de code à barres pour savoir  place_dans_entrepot des objets reçus afin de les remplirs.
    2. Le gestionnaire de l'entrepôt doit entrer le code de l'élément dans le système et la description de l'article et la quantité reçue.
    3. Si l'élément reçu n'existe pas, ils doivent retourner à (1. Cree un bien)
3. Promotion sur un bien (entrepôt virtuelle)
    1.	Choisissez la description de l'élément du nouveau produit (coordinateur)
    2.	Assigne un nouveau code à barres (coordinateur)
    3.	Envoie le coût et le prix de la description des codes barres au (inventaire) afin de publier le produit sur le système
    4.	Exécutez un bont de commerce pour transférer de l'entrepôt principal à l'entrepôt de promotion afin d'avoir les articles prêts dans l'entrepôt de promotion pour la manipulation.
    5.	Après avoir fini la manipulation, le coordonnateur doit obtenir le nombre exact des offres effectuées (certaines offres exiperées, endommagées, perdues)
    6.	Assembler le composant de la offre (1 ou plus) en un produit final
    7.	L'inventaire doit afficher le produit sur le système avec ses quantités.
    8.	Le coordinateur doit envoyer un bont de transfert à l'entrepôt pour transférer les quantités de l'entrepôt promotion à l'entrepôt principal (en main).
    9.	Mettez à jour un nouveau bont de commerce contenant le produit afin de pouvoir le vendre.
4. Produits endommagés (entrepôt virtuelle)
    1.	L'entrepôt doit faire un bon de transfert de l'entrepôt principal à l'entrepôt endommagé en déduisant la quantité.
5.	Déplacer un bien
    1.	Si vous devez déplacer un produit de l'entrepôt principal vers n'importe quel autre emplacement ou entrepôt, le gestionnaire de l'entrepôt doit recevoir (bon de comande bdc par courrier électronique) du coordinateur, en demandant le mouvement du produit
    5.2.	De plus, il peut être surveillé par le GPS (par le téléphone du pilote)
6.	Vendre un bien
    1.	Après avoir reçu un ordre puchase du client, ou remplir un bdc (bon de commerce). Il sera envoyé à l'entrepôt pour préparer la commande. Le bdc contient le code, la description de l'article, le prix et la quantité gratuite si disponible
    2.	Le travailleur de l'entrepôt doit entrer le code de l'élément dans l'application afin de montrer les informations sur le produit specialise (la rangée, l'étagère, la direction).
    3.	Lorsque le travailleur de l'entrepôt trouve que le produit sur l'étagère doit analyser le code à barres et entrer la quantité déduite du stock. Et qu'il prépare les articles à envoyer au client au lendemain.

7.	Bien consommable fin de vie
    1.	Le système doit mettre en évidence le produit dans le tableau avant la date de péremption dans un délai précis.
    
8. Consolider l'inventaire de stock
    1. Compter le stock physiquement
