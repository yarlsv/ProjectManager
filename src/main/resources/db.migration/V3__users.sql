CREATE TABLE IF NOT EXISTS users
(
  id                uuid DEFAULT gen_random_uuid()      NOT NULL,
  email             VARCHAR                             NOT NULL,
  firstName         VARCHAR                             NOT NULL,
  lastName          VARCHAR                             NOT NULL,
  password          VARCHAR                             NOT NULL,
  role              VARCHAR                             NOT NULL,
  status            VARCHAR                             NOT NULL,
  CONSTRAINT pk_users PRIMARY KEY (id)
);