USE [BongDa]
GO
/****** Object:  Table [dbo].[account]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[account_name] [varchar](255) NOT NULL,
	[password] [varchar](128) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[account_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[account_role]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account_role](
	[id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[account_name] [varchar](255) NULL,
	[role_id] [numeric](19, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[classes]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[classes](
	[class_id] [int] IDENTITY(1,1) NOT NULL,
	[capacity] [int] NOT NULL,
	[class_name] [varchar](255) NULL,
	[end_date] [datetime] NULL,
	[start_date] [datetime] NULL,
	[coach_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[class_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[coach_rating]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[coach_rating](
	[rating_id] [int] IDENTITY(1,1) NOT NULL,
	[coach_training] [int] NULL,
	[communication] [int] NULL,
	[rating_date] [datetime] NULL,
	[discipline] [int] NULL,
	[football_knowledge] [int] NULL,
	[other_opinion] [varchar](255) NULL,
	[overall_rating] [int] NULL,
	[class_id] [int] NULL,
	[coach_id] [int] NULL,
	[player_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[rating_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[coaches]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[coaches](
	[coach_id] [int] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NULL,
	[avatar] [varchar](255) NULL,
	[birthday] [datetime] NOT NULL,
	[email] [varchar](255) NULL,
	[gender] [bit] NOT NULL,
	[name_coach] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[account_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[coach_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[doctor]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[doctor](
	[doctor_id] [int] IDENTITY(1,1) NOT NULL,
	[address] [varchar](255) NULL,
	[email] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[phone] [varchar](255) NULL,
	[specialty] [varchar](255) NULL,
	[account_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[doctor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hibernate_sequence]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hibernate_sequence](
	[next_val] [numeric](19, 0) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[medical_report]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[medical_report](
	[report_id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[cause] [varchar](255) NULL,
	[diagnosis] [varchar](255) NULL,
	[report_date] [datetime] NULL,
	[symptom] [varchar](255) NULL,
	[test_result] [varchar](255) NULL,
	[treatment] [varchar](255) NULL,
	[doctor_id] [int] NULL,
	[player_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[report_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[player]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[player](
	[player_id] [int] IDENTITY(1,1) NOT NULL,
	[avatar] [varchar](255) NULL,
	[birthday] [datetime] NULL,
	[height] [float] NULL,
	[name] [varchar](255) NULL,
	[parent_phone] [varchar](255) NULL,
	[position] [varchar](255) NULL,
	[weight] [float] NULL,
	[account_name] [varchar](255) NULL,
	[class_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[player_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[player_health_report]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[player_health_report](
	[report_id] [numeric](19, 0) IDENTITY(1,1) NOT NULL,
	[cholesterol] [int] NOT NULL,
	[heart_rate] [int] NOT NULL,
	[height] [float] NOT NULL,
	[inspect_date] [datetime] NULL,
	[weight] [float] NOT NULL,
	[doctor_id] [int] NULL,
	[player_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[report_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[player_rating]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[player_rating](
	[id_rating] [int] IDENTITY(1,1) NOT NULL,
	[defense] [int] NOT NULL,
	[jumping] [int] NOT NULL,
	[offense] [int] NOT NULL,
	[speed] [int] NOT NULL,
	[strength] [int] NOT NULL,
	[technique] [int] NOT NULL,
	[create_date] [datetime] NULL,
	[coach_id] [int] NULL,
	[player_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_rating] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[player_team_entities]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[player_team_entities](
	[player_player_id] [int] NOT NULL,
	[team_entities_team_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[player_player_id] ASC,
	[team_entities_team_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[role_id] [numeric](19, 0) NOT NULL,
	[role_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[schedule]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[schedule](
	[schedule_id] [int] IDENTITY(1,1) NOT NULL,
	[class_id] [int] NULL,
	[end_time] [datetime] NULL,
	[location] [varchar](255) NULL,
	[schedule_date] [datetime] NULL,
	[start_time] [datetime] NULL,
	[subject_id] [int] NULL,
	[training_description] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[schedule_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[skill]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[skill](
	[skill_id] [int] IDENTITY(1,1) NOT NULL,
	[skill_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[skill_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[subject]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[subject](
	[subject_id] [int] IDENTITY(1,1) NOT NULL,
	[subject_name] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[subject_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[team]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[team](
	[team_id] [int] IDENTITY(1,1) NOT NULL,
	[capacity] [int] NULL,
	[team_name] [varchar](255) NULL,
	[class_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[team_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[team_member]    Script Date: 4/1/2023 5:49:49 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[team_member](
	[player_id] [int] NOT NULL,
	[team_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[player_id] ASC,
	[team_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'admin', N'$2a$10$juKtgC0WrbMLgICw0oi3yuipKJH82ZUtINe4YhAfavx2ZO7talCEW')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'datnt', N'$2a$10$juKtgC0WrbMLgICw0oi3yuipKJH82ZUtINe4YhAfavx2ZO7talCEW')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'dienhh', N'$2a$10$juKtgC0WrbMLgICw0oi3yuipKJH82ZUtINe4YhAfavx2ZO7talCEW')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'doctor', N'$2a$10$juKtgC0WrbMLgICw0oi3yuipKJH82ZUtINe4YhAfavx2ZO7talCEW')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'dunglv', N'$2a$10$juKtgC0WrbMLgICw0oi3yuipKJH82ZUtINe4YhAfavx2ZO7talCEW')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'HUYGAY', N'$2a$10$rm1.kZ3gkn34F5Tl.Q./2.3qzC23vBfu2q58GuIo6R4x18jFz9Ooe')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'HUYGAY0', N'$2a$10$3p5p/yP0Y4IHgZKTK/67DO7nQqBds41FMJDzhP8Fk5Llz55Hxnwve')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'HUYGAY09', N'$2a$10$MV8VkfQRdbKke3nCFdmofeijiTty/tw2OhnYkL7A2wyiq9HDj0/DS')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'huynl', N'$2a$10$2Yff5dI2pp0mNDsgL0Gk2uWtuRiho/AN5FeTX0mEmjA65K8sbuG5e')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'LiCH', N'$2a$10$juKtgC0WrbMLgICw0oi3yuipKJH82ZUtINe4YhAfavx2ZO7talCEW')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN', N'$2a$10$2Yff5dI2pp0mNDsgL0Gk2uWtuRiho/AN5FeTX0mEmjA65K8sbuG5e')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN07', N'$2a$10$YrMgM40Mg0A0gd/DvEDq5eZ/xm73Q.91zlkhnbN8mEsxlNCQTr7Fa')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN0787', N'$2a$10$FJ4lMnj8QMhCFjRWsmmnW.nFCgHQeetuDyKqq/MYj7wwRykAh8Aui')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN079', N'$2a$10$MBo/wgc/ibz9VMBXy8zj2evvI1.cqnGTUwdovbMmMfiKJ45sFX2rK')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN09', N'$2a$10$Z0D7xC8/1J//PAGoKdeaGOXV95wlhfkxkVI604yDf3P8OUZMBJ59K')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN231213', N'$2a$10$5wJqyFHKf0gCuGt09rWgS.zk1xwWw.ixvNU/6M3tZz/FjDPz6q0iC')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN543', N'$2a$10$wKPDH48b9zWvuzvAf0gtQuB.gDPUoQM94aaANlNb34GAbi7d.pxu6')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN56', N'$2a$10$A5svnrWhIeJLlsvB/lX7M.MLn41.S9ajjXXf0j9Yo2oING4nMIghG')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN634', N'$2a$10$zZu.DnzX4XRXIkPZ3mfp7OGvwJ9.slLx61lpmQYiPSitukxPpPkeS')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN7', N'$2a$10$aTaEjNrt2soMZFcC.583DetPIjklUj3I/3860FgyOigMIUalplZI2')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN745', N'$2a$10$xyIbFh44MyuyhmJ9asPyUuV9vIrSbcofjpXKc4M.L6PANNRAq6d1K')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN7632', N'$2a$10$8Juo2P2aS42fMrI8TPxOOOr/eIO9lt.vfFFCEJusINCF9jgEUdPuC')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN763209', N'$2a$10$qp.iY/qcCbivOaTWwlJKxeuv3IRiSV3Nz7tA3XboBKJ5GzYlyhvDK')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN90', N'$2a$10$Xz42jcuDekh10LL24HY2ee2VDUA.JNYaKMtEW8hIaUJj/Rs/H64Ai')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN98', N'$2a$10$qEGkzcAlqo37nma22vRJ4u0pbBTvzbxFfK6Uichs2sDjbTtfByZ4i')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'PHUCTAN9900', N'$2a$10$VucXfO/F4/ZULYxBCSt/wuwpcBUPHMxcJGiMoIES5Tr/XBzA3C0wa')
INSERT [dbo].[account] ([account_name], [password]) VALUES (N'trilhh', N'$2a$10$IKWr3YTZB/.4cp7roZj8L.vQ/mqaRCoKJTYifMaSF9PbzU/mrk4N2')
GO
SET IDENTITY_INSERT [dbo].[account_role] ON 

INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(22 AS Numeric(19, 0)), N'admin', CAST(1 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(23 AS Numeric(19, 0)), N'dienhh', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(24 AS Numeric(19, 0)), N'datnt', CAST(4 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(25 AS Numeric(19, 0)), N'dunglv', CAST(2 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(26 AS Numeric(19, 0)), N'huynl', CAST(2 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(28 AS Numeric(19, 0)), N'LiCH', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(29 AS Numeric(19, 0)), N'HUYGAY', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(30 AS Numeric(19, 0)), N'HUYGAY0', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(31 AS Numeric(19, 0)), N'PHUCTAN543', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(32 AS Numeric(19, 0)), N'PHUCTAN634', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(33 AS Numeric(19, 0)), N'doctor', CAST(4 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(34 AS Numeric(19, 0)), N'PHUCTAN56', CAST(3 AS Numeric(19, 0)))
INSERT [dbo].[account_role] ([id], [account_name], [role_id]) VALUES (CAST(35 AS Numeric(19, 0)), N'PHUCTAN079', CAST(3 AS Numeric(19, 0)))
SET IDENTITY_INSERT [dbo].[account_role] OFF
GO
SET IDENTITY_INSERT [dbo].[classes] ON 

INSERT [dbo].[classes] ([class_id], [capacity], [class_name], [end_date], [start_date], [coach_id]) VALUES (4, 33, N'U12', CAST(N'2023-01-01T00:00:00.000' AS DateTime), CAST(N'2023-04-04T00:00:00.000' AS DateTime), 1)
INSERT [dbo].[classes] ([class_id], [capacity], [class_name], [end_date], [start_date], [coach_id]) VALUES (5, 31, N'U13', CAST(N'2023-01-01T00:00:00.000' AS DateTime), CAST(N'2023-08-08T00:00:00.000' AS DateTime), 7)
INSERT [dbo].[classes] ([class_id], [capacity], [class_name], [end_date], [start_date], [coach_id]) VALUES (8, 56, N'u9', CAST(N'2023-04-19T00:00:00.000' AS DateTime), CAST(N'2023-03-30T00:00:00.000' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[classes] OFF
GO
SET IDENTITY_INSERT [dbo].[coaches] ON 

INSERT [dbo].[coaches] ([coach_id], [address], [avatar], [birthday], [email], [gender], [name_coach], [phone], [account_name]) VALUES (1, N'BINH DINH', N'erik-ten-hag-0-1424.jpg', CAST(N'2001-12-12T00:00:00.000' AS DateTime), N'DIENHH@gmail.com', 1, N'HUYNH HUU DIEN', N'0333915138', N'dienhh')
INSERT [dbo].[coaches] ([coach_id], [address], [avatar], [birthday], [email], [gender], [name_coach], [phone], [account_name]) VALUES (7, N'Da nag', N'bruno.png', CAST(N'2023-03-03T00:00:00.000' AS DateTime), N'ltri1042@gmail.com', 1, N'Dien HUynh HUU', N'0333915138', N'LiCH')
SET IDENTITY_INSERT [dbo].[coaches] OFF
GO
SET IDENTITY_INSERT [dbo].[doctor] ON 

INSERT [dbo].[doctor] ([doctor_id], [address], [email], [name], [phone], [specialty], [account_name]) VALUES (1, N'Truong Chinh', N'ntdat1232001@gmail.com', N'Nguyen Thanh Dat', N'0972530969', N'Tâm lí', N'datnt')
INSERT [dbo].[doctor] ([doctor_id], [address], [email], [name], [phone], [specialty], [account_name]) VALUES (2, N'Ngo Thi Nham', N'thanhdiort', N'NANDOCTO', N'0213245445', N'Ch?n thuong ch?nh hình', N'doctor')
SET IDENTITY_INSERT [dbo].[doctor] OFF
GO
INSERT [dbo].[hibernate_sequence] ([next_val]) VALUES (CAST(1 AS Numeric(19, 0)))
GO
SET IDENTITY_INSERT [dbo].[medical_report] ON 

INSERT [dbo].[medical_report] ([report_id], [cause], [diagnosis], [report_date], [symptom], [test_result], [treatment], [doctor_id], [player_id]) VALUES (CAST(2 AS Numeric(19, 0)), N'Sút quá m?nh', N'Bong Gân', CAST(N'2023-01-01T00:00:00.000' AS DateTime), N'Ch?n thuong Chân ', N'Bong Gân ? c? chân', N'Thu?c bôi , và cãni', 1, 4)
SET IDENTITY_INSERT [dbo].[medical_report] OFF
GO
SET IDENTITY_INSERT [dbo].[player] ON 

INSERT [dbo].[player] ([player_id], [avatar], [birthday], [height], [name], [parent_phone], [position], [weight], [account_name], [class_id]) VALUES (4, N'/player/dist/img/avatar/bruno.jpg', CAST(N'2009-01-01T00:00:00.000' AS DateTime), 180, N'DUNG LE VAN', N'0333915129', N'TIEN DAO CAM', 50, N'dunglv', 4)
INSERT [dbo].[player] ([player_id], [avatar], [birthday], [height], [name], [parent_phone], [position], [weight], [account_name], [class_id]) VALUES (5, N'/player/dist/img/avatar/bruno.jpg', CAST(N'2009-01-01T00:00:00.000' AS DateTime), 150, N'HUY HOANG', N'0333915189', N'HAU VE PHAI', 57, N'huynl', 5)
SET IDENTITY_INSERT [dbo].[player] OFF
GO
SET IDENTITY_INSERT [dbo].[player_rating] ON 

INSERT [dbo].[player_rating] ([id_rating], [defense], [jumping], [offense], [speed], [strength], [technique], [create_date], [coach_id], [player_id]) VALUES (22, 90, 90, 90, 90, 90, 90, CAST(N'2023-03-31T00:00:00.000' AS DateTime), 1, 4)
INSERT [dbo].[player_rating] ([id_rating], [defense], [jumping], [offense], [speed], [strength], [technique], [create_date], [coach_id], [player_id]) VALUES (23, 90, 90, 90, 90, 90, 90, CAST(N'2023-04-01T00:00:00.000' AS DateTime), 7, 5)
INSERT [dbo].[player_rating] ([id_rating], [defense], [jumping], [offense], [speed], [strength], [technique], [create_date], [coach_id], [player_id]) VALUES (24, 90, 89, 75, 80, 75, 80, CAST(N'2023-04-01T00:00:00.000' AS DateTime), 1, 4)
SET IDENTITY_INSERT [dbo].[player_rating] OFF
GO
INSERT [dbo].[role] ([role_id], [role_name]) VALUES (CAST(1 AS Numeric(19, 0)), N'ROLE_ADMIN')
INSERT [dbo].[role] ([role_id], [role_name]) VALUES (CAST(2 AS Numeric(19, 0)), N'ROLE_USER')
INSERT [dbo].[role] ([role_id], [role_name]) VALUES (CAST(3 AS Numeric(19, 0)), N'ROLE_COACH')
INSERT [dbo].[role] ([role_id], [role_name]) VALUES (CAST(4 AS Numeric(19, 0)), N'ROLE_DOCTOR')
GO
ALTER TABLE [dbo].[account_role]  WITH CHECK ADD  CONSTRAINT [FKp0g1cy60378l4lapy5l1c7d7o] FOREIGN KEY([account_name])
REFERENCES [dbo].[account] ([account_name])
GO
ALTER TABLE [dbo].[account_role] CHECK CONSTRAINT [FKp0g1cy60378l4lapy5l1c7d7o]
GO
ALTER TABLE [dbo].[account_role]  WITH CHECK ADD  CONSTRAINT [FKrs2s3m3039h0xt8d5yhwbuyam] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([role_id])
GO
ALTER TABLE [dbo].[account_role] CHECK CONSTRAINT [FKrs2s3m3039h0xt8d5yhwbuyam]
GO
ALTER TABLE [dbo].[classes]  WITH CHECK ADD  CONSTRAINT [FK28p9xb2l2q3u0s3gxlchv0i4y] FOREIGN KEY([coach_id])
REFERENCES [dbo].[coaches] ([coach_id])
GO
ALTER TABLE [dbo].[classes] CHECK CONSTRAINT [FK28p9xb2l2q3u0s3gxlchv0i4y]
GO
ALTER TABLE [dbo].[coach_rating]  WITH CHECK ADD  CONSTRAINT [FKcm4d46qckcoi9obwmbubcfdnk] FOREIGN KEY([player_id])
REFERENCES [dbo].[player] ([player_id])
GO
ALTER TABLE [dbo].[coach_rating] CHECK CONSTRAINT [FKcm4d46qckcoi9obwmbubcfdnk]
GO
ALTER TABLE [dbo].[coach_rating]  WITH CHECK ADD  CONSTRAINT [FKda1nmi2m8a9jv7j3nee2swftf] FOREIGN KEY([class_id])
REFERENCES [dbo].[classes] ([class_id])
GO
ALTER TABLE [dbo].[coach_rating] CHECK CONSTRAINT [FKda1nmi2m8a9jv7j3nee2swftf]
GO
ALTER TABLE [dbo].[coach_rating]  WITH CHECK ADD  CONSTRAINT [FKsekubqfccpof8j8f23d32rc9f] FOREIGN KEY([coach_id])
REFERENCES [dbo].[coaches] ([coach_id])
GO
ALTER TABLE [dbo].[coach_rating] CHECK CONSTRAINT [FKsekubqfccpof8j8f23d32rc9f]
GO
ALTER TABLE [dbo].[coaches]  WITH CHECK ADD  CONSTRAINT [FK8cidq0p9lh6c0q5ppjiv53i5s] FOREIGN KEY([account_name])
REFERENCES [dbo].[account] ([account_name])
GO
ALTER TABLE [dbo].[coaches] CHECK CONSTRAINT [FK8cidq0p9lh6c0q5ppjiv53i5s]
GO
ALTER TABLE [dbo].[doctor]  WITH CHECK ADD  CONSTRAINT [FK841rodk2hxlr6pdmasx2bkqu6] FOREIGN KEY([account_name])
REFERENCES [dbo].[account] ([account_name])
GO
ALTER TABLE [dbo].[doctor] CHECK CONSTRAINT [FK841rodk2hxlr6pdmasx2bkqu6]
GO
ALTER TABLE [dbo].[medical_report]  WITH CHECK ADD  CONSTRAINT [FKbjopw2obo0h7wv0tb18f7uw59] FOREIGN KEY([player_id])
REFERENCES [dbo].[player] ([player_id])
GO
ALTER TABLE [dbo].[medical_report] CHECK CONSTRAINT [FKbjopw2obo0h7wv0tb18f7uw59]
GO
ALTER TABLE [dbo].[medical_report]  WITH CHECK ADD  CONSTRAINT [FKcnpgh5u2r488as0pephafq5dg] FOREIGN KEY([doctor_id])
REFERENCES [dbo].[doctor] ([doctor_id])
GO
ALTER TABLE [dbo].[medical_report] CHECK CONSTRAINT [FKcnpgh5u2r488as0pephafq5dg]
GO
ALTER TABLE [dbo].[player]  WITH CHECK ADD  CONSTRAINT [FK2j2gjqoaf956n263a0n9xuif5] FOREIGN KEY([class_id])
REFERENCES [dbo].[classes] ([class_id])
GO
ALTER TABLE [dbo].[player] CHECK CONSTRAINT [FK2j2gjqoaf956n263a0n9xuif5]
GO
ALTER TABLE [dbo].[player]  WITH CHECK ADD  CONSTRAINT [FKekh889r03f2f7xx27t6hinqrt] FOREIGN KEY([account_name])
REFERENCES [dbo].[account] ([account_name])
GO
ALTER TABLE [dbo].[player] CHECK CONSTRAINT [FKekh889r03f2f7xx27t6hinqrt]
GO
ALTER TABLE [dbo].[player_health_report]  WITH CHECK ADD  CONSTRAINT [FKp7lo6ol5du0qxq5nia2r76wli] FOREIGN KEY([player_id])
REFERENCES [dbo].[player] ([player_id])
GO
ALTER TABLE [dbo].[player_health_report] CHECK CONSTRAINT [FKp7lo6ol5du0qxq5nia2r76wli]
GO
ALTER TABLE [dbo].[player_health_report]  WITH CHECK ADD  CONSTRAINT [FKphaqvpahktor9pruovghjneow] FOREIGN KEY([doctor_id])
REFERENCES [dbo].[doctor] ([doctor_id])
GO
ALTER TABLE [dbo].[player_health_report] CHECK CONSTRAINT [FKphaqvpahktor9pruovghjneow]
GO
ALTER TABLE [dbo].[player_rating]  WITH CHECK ADD  CONSTRAINT [FK10embagq5co1e1onhk16pea2r] FOREIGN KEY([player_id])
REFERENCES [dbo].[player] ([player_id])
GO
ALTER TABLE [dbo].[player_rating] CHECK CONSTRAINT [FK10embagq5co1e1onhk16pea2r]
GO
ALTER TABLE [dbo].[player_rating]  WITH CHECK ADD  CONSTRAINT [FK34o5qr9m28aerr0iqclhc4ymm] FOREIGN KEY([coach_id])
REFERENCES [dbo].[coaches] ([coach_id])
GO
ALTER TABLE [dbo].[player_rating] CHECK CONSTRAINT [FK34o5qr9m28aerr0iqclhc4ymm]
GO
ALTER TABLE [dbo].[player_team_entities]  WITH CHECK ADD  CONSTRAINT [FKbvthh94fmj0eptg7ayw3h3kwd] FOREIGN KEY([player_player_id])
REFERENCES [dbo].[player] ([player_id])
GO
ALTER TABLE [dbo].[player_team_entities] CHECK CONSTRAINT [FKbvthh94fmj0eptg7ayw3h3kwd]
GO
ALTER TABLE [dbo].[player_team_entities]  WITH CHECK ADD  CONSTRAINT [FKhmnylcx8h94t6sv5p4gkajdhc] FOREIGN KEY([team_entities_team_id])
REFERENCES [dbo].[team] ([team_id])
GO
ALTER TABLE [dbo].[player_team_entities] CHECK CONSTRAINT [FKhmnylcx8h94t6sv5p4gkajdhc]
GO
ALTER TABLE [dbo].[team]  WITH CHECK ADD  CONSTRAINT [FKt4p1svkn65gk7dmack4w17ffe] FOREIGN KEY([class_id])
REFERENCES [dbo].[classes] ([class_id])
GO
ALTER TABLE [dbo].[team] CHECK CONSTRAINT [FKt4p1svkn65gk7dmack4w17ffe]
GO
ALTER TABLE [dbo].[team_member]  WITH CHECK ADD  CONSTRAINT [FK8f0sej29g2eoxeg6tk8qbfjy8] FOREIGN KEY([player_id])
REFERENCES [dbo].[team] ([team_id])
GO
ALTER TABLE [dbo].[team_member] CHECK CONSTRAINT [FK8f0sej29g2eoxeg6tk8qbfjy8]
GO
ALTER TABLE [dbo].[team_member]  WITH CHECK ADD  CONSTRAINT [FKix9ychrfbfyt1p1xyjpolh6rn] FOREIGN KEY([team_id])
REFERENCES [dbo].[player] ([player_id])
GO
ALTER TABLE [dbo].[team_member] CHECK CONSTRAINT [FKix9ychrfbfyt1p1xyjpolh6rn]
GO
ALTER TABLE [dbo].[player_health_report]  WITH CHECK ADD CHECK  (([cholesterol]<=(300) AND [cholesterol]>=(30)))
GO
ALTER TABLE [dbo].[player_health_report]  WITH CHECK ADD CHECK  (([cholesterol]<=(300) AND [cholesterol]>=(30)))
GO
ALTER TABLE [dbo].[player_health_report]  WITH CHECK ADD CHECK  (([heart_rate]>=(30) AND [heart_rate]<=(300)))
GO
ALTER TABLE [dbo].[player_health_report]  WITH CHECK ADD CHECK  (([heart_rate]>=(30) AND [heart_rate]<=(300)))
GO
