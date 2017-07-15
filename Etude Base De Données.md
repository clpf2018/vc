## Branch
CodeBr | NameBr	| TelBr	| AddressBr |
-------|------- |-------|-----------|

## Supplier
CodeSup | NameSup | ***Brands*** | TelSup | chaque supplier peut avoir plusieurs brands |
--------| --------| -------------| -------| --------------------------------------------|

## Brand
CodeBrd | NameBrd | ***Supplier*** | chaque Brand concerne un seul supplier |
--------|---------|----------------|----------------------------------------|

## Client
CodeClt | NameClt | TelClt | Cette entité est necessaire en cas d'envoye de message de ***sale*** |
--------|---------|--------|----------------------------------------------------------------------|

## Stock
CodeSt | TelSt | AddressSt |
-------|-------|-----------|

## Product
CodePr | BarCodePr | NamePr | TypePr | FamilyPr | QuantityPr |
-------|-----------|--------|--------|----------|------------|

OriginalPrice | SellingPrice | ***Brand*** | Season | Status | Location | location: Branch; Status: Available or no | 
--------------|--------------|-------------|--------|--------|----------|------------------------------------------|

