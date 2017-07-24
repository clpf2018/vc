## Company:
Ce système peut supporter plusieurs entreprises
----------------------------------------------- |

CompCode | CompName | CompDesc | CompCreationDate | CompStatus(Active/Inactive) |
-------- | -------- | -------- | ---------------- | --------------------------- |

## Branch:
Dans le cas où CompCode est inclus dans la clé primaire, il devrait être reflété dans toutes les tables contenant BrCode |
------------------------------------------------------------------------------------------------------------------------ |

CompCode | BrCode | BrName | BrTel | BrAddress | BrStatus(Active/Inactive) |
-------- | ------ | ------ | ----- | --------- | ------------------------- |

## Supplier
chaque supplier peut avoir plusieurs brands | 
------------------------------------------- |

SupCode | SupName | SupTel | SupMobile | SupAddress | SupEmail | 
------- | ------- | ------ | --------- | ---------- | -------- |  

SupCountry | SupCreationDate | SupStatus(Active/Inactive) |
---------- | --------------- | -------------------------- |
 
## Brand
chaque Brand concerne un seul supplier et une entreprise  |
--------------------------------------------------------- |

CompCode |BrdCode | BrdName | BrdCreationDate | BrdStatus(Active/Inactive) | 
-------- |------- | ------- | --------------- | -------------------------- |

## SupBrand
SupBrandCode | SupCode | BrdCode |
------------ | ------- | ------- |

## User
Chaque utilisateur concerne une branche |
--------------------------------------- |

UsrCode | BrCode | UsrName | UsrEmail | UsrPassword |
------- | ------ | ------- | -------- | ----------- |

## Client
Les informations sur le client sont necessaires pour envoyer les messages et les catalogues |
------------------------------------------------------------------------------------------- |

CltCode | CltTitle | CltName | CltMobile | CltAddress | CltEmail | 
------- | -------- | ------- | --------- | ---------- | -------- |
 
SendMessage (Y/N) | SendCatalogue (Y/N) | CltCreationDate | 
----------------- | ------------------- | --------------- |

## Stock
Dans le cas où CompCode est inclus dans la clé primaire, il devrait être reflété dans toutes les tables contenant StockCode |
--------------------------------------------------------------------------------------------------------------------------- |

CompCode | StkCode | StkName | StkTel | StkAddress | 
-------- | ------- | ------- | ------ | ---------- | 

## Product
CompCode |PrCode | PrBarCode | PrName | PrType | PrFamily | PrStatus (Active/Inactive) |
-------- |-------| --------- | ------ | ------ | -------- | -------------------------- |

CostPrice | SellingPrice | PrSeason | PrCreationDate | 
--------- | ------------ | ---------| -------------- |

## Transfert ou Order 
Débit en (stock de la Branche), Crédit hors (stock de la Branche) |
----------------------------------------------------------------- |

CompCode | PrCode | TransCode | TransType | TransDate | TransDbCr | TransQty |TransFrom | TransTo |
-------- | ------ | --------- | --------- | --------- | --------- | -------- |----------| ------- |

## ProductBranchQty 
Cette table sera remplie en fonction du déclenchement sur la table de transfert (Débit/crédit) |
---------------------------------------------------------------------------------------------- |

CompCode | PrCode | BrCode | PrQty |
-------- |------- | ------ | ----- |

