USE [HandsApp]
GO

/****** Object:  Table [dbo].[Diplomatiki_Communication]    Script Date: 20/3/2019 6:21:52 μμ ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Diplomatiki_Communication](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NAME] [nvarchar](50) NOT NULL,
	[EMAIL] [nvarchar](50) NOT NULL,
	[SUBJECT] [nvarchar](50) NOT NULL,
	[COMMENT] [char](1000) NOT NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

/****** Object:  Table [dbo].[Diplomatiki_Login]    Script Date: 20/3/2019 6:21:52 μμ ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Diplomatiki_Login](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[USERNAME] [nvarchar](50) NOT NULL,
	[PASSWORD] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Diplomatiki_Login] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[Diplomatiki_Region]    Script Date: 20/3/2019 6:21:52 μμ ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Diplomatiki_Region](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_REGION] [int] NOT NULL,
	[REGION_NAME] [nvarchar](50) NOT NULL
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[Diplomatiki_Services]    Script Date: 20/3/2019 6:21:52 μμ ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Diplomatiki_Services](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DISABILITY_PLATFORM] [bit] NOT NULL,
	[WC] [bit] NOT NULL,
	[PARKIN] [bit] NOT NULL,
	[OFFER] [nvarchar](255) NOT NULL,
	[SYSTEM_BRAILLE] [bit] NOT NULL,
	[DEAF_LANGUAGE] [bit] NOT NULL,
	[OTHERS] [nvarchar](255) NOT NULL
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[Diplomatiki_Signup]    Script Date: 20/3/2019 6:21:52 μμ ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Diplomatiki_Signup](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[EMAIL] [nvarchar](50) NOT NULL,
	[USERNAME] [nvarchar](50) NOT NULL,
	[PASSWORD] [nvarchar](50) NOT NULL,
	[REPEAT_PASSWORD] [nvarchar](50) NOT NULL
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[Diplomatiki_Venues]    Script Date: 20/3/2019 6:21:52 μμ ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Diplomatiki_Venues](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_VENUES] [int] NOT NULL,
	[RESTAURANTS] [nvarchar](255) NOT NULL,
	[CAFE_BAR] [nvarchar](255) NOT NULL,
	[CINEMA_THEATER] [nvarchar](255) NOT NULL,
	[FESTIVALS] [nvarchar](255) NOT NULL,
	[SPORTS] [nvarchar](255) NOT NULL,
	[HEALTH] [nvarchar](255) NOT NULL,
	[MUSEUM] [nvarchar](255) NOT NULL,
	[PUBLIC_SERVICES] [nvarchar](255) NOT NULL,
	[HOTEL] [nvarchar](255) NOT NULL,
	[STORES] [nvarchar](255) NOT NULL,
	[SUPER_MARKET] [nvarchar](255) NOT NULL,
	[TRANSPORTS] [nvarchar](255) NOT NULL
) ON [PRIMARY]

GO


