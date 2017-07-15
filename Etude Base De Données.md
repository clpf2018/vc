## Branch
CodeBr | NameBr	| TelBr	| AddressBr |
-------|------- |-------|-----------|

## Supplier
CodeSup | NameSup |  TelSup | MobSup     | AddressSup | EmailSup | StatusSup(Active/Inactive) |
--------| --------|  -------| ---------- | ---------- | -------- | -------------------------- | 

CountrySup     |StatusSup(A/I) | CreationDateSup | CreationUserSup |
---------------|---------------| --------------- | --------------  |

 
## Brand
CodeBrd | NameBrd | ***Supplier*** | StatusBrd(A/I)| CreationDateBrd | CreationUserBrd |chaque Brand concerne un seul supplier  |
--------|---------|----------------|-------------- | --------------- | --------------  |----------------------------------------|


chaque supplier peut avoir plusieurs brands 
|--------------------------------------------|

## SupBrand

CodeSupBrand | CodeSup | CodeBrd |
------------ | ------- | ------- |


## Client
CodeClt | NameClt | TelClt | MobClt   |TitleClt | CatClt     | AddressClt | EmailClt | StatusClt(Active/Inactive) | SendSms(Y/N) |
--------|---------|--------| -------- | ------  | ---------- | ---------- | -------- | -------------------------  | ------------ |

CreationDateClt | CreationUserClt | 
--------------- | --------------- |


## Product
CodePr | BarCodePr | NamePr | TypePr | FamilyPr |  StatusPr(A/I)  | MadeInPr | CodeBrd |
-------|-----------|--------|--------|----------|--------------   | -------- | ------- |

CostPrice     | SellingPrice |  CodeSupBrand     | SeasonPr        | CreationDatePr  | CreationUserPr  | 
--------------|--------------|-----------------  |  --------       | --------------- | --------------- | 


## Transaction(Debit in Stock ,Credit Out Stock)
TransactionId | TransactionType | TransactionDate | TransactionNo | TransactionDbCr |
--------------| --------------- | --------------- | ------------- | --------------- |

CodePr | CodeBr | CodeSupBrand     | CreationDateSt  | CreationUserSt |
-----  |------- |----------------- |  -----------    | -------------- | 


## ProductBranchQty (this table will be fill depends trigger on transaction Table (Debit Or credit)

CodePr | CodeBr   | QtyPr |
------ | -------- | ----- |
