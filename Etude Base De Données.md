## Companies: the system may support many companies. Status to enable/ disable a company 

CompCode | CompName | CompDesc | CreationDate | Status |
-------- | -------- | -------- | ------------ | ------ |



## Branch. Status to enable/ disable a branch. in case the compCode is included in the primary key it should be reflected in all the tables containing branchCode.
CompCode | CodeBr | NameBr | TelBr | AddressBr | Status |
-------- | ------ | ------ | ----- | --------- | ------ |

## Supplier
CompCode |CodeSup | NameSup | TelSup | MobSup | AddressSup | EmailSup | StatusSup(Active/Inactive) |
-------- |------- | ------- | ------ | ------ | ---------- | -------- | -------------------------- | 

CountrySup | CreationDateSup | CreationUserSup |
---------- | --------------- | --------------- |

chaque supplier peut avoir plusieurs brands | 
------------------------------------------- |
 
## Brand
CompCode |CodeBrd | NameBrd | StatusBrd(Active/Inactive) | CreationDateBrd | *CreationUserBrd(Created by User* |
-------- |------- | ------- | -------------------------- | --------------- | --------------------------------- |

chaque Brand concerne un seul supplier  |
--------------------------------------- |

## SupBrand
CompCode |CodeSupBrand | CodeSup | CodeBrd |
-------- |------------ | ------- | ------- |


## Categories: will contain client categories
CompCode |CatCode | CatDesc | DateCreated |
-------- |------- | ------- | ----------- |


## Client
CompCode |CodeClt | NameClt | TelClt | MobClt | TitleClt | CatCode | AddressClt | EmailClt | 
-------- |------- | ------- | ------ | ------ | -------- | ------- | ---------- | -------- |
 

*StatusClt(Active/Inactive) Client Status)* | SendSms(Y/N) | CreationDateClt | *CreationUserClt(Created By User)* | 
------------------------------------------- | ------------ | --------------- | ---------------------------------- |


## Product
CompCode |CodePr | BarCodePr | NamePr | TypePr | FamilyPr | StatusPr(Active/Inactive) | *MadeInPr(made in country)* | 
-------- |-------| --------- | ------ | ------ | -------- | ------------------------- | --------------------------- | 

CostPrice | SellingPrice | *CodeSupBrand(we have table to match sup with Brand)* | SeasonPr | 
--------- | ------------ | ----------------------------------------------------- | ---------| 

CreationDatePr  | *CreationUserPr (Created By user)*  | 
--------------- | ----------------------------------- |



## Transaction (Debit in Stock ,Credit Out Stock)
CompCode |TransactionId | TransactionType | TransactionDate | TransactionDbCr |
-------- |------------- | --------------- | --------------- | --------------- |

CodePr | CodeBr | CodeSupBrand | CreationDateSt | CreationUserSt | QtyPr |From_CodeBr | To_CodeBr  | conf_trf |
-----  | ------ | ------------ | -------------- | -------------- | ----- |------------| ---------- | ---------|




## ProductBranchQty 
This table will be filled depending on trigger on transaction Table (Debit Or credit) |
------------------------------------------------------------------------------------- |

CompCode |CodePr | CodeBr | QtyPr |
-------- |------ | ------ | ----- |




## User
CompCode |CodeUsr | CodeBr | FullNameUsr | TelUsr | AddressUsr | PostUsr | UsrName |
-------- |------- | ------ | ----------- | ------ | ---------- | ------- |---------|

|Password | CreationDateUsr | ModifDateUsr | StatusUsr |
 -------- | --------------- | ------------ | --------- |


## UserProfile

CompCode |ProfileID | ProfileDesc | DateCreation |
-------- |--------- | ----------- | ------------ |

## MenuPermission
CompCode |CodeMenu | LabelMenu | DateCreationMenu |
-------- |-------- | --------- | ---------------- |


## ProfileMenu
CompCode |ProfileID | CodeMenu | DateCreationProfileMenu |
-------- |--------- | -------- | ----------------------- |


## UserMenu
CompCode |CodeUsr | ProfileID | DateCreationUsrMenu |
-------- |------- | --------- | ------------------- |

