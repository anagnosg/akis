USE [HandsApp]
GO

/****** Object:  Table [dbo].[REGIONS]    Script Date: 4/7/2019 9:49:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[REGIONS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DESCRIPTION] [nvarchar](150) NOT NULL,
 CONSTRAINT [UN_REGION_DESCRIPTION] UNIQUE NONCLUSTERED 
(
	[DESCRIPTION] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[SCORES]    Script Date: 4/7/2019 9:49:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SCORES](
	[USER_ID] [int] NOT NULL,
	[VENUE_ID] [int] NOT NULL,
	[SCORE] [int] NOT NULL,
	[COMMENT] [nvarchar](500) NULL,
 CONSTRAINT [UN_SCORE_USER_VENUE] UNIQUE NONCLUSTERED 
(
	[USER_ID] ASC,
	[VENUE_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[SERVICES]    Script Date: 4/7/2019 9:49:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[SERVICES](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DESCRIPTION] [nvarchar](100) NOT NULL,
 CONSTRAINT [UN_DESCRIPTION] UNIQUE NONCLUSTERED 
(
	[DESCRIPTION] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[TOKENS]    Script Date: 4/7/2019 9:49:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[TOKENS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TOKEN] [nchar](100) NOT NULL,
	[USERID] [int] NOT NULL,
	[EXPIRE] [datetime] NULL
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[USERS]    Script Date: 4/7/2019 9:49:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[USERS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[USERNAME] [nvarchar](50) NOT NULL,
	[PASSWORD] [nvarchar](50) NOT NULL,
	[REGION_ID] [int] NOT NULL,
	[EMAIL] [nvarchar](50) NOT NULL,
	[AGE] [int] NOT NULL,
 CONSTRAINT [PK_USERS] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
 CONSTRAINT [UN_USERNAME] UNIQUE NONCLUSTERED 
(
	[USERNAME] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[VENUE_CATEGORIES]    Script Date: 4/7/2019 9:49:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[VENUE_CATEGORIES](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DESCRIPTION] [nvarchar](255) NOT NULL,
 CONSTRAINT [UN_VENUES_CATEGORIES_DESCRIPTION] UNIQUE NONCLUSTERED 
(
	[DESCRIPTION] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[VENUES]    Script Date: 4/7/2019 9:49:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[VENUES](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DESCRIPTION] [nvarchar](255) NOT NULL,
	[CATEGORY_ID] [int] NOT NULL,
	[REGION_ID] [int] NOT NULL,
	[ADDRESS] [nvarchar](255) NOT NULL,
	[SUMMARY] [nvarchar](1000) NOT NULL
) ON [PRIMARY]
GO

/****** Object:  Table [dbo].[VENUES_HAVE_SERVICES]    Script Date: 4/7/2019 9:49:06 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[VENUES_HAVE_SERVICES](
	[VENUE_ID] [int] NOT NULL,
	[SERVICE_ID] [int] NOT NULL
) ON [PRIMARY]
GO


