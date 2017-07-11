Projet C2 :  Gestion de Stock d’une entreprise « X »

# Contributeurs (Par Order Alphabétique) :
1. Abdel Majid Nadar « 10215f » 
2. Ali Chreif « 7880 »
3. Ali Younes « 9902 » 
4. Chiraze Haydar « 2876f »
5. Elias Zgeib « 8114f » 
6. Elie Ohanian « 9290f »
7. Firass Semaan « 3291f » 
8. Khalil Bsaibes « 726z »
9. Mike Rmaily « 6504f » 
10. Mohamed Faour « 3141f »

ce projet consiste à faire un système pour la gestion de stock d’une
entreprise « X ».
On a pris comme étude l’entreprise « Moustache Lebanon » puisqu’elle est
une grande entreprise, ayant plusieurs branches, et son stock est en
mouvement fréquent.
Dans cette étude, on a différents éléments qu’on doit s’occuper de :

## 1- Biens :
« Ce bien possède différents critères : code, type, taille, Brand, saison,
etc. »

### Création d’un bien :
« Comme les propriétaires de l’entreprise sont eux qui importent les
différents produits, on n’a pas une étape d’ordre ou de fabrication »

 ***Créer un bien.*** « cela est fait chaque saison ».
### Détruire un bien :
« Les biens ne seront détruits de la base de données que si leur
quantité est à 0. »
« Les biens ne sont pas donnés, mais transmis dans un magasin ayant
tous les anciens biens : Outlet »
 ***Vendre un bien.***
 Un bien totalement consommé « Quantité en stock est à 0 »
### La vie d’un bien :
« Un bien, lors de son importation ; sera transmis directement dans le
stock. Après vérification des biens reçus, les biens seront transmis
dans les différents branches en suivant le critère : Brand. Or, la
branche principale contient tous les Brands. On peut prêter un bien
entre les différentes branches, en cas de besoins. »
***Réception d’un bien et le placer dans le stock.***

***Déplacer le bien vers les différentes branches.***

***Prêter un bien d’une branche à une autre.***

***Suivre un bien :***
« Cette étape est utilisé en cas de déplacement des biens entre le
stock et les branches, ou bien entre branches. »
***Connaitre la position d’un bien.***

## 2- Supplier :
« Les fournisseurs dans cette entreprise sont les brands »
### Création d’un fournisseur :
« Cela est fait une seule fois dans le programme avec une possibilité
d’ajouter des nouveaux en cas de besoins »
## 3- Stock :
« Apres l’importation des biens, ils seront transmis dans le stock. Après
vérification, les biens avec leurs quantités seront préparés pour chaque
branche. Ensuite, ils seront envoyés vers chaque branche comme
prévu. »
## 4- Branche :
« Les biens seront transmis du stock vers les branches. Chaque branche
fait enregistrer les biens reçus. A ce moment, toutes les actions sur les
biens, se passent dans les branches ».
