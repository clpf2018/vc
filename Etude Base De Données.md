## Companies: the system may support many companies. STatus to enable/ disable a company 

CompCode | CompName | CompDesc | CreationDate | Status |
-------- | -------- | -------- | ------------ | ------ |



## Branch. Status to enable/ disable a branch. in case the compCode is included in the primary key it should be reflected in all the tables containing branchCode.
CompCode | CodeBr | NameBr | TelBr | AddressBr | Status |
-------- | ------ | ------ | ----- | --------- | ------ |

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


## Categories: will contain client categories
CatCode | CatDesc | DateCreated |
------- | ------- | ----------- |


## Client
CodeClt | NameClt | TelClt | MobClt | TitleClt | CatCode | AddressClt | EmailClt | 
------- | ------- | ------ | ------ | -------- | ------- | ---------- | -------- |
 

*StatusClt(Active/Inactive) Client Status)* | SendSms(Y/N) | CreationDateClt | *CreationUserClt(Created By User)* | 
------------------------------------------- | ------------ | --------------- | ---------------------------------- |


## Product
CodePr | BarCodePr | NamePr | TypePr | FamilyPr | StatusPr(Active/Inactive) | *MadeInPr(made in country)* | CodeBr |
-------| --------- | ------ | ------ | -------- | ------------------------- | --------------------------- | ------ |

CostPrice | SellingPrice | *CodeSupBrand(we have table to match sup with Brand)* | SeasonPr | 
--------- | ------------ | ----------------------------------------------------- | ---------| 

CreationDatePr  | *CreationUserPr (Created By user)*  | 
--------------- | ----------------------------------- |



## Transaction (Debit in Stock ,Credit Out Stock)
TransactionId | TransactionType | TransactionDate | TransactionDbCr |
------------- | --------------- | --------------- | --------------- |

CodePr | CodeBr | CodeSupBrand | CreationDateSt | CreationUserSt | QtyPr |
-----  | ------ | ------------ | -------------- | -------------- | ----- |




## ProductBranchQty 
This table will be filled depending on trigger on transaction Table (Debit Or credit) |
------------------------------------------------------------------------------------- |

CodePr | CodeBr | QtyPr |
------ | ------ | ----- |




## User
CodeUsr | BranchCode | FullNameUsr | TelUsr | AddressUsr | PostUsr | UsrName |
------- | ---------- | ----------- | ------ | ---------- | ------- |---------|

|Password | CreationDateUsr | ModifDateUsr | StatusUsr |
 -------- | --------------- | ------------ | --------- |


## UserProfile

ProfileID | ProfileDesc | DateCreation |
--------- | ----------- | ------------ |

## MenuPermission
CodeMenu | LabelMenu | DateCreationMenu |
-------- | --------- | ---------------- |


## ProfileMenu
ProfileID | CodeMenu | DateCreationProfileMenu |
--------- | -------- | ----------------------- |


## UserMenu
CodeUsr | ProfileID | DateCreationUsrMenu |
------- | --------- | ------------------- |

