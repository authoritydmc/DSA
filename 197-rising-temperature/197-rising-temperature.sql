# Write your MySQL query statement below


select asli.id from weather asli join weather w on  asli.temperature > w.temperature and datediff(asli.recordDate,w.recordDate)=1;