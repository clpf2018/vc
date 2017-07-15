## Branch
CodeBr | NameBr	| TelBr	| AddressBr |
-------|------- |-------|-----------|

## Supplier
CodeSup | NameSup | ***Brands*** | TelSup | MobSup     | AddressSup | EmailSup | StatusSup | CreationDateSup | CreationUserSup |
--------| --------| -------------| -------| ---------- | ---------- | -------- | --------- | --------------- | --------------  |

 chaque supplier peut avoir plusieurs brands 
|--------------------------------------------|

## Brand
CodeBrd | NameBrd | ***Supplier*** | chaque Brand concerne un seul supplier |
--------|---------|----------------|----------------------------------------|

## Client
CodeClt | NameClt | TelClt | TitleClt | CatClt | MobClt     | AddressClt | EmailClt | StatusClt | CreationDateClt | CreationUserClt | 
--------|---------|--------| -------- | ------ | ---------- | ---------- | -------- | --------- | --------------- | --------------- |

| Cette entité est necessaire en cas d'envoye de message de ***sale*** |
| -------------------------------------------------------------------  |



## Product
CodePr | BarCodePr | NamePr | TypePr | FamilyPr | QuantityPr |StatusPr  | CreationDatePr  | CreationUserPr  | 
-------|-----------|--------|--------|----------|------------|--------- | --------------- | --------------- |

OriginalPrice | SellingPrice | ***Brand*** | Season  | Location | location: Branch; Status: Available or no | 
--------------|--------------|-------------|-------- |----------| ------------------------------------------|


## Stock
CodeSt | TelSt | AddressSt | StatusSt  | CreationDateSt  | CreationUserSt|
-------|-------|-----------|  -------- | --------------- | --------------|
