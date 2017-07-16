## Branch
CodeBr | NameBr	| TelBr	| AddressBr |
------ | ------ | ----- | --------- |

## Supplier
CodeSup | NameSup | TelSup | MobSup | AddressSup | EmailSup | StatusSup(Active/Inactive) |
------- | ------- | ------ | ------ | ---------- | -------- | -------------------------- | 

CountrySup | CreationDateSup | CreationUserSup |
---------- | --------------- | --------------- |

chaque supplier peut avoir plusieurs brands | 
------------------------------------------- |
 
## Brand
CodeBrd | NameBrd | StatusBrd(Active/Inactive) | CreationDateBrd | *CreationUserBrd* |
------- | ------- | -------------------------- | --------------- | ----------------- |

chaque Brand concerne un seul supplier  |
--------------------------------------- |

## SupBrand
CodeSupBrand | CodeSup | CodeBrd |
------------ | ------- | ------- |

## Client
CodeClt | NameClt | TelClt | MobClt | TitleClt | *CatClt* | AddressClt | EmailClt | 
------- | ------- | ------ | ------ | -------- | -------- | ---------- | -------- | 

*StatusClt(Active/Inactive)* | SendSms(Y/N) | CreationDateClt | *CreationUserClt* | 
---------------------------- | ------------ | --------------- | ----------------- |

## Product
CodePr | BarCodePr | NamePr | TypePr | FamilyPr | StatusPr(Active/Inactive) | *MadeInPr* | CodeBr |
-------| --------- | ------ | ------ | -------- | ------------------------- | ---------- | ------ |

CostPrice | SellingPrice | *CodeSupBrand* | SeasonPr | CreationDatePr  | *CreationUserPr*  | 
--------- | ------------ | -------------- | -------- | --------------- | ----------------- | 

## Transaction (Debit in Stock ,Credit Out Stock)
TransactionId | TransactionType | TransactionDate | TransactionNo | TransactionDbCr |
------------- | --------------- | --------------- | ------------- | --------------- |

CodePr | CodeBr | CodeSupBrand | CreationDateSt | CreationUserSt |
-----  | ------ | ------------ | -------------- | -------------- | 

## ProductBranchQty 
This table will be filled depending on trigger on transaction Table (Debit Or credit) |
------------------------------------------------------------------------------------- |

CodePr | CodeBr | QtyPr |
------ | ------ | ----- |
