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
CodeBrd | NameBrd | StatusBrd(Active/Inactive) | CreationDateBrd | *CreationUserBrd(Created by User* |
------- | ------- | -------------------------- | --------------- | --------------------------------- |

chaque Brand concerne un seul supplier  |
--------------------------------------- |

## SupBrand
CodeSupBrand | CodeSup | CodeBrd |
------------ | ------- | ------- |

## Client
CodeClt | NameClt | TelClt | MobClt | TitleClt | *CatClt*(client Category(VIP,Regular...) | AddressClt | EmailClt | 
------- | ------- | ------ | ------ | -------- | ---------------------------------------- | ---------- | -------- | 

*StatusClt(Active/Inactive)* | SendSms(Y/N) | CreationDateClt | *CreationUserClt* | 
---------------------------- | ------------ | --------------- | ----------------- |

## Product
CodePr | BarCodePr | NamePr | TypePr | FamilyPr | StatusPr(Active/Inactive) | *MadeInPr(made in country)* | CodeBr |
-------| --------- | ------ | ------ | -------- | ------------------------- | --------------------------- | ------ |

CostPrice | SellingPrice | *CodeSupBrand(we have table to match sup with Brand)* | SeasonPr | 
--------- | ------------ | ----------------------------------------------------- | ---------| 

CreationDatePr  | *CreationUserPr (Created By user)*  | 
--------------- | ----------------------------------- |

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
