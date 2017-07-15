## Branch
CodeBr | NameBr	| TelBr	| AddressBr |
-------|------- |-------|-----------|

## Supplier
CodeSup | NameSup | ***Brands*** | TelSup | MobSup     | AddressSup | EmailSup | StatusSup(Active/Inactive) |
--------| --------| -------------| -------| ---------- | ---------- | -------- | -------------------------- | 

StatusSup(A/I) | CreationDateSup | CreationUserSup |
---------------| --------------- | --------------  |

 chaque supplier peut avoir plusieurs brands 
|--------------------------------------------|

## Brand
  | NameBrd | ***Supplier*** | StatusBrd(A/I)| CreationDateBrd | CreationUserBrd |chaque Brand concerne un seul supplier  |
--------|---------|----------------|-------------- | --------------- | --------------  |----------------------------------------|

## Client
CodeClt | NameClt | TelClt | MobClt   |TitleClt | CatClt     | AddressClt | EmailClt | StatusClt(Active/Inactive) | SendSms(Y/N) |
--------|---------|--------| -------- | ------  | ---------- | ---------- | -------- | -------------------------  | ------------ |

CreationDateClt | CreationUserClt | 
--------------- | --------------- |



## Product
CodePr | BarCodePr | NamePr | TypePr | FamilyPr |  StatusPr(A/I)  | 
-------|-----------|--------|--------|----------|--------------   | 

CostPrice     | SellingPrice | ***Brand*** | SeasonPr  | CreationDatePr  | CreationUserPr  | 
--------------|--------------|-------------|--------   | --------------- | --------------- |



## Stock
CodeSt | TelSt | AddressSt | StatusSt(A/I)  | CreationDateSt  | CreationUserSt|
-------|-------|-----------|  --------      | --------------- | --------------|

## Transaction
TransactionId | TransactionType | TransactionDate | TransactionNo | TransactionDbCr |
--------------| --------------- | --------------- | ------------- | --------------- |

CodePr | CodeBr | CodeSup   |  CodeBrd     | CreationDateSt  | CreationUserSt |
-----  |------- |-----------|  --------    | --------------  | ---------------| 


## ProductBranchQty

CodePr | CodeBr   | QtyPr |
------ | -------- | ----- |
