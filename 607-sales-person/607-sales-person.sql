select distinct name from SalesPerson where sales_id  not in (

    select distinct sales_id from Orders where com_id in (select com_id from company where  name="RED")
)
