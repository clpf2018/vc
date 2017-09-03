## Company:
Ce système peut supporter plusieurs entreprises
----------------------------------------------- |

CompCode | CompName | CompDesc | CompCreationDate | CompStatus(Active/Inactive) |
-------- | -------- | -------- | ---------------- | --------------------------- |

## Branch:

BrCode | CompCode | BrName | BrTel | BrAddress | BrStatus(Active/Inactive) |
------ | -------- | ------ | ----- | --------- | ------------------------- |

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

## UserRole

UsrRoleCode | UsrCode | RoCode |
----------- | ------- | ------ |

## Action
Chaque Role signifie certaines action que l'utilisateur peut faire dans le syst1ème |
----------------------------------------------------------------------------------- |

ActCode | ActName | ActDescription |
------- | ------- | -------------- |

## RoleAction

RoActionCode | RoCode | ActCode |
------------ | ------ | ------- |

## RoleBranch

RoBranchCode | RoCode | BrCode |
------------ | ------ | ------ |

## Client
Les informations sur le client sont necessaires pour envoyer les messages et les catalogues |
------------------------------------------------------------------------------------------- |

CltCode | CltTitle | CltName | CltMobile | CltEmail |  
------- | -------- | ------- | --------- | -------- | 
 
SendMessage (Y/N) | SendCatalogue (Y/N) | CltCreationDate | CltAddress |
----------------- | ------------------- | --------------- | ---------- |

## Stock
Dans le cas où CompCode est inclus dans la clé primaire, il devrait être reflété dans toutes les tables contenant ce field |
-------------------------------------------------------------------------------------------------------------------------- |

StkCode | StkName | StkTel | StkAddress | CompCode |
------- | ------- | ------ | ---------- | -------- |

## Product

PrCode | PrBarCode | PrName | BrdCode | PrType | PrFamily | SupCode | PrStatus (Active/Inactive) |
-------| --------- | ------ | ------- | ------ |--------- | ------- | -------------------------- |

BrdCode | PrSeason | CostPrice | SellingPrice | 
------- | -------- | --------- | ------------ |

## StockProduct

StkProductCode | PrCode | StkCode | StkPrQty |
-------------- | ------ | ------- | -------- |

## Order 
Débit en (stock de la Branche), Crédit hors (stock de la Branche) |
----------------------------------------------------------------- |

OrdCode | OrdDate | OrdSource | OrdDestination | TrCode | OrdQty | CompCode | UsrCode | OrdDbCr|
------- | ------- | --------- | -------------- | ------ | ------ | -------- | ------- |------- |

## Invoice 
Débit en (stock de la Branche), Crédit hors (stock de la Branche) |
----------------------------------------------------------------- |

InvCode | CompCode | PrCode | TrCode | InvDate | BrCode | InvQty | InvDbCr | 
------- | -------- | ------ | ------ | ------- | ------ | ------ | ------- | 

SellingPrice | Value  | Discount | CltCode |
------------ | ------ | -------- | ------- |

## BranchProduct 
Cette table sera remplie en fonction du déclenchement sur la table de transaction (Débit/crédit) |
------------------------------------------------------------------------------------------------ |

BrProductCode | BrCode | PrCode | Qty |
------------- |------- | ------ | --- |

## TransactionType

TrCode | Source | Destination |
------ | ------ | ----------- |
