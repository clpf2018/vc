Inventory Management System:

Les principaux composants de l'inventaire sont les suivants: entrepôt, produits, particuliers ou entreprises.

	Entrepôt:
	A warehouse is a location where you store products. it is either a physical 	or a virtual warehouse. it could be a store or a repository.
	Chaque entrepôt a 0 ou plus d'emplacements. Les emplacements sont 	utilisés pour structurer les zones de stockage dans l'entrepôt (e.g: 	Shelf34,Internal locations, emplacement pour les 	fournisseurs)
	
Informations nécessaires: 
Name. (ex: Bourj Abi Haydar)
Short_Name (ex: BAH)
Address (classe).
Locations (Shelf , Marchandise):
Localization:
Corridor
Shelves
Height
Barcode
Location Type (Internal Location , Vendor location , inventory loss).
		
				(More info to be added)


	Produit:
	Le produit doit contenir les champs ci-dessous:
Serial Number:Un Serrial Number est un identifiant unique d'un produit spécifique.
Barcode.
Name.
Quantite.
Product_Type:
Produit Consommable:Un produit pour lequel vous ne souhaitez pas gérer le niveau d'inventaire, mais vous pouvez recevoir et livrer.
Produit Stockable:Un produit pour lequel vous souhaitez gérer le niveau d'inventaire
Produit de service
unité de mesure: Définissez la manière dont la quantité de produits est exprimée. Mètres, kilogramme, paquet de 24 ... Unité de mesure de la même catégorie (ex: taille) peut être convertie les unes aux autres (m, cm, mm) en utilisant un rapport fixe.
NB: les produits peuvent etre regroupés sous des lots indentifies avec un bar code ou un numero de serie unique. En plus nous pouvons avoir un paquet contient plusieurs produits (identifiés par leur numéro de série / perdu ou non).

Individuel ou entreprise:

Le particulier / l'entreprise peut être un fournisseur, un fournisseur ou un client.
 
		
 
