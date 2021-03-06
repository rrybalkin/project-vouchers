CREATE TABLE ASSOCIATIONS (
  ASSOCIATION_ID INT
    CONSTRAINT CT_ASSOCIATIONS_PK_ID
    PRIMARY KEY,
  NAME           VARCHAR2(100)
    CONSTRAINT CT_ASSOCIATIONS_NN_NAME NOT NULL,
  DESCRIPTION    VARCHAR2(1000)
);

DROP TABLE VISITORS;
CREATE TABLE VISITORS (
  VISITOR_ID  INT
    CONSTRAINT CT_VISITORS_PK_ID
    PRIMARY KEY,
  FIRSTNAME   VARCHAR2(100)
    CONSTRAINT CT_VISITORS_NN_FIRSTNAME
    NOT NULL,
  LASTNAME    VARCHAR2(100)
    CONSTRAINT CT_VISITORS_NN_LASTNAME
    NOT NULL,
  MIDDLENAME  VARCHAR2(100),
  ASSOCIATION INT DEFAULT 0
    CONSTRAINT CT_VISITORS_FK_ASSOCIATION_ID
    REFERENCES ASSOCIATIONS (ASSOCIATION_ID),
  DESCRIPTION VARCHAR2(1000)
);

CREATE TABLE TALONS (
  TALON_ID     INT
    CONSTRAINT CT_TALONS_PK_ID
    PRIMARY KEY,
  VISITOR_ID   INT
    CONSTRAINT CT_TALONS_FK_VISITOR_ID
    REFERENCES VISITORS (VISITOR_ID),
  COUNT_LUNCH  INT
    CONSTRAINT CT_TALONS_NN_LUNCHES
    NOT NULL,
  COUNT_DINNER INT
    CONSTRAINT CT_TALONS_NN_DINNERS
    NOT NULL
);

CREATE TABLE VISITOR_TALON (
  VISITOR_ID INT
    CONSTRAINT CT_VT_NN_VISITOR_ID
    NOT NULL,
  TALON_ID   INT
    CONSTRAINT CT_VT_NN_TALON_ID
    NOT NULL
);

CREATE SEQUENCE sq_visitor_id
INCREMENT BY 1
START WITH 1
MAXVALUE 10000
NOCACHE
NOCYCLE;

CREATE SEQUENCE sq_association_id
INCREMENT BY 1
START WITH 1
MAXVALUE 10000
NOCACHE
NOCYCLE;

CREATE SEQUENCE sq_talons_id
INCREMENT BY 1
START WITH 1
MAXVALUE 10000
NOCACHE
NOCYCLE;

-- indexes on table VISITORS
CREATE INDEX xif04_v
  ON visitors (association);

-- indexes on table VISITOR_TALON
CREATE INDEX xif05_tv
  ON visitor_talon (visitor_id);
CREATE INDEX xif06_tv
  ON visitor_talon (talon_id);

INSERT INTO associations VALUES (0, 'No group', NULL);