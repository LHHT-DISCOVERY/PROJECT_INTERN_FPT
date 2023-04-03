CREATE DATABASE FTM;
use FTM ;

-- Qa and Q2
CREATE TABLE Trainee
(
	TraineeID INT IDENTITY(1,1) PRIMARY KEY,
	Full_Name NVARCHAR(50) NOT NULL,
	Birth_Date DATE NOT NULL,
	GENDER	NVARCHAR(6) NOT NULL 
	CONSTRAINT CK_Gender CHECK ( Gender IN ('Male', 'FeMale')) ,
	ET_IQ INT NOT NULL 
	CONSTRAINT CK_IQ CHECK (ET_IQ BETWEEN 0 AND 20),
	ET_Gmath INT NOT NULL 
	CONSTRAINT CK_Gmath CHECK (ET_Gmath BETWEEN 0 AND 20),
	ET_English INT NOT NULL 
	CONSTRAINT CK_English CHECK (ET_English BETWEEN 0 AND 20),
	Trainning_Class VARCHAR(15) NOT NULL,
	Evaluation NVARCHAR(MAX) NOT NULL,
	Fsoft_Account as 'FSAccount_'+ Cast( TraineeID as Varchar(40)) PERSISTED NOT NULL  
)


 -- Insert value to table
 INSERT INTO Trainee 
 (Full_Name, Birth_Date, GENDER, ET_IQ, ET_Gmath, ET_English, Trainning_Class, Evaluation)
 VALUES 
 (
	N'Lê Phương Lan Anh', '2001-10-04', N'FeMale', 10, 14, 15, N'FA.DAN.JAVA02', 'Good'
 ),
  (
	N'Huỳnh Ngọc Lan', '2000-01-06', N'FeMale', 4, 6, 8, N'FA.DAN.JAVA02', 'Bad'
 ),
  (
	N'Lương Sơn Bá', '2001-07-21', N'Male', 20, 20, 20, N'FA.DAN.IOS', 'Excellent'
 ),
 (
	N'Chúc Anh Đài', '2003-06-21', N'FeMale', 20, 19, 20, N'FA.DAN.IOS', 'Excellent'
 ),
 (
	N'Mã Văn Tài', '2001-12-03', N'Male', 18, 17, 17, N'FA.DAN.IOS', 'Talent'
 ),
 (
	N'Lê Đông Huy', '1998-06-05', N'Male', 10, 6, 4, N'FA.DAN.IOS', 'Normal'
 ),
(
	N'Bùi Ngọc An Hạo', '2001-08-09', N'FeMale', 4, 2, 3, N'FA.DAN.IOS', 'Bad'
 ),
 (
	N'Trần Tuấn Tú', '2000-10-11', N'Male', 6, 4, 1, N'FA.DAN.IOS', 'Bad'
 ),
 (
	N'Nguyễn Đức Đông Thi', '2001-12-01', N'Male', 12, 14, 18, N'FA.DAN.JAVA03', 'Good'
 ),
  (
	N'Lê Thị Nở', '2001-12-01', N'FeMale', 10, 6, 7, N'FA.DAN.JAVA03', 'bad'
 );

 GO

 -- Qest C
 CREATE VIEW ET_Passed_Trainees  
 AS 
	SELECT *
	FROM Trainee
	WHERE ET_IQ + ET_Gmath >= 20
	and ET_IQ >=8 and ET_Gmath >= 8 and ET_English >= 18 
 GO

-- Qest D
 SELECT	TraineeID,Full_Name, Birth_Date
 FROM	Trainee
 WHERE	ET_IQ + ET_Gmath >= 20
	AND ET_IQ >= 8
	AND ET_Gmath >= 8
	AND ET_English >= 18
ORDER BY MONTH(Birth_Date)
GO
-- Quest E
SELECT TOP 1 TraineeID, Full_Name, YEAR(GETDATE()) - YEAR(Birth_Date) AS AGE, Gender 
FROM Trainee
ORDER BY LEN(Full_Name) DESC
GO


 