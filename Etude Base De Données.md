## Company:
Ce système peut supporter plusieurs entreprises
----------------------------------------------- |

CompCode | CompName | CompDesc | CompCreationDate | CompStatus(Active/Inactive) |
-------- | -------- | -------- | ---------------- | --------------------------- |

## Branch:

CompCode | BrCode | BrName | BrTel | BrAddress | BrStatus(Active/Inactive) |
-------- | ------ | ------ | ----- | --------- | ------------------------- |

## Supplier
chaque supplier peut avoir plusieurs brands | 
------------------------------------------- |

SupCode | SupName | SupTel | SupMobile | SupAddress | SupEmail | 
------- | ------- | ------ | --------- | ---------- | -------- |  

## Brand
chaque Brand concerne un seul fournisseur |
----------------------------------------- |

BrdCode | BrdName | BrdCreationDate | BrdStatus(Active/Inactive) | 
------- | ------- | --------------- | -------------------------- |

## User
Chaque utilisateur concerne une branche et accède les autres branches selon son role |
------------------------------------------------------------------------------------ |

UsrCode | UsrFullName | UsrUsername | UsrPass | UsrMobile | UsrAddress |
------- | ----------- | ----------- | ------- | --------- | ---------- |

## Role
Chaque utilisateur possède un role bien defini dans le syst1ème |
--------------------------------------------------------------- |

RoCode | RoName |
------ | ------ |

## Action
Chaque Role signifie certaines action que l'utilisateur peut faire dans le syst1ème |
----------------------------------------------------------------------------------- |

ActCode | ActName | ActDescription |
------- | ------- | -------------- |

## RoleAction

RoCode | ActCode |
------ | ------- |

## UserRoleBranch

UsrCode | RoCode | BrCode |
------- | ------ | ------ |

## Client
Les informations sur le client sont necessaires pour envoyer les messages et les catalogues |
------------------------------------------------------------------------------------------- |

CompCode | CltCode | CltTitle | CltName | CltMobile | CltAddress | CltEmail | 
-------- | ------- | -------- | ------- | --------- | ---------- | -------- |
 
SendMessage (Y/N) | SendCatalogue (Y/N) | CltCreationDate | 
----------------- | ------------------- | --------------- |

## Stock
Dans le cas où CompCode est inclus dans la clé primaire, il devrait être reflété dans toutes les tables contenant ce fiels |
-------------------------------------------------------------------------------------------------------------------------- |

CompCode | StkCode | StkName | StkTel | StkAddress | 
-------- | ------- | ------- | ------ | ---------- | 

## Product

PrCode | PrBarCode | PrName | BrdCode | PrFamily | PrStatus (Active/Inactive) |
-------| --------- | ------ | ------- | -------- | -------------------------- |

CostPrice | SellingPrice | PrSeason | 
--------- | ------------ | ---------|

## StockProduct

StkCode | PrCode | StkPrQty |
------- | ------ | -------- |

## Order 
Débit en (stock de la Branche), Crédit hors (stock de la Branche) |
----------------------------------------------------------------- |

PrCode | TrCode | OrdCode | OrdDate | OrdSource | OrdDestination |OrdQty |
------ | ------ | ------- | ------- | --------- | -------------- | ----- |

## ProductBranchQty 
Cette table sera remplie en fonction du déclenchement sur la table de transfert (Débit/crédit) |
---------------------------------------------------------------------------------------------- |

CompCode | PrCode | BrCode | BrPrQty |
-------- |------- | ------ | ------- |

## TransactionType

TrCode | Source | Destination |
------ | ------ | ----------- |
