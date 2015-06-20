-- ==================================================================
-- TABLES
-- ==================================================================

-- USER
CREATE TABLE RB_USER (
	ID					BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	CREATE_USER			VARCHAR2(50) NOT NULL,
	CREATE_TIME			TIMESTAMP NOT NULL,
	MODIFY_USER			VARCHAR2(50) NOT NULL,
	MODIFY_TIME			TIMESTAMP NOT NULL,
	SYS_STATUS			CHAR(1) NOT NULL,
	
	CODE				VARCHAR2(50) NOT NULL,
	NAME				NVARCHAR(100),
	DESCRIPTION			NVARCHAR(1000),
	
	PASSWORD			VARCHAR2(100) NOT NULL,
	FIRST_LOGIN_TIME	TIMESTAMP,
	LAST_LOGIN_TIME		TIMESTAMP,
	LOGIN_COUNT			INT NOT NULL,
	ERROR_COUNT			INT NOT NULL,
	EXPIRE_TIME			TIMESTAMP NOT NULL,
	LOCK_STATUS			CHAR(1) NOT NULL
);
CREATE UNIQUE INDEX IDX_USER__CODE ON RB_USER (CODE);


-- ROLE
CREATE TABLE RB_ROLE (
	ID					BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	CREATE_USER			VARCHAR2(50) NOT NULL,
	CREATE_TIME			TIMESTAMP NOT NULL,
	MODIFY_USER			VARCHAR2(50) NOT NULL,
	MODIFY_TIME			TIMESTAMP NOT NULL,
	SYS_STATUS			CHAR(1) NOT NULL,
	
	CODE				VARCHAR2(50) NOT NULL,
	NAME				NVARCHAR(100),
	DESCRIPTION			NVARCHAR(1000)
);
CREATE UNIQUE INDEX IDX_ROLE__CODE ON RB_ROLE (CODE);


-- USER_ROLE
CREATE TABLE RB_USER_ROLE (
	ID					BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	CREATE_USER			VARCHAR2(50) NOT NULL,
	CREATE_TIME			TIMESTAMP NOT NULL,
	MODIFY_USER			VARCHAR2(50) NOT NULL,
	MODIFY_TIME			TIMESTAMP NOT NULL,
	SYS_STATUS			CHAR(1) NOT NULL,
	
	USER_ID				BIGINT NOT NULL,
	ROLE_ID				BIGINT NOT NULL
);

