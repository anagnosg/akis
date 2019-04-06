USE [handsapp]
GO

/****** Object:  Table [dbo].[Championship]    Script Date: 12/11/2017 3:20:34 �� ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Championship](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[year] [int] NOT NULL,
	[category] [int] NOT NULL,
	[name] [nvarchar](100) NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Game](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_race] [int] NOT NULL,
	[id_team1] [int] NOT NULL,
	[id_team2] [int] NOT NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Game_statistics](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_race] [int] NOT NULL,
	[id_game] [int] NOT NULL,
	[Describe_statistics] [nvarchar](100) NOT NULL,
	[Value_statistic] [nvarchar](100) NOT NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Person](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[surname] [nvarchar](100) NOT NULL,
	[age] [int] NOT NULL,
	[address] [nvarchar](100) NOT NULL,
	[points] [int] NOT NULL,
 CONSTRAINT [PK_Person] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Pinakas_id](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_GAME] [int] NOT NULL,
	[ID_RACE] [int] NOT NULL,
	[ID_CHAMPIONSHIP] [int] NOT NULL,
	[ID_PLAYER_OF_THE_TEAM] [int] NOT NULL,
	[ID_GAME_STATISTICS] [int] NOT NULL,
	[ID_TEAM] [int] NOT NULL,
	[ID_TEAM1] [int] NOT NULL,
	[ID_TEAM2] [int] NOT NULL,
	[ID_PERSON] [int] NOT NULL,
	[ID_SOME_OTHER_ISSUES] [int] NOT NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Player_of_the_Team](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_person] [int] NOT NULL,
	[id_team] [int] NOT NULL,
	[type] [int] NOT NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Race](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[id_championship] [int] NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Some_other_issues](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[injuries] [nvarchar](100) NOT NULL,
	[presidents] [nvarchar](100) NOT NULL,
	[coaches] [nvarchar](100) NOT NULL,
	[referees] [nvarchar](100) NOT NULL,
	[funs] [nvarchar](100) NOT NULL,
	[journalists] [nvarchar](100) NOT NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Team](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ADDRESS] [nvarchar](100) NULL,
	[NAME] [nvarchar](100) NULL
) ON [PRIMARY]

GO

CREATE TABLE [dbo].[Vatmologia_omadwn](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[basket_team] [nvarchar](100) NOT NULL,
	[id_race] [int] NOT NULL,
	[win] [int] NOT NULL,
	[lose] [int] NOT NULL,
	[points] [int] NOT NULL
) ON [PRIMARY]

GO