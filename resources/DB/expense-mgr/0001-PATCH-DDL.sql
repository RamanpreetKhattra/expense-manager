--------------------------------------------------------
--  DDL for Table EXPENSE
--------------------------------------------------------
DROP TABLE EXPENSE CASCADE CONSTRAINTS;
CREATE TABLE EXPENSE
  (
    EXPENSE_ID          NUMBER(10,0) NOT NULL,
	CATEGORY			VARCHAR2(20) NOT NULL,
	AMOUNT         		NUMBER(12,2),
    CURRENCY         	VARCHAR2(4 BYTE),
    USER_ID       		NUMBER(10,0) NOT NULL,
    CREATED_TS          TIMESTAMP (6) NOT NULL,
    CREATED_BY          VARCHAR2(80) NOT NULL,
    UPDATED_TS          TIMESTAMP (6),
    UPDATED_BY          VARCHAR2(80 BYTE),
    VERSION             NUMBER(10,0) DEFAULT 1 NOT NULL
  )
  TABLESPACE EXPENSE01;

COMMENT ON TABLE EXPENSE IS 'Stores the expenses';
COMMENT ON COLUMN EXPENSE.EXPENSE_ID IS 'Primary Key.';
COMMENT ON COLUMN EXPENSE.AMOUNT IS 'Specifies the Amount';
COMMENT ON COLUMN EXPENSE.CURRENCY IS 'Specifies the currenct of the Amount';
COMMENT ON COLUMN EXPENSE.CATEGORY IS 'Specifies the category of expense.';
COMMENT ON COLUMN EXPENSE.USER_ID IS 'Specifies user of which this expense is';
COMMENT ON COLUMN EXPENSE.CREATED_TS IS 'Audit column to store record creation timestamp. This column has no business significance.';
COMMENT ON COLUMN EXPENSE.CREATED_BY IS 'Audit column to store record creator ID. This column has no business significance.';
COMMENT ON COLUMN EXPENSE.UPDATED_TS IS 'Audit column to store record update timestamp. This column has no business significance.';
COMMENT ON COLUMN EXPENSE.UPDATED_BY IS 'Audit column to store record updator ID. This column has no business significance.';
COMMENT ON COLUMN EXPENSE.VERSION IS 'Used by hibernate to detect updates on stale data and concurrent modifications. This column has no business significance.';

--------------------------------------------------------
--  Constraints for Table EXPENSE
--------------------------------------------------------
ALTER TABLE EXPENSE ADD CONSTRAINT PK_EXPENSE PRIMARY KEY (EXPENSE_ID) USING INDEX TABLESPACE EXPENSE_INDX01 ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EXPENSE
--------------------------------------------------------
ALTER TABLE EXPENSE ADD CONSTRAINT EXPENSE_FK01 FOREIGN KEY (USER_ID) REFERENCES USER (USER_ID) ENABLE;



DROP SEQUENCE EXPENSE_SEQ;
CREATE SEQUENCE EXPENSE_SEQ START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER  T_EXPENSE_SEQ_BI 
BEFORE INSERT ON EXPENSE FOR EACH ROW
WHEN (NEW.EXPENSE_ID IS NULL) BEGIN
SELECT EXPENSE_SEQ.NEXTVAL INTO :NEW.EXPENSE_ID FROM DUAL;
END;
/
ALTER TRIGGER T_EXPENSE_SEQ_BI ENABLE;

----------------------------------
---- TABLE FOR CATEGORY ---------
----------------------------------

DROP TABLE CATEGORY CASCADE CONSTRAINTS;
CREATE TABLE CATEGORY
  (
    CATEGORY_ID          NUMBER(10,0) NOT NULL,
	CATEGORY_NAME		VARCHAR2(20) NOT NULL,
    CREATED_TS          TIMESTAMP (6) NOT NULL,
    CREATED_BY          VARCHAR2(80) NOT NULL,
    UPDATED_TS          TIMESTAMP (6),
    UPDATED_BY          VARCHAR2(80 BYTE),
    VERSION             NUMBER(10,0) DEFAULT 1 NOT NULL
  )
  TABLESPACE EXPENSE01;

COMMENT ON TABLE CATEGORY IS 'Stores the expenses';
COMMENT ON COLUMN CATEGORY.CATEGORY_ID IS 'Primary Key.';
COMMENT ON COLUMN CATEGORY.CATEGORY_NAME IS 'Specifies the category name';
COMMENT ON COLUMN CATEGORY.CREATED_TS IS 'Audit column to store record creation timestamp. This column has no business significance.';
COMMENT ON COLUMN CATEGORY.CREATED_BY IS 'Audit column to store record creator ID. This column has no business significance.';
COMMENT ON COLUMN CATEGORY.UPDATED_TS IS 'Audit column to store record update timestamp. This column has no business significance.';
COMMENT ON COLUMN CATEGORY.UPDATED_BY IS 'Audit column to store record updator ID. This column has no business significance.';
COMMENT ON COLUMN CATEGORY.VERSION IS 'Used by hibernate to detect updates on stale data and concurrent modifications. This column has no business significance.';

--------------------------------------------------------
--  Constraints for Table EXPENSE
--------------------------------------------------------
ALTER TABLE CATEGORY ADD CONSTRAINT PK_CATEGORY PRIMARY KEY (CATEGORY_ID) USING INDEX TABLESPACE EXPENSE_INDX01 ENABLE;


DROP SEQUENCE CATEGORY_SEQ;
CREATE SEQUENCE CATEGORY_SEQ START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER  T_CATEGORY_SEQ_BI 
BEFORE INSERT ON CATEGORY FOR EACH ROW
WHEN (NEW.CATEGORY_ID IS NULL) BEGIN
SELECT CATEGORY_SEQ.NEXTVAL INTO :NEW.CATEGORY_ID FROM DUAL;
END;
/
ALTER TRIGGER T_CATEGORY_SEQ_BI ENABLE;
