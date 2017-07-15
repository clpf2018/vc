## Branch
CodeBr | NameBr	| TelBr	| AddressBr |
-------|------- |-------|-----------|

## Supplier
CodeSup | NameSup | ***Brands*** | TelSup | MobSup     | AddressSup | EmailSup | StatusSup | CreationDateSup | CreationUserSup |
--------| --------| -------------| -------| ---------- | ---------- | -------- | --------- | --------------- | --------------  |

 chaque supplier peut avoir plusieurs brands 
|--------------------------------------------|

## Brand
CodeBrd | NameBrd | ***Supplier*** | StatusBrd | CreationDateBrd | CreationUserBrd |chaque Brand concerne un seul supplier  |
--------|---------|----------------|---------  | --------------- | --------------  |----------------------------------------|

## Client
CodeClt | NameClt | TelClt | MobClt   |TitleClt | CatClt     | AddressClt | EmailClt | StatusClt | CreationDateClt | CreationUserClt | 
--------|---------|--------| -------- | ------  | ---------- | ---------- | -------- | --------- | --------------- | --------------- |

| Cette entité est necessaire en cas d'envoye de message de ***sale*** |
| -------------------------------------------------------------------  |



## Product
CodePr | BarCodePr | NamePr | TypePr | FamilyPr |  StatusPr  | 
-------|-----------|--------|--------|----------|---------   | 

CostPrice     | SellingPrice | ***Brand*** | SeasonPr  | CreationDatePr  | CreationUserPr  | 
--------------|--------------|-------------|--------   | --------------- | --------------- |

## ProductQtyLocation
CodePr | Location | QtyPr |
------ | -------- | ----- |

## Stock
CodeSt | TelSt | AddressSt | StatusSt  | CreationDateSt  | CreationUserSt|
-------|-------|-----------|  -------- | --------------- | --------------|
